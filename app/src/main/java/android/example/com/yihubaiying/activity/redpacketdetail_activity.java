package android.example.com.yihubaiying.activity;

import android.content.Intent;
import android.example.com.yihubaiying.MainActivity;
import android.example.com.yihubaiying.enity.MyHongBao;
import android.example.com.yihubaiying.enity.value;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.amap.api.maps.model.LatLng;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class redpacketdetail_activity extends AppCompatActivity {
    private MyHongBao hongBao;
    private Toolbar toolbar;
    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;
    private CardView cardView4;
    private LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redpacket_detail_layout);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setNavigationIcon(R.drawable.white_back_icon1);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setTitle("设置红包金额");
        cardView1= (CardView) findViewById(R.id.card1);
        cardView2= (CardView) findViewById(R.id.card2);
        cardView3= (CardView) findViewById(R.id.card3);
        cardView4= (CardView) findViewById(R.id.card4);
        latLng=new LatLng(value.latLng.latitude,value.latLng.longitude);
        ImageView delect1= (ImageView) findViewById(R.id.delect1);
        delect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView1.setVisibility(View.GONE);

            }
        });
        ImageView delect2= (ImageView) findViewById(R.id.delect2);
        delect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView2.setVisibility(View.GONE);

            }
        });
        ImageView delect3= (ImageView) findViewById(R.id.delect3);
        delect3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView3.setVisibility(View.GONE);

            }
        });
        ImageView delect4= (ImageView) findViewById(R.id.delect4);
        delect4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView4.setVisibility(View.GONE);

            }
        });
         hongBao= (MyHongBao) getIntent().getSerializableExtra("hongbao");
        hongBao.setLatitude(latLng.latitude);
        hongBao.setLongitude(latLng.longitude);
        final String ImageResourceId=hongBao.getTitle();

        final Button button= (Button) findViewById(R.id.btn_next_step);
//        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//        pDialog.setTitleText("Loading");
//        pDialog.setCancelable(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),ImageResourceId,Toast.LENGTH_SHORT).show();


                final DialogPlus dialog=DialogPlus.newDialog(redpacketdetail_activity.this).setContentHolder(new ViewHolder(R.layout.dialog_pay)).setGravity(Gravity.BOTTOM).create();
                Button button1= (Button) dialog.getHolderView().findViewById(R.id.btn_save);
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"支付成功",Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(redpacketdetail_activity.this,MainActivity.class);//跳东西在这里更改
                                        Bundle mBundle=new Bundle();
                                        mBundle.putSerializable("hongbao",hongBao);
                                        intent.putExtras(mBundle);
                                        startActivity(intent);
                        finish();
                    }
                });

                dialog.show();

            }
        });
    }
}
