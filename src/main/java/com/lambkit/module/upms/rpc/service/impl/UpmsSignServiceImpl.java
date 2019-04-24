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
package com.lambkit.module.upms.rpc.service.impl;

import java.util.List;

import com.jfinal.aop.Enhancer;
import com.jfinal.kit.StrKit;
import com.lambkit.common.service.BaseModelServiceImpl;
import com.lambkit.module.upms.rpc.api.UpmsSignService;
import com.lambkit.module.upms.rpc.model.UpmsSign;

/**
 * @author yangyong 
 * @website: www.lambkit.com
 * @email: gismail@foxmail.com
 * @date 2019-04-17
 * @version 1.0
 * @since 1.0
 */
public class UpmsSignServiceImpl extends BaseModelServiceImpl<UpmsSign> implements UpmsSignService {
	
	private UpmsSign DAO = null;
	
	public UpmsSign dao() {
		if(DAO==null) {
			DAO = Enhancer.enhance(UpmsSign.class.getName(), UpmsSign.class);
		}
		return DAO;
	}

	@Override
	public UpmsSign today(Long userId, String sway) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ").append(getTableName()).append(" WHERE ").append(" user_id=? and ");
		sb.append(" to_days(stime) = to_days(now())");
		boolean f = StrKit.notBlank(sway);
		if(f) {
			sb.append(" and sway=?");
			return dao().findFirst(sb.toString(), userId, sway);
		} else {
			return dao().findFirst(sb.toString(), userId);
		}
	}

	@Override
	public List<UpmsSign> currentMonth(Long userId, String sway) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT *, DATE_FORMAT(stime,'%d') as d FROM ").append(getTableName()).append(" WHERE ").append(" user_id=? and ");
		sb.append(" DATE_FORMAT(stime, '%Y%m') = DATE_FORMAT(CURDATE(), '%Y%m')");
		boolean f = StrKit.notBlank(sway);
		if(f) {
			sb.append(" and sway=?");
			return dao().find(sb.toString(), userId, sway);
		} else {
			return dao().find(sb.toString(), userId);
		}
	}
}
