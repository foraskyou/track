package com.freeman.track.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.freeman.track.base.Util;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.tencentmap.mapsdk.map.MapView;

/**
 * 首页地图展示
 */
public class MainActivity extends Activity implements View.OnClickListener, TencentLocationListener {
    private TencentLocationManager mLocationManager;
    private MapView mMapView;
    //private LocationOverlay mLocationOverlay;

    private TencentLocation mLocation;

    // 用于记录定位参数, 以显示到 UI
    private String mRequestParams;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_right.setVisibility(View.VISIBLE);
        img_right.setImageResource(R.mipmap.add);
        img_right.setOnClickListener(this);
        findViewById(R.id.lil_back).setVisibility(View.GONE);
//地图
        initMapView();
        mLocationManager = TencentLocationManager.getInstance(this);
        mLocationManager.requestLocationUpdates(TencentLocationRequest.create()
                .setRequestLevel(TencentLocationRequest.REQUEST_LEVEL_GEO)
                .setInterval(500).setAllowDirection(true), this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationManager.removeUpdates(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startLocation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopLocation();
    }

    // 地图定位事件
    @Override
    public void onLocationChanged(TencentLocation location, int error, String reason) {
        if (error == TencentLocation.ERROR_OK) {
            mLocation = location;
            // 定位成功
            StringBuilder sb = new StringBuilder();
            sb.append("定位参数=").append(mRequestParams).append("\n");
            sb.append("(纬度=").append(location.getLatitude()).append(",经度=")
                    .append(location.getLongitude()).append(",精度=")
                    .append(location.getAccuracy()).append("), 来源=")
                    .append(location.getProvider()).append(", 地址=")
                    .append(location.getAddress());


            mMapView.invalidate();
            // Toast.makeText(this, "纬度=" + latitude + ",经度=" + longitude + "\n方向=" + (int) direction, Toast.LENGTH_LONG).show();
        }
    }

    // 地图定位事件
    @Override
    public void onStatusUpdate(String name, int status, String desc) {
        // ignore
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_right:
                //跳转至添加联系人引导页
                Util.startActivity(this, Activity_add.class, null);
                break;
        }
    }

    //方法
    private void initMapView() {
        mMapView = (MapView) findViewById(R.id.mapview);
        // mMapView.setBuiltInZoomControls(true);
        // mMapView.getController().setZoom(9);
    }

    private void startLocation() {
        TencentLocationRequest request = TencentLocationRequest.create();
        request.setInterval(5000);
        mLocationManager.requestLocationUpdates(request, this);


    }

    private void stopLocation() {
        mLocationManager.removeUpdates(this);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.freeman.track.ui/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.freeman.track.ui/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
