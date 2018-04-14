package com.d3dgrin.exchangerates.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.d3dgrin.exchangerates.R;
import com.d3dgrin.exchangerates.adapter.CurrencyAdapter;
import com.d3dgrin.exchangerates.dagger.App;
import com.d3dgrin.exchangerates.entity.Currency;
import com.d3dgrin.exchangerates.mvp.contract.MainContract;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;

    @BindView(R.id.rvCurrencies)
    RecyclerView rvCurrencies;
    @BindView(R.id.btnRefresh)
    Button btnRefresh;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;

    CurrencyAdapter currencyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.get(this).getInjector().inject(this);
        ButterKnife.bind(this);

        currencyAdapter = new CurrencyAdapter();
        rvCurrencies.setLayoutManager(new LinearLayoutManager(this));
        rvCurrencies.setAdapter(currencyAdapter);

        btnRefresh.setOnClickListener(view -> presenter.loadCurrencies());

        presenter.onAttachView(this);
    }

    @Override
    public void setCurrencies(List<Currency> currencies) {
        currencyAdapter.setCurrencies(currencies);
    }

    @Override
    public void showLoading() {
        rvCurrencies.setVisibility(View.GONE);
        btnRefresh.setVisibility(View.GONE);
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        rvCurrencies.setVisibility(View.VISIBLE);
        btnRefresh.setVisibility(View.VISIBLE);
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetachView();
    }
}
