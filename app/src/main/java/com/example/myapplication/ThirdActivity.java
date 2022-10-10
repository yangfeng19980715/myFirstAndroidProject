package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello, yangfeng, backed");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        Button button = (Button)findViewById(R.id.button_3);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // startActivity(new Intent(ThirdActivity.this, MainActivity.class));
                        // Intent intent = getIntent();  // getIntent()可以获取到启动这个activity的Intent
                        // String data = intent.getStringExtra("extra_data");
                        // Toast.makeText(ThirdActivity.this, data, Toast.LENGTH_SHORT).show();

                        // 通过按钮返回的话，使用这里的逻辑
                        Intent intent = new Intent(); // 这个intent仅仅是用于传递数据，没有指定任何的意图
                        intent.putExtra("data_return", "Hello, yangfeng, button clicked");  // 把数据存放在intent中
                        setResult(RESULT_OK, intent);  // 这个函数专门向上一个活动返回数据,第一个参数返回处理结果
                        finish();  // finish销毁当前活动

                    }

                }
        );

    }
}