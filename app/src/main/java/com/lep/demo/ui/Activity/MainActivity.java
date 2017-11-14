package com.lep.demo.ui.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;

import com.lep.demo.R;
import com.lep.demo.adapter.SlidingListAdapter;
import com.lep.demo.bean.BannerDate;

import com.lep.demo.retrofit.BannerService;
import com.lep.demo.utils.UrlUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private ConvenientBanner convenientBanner;
    private List<BannerDate.DataBean> list;
    private List<String> slidinglist=new ArrayList();
    private ImageView bannerimag;
    private ListView slidingLvNormal;
    private SlidingListAdapter slidingListAdapterNormal;


    private String[] testDate={"aaa","bbb"};
    private String  TAG="MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getQuest();
        Log.d(TAG, "onCreate: 11");
        initview();
    }

    private void initview() {
        list = new ArrayList<>();

        for (int i = 0; i <testDate.length ; i++) {
            slidinglist.add(testDate[i]);
        }

        Log.d(TAG, "initview: 22");


        convenientBanner = (ConvenientBanner) findViewById(R.id.main_banner);

        slidingLvNormal= (ListView) findViewById(R.id.main_SlidingList_normal);
        slidingListAdapterNormal=new SlidingListAdapter(this,slidinglist);
        slidingLvNormal.setAdapter(slidingListAdapterNormal);




        //        跳转打字机
        findViewById(R.id.main_tobt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        //        跳转九宫格
        findViewById(R.id.main_ninePoint_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NinePointActivity.class);
                startActivity(intent);
            }
        });

    }

    public void getQuest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlUtils.baseUrl)
//                构建一个gson转化器
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
//        动态代理
        BannerService serve = retrofit.create(BannerService.class);

        serve.getBanner()
                .subscribeOn(Schedulers.io())
//               拿到io线程的返回数据到主线程处理
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerDate>() {
                    @Override
                    public void onCompleted() {
//                       完成订阅
                        convenientBanner.setPages(new CBViewHolderCreator() {
                            @Override
                            public Object createHolder() {
                                return new MyViewholder();
                            }
                        }, list)
                                //设置指示器是否可见
                                //设置自动切换（同时设置了切换时间间隔）
                                .startTurning(2000)
                                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                                .setPageIndicator(new int[]{R.mipmap.point, R.mipmap.pointred})
////                                //设置指示器的方向（左、中、右）
//                                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                                //设置点击监听事件
                                .setPointViewVisible(true)
//                                .setOnItemClickListener((OnItemClickListener) MainActivity.this)
                                //设置手动影响（设置了该项无法手动切换）
//                                .setManualPageable(false)
                        //设置翻页的效果，不需要翻页效果可用不设
//                        setPageTransformer(Transformer.DefaultTransformer)   // 集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
                        ;
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BannerDate bannerDate) {
                        list.addAll(bannerDate.getData());
                    }


                });
    }

    private class MyViewholder implements Holder<BannerDate.DataBean> {

        @Override
        public View createView(Context context) {
            bannerimag = new ImageView(context);
            bannerimag.setScaleType(ImageView.ScaleType.FIT_XY);
            return bannerimag;
        }

        @Override
        public void UpdateUI(Context context, int position, BannerDate.DataBean data) {
            //            加载Banner图片
            Glide.with(context)
                    .load(data.getImageUrl())
                    .into(bannerimag);
        }
    }
}
