package android.example.com.yihubaiying.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

public class wode_set_activity extends AppCompatActivity {
    private String[] xingqu = new String[]
            {"创业人士","健身爱好者","有车一族","有房一族","极客一族","租房一族","好吃一族"};
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wode_info_layout);

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
        toolbar.set

        final TagFlowLayout flowLayout= (TagFlowLayout) findViewById(R.id.flow_wode);
        flowLayout.setAdapter(new TagAdapter<String>(xingqu) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(wode_set_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        });
        Button save= (Button) findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"您的信息已经更改",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
