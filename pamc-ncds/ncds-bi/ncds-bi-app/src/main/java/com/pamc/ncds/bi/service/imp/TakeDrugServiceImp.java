package com.pamc.ncds.bi.service.imp;

import com.pamc.ncds.bi.dao.DrugAlterMapper;
import com.pamc.ncds.bi.domain.DrugAlterDO;
import com.pamc.ncds.bi.service.TakeDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 17:43
 * @Modified :
 **/
@Service
public class TakeDrugServiceImp implements TakeDrugService {
    @Autowired
    private DrugAlterMapper drugAlterMapper;

    @Override
    public List<DrugAlterDO> getDrugAlter(Integer hour) {
        return drugAlterMapper.getDrugAlter(hour);
    }
}
