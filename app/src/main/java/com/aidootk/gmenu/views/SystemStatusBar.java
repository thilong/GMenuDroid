package com.aidootk.gmenu.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.aidootk.gmenu.droid.R;

public class SystemStatusBar extends LinearLayout {
    public SystemStatusBar(Context context) {
        super(context);
        initView();
    }

    public SystemStatusBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SystemStatusBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.getContext()).inflate(R.layout.view_system_status_bar, this);
    }
}
