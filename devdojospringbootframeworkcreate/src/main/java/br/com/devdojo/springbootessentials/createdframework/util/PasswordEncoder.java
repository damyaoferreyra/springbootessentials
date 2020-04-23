package br.com.devdojo.springbootessentials.createdframework.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("1234"));
		System.out.println(passwordEncoder.matches("1234", 
				"$2a$10$MkAT/KSGVDN25NPTdt6A6.xkrBV1kX4DV8yNH6ZJTr.24/LK8bEYC"));
		
	}
}
