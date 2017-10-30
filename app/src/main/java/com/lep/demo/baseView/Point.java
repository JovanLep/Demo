package com.lep.demo.baseView;

/**
 * Created by android on 2017/10/29.
 */

public class Point {
    //    定义两个变量保存x，y值
    public float x, y;
    //    定义点的状态
    public static final int STATE_NOMAL = 0;
    public static final int STATE_RIGHT = 1;
    public static final int STATE_ERROR = 2;

    int state = STATE_NOMAL;

    //    定义构造函数
    public Point(float x, float y) {
        this.x = x;
        this.y = y;

    }

    public float distance(Point a) {
        float dispoint = (float) (Math.sqrt((x - a.x)*(x - a.x)) + Math.sqrt((y - a.y)*(y - a.y)));
        return dispoint;
    }


}
