package com.yysj.bangtang.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClientExample() {
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickName is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickName is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickName =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickName <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickName >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickName >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickName <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickName <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickName like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickName not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickName in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickName not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickName between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickName not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andPicpathIsNull() {
            addCriterion("picPath is null");
            return (Criteria) this;
        }

        public Criteria andPicpathIsNotNull() {
            addCriterion("picPath is not null");
            return (Criteria) this;
        }

        public Criteria andPicpathEqualTo(String value) {
            addCriterion("picPath =", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathNotEqualTo(String value) {
            addCriterion("picPath <>", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathGreaterThan(String value) {
            addCriterion("picPath >", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathGreaterThanOrEqualTo(String value) {
            addCriterion("picPath >=", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathLessThan(String value) {
            addCriterion("picPath <", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathLessThanOrEqualTo(String value) {
            addCriterion("picPath <=", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathLike(String value) {
            addCriterion("picPath like", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathNotLike(String value) {
            addCriterion("picPath not like", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathIn(List<String> values) {
            addCriterion("picPath in", values, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathNotIn(List<String> values) {
            addCriterion("picPath not in", values, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathBetween(String value1, String value2) {
            addCriterion("picPath between", value1, value2, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathNotBetween(String value1, String value2) {
            addCriterion("picPath not between", value1, value2, "picpath");
            return (Criteria) this;
        }

        public Criteria andActivelasttimeIsNull() {
            addCriterion("activeLastTime is null");
            return (Criteria) this;
        }

        public Criteria andActivelasttimeIsNotNull() {
            addCriterion("activeLastTime is not null");
            return (Criteria) this;
        }

        public Criteria andActivelasttimeEqualTo(Date value) {
            addCriterion("activeLastTime =", value, "activelasttime");
            return (Criteria) this;
        }

        public Criteria andActivelasttimeNotEqualTo(Date value) {
            addCriterion("activeLastTime <>", value, "activelasttime");
            return (Criteria) this;
        }

        public Criteria andActivelasttimeGreaterThan(Date value) {
            addCriterion("activeLastTime >", value, "activelasttime");
            return (Criteria) this;
        }

        public Criteria andActivelasttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activeLastTime >=", value, "activelasttime");
            return (Criteria) this;
        }

        public Criteria andActivelasttimeLessThan(Date value) {
            addCriterion("activeLastTime <", value, "activelasttime");
            return (Criteria) this;
        }

        public Criteria andActivelasttimeLessThanOrEqualTo(Date value) {
            addCriterion("activeLastTime <=", value, "activelasttime");
            return (Criteria) this;
        }

        public Criteria andActivelasttimeIn(List<Date> values) {
            addCriterion("activeLastTime in", values, "activelasttime");
            return (Criteria) this;
        }

        public Criteria andActivelasttimeNotIn(List<Date> values) {
            addCriterion("activeLastTime not in", values, "activelasttime");
            return (Criteria) this;
        }

        public Criteria andActivelasttimeBetween(Date value1, Date value2) {
            addCriterion("activeLastTime between", value1, value2, "activelasttime");
            return (Criteria) this;
        }

        public Criteria andActivelasttimeNotBetween(Date value1, Date value2) {
            addCriterion("activeLastTime not between", value1, value2, "activelasttime");
            return (Criteria) this;
        }

        public Criteria andResetcodeIsNull() {
            addCriterion("resetCode is null");
            return (Criteria) this;
        }

        public Criteria andResetcodeIsNotNull() {
            addCriterion("resetCode is not null");
            return (Criteria) this;
        }

        public Criteria andResetcodeEqualTo(String value) {
            addCriterion("resetCode =", value, "resetcode");
            return (Criteria) this;
        }

        public Criteria andResetcodeNotEqualTo(String value) {
            addCriterion("resetCode <>", value, "resetcode");
            return (Criteria) this;
        }

        public Criteria andResetcodeGreaterThan(String value) {
            addCriterion("resetCode >", value, "resetcode");
            return (Criteria) this;
        }

        public Criteria andResetcodeGreaterThanOrEqualTo(String value) {
            addCriterion("resetCode >=", value, "resetcode");
            return (Criteria) this;
        }

        public Criteria andResetcodeLessThan(String value) {
            addCriterion("resetCode <", value, "resetcode");
            return (Criteria) this;
        }

        public Criteria andResetcodeLessThanOrEqualTo(String value) {
            addCriterion("resetCode <=", value, "resetcode");
            return (Criteria) this;
        }

        public Criteria andResetcodeLike(String value) {
            addCriterion("resetCode like", value, "resetcode");
            return (Criteria) this;
        }

        public Criteria andResetcodeNotLike(String value) {
            addCriterion("resetCode not like", value, "resetcode");
            return (Criteria) this;
        }

        public Criteria andResetcodeIn(List<String> values) {
            addCriterion("resetCode in", values, "resetcode");
            return (Criteria) this;
        }

        public Criteria andResetcodeNotIn(List<String> values) {
            addCriterion("resetCode not in", values, "resetcode");
            return (Criteria) this;
        }

        public Criteria andResetcodeBetween(String value1, String value2) {
            addCriterion("resetCode between", value1, value2, "resetcode");
            return (Criteria) this;
        }

        public Criteria andResetcodeNotBetween(String value1, String value2) {
            addCriterion("resetCode not between", value1, value2, "resetcode");
            return (Criteria) this;
        }

        public Criteria andActivecodeIsNull() {
            addCriterion("activeCode is null");
            return (Criteria) this;
        }

        public Criteria andActivecodeIsNotNull() {
            addCriterion("activeCode is not null");
            return (Criteria) this;
        }

        public Criteria andActivecodeEqualTo(String value) {
            addCriterion("activeCode =", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeNotEqualTo(String value) {
            addCriterion("activeCode <>", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeGreaterThan(String value) {
            addCriterion("activeCode >", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeGreaterThanOrEqualTo(String value) {
            addCriterion("activeCode >=", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeLessThan(String value) {
            addCriterion("activeCode <", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeLessThanOrEqualTo(String value) {
            addCriterion("activeCode <=", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeLike(String value) {
            addCriterion("activeCode like", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeNotLike(String value) {
            addCriterion("activeCode not like", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeIn(List<String> values) {
            addCriterion("activeCode in", values, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeNotIn(List<String> values) {
            addCriterion("activeCode not in", values, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeBetween(String value1, String value2) {
            addCriterion("activeCode between", value1, value2, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeNotBetween(String value1, String value2) {
            addCriterion("activeCode not between", value1, value2, "activecode");
            return (Criteria) this;
        }

        public Criteria andEmailstatusIsNull() {
            addCriterion("emailStatus is null");
            return (Criteria) this;
        }

        public Criteria andEmailstatusIsNotNull() {
            addCriterion("emailStatus is not null");
            return (Criteria) this;
        }

        public Criteria andEmailstatusEqualTo(Integer value) {
            addCriterion("emailStatus =", value, "emailstatus");
            return (Criteria) this;
        }

        public Criteria andEmailstatusNotEqualTo(Integer value) {
            addCriterion("emailStatus <>", value, "emailstatus");
            return (Criteria) this;
        }

        public Criteria andEmailstatusGreaterThan(Integer value) {
            addCriterion("emailStatus >", value, "emailstatus");
            return (Criteria) this;
        }

        public Criteria andEmailstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("emailStatus >=", value, "emailstatus");
            return (Criteria) this;
        }

        public Criteria andEmailstatusLessThan(Integer value) {
            addCriterion("emailStatus <", value, "emailstatus");
            return (Criteria) this;
        }

        public Criteria andEmailstatusLessThanOrEqualTo(Integer value) {
            addCriterion("emailStatus <=", value, "emailstatus");
            return (Criteria) this;
        }

        public Criteria andEmailstatusIn(List<Integer> values) {
            addCriterion("emailStatus in", values, "emailstatus");
            return (Criteria) this;
        }

        public Criteria andEmailstatusNotIn(List<Integer> values) {
            addCriterion("emailStatus not in", values, "emailstatus");
            return (Criteria) this;
        }

        public Criteria andEmailstatusBetween(Integer value1, Integer value2) {
            addCriterion("emailStatus between", value1, value2, "emailstatus");
            return (Criteria) this;
        }

        public Criteria andEmailstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("emailStatus not between", value1, value2, "emailstatus");
            return (Criteria) this;
        }

        public Criteria andRegtimeIsNull() {
            addCriterion("regTime is null");
            return (Criteria) this;
        }

        public Criteria andRegtimeIsNotNull() {
            addCriterion("regTime is not null");
            return (Criteria) this;
        }

        public Criteria andRegtimeEqualTo(Date value) {
            addCriterion("regTime =", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeNotEqualTo(Date value) {
            addCriterion("regTime <>", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeGreaterThan(Date value) {
            addCriterion("regTime >", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("regTime >=", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeLessThan(Date value) {
            addCriterion("regTime <", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeLessThanOrEqualTo(Date value) {
            addCriterion("regTime <=", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeIn(List<Date> values) {
            addCriterion("regTime in", values, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeNotIn(List<Date> values) {
            addCriterion("regTime not in", values, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeBetween(Date value1, Date value2) {
            addCriterion("regTime between", value1, value2, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeNotBetween(Date value1, Date value2) {
            addCriterion("regTime not between", value1, value2, "regtime");
            return (Criteria) this;
        }

        public Criteria andRelotimeIsNull() {
            addCriterion("reLoTime is null");
            return (Criteria) this;
        }

        public Criteria andRelotimeIsNotNull() {
            addCriterion("reLoTime is not null");
            return (Criteria) this;
        }

        public Criteria andRelotimeEqualTo(Date value) {
            addCriterion("reLoTime =", value, "relotime");
            return (Criteria) this;
        }

        public Criteria andRelotimeNotEqualTo(Date value) {
            addCriterion("reLoTime <>", value, "relotime");
            return (Criteria) this;
        }

        public Criteria andRelotimeGreaterThan(Date value) {
            addCriterion("reLoTime >", value, "relotime");
            return (Criteria) this;
        }

        public Criteria andRelotimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reLoTime >=", value, "relotime");
            return (Criteria) this;
        }

        public Criteria andRelotimeLessThan(Date value) {
            addCriterion("reLoTime <", value, "relotime");
            return (Criteria) this;
        }

        public Criteria andRelotimeLessThanOrEqualTo(Date value) {
            addCriterion("reLoTime <=", value, "relotime");
            return (Criteria) this;
        }

        public Criteria andRelotimeIn(List<Date> values) {
            addCriterion("reLoTime in", values, "relotime");
            return (Criteria) this;
        }

        public Criteria andRelotimeNotIn(List<Date> values) {
            addCriterion("reLoTime not in", values, "relotime");
            return (Criteria) this;
        }

        public Criteria andRelotimeBetween(Date value1, Date value2) {
            addCriterion("reLoTime between", value1, value2, "relotime");
            return (Criteria) this;
        }

        public Criteria andRelotimeNotBetween(Date value1, Date value2) {
            addCriterion("reLoTime not between", value1, value2, "relotime");
            return (Criteria) this;
        }

        public Criteria andMachineIsNull() {
            addCriterion("machine is null");
            return (Criteria) this;
        }

        public Criteria andMachineIsNotNull() {
            addCriterion("machine is not null");
            return (Criteria) this;
        }

        public Criteria andMachineEqualTo(String value) {
            addCriterion("machine =", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineNotEqualTo(String value) {
            addCriterion("machine <>", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineGreaterThan(String value) {
            addCriterion("machine >", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineGreaterThanOrEqualTo(String value) {
            addCriterion("machine >=", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineLessThan(String value) {
            addCriterion("machine <", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineLessThanOrEqualTo(String value) {
            addCriterion("machine <=", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineLike(String value) {
            addCriterion("machine like", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineNotLike(String value) {
            addCriterion("machine not like", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineIn(List<String> values) {
            addCriterion("machine in", values, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineNotIn(List<String> values) {
            addCriterion("machine not in", values, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineBetween(String value1, String value2) {
            addCriterion("machine between", value1, value2, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineNotBetween(String value1, String value2) {
            addCriterion("machine not between", value1, value2, "machine");
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