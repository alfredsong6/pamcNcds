package com.pamc.ncds.bi.dto;

import java.math.BigDecimal;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 9:21
 * @Modified :
 **/
public class FlowUpStatisticDTO {
    private Integer total;
    private Integer finishTotal;
    private BigDecimal finishPer;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getFinishTotal() {
        return finishTotal;
    }

    public void setFinishTotal(Integer finishTotal) {
        this.finishTotal = finishTotal;
    }

    public BigDecimal getFinishPer() {
        return finishPer;
    }

    public void setFinishPer(BigDecimal finishPer) {
        this.finishPer = finishPer;
    }
}
