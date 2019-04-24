package com.lambkit.module.api;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class AccessTokenInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		inv.invoke();
	}

}
