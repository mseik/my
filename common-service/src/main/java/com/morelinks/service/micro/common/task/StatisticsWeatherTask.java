//package com.morelinks.service.micro.common.task;
//
//import com.morelinks.core.util.DateUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//@Component
//@ConditionalOnExpression("${task.enabled:false}")
//public class StatisticsWeatherTask {
//    private static Logger logger = LoggerFactory.getLogger(StatisticsWeatherTask.class);
//
//    //凌晨执行
//    @Scheduled(cron = "0 5 * * * ?")
//    public void job() {
//
//    }
//}