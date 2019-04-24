package com.lambkit.module.api;

public interface IAccessTokenService {

	String getToken(String name);
	
	String generateToken(String name);
	
	String access(String token);
}
