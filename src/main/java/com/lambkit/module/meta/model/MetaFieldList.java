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
package com.lambkit.module.meta.model;

import com.jfinal.kit.StrKit;
import com.lambkit.common.service.ServiceKit;
import com.lambkit.db.sql.column.Column;
import com.lambkit.module.meta.MetaMgrConfig;
import com.lambkit.module.meta.MetaMgrManager;

import com.lambkit.module.meta.model.base.BaseMetaFieldList;
import com.lambkit.module.meta.model.sql.MetaFieldListCriteria;
import com.lambkit.module.meta.service.MetaFieldListService;
import com.lambkit.module.meta.service.impl.MetaFieldListServiceImpl;

/**
 * @author yangyong 
 * @website: www.lambkit.com
 * @email: gismail@foxmail.com
 * @date 2019-01-07
 * @version 1.0
 * @since 1.0
 */
public class MetaFieldList extends BaseMetaFieldList<MetaFieldList> {

	private static final long serialVersionUID = 1L;
	
	public static MetaFieldListService service() {
		return ServiceKit.inject(MetaFieldListService.class, MetaFieldListServiceImpl.class);
	}
	
	public static MetaFieldListCriteria sql() {
		return new MetaFieldListCriteria();
	}
	
	public static MetaFieldListCriteria sql(Column column) {
		MetaFieldListCriteria that = new MetaFieldListCriteria();
		that.add(column);
        return that;
    }

	public MetaFieldList() {
		MetaMgrConfig config = MetaMgrManager.me().getConfig();
		String dbconfig = config.getDbconfig();
		if(StrKit.notBlank(dbconfig)) {
			this.use(dbconfig);
		}
	}
}
