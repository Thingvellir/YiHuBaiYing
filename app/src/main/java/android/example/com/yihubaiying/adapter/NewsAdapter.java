package android.example.com.yihubaiying.adapter;

import android.example.com.yihubaiying.R;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Thingvellir on 2017/11/9.
 */

public class NewsAdapter extends BaseQuickAdapter<News,BaseViewHolder>{
    public NewsAdapter(int layoutResId,List data){
        super(layoutResId,data);
    }

    @Override


    protected void convert(BaseViewHolder helper, News item) {
        helper.setText(R.id.title,item.getTitle()).setText(R.id.source,item.getSource()).setText(R.id.liuliang,item.getLiuliang());
        Glide.with(mContext).load(item.getImageResourceId()).crossFade().into((ImageView) helper.getView(R.id.pic));
    }
}
