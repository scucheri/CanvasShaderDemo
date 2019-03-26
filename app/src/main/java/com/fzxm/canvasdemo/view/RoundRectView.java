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

public class RoundRectView extends View {
    public RoundRectView(Context context) {
        super(context);
    }

    public RoundRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundRectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        //设置颜色
        paint.setColor(getResources().getColor(android.R.color.holo_blue_light));

        //绘制普通圆角矩形
        RectF rectF = new RectF(100,100,300,300);
        canvas.drawRoundRect(rectF,20,20,paint);

        //空心模式
        paint.setStyle(Paint.Style.STROKE);
        //设置空心边框的宽度
        paint.setStrokeWidth(10);
        //绘制空心圆角矩形
        RectF rectF2 = new RectF(100,500,700,900);
        canvas.drawRoundRect(rectF2,30,30,paint);
    }
}
