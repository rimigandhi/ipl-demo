package qr;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class QRApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
	    SpringApplication.run(QRApplication.class, args);
	  }
		
		  @Bean 
		  public Function<Flux<String>, Flux<String>> uppercase() {
		  System.out.println("Hello World"); 
		  return flux -> flux.map(value -> value.toUpperCase()); 
		  }
		 
}
