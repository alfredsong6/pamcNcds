package com.pamc.ncds.schedule.task;

import com.google.common.collect.Lists;
import com.pamc.ncds.bi.cleint.DrugAlterApi;
import com.pamc.ncds.bi.domain.DrugAlterDO;
import com.pamc.ncds.message.service.MsgService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/9 23:07
 * @Modified :
 **/
@Component
public class DrugAlterWithout {
    @Autowired
    private DrugAlterApi drugAlterApi;

    @Autowired
    private MsgService msgService;

    private static Logger log = LoggerFactory.getLogger(DrugAlterJob.class);



    @XxlJob("drugAlterWithout")
    public ReturnT<String> drugAlterJobHandler(String param) throws ExecutionException, InterruptedException {

        XxlJobLogger.log("开始执行用药提醒任务");
        log.info("开始执行用药提醒任务");
        LocalDateTime start = LocalDateTime.now();
        log.info("开始执行时间-{}", start.getSecond());
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        log.info("时间--{}",cal.get(Calendar.HOUR_OF_DAY));
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        List<DrugAlterDO> drugAlter = drugAlterApi.getDrugAlter(hour);

        log.info("需要提醒用药的用户数量-{}",drugAlter.size());


        Thread.sleep(2000);
        List<List<DrugAlterDO>> partition = Lists.partition(drugAlter,800000);
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Integer num = 1;

        for(List<DrugAlterDO> list:partition){
            log.info("第-{}--批执行的任务。。",num);
            //Thread.sleep(3000);
            num++;

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    Integer count =1;
                    for (DrugAlterDO req : list) {
                        //log.info("用户---{}",req.toString());
                        msgService.msgSend(req);
                        System.out.println("发送次数-------"+count++);
                    }
                }
            };
            executorService.submit(runnable);

        }

        LocalDateTime end = LocalDateTime.now();
        log.info("结束执行时间-{}", end.getSecond()-start.getSecond());
        //log.info("发送用药提醒--{}，其中成功--{}，失败--{}",success.size()+fail.size(),success.size(),fail.size());
        return ReturnT.SUCCESS;
    }
}
