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
public abstract class BaseUpmsCredit<M extends BaseUpmsCredit<M>> extends BaseModel<M> implements IBean {

	public String getTableName() {
		return "upms_credit";
	}
    
	public java.lang.Long getId() {
		return this.get("id");
	}

	public void setId(java.lang.Long id) {
		this.set("id", id);
	}
	public java.lang.Long getUserId() {
		return this.get("user_id");
	}

	public void setUserId(java.lang.Long userId) {
		this.set("user_id", userId);
	}
	public java.lang.Integer getCredit() {
		return this.get("credit");
	}

	public void setCredit(java.lang.Integer credit) {
		this.set("credit", credit);
	}
	public java.lang.String getCtype() {
		return this.get("ctype");
	}

	public void setCtype(java.lang.String ctype) {
		this.set("ctype", ctype);
	}
	public java.util.Date getCtime() {
		return this.get("ctime");
	}

	public void setCtime(java.util.Date ctime) {
		this.set("ctime", ctime);
	}
	public java.lang.String getAction() {
		return this.get("action");
	}

	public void setAction(java.lang.String action) {
		this.set("action", action);
	}
}
