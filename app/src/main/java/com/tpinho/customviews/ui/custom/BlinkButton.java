package com.tpinho.customviews.ui.custom;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * Created by tpinho on 1/4/16.
 */
public class BlinkButton extends AppCompatButton {

    private int times = 0;

    private OnClickListener onClickListener;

    public BlinkButton(Context context) {
        super(context);
        init();
    }

    public BlinkButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BlinkButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        super.setOnClickListener(view -> blink(view));
    }

    @Override
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    private void blink(final View view) {
        Animation alphaAnimation = new AlphaAnimation(1f, 0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(times);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(onClickListener != null)
                    onClickListener.onClick(view);
            }
        });
        startAnimation(alphaAnimation);
    }

}