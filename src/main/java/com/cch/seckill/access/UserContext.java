package com.cch.seckill.access;

import com.cch.seckill.domain.MiaoshaUser;

/**
 * Created by 459105408@qq.com
 * 2018-03-18 18:01.
 */

public class UserContext {
    private static ThreadLocal<MiaoshaUser> userHolder = new ThreadLocal<MiaoshaUser>();

    public static void setUser(MiaoshaUser user) {
        userHolder.set(user);
    }

    public static MiaoshaUser getUser() {
        return userHolder.get();
    }

}
