package Appli.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import Appli.DTO.Response;

@Service
public class MathService {
	
	public Response findSquare(int input) {
		return new Response(input * input);
	}
	
	public List<Response> multiplicationTable(int input){
		return IntStream.range(1, 11)
				.peek(i -> SleepUtil.sleepSeconds(1))
				.peek(i -> System.out.println("Math-Service Processing : "+i))
				.mapToObj(i -> new Response(i * input))
				.collect(Collectors.toList());
	}
	
}
