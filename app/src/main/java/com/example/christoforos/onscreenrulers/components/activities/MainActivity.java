package com.example.christoforos.onscreenrulers.components.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.christoforos.onscreenrulers.R;
import com.example.christoforos.onscreenrulers.presenters.MainPresenter;
import com.example.christoforos.onscreenrulers.screens.MainScreen;

public class MainActivity extends BaseActivity implements MainScreen {

    private MainPresenter presenter;

    private View startButton;

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
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public Context getScreenContext() {
        return this;
    }

    private void initViews() {
        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.startButtonPressed();
            }
        });
    }

    private void initPresenter() {
        presenter = new MainPresenter(this);
        presenter.initialize();
    }
}
