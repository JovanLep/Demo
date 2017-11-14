package com.lep.demo.ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lep.demo.R;

public class MobActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText intputEdit;
    private Button sendMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mob);
//        initView();

    }

//   1 初始化控件
    private void initView() {
        intputEdit= (EditText) findViewById(R.id.mob_edt);
        sendMsg= (Button) findViewById(R.id.mob_bt);
        intputEdit.setOnClickListener(this);
        sendMsg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mob_edt:
                String infoNum = intputEdit.getText().toString();


                break;

            case R.id.mob_bt:

                break;
        }

    }

//    生成4位随机验证码
    private void getnum(){

    }
}
