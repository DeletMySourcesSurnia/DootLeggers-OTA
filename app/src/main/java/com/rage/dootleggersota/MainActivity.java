package com.rage.dootleggersota;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.rage.dootleggersota.Fragments.BaseFragment;
import com.rage.dootleggersota.Fragments.UnableFragment;
import com.rage.dootleggersota.Fragments.UpdateFragment;
import com.rage.dootleggersota.Utils.CheckUpdate;
import com.rage.dootleggersota.Utils.ExecShell;

public class MainActivity extends AppCompatActivity {

    private int container = R.id.frameLayoutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckUpdate checkUpdate = new CheckUpdate();
        if (checkUpdate.isDeviceOfficial()) {
            if (checkUpdate.isUpdateAvailable()) {
                UpdateFragment fragment = new UpdateFragment();
                getSupportFragmentManager().beginTransaction().replace(container, fragment).commit();
            }
            else {
                BaseFragment fragment = new BaseFragment();
                getSupportFragmentManager().beginTransaction().replace(container, fragment).commit();
            }
        }
        else {
            UnableFragment fragment = new UnableFragment();
            getSupportFragmentManager().beginTransaction().replace(container, fragment).commit();
        }
    }
}
