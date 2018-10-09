package com.itlaiba.itlaibashare.resource.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourcesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourcesExample() {
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

    protected abstract static class GeneratedCriteria {
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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andResourceIdIsNull() {
            addCriterion("resource_id is null");
            return (Criteria) this;
        }

        public Criteria andResourceIdIsNotNull() {
            addCriterion("resource_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIdEqualTo(String value) {
            addCriterion("resource_id =", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotEqualTo(String value) {
            addCriterion("resource_id <>", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThan(String value) {
            addCriterion("resource_id >", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("resource_id >=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThan(String value) {
            addCriterion("resource_id <", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThanOrEqualTo(String value) {
            addCriterion("resource_id <=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLike(String value) {
            addCriterion("resource_id like", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotLike(String value) {
            addCriterion("resource_id not like", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdIn(List<String> values) {
            addCriterion("resource_id in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotIn(List<String> values) {
            addCriterion("resource_id not in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdBetween(String value1, String value2) {
            addCriterion("resource_id between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotBetween(String value1, String value2) {
            addCriterion("resource_id not between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNull() {
            addCriterion("resource_name is null");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNotNull() {
            addCriterion("resource_name is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNameEqualTo(String value) {
            addCriterion("resource_name =", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotEqualTo(String value) {
            addCriterion("resource_name <>", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThan(String value) {
            addCriterion("resource_name >", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("resource_name >=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThan(String value) {
            addCriterion("resource_name <", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThanOrEqualTo(String value) {
            addCriterion("resource_name <=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLike(String value) {
            addCriterion("resource_name like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotLike(String value) {
            addCriterion("resource_name not like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameIn(List<String> values) {
            addCriterion("resource_name in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotIn(List<String> values) {
            addCriterion("resource_name not in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameBetween(String value1, String value2) {
            addCriterion("resource_name between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotBetween(String value1, String value2) {
            addCriterion("resource_name not between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceCreateTimeIsNull() {
            addCriterion("resource_create_time is null");
            return (Criteria) this;
        }

        public Criteria andResourceCreateTimeIsNotNull() {
            addCriterion("resource_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andResourceCreateTimeEqualTo(Date value) {
            addCriterion("resource_create_time =", value, "resourceCreateTime");
            return (Criteria) this;
        }

        public Criteria andResourceCreateTimeNotEqualTo(Date value) {
            addCriterion("resource_create_time <>", value, "resourceCreateTime");
            return (Criteria) this;
        }

        public Criteria andResourceCreateTimeGreaterThan(Date value) {
            addCriterion("resource_create_time >", value, "resourceCreateTime");
            return (Criteria) this;
        }

        public Criteria andResourceCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("resource_create_time >=", value, "resourceCreateTime");
            return (Criteria) this;
        }

        public Criteria andResourceCreateTimeLessThan(Date value) {
            addCriterion("resource_create_time <", value, "resourceCreateTime");
            return (Criteria) this;
        }

        public Criteria andResourceCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("resource_create_time <=", value, "resourceCreateTime");
            return (Criteria) this;
        }

        public Criteria andResourceCreateTimeIn(List<Date> values) {
            addCriterion("resource_create_time in", values, "resourceCreateTime");
            return (Criteria) this;
        }

        public Criteria andResourceCreateTimeNotIn(List<Date> values) {
            addCriterion("resource_create_time not in", values, "resourceCreateTime");
            return (Criteria) this;
        }

        public Criteria andResourceCreateTimeBetween(Date value1, Date value2) {
            addCriterion("resource_create_time between", value1, value2, "resourceCreateTime");
            return (Criteria) this;
        }

        public Criteria andResourceCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("resource_create_time not between", value1, value2, "resourceCreateTime");
            return (Criteria) this;
        }

        public Criteria andResourceNumberIsNull() {
            addCriterion("resource_number is null");
            return (Criteria) this;
        }

        public Criteria andResourceNumberIsNotNull() {
            addCriterion("resource_number is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNumberEqualTo(Integer value) {
            addCriterion("resource_number =", value, "resourceNumber");
            return (Criteria) this;
        }

        public Criteria andResourceNumberNotEqualTo(Integer value) {
            addCriterion("resource_number <>", value, "resourceNumber");
            return (Criteria) this;
        }

        public Criteria andResourceNumberGreaterThan(Integer value) {
            addCriterion("resource_number >", value, "resourceNumber");
            return (Criteria) this;
        }

        public Criteria andResourceNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_number >=", value, "resourceNumber");
            return (Criteria) this;
        }

        public Criteria andResourceNumberLessThan(Integer value) {
            addCriterion("resource_number <", value, "resourceNumber");
            return (Criteria) this;
        }

        public Criteria andResourceNumberLessThanOrEqualTo(Integer value) {
            addCriterion("resource_number <=", value, "resourceNumber");
            return (Criteria) this;
        }

        public Criteria andResourceNumberIn(List<Integer> values) {
            addCriterion("resource_number in", values, "resourceNumber");
            return (Criteria) this;
        }

        public Criteria andResourceNumberNotIn(List<Integer> values) {
            addCriterion("resource_number not in", values, "resourceNumber");
            return (Criteria) this;
        }

        public Criteria andResourceNumberBetween(Integer value1, Integer value2) {
            addCriterion("resource_number between", value1, value2, "resourceNumber");
            return (Criteria) this;
        }

        public Criteria andResourceNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_number not between", value1, value2, "resourceNumber");
            return (Criteria) this;
        }

        public Criteria andOrdeByIsNull() {
            addCriterion("orde_by is null");
            return (Criteria) this;
        }

        public Criteria andOrdeByIsNotNull() {
            addCriterion("orde_by is not null");
            return (Criteria) this;
        }

        public Criteria andOrdeByEqualTo(Integer value) {
            addCriterion("orde_by =", value, "ordeBy");
            return (Criteria) this;
        }

        public Criteria andOrdeByNotEqualTo(Integer value) {
            addCriterion("orde_by <>", value, "ordeBy");
            return (Criteria) this;
        }

        public Criteria andOrdeByGreaterThan(Integer value) {
            addCriterion("orde_by >", value, "ordeBy");
            return (Criteria) this;
        }

        public Criteria andOrdeByGreaterThanOrEqualTo(Integer value) {
            addCriterion("orde_by >=", value, "ordeBy");
            return (Criteria) this;
        }

        public Criteria andOrdeByLessThan(Integer value) {
            addCriterion("orde_by <", value, "ordeBy");
            return (Criteria) this;
        }

        public Criteria andOrdeByLessThanOrEqualTo(Integer value) {
            addCriterion("orde_by <=", value, "ordeBy");
            return (Criteria) this;
        }

        public Criteria andOrdeByIn(List<Integer> values) {
            addCriterion("orde_by in", values, "ordeBy");
            return (Criteria) this;
        }

        public Criteria andOrdeByNotIn(List<Integer> values) {
            addCriterion("orde_by not in", values, "ordeBy");
            return (Criteria) this;
        }

        public Criteria andOrdeByBetween(Integer value1, Integer value2) {
            addCriterion("orde_by between", value1, value2, "ordeBy");
            return (Criteria) this;
        }

        public Criteria andOrdeByNotBetween(Integer value1, Integer value2) {
            addCriterion("orde_by not between", value1, value2, "ordeBy");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

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

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}