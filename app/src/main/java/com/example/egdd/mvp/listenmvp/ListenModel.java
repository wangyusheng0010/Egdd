package com.example.egdd.mvp.listenmvp;

import com.example.egdd.http.HttpCallBack;
import com.example.egdd.http.listenhttp.ListenBean;
import com.example.egdd.http.listenhttp.ListenCollBack;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.mvplibrary.model.BaseModel;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

public class ListenModel implements BaseModel {

    public void getTab(ListenCollBack collBack, LifecycleProvider lifeCycle) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("channel","original");
        new HttpClient.Builder()
                .get()
                .setApiUrl("audio_categories")
                .setParamser(map)
                .setLifecycleProvider(lifeCycle)
                .build()
                .request(new HttpCallBack<List<ListenBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        collBack.fild(message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<ListenBean> listenBeans) {
                        collBack.succeed(listenBeans);
                    }

                    @Override
                    public List<ListenBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result,ListenBean.class);
                    }
                });
    }
}
