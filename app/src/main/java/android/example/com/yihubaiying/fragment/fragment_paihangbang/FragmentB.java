package android.example.com.yihubaiying.fragment.fragment_paihangbang;

import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.activity.Newsdetail_activity;
import android.example.com.yihubaiying.adapter.NewsAdapter;
import android.example.com.yihubaiying.adapter.RankAdapter;
import android.example.com.yihubaiying.adapter.RankItem;
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

    List<RankItem> rankItemList=new ArrayList<>();
    private String title;
    private RecyclerView recyclerView;
    int flag=0;

    @Override
    public int getLayoutID() {
        return R.layout.frag_paihangbang_quanguo;
    }

    @Override
    public void initView() {
        if (flag==0){
            initDatas();
            flag+=1;

        }

        recyclerView= (RecyclerView) view.findViewById(R.id.rank_recycleview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RankAdapter adapter=new RankAdapter(R.layout.rank_layout,rankItemList);
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
        RankItem item=new RankItem(""+3, R.drawable.user_six,"漫漫", R.drawable.diamond_icon,"日红包:31.6元", R.drawable.up_icon);
        RankItem item1=new RankItem(""+4, R.drawable.user_seven,"眉眼", R.drawable.diamond_icon,"日红包:28.7元", R.drawable.down_icon);
        RankItem item2=new RankItem(""+5, R.drawable.user_eight,"死亡之翼", R.drawable.diamond_icon,"日红包:26.5元", R.drawable.down_icon);
        RankItem item3=new RankItem(""+6, R.drawable.user_nine,"冬雨如春", R.drawable.diamond_icon,"日红包:21.3元", R.drawable.up_icon);
        RankItem item4=new RankItem(""+6, R.drawable.user3,"晴空万里", R.drawable.diamond_icon,"日红包:19.3元", R.drawable.up_icon);
        RankItem item5=new RankItem(""+6, R.drawable.user4,"陈凌锋", R.drawable.diamond_icon,"日红包:17.4元", R.drawable.up_icon);
        rankItemList.add(item);
        rankItemList.add(item1);
        rankItemList.add(item2);
        rankItemList.add(item3);
        rankItemList.add(item4);
        rankItemList.add(item5);


    }

    public static FragmentB getInstance(String title) {
        FragmentB mf = new FragmentB();
        mf.title = title;
        return mf;
    }
}
