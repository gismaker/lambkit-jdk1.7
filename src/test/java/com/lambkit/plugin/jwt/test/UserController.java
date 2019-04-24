package com.lambkit.plugin.jwt.test;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.lambkit.plugin.jwt.Auth;
import com.lambkit.plugin.jwt.JwtKit;
import com.lambkit.plugin.jwt.JwtTokenInterceptor;

/**
 * 我有故事，你有酒么？
 * JKhaled created by yunqisong@foxmail.com 2017/9/5
 * FOR : 简单实现
 */
public class UserController extends Controller {

    public void login() {
        User user = getBean(User.class, "");
        String token = JwtKit.getToken(user.getUserName(), user.getPassword());
        renderJson(Ret.by("token", token));
    }

    // 登录认证
    @Before(JwtTokenInterceptor.class)
    public void testLogin() {
        renderJson(Ret.ok());
    }

    @Auth(hasRoles = {"管理员"})
    public void testHasRole() {
        renderJson(Ret.ok());
    }

    @Auth(hasForces = {"登录后台"})
    public void testHasForce() {
        renderJson(Ret.ok());
    }

    @Auth(withRoles = {"管理员", "普通用户"})
    public void testWithRoles() {
        renderJson(Ret.ok());
    }

    @Auth(withForces = {"登录后台", "管理用户"})
    public void testWithForces() {
        renderJson(Ret.ok());
    }

}