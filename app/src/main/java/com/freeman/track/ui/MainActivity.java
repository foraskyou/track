package com.freeman.track.ui;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.freeman.track.base.Util;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.tencentmap.mapsdk.map.MapView;

/**
 * 首页地图展示
 */
public class MainActivity extends Activity implements View.OnClickListener, TencentLocationListener {
    MapView mapview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapview = (MapView) findViewById(R.id.mapview);
        ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_right.setVisibility(View.VISIBLE);
        img_right.setImageResource(R.mipmap.add);
        img_right.setOnClickListener(this);
        findViewById(R.id.lil_back).setVisibility(View.GONE);

        //创建Intent对象，action为ELITOR_CLOCK，附加信息为字符串“你该打酱油了”
        Intent intent = new Intent("ELITOR_CLOCK");
        intent.putExtra("msg", "你该打酱油了");
        //定义一个PendingIntent对象，PendingIntent.getBroadcast包含了sendBroadcast的动作。
        //也就是发送了action 为"ELITOR_CLOCK"的intent
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent, 0);
        //AlarmManager对象,注意这里并不是new一个对象，Alarmmanager为系统级服务
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        //设置闹钟从当前时间开始，每隔5s执行一次PendingIntent对象pi，注意第一个参数与第二个参数的关系
// 5秒后通过PendingIntent pi对象发送广播
        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, System.currentTimeMillis(), 5 * 1000, pi);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_right:
                //跳转至添加联系人引导页
                Util.startActivity(this, Activity_add.class, null);
                break;
        }
    }


}
