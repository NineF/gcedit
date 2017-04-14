package com.glovec.gcedit.ui.flash;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class FlashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                luanchApp();
            }
        },2000);


    }

    private void luanchApp(){
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("gcedit://login"));
        startActivity(intent);
        FlashActivity.this.finish();
    }

}
