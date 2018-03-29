package com.example.christoforos.onscreenrulers.components.navigation;

import android.content.Context;
import android.content.Intent;

import com.example.christoforos.onscreenrulers.components.activities.MainActivity;
import com.example.christoforos.onscreenrulers.components.activities.RulersActivity;

/**
 * Created by christoforos on 29/03/2018.
 */

public class Navigator {

    private static Navigator instance;

    public static Navigator getInstance() {
        if (instance == null) {
            instance = new Navigator();
        }
        return instance;
    }

    public Navigator() {
    }

    public void navigateToMainActivity(Context context) {
        if (context != null) {
            Intent intent = MainActivity.getCallingIntent(context);
            context.startActivity(intent);
        }
    }

    public void navigateToRulersActivity(Context context) {
        if (context != null) {
            Intent intent = RulersActivity.getCallingIntent(context);
            context.startActivity(intent);
        }
    }
}
