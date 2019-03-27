package com.fzxm.canvasdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.fzxm.canvasdemo.R;

public class ComposeShaderView extends View {

    public ComposeShaderView(Context context) {
        super(context);
    }

    public ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    // https://blog.csdn.net/iispring/article/details/50472485
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 装载资源
        Bitmap mBitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.music)).getBitmap();
        // 得到宽高
        int bitwidth = mBitmap.getWidth();
        int bitheight = mBitmap.getHeight();
        // 创建BitmapShader对象
        BitmapShader mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        // 创建LinearGradient并设置渐变颜色数组,平铺效果为镜像
        LinearGradient mLinearGradient = new LinearGradient(0, 0, 0, 100, new int[] {
            Color.WHITE, Color.LTGRAY, Color.TRANSPARENT, Color.GREEN
        }, null, Shader.TileMode.MIRROR);

        // 混合渲染 将两个效果叠加,使用PorterDuff叠加模式
        ComposeShader mComposeShader = new ComposeShader(mBitmapShader, mLinearGradient, PorterDuff.Mode.DST_IN);
        Paint mPaint = new Paint();

        mPaint.setShader(mComposeShader);
        canvas.drawCircle(240, bitwidth/2, bitheight/2, mPaint);

    }



}
