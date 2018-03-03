package com.cch.seckill.redis;

/**
 * Created by 459105408@qq.com
 * 2018-03-03 16:32.
 */

public class UserKey extends BasePrefix{

    public UserKey(String prefix) {
        super(prefix);
    }
    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
