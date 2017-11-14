package com.lep.demo.model;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * Created by android on 2017/10/28.
 */

public class MainModel {


    public interface OnColorCallBackListener {
        public void OnColor();
    }

    private OnColorCallBackListener onColorCallBackListener;

    public void setOnColorCallBackListener(OnColorCallBackListener onColorCallBackListener) {
        this.onColorCallBackListener = onColorCallBackListener;
    }


}
