package com.fzxm.canvasdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void circle(View v){
        startActivity(new Intent(this,CircleActivity.class));
    }
    public void rect(View v){
        startActivity(new Intent(this,RectActivity.class));
    }
    public void roundRect(View v){
        startActivity(new Intent(this,RoundRectActivity.class));
    }
    public void arc(View v){startActivity(new Intent(this,ArcActivity.class));}
    public void oval(View v){
        startActivity(new Intent(this,OvalActivity.class));
    }
    public void text(View v){
        startActivity(new Intent(this,TextActivity.class));
    }
    public void point(View v){
        startActivity(new Intent(this,PointActivity.class));
    }
    public void line(View v){
        startActivity(new Intent(this,LineActivity.class));
    }
    public void path(View v){
        startActivity(new Intent(this,PathActivity.class));
    }
    public void bitmap(View v){
        startActivity(new Intent(this,BitmapActivity.class));
    }
    public void shader(View v){
        startActivity(new Intent(this,ShaderActivity.class));
    }
    public void porterDuff(View v){
        startActivity(new Intent(this,PorterDuffXfermodeActivity.class));
    }
    public void roundRectImage(View v){
        startActivity(new Intent(this,RoundRectImageActivity.class));
    }
    public void composeShader(View v){
        startActivity(new Intent(this,ComposeShaderActivity.class));
    }
    public void waveView(View v){
        startActivity(new Intent(this,WaveViewActivity.class));
    }
    public void rotateImage(View v){
        startActivity(new Intent(this,RotateImageActivity.class));
    }
    public void testLottie(View v){
        startActivity(new Intent(this,TestLottieActivity.class));
    }

}
