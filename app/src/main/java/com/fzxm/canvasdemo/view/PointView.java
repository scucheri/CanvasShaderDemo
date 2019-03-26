package com.fzxm.canvasdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zxm on 2017/7/12 0012.
 * url: https://developer.android.com/reference/android/graphics/Canvas.html
 */

public class PointView extends View {
    public PointView(Context context) {
        super(context);
    }

    public PointView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        //设置颜色
        paint.setColor(getResources().getColor(android.R.color.black));
        //点大小
        paint.setStrokeWidth(20);
        //绘制圆形点
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(50,50,paint);

        //绘制方形点
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(50,100,paint);

        //绘制一组点(第0个参数开始绘制8个参数即4个点 )
        paint.setStrokeCap(Paint.Cap.ROUND);
        float[] points = {50,150,50,200,100,150,100,200};
        canvas.drawPoints(points,0,8,paint);

    }
}
