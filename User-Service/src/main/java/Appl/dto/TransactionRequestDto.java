package Appl.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TransactionRequestDto {
	
	private Integer userId;
	private Integer amount;
	
}
