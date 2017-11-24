package android.example.com.yihubaiying.activity.redvelet;
import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.activity.redvelet.BaseActivity;
import android.example.com.yihubaiying.activity.redvelet.JiaQunActivity;
import android.example.com.yihubaiying.activity.redvelet.ZhuanFaActivity;
import android.example.com.yihubaiying.enity.HongBao;
import android.example.com.yihubaiying.utils.AppManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by carnivalnian on 2017/11/8.
 */

public class SelectHongbaoActivity extends BaseActivity implements View.OnClickListener{
    private Button daodian;
    private Button zhuanfa;
    private Button jiaqun;
    private Button diaocha;
    private ImageButton back_hongbaoselect;
    private String thisSnippet;
    private TextView thisTextView;
    private HongBao passedHongBao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.hongbao_select);


        daodian=(Button)findViewById(R.id.daodian_get);
        zhuanfa=(Button)findViewById(R.id.zhuanfa_get);
        jiaqun=(Button)findViewById(R.id.jiaqun_get);
        diaocha=(Button)findViewById(R.id.diaocha_get);
        back_hongbaoselect=(ImageButton)findViewById(R.id.back_hongbaoselect);

        daodian.setOnClickListener(this);
        zhuanfa.setOnClickListener(this);
        jiaqun.setOnClickListener(this);
        diaocha.setOnClickListener(this);
        back_hongbaoselect.setOnClickListener(this);
//
//        Intent intent=getIntent();
//        thisSnippet=intent.getStringExtra("snippet");
//        thisTextView=(TextView)findViewById(R.id.tittle_select);
//        thisTextView.setText(thisSnippet);
        passedHongBao=(HongBao)getIntent().getSerializableExtra("hongbao");
        thisSnippet=passedHongBao.getSnippet();
        thisTextView=(TextView)findViewById(R.id.tittle_select);
        thisTextView.setText(thisSnippet);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.daodian_get:
                break;
            case R.id.zhuanfa_get:
                Intent thisIntent=new Intent(SelectHongbaoActivity.this,ZhuanFaActivity.class);
                Bundle mBundle=new Bundle();
                mBundle.putSerializable("hongbao",passedHongBao);
                thisIntent.putExtras(mBundle);
                startActivity(thisIntent);
                AppManager.getAppManager().finishActivity(this);
                break;
            case R.id.jiaqun_get:
                Intent thatIntent=new Intent(SelectHongbaoActivity.this,JiaQunActivity.class);
                Bundle nBundle=new Bundle();
                nBundle.putSerializable("hongbao1",passedHongBao);
                thatIntent.putExtras(nBundle);
                startActivity(thatIntent);
                AppManager.getAppManager().finishActivity(this);
                break;
            case R.id.diaocha_get:
                break;
            case R.id.back_hongbaoselect:
                AppManager.getAppManager().finishActivity(this);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AppManager.getAppManager().finishActivity(this);
    }
}
