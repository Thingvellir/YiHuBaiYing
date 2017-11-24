package android.example.com.yihubaiying.fragment.fragment_hongbaomap;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.example.com.yihubaiying.R;
import android.example.com.yihubaiying.activity.redvelet.HongBaoActivity;
import android.example.com.yihubaiying.adapter.MyInfoWinAdapter;
import android.example.com.yihubaiying.adapter.RollingAdapter;
import android.example.com.yihubaiying.application.MyAppication;
import android.example.com.yihubaiying.enity.HongBao;
import android.example.com.yihubaiying.enity.MyHongBao;
import android.example.com.yihubaiying.loader.GlideImageLoader;
import android.example.com.yihubaiying.utils.PermissionRequest;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.jkb.rollinglayout.RollingLayout;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.PermissionListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.example.com.yihubaiying.enity.value.latLng;
import static com.amap.api.col.sl3.dj.m;
import static com.amap.api.col.sl3.dj.n;

/**
 * Created by carnivalnian on 2017/10/21.
 *
 * ToDo:1、怎么构造红包，让跳转activity时知道是哪个红包，并传进信息（id，tittle，snippet，detail）2、新的标题栏布局 3、滚轮数字逻辑，和留出数据对外访问接口
 *
 *
 */

public  class Fragment_HongBao extends LazyFragment implements AMap.OnMyLocationChangeListener,
        AMap.OnMarkerClickListener,
        View.OnClickListener,
        AMap.OnMapClickListener,
        CancelableCallback,
        AMap.OnInfoWindowClickListener,
        AMap.OnMapLongClickListener{

    private static final int STROKE_COLOR = Color.argb(180, 3, 145, 255);
    private static final int FILL_COLOR = Color.argb(10, 0, 0, 180);
    public static boolean isInit = true;
    private boolean isAdded=false;
    private Banner banner;
    private AMap aMap;
    private TextureMapView mapView;
    private UiSettings uiSettings;
    private MyLocationStyle myLocationStyle;
    private Bitmap mBitmap;

    private TextView numHongbao;

    private ImageButton location_btn;
    private CardView cardView;

    private Marker pickedMarker;

    private MyInfoWinAdapter adapter;
    private ArrayList<HongBao>hongBaos;
    private LatLng mineLatLng;
    private View markerView;
    private Marker markerLocal;


    private Circle circle;


    private Dialog hongbaoDia;
    private ImageButton openRedvelet;
    private Button closeDia;
    private TextView hongbaoDiaText;


    private RollingAdapter rollingAdapter;
    private LinearLayout linearLayout1;
    private MyAppication appication;
    private TextView mymoney;

    private MyHongBao hongBao;

    private PermissionRequest permissionRequest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_hongbao,container,false);
        isInit=true;
        mapView=(TextureMapView)view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        Log.e("fragment_1","onCreate");
