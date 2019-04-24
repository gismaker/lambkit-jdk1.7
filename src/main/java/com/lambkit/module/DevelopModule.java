package com.lambkit.module;

import com.jfinal.config.Handlers;
import com.jfinal.config.Routes;
import com.lambkit.Lambkit;
import com.lambkit.component.swagger.SwaggerController;
import com.lambkit.db.mgr.MgrdbConfig;
import com.lambkit.db.mgr.controller.MgrdbApiController;
import com.lambkit.db.mgr.controller.MgrdbController;
import com.lambkit.db.mgr.controller.MgrdbViewController;
import com.lambkit.system.controller.FileController;
import com.lambkit.system.controller.HandlerController;
import com.lambkit.system.controller.InterceptorController;
import com.lambkit.system.controller.MappingController;
import com.lambkit.system.controller.MgrdbIndexController;
import com.lambkit.system.controller.MonitorController;
import com.lambkit.system.controller.PluginController;
import com.lambkit.system.controller.PropController;
import com.lambkit.system.controller.RouteController;
import com.lambkit.system.controller.SystemIndexController;
import com.lambkit.system.controller.TagController;
import com.lambkit.web.handler.LambkitDruidStatViewHandler;

public class DevelopModule extends LambkitModule {

	@Override
	public void configRoute(Routes routes) {
		routes.add("/lambkit/dev", SystemIndexController.class, "/lambkit/dev");
		routes.add("/lambkit/dev/route", RouteController.class, "/lambkit/dev/route");
		routes.add("/lambkit/dev/handler", HandlerController.class, "/lambkit/dev/handler");
		routes.add("/lambkit/dev/plugin", PluginController.class, "/lambkit/dev/plugin");
		routes.add("/lambkit/dev/tag", TagController.class, "/lambkit/dev/tag");
		routes.add("/lambkit/dev/interceptor", InterceptorController.class, "/lambkit/dev/interceptor");
		routes.add("/lambkit/dev/mapping", MappingController.class, "/lambkit/dev/mapping");
		routes.add("/lambkit/dev/prop", PropController.class, "/lambkit/dev/prop");
		routes.add("/lambkit/dev/monitor", MonitorController.class, "/lambkit/dev/monitor");
		routes.add("/lambkit/dev/file", FileController.class, "/lambkit/dev/file");
		routes.add("/lambkit/dev/swagger", SwaggerController.class, "/lambkit/dev/swagger");
		
		MgrdbConfig config = Lambkit.config(MgrdbConfig.class);
		if(MgrdbConfig.META.equals(config.getType())) {
			routes.add("/lambkit/mgrdb/api", MgrdbApiController.class);
			routes.add("/lambkit/mgrdb", MgrdbViewController.class, "/lambkit/dev/mgrdb/enjoy");
		} else if(MgrdbConfig.SYSCONFIG.equals(config.getType())) {
			routes.add("/lambkit/mgrdb", MgrdbController.class, "/lambkit/dev/mgrdb/freemarker");
		} 
		routes.add("/lambkit/dev/mgrdb", MgrdbIndexController.class, "/lambkit/dev/mgrdb");
	}
	
	@Override
	public void configHandler(Handlers me) {
		LambkitDruidStatViewHandler druidViewHandler = new LambkitDruidStatViewHandler();
		me.add(druidViewHandler);
	}
}
