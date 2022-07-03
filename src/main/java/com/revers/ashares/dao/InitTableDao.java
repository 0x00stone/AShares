package com.revers.ashares.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface InitTableDao {

    @Update("CREATE TABLE `Shares` (  " +
            "id varchar(25) NOT NULL  PRIMARY KEY,  " +
            "volume bigint(15),  " +
            "open float," +
            "high float," +
            "low float," +
            "close float," +
            "chg float," +
            "percent float," +
            "turnoverrate float," +
            "amount bigint(20)," +
            "volume_post double," +
            "amount_post double," +
            "pe float," +
            "pb float," +
            "ps float," +
            "pcf float," +
            "market_capital double," +
            "balance bigint(15)," +
            "hold_volume_cn bigint(15)," +
            "hold_ratio_cn float," +
            "net_volume_cn bigint(15)," +
            "hold_volume_hk double," +
            "hold_ratio_hk double," +
            "net_volume_hk double," +
            "create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP," +
            "update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" +
            ");")
    public void createTable();

    /** private Integer id;
     private String companyId; //股票id SH600000
     private String companyName; //公司名称 上海浦东发展银行股份有限公司
     private String companyLocal; //所属省份 上海市
     private String companyOwnershipNatureName;  //所有制性质名称 	省属国资控股
     private String mainBusiness; //主营业务 提供银行及相关金融服务
     private String chairman; //董事长 郑杨
     private String legalRepresentative; //法人代表 郑杨
     private Long dateOfIncorporation; //成立日期 1992-10-19
     private String registeredCapital;//注册资本 293.52亿
     private Integer numberOfEmployees;//员工人数 63361
     private Integer numberOfManagement; //管理层人数 	27
     private Long listingDate;//上市日期 1999-11-10
     private String circulation;//发行量 4.00亿
     private Float issuePrice;//    发行价格	10
     private String raisedFunds;//    募集资金	39.55亿
     private Float IPOPERatio;//    发行市盈率	26.30
     private Float onlineWinningRate;//    网上中签率	1.42%
     private String contactNumber;//    联系电话	86-21-63611226;86-21-61618888
     private Integer postalCode;//    邮政编码	200002
     private String fax;//    传真	86-21-63230807
     private String email;//    电子邮箱	xw@spdb.com.cnwur2@spdb.com.cnbdo@spdb.com.cn
     private String companyWebSite;//    公司网址	www.spdb.com.cn
     private String companyRegisteredAddress;//    注册地址	上海市黄浦区中山东一路12号
     private String officeAddress;//    办公地址	上海市黄浦区中山东一路12号**/
    @Update("CREATE TABLE `company` (  " +
            "id varchar(25) NOT NULL  PRIMARY KEY,  " +
            "companyId varchar(15),  " +
            "companyName varchar(50)," +
            "companyLocal varchar(20)," +
            "companyOwnershipNatureName varchar(20)," +
            "mainBusiness varchar(50)," +
            "chairman varchar(10)," +
            "legalRepresentative varchar(10)," +
            "dateOfIncorporation bigint(20)," +
            "registeredCapital varchar(20)," +
            "numberOfEmployees integer," +
            "numberOfManagement integer," +
            "listingDate bigint(20)," +
            "circulation varchar(20)," +
            "issuePrice float," +
            "raisedFunds varchar(20)," +
            "IPOPERatio float," +
            "onlineWinningRate float," +
            "contactNumber varchar(30)," +
            "postalCode integer," +
            "fax varchar(30)," +
            "email varchar(30)," +
            "companyWebSite varchar(30)," +
            "companyRegisteredAddress varchar(30)," +
            "officeAddress varchar(30)," +
            "create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP," +
            "update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" +
            ");")
    public void createCompany();


}