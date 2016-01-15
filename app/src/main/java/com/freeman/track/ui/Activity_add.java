package com.freeman.track.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.freeman.track.base.Util;

/**
 * 短信推送定位客户端服务
 */
public class Activity_add extends Activity implements View.OnClickListener {
    //手机号
    EditText edt_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        findViewById(R.id.lil_right).setOnClickListener(this);
        findViewById(R.id.lil_back).setOnClickListener(this);
        TextView tv_right = (TextView) findViewById(R.id.tv_right);
        tv_right.setText(R.string.send);
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText(R.string.smssend);
        edt_phone = (EditText) findViewById(R.id.edt_phone);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lil_right:
                //发送短信
                String phone = edt_phone.getText().toString();
                sendSms(phone);
                break;
            case R.id.lil_back:
                finish();
                break;
        }
    }

    void sendSms(String phone) {
        String myPhone= Util.getMyPhone(this);
        Uri smsToUri = Uri.parse("smsto:"+phone);
        Intent intent = new Intent(Intent.ACTION_SENDTO, smsToUri);
        intent.putExtra("sms_body", myPhone+"需要获取您的位置信息，如果同意请点链接下载安装");
        startActivity(intent);
    }
}
