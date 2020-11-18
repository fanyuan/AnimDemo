package com.demo.video.animdemo.animators;

import android.support.v7.widget.RecyclerView;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by 剑出利刃寒 on 2019/1/24.
 */

public class ItemAnimatorFactory {
    static public RecyclerView.ItemAnimator slidein(){
        SlideInUpDelayedAnimator animator = new SlideInUpDelayedAnimator(new DecelerateInterpolator());
        animator.setAddDuration(600);
        return animator;
    }
}
