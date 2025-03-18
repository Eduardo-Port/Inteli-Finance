package io.github.Eduardo_Port.stocksfinance.domain.stock.dto;

public record StockInputDTO(
        String title,
        Double price,
        Double profit,
        Double pricePerPatrimonialValue,
        Double dividendYield,
        Double dividendYieldLast5Years
) {
}
