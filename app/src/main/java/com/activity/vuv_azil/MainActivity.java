package com.activity.vuv_azil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        method();
    }

    private void method() {
        TextView tv1 = (TextView)findViewById(R.id.btnPIA);
        tv1.setText("zivotinja");
    }
}