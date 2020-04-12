package com.pamc.ncds.message.api;

import com.pamc.ncds.bi.domain.DrugAlterDO;
import com.pamc.ncds.message.domain.RespBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 23:25
 * @Modified :
 **/
@FeignClient(value = "ncds-message")
public interface MessageApi {

    @PostMapping("message/alter")
    RespBase sendMessage(@RequestBody DrugAlterDO drugAlterDO);

    @PostMapping("message/alterVoid")
    void sendVoidMessage(@RequestBody DrugAlterDO drugAlterDO);
}
