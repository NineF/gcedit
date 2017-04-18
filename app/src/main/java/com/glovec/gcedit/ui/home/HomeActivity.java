package com.glovec.gcedit.ui.home;

import android.app.TabActivity;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TabHost;

import com.glovec.gcedit.R;
import com.glovec.gcedit.ui.base.BaseActivity;

public class HomeActivity extends BaseActivity implements TabHost.OnTabChangeListener {
    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tabHost= (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

    }

    @Override
    public void onTabChanged(String s) {

    }
}
