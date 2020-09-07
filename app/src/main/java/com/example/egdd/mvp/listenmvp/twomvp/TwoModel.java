package com.example.egdd.mvp.listenmvp.twomvp;

import com.example.egdd.http.HttpCallBack;
import com.example.egdd.http.listenhttp.Twohttp.TwoBean;
import com.example.egdd.http.listenhttp.Twohttp.TwoCollback;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.mvplibrary.model.BaseModel;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoModel implements BaseModel {
    public void getDemo(int id, TwoCollback collback, LifecycleProvider lifeCycle) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("channel","new");
        map.put("offset","0");
        map.put("limit","20");
        new HttpClient.Builder()
                .get()
                .setApiUrl("audio_categories/"+id+"/playlists")
                .setParamser(map)
                .setLifecycleProvider(lifeCycle)
                .build()
                .request(new HttpCallBack<List<TwoBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        collback.fild(message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<TwoBean> twoBeans) {
                        collback.succeed((ArrayList<TwoBean>) twoBeans);
                    }

                    @Override
                    public List<TwoBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result,TwoBean.class);
                    }
                });
    }
}
