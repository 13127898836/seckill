package com.cch.seckill.redis;

/**
 * Created by 459105408@qq.com
 * 2018-03-03 16:34.
 */

public class MiaoshaUserKey extends BasePrefix{
    public static final int TOKEN_EXPIRE = 3600*24 * 2;
    private MiaoshaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE, "tk");
}
