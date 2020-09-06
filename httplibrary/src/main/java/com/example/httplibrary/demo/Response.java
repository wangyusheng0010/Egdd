package com.example.httplibrary.demo;

import com.google.gson.JsonElement;

import java.io.Serializable;

/**
 * 项目名：Shopping
 * 包名：  com.example.liangxq.shopping.app
 * 文件名：Response
 * 创建者：liangxq
 * 创建时间：2020/8/1  14:58
 * 描述：TODO
 */
public class Response {
    private JsonElement data;
    private int status;
    private String message;

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }

    public int getErrorCode() {
        return status;
    }

    public void setErrorCode(int errorCode) {
        this.status = errorCode;
    }

    public String getErrorMsg() {
        return message;
    }

    public void setErrorMsg(String errorMsg) {
        this.message = errorMsg;
    }
}
