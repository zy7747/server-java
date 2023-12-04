package com.example.framework.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Result<T> {
    @ApiModelProperty(value = "code")
    private Integer code;

    @ApiModelProperty(value = "返回信息")
    private Object message;

    @ApiModelProperty(value = "回参")
    private T data;

    public Result() {
        super();
    }

    /**
     * 请求成功
     *
     * @param data 需要返回的数据
     * @return 封装的返回结果
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("请求成功");
        result.setData(data);
        return result;
    }

    /**
     * 请求失败
     *
     * @param msg 需要返回的错误信息
     * @return 封装的返回结果
     */
    public static <T> Result<T> fail(Object msg) {
        Result<T> results = new Result<>();
        results.setCode(400);
        results.setMessage(msg);
        return results;
    }

    /**
     * 异常与校验
     *
     * @param msg 需要返回的错误信息
     * @return 封装的返回结果
     */
    public static <T> Result<T> error(Object msg) {
        Result<T> results = new Result<>();
        results.setCode(500);
        results.setMessage(msg);
        return results;
    }

    /**
     * 没有权限
     *
     * @return 封装的返回结果
     */
    public static <T> Result<T> noPermissions() {
        Result<T> results = new Result<>();
        results.setCode(401);
        results.setMessage("用户没有权限（令牌、用户名、密码错误）");
        return results;
    }

}