//        AndPermission.with()
//                .requestCode(101)
//                .permission(
//                        // 申请多个权限组方式：
//                        Permission.LOCATION,
//                        Permission.STORAGE
//                )
//                .callback(listener)
//                .start();
        permissionRequest = new PermissionRequest(getContext(), new PermissionRequest.PermissionCallback() {
            @Override
            public void onSuccessful() {

            }

            @Override
            public void onFailure() {

            }
        });
        permissionRequest.request();
        initView(view);
        setUpMap();
        appication= (MyAppication) getActivity().getApplicationContext();
        mymoney= (TextView) view.findViewById(R.id.xuanfutiao_money);



        return view;
    }


    private void initView(View view) {


        linearLayout1 = (LinearLayout) view.findViewById(R.id.linear11);
        rollingAdapter = new RollingAdapter(getContext());
        RollingLayout rollingLeftRight = (RollingLayout) view.findViewById(R.id.rollingleftRight);
        rollingLeftRight.setAdapter(rollingAdapter);
        rollingLeftRight.startRolling();

        initTitleList();
        initSnipprtList();
        initDetailList();
        initHongbao();
        initBanner(view);
        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        markerView=inflater.inflate(R.layout.marker_hongbao,null);
        numHongbao =(TextView)markerView.findViewById(R.id.num_hongbao);
        location_btn=(ImageButton) view.findViewById(R.id.location_bt);
    }

    public void initBanner(View view){
        banner=(Banner)view.findViewById(R.id.banner);
        List<Integer> list=new ArrayList<>();
        List<String> mlist=new ArrayList<>();
        list.add(R.drawable.banner_image1);
        list.add(R.drawable.banner_image2);
        list.add(R.drawable.banner_image3);
        mlist.add("中海国际新房优惠");
        mlist.add("中海国际新盘开售");
        mlist.add("中海国际房价一览");
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImages(list)
                .setImageLoader(new GlideImageLoader())
                .setBannerTitles(mlist)
                .start();
    }

    public void setUpMap(){
        aMap = mapView.getMap();

//地图自定义主题
        setMapCustomStyleFile(getContext());
        aMap.setMapCustomEnable(true);
//入果点击事件没反应看看是否监听器初始化了
        adapter=new MyInfoWinAdapter(getContext());
        aMap.setInfoWindowAdapter(adapter);
//监听
        aMap.setOnMyLocationChangeListener(this);
        aMap.setOnMapClickListener(this);
        aMap.setOnMarkerClickListener(this);
        aMap.setOnInfoWindowClickListener(this);
        aMap.setOnMapLongClickListener(this);
        location_btn.setOnClickListener(this);

//视角
        aMap.setMinZoomLevel(15);
        aMap.setMaxZoomLevel(17);
        aMap.moveCamera(CameraUpdateFactory.zoomTo(17));

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

    @Override
    protected void lazyLoad() {

        if (null != aMap) {
            //每次重新加载地图前，清除数据
            aMap.clear();
            markerLocal = null;
            isAdded=false;
        }
        setUpMap();
    }

    /**
     * 方法必须重写
     */
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
        aMap.reloadMap();
        mymoney.setText(appication.getYiMoney()+"元");
        Log.e("fragment_1","onResume");
    }

    /**
     * 方法必须重写
     */
    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
        aMap.reloadMap();
        Log.e("fragment_1","onPause");
    }

    /**
     * 方法必须重写
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        mapView.onDestroy();
        Log.e("fragment_1","onDestroyView");
    }

    /**
     * 方法必须重写
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("fragment_1","onDestroy");
    }



    @Override
    public void onMyLocationChange(Location mylocation) {
        // 定位回调监听
        if(mylocation != null) {
            Log.e("amap", "onMyLocationChange 定位成功， lat: " + mylocation.getLatitude() + " lon: " + mylocation.getLongitude());
            Bundle bundle = mylocation.getExtras();
            mineLatLng=new LatLng(mylocation.getLatitude(),mylocation.getLongitude());
            if(isAdded==false) {

                initHongbaoMarker(mylocation);
                isAdded=true;

            }
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
                Log.e("amap", "定位信息， code: " + errorCode + " errorInfo: " + errorInfo + " locationType: " + locationType );
            } else {
                Log.e("amap", "定位信息， bundle is null ");

            }

        } else {
            Log.e("amap", "定位失败");
        }
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
//   红包逻辑：

    //    1、构造红包
//                拿到位置
//            构造随机红包位置信息
//    传入参数
//          {
//              bitmap方法：
//              view初始化
//              view转化成bitmap
//              改变bitmap大小
//          }
    //   添加红包
//    2、红包点击事件：
//        a、根据位置画范围圈  onmylocationchange回掉时调用 有isadded判断
//        b、显示infowindow
//                点击infowindow进入红包事件
//        c、点击屏幕取消显示
    private ArrayList<String> titleList=new ArrayList<>();
    private void initTitleList(){

        titleList.add("商家 中海国际");
        titleList.add("商家 川西坝子");
        titleList.add("商家 永辉超市");
        titleList.add("商家 自然美理发");
        titleList.add("商家 新起点教育");
        titleList.add("商家 链家");
        titleList.add("商家 KFC");
        titleList.add("商家 快捷酒店");
        titleList.add("商家 安杰电脑维修");
        titleList.add("用户 王三");
        titleList.add("用户 胡一菲");
        titleList.add("用户 飞翔的荷兰豆");
        titleList.add("用户 lypeer");
        titleList.add("用户 电子科大杨伟豪");
        titleList.add("用户 李杰钰");
        titleList.add("用户 杨廷飞");


    }
    private ArrayList<String> snippetList=new ArrayList<>();
    private void initSnipprtList(){
        snippetList.add("中海左岸，十一国庆，盛大开盘，回馈全城");
        snippetList.add("新店开张，全场八折，正宗火锅，畅享热辣");
        snippetList.add("十一购物狂欢月，史上最大优惠，欢迎来购");
        snippetList.add("理发店重新装修完毕，欢迎新老客户光临");
        snippetList.add("名师汇聚，打造最强考研补习班，还等什么，赶快报名");
        snippetList.add("还在为寻找优质二手房苦恼吗，快来链家，我们是专业的");
        snippetList.add("TFBOYS代言，全新花生鸡排堡隆重上市，快来尝鲜");
        snippetList.add("钟点房，日房开始优惠啦");
        snippetList.add("电脑维修，安装固态，手机维修贴膜，认准安杰");
        snippetList.add("重金求通信原理历年考试真题");
        snippetList.add("失物寻找，一张饭卡胡一菲");
        snippetList.add("寻找合租，坐标成都合院");
        snippetList.add("求计院院花联系方式");
        snippetList.add("求在银桦广场投宿舍347一票");
        snippetList.add("招聘送餐兼职学生");
        snippetList.add("寻人启示");

    }

    private ArrayList<String> detailList=new ArrayList<>();
    private void initDetailList(){
        detailList.add("    项目一期主推70-85m²通透两房,95-125m²全功能三房。\n" +
                "   项目位于天府核心地段,规划50万平商业集群,尊享便利生活。\n" +
                "   地铁4号线、9号线换乘站也将途径这里,双地铁直通城市繁华中心。附近有149路,154路,327路等多条公交线路,出行更加便捷。\n"+
                "   479中学尽在咫尺，两所名校可优先入学。\n");

        detailList.add("    全场最低3折起售，更有好礼相赠。\n"+
                "当天前1000名顾客可免费获得精品购物袋一个，前5000名顾客可获得纪念挂饰一个。\n"+
                "    凡在周年店庆期间一次购物消费每满100元，都会获得周年店庆大礼包抽奖卷一张。\n"+
                "    一等奖价值9999的金条一块，二等奖价值3999的家庭电视一台，三等奖小米空气净化器一个，凡参与抽奖的顾客都将获得精美小奖品一份。还等什么，快来购物吧！");
        detailList.add("      庆祝装修完毕，特别推出以下活动：\n" +
                "   凡是在本店做大头的顾客，一律赠送6张精剪卡（有效期为1个月）。\n" +
                "   学生客户可凭相应证件，可免费享受精品洗剪吹一次，如果办理会员卡，还可加赠3次。\n" +
                "   凡是在店内购买染烫年卡的顾客，赠送1次烫发机会卷，可给他人使用。\n");
        detailList.add("        肯德基花生霸王双层堡霸气登场！\n" +
                "丰富好料，绝色搭配：\n" +
                "    外脆里嫩的大块鸡腿肉饱满多汁，搭配香酥薯饼，丰富的食材层次分明，一口下去满满都是幸福，厚实的感觉 “堡” 你大满足！\n" +
                "醇厚花生酱，双层享受：\n" +
                "    当柔滑香浓的花生酱遇上脆辣鲜嫩的鸡腿肉，两种美味在舌尖碰撞，给味蕾一次新奇体验，前所未有的口感，给你不一样惊喜");
        detailList.add("   杜应美，女，籍贯：云南省昭通市威信县\n" +
                "出生日期：1995年11月12日，身高：160厘米，右手有残疾，右手的拇指反在手背上，身材苗条，不胖不瘦，右嘴角边有一颗痣。\n" +
                "身份证号为53213019951112****。于2017年11月09日离家出走，至今无音信。\n" +
                "   请知情者帮忙提供线索，提供信息酬金：重谢，护送回家酬金：重谢。\n");

    }



    private void initHongbao(){
        hongBaos=new ArrayList<>();
        for (int i=0;i<16;i++){
            final HongBao mHongBao=new HongBao();
            mHongBao.setId(i);
            mHongBao.setNumber(88);
            mHongBao.setTitle(titleList.get(i));
            mHongBao.setSnippet(snippetList.get(i));
            mHongBao.setDetail("");
            hongBaos.add(mHongBao);
        }
        hongBaos.get(0).setDetail(detailList.get(0));
        hongBaos.get(2).setDetail(detailList.get(1));
        hongBaos.get(3).setDetail(detailList.get(2));
        hongBaos.get(6).setDetail(detailList.get(3));
        hongBaos.get(15).setDetail(detailList.get(4));

        hongBao= (MyHongBao)getActivity().getIntent().getSerializableExtra("hongbao");//这样获取红包对象
        if(hongBao!=null) {
            HongBao newHongBao = new HongBao();
            newHongBao.setId(hongBaos.size() + 1);
            newHongBao.setNumber(88);
            newHongBao.setTitle(hongBao.getTitle());
            newHongBao.setSnippet(hongBao.getGuanggaoyu());
            newHongBao.setImageResourceId(hongBao.getImageResourceId());
            hongBaos.add(newHongBao);
        }
    }


    private ArrayList<Integer> idList=new ArrayList<>();
    private ArrayList<String> markeridList=new ArrayList<>();
    public void initHongbaoMarker(Location location){

        if (aMap != null && location != null) {
            Random r = new Random(1);
            mBitmap = convertViewToBitmap(markerView);
            for (int i = 0; i < 16; i++) {

                LatLng latLng = new LatLng(location.getLatitude() + 0.001 * (r.nextInt(10) - 5), location.getLongitude() + 0.001 * (r.nextInt(10) - 5));
                final Marker marker = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f)
                        .position(latLng)
                        .title(hongBaos.get(i).getTitle())
                        .snippet(hongBaos.get(i).getSnippet())
                        .icon(BitmapDescriptorFactory.fromBitmap(changeBitmapSize(mBitmap))));
                idList.add(hongBaos.get(i).getId());
                markeridList.add(marker.getId());
                Log.e("id", idList.get(i) + "");
            }
            if (hongBaos.size() > 16) {
                for (int i = 16; i < hongBaos.size(); i++) {
                    LatLng thislat=new LatLng(hongBao.getLatitude(),hongBao.getLongitude());
                    final Marker yiMarker = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f)
                            .position(thislat)
                            .title(hongBaos.get(i).getTitle())
                            .snippet(hongBaos.get(i).getSnippet())
                            .icon(BitmapDescriptorFactory.fromBitmap(changeBitmapSize(mBitmap))));
                    idList.add(hongBaos.get(i).getId());
                    markeridList.add(yiMarker.getId());
                }
            }
        }
    }



    private Bitmap changeBitmapSize(Bitmap bitmap) {
        numHongbao.setText("88");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //计算压缩的比率
        double scaleWidth=0.68;
        double scaleHeight=0.68;
        //获取想要缩放的matrix
        Matrix matrix = new Matrix();
        matrix.postScale((float) scaleWidth,(float) scaleHeight);
        //获取新的bitmap
        bitmap=Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);
        bitmap.getWidth();
        bitmap.getHeight();
        return bitmap;
    }

    public static Bitmap convertViewToBitmap(View view) {

        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }


    /**
     * 对marker标注点点击响应事件
     */
    @Override
    public boolean onMarkerClick( Marker marker) {
        if (aMap != null) {
            if(circle!=null) {
                circle.remove();
            }

            if (!marker.getPosition().equals(mineLatLng)&&marker!=pickedMarker) {

                markerLocal = marker;
                changeCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(
                        markerLocal.getPosition(), 17, 0, 0)), this);
            }
        }
        //返回 “false”，除定义的操作之外，默认操作也将会被执行（如果有infowindow会调用方法显示出来）
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.location_bt:
                if(v.getId()==R.id.location_bt)
                    if (markerLocal != null) {
                        markerLocal.hideInfoWindow();
                        markerLocal = null;
                    }
                changeCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(
                        mineLatLng, 17, 0, 0)),this);
                break;
            case R.id.open_btn:
                int passId= markeridList.indexOf(markerLocal.getId());
                HongBao passHongBao=hongBaos.get(passId);
                Intent intent=new Intent(getActivity(),HongBaoActivity.class);
                Bundle mBundle=new Bundle();
                mBundle.putSerializable("hongbao",passHongBao);
                intent.putExtras(mBundle);
                startActivity(intent);
                hongbaoDia.dismiss();
                break;
            case R.id.close:
                hongbaoDia.dismiss();
        }




    }
    @Override
    public void onMapClick(LatLng point){
        //点击地图上没marker 的地方，隐藏inforwindow
        banner.setVisibility(View.GONE);
        linearLayout1.setVisibility(View.VISIBLE);
        if (markerLocal != null) {
            circle.remove();
            markerLocal.hideInfoWindow();
            markerLocal=null;

        }
        if(pickedMarker!=null){
            pickedMarker.remove();
        }

    }
    @Override
    public void onMapLongClick(LatLng point){
        if(pickedMarker!=null){
            pickedMarker.remove();

        }
        pickedMarker = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f)
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED))
        .title("在此处发布红包")
                .snippet("详细发布信息编辑请点击窗口跳转")
        .infoWindowEnable(true));
        pickedMarker.setPosition(point);
        pickedMarker.showInfoWindow();

    }

    @Override
    public void onInfoWindowClick(Marker marker){
        if(marker == pickedMarker){
            pickedMarker.hideInfoWindow();
            pickedMarker.remove();


        }else {
            marker.hideInfoWindow();
            circle.remove();
            float distance = AMapUtils.calculateLineDistance(mineLatLng,marker.getPosition());
            if(distance>300){
                Toast.makeText(getContext(),"距离太远，您无法领取红包",Toast.LENGTH_SHORT).show();
            }else {

                showDialog();
                hongbaoDiaText.setText(marker.getTitle());
            }
        }
    }

    /**
     * 地图动画效果终止回调方法
     */
    @Override
    public void onCancel() {

    }


    private void showDialog() {
        hongbaoDia=new Dialog(getContext(),R.style.MyDialog);

        Window window=hongbaoDia.getWindow();
        window.setContentView(R.layout.dialog_default);
        window.setGravity(Gravity.CENTER);
        hongbaoDia.setCanceledOnTouchOutside(true);
        hongbaoDia.setCancelable(true);
        WindowManager.LayoutParams lp = hongbaoDia.getWindow().getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        hongbaoDia.getWindow().setAttributes(lp);
        hongbaoDia.show();
        hongbaoDiaText=(TextView)window .findViewById(R.id.name);
        closeDia=(Button)window.findViewById(R.id.close);
        openRedvelet=(ImageButton)window.findViewById(R.id.open_btn);
        closeDia.setOnClickListener(this);
        openRedvelet.setOnClickListener(this);

    }
