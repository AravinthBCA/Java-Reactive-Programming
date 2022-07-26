package ProductService.Util;

import org.springframework.beans.BeanUtils;

import ProductService.Dto.ProductDto;
import ProductService.Entity.Product;

public class EntityDtoUtil {
	
	public static ProductDto toDto(Product product) {
		ProductDto dto = new ProductDto();
		BeanUtils.copyProperties(product, dto);
		return dto;
	}
	
	public static Product toEntity(ProductDto product) {
		Product entity = new Product();
		BeanUtils.copyProperties(product, entity);
		return entity;
	}
	
}
