package com.pamc.ncds.bi.controller;

import com.pamc.ncds.bi.domain.DrugAlterDO;
import com.pamc.ncds.bi.service.TakeDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 17:23
 * @Modified :
 **/
@RestController
@RequestMapping("drug")
public class TakeDrugController {

    @Autowired
    private TakeDrugService takeDrugService;


    @GetMapping("alterList")
    public List<DrugAlterDO> getDrugAlter(@RequestParam Integer hour){
        System.out.println("执行。。。。。。。");
        return takeDrugService.getDrugAlter(hour);
    }

    @PostMapping("test")
    public String test(){
        DrugAlterDO drugAlterDO = new DrugAlterDO();
        drugAlterDO.setDrugName("123");
        drugAlterDO.setName(null);
        drugAlterDO.setDrugCode("1da21");
        drugAlterDO.setRuleCode("8");
        drugAlterDO.setUserCode("d87972134");
        return "ok";
    }
}
