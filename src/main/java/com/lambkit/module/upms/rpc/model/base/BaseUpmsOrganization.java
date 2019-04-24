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
public abstract class BaseUpmsOrganization<M extends BaseUpmsOrganization<M>> extends BaseModel<M> implements IBean {

	public String getTableName() {
		return "upms_organization";
	}
    
	public java.lang.Long getOrganizationId() {
		return this.get("organization_id");
	}

	public void setOrganizationId(java.lang.Long organizationId) {
		this.set("organization_id", organizationId);
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
	public java.lang.String getDescription() {
		return this.get("description");
	}

	public void setDescription(java.lang.String description) {
		this.set("description", description);
	}
	public java.lang.Long getCtime() {
		return this.get("ctime");
	}

	public void setCtime(java.lang.Long ctime) {
		this.set("ctime", ctime);
	}
}
