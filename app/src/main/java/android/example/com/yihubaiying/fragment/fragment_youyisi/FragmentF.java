package android.example.com.yihubaiying.fragment.fragment_youyisi;

import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.activity.Newsdetail_activity;
import android.example.com.yihubaiying.adapter.News;
import android.example.com.yihubaiying.adapter.NewsAdapter;
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
public class FragmentF extends BaseFragment {

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
        NewsAdapter adapter=new NewsAdapter(R.layout.news_layout,newsItemList);
        recyclerView.setAdapter(adapter);


    }
    private void initDatas() {
        News news1=new News("23岁奶茶妹妹章泽天穿职业装出席活动，美的不忍直视！","新浪娱乐","13469看过",R.drawable.yule1);
        News news2=new News("孙燕姿自曝与老公恋爱史 预计生二胎","网易娱乐","29581看过",R.drawable.yule2);
        News news3=new News("赛琳娜比伯当众接吻 画面闪瞎眼","凤凰娱乐","86514看过",R.drawable.yule3);
        News news4=new News("小泡芙录节目生病惹众人心疼：没力气了","大成娱乐","14547看过",R.drawable.yule4);
        News news5=new News("恭喜！张雨绮生下龙凤胎 经纪人朋友圈晒照","中工娱乐","345275过",R.drawable.yule5);

        newsItemList.add(news1);
        newsItemList.add(news2);
        newsItemList.add(news3);
        newsItemList.add(news4);
        newsItemList.add(news5);


    }

    public static FragmentF getInstance(String title) {
        FragmentF mf = new FragmentF();
        mf.title = title;
        return mf;
    }
}
