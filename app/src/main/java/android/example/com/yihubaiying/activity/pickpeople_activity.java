package android.example.com.yihubaiying.activity;

import android.content.Intent;
import android.example.com.yihubaiying.enity.MyHongBao;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wenld.smoothcheckbox.SmoothCheckBox;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;

import me.gujun.android.taggroup.TagGroup;

public class pickpeople_activity extends AppCompatActivity {
    private MyHongBao hongBao;

    private String[] sexs = new String[]
            {"男","女"};
    private String[] ages = new String[]
            {"10~19","20~29","30~39","40~49","50~59"};
//    ,"遂宁市","内江市","乐山市","宜宾市","广安市","南充市","达州市"
    private String[] homes = new String[]
            {"成都市","自贡市","攀枝花市","泸州市","绵阳市","德阳市","广元市"};
    private String[] edus = new String[]
            {"初中","高中","专科","本科","研究生","博士及以上"};
//    "四川师范大学","西南民族大学","西南石油大学","西华大学"
    private String[] schos = new String[]
            {"四川大学","电子科技大学","西南交通大学","西南财经大学","四川农业大学","成都理工大学"};
    //            "工学","农学","医学","管理学"}
    private String[] cols = new String[]
            {"经济学","历史学","法学","教育学","文学","理学"};
    private String[] inds = new String[]
            {"广告","建筑业","林木","美容","机械装备制造","学生","媒体/公关","零售","IT/互联网/通信"};
    private String[] jobs = new String[]
            {"基层","工程师","审计师","总经理","人事","店长"};
    private String[] sals = new String[]
            {"0~5000元","5000~10000元","10000~20000元","20000及以上"};
    private String[] marrys = new String[]
            {"已婚","未婚"};

    private String[] childs = new String[]
            {"有子女","无子女"};

    private String[] child_ages = new String[]
            {"0-3岁","3-10岁","10-19岁","20岁及以上"};

    private String[] child_parents = new String[]
            {"已退休","未退休"};

    private String[] believes = new String[]
            {"佛教","无神论","伊斯兰教","基督教","印度教","科学主义"};

