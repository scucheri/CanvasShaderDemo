package com.fzxm.canvasdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import com.fzxm.canvasdemo.R;

public class RoundRectImageView extends View {
    private Bitmap mBitmap;
    private int cornerSizePx;

    public RoundRectImageView(Context context) {
        super(context);
    }

    public RoundRectImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initByAttrs(attrs);
    }

    public RoundRectImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initByAttrs(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RoundRectImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initByAttrs(attrs);
    }

    private void initByAttrs(AttributeSet attrs){
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.RoundRectImageViewStyle);
        cornerSizePx = (int) typedArray.getDimension(R.styleable.RoundRectImageViewStyle_cornerSize, 5);
    }

    public void setBitmap(Bitmap bitmap){
        this.mBitmap = bitmap;
        invalidate();
    }

    // https://blog.csdn.net/iispring/article/details/50472485
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
         Paint paint = new Paint();

         if(mBitmap != null) {
             //设置背景色
             //canvas.drawARGB(255, 139, 197, 186);
             int canvasWidth = canvas.getWidth();
             int canvasHeight = canvas.getHeight();
             int layerId = canvas.saveLayer(0, 0, canvasWidth, canvasHeight, null, Canvas.ALL_SAVE_FLAG);
             //根据图片生成bitmapshader
             //Bitmap bitmap = Bitmap.createBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.xihu));
             mBitmap = scaleBitmap(mBitmap, canvasWidth, canvasHeight);
             BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
             paint.setShader(bitmapShader);

             RectF rectF = new RectF(0, 0, canvasWidth, canvasHeight);
             canvas.drawRoundRect(rectF, cornerSizePx, cornerSizePx, paint);
         }
    }


    /**
     * 根据给定的宽和高进行拉伸
     *
     * @param origin    原图
     * @param newWidth  新图的宽
     * @param newHeight 新图的高
     * @return new Bitmap
     */
    private Bitmap scaleBitmap(Bitmap origin, int newWidth, int newHeight) {
        if (origin == null) {
            return null;
        }
        int height = origin.getHeight();
        int width = origin.getWidth();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);// 使用后乘
        Bitmap newBM = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);
        if (!origin.isRecycled()) {
            origin.recycle();
        }
        return newBM;
    }
}
