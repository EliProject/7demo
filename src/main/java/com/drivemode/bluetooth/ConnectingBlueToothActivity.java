package com.drivemode.bluetooth;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.flyme7demo.R;

/**
 * Created by liyuanqin on 17-10-9.
 */

public class ConnectingBlueToothActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.bluetooth_connect_layout);
    }
}
