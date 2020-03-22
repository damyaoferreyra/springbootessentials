package br.com.devdojo.springbootessentials;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class ApplicationStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ApplicationStart.class, args);
	}

}
