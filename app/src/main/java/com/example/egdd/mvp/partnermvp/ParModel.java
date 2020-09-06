package com.example.egdd.mvp.partnermvp;

import com.example.egdd.http.HttpCallBack;
import com.example.egdd.http.partnerhttp.ParCollBack;
import com.example.egdd.http.partnerhttp.PartnerDemo;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.mvplibrary.model.BaseModel;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

public class ParModel implements BaseModel {
    public void getDemo(ParCollBack collBack, LifecycleProvider lifeCycle) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("types","brand_area");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Authorization","ergedd_android:Android");
        new HttpClient.Builder()
                .setApiUrl("app_configs")
                .get()
                .setLifecycleProvider(lifeCycle)
                .setParamser(map)
                .setHeadres(hashMap)
                .build()
                .request(new HttpCallBack<List<PartnerDemo>>() {
                    @Override
                    public void onError(String message, int code) {
                        collBack.fild(message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<PartnerDemo> list) {
                        collBack.succeed(list);
                    }

                    @Override
                    public List<PartnerDemo> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result,PartnerDemo.class);
                    }
                });

    }
}
