package com.revers.ashares.task;

import com.alibaba.fastjson.JSON;
import com.revers.ashares.ASharesApplication;
import com.revers.ashares.pojo.Company;
import com.revers.ashares.service.CompanyService;
import com.revers.ashares.service.ItemService;
import com.revers.ashares.util.net.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.net.URISyntaxException;

/**
 * @author Revers.
 * @date 2022/07/03 22:13
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ASharesApplication.class)
public class TestCompanyTask {

    @Autowired
    CompanyService companyService;

    HttpUtils httpUtils;

    public void TestCompanyTask(int id) throws URISyntaxException {
        String content2 = "";
        String content1 = "";
        if(httpUtils == null){
            httpUtils = new HttpUtils();
        }

        URIBuilder uriBuilder = new URIBuilder("https://stock.xueqiu.com/v5/stock/f10/cn/company.json");
        uriBuilder.setParameter("symbol","SH" + id);

        String content = httpUtils.doGetHtml(uriBuilder);
        if("400".equals(content)){
            TestCompanyTask(id);
            return;
        }else if("404".equals(content)){
            log.warn(id + "404!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        Object data = JSON.parseObject(content).get("data");
        if(data != null) {
            content1 = data.toString();
        }else {
            return;
        }
        Object companyOboject = JSON.parseObject(content1).get("company");
        if(companyOboject != null) {
            content2 = companyOboject.toString();
        }else {
            return;
        }


        Company company = JSON.parseObject(content2,Company.class);
        if(!"null".equals(company.getOrg_id()) && company.getOrg_id() != null){
            companyService.save(company);
        }
    }

    @Test
    public void spiderCompany(){
        for(int i = 600000 ; i < 700000 ; i++){
            try {
                TestCompanyTask(i);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        log.warn("公司遍历完成！！！！！！！！！！！！！！！！！！！！！！！！！！！");
    }
}
