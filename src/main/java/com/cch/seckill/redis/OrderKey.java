package com.cch.seckill.redis;

/**
 * Created by 459105408@qq.com
 * 2018-03-03 16:33.
 */

public class OrderKey extends BasePrefix {
    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
