package com.example.christoforos.onscreenrulers.presenters;

import com.example.christoforos.onscreenrulers.screens.BaseScreen;
import com.example.christoforos.onscreenrulers.screens.RulersScreen;

/**
 * Created by christoforos on 29/03/2018.
 */

public class RulersPresenter extends BasePresenter implements Presenter {

    private RulersScreen screen;

    public RulersPresenter(RulersScreen screen) {
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
}
