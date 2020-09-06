package com.example.egdd.mvp.lookmvp;

import com.example.egdd.http.HttpCallBack;
import com.example.egdd.http.lookhttp.LookCollBack;
import com.example.egdd.http.lookhttp.LookDemo;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.mvplibrary.model.BaseModel;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

public class LookModel implements BaseModel {

    public void getTab(LifecycleProvider lifeCycle, LookCollBack collBack) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("offset","0");
        map.put("limit","100");
        map.put("addition_album_count","20");
        map.put("channel","new");
        new HttpClient.Builder()
                .setLifecycleProvider(lifeCycle)
                .setApiUrl("album_categories")
                .setParamser(map)
                .get()
                .build()
                .request(new HttpCallBack<List<LookDemo>>() {
                    @Override
                    public void onError(String message, int code) {
                        collBack.fild(message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<LookDemo> lookDemos) {
                        collBack.succeed(lookDemos);
                    }

                    @Override
                    public List<LookDemo> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result,LookDemo.class);
                    }
                });
    }
}
