package android.example.com.yihubaiying.fragment.fragment_haoyou;

import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.activity.Newsdetail_activity;
import android.example.com.yihubaiying.activity.group_chat_activity;
import android.example.com.yihubaiying.adapter.MessAdapter;
import android.example.com.yihubaiying.adapter.Message;
import android.example.com.yihubaiying.adapter.News;
import android.example.com.yihubaiying.adapter.NewsAdapter;
import android.example.com.yihubaiying.fragment.fragment_youyisi.BaseFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by asus on 2016/6/23.
 */
public class FragmentB extends BaseFragment {
    private List<Message> MessItemList=new ArrayList<>();


    List<News> newsItemList=new ArrayList<>();
    private String title;
    private RecyclerView recyclerView;
    int flag=0;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_layout_b;
    }

    @Override
    public void initView() {
        if (flag==0){
            initDatas();
            flag+=1;

        }

        recyclerView= (RecyclerView) view.findViewById(R.id.recycle);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        MessAdapter adapter=new MessAdapter(R.layout.message_layout,MessItemList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getContext(), "onItemChildClick" + position, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(),group_chat_activity.class));
            }
        });

    }
    private void initDatas() {
        Message item=new Message(R.drawable.user_nine,"旅行社小张","嗯嗯好的我知道了，我马上把位置发过去。","15:28",R.drawable.red_icon);
        MessItemList.add(item);


    }

    public static FragmentB getInstance(String title) {
        FragmentB mf = new FragmentB();
        mf.title = title;
        return mf;
    }
}