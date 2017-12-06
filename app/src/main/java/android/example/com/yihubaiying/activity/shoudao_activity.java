package android.example.com.yihubaiying.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.amap.api.maps.model.Text;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class shoudao_activity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView shoudao;
    private TextView fachu;
    private TextView Text1text;
    private TextView Text2text;
    private TextView Text3text;
    private TextView Text4text;
    private TextView Text5text;
    private TextView Text1money;
    private TextView Text2money;
    private TextView Text3money;
    private TextView Text4money;
    private TextView Text5money;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._header_receive_rp);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setNavigationIcon(R.drawable.white_back_icon1);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setTitle("我的红包");

        Text1money= (TextView) findViewById(R.id.text1money);
        Text2money= (TextView) findViewById(R.id.text2money);
        Text3money= (TextView) findViewById(R.id.text3money);
        Text4money= (TextView) findViewById(R.id.text4money);
        Text5money= (TextView) findViewById(R.id.text5money);
        Text1text= (TextView) findViewById(R.id.text1text);
        Text2text= (TextView) findViewById(R.id.text2text);
        Text3text= (TextView) findViewById(R.id.text3text);
        Text4text= (TextView) findViewById(R.id.text4text);
        Text5text= (TextView) findViewById(R.id.text5text);
        Text1text.setText("泡桐树小学投票群签到红包");
        Text2text.setText("给中海国际售楼小宋的定向红包");
        Text3text.setText("仁寿猪肝面群转发红包");
        Text4text.setText("王妈串串香群签到红包");
        Text5text.setText("来自用户呵呵哒的线索红包红包");
        shoudao= (TextView) findViewById(R.id.text_shoudao);
        shoudao.setTextColor(Color.parseColor("#FF4040"));
        fachu= (TextView) findViewById(R.id.text_fachu);
        fachu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fachu.setTextColor(Color.parseColor("#FF4040"));
                shoudao.setTextColor(Color.parseColor("#7A8B8B"));
                Text1text.setText("寻找孙老师的老妈签到红包");
                Text2text.setText("给仓晓的定向红包");
                Text3text.setText("寻找孙老师的老妈转发红包");
                Text4text.setText("寻找孙老师的老妈签到红包");
                Text5text.setText("给用户25698的线索红包红包");

            }
        });
        shoudao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoudao.setTextColor(Color.parseColor("#FF4040"));
                fachu.setTextColor(Color.parseColor("#7A8B8B"));
                Text1text.setText("泡桐树小学投票群签到红包");
                Text2text.setText("给中海国际售楼小宋的定向红包");
                Text3text.setText("仁寿猪肝面群转发红包");
                Text4text.setText("王妈串串香群签到红包");
                Text5text.setText("来自用户呵呵哒的线索红包红包");

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar.setTitle("我的红包");
    }


}
