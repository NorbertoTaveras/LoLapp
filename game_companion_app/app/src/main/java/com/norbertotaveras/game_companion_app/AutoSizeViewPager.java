package com.norbertotaveras.game_companion_app;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Norberto Taveras on 12/7/2017.
 */

public class AutoSizeViewPager extends ViewPager {
    public AutoSizeViewPager(Context context) {
        super(context);
    }

    public AutoSizeViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        for(int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec,
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int h = child.getMeasuredHeight();
            if(h > height) height = h;
        }

        if (height != 0) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        }

        if (heightMeasureSpec < 0)
            heightMeasureSpec = 200;

        Log.v("AutoSizeViewPager", "Height=" + String.valueOf(heightMeasureSpec));

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
