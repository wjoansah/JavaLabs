package com.wjoansah;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class StockService {
    @Autowired
    private StockApiClient stockApiClient;

    private final List<String> symbols = List.of("AAPL", "MSFT", "GOOGL");

    public Flowable<StockResponse> observeStockPrices() {
        return Observable.interval(5, TimeUnit.SECONDS) // Every 5 seconds
                .flatMapSingle(tick -> Observable.fromIterable(symbols) // Iterate over symbols
                        .flatMapSingle(symbol -> stockApiClient.getStockPrice(symbol))
                        .toList()
                )
                .flatMapIterable(list -> list)
                .toFlowable(BackpressureStrategy.BUFFER);
    }
}
