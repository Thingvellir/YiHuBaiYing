package android.example.com.yihubaiying.fragment.fragment_haoyou;

import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.activity.Newsdetail_activity;
import android.example.com.yihubaiying.activity.group_chat_activity;
import android.example.com.yihubaiying.adapter.MessAdapter;
import android.example.com.yihubaiying.adapter.MessItem;
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


    }
    private void initDatas() {
        Message item=new Message(R.drawable.user_nine,"旅行社小张","嗯嗯好的我知道了，我马上把位置发过去。","01:28",R.drawable.red_icon);
        Message item1=new Message(R.drawable.user11,"范璐","能不能帮我找到成都所有的建筑师","05:27",R.drawable.red_icon);
        Message item2=new Message(R.drawable.user13,"小木匠","你能帮我调一下九眼桥附近的监控吗","15:25",R.drawable.red_icon);
        Message item3=new Message(R.drawable.user12,"同样仍是并不在意","马上到了","12:26",R.drawable.red_icon);
        Message item4=new Message(R.drawable.user10,"紫霞狼","我们这边三件七折 亲可以来选购呢","08:24",R.drawable.red_icon);
        Message item5=new Message(R.drawable.user4,"美丽生燕窝","亲您的优惠卷已经可以领取了","09:27",R.drawable.red_icon);
        Message item6=new Message(R.drawable.user2,"文刀先生","鹿晗今天乘坐的航班是C98526 下午到成都","11:24",R.drawable.red_icon);
        Message item7=new Message(R.drawable.user1,"张云云","您能详细的描述一下事发当晚你看到的东西吗？","16:58",R.drawable.red_icon);
        Message item8=new Message(R.drawable.user8,"天狼爸","我打听了，他就在高新区工作","19:43",R.drawable.red_icon);
        Message item9=new Message(R.drawable.user6,"果儿","法院的判决结果，这个必须立即生效的","15:52",R.drawable.red_icon);

        MessItemList.add(item);
        MessItemList.add(item1);
        MessItemList.add(item2);
        MessItemList.add(item3);
        MessItemList.add(item4);
        MessItemList.add(item5);
        MessItemList.add(item6);
        MessItemList.add(item7);
        MessItemList.add(item8);
        MessItemList.add(item9);



    }

    public static FragmentB getInstance(String title) {
        FragmentB mf = new FragmentB();
        mf.title = title;
        return mf;
    }
}