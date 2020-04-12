package com.pamc.ncds.message.controllere;

import com.pamc.ncds.bi.domain.DrugAlterDO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 23:21
 * @Modified :
 **/
@RestController
@RequestMapping("message")
public class MessageController {

    @PostMapping("alter")
    public void sendMessage(@RequestBody @Validated DrugAlterDO drugAlterDO){
        System.out.println(drugAlterDO.toString());
    }

    @PostMapping("alterVoid")
    public void sendVoidMessage(@RequestBody DrugAlterDO drugAlterDO){
        System.out.println(drugAlterDO);
    }
}
