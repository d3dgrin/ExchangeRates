package com.d3dgrin.exchangerates.mvp.presenter;

import android.content.Context;

import com.d3dgrin.exchangerates.dagger.App;
import com.d3dgrin.exchangerates.mvp.contract.MainContract;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view = null;

    @Inject
    MainContract.Model model;

    @Inject
    public MainPresenter(Context context) {
        App.get(context).getInjector().inject(this);
    }

    @Override
    public void onAttachView(MainContract.View attachedView) {
        view = attachedView;
        loadCurrencies();
    }

    @Override
    public void onDetachView() {
        view = null;
    }

    @Override
    public void loadCurrencies() {
        view.showLoading();
        model.getCurrencies().subscribe(list -> {
            view.hideLoading();
            view.setCurrencies(list);
        });
    }
}
