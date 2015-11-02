package com.freeman.track.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/11/2.
 */
public class TrackReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Log.d("MyTag", "onclock......................");
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
