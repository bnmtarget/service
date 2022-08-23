package bnm.bnmapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class BnmapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BnmapiApplication.class, args);
	}

}
