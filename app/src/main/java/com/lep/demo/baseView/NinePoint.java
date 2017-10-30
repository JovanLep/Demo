package com.lep.demo.baseView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.lep.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 2017/10/29.
 */

public class NinePoint extends View {
    private Point[][] points = new Point[3][3];
    //    定义一个标记，初始化
    private boolean flag = false;
    private Bitmap RightBit;
    private Bitmap NormalBit;
    private Bitmap ErrorBit;

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint paintlineRight=new Paint();
    private Paint paintlineError=new Paint();

    //    修改图形的位置
    private float bitMapR;
    private float mouseX, mouseY;
//    定义标记，标记判断是否是绘制状态
    private boolean isDraw=false;
//    定义一个集合保存状态
    private List<Point> list=new ArrayList<>();

    public NinePoint(Context context) {
        super(context);
    }

    public NinePoint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NinePoint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        设置触摸位置
        mouseX = event.getX();
        mouseY = event.getY();
        int[] ij;
        int i,j;
//        判断状态
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

//                处理触摸事件 是否按在点上
                ij=getSelectPoint();
                if (ij!=null) {
//                    是否处于绘制状态
                    isDraw=true;
                    i=ij[0];
                    j=ij[1];
//                    修改状态
                    points[i][j].state=Point.STATE_RIGHT;
//                    把点添加到集合中
                    list.add(points[i][j]);
                }
                break;
            case MotionEvent.ACTION_MOVE:

                if (isDraw) {
                    ij=getSelectPoint();
                    if(ij!=null){
                        i=ij[0];
                        j=ij[1];

                        if (!list.contains(points[i][j])){
                            points[i][j].state=Point.STATE_RIGHT;
                            list.add(points[i][j]);
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                isDraw=false;
                break;
        }
        this.postInvalidate();
        return true;
    }

//    获取点击的位置
    private int[] getSelectPoint(){
//        点击位置生成点坐标
        Point pmouse=new Point(mouseX,mouseY);
        for (int i = 0; i <points.length ; i++) {
            for (int j = 0; j <points[i].length ; j++) {
                if(points[i][j].distance(pmouse)<bitMapR){
//                    有效的手势动作
                    int[] result=new int[3];
                    result[0]=i;
                    result[1]=j;
                    return  result;
                }
            }
        }
//        不存在返回null
        return null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!flag) {
            initNinePoint();
        }
        drawPoint(canvas);
//        先判断是否有点
        if(list.size()>0){
//            定义一个变量
            Point a=list.get(0);
            for (int i = 1; i < list.size(); i++) {
//                绘制一条两点之间的线
                Point b=list.get(i);
                drawline(a,b,canvas);
//                从末尾点从新计算
                a=b;
            }
            if (isDraw) {
                drawline(a,new Point(mouseX,mouseY),canvas);
            }
        }
    }
//    划线
    private void drawline(Point a,Point b,Canvas canvas){
        if(a.state==Point.STATE_RIGHT){
//            绘制线
            canvas.drawLine(a.x,a.y,b.x,b.y,paintlineRight);
        }else{
            canvas.drawLine(a.x,a.y,b.x,b.y,paintlineError);
        }

    }

    private void initNinePoint() {
        paintlineRight.setColor(Color.BLUE);
        paintlineRight.setStrokeWidth(8);
        paintlineError.setColor(Color.RED);
        paintlineError.setStrokeWidth(8);

        NormalBit = BitmapFactory.decodeResource(getResources(), R.mipmap.normalbit);
        RightBit = BitmapFactory.decodeResource(getResources(), R.mipmap.rightbit);
        ErrorBit = BitmapFactory.decodeResource(getResources(), R.mipmap.errorbit);
//        每张图的半径
        bitMapR=NormalBit.getHeight()/2;

//        定义宽高和矩形
        int widthPoint = getWidth();
        int heightPoint = getHeight();
        int offSet = Math.abs(widthPoint - heightPoint)/2;

        int space;

        int offSetX, offSetY;
        if (widthPoint > heightPoint) {
//            横屏
            offSetX = offSet;
            offSetY = 0;
//小方格赋值
            space = heightPoint / 4;

        } else {
//            竖屏
            offSetY = offSet;
            offSetX = 0;
            space = widthPoint / 4;
        }
        points[0][0] = new Point(offSetX + space, offSetY + space);
        points[0][1] = new Point(offSetX + space * 2, offSetY + space);
        points[0][2] = new Point(offSetX + space * 3, offSetY + space);

        points[1][0] = new Point(offSetX + space, offSetY + space * 2);
        points[1][1] = new Point(offSetX + space * 2, offSetY + space * 2);
        points[1][2] = new Point(offSetX + space * 3, offSetY + space * 2);

        points[2][0] = new Point(offSetX + space, offSetY + space * 3);
        points[2][1] = new Point(offSetX + space * 2, offSetY + space * 3);
        points[2][2] = new Point(offSetX + space * 3, offSetY + space * 3);
//        防止无限循环
        flag = true;

    }

    //    将点绘制到画布上
    private void drawPoint(Canvas canvas) {

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
//                判断当前状态
                if (points[i][j].state == Point.STATE_NOMAL) {
//                    正常状态
                    canvas.drawBitmap(NormalBit, points[i][j].x-bitMapR, points[i][j].y-bitMapR, paint);


                } else if (points[i][j].state == Point.STATE_RIGHT) {
//                    按下状态
                     canvas.drawBitmap(RightBit, points[i][j].x-bitMapR, points[i][j].y-bitMapR, paint);
                } else {
//                    错误状态
                   canvas.drawBitmap(ErrorBit, points[i][j].x-bitMapR, points[i][j].y-bitMapR, paint);
                }
            }
        }
    }

}
