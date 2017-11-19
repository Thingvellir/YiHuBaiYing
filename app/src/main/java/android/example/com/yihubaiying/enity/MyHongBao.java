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
    private LatLng latLng;
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

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public ArrayList<String> getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(ArrayList<String> imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
