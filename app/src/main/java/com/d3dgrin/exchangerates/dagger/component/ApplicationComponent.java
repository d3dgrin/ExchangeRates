package com.d3dgrin.exchangerates.dagger.component;

import com.d3dgrin.exchangerates.dagger.module.AppModule;
import com.d3dgrin.exchangerates.dagger.module.NetworkModule;
import com.d3dgrin.exchangerates.mvp.model.MainModel;
import com.d3dgrin.exchangerates.mvp.presenter.MainPresenter;
import com.d3dgrin.exchangerates.mvp.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface ApplicationComponent {
    void inject(MainModel mainModel);
    void inject(MainPresenter mainPresenter);
    void inject(MainActivity mainActivity);
}
