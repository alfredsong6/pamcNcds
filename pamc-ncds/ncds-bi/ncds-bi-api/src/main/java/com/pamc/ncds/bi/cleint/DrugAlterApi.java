package com.pamc.ncds.bi.cleint;

import com.pamc.ncds.bi.domain.DrugAlterDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 9:26
 * @Modified :
 **/

@FeignClient(value = "ncds-bi")
public interface DrugAlterApi {

    @GetMapping("bi/drug/alterList")
    List<DrugAlterDO> getDrugAlter(@RequestParam Integer hour);
}
