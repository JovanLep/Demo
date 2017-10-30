package com.lep.demo.model;

/**
 * Created by android on 2017/10/28.
 */

public class MainModel{


    public static interface OnColorCallBackListener{
        public void OnColor();
    }
    private OnColorCallBackListener onColorCallBackListener;

    public void setOnColorCallBackListener(OnColorCallBackListener onColorCallBackListener) {
        this.onColorCallBackListener = onColorCallBackListener;
    }


}
