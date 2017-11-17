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
public class FragmentC extends BaseFragment {

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
        News news1=new News("曝上港要求孔卡回归遭拒 前中超MVP不想回中国","新浪体育","13569看过",R.drawable.tiyu1);
        News news2=new News("西媒曝国安购21岁西甲前锋 南美国脚身价400万欧","搜狐体育","94581看过",R.drawable.tiyu2);
        News news3=new News("小李雪芮？19岁小丫爆冷击败辛杜：万万没想到！","腾讯体育","76514看过",R.drawable.tiyu3);
        News news4=new News("本土双子星空砍41分 广厦客场86-91惜败新疆","CBA官网","54527看过",R.drawable.tiyu4);
        News news5=new News("翟晓川25分北京胜福建 弗神54分上海胜八一","优酷体育","44527看过",R.drawable.tiyu5);

        newsItemList.add(news1);
        newsItemList.add(news2);
        newsItemList.add(news3);
        newsItemList.add(news4);
        newsItemList.add(news5);


    }

    public static FragmentC getInstance(String title) {
        FragmentC mf = new FragmentC();
        mf.title = title;
        return mf;
    }
}
