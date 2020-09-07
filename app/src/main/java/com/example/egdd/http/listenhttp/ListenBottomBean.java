package com.example.egdd.http.listenhttp;

import java.util.List;

public class ListenBottomBean {
    /**
     * id : 1
     * name : 儿歌
     * type : 1
     * image : http://img5g22.ergedd.com/slide/54446175068_1493797199844.png
     * description : 中文儿歌
     * sensitive : 0
     * playlists : [{"id":338,"name":"手指家族","count":31,"image":"http://img5g22.ergedd.com/audio_playlist/57346360551_1547461400473.jpg","description":"动动手指学英文，经典英文童谣Finger Family","square_image_url":"http://img5g22.ergedd.com/audio_playlist/17413388600_1547461404162.jpg","sensitive":0,"watch_areas":["1"],"free":5,"cost":0,"price":0,"expires_at":null,"vip_price":0},{"id":366,"name":"蓝迪儿歌","count":17,"image":"http://img5g22.ergedd.com/audio_playlist/75275868466_1565849918844.jpg","description":"让孩子在轻松活泼、富有节奏感的律动中感受音乐的魅力。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/58449575300_1565849921648.jpg","sensitive":0,"watch_areas":["1"],"free":5,"cost":0,"price":0,"expires_at":null,"vip_price":0},{"id":339,"name":"跟着小河马唱儿歌","count":30,"image":"http://img5g22.ergedd.com/audio_playlist/98335096936_1547541448246.jpg","description":"超好听的经典英文儿歌全在这儿","square_image_url":"http://img5g22.ergedd.com/audio_playlist/64426795367_1550764431554.jpg","sensitive":0,"watch_areas":["1"],"free":5,"cost":0,"price":0,"expires_at":null,"vip_price":0}]
     */

    private int id;
    private String name;
    private int type;
    private String image;
    private String description;
    private int sensitive;
    private List<PlaylistsBean> playlists;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public int getSensitive() {
        return sensitive;
    }

    public void setSensitive(int sensitive) {
        this.sensitive = sensitive;
    }

    public List<PlaylistsBean> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistsBean> playlists) {
        this.playlists = playlists;
    }

    public static class PlaylistsBean {
        /**
         * id : 338
         * name : 手指家族
         * count : 31
         * image : http://img5g22.ergedd.com/audio_playlist/57346360551_1547461400473.jpg
         * description : 动动手指学英文，经典英文童谣Finger Family
         * square_image_url : http://img5g22.ergedd.com/audio_playlist/17413388600_1547461404162.jpg
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
}
