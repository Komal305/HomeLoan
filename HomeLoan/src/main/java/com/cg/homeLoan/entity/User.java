package com.cg.homeLoan.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class User implements UserDetails {
    
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
	 @Column(nullable = false, unique = true)
	    private String email;

	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false)
	    private String password;

	    @Column(nullable = false)
	    private String city;

	    @Enumerated(EnumType.STRING)
	    private Role role; // USER or ADMIN

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	    private List<HomeLoan> homeLoans;
    
    
    public User() {
    	super();
	}

	public User(Integer id, String email, String name, String password, String city, Role role) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.city = city;
		this.role = role;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String getUsername() {
        return email;
    }

	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", city=" + city
				+ ", role=" + role + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	
}