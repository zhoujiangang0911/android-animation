package com.example.animation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 建刚 on 2014/12/20.
 */
public class AnimatorMenuActivity extends Activity implements View.OnClickListener{

    private int[] res ={R.id.imageView7,R.id.imageView2,R.id.imageView3,
            R.id.imageView4,R.id.imageView5,R.id.imageView6,R.id.imageView1};
    private List<ImageView> imageViewsList= new ArrayList<ImageView>();
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example);

        for (int i = 0; i <res.length ; i++) {
            ImageView imageView = (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            imageViewsList.add(imageView);
        }
        


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView7:
                if (flag) {
                    startAnim();
                }else {
                    closeAnim();
                }

                break;
             default:
                 Toast.makeText(this,"click"+v.getId(),Toast.LENGTH_SHORT).show();
                    break;
        }
    }

    private void closeAnim() {
        for (int i = 1; i <res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewsList.get(i),
                    "translationY",i*50f,0f
            );
            animator.setDuration(500);
            animator.setInterpolator(new BounceInterpolator());//差值期 线性加速 自由落体
            animator.setStartDelay(i*300);
            animator.start();
            flag = true;
        }


    }

    private void startAnim() {
        for (int i = 1; i <res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewsList.get(i),
                    "translationY",0f,i*50f
                    );
            animator.setDuration(500);
            animator.setInterpolator(new BounceInterpolator());//差值期 线性加速 自由落体
            animator.setStartDelay(i*300);
            animator.start();
            flag = false;
        }


    }
}
