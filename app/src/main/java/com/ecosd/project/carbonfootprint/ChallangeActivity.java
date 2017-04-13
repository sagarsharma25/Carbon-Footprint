package com.ecosd.project.carbonfootprint;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.ecosd.project.carbonfootprint.Others.PrefManager;

/**
 * Created by this pc on 12-04-17.
 */

public class ChallangeActivity extends AppCompatActivity {

    TextView score,alternative,challange_score;
    Toolbar toolbar;
    PrefManager prefManager;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challange);
        prefManager=new PrefManager(getApplicationContext());
        toolbar=(Toolbar)findViewById(R.id.ch_toolbar);
        toolbar.setTitle(getString(R.string.Challange));
        toolbar.setTitleTextColor(Color.WHITE);
        score=(TextView)findViewById(R.id.score);
        challange_score=(TextView)findViewById(R.id.challange_score);
        alternative=(TextView)findViewById(R.id.alternativeb);
        startCountAnimation();
        startCountAnimation2();
        alternative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChallangeActivity.this,Alternatives.class));
            }
        });
    }

    private void startCountAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, Float.parseFloat(prefManager.getAnswer()));
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                score.setText(animation.getAnimatedValue().toString());
            }
        });
        animator.start();
    }

    private void startCountAnimation2() {
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, Float.parseFloat(prefManager.getAnswer())-10.2f);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                challange_score.setText(animation.getAnimatedValue().toString());
            }
        });
        animator.start();
    }
}
