package com.example.animation;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by 建刚 on 2014/12/20.
 */
public class Animator extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animator);




    }

    public void clickvalueanimator(View view){
        final Button button = (Button) view;
        ValueAnimator animator = ValueAnimator.ofInt(0, 100);
        animator.setDuration(5000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                button.setText(""+value);
            }
        });
        animator.start();

    }

    public void offobject(View view){
        //通过泛型获得想要改变的结果类型
        ValueAnimator animator = ValueAnimator.ofObject(new TypeEvaluator<PointF>() {
            /**
             *
              * @param fraction 时间因子 0~1之间变化
             * @param startValue
             * @param endValue
             * @return
             */
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                return null;
            }
        });
    }





    public void click(View v){
        ObjectAnimator animator = ObjectAnimator.ofFloat(v,"alpha",0f,1f);
        animator.setDuration(1000);
//        animator.addListener(new android.animation.Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(android.animation.Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(android.animation.Animator animation) {
//                Toast.makeText(Animator.this,"anim end",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationCancel(android.animation.Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(android.animation.Animator animation) {
//
//            }
//        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(android.animation.Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(Animator.this,"anim end",Toast.LENGTH_SHORT).show();

            }
        });
        animator.start();


    }

}
