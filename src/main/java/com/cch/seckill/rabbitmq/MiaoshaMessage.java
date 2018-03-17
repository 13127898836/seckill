package com.cch.seckill.rabbitmq;

import com.cch.seckill.domain.MiaoshaUser;

/**
 * Created by 459105408@qq.com
 * 2018-03-17 20:05.
 */

public class MiaoshaMessage {
    private MiaoshaUser user;
    private long goodsId;
    public MiaoshaUser getUser() {
        return user;
    }
    public void setUser(MiaoshaUser user) {
        this.user = user;
    }
    public long getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }
}

