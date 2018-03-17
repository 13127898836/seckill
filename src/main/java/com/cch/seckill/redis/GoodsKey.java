package com.cch.seckill.redis;

/**
 * Created by 459105408@qq.com
 * 2018-03-03 16:32.
 */

public class GoodsKey extends BasePrefix{

    public GoodsKey(int exprieSecond,String prefix) {
        super(exprieSecond,prefix);
    }
    public static GoodsKey getGoodsList = new GoodsKey(60,"gl");
    public static GoodsKey getGoodsDetail = new GoodsKey(60, "gd");
    public static GoodsKey getMiaoshaGoodsStock= new GoodsKey(0, "gs");
}
