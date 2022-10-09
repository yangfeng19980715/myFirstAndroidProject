package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {


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
                        Intent intent = getIntent();  // getIntent()可以获取到启动这个activity的Intent

                        String data = intent.getStringExtra("extra_data");

                        Toast.makeText(ThirdActivity.this, data, Toast.LENGTH_SHORT).show();

                    }
                }
        );

    }
}