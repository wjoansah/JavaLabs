package com.wjoansah;

import io.reactivex.rxjava3.core.Single;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class StockApiClient {
    private final StockApiConfig config;

    private final WebClient webClient;

    public StockApiClient(StockApiConfig config) {
        this.config = config;
        this.webClient = WebClient.builder()
                .baseUrl(config.getBaseUrl()).build();
    }

    public Single<StockResponse> getStockPrice(String symbol) {
        return Single.fromPublisher(
                webClient.get()
                        .uri("/query?function=GLOBAL_QUOTE&symbol={symbol}&apikey={apikey}", symbol, config.getApiKey())
                        .retrieve()
                        .bodyToMono(StockResponse.class)
//                        .doOnError(WebClientResponseException.class, ex -> {
//                            System.err.println("Error Response Code: " + ex.getStatusCode());
//                            System.err.println("Error Response Body: " + ex.getResponseBodyAsString());
//                        })
//                        .onErrorResume(ex -> {
//                            System.err.println("Failed to fetch data: " + ex.getMessage());
//                            // Provide a fallback response or empty data as needed
//                            return Mono.empty();
//                        })
        );
    }
}
