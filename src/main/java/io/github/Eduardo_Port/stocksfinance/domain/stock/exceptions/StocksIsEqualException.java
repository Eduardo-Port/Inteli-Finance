package io.github.Eduardo_Port.stocksfinance.domain.stock.exceptions;

public class StocksIsEqualException extends RuntimeException{
    private Double value;

    public StocksIsEqualException(Double value) {
        super("The stocks are equal in valuation");
        this.value = value;
    }

    public Double getValuek() {
        return value;
    }
}
