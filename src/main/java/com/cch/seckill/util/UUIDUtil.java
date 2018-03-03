package com.cch.seckill.util;

import java.util.UUID;

/**
 * Created by 459105408@qq.com
 * 2018-03-03 22:11.
 */

public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
