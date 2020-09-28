package com.yhd.amn.common.view;


import java.io.Serializable;

public class R<T> implements Serializable {

    /**
     * 成功码.
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * 成功信息.
     */
    public static final String SUCCESS_MESSAGE = "操作成功";

    public static final String ADD_SUC = "新增成功";

    public static final String UPDATE_SUC = "修改成功";

    public static final String DEL_SUC = "删除成功";

    public static final String HANDLE_SUC = "操作成功";

    public static final String UPDATE_FAIL = "更新失败，请重试";

    public static final String MODIFY_FAIL = "操作失败，请刷新后重试";

    public static final String ADD_TRUCK_MBILLIN_SUC = "材料车进站过磅成功";

    public static final String ADD_TRUCK_MBILL_SUC = "材料车出站过磅成功";

    /**
     * 错误码.
     */
    public static final int ERROR_CODE = 500;

    /**
     * 错误信息.
     */
    public static final String ERROR_MESSAGE = "内部异常";

    /**
     * 错误码：参数非法
     */
    public static final int ILLEGAL_ARGUMENT_CODE_ = 400;

    /**
     * 错误信息：参数非法
     */
    public static final String ILLEGAL_ARGUMENT_MESSAGE = "参数非法";

    //未登录
    public static final int UNLOGIN = 401;

    public static final String UNLOGIN_MESSAGE = "未登录或会话过期";
    //无访问权限
    public static final int NO_ACCESS = 403;

    public static final String NO_ACCESS_MESSAGE = "无访问权限";

    private Integer status;

    private String message;

    private T data;

    public R() {
    }

    public R(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public R(T data) {
        this.status = 200;
        this.message = "ok";
        this.data = data;
    }


    public static <T> R<T> ok(T data) {
        return new R<>(data);
    }

    public static <T> R<T> error(T data) {
        return new R(ERROR_CODE, ERROR_MESSAGE, data);
    }

    public static <T> R<T> error() {
        return new R(ERROR_CODE, ERROR_MESSAGE, "");
    }

    public static R ok() {
        return new R(null);
    }

    public static R okMsg(String message) {
        return new R(SUCCESS_CODE, message, null);
    }

    public static R build(Integer status, String message) {
        return new R(status, message, null);
    }

    public static R error(String message) {
        return new R(ERROR_CODE, message, null);
    }

    public static R parmError(String message) {
        return new R(ILLEGAL_ARGUMENT_CODE_, message, null);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
