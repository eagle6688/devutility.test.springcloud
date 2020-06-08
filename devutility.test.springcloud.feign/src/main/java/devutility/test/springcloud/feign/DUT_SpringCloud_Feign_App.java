package devutility.test.springcloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

import devutility.test.spring.configuration.DevUtilityTestConfiguration;

/**
 * 
 * DUT_SpringCloud_Feign_App
 * 
 * @author: Aldwin Su
 * @version: 2020-06-04 16:55:36
 */
@Import(DevUtilityTestConfiguration.class)
@SpringBootApplication
@EnableFeignClients
public class DUT_SpringCloud_Feign_App {
	public static void main(String[] args) {
		SpringApplication.run(DUT_SpringCloud_Feign_App.class, args);
	}
}