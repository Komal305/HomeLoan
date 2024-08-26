package com.cg.homeLoan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.cg.homeLoan.Dto.UserDto;
import com.cg.homeLoan.entity.Users;
import com.cg.homeLoan.services.impl.UserManagementService;

@RestController
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/auth/register")//done
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto){
        return  ResponseEntity.ok(userManagementService.register(userDto));    }

    @PostMapping("/auth/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userManagementService.login(userDto));
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity<UserDto> refershToken(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userManagementService.refreshToken(userDto));
    }

    @GetMapping("/admin/getAllUser")
    public ResponseEntity<UserDto>  getAllUser(){
        return  ResponseEntity.ok(userManagementService.getAllUser());
    }

    @GetMapping("/admin/getUser/{userId}")
    public ResponseEntity<UserDto>  getUsersById(@PathVariable Integer userId) {
        return ResponseEntity.ok(userManagementService.getUserById(userId));
    }

    @PutMapping("/auth/update/{userId}")
    public  ResponseEntity<UserDto> updateUser(@PathVariable Integer userId, @RequestBody Users users){
        return ResponseEntity.ok(userManagementService.updateUser(userId, users));
    }

    @GetMapping("/adminuser/getProfile")//checked
    public ResponseEntity<UserDto> getMyProfile(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String email=authentication.getName();
        UserDto response=userManagementService.getMyInfo(email);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }

    @DeleteMapping("/admin/delete/{userId}")
    public  ResponseEntity<UserDto> deleteUser(@PathVariable Integer userId){
        return ResponseEntity.ok(userManagementService.deleteUser(userId));
    }

}
