package com.drivemode.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.flyme7demo.R;

/**
 * Created by liyuanqin on 17-10-10.
 */

public class DriveModeSettingsActivity extends Activity {

    public static final String MZ_DRIVE_MODE_MUSIC_AUTOPLAY = "mz_drive_mode_music_autoplay";
    public static final String MZ_DRIVE_MODE_BLUETOOTH_TRIGGER = "mz_drive_mode_bluetooth_trigger";

    private Switch mAutoPlayMusicSwitch;
    private Switch mStartConnBlueTooth;
    private Button mDriveModeSwitchBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        mAutoPlayMusicSwitch = findViewById(R.id.auto_play_music_switch);
        mStartConnBlueTooth = findViewById(R.id.conn_bluetooth_start_switch);
        mDriveModeSwitchBtn = findViewById(R.id.exit_drive_mode);

        mAutoPlayMusicSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                autoPlayMusic(isChecked);
            }
        });


        mStartConnBlueTooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                launchBtPicker(isChecked);
            }
        });

        mDriveModeSwitchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendBroadcast(new Intent(MZ_ACTION_DRIVER_MODE_STOP));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        sendBroadcast(new Intent(MZ_ACTION_DRIVER_MODE_START));//进入这个页面时候，开启驾驶模式

        boolean on = Settings.Secure.getInt(getContentResolver(),
                MZ_DRIVE_MODE_MUSIC_AUTOPLAY, 0) == 1;
        mAutoPlayMusicSwitch.setChecked(on);

        boolean isChecked = Settings.Secure.getInt(getContentResolver(),
                MZ_DRIVE_MODE_BLUETOOTH_TRIGGER, 0) == 1;
        mStartConnBlueTooth.setChecked(isChecked);

    }

    public static final String MZ_ACTION_DRIVER_MODE_START = "meizu.intent.action.DRIVE_MODE_START";
    public static final String MZ_ACTION_DRIVER_MODE_STOP = "meizu.intent.action.DRIVE_MODE_STOP";

    private void autoPlayMusic(boolean isChecked) {
        Settings.Secure.putInt(getContentResolver(), MZ_DRIVE_MODE_MUSIC_AUTOPLAY,
                isChecked ? 1 : 0);
    }

    private void launchBtPicker(boolean isChecked) {
        Settings.Secure.putInt(getContentResolver(),
                                    MZ_DRIVE_MODE_BLUETOOTH_TRIGGER, isChecked ? 1 : 0);
    }

}
