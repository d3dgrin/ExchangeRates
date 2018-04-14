package com.d3dgrin.exchangerates.dagger.module;

import android.content.Context;

import com.d3dgrin.exchangerates.mvp.contract.MainContract;
import com.d3dgrin.exchangerates.mvp.model.MainModel;
import com.d3dgrin.exchangerates.mvp.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    MainContract.Model provideMainModel(Context context) {
        return new MainModel(context);
    }

    @Singleton
    @Provides
    MainContract.Presenter provideMainPresenter(Context context) {
        return new MainPresenter(context);
    }
}
