package io.github.Eduardo_Port.stocksfinance.domain.stock;

import io.github.Eduardo_Port.stocksfinance.domain.stock.dto.StockInputDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.RepresentationModel;

@Document(collection = "stocks")
@Getter
@Setter
public class Stock extends RepresentationModel<Stock> {
    @Id
    private String title;
    private Double price;
    private Double profit;
    private Double pricePerPatrimonialValue;
    private Double dividendYield;
    private Double dividendYieldLast5Years;

    public Stock() {

    }

    public Stock(StockInputDTO stockData) {
        this.title= stockData.title();
        this.price = stockData.price();
        this.profit = stockData.profit();
        this.pricePerPatrimonialValue = stockData.pricePerPatrimonialValue();
        this.dividendYield = stockData.dividendYield();
        this.dividendYieldLast5Years = stockData.dividendYieldLast5Years();
    }
}
