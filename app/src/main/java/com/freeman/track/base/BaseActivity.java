package com.freeman.track.base;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseActivity extends Activity {
    TextView tv_title, tv_left, tv_right;
    ImageView img_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
