package com.example.christoforos.onscreenrulers.components.activities;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.view.View;

import com.example.christoforos.onscreenrulers.R;
import com.example.christoforos.onscreenrulers.presenters.MainPresenter;
import com.example.christoforos.onscreenrulers.screens.MainScreen;
import com.example.christoforos.onscreenrulers.services.RulersService;

public class MainActivity extends BaseActivity implements MainScreen, View.OnClickListener {

    private MainPresenter presenter;

    public final static int ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE = 1;

    private View startButton;
    private View endButton;

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isMyServiceRunning(RulersService.class)) {
            showStopButton();
        } else {
            showStartButton();
        }
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public Context getScreenContext() {
        return this;
    }

    private void initViews() {
        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
        endButton = findViewById(R.id.endButton);
        endButton.setOnClickListener(this);
    }

    private void initPresenter() {
        presenter = new MainPresenter(this);
        presenter.initialize();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == startButton.getId()) {
            presenter.startButtonPressed();
        } else if (view.getId() == endButton.getId()) {
            stopRulersService();
        }
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkDrawOverlayPermission() {
        if (Settings.canDrawOverlays(this)) {
            startRulersService();
        } else {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            //Yes button clicked
                            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                    Uri.parse("package:" + getPackageName()));
                            startActivityForResult(intent, ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE);
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };

            new AlertDialog.Builder(this)
                    .setMessage("You need to allow this app to display over other apps.")
                    .setPositiveButton("OK", dialogClickListener)
                    .setNegativeButton("CANCEL", dialogClickListener)
                    .show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE) {
            checkDrawOverlayPermission();
        }
    }

    private void startRulersService() {
        startService(new Intent(this, RulersService.class));
        showStopButton();
    }

    private void stopRulersService() {
        stopService(new Intent(this, RulersService.class));
        showStartButton();
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private void showStartButton() {
        startButton.setVisibility(View.VISIBLE);
        endButton.setVisibility(View.GONE);
    }

    private void showStopButton() {
        startButton.setVisibility(View.GONE);
        endButton.setVisibility(View.VISIBLE);
    }

}
