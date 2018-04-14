package com.d3dgrin.exchangerates.dagger;

import android.app.Application;
import android.content.Context;

import com.d3dgrin.exchangerates.dagger.component.ApplicationComponent;
import com.d3dgrin.exchangerates.dagger.component.DaggerApplicationComponent;
import com.d3dgrin.exchangerates.dagger.module.AppModule;
import com.d3dgrin.exchangerates.dagger.module.NetworkModule;

public class App extends Application {
    private ApplicationComponent applicationComponent;

    public ApplicationComponent getInjector() {
        if(applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .appModule(new AppModule(this))
                    .networkModule(new NetworkModule("https://api.privatbank.ua/p24api/"))
                    .build();
        }
        return applicationComponent;
    }

    public static App get(Context context) {
        return (App)context.getApplicationContext();
    }
}
