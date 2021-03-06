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
import com.lambkit.module.upms.rpc.query.UpmsOrganizationQuery;

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
public class UpmsOrganizationExample implements IQuery, Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public UpmsOrganizationExample() {
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
    	s.append(UpmsOrganizationQuery.me().getTableName());
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

        public Criteria andOrganizationIdIsNull() {
            addCriterion("organization_id is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdIsNotNull() {
            addCriterion("organization_id is not null");
            return (Criteria) this;
        }

         public Criteria andOrganizationIdEqualTo(java.lang.Long value) {
            addCriterion("organization_id =", value, "organizationId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdNotEqualTo(java.lang.Long value) {
            addCriterion("organization_id <>", value, "organizationId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdGreaterThan(java.lang.Long value) {
            addCriterion("organization_id >", value, "organizationId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdGreaterThanOrEqualTo(java.lang.Long value) {
            addCriterion("organization_id >=", value, "organizationId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdLessThan(java.lang.Long value) {
            addCriterion("organization_id <", value, "organizationId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdLessThanOrEqualTo(java.lang.Long value) {
            addCriterion("organization_id <=", value, "organizationId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("organization_id between", value1, value2, "organizationId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("organization_id not between", value1, value2, "organizationId", "java.lang.Long", "Float");
            return (Criteria) this;
        }
        
        public Criteria andOrganizationIdIn(List<Integer> values) {
            addCriterion("organization_id in", values, "organizationId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdNotIn(List<java.lang.Long> values) {
            addCriterion("organization_id not in", values, "organizationId", "java.lang.Long", "Float");
            return (Criteria) this;
        }
        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

         public Criteria andPidEqualTo(java.lang.Integer value) {
            addCriterion("pid =", value, "pid", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(java.lang.Integer value) {
            addCriterion("pid <>", value, "pid", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(java.lang.Integer value) {
            addCriterion("pid >", value, "pid", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(java.lang.Integer value) {
            addCriterion("pid >=", value, "pid", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(java.lang.Integer value) {
            addCriterion("pid <", value, "pid", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(java.lang.Integer value) {
            addCriterion("pid <=", value, "pid", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andPidBetween(java.lang.Integer value1, java.lang.Integer value2) {
            addCriterion("pid between", value1, value2, "pid", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(java.lang.Integer value1, java.lang.Integer value2) {
            addCriterion("pid not between", value1, value2, "pid", "java.lang.Integer", "Float");
            return (Criteria) this;
        }
        
        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<java.lang.Integer> values) {
            addCriterion("pid not in", values, "pid", "java.lang.Integer", "Float");
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