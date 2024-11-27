package com.wjoansah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class StockRestController {
    @Autowired
    private StockService stockService;

    @GetMapping(value = "/stocks/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<StockResponse> streamStockPrices() {
        return Flux.from(stockService.observeStockPrices())
                .delayElements(Duration.ofSeconds(1)); // Delay to simulate real-time updates
    }
}
