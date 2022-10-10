package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    // 第一个参数是启动活动时传入的请求码
    // 第二个是返回数据时传入的处理结果
    // 第三个是携带数据的intent
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // 由于在一个活动中可能用startActivityForResult方法去启动很多不同的活动，每一个活动返回的数据都会回调到onActivityResult这个方法中
        // 因此我们首先要做的就是通过检查requestCode的值来判断数据来源
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Toast.makeText(MainActivity.this, returnedData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    private static final String TAG = "MainActivity";
    @Override
    /*
    onCreate是活动创建时必定被执行的方法
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button button_first = (Button)findViewById(R.id.button_first);

        button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "You clicked this button", Toast.LENGTH_SHORT).show(); // 1.
                // finish(); // 2.
                // Intent intent = new Intent(MainActivity.this, MyActivity.class); // 3.
                // startActivity(intent);

                // Intent intent = new Intent("com.example.myapplication.ACTION_START"); // 4.
                // intent.addCategory("com.example.myapplication.MY_CATEGORY");
                // startActivity(intent);

                // Intent intent = new Intent(Intent.ACTION_VIEW); // 5.
                // intent.setData(Uri.parse("http://baidu.com"));
                // startActivity(intent);

                // Intent intent = new Intent(Intent.ACTION_DIAL); // 6.
                // intent.setData(Uri.parse("tel:10086"));
                // startActivity(intent);

                // String data = "Hello, yangfeng";  // 7.
                // Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                // intent.putExtra("extra_data", data);  // extra_data是键，data是值
                // startActivity(intent);

                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(intent, 1);  // 第二个参数是请求码(只需要是个唯一值就可以了)，用于在之后的回调中判断数据的来源



            }
        });

        Log.d(TAG, "onCreate() execute");

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
         */

        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(MainActivity.this, "You clicked add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(MainActivity.this, "You clicked remove", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
        return true;
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}


















