package com.example.christoforos.onscreenrulers.presenters;

import com.example.christoforos.onscreenrulers.components.navigation.Navigator;
import com.example.christoforos.onscreenrulers.screens.BaseScreen;

/**
 * Created by christoforos on 29/03/2018.
 */

public abstract class BasePresenter {

    public Navigator getNavigator() {
        return Navigator.getInstance();
    }

    protected abstract BaseScreen getScreen();

}
