package com.d3dgrin.exchangerates.mvp.contract;

import com.d3dgrin.exchangerates.entity.Currency;

import java.util.List;

import io.reactivex.Observable;

public interface MainContract {
    interface View {
        void setCurrencies(List<Currency> currencies);
        void showLoading();
        void hideLoading();
    }
    interface Presenter extends BasePresenter<View> {
        void loadCurrencies();
    }
    interface Model {
        Observable<List<Currency>> getCurrencies();
    }
}
