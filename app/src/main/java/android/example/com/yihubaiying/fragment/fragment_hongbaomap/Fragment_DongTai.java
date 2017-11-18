package android.example.com.yihubaiying.fragment.fragment_hongbaomap;

import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.adapter.DongtaiAdapter;
import android.example.com.yihubaiying.adapter.DongtaiItem;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wx.goodview.GoodView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carnivalnian on 2017/10/21.
 */

public class Fragment_DongTai extends Fragment implements View.OnClickListener{
    private List<DongtaiItem> dongtaiItemList=new ArrayList<>();
    GoodView mGoodView;
    int flag=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_dongtai,container,false);
        initView(view);
        if (flag==0){
            initDongtai();
            flag+=1;

        }
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.dongtai_recycleview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        DongtaiAdapter adapter=new DongtaiAdapter(R.layout.dontai_layout,dongtaiItemList);
        recyclerView.setAdapter(adapter);
        mGoodView=new GoodView(getContext());


        
        return view;

    }

    private void initDongtai() {
        DongtaiItem dongtaiItem=new DongtaiItem(R.drawable.user2,"人生哲理  lv.5","一小时前","[领取红包]我刚刚在这这里领取了大额的红包，赶快加入我把。","成功推广胡八一软件，得到大额红包一个。",R.drawable.good);
        DongtaiItem dongtaiItem1=new DongtaiItem(R.drawable.user6,"龙云  lv.7","一小时前","[领取红包]每日签到 轻松赢取升级红包，小伙伴们速速行动起来。","完成签到任务，领取签到红包。",R.drawable.good);
        DongtaiItem dongtaiItem2=new DongtaiItem(R.drawable.user7,"汽齿龙  lv.9","二小时前","[领取红包]我刚刚领取了寻人红包，快和我一样提供线索。","成功为寻找陕西榆林王根香女士提供线索，领取红包一个。",R.drawable.good);
        DongtaiItem dongtaiItem3=new DongtaiItem(R.drawable.user10,"江湖郎中  lv.2","三小时前","[领取红包]我刚刚在这这里领取了分享红包，快来加入我们。","成功将中海国际广告分享到朋友圈，领取分享红包一个。",R.drawable.good);
        DongtaiItem dongtaiItem4=new DongtaiItem(R.drawable.user11,"剩下的风  lv.4","四小时前","[领取红包]我刚刚在这这里领取了任务红包，你还在等什么？","成功为商家拍摄货架商品，领取任务红包一个。",R.drawable.good);
        DongtaiItem dongtaiItem5=new DongtaiItem(R.drawable.user4,"我是外科医生  lv.18","四小时前","[领取红包]我刚刚在这这里领取了寻人红包，赶快加入我把。","成功帮助建筑师雪岩清风找到建筑伙伴，领取寻人红包一个。",R.drawable.good);

        dongtaiItemList.add(dongtaiItem);
        dongtaiItemList.add(dongtaiItem1);
        dongtaiItemList.add(dongtaiItem2);
        dongtaiItemList.add(dongtaiItem3);
        dongtaiItemList.add(dongtaiItem4);
        dongtaiItemList.add(dongtaiItem5);


    }


    private void initView(View view) {

    }


    @Override
    public void onClick(View v) {

    }

}
