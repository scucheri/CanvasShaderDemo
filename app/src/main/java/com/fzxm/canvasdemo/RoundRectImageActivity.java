package com.fzxm.canvasdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.fzxm.canvasdemo.view.RoundRectImageView;

public class RoundRectImageActivity extends AppCompatActivity {
    private RoundRectImageView roundRectImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_rect_image);
        roundRectImageView = (RoundRectImageView) findViewById(R.id.round_rect_image);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bitmap bitmap = Bitmap.createBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.xihu));
        roundRectImageView.setBitmap(bitmap);
    }
}