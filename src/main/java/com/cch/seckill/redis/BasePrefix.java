package com.cch.seckill.redis;

/**
 * Created by 459105408@qq.com
 * 2018-03-03 16:28.
 */

public abstract class BasePrefix implements KeyPrefix{
    private int expireSeconds;
    private String prefix;

    public BasePrefix(String prefix) {
        this(0, prefix);//0代表永不过期
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className+":" + prefix;
    }
}
