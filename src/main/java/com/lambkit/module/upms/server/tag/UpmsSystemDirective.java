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
package com.lambkit.module.upms.server.tag;

import java.io.IOException;
import java.util.Map;

import com.lambkit.module.upms.rpc.model.UpmsSystem;
import com.lambkit.module.upms.rpc.api.UpmsSystemService;
import com.lambkit.common.util.StringUtils;
import com.lambkit.common.service.ServiceKit;
import com.lambkit.web.tag.base.BaseDirectiveModel;
import com.jfinal.kit.StrKit;
import com.jfinal.render.FreeMarkerRender;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * @author yangyong 
 * @website: www.lambkit.com
 * @email: gismail@foxmail.com
 * @date 2019-04-17
 * @version 1.0
 * @since 1.0
 */
/**
 * upms_system标签<br>
 * 参数：{id:主键}
 * 返回值：{entity:upms_system信息}
 * @author lambkit
 */
public class UpmsSystemDirective extends BaseDirectiveModel {

	@Override
	public void executeMe(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// TODO Auto-generated method stub
		String systemId = get(params, "system_id");
		String icon = get(params, "icon");
		String banner = get(params, "banner");
		String theme = get(params, "theme");
		String basepath = get(params, "basepath");
		String status = get(params, "status");
		String name = get(params, "name");
		String title = get(params, "title");
		String description = get(params, "description");
		String ctime = get(params, "ctime");
		String orders = get(params, "orders");
		int pagenum = getInt(params, "pagenum", 0);
		int pagesize = getInt(params, "pagesize", 0);
		String wheresql = get(params, "sql", null);
		String sql = " from upms_system where "; 
		if(wheresql == null) {
			sql += " 1=1 ";
			if(StringUtils.hasText(systemId)) sql += " and system_id=" + systemId;//int unsigned
			if(StringUtils.hasText(icon)) sql += " and icon like '%" + icon + "%'";//varchar
			if(StringUtils.hasText(banner)) sql += " and banner like '%" + banner + "%'";//varchar
			if(StringUtils.hasText(theme)) sql += " and theme like '%" + theme + "%'";//varchar
			if(StringUtils.hasText(basepath)) sql += " and basepath like '%" + basepath + "%'";//varchar
			if(StringUtils.hasText(status)) sql += " and status=" + status;//tinyint
			if(StringUtils.hasText(name)) sql += " and name like '%" + name + "%'";//varchar
			if(StringUtils.hasText(title)) sql += " and title like '%" + title + "%'";//varchar
			if(StringUtils.hasText(description)) sql += " and description like '%" + description + "%'";//varchar
			if(StringUtils.hasText(ctime)) sql += " and ctime=" + ctime;//bigint
			if(StringUtils.hasText(orders)) sql += " and orders=" + orders;//bigint
		} else {
			sql += wheresql;
		}
		
		String orderby = get(params, "orderby", null);
		
		if(StrKit.notBlank(orderby)) {
			sql += " order by " + orderby;
		}
		
		UpmsSystemService service = UpmsSystem.service();
		
		String tagEntityKeyname = get(params, "key", "entity");
		if(pagenum==0) {
			env.setVariable(tagEntityKeyname, FreeMarkerRender.getConfiguration().getObjectWrapper().wrap(
					service.dao().findFirst("select *" + sql)));
		} else {
			if(pagesize==0) {
				env.setVariable(tagEntityKeyname, FreeMarkerRender.getConfiguration().getObjectWrapper().wrap(
						service.dao().find("select *" + sql)));
			} else {
				env.setVariable(tagEntityKeyname, FreeMarkerRender.getConfiguration().getObjectWrapper().wrap(
						service.dao().paginate(pagenum, pagesize, "select *", sql)));
			}
		}
        body.render(env.getOut());
	}
}
