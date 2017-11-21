package android.example.com.yihubaiying.application;

import android.app.Application;

/**
 * Created by Thingvellir on 2017/11/21.
 */

public class MyAppication extends Application{
    private double yiMoney =118.03;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public double getYiMoney() {
        return yiMoney;
    }

    public void setYiMoney(double yiMoney) {
        this.yiMoney = yiMoney;
    }
}
