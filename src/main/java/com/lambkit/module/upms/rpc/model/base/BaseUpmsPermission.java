/**
 * Copyright (c) 2015-2017, Henry Yang 杨勇 (gismail@foxmail.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lambkit.module.upms.rpc.model.base;

import com.jfinal.plugin.activerecord.IBean;

import com.lambkit.common.dao.BaseModel;

/**
 * @author yangyong 
 * @website: www.lambkit.com
 * @email: gismail@foxmail.com
 * @date 2019-04-17
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("serial")
public abstract class BaseUpmsPermission<M extends BaseUpmsPermission<M>> extends BaseModel<M> implements IBean {

	public String getTableName() {
		return "upms_permission";
	}
    
	public java.lang.Long getPermissionId() {
		return this.get("permission_id");
	}

	public void setPermissionId(java.lang.Long permissionId) {
		this.set("permission_id", permissionId);
	}
	public java.lang.Long getSystemId() {
		return this.get("system_id");
	}

	public void setSystemId(java.lang.Long systemId) {
		this.set("system_id", systemId);
	}
	public java.lang.Integer getPid() {
		return this.get("pid");
	}

	public void setPid(java.lang.Integer pid) {
		this.set("pid", pid);
	}
	public java.lang.String getName() {
		return this.get("name");
	}

	public void setName(java.lang.String name) {
		this.set("name", name);
	}
	public java.lang.Integer getType() {
		return this.get("type");
	}

	public void setType(java.lang.Integer type) {
		this.set("type", type);
	}
	public java.lang.String getPermissionValue() {
		return this.get("permission_value");
	}

	public void setPermissionValue(java.lang.String permissionValue) {
		this.set("permission_value", permissionValue);
	}
	public java.lang.String getUri() {
		return this.get("uri");
	}

	public void setUri(java.lang.String uri) {
		this.set("uri", uri);
	}
	public java.lang.String getIcon() {
		return this.get("icon");
	}

	public void setIcon(java.lang.String icon) {
		this.set("icon", icon);
	}
	public java.lang.Integer getStatus() {
		return this.get("status");
	}

	public void setStatus(java.lang.Integer status) {
		this.set("status", status);
	}
	public java.lang.Long getCtime() {
		return this.get("ctime");
	}

	public void setCtime(java.lang.Long ctime) {
		this.set("ctime", ctime);
	}
	public java.lang.Long getOrders() {
		return this.get("orders");
	}

	public void setOrders(java.lang.Long orders) {
		this.set("orders", orders);
	}
}
