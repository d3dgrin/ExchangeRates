package com.d3dgrin.exchangerates.mvp.model;

import android.content.Context;

import com.d3dgrin.exchangerates.dagger.App;
import com.d3dgrin.exchangerates.entity.Currency;
import com.d3dgrin.exchangerates.mvp.contract.MainContract;
import com.d3dgrin.exchangerates.retrofit.PrivatbankService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainModel implements MainContract.Model {
    @Inject
    PrivatbankService privatbankService;

    @Inject
    public MainModel(Context context) {
        App.get(context).getInjector().inject(this);
    }

    @Override
    public Observable<List<Currency>> getCurrencies() {
        return privatbankService.getCurrencies().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
