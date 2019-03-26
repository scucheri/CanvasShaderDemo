package com.fzxm.canvasdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zxm on 2017/7/12 0012.
 * url: https://developer.android.com/reference/android/graphics/Canvas.html
 */

public class PathView extends View {
    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        //设置颜色
        paint.setColor(getResources().getColor(android.R.color.holo_red_light));
        Path path = new Path();
        //画心形
        RectF rectF = new RectF(200,200,400,400);
        path.addArc(rectF,-225,225);
        RectF rectF2 = new RectF(400,200,600,400);
        path.arcTo(rectF2,-180,225,false);
        path.lineTo(400,542);
        canvas.drawPath(path,paint);

        /*//画三角形(未封闭)
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        path.moveTo(200,600);
        path.lineTo(400,600);
        path.lineTo(300,700);
        canvas.drawPath(path,paint);
        //画三角形(封闭)
        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(500,600);
        path.lineTo(700,600);
        path.lineTo(600,700);
        path.close();
        canvas.drawPath(path,paint);*/

        //画三角形(填充)
        paint.setStyle(Paint.Style.FILL);
        path.moveTo(200,800);
        path.lineTo(400,800);
        path.lineTo(300,900);
        canvas.drawPath(path,paint);

        //
    }
}
