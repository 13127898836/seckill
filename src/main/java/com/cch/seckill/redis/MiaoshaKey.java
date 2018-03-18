package com.cch.seckill.redis;

/**
 * Created by 459105408@qq.com
 * 2018-03-17 20:11.
 */

public class MiaoshaKey extends BasePrefix{

    private MiaoshaKey( int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    public static MiaoshaKey isGoodsOver = new MiaoshaKey(0, "go");
    public static MiaoshaKey getMiaoshaPath = new MiaoshaKey(60, "mp");
    public static MiaoshaKey getMiaoshaVerifyCode = new MiaoshaKey(300, "vc");
}
