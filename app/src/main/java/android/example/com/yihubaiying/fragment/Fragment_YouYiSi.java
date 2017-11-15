package android.example.com.yihubaiying.fragment;

import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.activity.Newsdetail_activity;
import android.example.com.yihubaiying.adapter.News;
import android.example.com.yihubaiying.adapter.NewsAdapter;
import android.example.com.yihubaiying.fragment.fragment_youyisi.BaseFragment;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentA;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentB;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentC;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentD;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentE;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carnivalnian on 2017/10/21.
 */
public class Fragment_YouYiSi extends Fragment implements View.OnClickListener{
    SlidingTabLayout tabLayout;
    ViewPager viewPager;
    private MyPagerAdapter adapter;
    private ArrayList<BaseFragment> mFagments = new ArrayList<>();
    private String[] mTitles = {"滚动", "健康", "体育", "财经", "科技", "娱乐"};
    int  flag=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.youyisi_layout,container,false);
        tabLayout= (SlidingTabLayout) view.findViewById(R.id.tabLayout);
        viewPager= (ViewPager) view.findViewById(R.id.view_pager);
        if (flag==0) {

            initDatas(view);
            flag+=1;
        }


        adapter = new MyPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager, mTitles);
        return view;
    }

    private void initDatas(View view) {
            mFagments.add(FragmentA.getInstance(mTitles[0]));
            mFagments.add(FragmentB.getInstance(mTitles[1]));
            mFagments.add(FragmentC.getInstance(mTitles[2]));
            mFagments.add(FragmentD.getInstance(mTitles[3]));
            mFagments.add(FragmentE.getInstance(mTitles[4]));
            mFagments.add(FragmentF.getInstance(mTitles[5]));
    }



        //getChildFragmentManager() 如果是嵌套在fragment中就要用这

    @Override
    public void onClick(View v) {
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFagments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFagments.get(position);
        }
    }


}