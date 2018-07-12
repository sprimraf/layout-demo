package org.moandor.layoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Class<?> cls = null;
            switch (view.getId()) {
                case R.id.button_linear_layout:
                    cls = LinearLayoutActivity.class;
                    break;
                case R.id.button_linear_layout_right_center:
                    cls = LinearLayoutRightCenterActivity.class;
                    break;
                case R.id.button_table_layout:
                    cls = TableLayoutActivity.class;
                    break;
                case R.id.button_frame_layout:
                    cls = FrameLayoutActivity.class;
                    break;
                case R.id.button_relative_layout:
                    cls = RelativeLayoutActivity.class;
                    break;
                case R.id.button_grid_layout:
                    cls = GridLayoutActivity.class;
                    break;
            }
            startActivity(new Intent(MainActivity.this, cls));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_linear_layout).setOnClickListener(mOnClickListener);
        findViewById(R.id.button_linear_layout_right_center).setOnClickListener(mOnClickListener);
        findViewById(R.id.button_table_layout).setOnClickListener(mOnClickListener);
        findViewById(R.id.button_frame_layout).setOnClickListener(mOnClickListener);
        findViewById(R.id.button_relative_layout).setOnClickListener(mOnClickListener);
        findViewById(R.id.button_grid_layout).setOnClickListener(mOnClickListener);
    }
}
