package android.example.com.yihubaiying.activity.yihubaiying;

import android.content.Intent;
import android.example.com.yihubaiying.activity.LoginActivity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载启动界面
        setContentView(R.layout.activity_launch);
        Integer time = 2000;    //设置等待时间，单位为毫秒
        Handler handler = new Handler();
        //当计时结束时，跳转至主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LaunchActivity.this, LoginActivity.class));
                LaunchActivity.this.finish();
            }
        }, time);
    }
}
