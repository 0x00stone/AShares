package com.revers.ashares.util.net;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Revers.
 * @date 2022/06/25 14:32
 * 爬虫类
 **/

@Slf4j
public class HttpUtils {
    private PoolingHttpClientConnectionManager cm;
    String userAgent = "";
    String cookie = "";

    public HttpUtils(){
        this.cm = new PoolingHttpClientConnectionManager();

        cm.setMaxTotal(200);

        cm.setDefaultMaxPerRoute(50);
    }

    public String doGetHtml(URIBuilder url){

        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(this.cm).build();

        CloseableHttpResponse response = null;

        if("".equals(cookie)){
            doGetToken();
        }

        try {

            HttpGet httpGet = new HttpGet(url.build());
            httpGet.setConfig(this.getConfig());
            httpGet.addHeader("cookie","xq_a_token=" + cookie);
            httpGet.setHeader("User-Agent",userAgent);
            httpGet.setHeader("Content-Type","application/json;charset=utf-8");
            response = httpclient.execute(httpGet);

            if(response.getStatusLine().getStatusCode() == 200){
                if(response.getEntity() != null){
                    String content = EntityUtils.toString(response.getEntity(),"UTF-8");
                    log.info(content);
                    return content;
                }
            }else {
                return String.valueOf(response.getStatusLine().getStatusCode());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(response != null){
                try{
                    response.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public String doGetToken(){
        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(this.cm).build();
        userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:102.0) Gecko/20100101 Firefox/102.0";

        HttpGet httpGet = new HttpGet("https://xueqiu.com/");
        httpGet.setHeader("User-Agent",userAgent);
        CloseableHttpResponse response = null;

        httpGet.setConfig(this.getConfig());

        try {
            response = httpclient.execute(httpGet);

            if(response.getStatusLine().getStatusCode() == 200){
                for(Header header : response.getHeaders("Set-Cookie")){
                    if(header.getValue().matches(".*xq_a_token.*")){
                        cookie = header.getValue().substring(11,53);
                        log.info("获取token" + cookie);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(response != null){
                try{
                    response.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public String doGetHtml(String url){
        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(this.cm).build();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;

        httpGet.setConfig(this.getConfig());

        try {
            response = httpclient.execute(httpGet);

            if(response.getStatusLine().getStatusCode() == 200){
                if(response.getEntity() != null){
                    String content = EntityUtils.toString(response.getEntity(),"utf8");
                    return content;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(response != null){
                try{
                    response.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return "";
    }



    private RequestConfig getConfig() {

        return RequestConfig.custom().setConnectionRequestTimeout(500)
                .setConnectTimeout(1000)
                .setSocketTimeout(10000)
                .build();
    }
}
