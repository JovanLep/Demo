package com.lep.demo.baseView;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.lep.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 2017/11/5.
 */

public class GameView extends GridLayout {
    private TextView mGameScoreTv;
    private GameView mGameGv;
//    二维数组记录方阵
    private  Card[][] cardMap=new Card[4][4];

//    定义集合保存卡片位置
    private List<Point> cardPointList=new ArrayList<>();

    public GameView(Context context) {
        super(context);
        initView();
    }


    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mGameScoreTv = (TextView) findViewById(R.id.game_score_tv);
        mGameGv = (GameView) findViewById(R.id.game_gv);
//        定义卡片列数
        setColumnCount(4);
        setBackgroundColor(Color.parseColor("#red"));

//        通过判断用户按下和离开的位置判断意图

        setOnTouchListener(new OnTouchListener() {
            //            3.1定义按下，离开坐标
            private float startX, startY, offsetX, offsetY;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
//                        记录按下位置
                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_UP:
//                        记录xy偏移量的位置,判断手势方向
                        offsetX = motionEvent.getX() - startX;
                        offsetY = motionEvent.getY() - startY;
//                        横向
                        if (Math.abs(offsetX) > Math.abs(offsetY)) {
//                            左边
                            if (offsetX < -5) {
                                swipeLeft();
//                            右边
                            } else if (offsetX > 5) {
                                swipeRight();
                            }
//                        纵向
                        } else {
//                            上
                            if (offsetY < -5) {
                                swipeTop();
//                             下
                            } else if (offsetY > 5) {
                                swipeBottom();
                            }
                        }
                        break;
                }
                return true;
            }
        });
    }
//    动态计算卡片宽高 屏幕适配


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
//        求出卡片宽高 -10图形边缘10像素
        int cardwidth=(Math.min(w,h)-10)/4;
        addcards(cardwidth,cardwidth);

        startGame();
    }
//    添加卡片方法
    private void addcards(int cardwidth,int cardheight){
        Card c;

//        外出循环4列 内层循环4行
        for (int y = 0; y <4 ; y++) {
            for (int x = 0; x <4 ; x++) {
               c=new Card(getContext());
//                c.setNum=0;
//                addView(c,cardwidth,cardheight);
//                记录下卡片
                cardMap[x][y]=c;
            }
        }
    }

//    添加卡片随机数
    private void addRandomNum(int num){
        cardPointList.clear();
//        开始对所以卡片遍历
        for (int y = 0; y <4 ; y++) {
            for (int x = 0; x <4 ; x++) {

//                判断是否为空
//                if(cardPointList[x][y].getNum()<=0){
//                    cardPointList.add(new Point(x,y));
//                }
            }
        }
        Point p=cardPointList.remove((int)Math.random()*cardPointList.size());
//        cardPointList[p.x][p.y].setNum(Math.random()>0.1?2:4);

    }

    private void startGame(){
        cardPointList.clear();

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
//                cardPointList[x][y].setNum(0);
            }
        }
//            添加两个数字2,4
        addRandomNum(2);
        addRandomNum(4);
    }


    private void swipeLeft() {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
//                从当前位置往右遍历
                for (int x1 = x+1; x1<4 ; x1++) {
//                    if(cardPointList[x1][y].getNum()>0){


//                    }
                }
            }
        }
    }

    private void swipeRight() {
    }

    private void swipeTop() {
    }

    private void swipeBottom() {
    }
}
