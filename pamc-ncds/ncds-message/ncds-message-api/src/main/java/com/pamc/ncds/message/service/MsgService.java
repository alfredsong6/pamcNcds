package com.pamc.ncds.message.service;

import com.pamc.ncds.bi.domain.DrugAlterDO;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/9 22:00
 * @Modified :
 **/
@Component
public class MsgService {

    @Validated
    public void msgSend(@Valid DrugAlterDO drugAlterDO){
        //System.out.println(drugAlterDO.toString());
    }
}
