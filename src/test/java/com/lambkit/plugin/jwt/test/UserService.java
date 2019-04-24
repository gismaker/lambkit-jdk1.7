package com.lambkit.plugin.jwt.test;


import java.util.Arrays;
import java.util.HashSet;

import com.jfinal.kit.Kv;
import com.lambkit.plugin.jwt.IJwtAble;
import com.lambkit.plugin.jwt.IJwtUserService;

public class UserService implements IJwtUserService {
    public static final UserService me = new UserService();

    private UserService() {
    }

    private static Kv store = Kv.create();

    static {
        store.set("admin",
                new User().setForces(new HashSet<String>(Arrays.asList("登录后台", "管理用户")))
                        .setRoles(new HashSet<String>(Arrays.asList("管理员", "普通用户")))
                        .setUserName("admin").setPassword("123456")
        ).set("user",
                new User().setForces(new HashSet<String>(Arrays.asList("前台登录", "发布文章")))
                        .setRoles(new HashSet<String>(Arrays.asList("普通用户")))
                        .setUserName("user").setPassword("123456")
        );
    }

    @Override
    public IJwtAble login(String userName, String password) {
        User user = (User) store.get(userName);// 假装登录验证
        if (user != null)
            return user;
        throw new RuntimeException("找不到用户");
    }

	@Override
	public IJwtAble getJwtAbleInfo(String userName) {
		User user = (User) store.get(userName);// 假装登录验证
        if (user != null)
            return user;
        throw new RuntimeException("找不到用户");
	}
}