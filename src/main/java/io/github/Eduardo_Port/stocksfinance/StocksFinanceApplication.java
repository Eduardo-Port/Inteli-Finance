package io.github.Eduardo_Port.stocksfinance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableMongoRepositories
public class StocksFinanceApplication {
	public static void main(String[] args) {
		SpringApplication.run(StocksFinanceApplication.class, args);
	}

}
