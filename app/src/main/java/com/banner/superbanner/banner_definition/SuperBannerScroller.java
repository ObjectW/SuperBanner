package com.banner.superbanner.banner_definition;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class SuperBannerScroller extends Scroller {
    private int mScrollDuration; //切换动画时长
    private static final Interpolator sInterpolator = new Interpolator() {
        @Override
        public float getInterpolation(float t) {
            t -= 1.0f;
            return t * t * t * t * t + 1.0f;
        }
    };
    public boolean noDuration;

    public void setNoDuration(boolean noDuration) {
        this.noDuration = noDuration;
    }

    public void setScrollDuration(int  scrollDuration) {
        this.mScrollDuration = scrollDuration;
    }

    public SuperBannerScroller(Context context) {
        this(context, sInterpolator);
    }

    public SuperBannerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        if (noDuration) {
            //不需要时间间隔
            super.startScroll(startX, startY, dx, dy, 0);
        } else {
            super.startScroll(startX, startY, dx, dy, mScrollDuration);
        }
    }
}
