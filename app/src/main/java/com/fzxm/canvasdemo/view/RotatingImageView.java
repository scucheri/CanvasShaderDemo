package com.fzxm.canvasdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.fzxm.canvasdemo.R;

public class RotatingImageView extends AppCompatImageView {

  private int rotationDegrees = 0;
  private float scale;
  private int directionScale;

  public RotatingImageView(Context context) {
    super(context);
    init();
  }

  public RotatingImageView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public RotatingImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }


  private void init() {
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xihu);
    setImageBitmap(bitmap);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    canvas.translate(canvas.getWidth()/2, canvas.getHeight()/2);
    canvas.rotate(rotation(3));
    float scaleFactor = scale(0.01f);
    canvas.scale(scaleFactor, scaleFactor);
    canvas.translate(-canvas.getWidth()/2, -canvas.getHeight()/2);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
      postInvalidate();
      //postInvalidateOnAnimation();

      // 每一次ondraw由vsync信号在chreometer的doframe中唤起，
      // 然后🈶又重新将invalidate事件post到cheographer的回调队列中，
      // 这样的话，就会循环执行ondraw，频率与vsync信号一样，60fps
    }
    super.onDraw(canvas);
  }

  private float scale(float delta) {
    scale = (scale + delta * directionScale);
    if (scale <= 0) {
      directionScale = 1;
      scale = 0;
    } else if (scale >= 1) {
      directionScale = -1;
      scale = 1;
    }
    return scale;
  }

  private int rotation(int delta) {
    rotationDegrees = (rotationDegrees + delta) % 360;
    return rotationDegrees;
  }
}