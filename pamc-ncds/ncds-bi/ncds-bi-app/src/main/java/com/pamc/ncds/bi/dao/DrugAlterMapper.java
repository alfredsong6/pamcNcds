package com.pamc.ncds.bi.dao;

import com.pamc.ncds.bi.domain.DrugAlterDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 17:24
 * @Modified :
 **/
@Mapper
public interface DrugAlterMapper {

    List<DrugAlterDO> getDrugAlter(Integer hour);
}
