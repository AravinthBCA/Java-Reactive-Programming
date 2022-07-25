package appl.repository;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Repository;

import appl.entity.Product;
import reactor.core.publisher.Flux;

@Repository
@EnableReactiveMongoRepositories
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
	
	// > min & < max
//	Flux<Product> findByPriceBetween(int min,int max);
	
	Flux<Product> findByPriceBetween(Range<Integer> range);
}
