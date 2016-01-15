package com.freeman.track.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * Created by Administrator on 2016/1/6.
 */
public class Util {
    private static Util util = null;

    public static Util getInstance() {
        if (util == null) {
            util = new Util();
        }
        return util;
    }

    public static void startActivity(Context context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    /**
     * 获取本机手机号
     *
     * @return
     */
    public static String getMyPhone(Context context) {
        TelephonyManager mTelephonyMgr;
        mTelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return mTelephonyMgr.getLine1Number();
    }
}
