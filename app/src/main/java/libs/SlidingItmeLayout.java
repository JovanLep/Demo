package libs;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.IllegalFormatException;

/**
 * Created by android on 2017/10/26.
 */

public class SlidingItmeLayout extends FrameLayout {
    private View contentView;
    private View functionView;
    private int horizontalDX;
    private SlidingType slidingType = SlidingType.Right;
    private SlidingStates slidingStates = SlidingStates.Close;
    private boolean isMove=false;


    //定义滑动位置
    public enum SlidingType {
        Left, Right
    }

    /*
    定义滑动状态
     */
    public enum SlidingStates {
        Open, Close, Sliding
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                isMove=true;

                break;
            case MotionEvent.ACTION_MOVE:
                if (isMove) {

                }

                break;
            case MotionEvent.ACTION_UP:
                isMove=false;

                break;
        }

        return super.onTouchEvent(event);
    }

    public SlidingItmeLayout(@NonNull Context context) {
        super(context);
    }

    public SlidingItmeLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    //加载布局
    private void initView() {
        //抛异常 不能让他通过
        if (getChildCount() != 2) {
            throw new IllegalArgumentException("子视图不让通过");
        }
        functionView = getChildAt(1);
        contentView = getChildAt(0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        horizontalDX = functionView.getMeasuredWidth();
    }
//    定义滑动视图摆放onLayout


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
//        具体摆放
        layoutView(false);
    }

    private void layoutView(boolean isOpen) {

        Rect contentRect = layoutContentView(isOpen);
        contentView.layout(contentRect.left,contentRect.top,contentRect.right,contentRect.bottom);

        Rect functionRect = layoutFouctionView(isOpen,contentRect);
        functionView.layout(functionRect.left,functionRect.top,functionRect.right,functionRect.bottom);
    }

    private Rect layoutContentView(boolean isOpen) {
        int left = 0;
//        打开状态
        if (isOpen) {
            if (slidingType == SlidingType.Left) {
//            功能视图在左边
                left = horizontalDX;
//                return new Rect(horizontalDX,0,left+getMeasuredWidth()+horizontalDX,getMeasuredHeight());
            } else {
//            功能视图在右边
                left = -horizontalDX;
//                return new Rect(-horizontalDX,0,left+getMeasuredWidth()-horizontalDX,getMeasuredHeight());
            }
        }
//        6.2.3摆放contentView的关闭状态
        return new Rect(left, 0, left + getMeasuredWidth(), getMeasuredHeight());
    }

    private Rect layoutFouctionView(boolean isOpen, Rect rect) {
        int left = 0;
//        根据类型来摆放
        if (isOpen) {
//            打开
            if (slidingType == SlidingType.Right) {
                left = getMeasuredWidth() - horizontalDX;
            } else if (slidingType == SlidingType.Left) {
                left = 0;
            }
        } else {
//关闭
            if (slidingType == SlidingType.Right) {
//            left=left+getMeasuredWidth()-horizontalDX;
                left = rect.right;
            } else if(slidingType==SlidingType.Left){
                left = -horizontalDX;
            }
        }
        return new Rect(left, 0, left + horizontalDX, functionView.getMeasuredHeight());
    }
}
