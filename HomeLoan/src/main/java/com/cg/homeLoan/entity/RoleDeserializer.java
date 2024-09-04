package com.cg.homeLoan.entity;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.homeLoan.repo.RoleRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;


public class RoleDeserializer extends StdDeserializer<Role> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	RoleRepository roleRepository;
	
    public RoleDeserializer() {
        super(Role.class);
    }

    @Override
    public Role deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String roleName = p.getText();
        // Assuming you have a method in your Role repository to find the Role by name
        return roleRepository.findByRole(roleName);
    }
}

