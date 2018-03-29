package com.example.christoforos.onscreenrulers.presenters;

/**
 * Created by christoforos on 29/03/2018.
 */

public interface Presenter {

    void initialize();

    void start();

    void resume();

    void pause();

    void stop();

    void destroy();
}