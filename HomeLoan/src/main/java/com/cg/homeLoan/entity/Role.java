package com.cg.homeLoan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType role; // ADMIN, USER, etc.
    

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Role(Long id, RoleType role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}



	
   
}