//完成回掉

    @Override
    public void onFinish() {

        markerLocal.showInfoWindow();
if(markerLocal!=pickedMarker) {
    circle = aMap.addCircle(new CircleOptions()
            .center(markerLocal.getPosition())
            .strokeColor(STROKE_COLOR)
            .fillColor(FILL_COLOR)
            .strokeWidth(2f)
            .radius(300)
            .visible(true));
}
    }

    private void changeCamera(CameraUpdate update, CancelableCallback callback) {
        aMap.animateCamera(update, 200, callback);
    }



//    private PermissionListener listener = new PermissionListener() {
//        @Override
//        public void onSucceed(int requestCode, List<String> grantedPermissions) {
//            // 权限申请成功回调。
//            // 这里的requestCode就是申请时设置的requestCode。
//            // 和onActivityResult()的requestCode一样，用来区分多个不同的请求。
//            if(AndPermission.hasPermission( getContext(),Permission.LOCATION)&&AndPermission.hasPermission( getContext(),Permission.STORAGE)) {
//                if (requestCode == 200) {
//
//                }
//            }
//        }
//
//        @Override
//        public void onFailed(int requestCode, List<String> deniedPermissions) {
//            // 权限申请失败回调。
//            if(requestCode == 200) {
//
//            }
//        }
//    };


}