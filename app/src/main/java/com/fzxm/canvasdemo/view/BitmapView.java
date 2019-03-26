package com.fzxm.canvasdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.fzxm.canvasdemo.R;

/**
 * Created by zxm on 2017/7/12 0012.
 * url: https://developer.android.com/reference/android/graphics/Canvas.html
 */

public class BitmapView extends View {
    public BitmapView(Context context) {
        super(context);
    }

    public BitmapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BitmapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        //paint.setColor(getResources().getColor(android.R.color.white));
        //抗锯齿
        paint.setAntiAlias(true);
        //画圆
        //paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
        canvas.drawBitmap(bitmap,200,200,paint);




    }
}
