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
import com.lambkit.module.upms.rpc.query.UpmsUserPermissionQuery;

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
public class UpmsUserPermissionExample implements IQuery, Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public UpmsUserPermissionExample() {
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
    	s.append(UpmsUserPermissionQuery.me().getTableName());
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

        public Criteria andUserPermissionIdIsNull() {
            addCriterion("user_permission_id is null");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdIsNotNull() {
            addCriterion("user_permission_id is not null");
            return (Criteria) this;
        }

         public Criteria andUserPermissionIdEqualTo(java.lang.Long value) {
            addCriterion("user_permission_id =", value, "userPermissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdNotEqualTo(java.lang.Long value) {
            addCriterion("user_permission_id <>", value, "userPermissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdGreaterThan(java.lang.Long value) {
            addCriterion("user_permission_id >", value, "userPermissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdGreaterThanOrEqualTo(java.lang.Long value) {
            addCriterion("user_permission_id >=", value, "userPermissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdLessThan(java.lang.Long value) {
            addCriterion("user_permission_id <", value, "userPermissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdLessThanOrEqualTo(java.lang.Long value) {
            addCriterion("user_permission_id <=", value, "userPermissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("user_permission_id between", value1, value2, "userPermissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("user_permission_id not between", value1, value2, "userPermissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }
        
        public Criteria andUserPermissionIdIn(List<Integer> values) {
            addCriterion("user_permission_id in", values, "userPermissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdNotIn(List<java.lang.Long> values) {
            addCriterion("user_permission_id not in", values, "userPermissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }
        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

         public Criteria andUserIdEqualTo(java.lang.Long value) {
            addCriterion("user_id =", value, "userId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(java.lang.Long value) {
            addCriterion("user_id <>", value, "userId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(java.lang.Long value) {
            addCriterion("user_id >", value, "userId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(java.lang.Long value) {
            addCriterion("user_id >=", value, "userId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(java.lang.Long value) {
            addCriterion("user_id <", value, "userId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(java.lang.Long value) {
            addCriterion("user_id <=", value, "userId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("user_id between", value1, value2, "userId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("user_id not between", value1, value2, "userId", "java.lang.Long", "Float");
            return (Criteria) this;
        }
        
        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<java.lang.Long> values) {
            addCriterion("user_id not in", values, "userId", "java.lang.Long", "Float");
            return (Criteria) this;
        }
        public Criteria andPermissionIdIsNull() {
            addCriterion("permission_id is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNotNull() {
            addCriterion("permission_id is not null");
            return (Criteria) this;
        }

         public Criteria andPermissionIdEqualTo(java.lang.Long value) {
            addCriterion("permission_id =", value, "permissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotEqualTo(java.lang.Long value) {
            addCriterion("permission_id <>", value, "permissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThan(java.lang.Long value) {
            addCriterion("permission_id >", value, "permissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThanOrEqualTo(java.lang.Long value) {
            addCriterion("permission_id >=", value, "permissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThan(java.lang.Long value) {
            addCriterion("permission_id <", value, "permissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThanOrEqualTo(java.lang.Long value) {
            addCriterion("permission_id <=", value, "permissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andPermissionIdBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("permission_id between", value1, value2, "permissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
            addCriterion("permission_id not between", value1, value2, "permissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }
        
        public Criteria andPermissionIdIn(List<Integer> values) {
            addCriterion("permission_id in", values, "permissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotIn(List<java.lang.Long> values) {
            addCriterion("permission_id not in", values, "permissionId", "java.lang.Long", "Float");
            return (Criteria) this;
        }
        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

         public Criteria andTypeEqualTo(java.lang.Integer value) {
            addCriterion("type =", value, "type", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(java.lang.Integer value) {
            addCriterion("type <>", value, "type", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(java.lang.Integer value) {
            addCriterion("type >", value, "type", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(java.lang.Integer value) {
            addCriterion("type >=", value, "type", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(java.lang.Integer value) {
            addCriterion("type <", value, "type", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(java.lang.Integer value) {
            addCriterion("type <=", value, "type", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(java.lang.Integer value1, java.lang.Integer value2) {
            addCriterion("type between", value1, value2, "type", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(java.lang.Integer value1, java.lang.Integer value2) {
            addCriterion("type not between", value1, value2, "type", "java.lang.Integer", "Float");
            return (Criteria) this;
        }
        
        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type", "java.lang.Integer", "Float");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<java.lang.Integer> values) {
            addCriterion("type not in", values, "type", "java.lang.Integer", "Float");
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