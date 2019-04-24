package com.lambkit.plugin.jwt.test;

import com.jfinal.config.Interceptors;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.lambkit.Lambkit;
import com.lambkit.module.LambkitModule;
import com.lambkit.plugin.jwt.AuthInterceptor;
import com.lambkit.plugin.jwt.JwtTokenPlugin;

public class JwtTestServerStart {

	public static void main(String[] args) {

		LambkitModule config = new LambkitModule() {
			@Override
			public void configRoute(Routes me) {
				// TODO Auto-generated method stub
				super.configRoute(me);
				me.add("/user", UserController.class);
			}

			@Override
			public void configPlugin(Plugins me) {
				/** 配置权限拦截插件 */
				me.add(new JwtTokenPlugin(UserService.me));
			}
			
			@Override
		    public void configInterceptor(Interceptors me) {
				// 权限拦截器
		        me.add(new AuthInterceptor());                  
		    }

		};
		Lambkit.me().addModule(config);

		Lambkit.setBootArg("lambkit.server.webAppDir", "src/main/webapp");
		Lambkit.setBootArg("lambkit.server.port", 8080);
		Lambkit.run(args);
	}
}
