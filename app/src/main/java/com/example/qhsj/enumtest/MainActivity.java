package com.example.qhsj.enumtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvClick;
    private TextView tvGoNext;

    //枚举作为常量
    enum Signal {
        GREEN, YELLOW, RED
    }

    public Signal color = Signal.RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView() {
        tvClick = (TextView) findViewById(R.id.tvClick);
        tvGoNext = (TextView) findViewById(R.id.tvGoNext);
    }

    private void initListener() {
        tvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Signal signal = change();
                Toast.makeText(MainActivity.this,signal.toString(),Toast.LENGTH_LONG).show();
                Log.e("chris","signal=" + signal.toString());
            }
        });

        tvGoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }

    public Signal change() {
        switch (color) {//switch支持枚举
            case RED:
                color = Signal.GREEN;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
        }
        return color;
    }
}
