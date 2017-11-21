package android.example.com.yihubaiying.fragment;

import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.activity.renwu_activity;
import android.example.com.yihubaiying.activity.shoudao_activity;
import android.example.com.yihubaiying.activity.wode_set_activity;
import android.example.com.yihubaiying.application.MyAppication;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.maps.model.Text;

/**
 * Created by carnivalnian on 2017/10/21.
 */


public class Fragment_WoDe extends Fragment implements View.OnClickListener{
    TextView my_money;
    private MyAppication appication;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.wode_layout,container,false);
        initView(view);
        my_money= (TextView) view.findViewById(R.id.my_Money);

        ImageView setinfo= (ImageView) view.findViewById(R.id.set_info);
        setinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),wode_set_activity.class));
            }
        });
        LinearLayout lishihongbao= (LinearLayout) view.findViewById(R.id.linear_lishihongbao);
        lishihongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),shoudao_activity.class));
            }
        });
        LinearLayout lishirenwu= (LinearLayout) view.findViewById(R.id.linear_lishirenwu);
        lishirenwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),renwu_activity.class));
            }
        });
        appication= (MyAppication) getActivity().getApplicationContext();

        return view;

    }



    private void initView(View view) {

    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onResume() {
        super.onResume();
        my_money.setText(String.valueOf(appication.getYiMoney()));


    }
}
