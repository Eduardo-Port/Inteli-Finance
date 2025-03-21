package io.github.Eduardo_Port.stocksfinance.infra;

import io.github.Eduardo_Port.stocksfinance.domain.stock.exceptions.RegisteredStockException;
import io.github.Eduardo_Port.stocksfinance.domain.stock.exceptions.StockNotFoundException;
import io.github.Eduardo_Port.stocksfinance.domain.stock.exceptions.StocksIsEqualException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StockExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(StockNotFoundException.class)
    private ResponseEntity<String> stockStockNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stock not found.");
    }

    @ExceptionHandler(RegisteredStockException.class)
    private ResponseEntity<String> stockRegisteredStockException() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("This stock is already registered.");
    }

    @ExceptionHandler(StocksIsEqualException.class)
    public ResponseEntity<String> stockStocksIsEqualException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Stocks have equal results.");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> stockRuntimeException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to parse values.");
    }
}
