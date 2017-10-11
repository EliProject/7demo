package com.android.calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.drivemode.settings.DriveModeSettingsActivity;
import com.example.flyme7demo.R;
import com.map.demo.MapActivity;
import com.musicplayer.demo.MediaActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button musicPlayerBtn = findViewById(R.id.enter_music_player);
        Button mapBtn = findViewById(R.id.enter_map);
        Button bluetoothBtn = findViewById(R.id.bluetooth);
        Button settingsBtn = findViewById(R.id.setttings);

        musicPlayerBtn.setOnClickListener(mOnClickListener);
        mapBtn.setOnClickListener(mOnClickListener);
        bluetoothBtn.setOnClickListener(mOnClickListener);
        settingsBtn.setOnClickListener(mOnClickListener);
    }


    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.enter_music_player:
                    Intent musicIntent = new Intent(getApplicationContext(), MediaActivity.class);
                    startActivity(musicIntent);
                    break;
                case R.id.enter_map:
                    Intent mapIntent = new Intent(getApplicationContext(), MapActivity.class);
                    startActivity(mapIntent);
                    break;
                case R.id.bluetooth:
                    Toast.makeText(MainActivity.this, "还没有上线，请等待！",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.setttings:
                    Intent settingsIntent = new Intent(getApplicationContext(), DriveModeSettingsActivity.class);
                    startActivity(settingsIntent);
                    break;
            }
        }
    };
}
