package com.pamc.ncds.schedule.contorller;

import com.pamc.ncds.bi.cleint.DrugAlterApi;
import com.pamc.ncds.bi.domain.DrugAlterDO;
import com.pamc.ncds.message.api.MessageApi;
import com.pamc.ncds.message.domain.RespBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 18:29
 * @Modified :
 **/
@RestController
@RequestMapping("schedule")
public class TestController {
    @Autowired
    private DrugAlterApi drugAlterApi;

    @Autowired
    private MessageApi messageApi;


    @GetMapping("drug")
    public List<DrugAlterDO> test(@RequestParam Integer hour){
        System.out.println("schedule..");
        List<DrugAlterDO> list = drugAlterApi.getDrugAlter(hour);

        return list;
    }

    @PostMapping("message")
    public RespBase other(@RequestBody DrugAlterDO drugAlterDO){
        RespBase respBase = messageApi.sendMessage(drugAlterDO);

        return respBase;
    }
}
