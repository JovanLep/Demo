package com.lep.demo.ui.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lep.demo.R;
import com.lep.demo.utils.BaseUtils;

import java.util.Timer;
import java.util.TimerTask;


public class LoadingActivity extends AppCompatActivity implements View.OnClickListener {
    private int intentTime = 5999;
    private LinearLayout TimeLinear;
    private TextView TimeTv;
    Timer timer = new Timer();

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    TimeTv.setText(BaseUtils.secToTime(intentTime));
                    if(intentTime<=0){
                        timerTask.cancel();
                        intentActivity();
                    }
                    break;
            }
        }
    };

    TimerTask timerTask=new TimerTask() {
        @Override
        public void run() {
            intentTime--;
            Message message=new Message();
            message.what=1;
            handler.sendMessage(message);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        init();
    }

    //    初始化数据
    private void init() {
        TimeLinear = (LinearLayout) findViewById(R.id.loadtime_ll);
        TimeTv = (TextView) findViewById(R.id.loadtime_tv);
        TimeLinear.setOnClickListener(this);
        timer.schedule(timerTask, 500, 10);
    }

    private void intentActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loadtime_ll:
                intentActivity();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.finish();
    }
}
