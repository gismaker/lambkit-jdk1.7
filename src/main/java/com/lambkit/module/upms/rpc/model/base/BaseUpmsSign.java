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
public abstract class BaseUpmsSign<M extends BaseUpmsSign<M>> extends BaseModel<M> implements IBean {

	public String getTableName() {
		return "upms_sign";
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
	public java.util.Date getStime() {
		return this.get("stime");
	}

	public void setStime(java.util.Date stime) {
		this.set("stime", stime);
	}
	public java.lang.Float getLng() {
		return this.get("lng");
	}

	public void setLng(java.lang.Float lng) {
		this.set("lng", lng);
	}
	public java.lang.Float getLat() {
		return this.get("lat");
	}

	public void setLat(java.lang.Float lat) {
		this.set("lat", lat);
	}
	public java.lang.String getSway() {
		return this.get("sway");
	}

	public void setSway(java.lang.String sway) {
		this.set("sway", sway);
	}
}
