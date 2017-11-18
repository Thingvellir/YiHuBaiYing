package android.example.com.yihubaiying.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.view.View;
import android.widget.Button;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class redpacketdetail_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redpacket_detail_layout);
        Button button= (Button) findViewById(R.id.btn_next_step);

        final SweetAlertDialog pDialog=new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
        pDialog.setTitleText("Good job!").setContentText("You clicked the button!");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SweetAlertDialog pDialog=new SweetAlertDialog(v.getContext(), SweetAlertDialog.SUCCESS_TYPE);
                pDialog.setTitleText("Good job!").setContentText("You clicked the button!");

                pDialog.show();
                startActivity(new Intent(redpacketdetail_activity.this,Newsdetail_activity.class));
            }
        });
    }
}
