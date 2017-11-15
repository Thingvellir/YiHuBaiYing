package android.example.com.yihubaiying.fragment.fragment_hongbaomap;

import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.adapter.RankAdapter;
import android.example.com.yihubaiying.adapter.RankItem;
import android.example.com.yihubaiying.fragment.fragment_paihangbang.FragmentA;
import android.example.com.yihubaiying.fragment.fragment_paihangbang.FragmentB;
import android.example.com.yihubaiying.fragment.fragment_paihangbang.FragmentC;
import android.example.com.yihubaiying.fragment.fragment_youyisi.BaseFragment;
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

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carnivalnian on 2017/10/21.
 */

public class Fragment_PaiHangBang extends Fragment implements View.OnClickListener {
    SlidingTabLayout tabLayout;
    ViewPager viewPager;
    private MyPagerAdapter adapter;
    private ArrayList<BaseFragment> mFagments = new ArrayList<>();
    private String[] mTitles = {"本地排行榜", "省排行榜","全国排行榜"};
    int flag = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_paihangbang, container, false);
        tabLayout = (SlidingTabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        if (flag == 0) {

            initDatas();
            flag += 1;
        }
        adapter = new MyPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager, mTitles);
        return view;
    }


    @Override
    public void onClick(View v) {

    }

    private void initDatas() {
        mFagments.add(FragmentA.getInstance(mTitles[0]));
        mFagments.add(FragmentB.getInstance(mTitles[1]));
        mFagments.add(FragmentC.getInstance(mTitles[2]));

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