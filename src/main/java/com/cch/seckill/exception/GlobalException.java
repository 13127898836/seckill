package com.cch.seckill.exception;

import com.cch.seckill.result.CodeMsg;

/**
 * 全局异常
 * Created by 459105408@qq.com
 * 2018-03-03 22:06.
 */

public class GlobalException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }

}
