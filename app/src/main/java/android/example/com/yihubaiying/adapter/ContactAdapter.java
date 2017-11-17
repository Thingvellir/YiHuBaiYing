package android.example.com.yihubaiying.adapter;

import android.example.com.yihubaiying.R;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Thingvellir on 2017/11/2.
 */

public class ContactAdapter extends BaseQuickAdapter<ContactItem,BaseViewHolder> {

    public ContactAdapter(int layoutResId,List data){
        super(layoutResId,data);
    }
    protected void convert(BaseViewHolder helper, ContactItem item) {
        helper.setText(R.id.contact_title,item.getName()).setImageResource(R.id.contact_tel,item.getTelImageId());
        Glide.with(mContext).load(item.getUserImageId()).crossFade().into((ImageView) helper.getView(R.id.contact_user));
    }
}
