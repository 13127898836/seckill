package com.cch.seckill.vo;

import com.cch.seckill.domain.OrderInfo;

/**
 * Created by 459105408@qq.com
 * 2018-03-17 21:46.
 */

public class OrderDetailVo {
    private GoodsVo goods;
    private OrderInfo order;
    public GoodsVo getGoods() {
        return goods;
    }
    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }
    public OrderInfo getOrder() {
        return order;
    }
    public void setOrder(OrderInfo order) {
        this.order = order;
    }
}