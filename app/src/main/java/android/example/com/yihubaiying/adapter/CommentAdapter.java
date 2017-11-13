package android.example.com.yihubaiying.adapter;

import android.example.com.yihubaiying.R;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Thingvellir on 2017/11/9.
 */

public class CommentAdapter extends BaseQuickAdapter<CommentItem,BaseViewHolder>{

    public CommentAdapter(int layoutResId,List data){
        super(layoutResId,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentItem item) {

        helper.setImageResource(R.id.comment_image,item.getImageResourceId()).setText(R.id.comment_nickname,item.getNickname()).setText(R.id.comment_time,item.getTime()).setText(R.id.comment_content,item.getContent()).setImageResource(R.id.comment_good,item.getGoodPicId());

    }
}
