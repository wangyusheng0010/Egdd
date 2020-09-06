package com.example.egdd.http;

import android.util.Log;

import com.example.egdd.http.Response;
import com.example.httplibrary.callback.BaseCallBack;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * 项目名：Shopping
 * 包名：  com.example.httplibrary.callback
 * 文件名：HttpCallBack
 * 创建者：liangxq
 * 创建时间：2020/8/3  14:29
 * 描述：TODO
 * <p>
 * 示例
 */
public abstract class HttpCallBack<T> extends BaseCallBack<T> {
    Response response;
    @Override
    protected T onConvert(String result) {
        T t=null;
        response = new Gson().fromJson(result, Response.class);
        JsonElement data = response.getData();
        boolean code = response.isSuccess();
        String errorMsg = response.getMessage();
        int errorCode;
        if (code){
            errorCode = 0;
        }else {
            errorCode = -1;
        }
        switch (errorCode) {
            case -1:
                onError(errorMsg,errorCode);
                break;
            default:
                if (isCodeSuccess()) {
                    t=convert(data);
                }
                break;
        }
        Log.e("wangys", "onConvert: "+t.toString() );
        return t;
    }


    @Override
    public boolean isCodeSuccess() {
        if (response != null) {
            return response.isSuccess();
        }
        return false;
    }

}
