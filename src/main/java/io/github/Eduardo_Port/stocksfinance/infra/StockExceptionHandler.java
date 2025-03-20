package io.github.Eduardo_Port.stocksfinance.infra;


import io.github.Eduardo_Port.stocksfinance.domain.stock.exceptions.RegisteredStockException;
import io.github.Eduardo_Port.stocksfinance.domain.stock.exceptions.StockNotFoundException;
import io.github.Eduardo_Port.stocksfinance.domain.stock.exceptions.StocksIsEqualException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StockExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(StockNotFoundException.class)
    private ResponseEntity<String> stockStockNotFoundException(StockNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stock not found");
    }

    @ExceptionHandler(RegisteredStockException.class)
    private ResponseEntity<String> stockRegisteredStockException(RegisteredStockException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Stock already registered");
    }

    @ExceptionHandler(StocksIsEqualException.class)
    public ResponseEntity<String> stockStocksIsEqualException(StocksIsEqualException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Stocks are equal");
    }
}
