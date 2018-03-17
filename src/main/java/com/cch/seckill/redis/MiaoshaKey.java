package com.cch.seckill.redis;

/**
 * Created by 459105408@qq.com
 * 2018-03-17 20:11.
 */

public class MiaoshaKey extends BasePrefix{

    private MiaoshaKey(String prefix) {
        super(prefix);
    }
    public static MiaoshaKey isGoodsOver = new MiaoshaKey("go");
}
