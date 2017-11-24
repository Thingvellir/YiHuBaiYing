package android.example.com.yihubaiying.activity;

import android.content.Intent;
import android.example.com.yihubaiying.MainActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        button= (Button) findViewById(R.id.reg_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
