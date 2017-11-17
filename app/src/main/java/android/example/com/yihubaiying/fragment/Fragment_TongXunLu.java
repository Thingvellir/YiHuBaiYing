package android.example.com.yihubaiying.fragment;

import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.adapter.ContactAdapter;
import android.example.com.yihubaiying.adapter.ContactItem;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carnivalnian on 2017/10/21.
 */


public class Fragment_TongXunLu extends Fragment implements View.OnClickListener{
        List<ContactItem> contentItemList=new ArrayList<>();
    int flag=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tongxunlu_layout,container,false);
        initView(view);
        if (flag==0){
            initDatas();
            flag+=1;
        }
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.contact_recycleview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ContactAdapter adapter=new ContactAdapter(R.layout.contact_layout,contentItemList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void initDatas() {
        ContactItem item=new ContactItem(R.drawable.user1,"人生哲理", R.drawable.tel_icon);
        ContactItem item1=new ContactItem(R.drawable.user2,"龙云", R.drawable.tel_icon);
        ContactItem item2=new ContactItem(R.drawable.user3,"用户591436884", R.drawable.tel_icon);
        ContactItem item3=new ContactItem(R.drawable.user4,"老顾", R.drawable.tel_icon);
        ContactItem item4=new ContactItem(R.drawable.user11,"快乐佑小王", R.drawable.tel_icon);
        ContactItem item5=new ContactItem(R.drawable.user6,"汽齿龙", R.drawable.tel_icon);
        ContactItem item6=new ContactItem(R.drawable.user7,"风吹你", R.drawable.tel_icon);
        ContactItem item7=new ContactItem(R.drawable.user8,"我是外科医生", R.drawable.tel_icon);
        ContactItem item9=new ContactItem(R.drawable.user9,"江湖郎中", R.drawable.tel_icon);
        ContactItem item10=new ContactItem(R.drawable.user10,"剩下的风", R.drawable.tel_icon);
        contentItemList.add(item);
        contentItemList.add(item1);
        contentItemList.add(item2);
        contentItemList.add(item3);
        contentItemList.add(item4);
        contentItemList.add(item5);
        contentItemList.add(item6);
        contentItemList.add(item7);
        contentItemList.add(item9);
        contentItemList.add(item10);


    }


    private void initView(View view) {

    }


    @Override
    public void onClick(View v) {

    }
}