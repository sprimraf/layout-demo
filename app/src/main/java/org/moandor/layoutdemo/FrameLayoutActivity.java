package org.moandor.layoutdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class FrameLayoutActivity extends AppCompatActivity {
    private static final int[] COLORS = new int[]{
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6,
    };

    private static final int[] NAMES = new int[]{
            R.id.view01,
            R.id.view02,
            R.id.view03,
            R.id.view04,
            R.id.view05,
            R.id.view06,
    };

    private int mCurrentColor = 0;
    private TextView[] mViews = new TextView[NAMES.length];

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                for (int i = 0; i < NAMES.length; i++) {
                    mViews[i].setBackgroundResource(COLORS[(i + mCurrentColor) % NAMES.length]);
                }
                ++mCurrentColor;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        for (int i = 0; i < NAMES.length; i++) {
            mViews[i] = findViewById(NAMES[i]);
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(0x123);
            }
        }, 0, 300);
    }
}
