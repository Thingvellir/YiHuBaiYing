package android.example.com.yihubaiying.activity.redvelet;

import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.activity.redvelet.BaseActivity;
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
import android.widget.TextView;
import android.widget.Toast;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hongbao_content);

        random=(Button) findViewById(R.id.random_get);
        random.setOnClickListener(this);
        checkBox=(CheckBox)findViewById(R.id.checkbox_hongbaocontent);
        back_hongbao=(ImageButton)findViewById(R.id.back_hongbao);
        back_hongbao.setOnClickListener(this);

        Intent intent=getIntent();
        markerId=intent.getStringExtra("markerId");
        markerSnippet=intent.getStringExtra("snippet");

        mSnippet=(TextView) findViewById(R.id.snippet_hongbaoactivity);
        mDetail=(TextView)findViewById(R.id.content_hongbaoactivity);

        mSnippet.setText(markerSnippet);
switch (markerId){
    case "Marker2":
        mDetail.setText("项目一期主推70-85m²通透两房,95-125m²全功能三房。\\n项目位于天府核心地段,规划50万平商业集群,尊享便利生活。\\n地铁4号线、9号线换乘站也将途径这里,双地铁直通城市繁华中心。附近有149路,154路,327路等多条公交线路,出行更加便捷。\\n479中学尽在咫尺，两所名校可优先入学。");
        break;
    case "Marker3":
        mDetail.setText("");
        break;
    case "Marker4":
        break;
    case "Marker5":
        break;
    case "Marker6":
        break;
    case "Marker7":
        break;
    case "Marker8":
        break;
    case "Marker9":
        break;
    case "Marker10":
        break;
    case "Marker11":
        break;
    case "Marker12":
        break;
    case "Marker13":
        break;
    case "Marker14":
        break;
    case "Marker15":
        break;
    case "Marker16":
        break;
    case "Marker17":
        break;

}
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.random_get:
                if(checkBox.isChecked()) {
                    Intent thisIntent=new Intent(HongBaoActivity.this, RandomHongbaoActivity.class);
                    thisIntent.putExtra("snippet",markerSnippet);
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
