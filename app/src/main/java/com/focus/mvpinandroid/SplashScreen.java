package com.focus.mvpinandroid;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;

/**
 * Created by J.yugandhar on 14-06-2017.
 */

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LinearLayout layout =   new LinearLayout(getApplicationContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.WHITE);
        LinearLayout.LayoutParams params    =   new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.gravity  = Gravity.CENTER;
        layout.setLayoutParams(params);

        LottieAnimationView animationView   =   new LottieAnimationView(getApplicationContext());
        animationView.setAnimation("an_endless_hike_on_a_tiny_world_.json");
        animationView.setLayoutParams(params);
        animationView.loop(true);
        animationView.playAnimation();
        layout.addView(animationView);
        /// METHOD 1

        final String name_class = getPackageName()+".view.MainActivity";

        setContentView(layout);
        int TIME_OUT = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = null;
                try {
                    i = new Intent(getApplicationContext(), Class.forName(name_class));
                } catch (ClassNotFoundException e) {
                    Log.i("Exception    -->",""+e);
                    e.printStackTrace();
                }
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }
}
