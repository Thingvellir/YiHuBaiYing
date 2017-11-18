package android.example.com.yihubaiying.fragment.fragment_haoyou;

import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.activity.Newsdetail_activity;
import android.example.com.yihubaiying.activity.group_chat_activity;
import android.example.com.yihubaiying.activity.qunliao_paotongshu;
import android.example.com.yihubaiying.activity.qunliao_zhonghai;
import android.example.com.yihubaiying.adapter.MessAdapter;
import android.example.com.yihubaiying.adapter.Message;
import android.example.com.yihubaiying.adapter.News;
import android.example.com.yihubaiying.adapter.NewsAdapter;
import android.example.com.yihubaiying.fragment.fragment_youyisi.BaseFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by asus on 2016/6/23.
 */
public class FragmentA extends BaseFragment {
    private List<Message> MessItemList=new ArrayList<>();


    List<News> newsItemList=new ArrayList<>();
    private String title;
    private RecyclerView recyclerView;
    int flag=0;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_layout_a;
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

                TextView a=(TextView)view.findViewById(R.id.mess_title);
                if(a.getText().toString().contains("寻找孙老师的老妈群")){
                    startActivity(new Intent(getActivity(),group_chat_activity.class));
                }
                if(a.getText().toString().contains("泡桐树小学最佳少先队员")){
                    startActivity(new Intent(getActivity(),qunliao_paotongshu.class));
                }
                if(a.getText().toString().contains("中海左岸")){
                    startActivity(new Intent(getActivity(),qunliao_zhonghai.class));
                }

            }
        });

    }
    private void initDatas() {
        Message item=new Message(R.drawable.wodequn1,"寻找孙老师的老妈群","孙老师：老妈是在温江走丢的@所有人","18:58",R.drawable.red_icon);
        Message item1=new Message(R.drawable.wodequn2,"泡桐树小学最佳少先队员","胡云野：大家帮我投票吧！","08:43",R.drawable.red_icon);
        Message item2=new Message(R.drawable.wodequn3,"中海左岸 火爆销售","中海销售部：中海开盘视频，震撼登场","17:28",R.drawable.red_icon);
        Message item3=new Message(R.drawable.wodequn4,"仁寿猪肝面 好吃天天见","平淡是福：今天凑齐三个字的朋友 三折哈！","05:21",R.drawable.red_icon);
        Message item4=new Message(R.drawable.wodequn5,"王妈串串香 饕客群","王妈：今天每隔一个小时抽奖一次，抽中","14:57",R.drawable.red_icon);
        Message item5=new Message(R.drawable.wodequn6,"嘴儿串串粉丝会","老板 卢大姐：整点报道的朋友，送一杯蓝色火焰哈！","13:26",R.drawable.red_icon);
        Message item6=new Message(R.drawable.wodequn7,"《摔跤吧！爸爸》粉丝会","阿米尔汗助理：幸运抽奖 第30 60 90 位进群的","14:54",R.drawable.red_icon);
        Message item7=new Message(R.drawable.wodequn8,"季富政建筑手绘展粉丝群","季大师的助理：今天上午九点 在省美术馆 欢迎大家","15:14",R.drawable.red_icon);
        Message item8=new Message(R.drawable.wodequn11,"西南设计院 女建筑师交流群","仇平萍大建筑师：求助各位师姐妹 这个景观设计方案怎么做啊？","18:23",R.drawable.red_icon);
        Message item9=new Message(R.drawable.wodequn9,"英郡业主交流群","业主委员会：能把大家聚到这个群里真是不容易！","18:51",R.drawable.red_icon);
        Message item10=new Message(R.drawable.wodequn10,"寻资深建筑师 设计大圆环","建筑师雪岩清风：各位大建筑师们，50米大跨度结构如何解决？","22:37",R.drawable.red_icon);

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
        MessItemList.add(item10);



    }

    public static FragmentA getInstance(String title) {
        FragmentA mf = new FragmentA();
        mf.title = title;
        return mf;
    }
}
