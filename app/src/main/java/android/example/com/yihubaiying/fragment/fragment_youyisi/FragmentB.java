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

    }
    private void initDatas() {
        News news1=new News("这5种避孕套赶快扔掉 用了小心染上病","寻医问药网","21077看过 红包69.2元",R.drawable.jiankang1);
        News news2=new News("乳腺癌早期症状有哪些？女性12个症状要警惕乳腺癌","人民网健康","59720看过 红包35.8元",R.drawable.jiankang2);
        News news3=new News("女人每天最需要的5种食物，吃这些才健康","搜狐健康","54785看过 红包39.1元",R.drawable.jiankang3);
        News news4=new News("什么样的痣会引发皮肤癌？留意7个恶变信号","新华网健康","17377看过 红包47.7元",R.drawable.jiankang4);
        News news5=new News("男人吃太饱有什么危害，这几种食物千万不要再吃了","百度医生","40621看过 红包11.2元",R.drawable.jiankang5);

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
