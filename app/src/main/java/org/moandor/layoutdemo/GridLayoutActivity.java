package org.moandor.layoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

public class GridLayoutActivity extends AppCompatActivity {
    private static final String[] CHARS = new String[]{
            "7", "8", "9", "÷",
            "4", "5", "6", "×",
            "1", "2", "3", "-",
            ".", "0", "=", "+",
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        GridLayout gridLayout = findViewById(R.id.root);
        for (int i = 0; i < CHARS.length; i++) {
            Button bn = new Button(this);
            bn.setText(CHARS[i]);
            bn.setTextSize(40);
            bn.setPadding(5, 35, 5, 35);
            GridLayout.Spec rowSpec = GridLayout.spec(i / 4 + 2);
            GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
            params.setGravity(Gravity.FILL);
            gridLayout.addView(bn, params);
        }
    }
}
