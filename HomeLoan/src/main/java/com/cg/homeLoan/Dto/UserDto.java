package com.cg.homeLoan.Dto;
import java.util.List;

import com.cg.homeLoan.entity.Role;
import com.cg.homeLoan.entity.User;

public class UserDto {

	private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String name;
    private String city;
    private Role role;
    private String email;
    private String password;
    private User User;
    private List<User> usersList;

    public UserDto() {
    }

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public List<User> getOurUsersList() {
		return usersList;
	}

	public void setOurUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	@Override
	public String toString() {
		return "UserDto [statusCode=" + statusCode + ", error=" + error + ", message=" + message + ", token=" + token
				+ ", refreshToken=" + refreshToken + ", expirationTime=" + expirationTime + ", name=" + name + ", city="
				+ city + ", role=" + role + ", email=" + email + ", password=" + password + ", User=" + User
				+ ", ourUsersList=" + usersList + "]";
	}

    
}