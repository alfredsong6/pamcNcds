package com.pamc.test.model.controller;

import com.pamc.ncds.bi.domain.DrugAlterDO;
import com.pamc.ncds.exception.exception.BaseException;
import com.pamc.ncds.message.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/11 18:16
 * @Modified :
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    //private TestService msgService;
    private MsgService msgService;

    @GetMapping("msg")
    public void test(){
        DrugAlterDO drugAlterDO = new DrugAlterDO();
        drugAlterDO.setDrugName("123");
        drugAlterDO.setName(null);
        drugAlterDO.setDrugCode("1da21");
        drugAlterDO.setRuleCode("8");
        drugAlterDO.setUserCode("d87972134");
        System.out.println(drugAlterDO.toString());
        if(drugAlterDO.getDrugName().equals("124")){
            throw new BaseException("0101","参数有误");
        }
        msgService.msgSend(drugAlterDO);
    }
}
