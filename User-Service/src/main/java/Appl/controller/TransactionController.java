package Appl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Appl.dto.TransactionRequestDto;
import Appl.dto.TransactionResponse;
import Appl.entity.UserTransaction;
import Appl.service.TransactionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user/transaction")
public class TransactionController {

	@Autowired
	private TransactionService tService;
	
	@PostMapping
	public Mono<TransactionResponse> createTransaction(@RequestBody Mono<TransactionRequestDto> tDto){
		return tDto.flatMap(this.tService::createTransaction);
	}
	
	@GetMapping("{id}")
	public Flux<UserTransaction> getTransactionByUserId(@PathVariable int id){
		return this.tService.getUserTransactionById(id);
	}
}
