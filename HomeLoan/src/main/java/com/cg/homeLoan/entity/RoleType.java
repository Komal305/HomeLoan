package com.cg.homeLoan.entity;

public enum RoleType {
	 USER,
	    ADMIN;
	    
	    public static RoleType fromName(String name) {
	        switch (name) {
	            case "USER":
	                return USER;
	            case "ADMIN":
	                return ADMIN;
	            default:
	                throw new IllegalArgumentException("Unknown role: " + name);
	        }
	    }
}
