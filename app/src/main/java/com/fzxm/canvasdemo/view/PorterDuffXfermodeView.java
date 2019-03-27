package com.fzxm.canvasdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.fzxm.canvasdemo.R;

public class PorterDuffXfermodeView extends View {

    public PorterDuffXfermodeView(Context context) {
        super(context);
    }

    public PorterDuffXfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PorterDuffXfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PorterDuffXfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    // https://blog.csdn.net/iispring/article/details/50472485
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
         Paint paint = new Paint();
        //设置背景色
        //canvas.drawARGB(255, 139, 197, 186);
        //int canvasWidth = canvas.getWidth();
        //int r = canvasWidth / 3;
        ////绘制黄色的圆形
        //paint.setColor(0xFFFFCC44);
        //canvas.drawCircle(r, r, r, paint);
        ////绘制蓝色的矩形
        //paint.setColor(0xFF66AAFF);
        //canvas.drawRect(r, r, r * 2.7f, r * 2.7f, paint);


        ////设置背景色
        //canvas.drawARGB(255, 139, 197, 186);
        //int canvasWidth = canvas.getWidth();
        //int r = canvasWidth / 3;
        ////正常绘制黄色的圆形
        //paint.setColor(0xFFFFCC44);
        //canvas.drawCircle(r, r, r, paint);
        ////使用CLEAR作为PorterDuffXfermode绘制蓝色的矩形
        //paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        ////本例中的Xfermode是PorterDuff.Mode.CLEAR，该规则比较简单粗暴，直接要求目标像素的ARGB四个分量全置为0，即(0，0，0，0)，即透明色，所以我们通过canvas.drawRect()在Canvas上绘制了一个透明的矩形，由于Activity本身屏幕的背景时白色的，所以此处就显示了一个白色的矩形。
        //paint.setColor(0xFF66AAFF);
        //canvas.drawRect(r, r, r * 2.7f, r * 2.7f, paint);
        ////最后将画笔去除Xfermode
        //paint.setXfermode(null);

        //设置背景色
        //canvas.drawARGB(255, 139, 197, 186);
        //int canvasWidth = canvas.getWidth();
        //int canvasHeight = canvas.getHeight();
        //int layerId = canvas.saveLayer(0, 0, canvasWidth, canvasHeight, null, Canvas.ALL_SAVE_FLAG);
        //int r = canvasWidth / 3;
        ////正常绘制黄色的圆形
        //paint.setColor(0xFFFFCC44);
        //canvas.drawCircle(r, r, r, paint);
        ////使用CLEAR作为PorterDuffXfermode绘制蓝色的矩形
        //paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));// clear 到背景颜色那一层
        //paint.setColor(0xFF66AAFF);
        //canvas.drawRect(r, r, r * 2.7f, r * 2.7f, paint);
        ////最后将画笔去除Xfermode
        //paint.setXfermode(null);
        //canvas.restoreToCount(layerId);


        //设置背景色
        //canvas.drawARGB(255, 139, 197, 186);
        //int canvasWidth = canvas.getWidth();
        //int canvasHeight = canvas.getHeight();
        //int layerId = canvas.saveLayer(0, 0, canvasWidth, canvasHeight, null, Canvas.ALL_SAVE_FLAG);
        //int r = canvasWidth / 5;
        ////正常绘制黄色的圆形
        //paint.setColor(0xFFFFCC44);
        //canvas.drawCircle(r, r, r, paint);
        ////使用CLEAR作为PorterDuffXfermode绘制蓝色的矩形
        //paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));// clear 到背景颜色那一层
        //paint.setColor(0xFF66AAFF);
        //canvas.drawCircle(r*3f-50, r, r , paint);
        ////最后将画笔去除Xfermode
        //paint.setXfermode(null);
        //canvas.restoreToCount(layerId);

        //设置背景色
        canvas.drawARGB(255, 139, 197, 186);
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        int layerId = canvas.saveLayer(0, 0, canvasWidth, canvasHeight, null, Canvas.ALL_SAVE_FLAG);
        int r = canvasWidth / 2;
        //正常绘制黄色的圆形
        paint.setColor(0xFFFFCC44);
        Bitmap bitmap = Bitmap.createBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.xihu));
        bitmap = scaleBitmap(bitmap,2*r,2*r);
        BitmapShader bitmapShader = new BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        paint.setShader(bitmapShader);
        canvas.drawCircle(r, r, r, paint);
        //使用CLEAR作为PorterDuffXfermode绘制蓝色的矩形
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));// clear 到背景颜色那一层
        //paint.setColor(0xFF66AAFF);
        canvas.drawCircle(r*3f-50, r, r , paint);
        //最后将画笔去除Xfermode
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);
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
