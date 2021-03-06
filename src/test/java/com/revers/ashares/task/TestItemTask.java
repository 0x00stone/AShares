package com.revers.ashares.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.revers.ashares.ASharesApplication;
import com.revers.ashares.dao.InitTableDao;
import com.revers.ashares.dao.ItemDao;
import com.revers.ashares.pojo.Item;
import com.revers.ashares.service.ItemService;
import com.revers.ashares.util.net.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Revers.
 * @date 2022/06/25 16:08
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ASharesApplication.class)
public class TestItemTask {

    //https://stock.xueqiu.com/v5/stock/chart/kline.json?
    // symbol=SH688363&
    // begin=1585152000000&
    // period=day&
    // type=before&
    // count=-212&
    // indicator=kline,pe,pb,ps,pcf,market_capital,agt,ggt,balance

    @Autowired
    private ItemService itemService;

    @Test
    public void testGetCookie(){
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.doGetToken();
    }

    @Test
    public void TestItemTask() throws URISyntaxException {

        HttpUtils httpUtils = new HttpUtils();

        //String s = httpUtils.doGetHtml("https://xueqiu.com/");

        String shareId = "SH688363";
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
                log.info(obj2[0] + "????????????24??????");
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

    @Test
    public void timestampToDate(){
        String timestamp = "1572969600000";
        LocalDateTime localDateTime = new Timestamp(Long.valueOf(timestamp)).toLocalDateTime();

        System.out.println(localDateTime.getYear()+","+localDateTime.getMonthValue()+","+localDateTime.getDayOfMonth());

    }
}
