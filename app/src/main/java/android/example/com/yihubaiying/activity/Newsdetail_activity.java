package android.example.com.yihubaiying.activity;

import android.content.Intent;
import android.example.com.yihubaiying.adapter.CommentAdapter;
import android.example.com.yihubaiying.adapter.CommentItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wx.goodview.GoodView;

import java.util.ArrayList;
import java.util.List;

public class Newsdetail_activity extends AppCompatActivity {
    GoodView mGoodView;

    List<CommentItem> CommentItemList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsdetail_layout);
        initDatas();

        RecyclerView recycleView= (RecyclerView) findViewById(R.id.comment_recycle);
        LinearLayoutManager layoutManger=new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManger);
        CommentAdapter adapter=new CommentAdapter(R.layout.comment_layout,CommentItemList);
        recycleView.setAdapter(adapter);


        mGoodView=new GoodView(this);


    }

    private void initDatas() {

        CommentItem item=new CommentItem(R.drawable.user_four,"仓晓","2小时前","哇雷总厉害了",R.drawable.good);
        CommentItem item1=new CommentItem(R.drawable.user_four,"仓晓","2小时前","哇雷总厉害了",R.drawable.good);
        CommentItem item2=new CommentItem(R.drawable.user_four,"仓晓","2小时前","哇雷总厉害了",R.drawable.good);
        CommentItem item3=new CommentItem(R.drawable.user_four,"仓晓","2小时前","哇雷总厉害了",R.drawable.good);
        CommentItem item4=new CommentItem(R.drawable.user_four,"仓晓","2小时前","哇雷总厉害了",R.drawable.good);
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
