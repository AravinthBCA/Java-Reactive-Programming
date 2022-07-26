package ProductService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DataSetupService implements CommandLineRunner{

	@Autowired
	private ProductService service;
	 
	// you want default data from below means you can un-comment this
	@Override
	public void run(String... args) throws Exception {
//		ProductDto p1 = new ProductDto("LG-Tv",1000);
//		ProductDto p2 = new ProductDto("Apple-Tv",2000);
//		ProductDto p3 = new ProductDto("Sony-Tv",3000);
//		ProductDto p4 = new ProductDto("Samsung-Tv",4000);
//		
//		Flux.just(p1,p2,p3,p4)
//			.flatMap(p -> this.service.insertProduct(Mono.just(p)))
//			.subscribe(System.out::println);
	}
	
}
