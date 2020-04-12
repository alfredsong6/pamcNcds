package com.pamc.test.model.service;

import com.pamc.ncds.bi.domain.DrugAlterDO;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/11 18:32
 * @Modified :
 **/
@Component
public class TestService {

    @Validated
    public void msgSend(@Valid DrugAlterDO drugAlterDO){
        System.out.println(drugAlterDO.toString());
    }
}
