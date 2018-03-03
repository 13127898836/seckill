package com.cch.seckill.result;

/**
 * Created by 459105408@qq.com
 * 2018-03-03 0:11.
 */

public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result() {
    }

    /**
     * 成功的时候调用
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> error(CodeMsg cm) {
        return new Result<T>(cm);
    }

    private Result(CodeMsg cm) {
        if (cm == null) {
            return;
        }
        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }

    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    public T getData() {
        return data;
    }


}
