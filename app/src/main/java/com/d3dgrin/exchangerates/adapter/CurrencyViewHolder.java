package com.d3dgrin.exchangerates.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.d3dgrin.exchangerates.R;
import com.d3dgrin.exchangerates.entity.Currency;

import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;

class CurrencyViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvCcy)
    TextView tvCcy;
    @BindView(R.id.tvBuy)
    TextView tvBuy;
    @BindView(R.id.tvSale)
    TextView tvSale;

    CurrencyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bind(Currency currency) {
        tvCcy.setText(currency.getCcy());
        tvBuy.setText(round(currency.getBuy(), 2));
        tvSale.setText(round(currency.getSale(), 2));
    }

    private String round(String num, int scale) {
        BigDecimal bigDecimal = new BigDecimal(num).setScale(scale, BigDecimal.ROUND_HALF_EVEN);
        return bigDecimal.toString();
    }
}
