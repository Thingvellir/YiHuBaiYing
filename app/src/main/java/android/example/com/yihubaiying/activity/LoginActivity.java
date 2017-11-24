package android.example.com.yihubaiying.activity;

import android.content.Intent;
import android.example.com.yihubaiying.MainActivity;
import android.example.com.yihubaiying.activity.redvelet.BaseActivity;
import android.example.com.yihubaiying.utils.AppManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amap.api.maps.model.Text;

public class LoginActivity extends BaseActivity {
    private Button button;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button= (Button) findViewById(R.id.de_login_sign);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });
        register= (TextView) findViewById(R.id.de_login_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                finish();
            }
        });

    }
}
