package Appl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

	private Integer userId;
	private Integer amount;
	private TransactionStatus status;
	
}
