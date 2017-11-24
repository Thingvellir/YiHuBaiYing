package android.example.com.yihubaiying.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

public class qunliao_zhonghai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qunliao_zhonghai);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.white_back_icon1);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setTitle("中海左岸 开盘在即");

        final DialogPlus dialog=DialogPlus.newDialog(qunliao_zhonghai.this).setContentHolder(new ViewHolder(R.layout.dialog_zhonghai)).setGravity(Gravity.CENTER).setContentBackgroundResource(R.drawable.shape_corner).create();
        ImageView delect= (ImageView) dialog.getHolderView().findViewById(R.id.delect_icon);
        delect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        TextView shengyuhongbao= (TextView) findViewById(R.id.shengyumoney);
        shengyuhongbao.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        dialog.show();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.group:
                Intent intent=new Intent(qunliao_zhonghai.this,detail_group_acitivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;

    }
}
