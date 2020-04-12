package com.pamc.test.model.doamin;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/12 10:32
 * @Modified :
 **/
public class Friend {
    private String name;
    private String SNO;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Integer age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "name='" + name + '\'' +
                ", SNO='" + SNO + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
