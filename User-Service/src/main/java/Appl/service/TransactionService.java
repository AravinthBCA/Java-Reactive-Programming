package Appl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Appl.dto.TransactionRequestDto;
import Appl.dto.TransactionResponse;
import Appl.dto.TransactionStatus;
import Appl.entity.UserTransaction;
import Appl.repository.UserRepository;
import Appl.repository.UserTransactionRepository;
import Appl.util.EntityDtoUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserTransactionRepository userTRepo;
	
	public Mono<TransactionResponse> createTransaction(final TransactionRequestDto requestDto){
		return this.userRepo.updateUserBalance(requestDto.getUserId(), requestDto.getAmount())
					 		.filter(Boolean::booleanValue)
					 		.map(b -> EntityDtoUtil.toEntity(requestDto))
					 		.flatMap(this.userTRepo::save)
					 		.map(ut -> EntityDtoUtil.toDto(requestDto, TransactionStatus.APPROVED))
					 		.defaultIfEmpty(EntityDtoUtil.toDto(requestDto, TransactionStatus.DECLINED));
	}
	
	public Flux<UserTransaction> getUserTransactionById(int id){
		return this.userTRepo.findByUserId(id);
	}
	
}
