package com.revers.ashares.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface createTableMapper {

    /**
     * "timestamp 时间戳乘以1000",
     * "volume 成交量",
     * "open 开盘价",
     *  "high 最高价",
     *  "low 最低价",
     *  "close 收盘价",
     *  "chg",
     *  "percent",
     *  "turnoverrate",
     *  "amount",
     *  "volume_post",
     *  "amount_post",
     *  "pe",
     *  "pb",
     *  "ps",
     *  "pcf",
     *  "market_capital",
     *  "balance",
     *  "hold_volume_cn",
     *  "hold_ratio_cn",
     *  "net_volume_cn",
     *  "hold_volume_hk",
     *  "hold_ratio_hk",
     *  "net_volume_hk"
     */

    @Update("CREATE TABLE `${tableName}` (  " +
            "timestamp INTEGER NOT NULL PRIMARY KEY,  " +
            "volume INTEGER,  " +
            "open float," +
            "high float," +
            "low float," +
            "close float," +
            "chg float," +
            "percent float," +
            "turnoverrate float," +
            "amount INTEGER," +
            "volume_post double," +
            "amount_post double," +
            "pe float," +
            "pb float," +
            "ps float," +
            "pcf float," +
            "market_capital double," +
            "balance double," +
            "hold_volume_cn INTEGER," +
            "hold_ratio_cn float," +
            "net_volume_cn INTEGER," +
            "hold_volume_hk double," +
            "hold_ratio_hk double," +
            "net_volume_hk double," +
            "create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP," +
            "update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" +
            ");")
    public void createTable(String tableName);


}