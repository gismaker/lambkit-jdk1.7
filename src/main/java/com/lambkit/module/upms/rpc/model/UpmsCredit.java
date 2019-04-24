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

import com.lambkit.module.upms.rpc.model.base.BaseUpmsCredit;
import com.lambkit.module.upms.rpc.sql.UpmsCreditCriteria;
import com.lambkit.module.upms.rpc.api.UpmsCreditService;
import com.lambkit.module.upms.rpc.service.impl.UpmsCreditServiceImpl;

/**
 * @author yangyong 
 * @website: www.lambkit.com
 * @email: gismail@foxmail.com
 * @date 2019-04-17
 * @version 1.0
 * @since 1.0
 */
public class UpmsCredit extends BaseUpmsCredit<UpmsCredit> {

	private static final long serialVersionUID = 1L;
	
	public static UpmsCreditService service() {
		return ServiceKit.inject(UpmsCreditService.class, UpmsCreditServiceImpl.class);
	}
	
	public static UpmsCreditCriteria sql() {
		return new UpmsCreditCriteria();
	}
	
	public static UpmsCreditCriteria sql(Column column) {
		UpmsCreditCriteria that = new UpmsCreditCriteria();
		that.add(column);
        return that;
    }
	
	public UpmsCredit() {
		UpmsConfig config = UpmsManager.me().getConfig();
		String dbconfig = config.getDbconfig();
		if(StrKit.notBlank(dbconfig)) {
			this.use(dbconfig);
		}
	}
}
