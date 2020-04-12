package com.pamc.ncds.schedule.task;

import com.google.common.collect.Lists;
import com.pamc.ncds.bi.cleint.DrugAlterApi;
import com.pamc.ncds.bi.domain.DrugAlterDO;
import com.pamc.ncds.message.api.MessageApi;
import com.pamc.ncds.message.domain.RespBase;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 22:02
 * @Modified :
 **/
@Component
public class DrugAlterJob {

    @Autowired
    private DrugAlterApi drugAlterApi;
    @Autowired
    private MessageApi messageApi;

    private static Logger log = LoggerFactory.getLogger(DrugAlterJob.class);

    @XxlJob("ncdsTest")
    public ReturnT<String> myTest(String param){
        XxlJobLogger.log("my xxl-job test...niubigalasi");
        System.out.println("执行ncds-schedule成功");
        return ReturnT.SUCCESS;
    }

    @XxlJob("drugAlterTask")
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

//        for (DrugAlterDO req : drugAlter) {
//            //log.info("用户---{}",req.toString());
//            messageApi.sendMessage(req);
//        }

        Thread.sleep(2000);
        List<List<DrugAlterDO>> partition = Lists.partition(drugAlter,800000);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        List<FutureTask<List<String>>> futureTasks = new ArrayList<>();
        Integer num = 1;

        for(List<DrugAlterDO> list:partition){
            log.info("第-{}--批执行的任务。。",num);
            //Thread.sleep(3000);
            num++;
            Callable<List<String>> call = new Callable<List<String>>() {
                @Override
                public List<String> call() throws Exception {
                    List<String> result = new ArrayList<>();
                    log.info("调用message");
                    for (DrugAlterDO req : list) {
                        //log.info("用户-{}",req.toString());
                        RespBase respBase = messageApi.sendMessage(req);
                        //log.info("message调用结果-{}",respBase.getStatu());
                        if (respBase.getMsg().equals("success")) {
                            String statu = respBase.getStatu();
                            result.add(statu);
                        } else {
                            result.add("bad");
                        }
                    }
                    log.info("result-{}",result.size());
                    return result;
                }
            };
            FutureTask<List<String>> task = new FutureTask<>(call);

            executorService.submit(task);
            futureTasks.add(task);
        }
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> success = new ArrayList<>();
        List<String> fail = new ArrayList<>();
        for(FutureTask<List<String>> tt:futureTasks){

            List<String> parList = tt.get();
            //log.info("parlist----{}---{}",parList.size(),parList);
            List<String> successList = parList.stream().filter((e) -> e.equals("ok")).collect(Collectors.toList());
            success.addAll(successList);
            List<String> failList = parList.stream().filter((e) -> e.equals("bad")).collect(Collectors.toList());
            fail.addAll(failList);
        }
        LocalDateTime end = LocalDateTime.now();
        log.info("结束执行时间-{}", end.getSecond()-start.getSecond());
        //log.info("发送用药提醒--{}，其中成功--{}，失败--{}",success.size()+fail.size(),success.size(),fail.size());
        return ReturnT.SUCCESS;
    }


}
