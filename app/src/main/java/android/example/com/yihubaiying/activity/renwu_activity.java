package android.example.com.yihubaiying.activity;

import android.example.com.yihubaiying.fragment.fragment_youyisi.BaseFragment;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentA;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentB;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentC;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentD;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentE;
import android.example.com.yihubaiying.fragment.fragment_youyisi.FragmentF;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class renwu_activity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.woderenwu_layout);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setNavigationIcon(R.drawable.white_back_icon1);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setTitle("我的任务");

    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar.setTitle("我的任务");
    }
}
