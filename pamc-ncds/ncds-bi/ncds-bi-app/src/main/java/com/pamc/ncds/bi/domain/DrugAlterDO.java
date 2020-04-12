package com.pamc.ncds.bi.domain;

import javax.validation.constraints.NotBlank;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 9:19
 * @Modified :
 **/
public class DrugAlterDO {
    @NotBlank(message = "姓名不能位空")
    private String name;
    @NotBlank(message = "用户code不能位空")
    private String userCode;
    private String drugName;
    private String drugCode;
    private String ruleCode;

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    @Override
    public String toString() {
        return "DrugAlterDO{" +
                "name='" + name + '\'' +
                ", userCode='" + userCode + '\'' +
                ", drugName='" + drugName + '\'' +
                ", drugCode='" + drugCode + '\'' +
                ", ruleCode='" + ruleCode + '\'' +
                '}';
    }


}
