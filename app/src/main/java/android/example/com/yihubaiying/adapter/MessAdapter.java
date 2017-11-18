package android.example.com.yihubaiying.adapter;

import android.example.com.yihubaiying.R;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Thingvellir on 2017/11/2.
 */

public class MessAdapter extends BaseQuickAdapter<Message,BaseViewHolder> {
    int[] shuzu={1,2,5,9,7};

    public MessAdapter(int layoutResId,List data){
        super(layoutResId,data);
    }
    protected void convert(BaseViewHolder helper, Message item) {

        helper.setText(R.id.mess_title,item.getTitle());
        helper.setText(R.id.mess_content,item.getContent()).setText(R.id.mess_time,item.getTime());
        helper.setImageResource(R.id.mess_state,item.getStateImageId());
        Glide.with(mContext).load(item.getUserImageId()).crossFade().into((ImageView) helper.getView(R.id.mess_user));
        if (Arrays.binarySearch(shuzu,helper.getPosition())>0){
            helper.getView(R.id.mess_state).setVisibility(View.INVISIBLE);
        }

    }
}
