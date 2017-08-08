package com.example.qhsj.enumtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private TextView tvClick;
    private TextView tvGoNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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
                String cName = Color.getCName(1);
                Log.e("chris","Color index为1的时候，name=" + cName);

                Color c = Color.RED;
                Log.e("chris","Color name为red的时候，index=" + c.index);
                Log.e("chris","Color name为red的时候，Color.toString=" + c.toString());

            }
        });

        tvGoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
            }
        });
    }

    // 如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。而且Java要求必须先定义enum 实例。
    // 既然枚举是常量，这样写也就相当于是定义几个静态对象了
    public enum Color {

        RED("red", 1), GREEN("green", 2), YELLOW("yellow", 3);

        // 成员变量
        private String name;
        private int index;

        // 构造方法，三种颜色都是调用的这个方法
        private Color(String name, int index) {
            this.name = name;
            this.index = index;
        }

        // 普通方法
        public static String getCName(int index) {
            for (Color c : Color.values()) { // Color.values() 是什么意思
                if (c.getIndex() == index) {
                    return c.name; // 调用成员变量
                }
            }
            return null;
        }

        // getter setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public String toString() {// 重写枚举 toString 方法
            return this.index + "_" + this.name;
        }

    }
}
