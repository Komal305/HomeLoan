package com.cg.homeLoan.services.impl;

import com.cg.homeLoan.Dto.UserDto;
import com.cg.homeLoan.entity.Users;
import com.cg.homeLoan.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserManagementService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private JWTUtils jwtUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	public UserDto register(UserDto userDto) {
		UserDto userD = new UserDto();
		try {
			Users users = new Users();
			users.setEmail(userDto.getEmail());
			users.setCity(userDto.getCity());
			users.setRole(userDto.getRole());
			users.setName(userDto.getName());
			users.setPassword(passwordEncoder.encode(userDto.getPassword()));

			Users result = userRepo.save(users);
			if (result.getId() > 0) {
				userD.setUsers(result);
				userD.setMessage("User saved");
				userD.setStatusCode(200);
			}
		} catch (Exception e) {
			userD.setStatusCode(500);
			userD.setError(e.getMessage());
		}
		return userD;
	}
	

	public UserDto login(UserDto userDto) {
		UserDto response = new UserDto();
		try {
			System.out.println("authh...... ");

			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()) );

			Users user = userRepo.findByEmail(userDto.getEmail()).orElseThrow();
			System.out.println("before generate ");
			var jwt = jwtUtils.generateToken(user);
			System.out.println("after generate ");
			var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
			response.setStatusCode(200);
			response.setToken(jwt);
			response.setRole(user.getRole());
			response.setRefreshToken(refreshToken);
			response.setExpirationTime("24Hrs");
			response.setMessage("Successfully logged in ");

		} catch (Exception e) {
			response.setStatusCode(500);
			
			 response.setMessage("Authentication failed: " + e.getMessage());
		}
		return response;
	}

	public UserDto refreshToken(UserDto refreshTokenReqiest) {
		UserDto response = new UserDto();
		try {
			String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
			Users users = userRepo.findByEmail(ourEmail).orElseThrow();
			if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
				var jwt = jwtUtils.generateToken(users);
				response.setStatusCode(200);
				response.setToken(jwt);
				response.setRefreshToken(refreshTokenReqiest.getToken());
				response.setExpirationTime("24Hr");
				response.setMessage("Successfully Refreshed Token");
			}
			response.setStatusCode(200);
			return response;

		} catch (Exception e) {
			response.setStatusCode(500);
			response.setMessage(e.getMessage());
			return response;
		}
	}

	public UserDto getAllUser() {
		UserDto userDto = new UserDto();
		try {
			List<Users> result = userRepo.findAll();
			if (!result.isEmpty()) {
				userDto.setUserList(result);
				userDto.setStatusCode(200);
				userDto.setMessage("Successful");
			} else {
				userDto.setStatusCode(404);
				userDto.setMessage("No user found");
			}
			return userDto;
		} catch (Exception e) {
			userDto.setStatusCode(500);
			userDto.setMessage("Error occurred" + e.getMessage());
		}
		return userDto;
	}

	public UserDto getUserById(Integer id) {
		UserDto userDto = new UserDto();
		try {
			Users usersById = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
			userDto.setUsers(usersById);
			userDto.setStatusCode(200);
			userDto.setMessage("User with id" + usersById + "got.");
		} catch (Exception e) {
			userDto.setStatusCode(500);
			userDto.setMessage("Error " + e.getMessage());
		}
		return userDto;
	}

	public UserDto deleteUser(Integer userId) {
		UserDto userDto = new UserDto();
		try {
			Optional<Users> users = userRepo.findById(userId);
			if (users.isPresent()) {
				userRepo.deleteById(userId);
				userDto.setStatusCode(200);
				userDto.setMessage("Deleted Successful");
			} else {
				userDto.setStatusCode(404);
				userDto.setMessage("No user found");
			}

		} catch (Exception e) {
			userDto.setStatusCode(500);
			userDto.setMessage("Error occurred while deleting user " + e.getMessage());
		}
		return userDto;

	}

	public UserDto updateUser(Integer userId, Users updateUser) {
		UserDto userDto = new UserDto();
		try {
			Optional<Users> user = userRepo.findById(userId);
			if (user.isPresent()) {
				Users existingUser = user.get();
				existingUser.setEmail(updateUser.getEmail());
				existingUser.setName(updateUser.getName());
				existingUser.setCity(updateUser.getCity());
				existingUser.setRole(updateUser.getRole());
				if (updateUser.getPassword() != null && !updateUser.getPassword().isEmpty()) {
					existingUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
				}
				Users savedUser = userRepo.save(existingUser);
				userDto.setUsers(savedUser);
				userDto.setStatusCode(200);
				userDto.setMessage("Updated Successful");
			} else {
				userDto.setStatusCode(404);
				userDto.setMessage("No user found to update");
			}
		} catch (Exception e) {
			userDto.setStatusCode(500);
			userDto.setMessage("Error occurred while Updating " + e.getMessage());
		}
		return userDto;
	}

	public UserDto getMyInfo(String email) {
		UserDto userDto = new UserDto();

		try {
			Optional<Users> users = userRepo.findByEmail(email);
			if (users.isPresent()) {
				userDto.setUsers(users.get());

				userDto.setStatusCode(200);
				userDto.setMessage("your profile");
			} else {
				userDto.setStatusCode(404);
				userDto.setMessage("No user found to update");
			}
		} catch (Exception e) {
			userDto.setStatusCode(500);
			userDto.setMessage("Error occurred while Updating " + e.getMessage());
		}
		return userDto;
	}

}
