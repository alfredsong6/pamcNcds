package com.pamc.test.model.doamin;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/12 10:32
 * @Modified :
 **/
public class Student {
    @NotBlank
    private String name;
    @NotNull
    private String address;
    @Valid
    private Friend friend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }
}
