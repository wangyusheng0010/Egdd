package com.example.egdd.http.listenhttp;

import java.util.List;

public class ZhongBean {
    /**
     * id : 276
     * name : 巴塔木儿歌
     * count : 79
     * image : http://img5g22.ergedd.com/audio_playlist/77294775510_1493795959461.jpg
     * description : 打造学习英语新途径，最萌动感儿歌，最完美英汉结合，宝宝轻松磨耳朵。
     * square_image_url : http://img5g22.ergedd.com/audio_playlist/46991113358_1565692098349.jpg
     * sensitive : 0
     * watch_areas : ["1"]
     * free : 5
     * cost : 0
     * price : 0
     * expires_at : null
     * vip_price : 0
     */

    private int id;
    private String name;
    private int count;
    private String image;
    private String description;
    private String square_image_url;
    private int sensitive;
    private int free;
    private int cost;
    private int price;
    private Object expires_at;
    private int vip_price;
    private List<String> watch_areas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSquare_image_url() {
        return square_image_url;
    }

    public void setSquare_image_url(String square_image_url) {
        this.square_image_url = square_image_url;
    }

    public int getSensitive() {
        return sensitive;
    }

    public void setSensitive(int sensitive) {
        this.sensitive = sensitive;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Object getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Object expires_at) {
        this.expires_at = expires_at;
    }

    public int getVip_price() {
        return vip_price;
    }

    public void setVip_price(int vip_price) {
        this.vip_price = vip_price;
    }

    public List<String> getWatch_areas() {
        return watch_areas;
    }

    public void setWatch_areas(List<String> watch_areas) {
        this.watch_areas = watch_areas;
    }
}
