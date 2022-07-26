package ProductService.Controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProductService.Dto.ProductDto;
import ProductService.Service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("all")
	public Flux<ProductDto> all(){
		return this.service.getAll();
	}
	
	@GetMapping("price-range")
	public Flux<ProductDto> getByPriceRange(@RequestParam("min") int min,
											@RequestParam("max") int max){
		return this.service.getProductByPriceRange(min, max);
	}
	
	// this method shows the non-blocking and asyn process.
	@GetMapping("{id}")
	public Mono<ResponseEntity<ProductDto>> getProductById(@PathVariable String id){
		Mono<ResponseEntity<ProductDto>> response =  this.service.getProductById(id)
				           										 .delayElement(Duration.ofSeconds(5))
				           										 .map(ResponseEntity::ok)
				           										 .defaultIfEmpty(ResponseEntity.notFound().build())
				           										 .doOnNext(System.out::println);
		System.out.println("Performing the Operations It takes some time.....");
		return response;
	}
	
	@PostMapping
	public Mono<ProductDto> insertProduct(@RequestBody Mono<ProductDto> productDto){
		return this.service.insertProduct(productDto);
	}
	
	@PutMapping("{id}")
	public Mono<ResponseEntity<ProductDto>> update(@PathVariable String id,@RequestBody Mono<ProductDto> productDto) {
		return this.service.updateProduct(id, productDto)
						   .map(ResponseEntity::ok)
						   .defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("{id}")
	public Mono<Void> deleteProduct(@PathVariable String id){
		return this.service.deleteProduct(id);
	}
	
}
