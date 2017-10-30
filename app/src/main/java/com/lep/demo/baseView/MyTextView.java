package com.lep.demo.baseView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by android on 2017/10/28.
 * 打印机自定义view
 */

//第一步继承控件TextView
public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    private Context context;
    private String text;
    private Timer timer;
    String TAG="MyTextView";

    //    第二部设置打字时间
    private int mTypeTime = 80;

    //实现构造器
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //创建任务
    class TypeTimeTask extends TimerTask {

        //主线程更新ui
        @Override
        public void run() {
            post(new Runnable() {
                @Override
                public void run() {
//                    判断String长度打字
//                    首先TextView的字有多少个
//                    getText().toString().length()当前字长度
//                      text打印长度
                    if (getText().toString().length() < text.toString().length()) {
//                        当前字的长度 +  1 = 要打字的长度
                        int nowTextLength = getText().toString().length();
                        int nextTextLength = nowTextLength + 1;
//                        生成当前字符串的长度
                        String str = text.substring(0, nextTextLength);
                        setText(str);
//                        开启打字  和结束打字
                        StartInput();
                    } else {
//                        停止打字
                        EndInput();
                    }
                }
            });
        }
    }
    /*
    开始打字
     */

    private void StartInput() {
        timer = new Timer();
        timer.schedule(new TypeTimeTask(), mTypeTime);
    }
    /*
    停止打字
     */

    private void EndInput() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void start(final String strText){
        if(strText.length()<=0){
            return;
        }
        post(new Runnable() {
            @Override
            public void run() {
                setText("");
                text=strText;
                StartInput();
            }
        });
    }


}
