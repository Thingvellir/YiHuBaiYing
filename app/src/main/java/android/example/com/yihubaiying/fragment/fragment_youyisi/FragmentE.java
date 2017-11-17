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
public class FragmentE extends BaseFragment {

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
        News news1=new News("毁灭人类！波士顿动力人形机器人会后空翻了","新浪科技","13969看过",R.drawable.keji1);
        News news2=new News("Xbox One X在日本销量不佳 上市首周仅售出1344台","凤凰科技","64581看过",R.drawable.keji2);
        News news3=new News("全国首家无人智慧餐厅落地：你会去试试吗？","网易科技","46814看过",R.drawable.keji3);
        News news4=new News("iPhone X获《时代》评为2017年25大最佳发明之一","百度科技","34527看过",R.drawable.keji4);
        News news5=new News("为打击假新闻 谷歌等四家科技公司将采纳Trust Project新闻指标","IT之家","94557看过",R.drawable.keji5);

        newsItemList.add(news1);
        newsItemList.add(news2);
        newsItemList.add(news3);
        newsItemList.add(news4);
        newsItemList.add(news5);


    }

    public static FragmentE getInstance(String title) {
        FragmentE mf = new FragmentE();
        mf.title = title;
        return mf;
    }
}
