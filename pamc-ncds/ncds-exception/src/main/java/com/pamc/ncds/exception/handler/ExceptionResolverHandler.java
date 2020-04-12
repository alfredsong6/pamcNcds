package com.pamc.ncds.exception.handler;

import com.pamc.ncds.exception.domain.Result;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/9 22:20
 * @Modified :
 **/
public interface ExceptionResolverHandler {

    Result resolver(Exception ex);
}
