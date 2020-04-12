package com.pamc.ncds.bi.service;

import com.pamc.ncds.bi.domain.DrugAlterDO;

import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 17:39
 * @Modified :
 **/
public interface TakeDrugService {

    List<DrugAlterDO> getDrugAlter(Integer hour);
}
