package com.example.egdd.mvp.choimvp;

import com.example.egdd.http.HttpCallBack;
import com.example.egdd.http.choihttp.ChoiBottomDemo;
import com.example.egdd.http.choihttp.ChoiCenterDemo;
import com.example.egdd.http.choihttp.ChoiCollBack;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.mvplibrary.model.BaseModel;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

public class ChoiModel implements BaseModel {
    public void getDemo(ChoiCollBack collBack, LifecycleProvider lifeCycle) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("channel","new");
        map.put("offset","0");
        map.put("limit","16");
        new HttpClient.Builder()
                .get()
                .setLifecycleProvider(lifeCycle)
                .setApiUrl("albums/home_recommended")
                .setParamser(map)
                .build()
                .request(new HttpCallBack<List<ChoiCenterDemo>>() {
                    @Override
                    public void onError(String message, int code) {
                        collBack.fild("这是中间"+message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<ChoiCenterDemo> choiCenterDemos) {
                        initBottom(choiCenterDemos,lifeCycle,collBack);
                    }

                    @Override
                    public List<ChoiCenterDemo> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result,ChoiCenterDemo.class);
                    }
                });
    }

    private void initBottom(List<ChoiCenterDemo> choiCenterDemos, LifecycleProvider lifeCycle, ChoiCollBack collBack) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type","4");
        map.put("channel","new");
        map.put("offset","0");
        map.put("limit","20 ");
        map.put("sensitive","8");
        new HttpClient.Builder()
                .get()
                .setParamser(map)
                .setLifecycleProvider(lifeCycle)
                .setApiUrl("home_items")
                .build()
                .request(new HttpCallBack<List<ChoiBottomDemo>>() {
                    @Override
                    public void onError(String message, int code) {
                        collBack.fild("这是下面"+message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<ChoiBottomDemo> choiBottomDemos) {
                        collBack.succeed(choiCenterDemos,choiBottomDemos);
                    }

                    @Override
                    public List<ChoiBottomDemo> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result,ChoiBottomDemo.class);
                    }
                });
    }
}
