package com.pamc.test.model.doamin;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/12 10:32
 * @Modified :
 **/
public class Friend {
    private String xingming;
    private String other;
    private String id;
    private String SNO;
    private String address;
    private double money;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Integer age;
    public String getName() {
        return xingming;
    }

    public void setName(String name) {
        this.xingming = name;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSNO() {
        return SNO;
    }

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + xingming + '\'' +
                ", other='" + other + '\'' +
                ", id='" + id + '\'' +
                ", SNO='" + SNO + '\'' +
                ", address='" + address + '\'' +
                ", money=" + money +
                ", age=" + age +
                '}';
    }
}
