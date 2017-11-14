package com.lep.demo.ui.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lep.demo.R;
import com.lep.demo.bean.PersonUser;

public class SuanMActivity extends AppCompatActivity {
    private EditText mSuanmNameEdt;
    private EditText mSuanmAgeEdt;
    private CheckBox mSuanmCb;
    private RadioButton mSuanmMan;
    private RadioButton mSuanmWoman;
    private RadioButton mSuanmSex;
    private Button mSuanmStart;
    private RadioGroup mSuanmRg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suan_m);
        initView();
    }
//初始化控件
    private void initView() {
        mSuanmNameEdt = (EditText) findViewById(R.id.suanm_name_edt);
        mSuanmAgeEdt = (EditText) findViewById(R.id.suanm_age_edt);
        mSuanmCb = (CheckBox) findViewById(R.id.suanm_cb);
        mSuanmMan = (RadioButton) findViewById(R.id.suanm_man);
        mSuanmWoman = (RadioButton) findViewById(R.id.suanm_woman);
        mSuanmSex = (RadioButton) findViewById(R.id.suanm_sex);
        mSuanmStart = (Button) findViewById(R.id.suanm_start);
        mSuanmRg = (RadioGroup) findViewById(R.id.suanm_rg);


    }
    private void getMsg(){
        String suanmName = mSuanmNameEdt.getText().toString();
        String suanmAge = mSuanmAgeEdt.getText().toString();
        boolean isChecked = mSuanmCb.isChecked();

//        PersonUser personUser=new PersonUser(suanmName,suanmAge,isChecked);
//
//        Intent intent=new Intent(this,SuanResultActivity.class);
//        Bundle bundle=new Bundle();
//        bundle.putSerializable("person",personUser);
//        intent.putExtra();
//        startActivity(intent);

    }
}
