package com.lambkit.plugin.jwt.test;


import java.util.Date;
import java.util.Set;

import com.lambkit.plugin.jwt.IJwtAble;

/**
 * 我有故事，你有酒么？
 * JKhaled created by yunqisong@foxmail.com 2017/9/5
 * FOR : 简单实现
 */
public class User implements IJwtAble {

    private String userName;

    private String password;

    private Set<String> _roles;

    private Set<String> _forces;

    /**
     * 当前用户的角色
     *
     * @return
     */
    @Override
    public Set<String> getRoles() {
        // 使用的时候写通过数据库查询返回给插件一个角色集合
        return get_roles();
    }

    /**
     * 当前用户的权限
     *
     * @return
     */
    @Override
    public Set<String> getForces() {
        // 使用的时候写通过数据库查询返回给插件一个角色集合
        return get_forces();
    }

    /**
     * 上次修改密码时间
     *
     * @return
     */
    @Override
    public Date getLastModifyPasswordTime() {

        return new Date(System.currentTimeMillis() - 60L * 1000L * 60L * 24);
    }



    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setRoles(Set<String> roles) {
        this._roles = roles;
        return this;
    }

    public User setForces(Set<String> forces) {
        this._forces = forces;
        return this;
    }

    public Set<String> get_roles() {
        return _roles;
    }

    public Set<String> get_forces() {
        return _forces;
    }
}