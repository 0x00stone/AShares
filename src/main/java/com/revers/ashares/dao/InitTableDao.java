package com.revers.ashares.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface InitTableDao {

    @Update("CREATE TABLE `Shares` (  " +
            "id varchar(25) NOT NULL  PRIMARY KEY,  " +
            "shareid varchar(10),  " +
            "number int,  " +
            "date varchar(10),  " +
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

    /**
     * private Integer id;//股票id SH600000 -- 02600000
     *     private String org_name_cn; //公司名称 上海浦东发展银行股份有限公司
     *     private String org_short_name_cn;//短名称  浦发银行
     *     private String org_name_en; //英文名称 Shanghai Pudong Development Bank Co.,Ltd.
     *     private String org_short_name_en;//英文短名称 SPD BANK
     *     private String main_operation_business; //主营业务 提供银行及相关金融服务
     *     private String operating_scope;//操作范围 吸收公众存款；发放短期、中期和长期贷款；办理结算；办理票据贴现；发行金融债券；代理发行、代理兑付、承销政府债券；买卖政府债券；同业拆借；提供信用证服务及担保；代理收付款项及代理保险业务；提供保管箱服务；外汇存款；外汇贷款；外汇汇款；外币兑换；国际结算；同业外汇拆借；外汇票据的承兑和贴现；外汇借款；外汇担保；结汇、售汇；买卖和代理买卖股票以外的外币有价证券；自营外汇买卖；代客外汇买卖；资信调查、咨询、见证业务；离岸银行业务；经中国人民银行和中国银行业监督管理委员会批准的其他业务。
     *     private Integer district_encode; // 310101
     *     private String org_cn_introduction;//上海浦东发展银行股份有限公司是一家全国性股份制商业银行,主营业务是提供银行及相关金融服务；主要产品为大客户经营业务、对公存贷款业务、投资银行业务、交易银行业务、国际业务平台业务、个人客户与存款业务、消
     *     private String legal_representative; //法人代表 郑杨
     *     private String general_manager;// 总经理 潘卫东
     *     private String secretary;//董秘 谢伟
     *     private Long established_date; //成立日期 719424000000 1992-10-19
     *     private Long reg_asset;//注册资本(CNY) 29352171861
     *     private Integer staff_num;//员工人数 63361
     *     private String telephone;//    联系电话	86-21-63611226;86-21-61618888
     *     private Integer postcode;//    邮政编码	200002
     *     private String fax;//    传真	86-21-63230807
     *     private String email;//    电子邮箱	xw@spdb.com.cnwur2@spdb.com.cnbdo@spdb.com.cn
     *     private String org_website;//    公司网址	www.spdb.com.cn
     *     private String reg_address_cn;//    注册地址	上海市黄浦区中山东一路12号
     *     private String reg_address_en;
     *     private String office_address_cn;//    办公地址	上海市黄浦区中山东一路12号
     *     private String office_address_en;
     *     private String currency_encode;//019001
     *     private String currency;//CNY
     *     private Long listed_date;//上市日期 942163200000 1999-11-10
     *     private String provincial_name; //所属省份 上海市
     *     private String actual_controller;//实际控制人
     *     private String classi_name;  //所有制性质名称 	省属国资控股
     *     private String pre_name_cn;//曾用名
     *     private String chairman; //董事长 郑杨
     *     private Integer executives_nums; //管理层人数 	27
     *     private Long actual_issue_vol;//发行量  400000000  4.00亿
     *     private Float issue_price;//    发行价格	10
     *     private Long actual_rc_net_amt;//    募集资金	3955000000 39.55亿
     *     private Float pe_after_issuing;//    发行市盈率	26.30
     *     private Float online_success_rate_of_issue;//    网上中签率	1.4155
     *     **/
    @Update("CREATE TABLE `company` (  " +
            "id varchar(20) NOT NULL PRIMARY KEY,  " +
            "org_id varchar(20)," +
            "org_name_cn varchar(300),  " +
            "org_short_name_cn varchar(300)," +
            "org_name_en varchar(300)," +
            "org_short_name_en varchar(300)," +
            "main_operation_business varchar(1000)," +
            "operating_scope varchar(1500)," +
            "district_encode integer," +
            "org_cn_introduction varchar(1500)," +
            "legal_representative varchar(30)," +
            "general_manager varchar(30)," +
            "secretary varchar(30)," +
            "established_date bigint(20)," +
            "reg_asset bigint(20)," +
            "staff_num integer," +
            "telephone varchar(100)," +
            "postcode varchar(20)," +
            "fax varchar(100)," +
            "email varchar(100)," +
            "org_website varchar(50)," +
            "reg_address_cn varchar(200)," +
            "reg_address_en varchar(200)," +
            "office_address_cn varchar(300)," +
            "office_address_en varchar(300)," +
            "currency_encode varchar(10)," +
            "currency varchar(20)," +
            "listed_date bigint(15)," +
            "provincial_name varchar(50)," +
            "actual_controller varchar(300)," +
            "classi_name varchar(50)," +
            "pre_name_cn varchar(50)," +
            "chairman varchar(50)," +
            "executives_nums integer," +
            "actual_issue_vol bigint(20)," +
            "issue_price float," +
            "actual_rc_net_amt bigint(20)," +
            "pe_after_issuing float," +
            "online_success_rate_of_issue float," +
            "create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP," +
            "update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" +
            ");")
    public void createCompany();


}