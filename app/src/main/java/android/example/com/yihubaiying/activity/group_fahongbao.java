package android.example.com.yihubaiying.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class group_fahongbao extends AppCompatActivity {
    Button btn_putin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_fahongbao);
        btn_putin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"您的群红包已发布",Toast.LENGTH_SHORT);
                finish();
            }
        });
    }
}
