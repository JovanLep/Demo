package com.lep.demo.baseView;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by android on 2017/11/2.
 */

public class DoubleView extends View {
    public DoubleView(Context context) {
        super(context);
    }

    public DoubleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        initParams();
    }

    private void initParams(Context context) {
//getMeasuredHeight()
    }

//    定义初始化方法


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//消除点击误差
//        canvas.translate(0,dy);
    }
}
