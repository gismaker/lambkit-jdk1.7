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
package com.lambkit.module.upms.rpc.model;

import com.jfinal.kit.StrKit;
import com.lambkit.common.service.ServiceKit;
import com.lambkit.db.sql.column.Column;
import com.lambkit.module.upms.common.UpmsConfig;
import com.lambkit.module.upms.common.UpmsManager;

import com.lambkit.module.upms.rpc.model.base.BaseUpmsRolePermission;
import com.lambkit.module.upms.rpc.sql.UpmsRolePermissionCriteria;
import com.lambkit.module.upms.rpc.api.UpmsRolePermissionService;
import com.lambkit.module.upms.rpc.service.impl.UpmsRolePermissionServiceImpl;

/**
 * @author yangyong 
 * @website: www.lambkit.com
 * @email: gismail@foxmail.com
 * @date 2019-04-17
 * @version 1.0
 * @since 1.0
 */
public class UpmsRolePermission extends BaseUpmsRolePermission<UpmsRolePermission> {

	private static final long serialVersionUID = 1L;
	
	public static UpmsRolePermissionService service() {
		return ServiceKit.inject(UpmsRolePermissionService.class, UpmsRolePermissionServiceImpl.class);
	}
	
	public static UpmsRolePermissionCriteria sql() {
		return new UpmsRolePermissionCriteria();
	}
	
	public static UpmsRolePermissionCriteria sql(Column column) {
		UpmsRolePermissionCriteria that = new UpmsRolePermissionCriteria();
		that.add(column);
        return that;
    }
	
	public UpmsRolePermission() {
		UpmsConfig config = UpmsManager.me().getConfig();
		String dbconfig = config.getDbconfig();
		if(StrKit.notBlank(dbconfig)) {
			this.use(dbconfig);
		}
	}
}
