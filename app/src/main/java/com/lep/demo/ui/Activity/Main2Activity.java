package com.lep.demo.ui.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lep.demo.R;
import com.lep.demo.baseView.MyTextView;
/*
打字机效果
 */

public class Main2Activity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private MyTextView myTextView;
    private String[] love = {
            "          深秋\n" +
                    "      本宝宝\n" +
                    "一秋枯叶随风，\n" +
                    "满城黄金遍地。\n" +
                    "已有北风刺骨，\n" +
                    "亦存牵挂暖秋。",

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    //    初始化控件 添加点击开始打印事件
    private void initView() {

        button = (Button) findViewById(R.id.main2_bt);
        myTextView = (MyTextView) findViewById(R.id.main2_tv);
        myTextView.setTextColor(Color.RED);
        editText = (EditText) findViewById(R.id.main2_edit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                myTextView.setTextColor(R.color.colorRed);
                for (int i = 0; i < love.length; i++) {
                    myTextView.start(love[i]);
                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
