package com.demo.video.animdemo;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CenterActivity extends AppCompatActivity {
    public static final int STARTUP_DELAY = 300; // 启动延迟
    public static final int ANIM_ITEM_DURATION = 1000;
    public static final int ITEM_DELAY = 300;

    @Bind(R.id.onboard_ll_container) LinearLayout mLlContainer;
    @Bind(R.id.onboard_iv_logo) ImageView mIvLogo;
    @Bind(R.id.onboard_b_choice_1) Button mBChoice1;
    @Bind(R.id.onboard_b_choice_2) Button mBChoice2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);
        ButterKnife.bind(this);

        ViewCompat.animate(mIvLogo)
                .translationY(-300)
                .setStartDelay(STARTUP_DELAY)
                .setDuration(ANIM_ITEM_DURATION)
                .setInterpolator(new DecelerateInterpolator(1.2f))
                .start();

        for(int i = 0 ; i < mLlContainer.getChildCount(); i++){
            View v = mLlContainer.getChildAt(i);
            ViewPropertyAnimatorCompat viewAnimator;
            if(!(v instanceof Button)){
                viewAnimator = ViewCompat.animate(v);
                viewAnimator.translationY(50)
                        .alpha(1)
                        .setStartDelay((ITEM_DELAY * i) + 500)
                        .setDuration(ANIM_ITEM_DURATION);
            }else {
                viewAnimator = ViewCompat.animate(v);
                viewAnimator.scaleX(1)
                        .scaleY(1)
                        .setStartDelay((ITEM_DELAY * i) + 500)
                        .setDuration(ANIM_ITEM_DURATION / 2);
            }

            viewAnimator.setInterpolator(new DecelerateInterpolator()).start();
        }

        mBChoice1.setOnClickListener(v -> Toast.makeText(getApplicationContext(),"test teest test",Toast.LENGTH_SHORT).show());
        mBChoice2.setOnClickListener(v -> onBackPressed());
    }
}
