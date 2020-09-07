package com.example.egdd.mvp.videomvp;

import com.example.egdd.http.HttpCallBack;
import com.example.egdd.http.videohttp.VideoBean;
import com.example.egdd.http.videohttp.VideoCallBack;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.mvplibrary.model.BaseModel;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ASUS
 * <p>
 * Date :2020/9/7
 * <p>
 * name :Fanyajun
 * <p>
 * Description :T0D0
 */
public class VideoModel implements BaseModel {

    public void getDatas(VideoCallBack callBack, LifecycleProvider lifeCycle, int id) {
        HashMap<String, Object> map = new HashMap();
        map.put("channel","new");
        map.put("offset","0");
        map.put("limit","20");
        map.put("sensitive","8");
        map.put("code","110114");
        map.put("adtype","2");
        map.put("ret","video");
        new HttpClient.Builder()
                .setApiUrl("albums/"+id+"/videos?")
                .setParamser(map)
                .setLifecycleProvider(lifeCycle)
                .get()
                .build()
                .request(new HttpCallBack<List<VideoBean>>() {

                    @Override
                    public void onError(String message, int code) {
                        callBack.showLog(message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<VideoBean> videoBeans) {
                            callBack.videoShowok(videoBeans);
                    }

                    @Override
                    public List<VideoBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result,VideoBean.class);
                    }
                });
    }
}
