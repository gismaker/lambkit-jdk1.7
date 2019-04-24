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
public class UpmsSignCriteria extends Columns implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static UpmsSignCriteria create() {
		return new UpmsSignCriteria();
	}
	
	public static UpmsSignCriteria create(Column column) {
		UpmsSignCriteria that = new UpmsSignCriteria();
		that.add(column);
        return that;
    }

    public static UpmsSignCriteria create(String name, Object value) {
        return (UpmsSignCriteria) create().eq(name, value);
    }
    
    public Example example() {
    	return Example.create("upms_sign", this);
    }
    
    /**
     * equals
     *
     * @param name
     * @param value
     * @return
     */
    public UpmsSignCriteria eq(String name, Object value) {
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
    public UpmsSignCriteria ne(String name, Object value) {
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

    public UpmsSignCriteria like(String name, Object value) {
    	super.like(name, value);
        return this;
    }
    
    public UpmsSignCriteria notLike(String name, Object value) {
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
    public UpmsSignCriteria gt(String name, Object value) {
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
    public UpmsSignCriteria ge(String name, Object value) {
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
    public UpmsSignCriteria lt(String name, Object value) {
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
    public UpmsSignCriteria le(String name, Object value) {
    	super.le(name, value);
        return this;
    }
    
    public UpmsSignCriteria isnull(String name) {
    	super.isnull(name);
        return this;
    } 

    public UpmsSignCriteria notNull(String name) {
    	super.notNull(name);
        return this;
    } 
    
    public UpmsSignCriteria empty(String name) {
    	super.empty(name);
        return this;
    } 
    
    public UpmsSignCriteria notEmpty(String name) {
    	super.notEmpty(name);
        return this;
    } 
    
    public UpmsSignCriteria add(Column column) {
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
		 
	public UpmsSignCriteria andIdIsNull() {
		isnull("id");
		return this;
	}
	
	public UpmsSignCriteria andIdIsNotNull() {
		notNull("id");
		return this;
	}
	
	public UpmsSignCriteria andIdIsEmpty() {
		empty("id");
		return this;
	}

	public UpmsSignCriteria andIdIsNotEmpty() {
		notEmpty("id");
		return this;
	}
       public UpmsSignCriteria andIdEqualTo(java.lang.Long value) {
          addCriterion("id", value, ConditionMode.EQUAL, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andIdNotEqualTo(java.lang.Long value) {
          addCriterion("id", value, ConditionMode.NOT_EQUAL, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andIdGreaterThan(java.lang.Long value) {
          addCriterion("id", value, ConditionMode.GREATER_THEN, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andIdGreaterThanOrEqualTo(java.lang.Long value) {
          addCriterion("id", value, ConditionMode.GREATER_EQUAL, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andIdLessThan(java.lang.Long value) {
          addCriterion("id", value, ConditionMode.LESS_THEN, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andIdLessThanOrEqualTo(java.lang.Long value) {
          addCriterion("id", value, ConditionMode.LESS_EQUAL, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andIdBetween(java.lang.Long value1, java.lang.Long value2) {
    	  addCriterion("id", value1, value2, ConditionMode.BETWEEN, "id", "java.lang.Long", "Float");
    	  return this;
      }

      public UpmsSignCriteria andIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
          addCriterion("id", value1, value2, ConditionMode.NOT_BETWEEN, "id", "java.lang.Long", "Float");
          return this;
      }
        
      public UpmsSignCriteria andIdIn(List<java.lang.Long> values) {
          addCriterion("id", values, ConditionMode.IN, "id", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andIdNotIn(List<java.lang.Long> values) {
          addCriterion("id", values, ConditionMode.NOT_IN, "id", "java.lang.Long", "Float");
          return this;
      }
	public UpmsSignCriteria andUserIdIsNull() {
		isnull("user_id");
		return this;
	}
	
	public UpmsSignCriteria andUserIdIsNotNull() {
		notNull("user_id");
		return this;
	}
	
	public UpmsSignCriteria andUserIdIsEmpty() {
		empty("user_id");
		return this;
	}

	public UpmsSignCriteria andUserIdIsNotEmpty() {
		notEmpty("user_id");
		return this;
	}
       public UpmsSignCriteria andUserIdEqualTo(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.EQUAL, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andUserIdNotEqualTo(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.NOT_EQUAL, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andUserIdGreaterThan(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.GREATER_THEN, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andUserIdGreaterThanOrEqualTo(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.GREATER_EQUAL, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andUserIdLessThan(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.LESS_THEN, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andUserIdLessThanOrEqualTo(java.lang.Long value) {
          addCriterion("user_id", value, ConditionMode.LESS_EQUAL, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andUserIdBetween(java.lang.Long value1, java.lang.Long value2) {
    	  addCriterion("user_id", value1, value2, ConditionMode.BETWEEN, "userId", "java.lang.Long", "Float");
    	  return this;
      }

      public UpmsSignCriteria andUserIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
          addCriterion("user_id", value1, value2, ConditionMode.NOT_BETWEEN, "userId", "java.lang.Long", "Float");
          return this;
      }
        
      public UpmsSignCriteria andUserIdIn(List<java.lang.Long> values) {
          addCriterion("user_id", values, ConditionMode.IN, "userId", "java.lang.Long", "Float");
          return this;
      }

      public UpmsSignCriteria andUserIdNotIn(List<java.lang.Long> values) {
          addCriterion("user_id", values, ConditionMode.NOT_IN, "userId", "java.lang.Long", "Float");
          return this;
      }
	public UpmsSignCriteria andStimeIsNull() {
		isnull("stime");
		return this;
	}
	
	public UpmsSignCriteria andStimeIsNotNull() {
		notNull("stime");
		return this;
	}
	
	public UpmsSignCriteria andStimeIsEmpty() {
		empty("stime");
		return this;
	}

	public UpmsSignCriteria andStimeIsNotEmpty() {
		notEmpty("stime");
		return this;
	}
       public UpmsSignCriteria andStimeEqualTo(java.util.Date value) {
          addCriterion("stime", value, ConditionMode.EQUAL, "stime", "java.util.Date", "String");
          return this;
      }

      public UpmsSignCriteria andStimeNotEqualTo(java.util.Date value) {
          addCriterion("stime", value, ConditionMode.NOT_EQUAL, "stime", "java.util.Date", "String");
          return this;
      }

      public UpmsSignCriteria andStimeGreaterThan(java.util.Date value) {
          addCriterion("stime", value, ConditionMode.GREATER_THEN, "stime", "java.util.Date", "String");
          return this;
      }

      public UpmsSignCriteria andStimeGreaterThanOrEqualTo(java.util.Date value) {
          addCriterion("stime", value, ConditionMode.GREATER_EQUAL, "stime", "java.util.Date", "String");
          return this;
      }

      public UpmsSignCriteria andStimeLessThan(java.util.Date value) {
          addCriterion("stime", value, ConditionMode.LESS_THEN, "stime", "java.util.Date", "String");
          return this;
      }

      public UpmsSignCriteria andStimeLessThanOrEqualTo(java.util.Date value) {
          addCriterion("stime", value, ConditionMode.LESS_EQUAL, "stime", "java.util.Date", "String");
          return this;
      }

      public UpmsSignCriteria andStimeBetween(java.util.Date value1, java.util.Date value2) {
    	  addCriterion("stime", value1, value2, ConditionMode.BETWEEN, "stime", "java.util.Date", "String");
    	  return this;
      }

      public UpmsSignCriteria andStimeNotBetween(java.util.Date value1, java.util.Date value2) {
          addCriterion("stime", value1, value2, ConditionMode.NOT_BETWEEN, "stime", "java.util.Date", "String");
          return this;
      }
        
      public UpmsSignCriteria andStimeIn(List<java.util.Date> values) {
          addCriterion("stime", values, ConditionMode.IN, "stime", "java.util.Date", "String");
          return this;
      }

      public UpmsSignCriteria andStimeNotIn(List<java.util.Date> values) {
          addCriterion("stime", values, ConditionMode.NOT_IN, "stime", "java.util.Date", "String");
          return this;
      }
	public UpmsSignCriteria andLngIsNull() {
		isnull("lng");
		return this;
	}
	
	public UpmsSignCriteria andLngIsNotNull() {
		notNull("lng");
		return this;
	}
	
	public UpmsSignCriteria andLngIsEmpty() {
		empty("lng");
		return this;
	}

	public UpmsSignCriteria andLngIsNotEmpty() {
		notEmpty("lng");
		return this;
	}
       public UpmsSignCriteria andLngEqualTo(java.lang.Float value) {
          addCriterion("lng", value, ConditionMode.EQUAL, "lng", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLngNotEqualTo(java.lang.Float value) {
          addCriterion("lng", value, ConditionMode.NOT_EQUAL, "lng", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLngGreaterThan(java.lang.Float value) {
          addCriterion("lng", value, ConditionMode.GREATER_THEN, "lng", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLngGreaterThanOrEqualTo(java.lang.Float value) {
          addCriterion("lng", value, ConditionMode.GREATER_EQUAL, "lng", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLngLessThan(java.lang.Float value) {
          addCriterion("lng", value, ConditionMode.LESS_THEN, "lng", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLngLessThanOrEqualTo(java.lang.Float value) {
          addCriterion("lng", value, ConditionMode.LESS_EQUAL, "lng", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLngBetween(java.lang.Float value1, java.lang.Float value2) {
    	  addCriterion("lng", value1, value2, ConditionMode.BETWEEN, "lng", "java.lang.Float", "Float");
    	  return this;
      }

      public UpmsSignCriteria andLngNotBetween(java.lang.Float value1, java.lang.Float value2) {
          addCriterion("lng", value1, value2, ConditionMode.NOT_BETWEEN, "lng", "java.lang.Float", "Float");
          return this;
      }
        
      public UpmsSignCriteria andLngIn(List<java.lang.Float> values) {
          addCriterion("lng", values, ConditionMode.IN, "lng", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLngNotIn(List<java.lang.Float> values) {
          addCriterion("lng", values, ConditionMode.NOT_IN, "lng", "java.lang.Float", "Float");
          return this;
      }
	public UpmsSignCriteria andLatIsNull() {
		isnull("lat");
		return this;
	}
	
	public UpmsSignCriteria andLatIsNotNull() {
		notNull("lat");
		return this;
	}
	
	public UpmsSignCriteria andLatIsEmpty() {
		empty("lat");
		return this;
	}

	public UpmsSignCriteria andLatIsNotEmpty() {
		notEmpty("lat");
		return this;
	}
       public UpmsSignCriteria andLatEqualTo(java.lang.Float value) {
          addCriterion("lat", value, ConditionMode.EQUAL, "lat", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLatNotEqualTo(java.lang.Float value) {
          addCriterion("lat", value, ConditionMode.NOT_EQUAL, "lat", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLatGreaterThan(java.lang.Float value) {
          addCriterion("lat", value, ConditionMode.GREATER_THEN, "lat", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLatGreaterThanOrEqualTo(java.lang.Float value) {
          addCriterion("lat", value, ConditionMode.GREATER_EQUAL, "lat", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLatLessThan(java.lang.Float value) {
          addCriterion("lat", value, ConditionMode.LESS_THEN, "lat", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLatLessThanOrEqualTo(java.lang.Float value) {
          addCriterion("lat", value, ConditionMode.LESS_EQUAL, "lat", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLatBetween(java.lang.Float value1, java.lang.Float value2) {
    	  addCriterion("lat", value1, value2, ConditionMode.BETWEEN, "lat", "java.lang.Float", "Float");
    	  return this;
      }

      public UpmsSignCriteria andLatNotBetween(java.lang.Float value1, java.lang.Float value2) {
          addCriterion("lat", value1, value2, ConditionMode.NOT_BETWEEN, "lat", "java.lang.Float", "Float");
          return this;
      }
        
      public UpmsSignCriteria andLatIn(List<java.lang.Float> values) {
          addCriterion("lat", values, ConditionMode.IN, "lat", "java.lang.Float", "Float");
          return this;
      }

      public UpmsSignCriteria andLatNotIn(List<java.lang.Float> values) {
          addCriterion("lat", values, ConditionMode.NOT_IN, "lat", "java.lang.Float", "Float");
          return this;
      }
	public UpmsSignCriteria andSwayIsNull() {
		isnull("sway");
		return this;
	}
	
	public UpmsSignCriteria andSwayIsNotNull() {
		notNull("sway");
		return this;
	}
	
	public UpmsSignCriteria andSwayIsEmpty() {
		empty("sway");
		return this;
	}

	public UpmsSignCriteria andSwayIsNotEmpty() {
		notEmpty("sway");
		return this;
	}
        public UpmsSignCriteria andSwayLike(java.lang.String value) {
    	   addCriterion("sway", value, ConditionMode.FUZZY, "sway", "java.lang.String", "Float");
    	   return this;
      }

      public UpmsSignCriteria andSwayNotLike(java.lang.String value) {
          addCriterion("sway", value, ConditionMode.NOT_FUZZY, "sway", "java.lang.String", "Float");
          return this;
      }
      public UpmsSignCriteria andSwayEqualTo(java.lang.String value) {
          addCriterion("sway", value, ConditionMode.EQUAL, "sway", "java.lang.String", "String");
          return this;
      }

      public UpmsSignCriteria andSwayNotEqualTo(java.lang.String value) {
          addCriterion("sway", value, ConditionMode.NOT_EQUAL, "sway", "java.lang.String", "String");
          return this;
      }

      public UpmsSignCriteria andSwayGreaterThan(java.lang.String value) {
          addCriterion("sway", value, ConditionMode.GREATER_THEN, "sway", "java.lang.String", "String");
          return this;
      }

      public UpmsSignCriteria andSwayGreaterThanOrEqualTo(java.lang.String value) {
          addCriterion("sway", value, ConditionMode.GREATER_EQUAL, "sway", "java.lang.String", "String");
          return this;
      }

      public UpmsSignCriteria andSwayLessThan(java.lang.String value) {
          addCriterion("sway", value, ConditionMode.LESS_THEN, "sway", "java.lang.String", "String");
          return this;
      }

      public UpmsSignCriteria andSwayLessThanOrEqualTo(java.lang.String value) {
          addCriterion("sway", value, ConditionMode.LESS_EQUAL, "sway", "java.lang.String", "String");
          return this;
      }

      public UpmsSignCriteria andSwayBetween(java.lang.String value1, java.lang.String value2) {
    	  addCriterion("sway", value1, value2, ConditionMode.BETWEEN, "sway", "java.lang.String", "String");
    	  return this;
      }

      public UpmsSignCriteria andSwayNotBetween(java.lang.String value1, java.lang.String value2) {
          addCriterion("sway", value1, value2, ConditionMode.NOT_BETWEEN, "sway", "java.lang.String", "String");
          return this;
      }
        
      public UpmsSignCriteria andSwayIn(List<java.lang.String> values) {
          addCriterion("sway", values, ConditionMode.IN, "sway", "java.lang.String", "String");
          return this;
      }

      public UpmsSignCriteria andSwayNotIn(List<java.lang.String> values) {
          addCriterion("sway", values, ConditionMode.NOT_IN, "sway", "java.lang.String", "String");
          return this;
      }
}