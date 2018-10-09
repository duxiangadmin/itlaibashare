package com.itlaiba.itlaibashare.myresource.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyresourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MyresourceExample() {
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

        public Criteria andOrderByIsNull() {
            addCriterion("order_by is null");
            return (Criteria) this;
        }

        public Criteria andOrderByIsNotNull() {
            addCriterion("order_by is not null");
            return (Criteria) this;
        }

        public Criteria andOrderByEqualTo(Integer value) {
            addCriterion("order_by =", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotEqualTo(Integer value) {
            addCriterion("order_by <>", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByGreaterThan(Integer value) {
            addCriterion("order_by >", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_by >=", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByLessThan(Integer value) {
            addCriterion("order_by <", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByLessThanOrEqualTo(Integer value) {
            addCriterion("order_by <=", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByIn(List<Integer> values) {
            addCriterion("order_by in", values, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotIn(List<Integer> values) {
            addCriterion("order_by not in", values, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByBetween(Integer value1, Integer value2) {
            addCriterion("order_by between", value1, value2, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotBetween(Integer value1, Integer value2) {
            addCriterion("order_by not between", value1, value2, "orderBy");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdIsNull() {
            addCriterion("myresource_id is null");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdIsNotNull() {
            addCriterion("myresource_id is not null");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdEqualTo(String value) {
            addCriterion("myresource_id =", value, "myresourceId");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdNotEqualTo(String value) {
            addCriterion("myresource_id <>", value, "myresourceId");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdGreaterThan(String value) {
            addCriterion("myresource_id >", value, "myresourceId");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("myresource_id >=", value, "myresourceId");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdLessThan(String value) {
            addCriterion("myresource_id <", value, "myresourceId");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdLessThanOrEqualTo(String value) {
            addCriterion("myresource_id <=", value, "myresourceId");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdLike(String value) {
            addCriterion("myresource_id like", value, "myresourceId");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdNotLike(String value) {
            addCriterion("myresource_id not like", value, "myresourceId");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdIn(List<String> values) {
            addCriterion("myresource_id in", values, "myresourceId");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdNotIn(List<String> values) {
            addCriterion("myresource_id not in", values, "myresourceId");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdBetween(String value1, String value2) {
            addCriterion("myresource_id between", value1, value2, "myresourceId");
            return (Criteria) this;
        }

        public Criteria andMyresourceIdNotBetween(String value1, String value2) {
            addCriterion("myresource_id not between", value1, value2, "myresourceId");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleIsNull() {
            addCriterion("myresource_title is null");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleIsNotNull() {
            addCriterion("myresource_title is not null");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleEqualTo(String value) {
            addCriterion("myresource_title =", value, "myresourceTitle");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleNotEqualTo(String value) {
            addCriterion("myresource_title <>", value, "myresourceTitle");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleGreaterThan(String value) {
            addCriterion("myresource_title >", value, "myresourceTitle");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("myresource_title >=", value, "myresourceTitle");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleLessThan(String value) {
            addCriterion("myresource_title <", value, "myresourceTitle");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleLessThanOrEqualTo(String value) {
            addCriterion("myresource_title <=", value, "myresourceTitle");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleLike(String value) {
            addCriterion("myresource_title like", value, "myresourceTitle");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleNotLike(String value) {
            addCriterion("myresource_title not like", value, "myresourceTitle");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleIn(List<String> values) {
            addCriterion("myresource_title in", values, "myresourceTitle");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleNotIn(List<String> values) {
            addCriterion("myresource_title not in", values, "myresourceTitle");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleBetween(String value1, String value2) {
            addCriterion("myresource_title between", value1, value2, "myresourceTitle");
            return (Criteria) this;
        }

        public Criteria andMyresourceTitleNotBetween(String value1, String value2) {
            addCriterion("myresource_title not between", value1, value2, "myresourceTitle");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgIsNull() {
            addCriterion("myresource_img is null");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgIsNotNull() {
            addCriterion("myresource_img is not null");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgEqualTo(String value) {
            addCriterion("myresource_img =", value, "myresourceImg");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgNotEqualTo(String value) {
            addCriterion("myresource_img <>", value, "myresourceImg");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgGreaterThan(String value) {
            addCriterion("myresource_img >", value, "myresourceImg");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgGreaterThanOrEqualTo(String value) {
            addCriterion("myresource_img >=", value, "myresourceImg");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgLessThan(String value) {
            addCriterion("myresource_img <", value, "myresourceImg");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgLessThanOrEqualTo(String value) {
            addCriterion("myresource_img <=", value, "myresourceImg");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgLike(String value) {
            addCriterion("myresource_img like", value, "myresourceImg");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgNotLike(String value) {
            addCriterion("myresource_img not like", value, "myresourceImg");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgIn(List<String> values) {
            addCriterion("myresource_img in", values, "myresourceImg");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgNotIn(List<String> values) {
            addCriterion("myresource_img not in", values, "myresourceImg");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgBetween(String value1, String value2) {
            addCriterion("myresource_img between", value1, value2, "myresourceImg");
            return (Criteria) this;
        }

        public Criteria andMyresourceImgNotBetween(String value1, String value2) {
            addCriterion("myresource_img not between", value1, value2, "myresourceImg");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlIsNull() {
            addCriterion("myresource_url is null");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlIsNotNull() {
            addCriterion("myresource_url is not null");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlEqualTo(String value) {
            addCriterion("myresource_url =", value, "myresourceUrl");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlNotEqualTo(String value) {
            addCriterion("myresource_url <>", value, "myresourceUrl");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlGreaterThan(String value) {
            addCriterion("myresource_url >", value, "myresourceUrl");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("myresource_url >=", value, "myresourceUrl");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlLessThan(String value) {
            addCriterion("myresource_url <", value, "myresourceUrl");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlLessThanOrEqualTo(String value) {
            addCriterion("myresource_url <=", value, "myresourceUrl");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlLike(String value) {
            addCriterion("myresource_url like", value, "myresourceUrl");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlNotLike(String value) {
            addCriterion("myresource_url not like", value, "myresourceUrl");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlIn(List<String> values) {
            addCriterion("myresource_url in", values, "myresourceUrl");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlNotIn(List<String> values) {
            addCriterion("myresource_url not in", values, "myresourceUrl");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlBetween(String value1, String value2) {
            addCriterion("myresource_url between", value1, value2, "myresourceUrl");
            return (Criteria) this;
        }

        public Criteria andMyresourceUrlNotBetween(String value1, String value2) {
            addCriterion("myresource_url not between", value1, value2, "myresourceUrl");
            return (Criteria) this;
        }

        public Criteria andMyresourceTimeIsNull() {
            addCriterion("myresource_time is null");
            return (Criteria) this;
        }

        public Criteria andMyresourceTimeIsNotNull() {
            addCriterion("myresource_time is not null");
            return (Criteria) this;
        }

        public Criteria andMyresourceTimeEqualTo(Date value) {
            addCriterion("myresource_time =", value, "myresourceTime");
            return (Criteria) this;
        }

        public Criteria andMyresourceTimeNotEqualTo(Date value) {
            addCriterion("myresource_time <>", value, "myresourceTime");
            return (Criteria) this;
        }

        public Criteria andMyresourceTimeGreaterThan(Date value) {
            addCriterion("myresource_time >", value, "myresourceTime");
            return (Criteria) this;
        }

        public Criteria andMyresourceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("myresource_time >=", value, "myresourceTime");
            return (Criteria) this;
        }

        public Criteria andMyresourceTimeLessThan(Date value) {
            addCriterion("myresource_time <", value, "myresourceTime");
            return (Criteria) this;
        }

        public Criteria andMyresourceTimeLessThanOrEqualTo(Date value) {
            addCriterion("myresource_time <=", value, "myresourceTime");
            return (Criteria) this;
        }

        public Criteria andMyresourceTimeIn(List<Date> values) {
            addCriterion("myresource_time in", values, "myresourceTime");
            return (Criteria) this;
        }

        public Criteria andMyresourceTimeNotIn(List<Date> values) {
            addCriterion("myresource_time not in", values, "myresourceTime");
            return (Criteria) this;
        }

        public Criteria andMyresourceTimeBetween(Date value1, Date value2) {
            addCriterion("myresource_time between", value1, value2, "myresourceTime");
            return (Criteria) this;
        }

        public Criteria andMyresourceTimeNotBetween(Date value1, Date value2) {
            addCriterion("myresource_time not between", value1, value2, "myresourceTime");
            return (Criteria) this;
        }

        public Criteria andMyresourceNumberIsNull() {
            addCriterion("myresource_number is null");
            return (Criteria) this;
        }

        public Criteria andMyresourceNumberIsNotNull() {
            addCriterion("myresource_number is not null");
            return (Criteria) this;
        }

        public Criteria andMyresourceNumberEqualTo(Integer value) {
            addCriterion("myresource_number =", value, "myresourceNumber");
            return (Criteria) this;
        }

        public Criteria andMyresourceNumberNotEqualTo(Integer value) {
            addCriterion("myresource_number <>", value, "myresourceNumber");
            return (Criteria) this;
        }

        public Criteria andMyresourceNumberGreaterThan(Integer value) {
            addCriterion("myresource_number >", value, "myresourceNumber");
            return (Criteria) this;
        }

        public Criteria andMyresourceNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("myresource_number >=", value, "myresourceNumber");
            return (Criteria) this;
        }

        public Criteria andMyresourceNumberLessThan(Integer value) {
            addCriterion("myresource_number <", value, "myresourceNumber");
            return (Criteria) this;
        }

        public Criteria andMyresourceNumberLessThanOrEqualTo(Integer value) {
            addCriterion("myresource_number <=", value, "myresourceNumber");
            return (Criteria) this;
        }

        public Criteria andMyresourceNumberIn(List<Integer> values) {
            addCriterion("myresource_number in", values, "myresourceNumber");
            return (Criteria) this;
        }

        public Criteria andMyresourceNumberNotIn(List<Integer> values) {
            addCriterion("myresource_number not in", values, "myresourceNumber");
            return (Criteria) this;
        }

        public Criteria andMyresourceNumberBetween(Integer value1, Integer value2) {
            addCriterion("myresource_number between", value1, value2, "myresourceNumber");
            return (Criteria) this;
        }

        public Criteria andMyresourceNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("myresource_number not between", value1, value2, "myresourceNumber");
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

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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