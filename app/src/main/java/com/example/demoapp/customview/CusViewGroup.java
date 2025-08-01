package com.example.demoapp.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

class CusViewGroup extends ViewGroup {

    private static final String TAG = "CusViewGroup";

    public CusViewGroup(Context context) {
        super(context);
    }

    public CusViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CusViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CusViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private String getMode(int mode) {
        String ret = null;
        switch (mode) {
            case MeasureSpec.AT_MOST:
                ret = "MeasureSpec.AT_MOST";
                break;
            case MeasureSpec.EXACTLY:
                ret = "MeasureSpec.EXACTLY";
                break;
            case MeasureSpec.UNSPECIFIED:
                ret = "MeasureSpec.UNSPECIFIED";
                break;
        }

        return ret;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //测量该ViewGroup中的所有子View，会触发子view的onMeasure函数。如果不执行该方法，则下面计算子view的大小都为0；

        // 1.
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        Log.d(TAG, "onMeasure: widthMode: " + getMode(widthMode) + ", width: " + width);

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            int groupWidth = getMaxChildWidth(getChildCount());
            int groupHeight = getTotalHeight(getChildCount());

            setMeasuredDimension(groupWidth, groupHeight);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(getMaxChildWidth(getChildCount()), height);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width, getTotalHeight(getChildCount()));
        } else {
            setMeasuredDimension(width,height);
        }
    }

    /**
     * 获得子view的最大宽度
     *
     * @param childCount
     * @return
     */
    private int getMaxChildWidth(int childCount) {
        int maxWidth = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getMeasuredWidth() > maxWidth) {
                maxWidth = childView.getMeasuredWidth();
            }
        }
        return maxWidth;
    }

    /**
     * 获得子view的高度之和
     *
     * @param childCount
     * @return
     */
    private int getTotalHeight(int childCount) {
        int height = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            height += childView.getMeasuredHeight();
        }
        return height;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        int currentHeight = 0;
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            int height = view.getMeasuredHeight();
            int width = view.getMeasuredWidth();
            view.layout(l, currentHeight, l + width, currentHeight + height);
            currentHeight += height;
        }
    }
}
