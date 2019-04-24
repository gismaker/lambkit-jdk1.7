package com.lambkit.module.api;

import com.jfinal.config.Routes;
import com.lambkit.plugin.jwt.JwtTokenInterceptor;

public abstract class ApiRoutes extends Routes {

	@Override
	public void config() {
		// TODO Auto-generated method stub
		addInterceptor(new JwtTokenInterceptor());
	}
	
	public abstract void configRoute();

}
