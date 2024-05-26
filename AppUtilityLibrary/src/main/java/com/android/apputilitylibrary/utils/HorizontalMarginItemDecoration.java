package com.android.apputilitylibrary.utils;

import android.content.Context;

import androidx.annotation.DimenRes;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalMarginItemDecoration extends RecyclerView.ItemDecoration {

    Context context;
    int horizontalMarginInDp;

    public HorizontalMarginItemDecoration(Context context, @DimenRes int horizontalMarginInDp) {
        this.context = context;
        this.horizontalMarginInDp = horizontalMarginInDp;
    }
}
