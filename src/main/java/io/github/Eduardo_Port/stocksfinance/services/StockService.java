package io.github.Eduardo_Port.stocksfinance.services;

import io.github.Eduardo_Port.stocksfinance.controller.StockController;
import io.github.Eduardo_Port.stocksfinance.domain.stock.Stock;
import io.github.Eduardo_Port.stocksfinance.domain.stock.dto.StockInputDTO;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import io.github.Eduardo_Port.stocksfinance.domain.stock.exceptions.StockNotFoundException;
import io.github.Eduardo_Port.stocksfinance.domain.stock.exceptions.StocksIsEqualException;
import io.github.Eduardo_Port.stocksfinance.repositories.StockRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock insert(StockInputDTO stockData) {
        Stock newStock = new Stock(stockData);
        this.stockRepository.save(newStock);
        newStock.add(linkTo(methodOn(StockController.class)
                .getStockByTitle(newStock.getTitle()))
                .withSelfRel());
        return newStock;
    }

    // getStocksPaginated creates an instance of the Pageable interface and passes it to the findAll method.
    public Page<Stock> getStocksPaginated(int page) {
        int numberStocksApresented = 9;
        Pageable pageable = PageRequest.of(page, numberStocksApresented);
        Page<Stock> stocks = stockRepository.findAll(pageable);
        if(stocks.isEmpty()) {
            throw new StockNotFoundException();
        } else{
            for (Stock stock : stocks) {
                String title = stock.getTitle();
                stock.add(linkTo(methodOn(StockController.class)
                        .getStockByTitle(title))
                        .withSelfRel()
                        .expand(page));
            }
        }
        return stocks;
    }

    public Stock getStockByTitle(String title) {
        Stock stock = stockRepository.findById(title).orElseThrow(StockNotFoundException::new);
        stock.add(linkTo(methodOn(StockController.class)
                .getStocksPaginated(0))
                .withRel("Stock list"));
        return stock;
    }

    public Stock update(StockInputDTO stockData) {
            Stock stock = this.stockRepository.findById(stockData.title()).orElseThrow(StockNotFoundException::new);
            if (stockData.price() != null && !stock.getPrice().equals(stockData.price())) {
                stock.setPrice(stockData.price());
            }

            if (stockData.profit() != null && !stock.getProfit().equals(stockData.profit())) {
                stock.setProfit(stockData.profit());
            }

            if (stockData.pricePerPatrimonialValue() != null && !stock.getPricePerPatrimonialValue()
                    .equals(stockData.pricePerPatrimonialValue())) {
                stock.setPricePerPatrimonialValue(stockData.pricePerPatrimonialValue());
            }

            if (stockData.dividendYield() != null && !stock.getDividendYield()
                    .equals(stockData.dividendYield())) {
                stock.setDividendYield(stockData.dividendYield());
            }

            if (stockData.dividendYieldLast5Years() != null && !stock.getDividendYieldLast5Years()
                    .equals(stockData.dividendYieldLast5Years())) {
                stock.setDividendYieldLast5Years(stockData.dividendYieldLast5Years());
            }
            this.stockRepository.save(stock);
            stock.add(linkTo(methodOn(StockController.class)
                    .getStockByTitle(stockData.title()))
                    .withSelfRel());
            return stock;
    }

    public void deleteByTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new StockNotFoundException();
        }
        Stock stock = this.stockRepository.findById(title).orElseThrow(StockNotFoundException::new);
        this.stockRepository.delete(stock);
    }

    public Stock getBetterStockBazinMethod(List<String> stocksToCompare) {
        List<Stock> stocks = this.stockRepository.findAllById(stocksToCompare);
        Double bazinMethodValueFirstStock = getValueBazinMethod(stocks.get(0).getPrice(), stocks.get(0).getDividendYieldLast5Years());
        Double bazinMethodvalueSecondStock = getValueBazinMethod(stocks.get(1).getPrice(), stocks.get(1).getDividendYieldLast5Years());
        if(bazinMethodValueFirstStock > bazinMethodvalueSecondStock) {
            return stocks.get(0);
        } else if (bazinMethodValueFirstStock < bazinMethodvalueSecondStock) {
            throw new StocksIsEqualException();
        } else {
            return stocks.get(1);
        }
    }

    public Double getValueBazinMethod(Double price, Double dividendYield5Years) {
        double dividendYieldDesired = 10.0;
        return (price * dividendYield5Years) / dividendYieldDesired;
    }

    public Double getValueGrahamMethod(Double profit, Double patrimonialValue) {
        double fixValue =  22.5;
        return Math.sqrt(fixValue*profit*patrimonialValue);
    }
}
