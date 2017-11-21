package android.example.com.yihubaiying.activity.redvelet;

import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.activity.redvelet.BaseActivity;
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
    private MyHongBao hongBao;
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
        markerId=intent.getStringExtra("markerId");
        markerSnippet=intent.getStringExtra("snippet");
        mSnippet=(TextView) findViewById(R.id.snippet_hongbaoactivity);
        mDetail=(TextView)findViewById(R.id.content_hongbaoactivity);
        hongBao= (MyHongBao)getIntent().getSerializableExtra("hongbao");//这样获取红包对象
        mSnippet.setText(markerSnippet);
        mDetail.setGravity(View.TEXT_ALIGNMENT_CENTER);
switch (markerId){

    case "Marker2":
        mDetail.setText("项目一期主推70-85m²通透两房,95-125m²全功能三房。\n" +
                "项目位于天府核心地段,规划50万平商业集群,尊享便利生活。\n" +
                "地铁4号线、9号线换乘站也将途径这里,双地铁直通城市繁华中心。附近有149路,154路,327路等多条公交线路,出行更加便捷。\n" +
                "479中学尽在咫尺，两所名校可优先入学。\n");
        break;
    case "Marker3":
        mDetail.setText("        香气扑鼻飞尔等\n" +
                "        辣味在喉久迷离\n" +
                "        是非往事随风去\n" +
                "        我也不曾品尝过\n");
       break;
    case "Marker4":
        mDetail.setText("               购物万福佳，幸福千万家\n" +
                "                 天天平价，天天惊喜\n" +
                "                 永辉购物，价格最优  \n" +
                "                 风雨相伴，一载相辉\n" +
                "               周年店庆日，购物狂欢时");
        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.yonghui_one));
        imageView2.setImageDrawable(getResources().getDrawable(R.drawable.yonghui_two));
        imageView3.setImageDrawable(getResources().getDrawable(R.drawable.yonghui_three));
        break;

    case "Marker5":
        mDetail.setText("        送剪发卡 回馈老顾客\n" +
                "凡是在本店做大头的顾客，一律赠送6张精剪卡（有效期为1个月），这样做的目的是吸引客流，增加店内的客流\n" +
                "        烫发0元，倒膜带回家\n" +
                "凡是在店内购买倒膜的顾客，赠送1次烫发，例如：380元一套倒膜，赠送价值280元的烫发一次\n");

        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.ziranmei_one));
        imageView2.setImageDrawable(getResources().getDrawable(R.drawable.ziranmei_two));
        imageView3.setImageDrawable(getResources().getDrawable(R.drawable.ziranmei_three));
        break;
    case "Marker6":
        mDetail.setText("新起点教育为高考生,中考生,小升初考生,艺考生、小学生,初中生,高中生提供全学科一对一个性化辅导补习课程。\n" +
                "在2016年的高考中，在京翰教育参加辅导的高考考生有8％成绩提高100分以上，平均成绩提高40分；中考考生有15％成绩提高100分以上，平均成绩提高40分以上。");
        break;
    case "Marker7":
        mDetail.setText("集二手、新房、租房功能于一体，随时随地任性找房。\n" +
                "IM匿名咨询让您放心，消息动态推送让您省心，服务承诺让您安心，数据百科锦囊让您感受贴心漫漫找房路，我们努力为您想更多。");
        break;
    case "Marker8":
        mDetail.setText("          肯德基花生霸王双层堡霸气登场！\n" +
                "              丰富好料，绝色搭配\n" +
                "外脆里嫩的大块鸡腿肉饱满多汁，搭配大块香酥薯饼，丰富的食材层次分明，一口下去满满都是幸福，厚实的感觉\"堡\"你大满足！\n" +
                "              醇厚花生酱，双层享受\n" +
                "当柔滑香浓的花生酱遇上脆辣鲜嫩的鸡腿肉，两种美味在舌尖碰撞，给味蕾一次新奇体验，前所未有的口感，给你不一样惊喜~");
        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.kfc_one));
        imageView2.setImageDrawable(getResources().getDrawable(R.drawable.kfc_two));
        imageView3.setImageDrawable(getResources().getDrawable(R.drawable.kfc_three));
        break;
    case "Marker9":
        mDetail.setText("如家快捷酒店（阳朔西街店）地处阳朔县北门厄，步行可至著名的阳朔西街，可谓闹中取静。\n" +
                "酒店周边景点和餐饮繁多。从阳朔汽车北站乘坐1路公交车、从阳朔汽车南站乘坐2路公交车或从阳朔县动车候车室（疾控中心站）乘坐3路公交车均可到达酒店，乘车时间约为10分钟。");
        break;
    case "Marker10":
        mDetail.setText("        我们为你提供专业的电脑维修\n " +
                " 电脑维护（硬件安装）、网络维修、常用软件安装、驱动安装。\n" +
                "局域网组建、宽带安装、共享上网、电脑升级、上门维修\n" +
                "        联系电话：13888888888  \n" +
                " 方便 我们便可以让您足不出户，电脑得到专业的维护。\n" +
                "经济 承诺修不好不收费，专业服务，物有所值，既实用又节省开\n");
        break;
    case "Marker11":
        mDetail.setText("        重金求通信学院历年通信原理考试真题，有答案的最好\n" +
                "        联系方式：QQ 17772586321\n" +
                "        电话 15985365468");
        break;
    case "Marker12":
        mDetail.setText("今天在品学楼A区到品学楼C区走廊上丢失一张学生卡，有黄色小黄人的卡套\n" +
                "若有看到的同学请联系我：外国语学院，日语二班，辰伶玲，万分感谢\n" +
                "电话：1564116516");
        break;
    case "Marker13":
        mDetail.setText("        求合租同学，要求不抽烟，不打游戏，个人清洁卫生");
        break;
    case "Marker14":
        mDetail.setText("        哈哈哈哈哈\n" +
                "        \n大家有没有计院院花的联系方式呀");
        break;
    case "Marker15":
        mDetail.setText("        寻人启事：杜应美，女，籍贯：云南省昭通市威信县\n" +
                "出生日期：1995年11月12日，身高：160厘米，右手有残疾，右手的拇指反在手背上，身材苗条，不胖不瘦，右嘴角边有一颗痣。\n" +
                "身份证号为53213019951112****。于2017年11月09日离家出走，至今无音信。\n" +
                "请知情者帮忙提供线索，提供信息酬金：重谢，护送回家酬金：重谢。\n");
        break;
    case "Marker16":
        mDetail.setText("招课余时间送餐同学，送餐时间弹性，按一小时30元结算.\n" +
                "详情可联系：1985655455");
        break;
    case "Marker17":
        mDetail.setText("        寻人启事：杜应美，女，籍贯：云南省昭通市威信县\n" +
                "出生日期：1995年11月12日，身高：160厘米，右手有残疾，右手的拇指反在手背上，身材苗条，不胖不瘦，右嘴角边有一颗痣。\n" +
                "身份证号为53213019951112****。于2017年11月09日离家出走，至今无音信。\n" +
                "请知情者帮忙提供线索，提供信息酬金：重谢，护送回家酬金：重谢。\n");
        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.yangtingfei));
        imageView2.setImageDrawable(getResources().getDrawable(R.drawable.yangtingfei));
        imageView3.setImageDrawable(getResources().getDrawable(R.drawable.yangtingfei));
        break;
    case "Marker18":
        mDetail.setText(hongBao.getGuanggaoyu());
        Glide.with(this).load(hongBao.getImageResourceId().get(0)).into(imageView1);
        Glide.with(this).load(hongBao.getImageResourceId().get(1)).into(imageView2);
        Glide.with(this).load(hongBao.getImageResourceId().get(2)).into(imageView3);
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
