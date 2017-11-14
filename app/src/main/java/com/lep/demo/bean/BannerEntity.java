package com.lep.demo.bean;

import java.util.List;

/**
 * Created by android on 2017/10/28.
 * http://news-at.zhihu.com/api/4/news/latest
 * 轮播图实体类
 */

public class BannerEntity {
    /**
     * date : 20171028
     * stories : [{"title":"在英国湖区，寻找彼得兔的创作者","ga_prefix":"102819","images":["https://pic1.zhimg.com/v2-0575db3963d40cbd90007e164140a8f8.jpg"],"multipic":true,"type":0,"id":9653704},{"title":"电台六声「滴」的报时是怎么发明的？在这里你能找到答案","ga_prefix":"102818","images":["https://pic1.zhimg.com/v2-43db731d4873530d25d8246de2559d2c.jpg"],"multipic":true,"type":0,"id":9653397},{"images":["https://pic1.zhimg.com/v2-2a3b36f77a679a66af3122f869c61cf4.jpg"],"type":0,"id":9654348,"ga_prefix":"102817","title":"人们永远记不住第二名，六年无冠的 Uzi，今年会捧起奖杯吗？"},{"images":["https://pic4.zhimg.com/v2-10ad3d8d009d0380298384e599268a63.jpg"],"type":0,"id":9654237,"ga_prefix":"102816","title":"你以为我知道，可其实我不知道，多少误解就是这么来的"},{"images":["https://pic1.zhimg.com/v2-854ddd8d7bea969f386025e301efaf48.jpg"],"type":0,"id":9654125,"ga_prefix":"102815","title":"这位种草莓的大叔，当年是与朴树齐名的歌手"},{"images":["https://pic3.zhimg.com/v2-776fe302836a4d4e95c30d784d6be806.jpg"],"type":0,"id":9654321,"ga_prefix":"102814","title":"被「左右脑年龄测试」刷了屏，可它到底不科学在哪？"},{"images":["https://pic2.zhimg.com/v2-8942cd52145f51d8f40606400f267a25.jpg"],"type":0,"id":9654313,"ga_prefix":"102813","title":"一道独立佳肴、踢馆大厨的主菜，说的就是它了，西班牙海鲜饭"},{"images":["https://pic2.zhimg.com/v2-e6f25794a9dd7e569a260e36ace4ccd1.jpg"],"type":0,"id":9654300,"ga_prefix":"102812","title":"大误 · 来吧，以子之矛，陷子之盾"},{"images":["https://pic2.zhimg.com/v2-f5805fdd93e9bbe7b0ada38212f16489.jpg"],"type":0,"id":9654127,"ga_prefix":"102811","title":"为什么大脑主要利用葡萄糖供能，而心肌 60%-70% 供能来自脂肪？"},{"images":["https://pic3.zhimg.com/v2-73b604070ecd45f60e0f48cf425a00da.jpg"],"type":0,"id":9653472,"ga_prefix":"102810","title":"严肃地讨论下，高速护栏为什么要做成「大波浪」"},{"images":["https://pic2.zhimg.com/v2-f98f8905797ed4e6617397a6977b669d.jpg"],"type":0,"id":9653960,"ga_prefix":"102809","title":"像《悲惨世界》这种音乐剧，学校社团公开排演算侵权吗？"},{"images":["https://pic1.zhimg.com/v2-1308c4ddbf9b50c5b26ea7c9884f9ac4.jpg"],"type":0,"id":9654157,"ga_prefix":"102808","title":"换一波「新时代」家用电器，让你的小确幸爆棚"},{"images":["https://pic4.zhimg.com/v2-fe80273fe3d9d9d2bdfc39e69e1f0be3.jpg"],"type":0,"id":9654014,"ga_prefix":"102807","title":"古人很早就玩剑，日本剑道却先出了名，其实并不意外"},{"title":"看《银翼杀手 2049》之前，先看看这篇文章","ga_prefix":"102807","images":["https://pic2.zhimg.com/v2-d0dd179c7e382adf2e3bb50fece77079.jpg"],"multipic":true,"type":0,"id":9654072},{"images":["https://pic2.zhimg.com/v2-2ea19defc2d1e86372a3407f8baa8b6d.jpg"],"type":0,"id":9654002,"ga_prefix":"102807","title":"未来 10~20 年，有几个行业可能会变得很惹眼"},{"images":["https://pic1.zhimg.com/v2-8f9b6719fc3c1528540298cd9dc4f138.jpg"],"type":0,"id":9653792,"ga_prefix":"102806","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic4.zhimg.com/v2-b2cf07001478aa6a71b086be580b982b.jpg","type":0,"id":9653704,"ga_prefix":"102819","title":"在英国湖区，寻找彼得兔的创作者"},{"image":"https://pic1.zhimg.com/v2-ed387c33ec5d7ccb88fef3fc2d673d64.jpg","type":0,"id":9654348,"ga_prefix":"102817","title":"人们永远记不住第二名，六年无冠的 Uzi，今年会捧起奖杯吗？"},{"image":"https://pic4.zhimg.com/v2-8bd42154fb1f61591e36887315b99a2b.jpg","type":0,"id":9654125,"ga_prefix":"102815","title":"这位种草莓的大叔，当年是与朴树齐名的歌手"},{"image":"https://pic3.zhimg.com/v2-60faf72dca8229eff95445c9cb703df6.jpg","type":0,"id":9654321,"ga_prefix":"102814","title":"被「左右脑年龄测试」刷了屏，可它到底不科学在哪？"},{"image":"https://pic3.zhimg.com/v2-ba5750d9f672f1481e52fea8af07681a.jpg","type":0,"id":9654237,"ga_prefix":"102816","title":"你以为我知道，可其实我不知道，多少误解就是这么来的"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }


    public static class StoriesBean {
        /**
         * title : 在英国湖区，寻找彼得兔的创作者
         * ga_prefix : 102819
         * images : ["https://pic1.zhimg.com/v2-0575db3963d40cbd90007e164140a8f8.jpg"]
         * multipic : true
         * type : 0
         * id : 9653704
         */

        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private List<String> images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic4.zhimg.com/v2-b2cf07001478aa6a71b086be580b982b.jpg
         * type : 0
         * id : 9653704
         * ga_prefix : 102819
         * title : 在英国湖区，寻找彼得兔的创作者
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
