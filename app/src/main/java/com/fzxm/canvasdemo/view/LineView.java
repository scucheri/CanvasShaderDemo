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

public class LineView extends View {
    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        //设置颜色
        paint.setColor(getResources().getColor(android.R.color.holo_red_dark));
        paint.setStrokeWidth(20);
        //画一条线
        canvas.drawLine(50,50,200,50,paint);
        //画一组线
        float[] points = {100,100,300,100,300,100,300,300,
                300,300,100,300,100,300,100,500,100,500,300,500,300,500,300,700,300,700,100,700,
                300,400,600,400,400,100,400,700,400,400,600,100,400,400,650,650,400,700,600,700};
        canvas.drawLines(points,paint);
    }
}
