package com.lep.demo.ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lep.demo.R;
import com.lep.demo.baseView.MyTextView;
/*
打字机效果
 */

public class Main2Activity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private MyTextView myTextView;

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
        editText = (EditText) findViewById(R.id.main2_edit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                myTextView.setTextColor(R.color.colorRed);
                myTextView.start(str);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
