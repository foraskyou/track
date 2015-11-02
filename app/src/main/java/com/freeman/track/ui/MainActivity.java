package com.freeman.track.ui;

import android.app.Activity;
import android.os.Bundle;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.tencentmap.mapsdk.map.MapView;

public class MainActivity extends Activity implements TencentLocationListener {
    MapView mapview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapview = (MapView) findViewById(R.id.mapview);
    }

    // 地图定位事件
    @Override
    public void onLocationChanged(TencentLocation arg0, int arg1, String arg2) {
        // TODO Auto-generated method stub

    }

    // 地图定位事件
    @Override
    public void onStatusUpdate(String arg0, int arg1, String arg2) {
        // TODO Auto-generated method stub

    }
}
