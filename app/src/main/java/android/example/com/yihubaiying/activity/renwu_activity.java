package android.example.com.yihubaiying.activity;

import android.example.com.yihubaiying.fragment.fragment_youyisi.BaseFragment;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentA;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentB;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentC;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentD;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentE;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentF;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class renwu_activity extends AppCompatActivity {
    SlidingTabLayout tabLayout;
    ViewPager viewPager;
    private MyPagerAdapter adapter;
    private ArrayList<BaseFragment> mFagments = new ArrayList<>();
    private String[] mTitles = {"Tab1", "Tab2", "Tab333344", "Tab4", "Tab5", "Tab6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youyisi_layout);
        tabLayout = (SlidingTabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        mFagments.add(FragmentA.getInstance(mTitles[0]));
        mFagments.add(FragmentB.getInstance(mTitles[1]));
        mFagments.add(FragmentC.getInstance(mTitles[2]));
        mFagments.add(FragmentD.getInstance(mTitles[3]));
        mFagments.add(FragmentE.getInstance(mTitles[4]));
        mFagments.add(FragmentF.getInstance(mTitles[5]));

        //getChildFragmentManager() 如果是嵌套在fragment中就要用这个
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager, mTitles);


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
