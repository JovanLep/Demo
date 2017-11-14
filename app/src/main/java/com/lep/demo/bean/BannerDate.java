package com.lep.demo.bean;

import java.util.List;

/**
 * Created by android on 2017/11/14.
 */

public class BannerDate {

    /**
     * retCode : 00000
     * retInfo : 操作成功
     * data : [{"pauseTime":4,"linkAddr":"http://resource.haier.net/download/oms/bangding/index.html?from=singlemessage","source":5,"checkLogin":0,"imageName":"绑定送1000海贝-1130","imageUrl":"http://oss.haier.net/mall/picture/20171109145938.jpg","isShare":1}]
     */

    private String retCode;
    private String retInfo;
    private List<DataBean> data;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * pauseTime : 4
         * linkAddr : http://resource.haier.net/download/oms/bangding/index.html?from=singlemessage
         * source : 5
         * checkLogin : 0
         * imageName : 绑定送1000海贝-1130
         * imageUrl : http://oss.haier.net/mall/picture/20171109145938.jpg
         * isShare : 1
         */

        private int pauseTime;
        private String linkAddr;
        private int source;
        private int checkLogin;
        private String imageName;
        private String imageUrl;
        private int isShare;

        public int getPauseTime() {
            return pauseTime;
        }

        public void setPauseTime(int pauseTime) {
            this.pauseTime = pauseTime;
        }

        public String getLinkAddr() {
            return linkAddr;
        }

        public void setLinkAddr(String linkAddr) {
            this.linkAddr = linkAddr;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getCheckLogin() {
            return checkLogin;
        }

        public void setCheckLogin(int checkLogin) {
            this.checkLogin = checkLogin;
        }

        public String getImageName() {
            return imageName;
        }

        public void setImageName(String imageName) {
            this.imageName = imageName;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getIsShare() {
            return isShare;
        }

        public void setIsShare(int isShare) {
            this.isShare = isShare;
        }
    }
}
