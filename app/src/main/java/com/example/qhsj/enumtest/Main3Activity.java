package com.example.qhsj.enumtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private TextView tvClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        initView();
        initListener();
    }

    private void initView() {
        tvClick = (TextView) findViewById(R.id.tvClick);
    }

    private void initListener() {
        tvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Food f = Food.Coffee.CAPPUCCINO;
                Log.e("chris","Food.toString=" + f.toString()); // Food.toString=CAPPUCCINO

            }
        });
    }

    /*
     * 定义接口和接口中的方法
     */
    public interface Behaviour {

        void print();

        String getInfo();
    }

    /*
     * 所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类.
     * 接口是可以多实现的，所以枚举可以实现接口
     */
    public enum Color implements Behaviour {

        RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4); // 成员变量

        private String name;
        private int index;

        // 构造方法
        private Color(String name, int index) {
            this.name = name;
            this.index = index;
        }

        // 接口方法
        @Override
        public String getInfo() {
            return this.name;
        }

        // 接口方法
        @Override
        public void print() {
            System.out.println(this.index + ":" + this.name);
            Log.e("chris","print()=" + this.index + ":" + this.name);
        }
    }

    // ------------------------------------------------

    /*
     * 使用接口组织枚举
     */
    public interface Food {

        enum Coffee implements Food {
            BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO  // 没有赋值会打印出来什么? 就是这个单词
        }

        enum Dessert implements Food {
            FRUIT, CAKE, GELATO
        }
    }
}
