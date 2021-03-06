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
package com.lambkit.module.upms.rpc.query;

import com.lambkit.common.dao.BaseModelQueryImpl;

import com.lambkit.module.upms.rpc.model.UpmsUserRole;

/**
 * @author yangyong 
 * @website: www.lambkit.com
 * @email: gismail@foxmail.com
 * @date 2018-10-25
 * @version 1.0
 * @since 1.0
 * ${tbcnn}
 */
public class UpmsUserRoleQuery extends BaseModelQueryImpl<UpmsUserRole> {

	protected final UpmsUserRole DAO = new UpmsUserRole();
	private static final UpmsUserRoleQuery QUERY = new UpmsUserRoleQuery();

	public static UpmsUserRoleQuery me() {
		return QUERY;
	}
	
	public UpmsUserRole dao() {
		return DAO;
	}
	
	@Override
	public Class<UpmsUserRole> getModelClass() {
		// TODO Auto-generated method stub
		return UpmsUserRole.class;
	}
	
}