    private String[] foods = new String[]
            {"火锅","烤串","麻辣烫","素食","北京菜"};
    private String[] hobbys = new String[]
            {"跑步","单车","足球","游泳","滑雪","台球","舞蹈","射击","射箭"};
    private String[] others = new String[]
            {"IT创业人士","健身爱好者","素食主义者","孤独患者","强迫症","理想主义"};
    private String[] houses = new String[]
            {"有房","无房","租房"};
    private String[] cars = new String[]
            {"无车","10万及以下","10-20万","20-30万","30-40万"};
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickpeople_layout);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setNavigationIcon(R.drawable.white_back_icon1);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setTitle("选择领取者身份");
        hongBao= (MyHongBao) getIntent().getSerializableExtra("hongbao");
        final TagFlowLayout flowLayout= (TagFlowLayout) findViewById(R.id.flow_sex);
        final TagAdapter sexsadapter=new TagAdapter<String>(sexs) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter agesadapter=new TagAdapter<String>(ages) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter homesadapter=new TagAdapter<String>(homes) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter edusadapter=new TagAdapter<String>(edus) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter schosadapter=new TagAdapter<String>(schos) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter colsadapter=new TagAdapter<String>(cols) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter indsadapter=new TagAdapter<String>(inds) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter jobsadapter=new TagAdapter<String>(jobs) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter salsadapter=new TagAdapter<String>(sals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter marrysadapter=new TagAdapter<String>(marrys) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter childsadapter=new TagAdapter<String>(childs) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter child_agesadapter=new TagAdapter<String>(child_ages) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter child_parentsadapter=new TagAdapter<String>(child_parents) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter believesadapter=new TagAdapter<String>(believes) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter foodsadapter=new TagAdapter<String>(foods) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter hobbysadapter=new TagAdapter<String>(hobbys) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter othersadapter=new TagAdapter<String>(others) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter housesadapter=new TagAdapter<String>(houses) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        final TagAdapter carsadapter=new TagAdapter<String>(cars) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(pickpeople_activity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };


        flowLayout.setAdapter(sexsadapter);
        final TagFlowLayout flowLayout_age= (TagFlowLayout) findViewById(R.id.flow_age);
        flowLayout_age.setAdapter(agesadapter);
        final TagFlowLayout flowLayout_home= (TagFlowLayout) findViewById(R.id.flow_home);

        flowLayout_home.setAdapter(homesadapter);
        final TagFlowLayout flowLayout_edu= (TagFlowLayout) findViewById(R.id.flow_edu);
        flowLayout_edu.setAdapter(edusadapter);
        final TagFlowLayout flowLayout_sch= (TagFlowLayout) findViewById(R.id.flow_sch);
        flowLayout_sch.setAdapter(schosadapter);
        final TagFlowLayout flowLayout_col= (TagFlowLayout) findViewById(R.id.flow_col);
        flowLayout_col.setAdapter(colsadapter);
        final TagFlowLayout flowLayout_ind= (TagFlowLayout) findViewById(R.id.flow_ind);
        flowLayout_ind.setAdapter(indsadapter);

        final TagFlowLayout flowLayout_job= (TagFlowLayout) findViewById(R.id.flow_job);
        flowLayout_job.setAdapter(jobsadapter);

        final TagFlowLayout flowLayout_sal= (TagFlowLayout) findViewById(R.id.flow_sal);
        flowLayout_sal.setAdapter(salsadapter);
        final TagFlowLayout flowLayout_marry= (TagFlowLayout) findViewById(R.id.flow_marry);
        flowLayout_marry.setAdapter(marrysadapter);

        final TagFlowLayout flowLayout_child= (TagFlowLayout) findViewById(R.id.flow_child);
        flowLayout_child.setAdapter(childsadapter);


        final TagFlowLayout flowLayout_child_age= (TagFlowLayout) findViewById(R.id.flow_child_age);
        flowLayout_child_age.setAdapter(child_agesadapter);

        final TagFlowLayout flowLayout_child_parent= (TagFlowLayout) findViewById(R.id.flow_child_parent);
        flowLayout_child_parent.setAdapter(child_parentsadapter);

        final TagFlowLayout flowLayout_believe= (TagFlowLayout) findViewById(R.id.flow_believe);
        flowLayout_believe.setAdapter(believesadapter);

        final TagFlowLayout flowLayout_foods= (TagFlowLayout) findViewById(R.id.flow_food);
        flowLayout_foods.setAdapter(foodsadapter);

        final TagFlowLayout flowLayout_hobbys= (TagFlowLayout) findViewById(R.id.flow_hobby);
        flowLayout_hobbys.setAdapter(hobbysadapter);

        final TagFlowLayout flowLayout_houses= (TagFlowLayout) findViewById(R.id.flow_houses);
        flowLayout_houses.setAdapter(housesadapter);

        final TagFlowLayout flowLayout_cars= (TagFlowLayout) findViewById(R.id.flow_cars);
        flowLayout_cars.setAdapter(carsadapter);
        final TagFlowLayout flowLayout_others= (TagFlowLayout) findViewById(R.id.flow_others);
        flowLayout_others.setAdapter(othersadapter);

        Button button= (Button) findViewById(R.id.btn_next_step);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(pickpeople_activity.this,redpacketdetail_activity.class);
                Bundle mBundle=new Bundle();
                mBundle.putSerializable("hongbao",hongBao);
                intent.putExtras(mBundle);
                finish();
                startActivity(intent);
            }
        });
        SmoothCheckBox smoothCheckBox= (SmoothCheckBox) findViewById(R.id.smoothcheckbox);
        smoothCheckBox.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
                if (isChecked){
                    sexsadapter.setSelectedList(0,1);
                    agesadapter.setSelectedList(0,1,2,3,4);
                    homesadapter.setSelectedList(0,1,2,3,4,5,6);
                    edusadapter.setSelectedList(0,1,2,3,4,5);
                    schosadapter.setSelectedList(0,1,2,3,4,5);
                    colsadapter.setSelectedList(0,1,2,3,4,5);
                    indsadapter.setSelectedList(0,1,2,3,4,5,6,7,8);
                    jobsadapter.setSelectedList(0,1,2,3,4,5);
                    salsadapter.setSelectedList(0,1,2,3);
                    marrysadapter.setSelectedList(0,1);
                    childsadapter.setSelectedList(0,1);
                    child_agesadapter.setSelectedList(0,1,2,3);
                    child_parentsadapter.setSelectedList(0,1);
                    believesadapter.setSelectedList(0,1,2,3,4,5);
                    foodsadapter.setSelectedList(0,1,2,3,4);
                    hobbysadapter.setSelectedList(0,1,2,3,4,5,6,7,8);
                    othersadapter.setSelectedList(0,1,2,3,4,5);
                    housesadapter.setSelectedList(0,1,2);
                    carsadapter.setSelectedList(0,1,2,3,4);
                }else{
                    sexsadapter.setSelectedList();
                    agesadapter.setSelectedList();
                    homesadapter.setSelectedList();
                    edusadapter.setSelectedList();
                    schosadapter.setSelectedList();
                    colsadapter.setSelectedList();
                    indsadapter.setSelectedList();
                    jobsadapter.setSelectedList();
                    salsadapter.setSelectedList();
                    marrysadapter.setSelectedList();
                    childsadapter.setSelectedList();
                    child_agesadapter.setSelectedList();
                    child_parentsadapter.setSelectedList();
                    believesadapter.setSelectedList();
                    foodsadapter.setSelectedList();
                    hobbysadapter.setSelectedList();
                    othersadapter.setSelectedList();
                    housesadapter.setSelectedList();
                    carsadapter.setSelectedList();
                }

            }
        });


    }
}
