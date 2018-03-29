package com.example.christoforos.onscreenrulers.components.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.christoforos.onscreenrulers.R;
import com.example.christoforos.onscreenrulers.presenters.MainPresenter;
import com.example.christoforos.onscreenrulers.screens.MainScreen;

public class MainActivity extends BaseActivity implements MainScreen {

    private MainPresenter presenter;

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

    private void initViews() {
    }

    private void initPresenter() {
        presenter = new MainPresenter(this);
        presenter.initialize();
    }

}
