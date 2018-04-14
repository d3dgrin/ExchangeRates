package com.d3dgrin.exchangerates.dagger.module;

import com.d3dgrin.exchangerates.retrofit.PrivatbankService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    private String baseUrl;

    public NetworkModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Singleton
    @Provides
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public PrivatbankService privatbankService(Retrofit retrofit) {
        return retrofit.create(PrivatbankService.class);
    }
}
