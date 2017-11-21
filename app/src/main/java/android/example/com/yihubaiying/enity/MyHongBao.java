package android.example.com.yihubaiying.enity;

import com.amap.api.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Thingvellir on 2017/11/19.
 */

public class MyHongBao implements Serializable{

    private String title;
    private String guanggaoyu;
    private double latitude;
    private double longitude;
    private ArrayList<String> imageResourceId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGuanggaoyu() {
        return guanggaoyu;
    }

    public void setGuanggaoyu(String guanggaoyu) {
        this.guanggaoyu = guanggaoyu;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public ArrayList<String> getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(ArrayList<String> imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
