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
public class FragmentB extends BaseFragment {

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
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getContext(), "onItemChildClick" + position, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(),Newsdetail_activity.class));
            }
        });

    }
    private void initDatas() {
        News news1=new News("产品力再升级！10-15万实惠家轿如何选","车天下","23569看过",R.drawable.youyisi_jiaoche);
        News news2=new News("从《功守道》，你就只看到马云的钱吗？","成都商报","24581看过",R.drawable.youyisi_gongshoudao);
        News news3=new News("大豆蛋白是不预防心脏病的，这样吃才可以","39健康网","86514看过",R.drawable.youyisi_daodou);
        News news4=new News("冬天到了，吃点麻辣辣才是冬天正确的打开方式","本地宝","14527看过",R.drawable.youyisi_malatang);
        News news5=new News("惊！公积金余额怎么只剩5毛？我的钱呢？","钱袋子金融","34527看过",R.drawable.youyisi_gongjijin);

        newsItemList.add(news1);
        newsItemList.add(news2);
        newsItemList.add(news3);
        newsItemList.add(news4);
        newsItemList.add(news5);


    }

    public static FragmentB getInstance(String title) {
        FragmentB mf = new FragmentB();
        mf.title = title;
        return mf;
    }
}
