package android.example.com.yihubaiying.activity;

import android.content.Intent;
import android.example.com.yihubaiying.MainActivity;
import android.example.com.yihubaiying.enity.MyHongBao;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class redpacketdetail_activity extends AppCompatActivity {
    private MyHongBao hongBao;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redpacket_detail_layout);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setNavigationIcon(R.drawable.white_back_icon1);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setTitle("设置红包金额");
         hongBao= (MyHongBao) getIntent().getSerializableExtra("hongbao");
        final String ImageResourceId=hongBao.getTitle();

        Button button= (Button) findViewById(R.id.btn_next_step);
//        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//        pDialog.setTitleText("Loading");
//        pDialog.setCancelable(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),ImageResourceId,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(redpacketdetail_activity.this,MainActivity.class);
                Bundle mBundle=new Bundle();
                mBundle.putSerializable("hongbao",hongBao);
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });
    }
}
