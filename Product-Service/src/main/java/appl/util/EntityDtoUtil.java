package appl.util;

import org.springframework.beans.BeanUtils;

import appl.dto.ProductDto;
import appl.entity.Product;

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
