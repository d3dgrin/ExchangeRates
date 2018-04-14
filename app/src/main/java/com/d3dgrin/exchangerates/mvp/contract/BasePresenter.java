package com.d3dgrin.exchangerates.mvp.contract;

public interface BasePresenter<V> {
    void onAttachView(V attachedView);
    void onDetachView();
}
