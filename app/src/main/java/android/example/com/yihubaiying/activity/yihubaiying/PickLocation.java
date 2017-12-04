package android.example.com.yihubaiying.activity.yihubaiying;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.adapter.MyInfoWinAdapter;
import android.example.com.yihubaiying.enity.MyHongBao;
import android.example.com.yihubaiying.enity.value;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.VisibleRegion;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static net.datafans.android.common.config.AndroidCommon.getContext;

/**
 * Created by carnivalnian on 2017/11/15.
 */

public class PickLocation extends AppCompatActivity implements AMap.OnMapLongClickListener
        ,AMap.OnMyLocationChangeListener ,GeocodeSearch.OnGeocodeSearchListener{

    private AMap aMap;
    private MapView mapView;
    private UiSettings uiSettings;
    private MyLocationStyle myLocationStyle;
    private GeocodeSearch geocoderSearch;
    private ProgressDialog progDialog = null;
    private Marker regeoMarker;
    //获取到的经纬度
    private LatLng pickLatlng;
    //选择的地理位置名字
    private String addressName;
    private Toolbar toolbar;
    private MyHongBao hongbaoa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.picklocation_layout);

        mapView = (MapView) findViewById(R.id.picK_location);
        mapView.onCreate(savedInstanceState);
        hongbaoa=new MyHongBao();
        init();
        progDialog = new ProgressDialog(this);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.white_back_icon1);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent();
//                intent.putExtra("localname",addressName);
//                intent.putExtra("lat",pickLatlng.latitude);
//                intent.putExtra("long",pickLatlng.longitude);
//                Toast.makeText(PickLocation.this, addressName, Toast.LENGTH_SHORT).show();
//                setResult(RESULT_OK,intent);

                value.addressname=addressName;
                value.latLng=pickLatlng;
                finish();
            }
        });
        toolbar.setTitle("请长按选择位置");

    }
    /**
     * 初始化AMap对象
     */
    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();
            setUpMap();
            regeoMarker = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f)
                    .icon(BitmapDescriptorFactory
                            .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        }
    }

    /**
     * amap地图设置
     */
    private void setUpMap() {
        aMap = mapView.getMap();

//地图自定义主题
        setMapCustomStyleFile(this);
        aMap.setMapCustomEnable(true);
//监听
        geocoderSearch = new GeocodeSearch(this);
        geocoderSearch.setOnGeocodeSearchListener(this);
        aMap.setOnMyLocationChangeListener(this);
        aMap.setOnMapLongClickListener(this);// 对amap添加长按地图事件监听器

//视角
        aMap.setMinZoomLevel(15);
        aMap.setMaxZoomLevel(17);
        aMap.moveCamera(CameraUpdateFactory.zoomTo(16));

        //定位蓝点样式，定位模式
        myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.
                fromResource(R.drawable.gps_point));
        myLocationStyle.strokeColor(Color.argb(1, 0, 0, 0));
        myLocationStyle.radiusFillColor(Color.argb(1, 0, 0, 0));

        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE);

        //地图控件
        uiSettings=aMap.getUiSettings();
        uiSettings.setMyLocationButtonEnabled(false);
        uiSettings.setZoomGesturesEnabled(true);
        uiSettings.setScaleControlsEnabled(false);
        uiSettings.setZoomControlsEnabled(false);
        //启动

        aMap.setMyLocationEnabled(true);
        aMap.setMyLocationStyle(myLocationStyle);

    }
    /**
     * 显示进度条对话框
     */
    public void showDialog() {
        progDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progDialog.setIndeterminate(false);
        progDialog.setCancelable(true);
        progDialog.setMessage("正在获取地址");
        progDialog.show();
    }
    /**
     * 隐藏进度条对话框
     */
    public void dismissDialog() {
        if (progDialog != null) {
            progDialog.dismiss();
        }
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }


    /**
     * 对长按地图事件回调
     */
    @Override
    public void onMapLongClick(LatLng point) {
        pickLatlng=point;
        LatLonPoint latLonPoint=new LatLonPoint(point.latitude,point.longitude);
        getAddress(latLonPoint);
    }

    private void setMapCustomStyleFile(Context context) {
        String styleName = "mystyle_sdk_1508946491_0100.data";
        FileOutputStream outputStream = null;
        InputStream inputStream = null;
        String filePath = null;
        try {
            inputStream = context.getAssets().open(styleName);
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);

            filePath = context.getFilesDir().getAbsolutePath();
            File file = new File(filePath + "/" + styleName);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            outputStream = new FileOutputStream(file);
            outputStream.write(b);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();

                if (outputStream != null)
                    outputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        aMap.setCustomMapStylePath(filePath + "/" + styleName);
        aMap.showMapText(true);
    }

    @Override
    public void onMyLocationChange(Location mylocation) {
        // 定位回调监听
        if(mylocation != null) {
            Log.e("pick", "onMyLocationChange 定位成功， lat: " + mylocation.getLatitude() + " lon: " + mylocation.getLongitude());
            Bundle bundle = mylocation.getExtras();
            initHongbaoMarker(mylocation);
            if(bundle != null) {
                int errorCode = bundle.getInt(MyLocationStyle.ERROR_CODE);
                String errorInfo = bundle.getString(MyLocationStyle.ERROR_INFO);
                // 定位类型，可能为GPS WIFI等，具体可以参考官网的定位SDK介绍
                int locationType = bundle.getInt(MyLocationStyle.LOCATION_TYPE);

                /*
                errorCode
                errorInfo
                locationType
                */
                Log.e("pick", "定位信息， code: " + errorCode + " errorInfo: " + errorInfo + " locationType: " + locationType );
            } else {
                Log.e("pick", "定位信息， bundle is null ");

            }

        } else {
            Log.e("pick", "定位失败");
        }
    }

    /**
     * 响应逆地理编码
     */
    public void getAddress(final LatLonPoint latLonPoint) {
        showDialog();
        RegeocodeQuery query = new RegeocodeQuery(latLonPoint, 200,
                GeocodeSearch.AMAP);// 第一个参数表示一个Latlng，第二参数表示范围多少米，第三个参数表示是火系坐标系还是GPS原生坐标系
        geocoderSearch.getFromLocationAsyn(query);// 设置异步逆地理编码请求
    }

    /**
     * 地理编码查询回调
     */
    @Override
    public void onGeocodeSearched(GeocodeResult result, int rCode) {
    }
    /**
     * 逆地理编码回调
     */
    @Override
    public void onRegeocodeSearched(RegeocodeResult result, int rCode) {
        dismissDialog();
        if (rCode == AMapException.CODE_AMAP_SUCCESS) {
            if (result != null && result.getRegeocodeAddress() != null
                    && result.getRegeocodeAddress().getFormatAddress() != null) {
                addressName =result.getRegeocodeAddress().getFormatAddress();
                Toast.makeText(this,"您已选择了"+addressName+ "附近",Toast.LENGTH_SHORT).show();
                aMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                        pickLatlng, 17));
                regeoMarker.setPosition(pickLatlng);
            } else {
                Toast.makeText(this, R.string.no_result,Toast.LENGTH_SHORT).show();
            }
        } else {
            Log.e("pickError",rCode+"");
        }
    }


    public void initHongbaoMarker(Location location){

        if (aMap != null && location != null) {
            Random r=new Random();

            for (int i=0;i<30;i++) {

                LatLng latLng=new LatLng(location.getLatitude() + 0.0013 * (r.nextInt(10) - 5), location.getLongitude() + 0.0014 * (r.nextInt(10) - 5));
                aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f)
                        .position(latLng)
                        .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.people_round))));

            }
        }
    }
}
