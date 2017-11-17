package android.example.com.yihubaiying.activity;

import android.content.Intent;
import android.example.com.yihubaiying.adapter.CommentAdapter;
import android.example.com.yihubaiying.adapter.CommentItem;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.wx.goodview.GoodView;

import java.util.ArrayList;
import java.util.List;

public class Newsdetail_activity extends AppCompatActivity {
    GoodView mGoodView;
    Toolbar toolbar;

    List<CommentItem> CommentItemList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsdetail_layout);
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
        View youyisi_faqian=findViewById(R.id.youyisi_fahongbao);
        youyisi_faqian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Newsdetail_activity.this,youyisi_fahongbao.class));
            }
        });

        initDatas();

        RecyclerView recycleView= (RecyclerView) findViewById(R.id.comment_recycle);
        LinearLayoutManager layoutManger=new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManger);
        CommentAdapter adapter=new CommentAdapter(R.layout.comment_layout,CommentItemList);
        recycleView.setAdapter(adapter);


        mGoodView=new GoodView(this);
        TextView textView1= (TextView) findViewById(R.id.linghongbao_1);
        TextView textView2= (TextView) findViewById(R.id.linghongbao_1);
        TextView textView3= (TextView) findViewById(R.id.linghongbao_1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"ss",Toast.LENGTH_SHORT).show();
                final DialogPlus dialog=DialogPlus.newDialog(Newsdetail_activity.this).setContentHolder(new ViewHolder(R.layout.dialog_youyisi)).setGravity(Gravity.CENTER).create();
                ImageView ad= (ImageView) dialog.getHolderView().findViewById(R.id.open_btn);
                ad.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Newsdetail_activity.this,group_chat_activity.class));
                    }
                });

                Button close= (Button) dialog.getHolderView().findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        ImageView imageView= (ImageView) findViewById(R.id.adv_pic);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Newsdetail_activity.this,webview_activity.class));
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar.setTitle("产品力再升级！...");
    }

    private void initDatas() {

        CommentItem item=new CommentItem(R.drawable.user1,"简简单单","","日产车的质量还是太差了",R.drawable.good);
        CommentItem item1=new CommentItem(R.drawable.user2,"西安用户2359","2小时前","成都这个优惠幅度还是非常诱人的",R.drawable.good);
        CommentItem item2=new CommentItem(R.drawable.user3,"罗拉","8小时前","我刚买的不到一个月的君越就开始露油了",R.drawable.good);
        CommentItem item3=new CommentItem(R.drawable.user4,"言尔夫","2天前","北京车展上看过这车 当时就想买来着",R.drawable.good);
        CommentItem item4=new CommentItem(R.drawable.user6,"兴济","7小时前","哇厉害了",R.drawable.good);



        CommentItemList.add(item);
        CommentItemList.add(item1);
        CommentItemList.add(item2);
        CommentItemList.add(item3);
        CommentItemList.add(item4);


    }

    public void good(View view){
            ((ImageView) view).setImageResource(R.drawable.good_checked);
            mGoodView.setText("+1");
            mGoodView.show(view);
    }
}
