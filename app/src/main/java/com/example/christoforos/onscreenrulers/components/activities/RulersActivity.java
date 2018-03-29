package com.example.christoforos.onscreenrulers.components.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.christoforos.onscreenrulers.R;
import com.example.christoforos.onscreenrulers.presenters.RulersPresenter;
import com.example.christoforos.onscreenrulers.screens.RulersScreen;

public class RulersActivity extends BaseActivity implements RulersScreen {

    private RulersPresenter presenter;

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, RulersActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rullers);

        initViews();
        initPresenter();
    }

    private void initViews() {
    }

    private void initPresenter() {
        presenter = new RulersPresenter(this);
        presenter.initialize();
    }
}
