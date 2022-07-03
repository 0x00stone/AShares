package com.revers.ashares.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * 每一支股票
 *
 * @author Revers.
 * @date 2022/06/24 00:06
 **/
@Entity
@Getter
@Setter
@Table(name = "shares")
public class Item {
    @Id
    private String id; //记录id 股票id+时间戳乘以1000
    private Integer volume; //成交量
    private BigDecimal open; //开盘价
    private BigDecimal high; //最高价
    private BigDecimal low; //最低价
    private BigDecimal close; //收盘价
    private BigDecimal chg;
    private BigDecimal percent;
    private BigDecimal turnoverrate;
    private Double amount;
    private Integer volume_post;
    private BigDecimal amount_post;
    private BigDecimal pe;
    private BigDecimal pb;
    private BigDecimal ps;
    private BigDecimal pcf;
    private Double market_capital;
    private Double balance;
    private Integer hold_volume_cn;
    private BigDecimal hold_ratio_cn;
    private Integer net_volume_cn;
    private BigDecimal hold_volume_hk;
    private BigDecimal hold_ratio_hk;
    private BigDecimal net_volume_hk;

    public Item(String sharesId, Long timestamp, Integer volume, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal chg,
                BigDecimal percent, BigDecimal turnoverrate, Double amount, Integer volume_post, BigDecimal amount_post,
                BigDecimal pe, BigDecimal pb, BigDecimal ps, BigDecimal pcf, Double market_capital, Double balance, Integer hold_volume_cn,
                BigDecimal hold_ratio_cn, Integer net_volume_cn, BigDecimal hold_volume_hk, BigDecimal hold_ratio_hk, BigDecimal net_volume_hk) {
        this.id = sharesId + timestamp;
        this.volume = volume;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.chg = chg;
        this.percent = percent;
        this.turnoverrate = turnoverrate;
        this.amount = amount;
        this.volume_post = volume_post;
        this.amount_post = amount_post;
        this.pe = pe;
        this.pb = pb;
        this.ps = ps;
        this.pcf = pcf;
        this.market_capital = market_capital;
        this.balance = balance;
        this.hold_volume_cn = hold_volume_cn;
        this.hold_ratio_cn = hold_ratio_cn;
        this.net_volume_cn = net_volume_cn;
        this.hold_volume_hk = hold_volume_hk;
        this.hold_ratio_hk = hold_ratio_hk;
        this.net_volume_hk = net_volume_hk;
    }

    public Item() {

    }
}
