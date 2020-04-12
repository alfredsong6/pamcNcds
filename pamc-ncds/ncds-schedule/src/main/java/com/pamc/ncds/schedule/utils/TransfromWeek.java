package com.pamc.ncds.schedule.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/1 22:27
 * @Modified :
 **/
public class TransfromWeek {
    public static int change(Date start, Object end) throws ParseException {
        LocalDate startLD = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endLD = null;
        if(end instanceof Date) {
            Date end1 = (Date) end;
            endLD = end1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        if(end instanceof String){
            String end1 = (String) end;
            Date dd2 = DateUtils.parseDate(end1, "yyyy-MM-dd");
            endLD = dd2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        }
        Period between = Period.between(startLD, endLD);
        //Period.between(start.,end);
        long days = between.getDays();
        double v = (double) days / 6;
        int ceil = (int) Math.ceil(v);

        return ceil;
    }
}
