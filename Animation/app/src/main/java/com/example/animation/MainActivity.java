package com.example.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Animator.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AnimatorMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    public void click(View view){
        Toast.makeText(this,"click",Toast.LENGTH_LONG).show();

    }


    public void move(View view){
//        TranslateAnimation animation = new TranslateAnimation(0,200,0,0);
//        animation.setDuration(1000);
//        animation.setFillAfter(true);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
//        imageView.startAnimation(animation);
//        ObjectAnimator.ofFloat(imageView,"rotation",0F,360F).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView,"translationX",0F,360F).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView,"translationY",0F,360F).setDuration(1000).start();

//        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("rotation",0F,360F);
//        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationX",0F,200F);
//        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("translationY",0F,200F);
//        ObjectAnimator.ofPropertyValuesHolder(imageView,p1,p2,p3).setDuration(1000).start();

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView,"rotation",0F,360F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView,"translationX",0F,360F);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView,"translationY",0F,360F);
        AnimatorSet set = new AnimatorSet();
        set.play(animator2).with(animator3);
        set.play(animator1).after(animator2);
//        set.playSequentially(animator1,animator2,animator3);
        set.setDuration(1000);
        set.start();
    }
}
