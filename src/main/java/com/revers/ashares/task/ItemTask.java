package com.revers.ashares.task;

import com.alibaba.fastjson.JSON;
import com.revers.ashares.pojo.Company;
import com.revers.ashares.pojo.Item;
import com.revers.ashares.service.CompanyService;
import com.revers.ashares.service.ItemService;
import com.revers.ashares.util.net.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 定时爬虫
 *
 * @author Revers.
 * @date 2022/06/25 14:53
 **/

@Slf4j
@Component
public class ItemTask {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CompanyService companyService;

    @Scheduled(fixedDelay = 100 * 1000)
    public void itemTask(){
        String url = "";


    }

    private void itemSpider(){
        for(Company company : companyService.findAll()){
            company.getListed_date();
        }

    }

    public void eachItemTask(String shareId) throws URISyntaxException {

        HttpUtils httpUtils = new HttpUtils();

        //String s = httpUtils.doGetHtml("https://xueqiu.com/");

        //String shareId = "SH688363";
        String begin = "1585152000000";
        URIBuilder uriBuilder = new URIBuilder("https://stock.xueqiu.com/v5/stock/chart/kline.json");
        uriBuilder.setParameter("symbol",shareId)
                .setParameter("begin",begin)
                .setParameter("period","day")
                .setParameter("type","before")
                .setParameter("count","-200")
                .setParameter("indicator","kline,pe,pb,ps,pcf,market_capital,agt,ggt,balance");



        String content = httpUtils.doGetHtml(uriBuilder);
        String content1 = JSON.parseObject(content).get("data").toString();
        String content2 = JSON.parseObject(content1).get("item").toString();
        System.out.println(JSON.parseArray(content2).size());
        //
        Object[][] objects = JSON.parseObject(content2,Object[][].class);
        for(Object[] obj2 : objects){
            if(obj2.length != 24){
                log.info(obj2[0] + "长度不足24字段");
            }

            Long timestamp = (Long) obj2[0];
            LocalDateTime localDateTime = new Timestamp(timestamp).toLocalDateTime();
            String date = Integer.toString(localDateTime.getYear());
            if(localDateTime.getMonthValue() < 10){
                date = date + "0" + localDateTime.getMonthValue();
            }else {
                date += localDateTime.getMonthValue();
            }
            if(localDateTime.getDayOfMonth() < 10){
                date = date + "0" + localDateTime.getMonthValue();
            }else {
                date += localDateTime.getDayOfMonth();
            }




            Integer volume = (Integer) obj2[1];
            BigDecimal open =(BigDecimal) obj2[2];
            BigDecimal high = (BigDecimal) obj2[3];
            BigDecimal low = (BigDecimal) obj2[4];
            BigDecimal close = (BigDecimal) obj2[5];
            BigDecimal chg =  (BigDecimal) obj2[6];
            BigDecimal percent = (BigDecimal) obj2[7];
            BigDecimal turnoverrate = (BigDecimal) obj2[8];
            Double amount = (Double) obj2[9];
            Integer volume_post = (Integer) obj2[10];
            BigDecimal amount_post = (BigDecimal) obj2[11];
            BigDecimal pe = (BigDecimal) obj2[12];
            BigDecimal pb = (BigDecimal) obj2[13];
            BigDecimal ps =  (BigDecimal) obj2[14];
            BigDecimal pcf = (BigDecimal) obj2[15];
            Double market_capital = (Double) obj2[16];
            Double balance =  (Double) obj2[17];
            Integer hold_volume_cn = (Integer) obj2[18];
            BigDecimal hold_ratio_cn = (BigDecimal) obj2[19];
            Integer net_volume_cn =  (Integer) obj2[20];
            BigDecimal hold_volume_hk =  (BigDecimal) obj2[21];
            BigDecimal hold_ratio_hk = (BigDecimal) obj2[22];
            BigDecimal net_volume_hk =  (BigDecimal) obj2[23];
            Item item = new Item(shareId,timestamp, date,volume, open, high, low,close, chg, percent, turnoverrate, amount, volume_post, amount_post, pe, pb, ps, pcf, market_capital, balance, hold_volume_cn, hold_ratio_cn, net_volume_cn, hold_volume_hk, hold_ratio_hk, net_volume_hk);

            itemService.save(item);
        }
        System.out.println("success");
    }


}
