package Appl.util;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import Appl.dto.TransactionRequestDto;
import Appl.dto.TransactionResponse;
import Appl.dto.TransactionStatus;
import Appl.dto.UserDto;
import Appl.entity.User;
import Appl.entity.UserTransaction;

public class EntityDtoUtil {
	
	public static UserDto toDto(User user) {
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(user, dto);
		return dto;
	}
	
	public static User toEntity(UserDto dto) {
		User user = new User();
		BeanUtils.copyProperties(dto,user);
		return user;
	}
	
	public static UserTransaction toEntity(TransactionRequestDto tDto) {
		UserTransaction ut = new UserTransaction();
		ut.setUserId(tDto.getUserId());
		ut.setAmount(tDto.getAmount());
		ut.setTransactionDate(LocalDateTime.now());
		return ut;
	}
	
	public static TransactionResponse toDto(TransactionRequestDto tDto,TransactionStatus tStatus) {
		TransactionResponse dto = new TransactionResponse();
		dto.setAmount(tDto.getAmount());
		dto.setUserId(tDto.getUserId());
		dto.setStatus(tStatus);
		return dto;
	}
	
}
