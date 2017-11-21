package android.example.com.yihubaiying.activity.redvelet;

import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.activity.redvelet.BaseActivity;
import android.example.com.yihubaiying.enity.HongBao;
import android.example.com.yihubaiying.enity.MyHongBao;
import android.example.com.yihubaiying.utils.AppManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.test.suitebuilder.TestMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import static android.example.com.yihubaiying.R.id.imageView;
import static com.amap.api.col.sl3.dj.m;


/**
 * Created by carnivalnian on 2017/10/31.
 */

public class HongBaoActivity extends BaseActivity implements View.OnClickListener{
    private ImageButton back_hongbao;
    private Button random;
    private CheckBox checkBox;
    private String markerId;
    private String markerTittle;
    private String markerSnippet;
    private TextView mSnippet;
    private TextView mDetail;


    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;


    private HongBao passedHongBao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hongbao_content);

        random=(Button) findViewById(R.id.random_get);
        random.setOnClickListener(this);
        checkBox=(CheckBox)findViewById(R.id.checkbox_hongbaocontent);
        back_hongbao=(ImageButton)findViewById(R.id.back_hongbao);
        back_hongbao.setOnClickListener(this);

        imageView1=(ImageView) findViewById(R.id.content_image1);
        imageView2=(ImageView) findViewById(R.id.content_image2);
       imageView3=(ImageView) findViewById(R.id.content_image3);

        Intent intent=getIntent();
        passedHongBao=(HongBao)getIntent().getSerializableExtra("hongbao");
        mSnippet=(TextView) findViewById(R.id.snippet_hongbaoactivity);
        mDetail=(TextView)findViewById(R.id.content_hongbaoactivity);
        mSnippet.setText(passedHongBao.getSnippet());
        mDetail.setGravity(View.TEXT_ALIGNMENT_CENTER);
        mDetail.setText(passedHongBao.getDetail());
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
        switch (v.getId()){
            case R.id.random_get:
                if(checkBox.isChecked()) {
                    Intent thisIntent=new Intent(HongBaoActivity.this, RandomHongbaoActivity.class);
                    Bundle mBundle=new Bundle();
                    mBundle.putSerializable("hongbao",passedHongBao);
                    thisIntent.putExtras(mBundle);
                    thisIntent.putExtra("from","HongBaoActivity");
                    startActivity(thisIntent);
                    AppManager.getAppManager().finishActivity(this);
                }
                else {
                    Toast.makeText(this,"请您先阅读并同意相关红包领取规则",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.back_hongbao:
                AppManager.getAppManager().finishActivity(this);
                break;
        }
    }

}
