package com.example.christoforos.onscreenrulers.presenters;

import com.example.christoforos.onscreenrulers.screens.BaseScreen;
import com.example.christoforos.onscreenrulers.screens.MainScreen;

/**
 * Created by christoforos on 29/03/2018.
 */

public class MainPresenter extends BasePresenter implements Presenter {

    private MainScreen screen;

    public MainPresenter(MainScreen screen) {
        this.screen = screen;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    protected BaseScreen getScreen() {
        return screen;
    }

    public void startButtonPressed() {
        screen.checkDrawOverlayPermission();
    }
}
