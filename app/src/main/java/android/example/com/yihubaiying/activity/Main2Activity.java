package android.example.com.yihubaiying.activity;

import android.Manifest;
import android.content.Intent;
import android.example.com.yihubaiying.MainActivity;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.example.com.yihubaiying.R;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.example.com.yihubaiying.R.id.image;
import static android.example.com.yihubaiying.R.id.imageView;
import static android.example.com.yihubaiying.R.id.pickimage1;

public class Main2Activity extends TakePhotoActivity {

    private ImageView takeFromGalleyBtn;
    private ImageView pickimage1;
    private ImageView pickimage2;
    private ImageView pickimage3;

    private TakePhoto takePhoto;
    private CropOptions cropOptions;  //裁剪参数
    private CompressConfig compressConfig;  //压缩参数
    private Uri imageUri;  //图片保存路径
    private Button nextstep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adv_layout);
        takeFromGalleyBtn= (ImageView) findViewById(R.id.image_pick);
        takeFromGalleyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageUri = getImageCropUri();
                //从相册中选取图片并裁剪
//                takePhoto.onPickFromGalleryWithCrop(imageUri, cropOptions);
               takePhoto.onPickMultiple(3);
            }
        });
        initPermission();
        initData();
        pickimage1= (ImageView) findViewById(R.id.pickimage1);
        pickimage2= (ImageView) findViewById(R.id.pickimage2);
        pickimage3= (ImageView) findViewById(R.id.pickimage3);
        nextstep= (Button) findViewById(R.id.btn_next_step);
        nextstep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,pickpeople_activity.class));
            }
        });
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
//        String iconPath = result.getImage().getOriginalPath();
//        //Toast显示图片路径
//        Toast.makeText(this, "imagePath:" + iconPath, Toast.LENGTH_SHORT).show();
//        //Google Glide库 用于加载图片资源
//        Glide.with(this).load(iconPath).into(pickimage2);
       ArrayList<TImage> images=result.getImages();

        Glide.with(this).load(new File(images.get(0).getCompressPath())).into(pickimage1);
        Glide.with(this).load(new File(images.get(1).getCompressPath())).into(pickimage2);
       Glide.with(this).load(new File(images.get(2).getCompressPath())).into(pickimage3);
//        Toast.makeText(this, "imagePath:" + images.get(2).getOriginalPath(), Toast.LENGTH_SHORT).show();



    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
        Toast.makeText(Main2Activity.this, "Error:" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }

    private void initData() {
        ////获取TakePhoto实例
        takePhoto = getTakePhoto();
        //设置裁剪参数
        cropOptions = new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(false).create();
        //设置压缩参数
        compressConfig=new CompressConfig.Builder().setMaxSize(50*1024).setMaxPixel(800).create();
        takePhoto.onEnableCompress(compressConfig,true);  //设置为需要压缩
    }

    private void initPermission() {
        // 申请权限。
        AndPermission.with(this)
                .requestCode(100)
                .permission(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .send();
    }

//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        // 只需要调用这一句，其它的交给AndPermission吧，最后一个参数是PermissionListener。
//        AndPermission.onRequestPermissionsResult(requestCode, permissions, grantResults, listener);
//    }

    //权限申请回调接口
    private PermissionListener listener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, List<String> grantedPermissions) {
            // 权限申请成功回调。
            if(requestCode == 100) {
                // TODO 相应代码。
                //do nothing
            }
        }
        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {
            // 权限申请失败回调。

            // 用户否勾选了不再提示并且拒绝了权限，那么提示用户到设置中授权。
            if (AndPermission.hasAlwaysDeniedPermission(Main2Activity.this, deniedPermissions)) {

                // 用自定义的提示语
                AndPermission.defaultSettingDialog(Main2Activity.this, 103)
                        .setTitle("权限申请失败")
                        .setMessage("我们需要的一些权限被您拒绝或者系统发生错误申请失败，请您到设置页面手动授权，否则功能无法正常使用！")
                        .setPositiveButton("好，去设置")
                        .show();
            }
        }
    };

    private Uri getImageCropUri() {
        File file=new File(Environment.getExternalStorageDirectory(), "/temp/"+System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists())file.getParentFile().mkdirs();
        return Uri.fromFile(file);
    }
}