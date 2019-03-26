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

public class OvalView extends View {
    public OvalView(Context context) {
        super(context);
    }

    public OvalView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OvalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        //设置颜色
        paint.setColor(getResources().getColor(android.R.color.holo_green_light));

        //绘制普通椭圆
        RectF rectF = new RectF(100,100,500,300);
        canvas.drawOval(rectF,paint);

        //空心模式
        paint.setStyle(Paint.Style.STROKE);
        //设置空心边框的宽度
        paint.setStrokeWidth(10);
        //绘制空心圆角椭圆
        RectF rectF2 = new RectF(100,600,500,800);
        canvas.drawOval(rectF2,paint);
    }
}
