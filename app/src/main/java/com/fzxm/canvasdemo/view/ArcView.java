package com.fzxm.canvasdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zxm on 2017/7/12 0012.
 * url: https://developer.android.com/reference/android/graphics/Canvas.html
 */

public class ArcView extends View {
    public ArcView(Context context) {
        super(context);
    }

    public ArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        //设置颜色
        paint.setColor(getResources().getColor(android.R.color.holo_orange_light));
        RectF rectF = new RectF(100,100,300,300);
        //绘制实心圆弧
        canvas.drawArc(rectF,0,270,false,paint);

        RectF rectF2 = new RectF(100,400,300,600);
        //实心圆弧 连接圆心
        canvas.drawArc(rectF2,0,270,true,paint);

        //空心模式
        paint.setStyle(Paint.Style.STROKE);
        //设置空心边框的宽度
        paint.setStrokeWidth(10);

        //绘制空心圆弧
        RectF rectF3 = new RectF(100,700,300,900);
        canvas.drawArc(rectF3,0,250,false,paint);

        //绘制空心圆弧 连接圆心
        RectF rectF4 = new RectF(400,700,600,900);
        canvas.drawArc(rectF4,0,250,true,paint);
    }
}
