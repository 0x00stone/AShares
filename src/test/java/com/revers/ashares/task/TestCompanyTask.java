package com.revers.ashares.task;

import com.alibaba.fastjson.JSON;
import com.revers.ashares.pojo.Company;
import com.revers.ashares.pojo.Item;
import com.revers.ashares.service.CompanyService;
import com.revers.ashares.service.ItemService;
import com.revers.ashares.util.net.HttpUtils;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.net.URISyntaxException;

/**
 * @author Revers.
 * @date 2022/07/03 22:13
 **/
public class TestCompanyTask {

    @Autowired
    private CompanyService companyService;

    @Test
    public void TestCompanyTask() throws URISyntaxException {

        HttpUtils httpUtils = new HttpUtils();

        //String s = httpUtils.doGetHtml("https://xueqiu.com/");

        URIBuilder uriBuilder = new URIBuilder("https://stock.xueqiu.com/v5/stock/f10/cn/company.json");
        uriBuilder.setParameter("symbol","SH600000");

        String content = httpUtils.doGetHtml(uriBuilder);
        if("400".equals(content)){

        }
        String content1 = JSON.parseObject(content).get("data").toString();
        System.out.println(content1);
        String content2 = JSON.parseObject(content1).get("company").toString();
        System.out.println(content2);
        Company company = JSON.parseObject(content2,Company.class);
        System.out.println(company.toString());
        //companyService.save(company);
        System.out.println("保存公司成功");
    }





}
