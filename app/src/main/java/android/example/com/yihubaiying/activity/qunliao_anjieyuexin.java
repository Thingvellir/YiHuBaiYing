package android.example.com.yihubaiying.activity;

import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

public class qunliao_anjieyuexin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qunliao_anjieyuexin);
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
        toolbar.setTitle("成都安捷悦信购车群");

        final DialogPlus dialog=DialogPlus.newDialog(qunliao_anjieyuexin.this).setContentHolder(new ViewHolder(R.layout.dialog_linghongbao)).setGravity(Gravity.CENTER).setContentBackgroundResource(R.drawable.shape_corner).create();
        Button close= (Button) dialog.getHolderView().findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

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
                Intent intent=new Intent(qunliao_anjieyuexin.this,detail_group_acitivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;

    }
}
