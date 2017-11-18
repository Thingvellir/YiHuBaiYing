package android.example.com.yihubaiying.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.example.com.yihubaiying.R;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

public class group_chat_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qunliao1);
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
        toolbar.setTitle("寻找孙老师的老妈群");

        final DialogPlus dialog=DialogPlus.newDialog(group_chat_activity.this).setContentHolder(new ViewHolder(R.layout.dialog_xunzhaosunlaoshi)).setGravity(Gravity.CENTER).setContentBackgroundResource(R.drawable.shape_corner).create();
        ImageView delect= (ImageView) dialog.getHolderView().findViewById(R.id.delect_icon);
        delect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

        ImageView fahongbao= (ImageView) findViewById(R.id.group_chat_fahongbao);
        fahongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(group_chat_activity.this,group_fahongbao.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.group:
                Intent intent=new Intent(group_chat_activity.this,detail_group_acitivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;

    }
}
