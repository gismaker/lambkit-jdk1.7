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
import com.jfinal.plugin.activerecord.Db;
import com.lambkit.common.service.BaseModelServiceImpl;
import com.lambkit.common.util.DateTimeUtils;
import com.lambkit.module.upms.rpc.api.UpmsCreditService;
import com.lambkit.module.upms.rpc.model.UpmsCredit;
import com.lambkit.module.upms.rpc.model.UpmsUserCredit;

/**
 * @author yangyong 
 * @website: www.lambkit.com
 * @email: gismail@foxmail.com
 * @date 2019-04-17
 * @version 1.0
 * @since 1.0
 */
public class UpmsCreditServiceImpl extends BaseModelServiceImpl<UpmsCredit> implements UpmsCreditService {
	
	private UpmsCredit DAO = null;
	
	public UpmsCredit dao() {
		if(DAO==null) {
			DAO = Enhancer.enhance(UpmsCredit.class.getName(), UpmsCredit.class);
		}
		return DAO;
	}

	@Override
	public boolean addCredit(Long userId, Integer credit, String ctype, String action) {
		UpmsCredit model = new UpmsCredit();
		model.setUserId(userId);
		model.setCredit(credit);
		model.setCtype(ctype);
		model.setAction(action);
		model.setCtime(DateTimeUtils.getCurrentTime());
		boolean flag = model.save();
		if(flag) {
			boolean fuc = addUserCredit(userId, credit);
			if(!fuc) {
				model.delete();
				return false;
			}
		}
		return true;
	}
	
	private boolean addUserCredit(Long userId, Integer credit) {
		UpmsUserCredit uc = UpmsUserCredit.service().findById(userId);
		credit = credit==null ? 0 : credit;
		boolean flag = false;
		if(uc==null) {
			uc = new UpmsUserCredit();
			uc.setUserId(userId);
			uc.setCredit(credit);
			flag = uc.save();
		} else {
			Integer tc = uc.getCredit()==null ? 0 : uc.getCredit();
			uc.setCredit(credit+tc);
			flag = uc.update();
		}
		return flag;
	}

	@Override
	public List<UpmsCredit> currentMonthCredits(Long userId, String ctype, String action) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ").append(getTableName()).append(" WHERE ").append(" user_id=? and ");
		sb.append(" DATE_FORMAT(ctime, '%Y%m') = DATE_FORMAT(CURDATE(), '%Y%m')");
		boolean f = StrKit.notBlank(ctype);
		boolean e = StrKit.notBlank(action);
		if(f && e) {
			sb.append(" and ctype=? and action=?");
			return dao().find(sb.toString(), userId, ctype, action);
		} else if(f) {
			sb.append(" and ctype=?");
			return dao().find(sb.toString(), userId, ctype);
		} else if(e) {
			sb.append(" and action=?");
			return dao().find(sb.toString(), userId, action);
		} else {
			return dao().find(sb.toString(), userId);
		}
	}

	@Override
	public Integer currentMonthCredit(Long userId, String ctype, String action) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT sum(credit) as credit FROM ").append(getTableName()).append(" WHERE ").append(" user_id=? and ");
		sb.append(" DATE_FORMAT(ctime, '%Y%m') = DATE_FORMAT(CURDATE(), '%Y%m')");
		boolean f = StrKit.notBlank(ctype);
		boolean e = StrKit.notBlank(action);
		Integer credit = 0;
		if(f && e) {
			sb.append(" and ctype=? and action=?");
			credit = Db.use(dao().configName()).queryInt(sb.toString(), userId, ctype, action);
		} else if(f) {
			sb.append(" and ctype=?");
			credit = Db.use(dao().configName()).queryInt(sb.toString(), userId, ctype);
		} else if(e) {
			sb.append(" and action=?");
			credit = Db.use(dao().configName()).queryInt(sb.toString(), userId, action);
		} else {
			credit = Db.use(dao().configName()).queryInt(sb.toString(), userId);
		}
		credit = credit==null? 0 : credit;
		return credit;
	}
}
