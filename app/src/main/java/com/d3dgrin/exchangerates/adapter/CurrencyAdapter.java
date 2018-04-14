package com.d3dgrin.exchangerates.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.d3dgrin.exchangerates.R;
import com.d3dgrin.exchangerates.entity.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyViewHolder> {

    private List<Currency> currencies = new ArrayList<>();

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
        notifyDataSetChanged();
    }

    @Override
    public CurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CurrencyViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.currency_card, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(CurrencyViewHolder holder, int position) {
        Currency currency = currencies.get(position);
        holder.bind(currency);
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }
}
