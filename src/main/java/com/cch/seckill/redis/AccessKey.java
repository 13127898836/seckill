package com.cch.seckill.redis;

/**
 * Created by 459105408@qq.com
 * 2018-03-18 18:03.
 */

public class AccessKey extends BasePrefix{

    private AccessKey( int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static AccessKey withExpire(int expireSeconds) {
        return new AccessKey(expireSeconds, "access");
    }

}

