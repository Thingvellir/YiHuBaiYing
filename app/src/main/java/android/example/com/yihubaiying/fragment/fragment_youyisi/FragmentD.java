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
public class FragmentD extends BaseFragment {

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
        News news1=new News("央行拟颁布新规：进一步加强金融机构资管业务监管","易通贷","13469看过 红包11.4元",R.drawable.caijing1);
        News news2=new News("解读：私募是否会哭晕？合格投资者门槛提至500万","东方财富","54881看过 红包26.1元",R.drawable.caijing2);
        News news3=new News("上海房价纪录刷新:汤臣一品豪宅每平34万 总价2.05亿","新浪财经","76564看过 红包116.1元",R.drawable.caijing3);
        News news4=new News("首次房地产违规跨省大检查启动 广告违规用词全抠掉","腾讯财经","44527看过 红包11.0元",R.drawable.caijing4);
        News news5=new News("万达寻求以50亿美元一次性打包卖出五处海外资产","雪球财经","78527看过 红包7.1元",R.drawable.caijing5);

        newsItemList.add(news1);
        newsItemList.add(news2);
        newsItemList.add(news3);
        newsItemList.add(news4);
        newsItemList.add(news5);


    }

    public static FragmentD getInstance(String title) {
        FragmentD mf = new FragmentD();
        mf.title = title;
        return mf;
    }
}
