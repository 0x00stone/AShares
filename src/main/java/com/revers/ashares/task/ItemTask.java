package com.revers.ashares.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时爬虫
 *
 * @author Revers.
 * @date 2022/06/25 14:53
 **/

@Component
public class ItemTask {

    @Scheduled(fixedDelay = 100 * 1000)
    public void itemTask(){
        String url = "";


    }

    private void itemSpider(){

    }


}
