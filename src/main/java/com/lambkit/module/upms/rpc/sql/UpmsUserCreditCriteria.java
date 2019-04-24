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
package com.lambkit.module.upms.rpc.sql;

import com.lambkit.db.sql.ConditionMode;
import com.lambkit.db.sql.column.Column;
import com.lambkit.db.sql.column.Columns;
import com.lambkit.db.sql.column.Example;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangyong 
 * @website: www.lambkit.com
 * @email: gismail@foxmail.com
 * @date 2019-04-17
 * @version 1.0
 * @since 1.0
 */
public class UpmsUserCreditCriteria extends Columns implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static UpmsUserCreditCriteria create() {
		return new UpmsUserCreditCriteria();
	}
	
	public static UpmsUserCreditCriteria create(Column column) {
		UpmsUserCreditCriteria that = new UpmsUserCreditCriteria();
		that.add(column);
        return that;
    }

    public static UpmsUserCreditCriteria create(String name, Object value) {
        return (UpmsUserCreditCriteria) create().eq(name, value);
    }
    
    public Example example() {
    	return Example.create("upms_user_credit", this);
    }
    
    /**
     * equals
     *
     * @param name
     * @param value
     * @return
     */
    public UpmsUserCreditCriteria eq(String name, Object value) {
    	super.eq(name, value);
        return this;
    }

    /**
     * not equals !=
     *
     * @param name
     * @param value
     * @return
     */
    public UpmsUserCreditCriteria ne(String name, Object value) {
    	super.ne(name, value);
        return this;
    }


    /**
     * like
     *
     * @param name
     * @param value
     * @return
     */

    public UpmsUserCreditCriteria like(String name, Object value) {
    	super.like(name, value);
        return this;
    }
    
    public UpmsUserCreditCriteria notLike(String name, Object value) {
    	super.notLike(name, value);
        return this;
    }

    /**
     * 大于 great than
     *
     * @param name
     * @param value
     * @return
     */
    public UpmsUserCreditCriteria gt(String name, Object value) {
    	super.gt(name, value);
        return this;
    }

    /**
     * 大于等于 great or equal
     *
     * @param name
     * @param value
     * @return
     */
    public UpmsUserCreditCriteria ge(String name, Object value) {
    	super.ge(name, value);
        return this;
    }

    /**
     * 小于 less than
     *
     * @param name
     * @param value
     * @return
     */
    public UpmsUserCreditCriteria lt(String name, Object value) {
    	super.lt(name, value);
        return this;
    }

    /**
     * 小于等于 less or equal
     *
     * @param name
     * @param value
     * @return
     */
    public UpmsUserCreditCriteria le(String name, Object value) {
    	super.le(name, value);
        return this;
    }
    
    public UpmsUserCreditCriteria isnull(String name) {
    	super.isnull(name);
        return this;
    } 

    public UpmsUserCreditCriteria notNull(String name) {
    	super.notNull(name);
        return this;
    } 
    
    public UpmsUserCreditCriteria empty(String name) {
    	super.empty(name);
        return this;
    } 
    
    public UpmsUserCreditCriteria notEmpty(String name) {
    	super.notEmpty(name);
        return this;
    } 
    
    public UpmsUserCreditCriteria add(Column column) {
    	super.add(column);
    	return this;
    }
    
    /**************************/
	
	public void addCriterion(String name, Object value, ConditionMode logic, String property, String typeHandler, String valueType) {
		 if (value == null) {
			 throw new RuntimeException("Value for " + property + " cannot be null");
		 }
		 add(Column.create(name, value, logic, typeHandler, valueType));
	}
   
	public void addCriterion(String name, Object value1, Object value2, ConditionMode logic, String property, String typeHandler, String valueType) {
		 if (value1 == null || value2 == null) {
			 throw new RuntimeException("Between values for " + property + " cannot be null");
		 }
		 add(Column.create(name, value1, value2, logic, typeHandler, valueType));
	}
		 
	public UpmsUserCreditCriteria andUserIdIsNull() {
		isnull("user_id");
		return this;
	}
	
	public UpmsUserCreditCriteria andUserIdIsNotNull() {
		notNull("user_id");
		return this;
	}
	
	public UpmsUserCreditCriteria andUserIdIsEmpty() {
		empty("user_id");
		return this;
	}

	public UpmsUserCreditCriteria andUserIdIsNotEmpty() {
		notEmpty("user_id");
		return this;
	}
       public UpmsUserCreditCriteria andUserIdEqualTo(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.EQUAL, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andUserIdNotEqualTo(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.NOT_EQUAL, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andUserIdGreaterThan(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.GREATER_THEN, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andUserIdGreaterThanOrEqualTo(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.GREATER_EQUAL, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andUserIdLessThan(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.LESS_THEN, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andUserIdLessThanOrEqualTo(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.LESS_EQUAL, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andUserIdBetween(java.lang.Long value1, java.lang.Long value2) {
    	  addCriterion("user_id", value1, value2, ConditionMode.BETWEEN, "userId", "java.lang.Long", "Float");
    	  return this;
      }

      public UpmsUserCreditCriteria andUserIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
          addCriterion("user_id", value1, value2, ConditionMode.NOT_BETWEEN, "userId", "java.lang.Long", "Float");
          return this;
      }
        
      public UpmsUserCreditCriteria andUserIdIn(List<java.lang.Long> values) {
          addCriterion("user_id", values, ConditionMode.IN, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andUserIdNotIn(List<java.lang.Long> values) {
          addCriterion("user_id", values, ConditionMode.NOT_IN, "userId", "java.lang.Long", "Float");
          return this;
      }
	public UpmsUserCreditCriteria andCreditIsNull() {
		isnull("credit");
		return this;
	}
	
	public UpmsUserCreditCriteria andCreditIsNotNull() {
		notNull("credit");
		return this;
	}
	
	public UpmsUserCreditCriteria andCreditIsEmpty() {
		empty("credit");
		return this;
	}

	public UpmsUserCreditCriteria andCreditIsNotEmpty() {
		notEmpty("credit");
		return this;
	}
       public UpmsUserCreditCriteria andCreditEqualTo(java.lang.Integer value) {
          addCriterion("credit", value, ConditionMode.EQUAL, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andCreditNotEqualTo(java.lang.Integer value) {
          addCriterion("credit", value, ConditionMode.NOT_EQUAL, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andCreditGreaterThan(java.lang.Integer value) {
          addCriterion("credit", value, ConditionMode.GREATER_THEN, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andCreditGreaterThanOrEqualTo(java.lang.Integer value) {
          addCriterion("credit", value, ConditionMode.GREATER_EQUAL, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andCreditLessThan(java.lang.Integer value) {
          addCriterion("credit", value, ConditionMode.LESS_THEN, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andCreditLessThanOrEqualTo(java.lang.Integer value) {
          addCriterion("credit", value, ConditionMode.LESS_EQUAL, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andCreditBetween(java.lang.Integer value1, java.lang.Integer value2) {
    	  addCriterion("credit", value1, value2, ConditionMode.BETWEEN, "credit", "java.lang.Integer", "Float");
    	  return this;
      }

      public UpmsUserCreditCriteria andCreditNotBetween(java.lang.Integer value1, java.lang.Integer value2) {
          addCriterion("credit", value1, value2, ConditionMode.NOT_BETWEEN, "credit", "java.lang.Integer", "Float");
          return this;
      }
        
      public UpmsUserCreditCriteria andCreditIn(List<java.lang.Integer> values) {
          addCriterion("credit", values, ConditionMode.IN, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsUserCreditCriteria andCreditNotIn(List<java.lang.Integer> values) {
          addCriterion("credit", values, ConditionMode.NOT_IN, "credit", "java.lang.Integer", "Float");
          return this;
      }
}