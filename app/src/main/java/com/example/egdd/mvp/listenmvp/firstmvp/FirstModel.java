package com.example.egdd.mvp.listenmvp.firstmvp;

import com.example.egdd.http.HttpCallBack;
import com.example.egdd.http.listenhttp.Firsthttp.FirstCollBack;
import com.example.egdd.http.listenhttp.Firsthttp.ListenBottomBean;
import com.example.egdd.http.listenhttp.Firsthttp.ListenImageBean;
import com.example.egdd.http.listenhttp.Firsthttp.ZhongBean;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.mvplibrary.model.BaseModel;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FirstModel implements BaseModel {
    public void getDemo(FirstCollBack collBack, LifecycleProvider lifeCycle) {
        HashMap<String, Object> zhongMap = new HashMap<>();
        zhongMap.put("channel", "original");
        new HttpClient.Builder()
                .get()
                .setLifecycleProvider(lifeCycle)
                .setApiUrl("audio_playlists/excellent")
                .setParamser(zhongMap)
                .build()
                .request(new HttpCallBack<List<ZhongBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        collBack.fild(message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<ZhongBean> zhongBeans) {
                        getBottom(zhongBeans, collBack, lifeCycle);
                    }

                    @Override
                    public List<ZhongBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, ZhongBean.class);
                    }
                });

    }

    private void getBottom(List<ZhongBean> zhongBeans, FirstCollBack collBack, LifecycleProvider lifeCycle) {
        HashMap<String, Object> zhongMap = new HashMap<>();
        zhongMap.put("channel", "original");
        new HttpClient.Builder()
                .get()
                .setLifecycleProvider(lifeCycle)
                .setApiUrl("audio_categories")
                .setParamser(zhongMap)
                .build()
                .request(new HttpCallBack<List<ListenBottomBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        collBack.fild(message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<ListenBottomBean> bottomBeans) {
                        getImage((ArrayList<ZhongBean>) zhongBeans, (ArrayList<ListenBottomBean>) bottomBeans, collBack, lifeCycle);
                    }

                    @Override
                    public List<ListenBottomBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, ListenBottomBean.class);
                    }
                });
    }

    private void getImage(ArrayList<ZhongBean> zhongBeans, ArrayList<ListenBottomBean> bottomBeans, FirstCollBack collBack, LifecycleProvider lifeCycle) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("types","promotion_audio_banner");
        HashMap<String, Object> head = new HashMap<>();
        head.put("Authorization","ergedd_android:Android");
        new HttpClient.Builder()
                .get()
                .setLifecycleProvider(lifeCycle)
                .setHeadres(head)
                .setApiUrl("app_configs")
                .setParamser(map)
                .build()
                .request(new HttpCallBack<List<ListenImageBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        collBack.fild(message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<ListenImageBean> imageBean) {
                        collBack.succeed(zhongBeans,bottomBeans, (ArrayList<ListenImageBean>) imageBean);
                    }

                    @Override
                    public List<ListenImageBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, ListenImageBean.class);
                    }
                });
    }
}
