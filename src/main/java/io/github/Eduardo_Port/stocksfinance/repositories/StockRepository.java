package io.github.Eduardo_Port.stocksfinance.repositories;

import io.github.Eduardo_Port.stocksfinance.domain.stock.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {
    Page<Stock> findAll(Pageable pageable);
}
