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

public class TextView extends View {
    public TextView(Context context) {
        super(context);
    }

    public TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        //设置大小
        paint.setTextSize(100);
        //绘制普通文本
        canvas.drawText("zxm",100,300,paint);
        canvas.drawText("军师联盟",100,500,paint);
    }
}
