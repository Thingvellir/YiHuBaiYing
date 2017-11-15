package android.example.com.yihubaiying.fragment.fragment_youyisi;

import android.example.com.yihubaiying.R;
import android.widget.TextView;


/**
 * Created by asus on 2016/6/23.
 */
public class FragmentD extends BaseFragment {
    private String title;
    private TextView txt;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_layout_d;
    }

    @Override
    public void initView() {
        txt = (TextView) view.findViewById(R.id.msg);
        txt.setText("FragmentD:" + title);
    }

    public static FragmentD getInstance(String title) {
        FragmentD mf = new FragmentD();
        mf.title = title;
        return mf;
    }
}
