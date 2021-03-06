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

import com.jfinal.kit.StrKit;
import com.lambkit.db.sql.IQuery;
import com.lambkit.db.sql.QueryParas;
import com.lambkit.module.upms.rpc.query.UpmsSystemQuery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangyong 
 * @website: www.lambkit.com
 * @email: gismail@foxmail.com
 * @date 2018-10-26
 * @version 1.0
 * @since 1.0
 * ${tbcnn}
 */
public class UpmsSystemExample implements IQuery, Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public UpmsSystemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
    
    public QueryParas toQueryParas() {
    	StringBuilder str = new StringBuilder();
    	int k=0;
    	for (Criteria criteria : oredCriteria) {
			if(criteria.isValid()) {
				if(StrKit.notBlank(str.toString())) {
					str.append(" or ");
				}
				str.append("(");
	    		int i=0;
				for (Criterion criterion : criteria.criteria) {
					boolean bStr = "String".equals(criterion.getValueType());
					if(criterion.noValue) {
						if(i>0) str.append(" and ");
						str.append(criterion.condition);
					} else if(criterion.singleValue) {
						if(i>0) str.append(" and ");
						str.append(criterion.condition);
						str.append(" ");
						if(bStr) str.append("'");
						str.append(criterion.value);
						if(bStr) str.append("'");
					} else if(criterion.betweenValue) {
						if(i>0) str.append(" and ");
						str.append(criterion.condition);
						str.append(" ");
						if(bStr) str.append("'");
						str.append(criterion.value);
						if(bStr) str.append("'");
						str.append(" and ");
						if(bStr) str.append("'");
						str.append(criterion.secondValue);
						if(bStr) str.append("'");
					} else if(criterion.listValue) {
						if(i>0) str.append(" and ");
						str.append(criterion.condition);
						int j=0;
						for (Object val : (List<?>)criterion.value) {
							if(j==0) str.append(" (");
							else str.append(",");
							j++;
							if(bStr) str.append("'");
							str.append(val);
							if(bStr) str.append("'");
						}
						str.append(")");
					}
					i++;
				}
				str.append(")");
			}
		}
    	String sqlWhere = str.toString();
    	QueryParas p = new QueryParas();
    	p.setSelect("select * ");
    	StringBuilder s = new StringBuilder();
    	s.append(" from ");
    	s.append(UpmsSystemQuery.me().getTableName());
    	if(StrKit.notBlank(sqlWhere)) {
    		s.append(" where ");
        	s.append(sqlWhere);
    	}
    	p.setSqlExceptSelect(s.toString());
    	return p;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property, String typeHandler, String valueType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value, typeHandler, valueType));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property, String typeHandler, String valueType) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2, typeHandler, valueType));
        }

        public Criteria andSystemIdIsNull() {
            addCriterion("system_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("system_id is not null");
            return (Criteria) this;
        }

         public Criteria andSystemIdEqualTo(java.lang.Long value) {
            addCriterion("system_id =", value, "systemId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(java.lang.Long value) {
            addCriterion("system_id <>", value, "systemId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(java.lang.Long value) {
            addCriterion("system_id >", value, "systemId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(java.lang.Long value) {
            addCriterion("system_id >=", value, "systemId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(java.lang.Long value) {
            addCriterion("system_id <", value, "systemId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(java.lang.Long value) {
            addCriterion("system_id <=", value, "systemId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("system_id between", value1, value2, "systemId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("system_id not between", value1, value2, "systemId", "java.lang.Long", "Float");
            return (Criteria) this;
        }
        
        public Criteria andSystemIdIn(List<Integer> values) {
            addCriterion("system_id in", values, "systemId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<java.lang.Long> values) {
            addCriterion("system_id not in", values, "systemId", "java.lang.Long", "Float");
            return (Criteria) this;
        }
        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

         public Criteria andIconLike(java.lang.String value) {
            addCriterion("icon like", value, "icon", "java.lang.String", "Float");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(java.lang.String value) {
            addCriterion("icon not like", value, "icon", "java.lang.String", "Float");
            return (Criteria) this;
        }
        public Criteria andIconEqualTo(java.lang.String value) {
            addCriterion("icon =", value, "icon", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(java.lang.String value) {
            addCriterion("icon <>", value, "icon", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(java.lang.String value) {
            addCriterion("icon >", value, "icon", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(java.lang.String value) {
            addCriterion("icon >=", value, "icon", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(java.lang.String value) {
            addCriterion("icon <", value, "icon", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(java.lang.String value) {
            addCriterion("icon <=", value, "icon", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andIconBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("icon between", value1, value2, "icon", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("icon not between", value1, value2, "icon", "java.lang.String", "String");
            return (Criteria) this;
        }
        
        public Criteria andIconIn(List<Integer> values) {
            addCriterion("icon in", values, "icon", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<java.lang.String> values) {
            addCriterion("icon not in", values, "icon", "java.lang.String", "String");
            return (Criteria) this;
        }
        public Criteria andBannerIsNull() {
            addCriterion("banner is null");
            return (Criteria) this;
        }

        public Criteria andBannerIsNotNull() {
            addCriterion("banner is not null");
            return (Criteria) this;
        }

         public Criteria andBannerLike(java.lang.String value) {
            addCriterion("banner like", value, "banner", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBannerNotLike(java.lang.String value) {
            addCriterion("banner not like", value, "banner", "java.lang.String", "String");
            return (Criteria) this;
        }
        public Criteria andBannerEqualTo(java.lang.String value) {
            addCriterion("banner =", value, "banner", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBannerNotEqualTo(java.lang.String value) {
            addCriterion("banner <>", value, "banner", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBannerGreaterThan(java.lang.String value) {
            addCriterion("banner >", value, "banner", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBannerGreaterThanOrEqualTo(java.lang.String value) {
            addCriterion("banner >=", value, "banner", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBannerLessThan(java.lang.String value) {
            addCriterion("banner <", value, "banner", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBannerLessThanOrEqualTo(java.lang.String value) {
            addCriterion("banner <=", value, "banner", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBannerBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("banner between", value1, value2, "banner", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBannerNotBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("banner not between", value1, value2, "banner", "java.lang.String", "String");
            return (Criteria) this;
        }
        
        public Criteria andBannerIn(List<Integer> values) {
            addCriterion("banner in", values, "banner", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBannerNotIn(List<java.lang.String> values) {
            addCriterion("banner not in", values, "banner", "java.lang.String", "String");
            return (Criteria) this;
        }
        public Criteria andThemeIsNull() {
            addCriterion("theme is null");
            return (Criteria) this;
        }

        public Criteria andThemeIsNotNull() {
            addCriterion("theme is not null");
            return (Criteria) this;
        }

         public Criteria andThemeLike(java.lang.String value) {
            addCriterion("theme like", value, "theme", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andThemeNotLike(java.lang.String value) {
            addCriterion("theme not like", value, "theme", "java.lang.String", "String");
            return (Criteria) this;
        }
        public Criteria andThemeEqualTo(java.lang.String value) {
            addCriterion("theme =", value, "theme", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andThemeNotEqualTo(java.lang.String value) {
            addCriterion("theme <>", value, "theme", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThan(java.lang.String value) {
            addCriterion("theme >", value, "theme", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThanOrEqualTo(java.lang.String value) {
            addCriterion("theme >=", value, "theme", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andThemeLessThan(java.lang.String value) {
            addCriterion("theme <", value, "theme", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andThemeLessThanOrEqualTo(java.lang.String value) {
            addCriterion("theme <=", value, "theme", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andThemeBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("theme between", value1, value2, "theme", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andThemeNotBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("theme not between", value1, value2, "theme", "java.lang.String", "String");
            return (Criteria) this;
        }
        
        public Criteria andThemeIn(List<Integer> values) {
            addCriterion("theme in", values, "theme", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andThemeNotIn(List<java.lang.String> values) {
            addCriterion("theme not in", values, "theme", "java.lang.String", "String");
            return (Criteria) this;
        }
        public Criteria andBasepathIsNull() {
            addCriterion("basepath is null");
            return (Criteria) this;
        }

        public Criteria andBasepathIsNotNull() {
            addCriterion("basepath is not null");
            return (Criteria) this;
        }

         public Criteria andBasepathLike(java.lang.String value) {
            addCriterion("basepath like", value, "basepath", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBasepathNotLike(java.lang.String value) {
            addCriterion("basepath not like", value, "basepath", "java.lang.String", "String");
            return (Criteria) this;
        }
        public Criteria andBasepathEqualTo(java.lang.String value) {
            addCriterion("basepath =", value, "basepath", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBasepathNotEqualTo(java.lang.String value) {
            addCriterion("basepath <>", value, "basepath", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBasepathGreaterThan(java.lang.String value) {
            addCriterion("basepath >", value, "basepath", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBasepathGreaterThanOrEqualTo(java.lang.String value) {
            addCriterion("basepath >=", value, "basepath", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBasepathLessThan(java.lang.String value) {
            addCriterion("basepath <", value, "basepath", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBasepathLessThanOrEqualTo(java.lang.String value) {
            addCriterion("basepath <=", value, "basepath", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBasepathBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("basepath between", value1, value2, "basepath", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBasepathNotBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("basepath not between", value1, value2, "basepath", "java.lang.String", "String");
            return (Criteria) this;
        }
        
        public Criteria andBasepathIn(List<Integer> values) {
            addCriterion("basepath in", values, "basepath", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andBasepathNotIn(List<java.lang.String> values) {
            addCriterion("basepath not in", values, "basepath", "java.lang.String", "String");
            return (Criteria) this;
        }
        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

         public Criteria andStatusEqualTo(java.lang.Integer value) {
            addCriterion("status =", value, "status", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(java.lang.Integer value) {
            addCriterion("status <>", value, "status", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(java.lang.Integer value) {
            addCriterion("status >", value, "status", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(java.lang.Integer value) {
            addCriterion("status >=", value, "status", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(java.lang.Integer value) {
            addCriterion("status <", value, "status", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(java.lang.Integer value) {
            addCriterion("status <=", value, "status", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(java.lang.Integer value1, java.lang.Integer value2) {
            addCriterion("status between", value1, value2, "status", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(java.lang.Integer value1, java.lang.Integer value2) {
            addCriterion("status not between", value1, value2, "status", "java.lang.Integer", "Float");
            return (Criteria) this;
        }
        
        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<java.lang.Integer> values) {
            addCriterion("status not in", values, "status", "java.lang.Integer", "Float");
            return (Criteria) this;
        }
        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

         public Criteria andNameLike(java.lang.String value) {
            addCriterion("name like", value, "name", "java.lang.String", "Float");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(java.lang.String value) {
            addCriterion("name not like", value, "name", "java.lang.String", "Float");
            return (Criteria) this;
        }
        public Criteria andNameEqualTo(java.lang.String value) {
            addCriterion("name =", value, "name", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(java.lang.String value) {
            addCriterion("name <>", value, "name", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(java.lang.String value) {
            addCriterion("name >", value, "name", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(java.lang.String value) {
            addCriterion("name >=", value, "name", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(java.lang.String value) {
            addCriterion("name <", value, "name", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(java.lang.String value) {
            addCriterion("name <=", value, "name", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andNameBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("name between", value1, value2, "name", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("name not between", value1, value2, "name", "java.lang.String", "String");
            return (Criteria) this;
        }
        
        public Criteria andNameIn(List<Integer> values) {
            addCriterion("name in", values, "name", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<java.lang.String> values) {
            addCriterion("name not in", values, "name", "java.lang.String", "String");
            return (Criteria) this;
        }
        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

         public Criteria andTitleLike(java.lang.String value) {
            addCriterion("title like", value, "title", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(java.lang.String value) {
            addCriterion("title not like", value, "title", "java.lang.String", "String");
            return (Criteria) this;
        }
        public Criteria andTitleEqualTo(java.lang.String value) {
            addCriterion("title =", value, "title", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(java.lang.String value) {
            addCriterion("title <>", value, "title", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(java.lang.String value) {
            addCriterion("title >", value, "title", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(java.lang.String value) {
            addCriterion("title >=", value, "title", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(java.lang.String value) {
            addCriterion("title <", value, "title", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(java.lang.String value) {
            addCriterion("title <=", value, "title", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("title between", value1, value2, "title", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("title not between", value1, value2, "title", "java.lang.String", "String");
            return (Criteria) this;
        }
        
        public Criteria andTitleIn(List<Integer> values) {
            addCriterion("title in", values, "title", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<java.lang.String> values) {
            addCriterion("title not in", values, "title", "java.lang.String", "String");
            return (Criteria) this;
        }
        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

         public Criteria andDescriptionLike(java.lang.String value) {
            addCriterion("description like", value, "description", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(java.lang.String value) {
            addCriterion("description not like", value, "description", "java.lang.String", "String");
            return (Criteria) this;
        }
        public Criteria andDescriptionEqualTo(java.lang.String value) {
            addCriterion("description =", value, "description", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(java.lang.String value) {
            addCriterion("description <>", value, "description", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(java.lang.String value) {
            addCriterion("description >", value, "description", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(java.lang.String value) {
            addCriterion("description >=", value, "description", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(java.lang.String value) {
            addCriterion("description <", value, "description", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(java.lang.String value) {
            addCriterion("description <=", value, "description", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("description between", value1, value2, "description", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("description not between", value1, value2, "description", "java.lang.String", "String");
            return (Criteria) this;
        }
        
        public Criteria andDescriptionIn(List<Integer> values) {
            addCriterion("description in", values, "description", "java.lang.String", "String");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<java.lang.String> values) {
            addCriterion("description not in", values, "description", "java.lang.String", "String");
            return (Criteria) this;
        }
        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

         public Criteria andCtimeEqualTo(java.lang.Long value) {
            addCriterion("ctime =", value, "ctime", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(java.lang.Long value) {
            addCriterion("ctime <>", value, "ctime", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(java.lang.Long value) {
            addCriterion("ctime >", value, "ctime", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(java.lang.Long value) {
            addCriterion("ctime >=", value, "ctime", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(java.lang.Long value) {
            addCriterion("ctime <", value, "ctime", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(java.lang.Long value) {
            addCriterion("ctime <=", value, "ctime", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("ctime between", value1, value2, "ctime", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("ctime not between", value1, value2, "ctime", "java.lang.Long", "Float");
            return (Criteria) this;
        }
        
        public Criteria andCtimeIn(List<Integer> values) {
            addCriterion("ctime in", values, "ctime", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<java.lang.Long> values) {
            addCriterion("ctime not in", values, "ctime", "java.lang.Long", "Float");
            return (Criteria) this;
        }
        public Criteria andOrdersIsNull() {
            addCriterion("orders is null");
            return (Criteria) this;
        }

        public Criteria andOrdersIsNotNull() {
            addCriterion("orders is not null");
            return (Criteria) this;
        }

         public Criteria andOrdersEqualTo(java.lang.Long value) {
            addCriterion("orders =", value, "orders", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrdersNotEqualTo(java.lang.Long value) {
            addCriterion("orders <>", value, "orders", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrdersGreaterThan(java.lang.Long value) {
            addCriterion("orders >", value, "orders", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrdersGreaterThanOrEqualTo(java.lang.Long value) {
            addCriterion("orders >=", value, "orders", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrdersLessThan(java.lang.Long value) {
            addCriterion("orders <", value, "orders", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrdersLessThanOrEqualTo(java.lang.Long value) {
            addCriterion("orders <=", value, "orders", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrdersBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("orders between", value1, value2, "orders", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrdersNotBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("orders not between", value1, value2, "orders", "java.lang.Long", "Float");
            return (Criteria) this;
        }
        
        public Criteria andOrdersIn(List<Integer> values) {
            addCriterion("orders in", values, "orders", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrdersNotIn(List<java.lang.Long> values) {
            addCriterion("orders not in", values, "orders", "java.lang.Long", "Float");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;
        
        private String valueType;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }
        
        public String getValueType() {
        	return valueType;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler, String valueType) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
            this.valueType = valueType;
        }
        
        protected Criterion(String condition, Object value, String typeHandler) {
            this(condition, value, typeHandler, "String");
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler, String valueType) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
            this.valueType = valueType;
        }
        
        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
        	this(condition, value, secondValue, typeHandler, "String");
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}