package com.d3dgrin.exchangerates.retrofit;

import com.d3dgrin.exchangerates.entity.Currency;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PrivatbankService {
    @GET("pubinfo?json&exchange&coursid=5")
    Observable<List<Currency>> getCurrencies();
}
