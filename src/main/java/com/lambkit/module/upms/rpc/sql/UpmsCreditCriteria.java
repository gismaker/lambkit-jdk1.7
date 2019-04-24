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
public class UpmsCreditCriteria extends Columns implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static UpmsCreditCriteria create() {
		return new UpmsCreditCriteria();
	}
	
	public static UpmsCreditCriteria create(Column column) {
		UpmsCreditCriteria that = new UpmsCreditCriteria();
		that.add(column);
        return that;
    }

    public static UpmsCreditCriteria create(String name, Object value) {
        return (UpmsCreditCriteria) create().eq(name, value);
    }
    
    public Example example() {
    	return Example.create("upms_credit", this);
    }
    
    /**
     * equals
     *
     * @param name
     * @param value
     * @return
     */
    public UpmsCreditCriteria eq(String name, Object value) {
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
    public UpmsCreditCriteria ne(String name, Object value) {
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

    public UpmsCreditCriteria like(String name, Object value) {
    	super.like(name, value);
        return this;
    }
    
    public UpmsCreditCriteria notLike(String name, Object value) {
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
    public UpmsCreditCriteria gt(String name, Object value) {
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
    public UpmsCreditCriteria ge(String name, Object value) {
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
    public UpmsCreditCriteria lt(String name, Object value) {
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
    public UpmsCreditCriteria le(String name, Object value) {
    	super.le(name, value);
        return this;
    }
    
    public UpmsCreditCriteria isnull(String name) {
    	super.isnull(name);
        return this;
    } 

    public UpmsCreditCriteria notNull(String name) {
    	super.notNull(name);
        return this;
    } 
    
    public UpmsCreditCriteria empty(String name) {
    	super.empty(name);
        return this;
    } 
    
    public UpmsCreditCriteria notEmpty(String name) {
    	super.notEmpty(name);
        return this;
    } 
    
    public UpmsCreditCriteria add(Column column) {
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
		 
	public UpmsCreditCriteria andIdIsNull() {
		isnull("id");
		return this;
	}
	
	public UpmsCreditCriteria andIdIsNotNull() {
		notNull("id");
		return this;
	}
	
	public UpmsCreditCriteria andIdIsEmpty() {
		empty("id");
		return this;
	}

	public UpmsCreditCriteria andIdIsNotEmpty() {
		notEmpty("id");
		return this;
	}
       public UpmsCreditCriteria andIdEqualTo(java.lang.Long value) {
          addCriterion("id", value, ConditionMode.EQUAL, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andIdNotEqualTo(java.lang.Long value) {
          addCriterion("id", value, ConditionMode.NOT_EQUAL, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andIdGreaterThan(java.lang.Long value) {
          addCriterion("id", value, ConditionMode.GREATER_THEN, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andIdGreaterThanOrEqualTo(java.lang.Long value) {
          addCriterion("id", value, ConditionMode.GREATER_EQUAL, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andIdLessThan(java.lang.Long value) {
          addCriterion("id", value, ConditionMode.LESS_THEN, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andIdLessThanOrEqualTo(java.lang.Long value) {
          addCriterion("id", value, ConditionMode.LESS_EQUAL, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andIdBetween(java.lang.Long value1, java.lang.Long value2) {
    	  addCriterion("id", value1, value2, ConditionMode.BETWEEN, "id", "java.lang.Long", "Float");
    	  return this;
      }

      public UpmsCreditCriteria andIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
          addCriterion("id", value1, value2, ConditionMode.NOT_BETWEEN, "id", "java.lang.Long", "Float");
          return this;
      }
        
      public UpmsCreditCriteria andIdIn(List<java.lang.Long> values) {
          addCriterion("id", values, ConditionMode.IN, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andIdNotIn(List<java.lang.Long> values) {
          addCriterion("id", values, ConditionMode.NOT_IN, "id", "java.lang.Long", "Float");
          return this;
      }
	public UpmsCreditCriteria andUserIdIsNull() {
		isnull("user_id");
		return this;
	}
	
	public UpmsCreditCriteria andUserIdIsNotNull() {
		notNull("user_id");
		return this;
	}
	
	public UpmsCreditCriteria andUserIdIsEmpty() {
		empty("user_id");
		return this;
	}

	public UpmsCreditCriteria andUserIdIsNotEmpty() {
		notEmpty("user_id");
		return this;
	}
       public UpmsCreditCriteria andUserIdEqualTo(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.EQUAL, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andUserIdNotEqualTo(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.NOT_EQUAL, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andUserIdGreaterThan(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.GREATER_THEN, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andUserIdGreaterThanOrEqualTo(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.GREATER_EQUAL, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andUserIdLessThan(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.LESS_THEN, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andUserIdLessThanOrEqualTo(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.LESS_EQUAL, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andUserIdBetween(java.lang.Long value1, java.lang.Long value2) {
    	  addCriterion("user_id", value1, value2, ConditionMode.BETWEEN, "userId", "java.lang.Long", "Float");
    	  return this;
      }

      public UpmsCreditCriteria andUserIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
          addCriterion("user_id", value1, value2, ConditionMode.NOT_BETWEEN, "userId", "java.lang.Long", "Float");
          return this;
      }
        
      public UpmsCreditCriteria andUserIdIn(List<java.lang.Long> values) {
          addCriterion("user_id", values, ConditionMode.IN, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsCreditCriteria andUserIdNotIn(List<java.lang.Long> values) {
          addCriterion("user_id", values, ConditionMode.NOT_IN, "userId", "java.lang.Long", "Float");
          return this;
      }
	public UpmsCreditCriteria andCreditIsNull() {
		isnull("credit");
		return this;
	}
	
	public UpmsCreditCriteria andCreditIsNotNull() {
		notNull("credit");
		return this;
	}
	
	public UpmsCreditCriteria andCreditIsEmpty() {
		empty("credit");
		return this;
	}

	public UpmsCreditCriteria andCreditIsNotEmpty() {
		notEmpty("credit");
		return this;
	}
       public UpmsCreditCriteria andCreditEqualTo(java.lang.Integer value) {
          addCriterion("credit", value, ConditionMode.EQUAL, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsCreditCriteria andCreditNotEqualTo(java.lang.Integer value) {
          addCriterion("credit", value, ConditionMode.NOT_EQUAL, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsCreditCriteria andCreditGreaterThan(java.lang.Integer value) {
          addCriterion("credit", value, ConditionMode.GREATER_THEN, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsCreditCriteria andCreditGreaterThanOrEqualTo(java.lang.Integer value) {
          addCriterion("credit", value, ConditionMode.GREATER_EQUAL, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsCreditCriteria andCreditLessThan(java.lang.Integer value) {
          addCriterion("credit", value, ConditionMode.LESS_THEN, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsCreditCriteria andCreditLessThanOrEqualTo(java.lang.Integer value) {
          addCriterion("credit", value, ConditionMode.LESS_EQUAL, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsCreditCriteria andCreditBetween(java.lang.Integer value1, java.lang.Integer value2) {
    	  addCriterion("credit", value1, value2, ConditionMode.BETWEEN, "credit", "java.lang.Integer", "Float");
    	  return this;
      }

      public UpmsCreditCriteria andCreditNotBetween(java.lang.Integer value1, java.lang.Integer value2) {
          addCriterion("credit", value1, value2, ConditionMode.NOT_BETWEEN, "credit", "java.lang.Integer", "Float");
          return this;
      }
        
      public UpmsCreditCriteria andCreditIn(List<java.lang.Integer> values) {
          addCriterion("credit", values, ConditionMode.IN, "credit", "java.lang.Integer", "Float");
          return this;
      }

      public UpmsCreditCriteria andCreditNotIn(List<java.lang.Integer> values) {
          addCriterion("credit", values, ConditionMode.NOT_IN, "credit", "java.lang.Integer", "Float");
          return this;
      }
	public UpmsCreditCriteria andCtypeIsNull() {
		isnull("ctype");
		return this;
	}
	
	public UpmsCreditCriteria andCtypeIsNotNull() {
		notNull("ctype");
		return this;
	}
	
	public UpmsCreditCriteria andCtypeIsEmpty() {
		empty("ctype");
		return this;
	}

	public UpmsCreditCriteria andCtypeIsNotEmpty() {
		notEmpty("ctype");
		return this;
	}
        public UpmsCreditCriteria andCtypeLike(java.lang.String value) {
    	   addCriterion("ctype", value, ConditionMode.FUZZY, "ctype", "java.lang.String", "Float");
    	   return this;
      }

      public UpmsCreditCriteria andCtypeNotLike(java.lang.String value) {
          addCriterion("ctype", value, ConditionMode.NOT_FUZZY, "ctype", "java.lang.String", "Float");
          return this;
      }
      public UpmsCreditCriteria andCtypeEqualTo(java.lang.String value) {
          addCriterion("ctype", value, ConditionMode.EQUAL, "ctype", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andCtypeNotEqualTo(java.lang.String value) {
          addCriterion("ctype", value, ConditionMode.NOT_EQUAL, "ctype", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andCtypeGreaterThan(java.lang.String value) {
          addCriterion("ctype", value, ConditionMode.GREATER_THEN, "ctype", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andCtypeGreaterThanOrEqualTo(java.lang.String value) {
          addCriterion("ctype", value, ConditionMode.GREATER_EQUAL, "ctype", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andCtypeLessThan(java.lang.String value) {
          addCriterion("ctype", value, ConditionMode.LESS_THEN, "ctype", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andCtypeLessThanOrEqualTo(java.lang.String value) {
          addCriterion("ctype", value, ConditionMode.LESS_EQUAL, "ctype", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andCtypeBetween(java.lang.String value1, java.lang.String value2) {
    	  addCriterion("ctype", value1, value2, ConditionMode.BETWEEN, "ctype", "java.lang.String", "String");
    	  return this;
      }

      public UpmsCreditCriteria andCtypeNotBetween(java.lang.String value1, java.lang.String value2) {
          addCriterion("ctype", value1, value2, ConditionMode.NOT_BETWEEN, "ctype", "java.lang.String", "String");
          return this;
      }
        
      public UpmsCreditCriteria andCtypeIn(List<java.lang.String> values) {
          addCriterion("ctype", values, ConditionMode.IN, "ctype", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andCtypeNotIn(List<java.lang.String> values) {
          addCriterion("ctype", values, ConditionMode.NOT_IN, "ctype", "java.lang.String", "String");
          return this;
      }
	public UpmsCreditCriteria andCtimeIsNull() {
		isnull("ctime");
		return this;
	}
	
	public UpmsCreditCriteria andCtimeIsNotNull() {
		notNull("ctime");
		return this;
	}
	
	public UpmsCreditCriteria andCtimeIsEmpty() {
		empty("ctime");
		return this;
	}

	public UpmsCreditCriteria andCtimeIsNotEmpty() {
		notEmpty("ctime");
		return this;
	}
       public UpmsCreditCriteria andCtimeEqualTo(java.util.Date value) {
          addCriterion("ctime", value, ConditionMode.EQUAL, "ctime", "java.util.Date", "String");
          return this;
      }

      public UpmsCreditCriteria andCtimeNotEqualTo(java.util.Date value) {
          addCriterion("ctime", value, ConditionMode.NOT_EQUAL, "ctime", "java.util.Date", "String");
          return this;
      }

      public UpmsCreditCriteria andCtimeGreaterThan(java.util.Date value) {
          addCriterion("ctime", value, ConditionMode.GREATER_THEN, "ctime", "java.util.Date", "String");
          return this;
      }

      public UpmsCreditCriteria andCtimeGreaterThanOrEqualTo(java.util.Date value) {
          addCriterion("ctime", value, ConditionMode.GREATER_EQUAL, "ctime", "java.util.Date", "String");
          return this;
      }

      public UpmsCreditCriteria andCtimeLessThan(java.util.Date value) {
          addCriterion("ctime", value, ConditionMode.LESS_THEN, "ctime", "java.util.Date", "String");
          return this;
      }

      public UpmsCreditCriteria andCtimeLessThanOrEqualTo(java.util.Date value) {
          addCriterion("ctime", value, ConditionMode.LESS_EQUAL, "ctime", "java.util.Date", "String");
          return this;
      }

      public UpmsCreditCriteria andCtimeBetween(java.util.Date value1, java.util.Date value2) {
    	  addCriterion("ctime", value1, value2, ConditionMode.BETWEEN, "ctime", "java.util.Date", "String");
    	  return this;
      }

      public UpmsCreditCriteria andCtimeNotBetween(java.util.Date value1, java.util.Date value2) {
          addCriterion("ctime", value1, value2, ConditionMode.NOT_BETWEEN, "ctime", "java.util.Date", "String");
          return this;
      }
        
      public UpmsCreditCriteria andCtimeIn(List<java.util.Date> values) {
          addCriterion("ctime", values, ConditionMode.IN, "ctime", "java.util.Date", "String");
          return this;
      }

      public UpmsCreditCriteria andCtimeNotIn(List<java.util.Date> values) {
          addCriterion("ctime", values, ConditionMode.NOT_IN, "ctime", "java.util.Date", "String");
          return this;
      }
	public UpmsCreditCriteria andActionIsNull() {
		isnull("action");
		return this;
	}
	
	public UpmsCreditCriteria andActionIsNotNull() {
		notNull("action");
		return this;
	}
	
	public UpmsCreditCriteria andActionIsEmpty() {
		empty("action");
		return this;
	}

	public UpmsCreditCriteria andActionIsNotEmpty() {
		notEmpty("action");
		return this;
	}
        public UpmsCreditCriteria andActionLike(java.lang.String value) {
    	   addCriterion("action", value, ConditionMode.FUZZY, "action", "java.lang.String", "String");
    	   return this;
      }

      public UpmsCreditCriteria andActionNotLike(java.lang.String value) {
          addCriterion("action", value, ConditionMode.NOT_FUZZY, "action", "java.lang.String", "String");
          return this;
      }
      public UpmsCreditCriteria andActionEqualTo(java.lang.String value) {
          addCriterion("action", value, ConditionMode.EQUAL, "action", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andActionNotEqualTo(java.lang.String value) {
          addCriterion("action", value, ConditionMode.NOT_EQUAL, "action", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andActionGreaterThan(java.lang.String value) {
          addCriterion("action", value, ConditionMode.GREATER_THEN, "action", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andActionGreaterThanOrEqualTo(java.lang.String value) {
          addCriterion("action", value, ConditionMode.GREATER_EQUAL, "action", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andActionLessThan(java.lang.String value) {
          addCriterion("action", value, ConditionMode.LESS_THEN, "action", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andActionLessThanOrEqualTo(java.lang.String value) {
          addCriterion("action", value, ConditionMode.LESS_EQUAL, "action", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andActionBetween(java.lang.String value1, java.lang.String value2) {
    	  addCriterion("action", value1, value2, ConditionMode.BETWEEN, "action", "java.lang.String", "String");
    	  return this;
      }

      public UpmsCreditCriteria andActionNotBetween(java.lang.String value1, java.lang.String value2) {
          addCriterion("action", value1, value2, ConditionMode.NOT_BETWEEN, "action", "java.lang.String", "String");
          return this;
      }
        
      public UpmsCreditCriteria andActionIn(List<java.lang.String> values) {
          addCriterion("action", values, ConditionMode.IN, "action", "java.lang.String", "String");
          return this;
      }

      public UpmsCreditCriteria andActionNotIn(List<java.lang.String> values) {
          addCriterion("action", values, ConditionMode.NOT_IN, "action", "java.lang.String", "String");
          return this;
      }
}