package com.pamc.ncds.bi.controller;

import com.pamc.ncds.bi.domain.DrugAlterDO;
import com.pamc.ncds.bi.dto.FlowUpStatisticDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 9:18
 * @Modified :
 **/
@RestController
@RequestMapping("flow-up")
public class FlowUpStatisticController {

    @GetMapping("statistic")
    public FlowUpStatisticDTO getStatistic(){
        DrugAlterDO drugAlterDO = new DrugAlterDO();
        drugAlterDO.setDrugName("lisi");
        System.out.println(drugAlterDO);
        FlowUpStatisticDTO flowUpStatisticDTO = new FlowUpStatisticDTO();
        flowUpStatisticDTO.setTotal(34561);
        flowUpStatisticDTO.setFinishPer(new BigDecimal(2.32));
        flowUpStatisticDTO.setFinishTotal(3455);
        return flowUpStatisticDTO;
    }


}
