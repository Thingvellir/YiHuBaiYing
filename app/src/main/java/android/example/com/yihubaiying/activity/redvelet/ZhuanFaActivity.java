package android.example.com.yihubaiying.activity.redvelet;

import android.content.Intent;
import android.example.com.yihubaiying.MainActivity;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.enity.HongBao;
import android.example.com.yihubaiying.utils.AppManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import me.curzbin.library.BottomDialog;
import me.curzbin.library.Item;
import me.curzbin.library.OnItemClickListener;

/**
 * Created by carnivalnian on 2017/11/10.
 */

public class ZhuanFaActivity extends BaseActivity implements View.OnClickListener {
    private EditText comments_txt;
    private Button zhuanfa_btn;
    private String thisSnippet;
    private TextView thisTextView;
    private HongBao passedHongBao;

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_zhuanfa);


        comments_txt=(EditText)findViewById(R.id.comments);
        zhuanfa_btn=(Button)findViewById(R.id.zhuanfa_jump);
        zhuanfa_btn.setOnClickListener(this);
        imageView1=(ImageView)findViewById(R.id.zhuanfa_image1);
        imageView2=(ImageView)findViewById(R.id.zhuanfa_image2);
        imageView3=(ImageView)findViewById(R.id.zhuanfa_image3);

//        Intent intent=getIntent();
//        thisSnippet=intent.getStringExtra("snippet");
//        thisTextView=(TextView)findViewById(R.id.title_zhuanfa);
//        thisTextView.setText(thisSnippet);
        passedHongBao=(HongBao)getIntent().getSerializableExtra("hongbao");
        thisSnippet=passedHongBao.getSnippet();
        thisTextView=(TextView)findViewById(R.id.title_zhuanfa);
        thisTextView.setText(thisSnippet);

        switch (passedHongBao.getId()){
            case 0:
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.hongbao_image1));
                imageView2.setImageDrawable(getResources().getDrawable(R.drawable.hongbao_image2));
                imageView3.setImageDrawable(getResources().getDrawable(R.drawable.hongbao_image3));
                break;
            case 2:
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.yonghui_one));
                imageView2.setImageDrawable(getResources().getDrawable(R.drawable.yonghui_two));
                imageView3.setImageDrawable(getResources().getDrawable(R.drawable.yonghui_three));
                break;
            case 3:
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.ziranmei_one));
                imageView2.setImageDrawable(getResources().getDrawable(R.drawable.ziranmei_two));
                imageView3.setImageDrawable(getResources().getDrawable(R.drawable.ziranmei_three));
                break;
            case 6:
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.kfc_one));
                imageView2.setImageDrawable(getResources().getDrawable(R.drawable.kfc_two));
                imageView3.setImageDrawable(getResources().getDrawable(R.drawable.kfc_three));
                break;
            case 15:
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.yangtingfei));
                imageView2.setImageDrawable(getResources().getDrawable(R.drawable.yangtingfei));
                imageView3.setImageDrawable(getResources().getDrawable(R.drawable.yangtingfei));
                break;
            default:
                Glide.with(this).load(passedHongBao.getImageResourceId().get(0)).into(imageView1);
                Glide.with(this).load(passedHongBao.getImageResourceId().get(1)).into(imageView2);
                Glide.with(this).load(passedHongBao.getImageResourceId().get(2)).into(imageView3);
        }
    }
    @Override
    public void onClick(View v){
        if(v.getId()==R.id.zhuanfa_jump){
            new BottomDialog(ZhuanFaActivity.this)
                    .title("分享到")
                    .orientation(BottomDialog.HORIZONTAL)
                    .inflateMenu(R.menu.menu_share, new OnItemClickListener() {
                        @Override
                        public void click(Item item) {
                            Toast.makeText(ZhuanFaActivity.this, getString(R.string.share_title) + item.getTitle() +"成功", Toast.LENGTH_SHORT).show();
                            Intent thisIntent=new Intent(ZhuanFaActivity.this,RandomHongbaoActivity.class);
                            thisIntent.putExtra("from","ZhuanFaActivity");
                            Bundle mBundle=new Bundle();
                            mBundle.putSerializable("hongbao",passedHongBao);
                            thisIntent.putExtras(mBundle);
                            startActivity(thisIntent);
                            AppManager.getAppManager().finishActivity(ZhuanFaActivity.this);
                        }
                    })
                    .show();


        }
    }
}
