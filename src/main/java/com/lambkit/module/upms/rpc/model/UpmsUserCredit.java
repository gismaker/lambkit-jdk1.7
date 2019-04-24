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

import com.lambkit.module.upms.rpc.model.base.BaseUpmsUserCredit;
import com.lambkit.module.upms.rpc.sql.UpmsUserCreditCriteria;
import com.lambkit.module.upms.rpc.api.UpmsUserCreditService;
import com.lambkit.module.upms.rpc.service.impl.UpmsUserCreditServiceImpl;

/**
 * @author yangyong 
 * @website: www.lambkit.com
 * @email: gismail@foxmail.com
 * @date 2019-04-17
 * @version 1.0
 * @since 1.0
 */
public class UpmsUserCredit extends BaseUpmsUserCredit<UpmsUserCredit> {

	private static final long serialVersionUID = 1L;
	
	public static UpmsUserCreditService service() {
		return ServiceKit.inject(UpmsUserCreditService.class, UpmsUserCreditServiceImpl.class);
	}
	
	public static UpmsUserCreditCriteria sql() {
		return new UpmsUserCreditCriteria();
	}
	
	public static UpmsUserCreditCriteria sql(Column column) {
		UpmsUserCreditCriteria that = new UpmsUserCreditCriteria();
		that.add(column);
        return that;
    }
	
	public UpmsUserCredit() {
		UpmsConfig config = UpmsManager.me().getConfig();
		String dbconfig = config.getDbconfig();
		if(StrKit.notBlank(dbconfig)) {
			this.use(dbconfig);
		}
	}
}
