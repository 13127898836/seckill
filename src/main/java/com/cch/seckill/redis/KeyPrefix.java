package com.cch.seckill.redis;

/**
 * Created by 459105408@qq.com
 * 2018-03-03 16:28.
 */

public interface KeyPrefix {
    public int expireSeconds();

    public String getPrefix();
}
