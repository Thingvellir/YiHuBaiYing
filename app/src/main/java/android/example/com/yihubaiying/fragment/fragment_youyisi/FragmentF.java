package android.example.com.yihubaiying.fragment.fragment_youyisi;

import android.example.com.yihubaiying.R;
import android.widget.TextView;


/**
 * Created by asus on 2016/6/23.
 */
public class FragmentF extends BaseFragment {
    private String title;
    private TextView txt;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_layout_f;
    }

    @Override
    public void initView() {
        txt = (TextView) view.findViewById(R.id.msg);
        txt.setText("FragmentF:" + title);
    }

    public static FragmentF getInstance(String title) {
        FragmentF mf = new FragmentF();
        mf.title = title;
        return mf;
    }
}
