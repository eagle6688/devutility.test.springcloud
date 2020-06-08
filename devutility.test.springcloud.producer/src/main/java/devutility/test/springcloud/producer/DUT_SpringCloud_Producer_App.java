package devutility.test.springcloud.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import devutility.test.spring.configuration.DevUtilityTestConfiguration;

/**
 * 
 * DUT_SpringCloud_Producer_App
 * 
 * @author: Aldwin Su
 * @version: 2020-06-08 17:45:09
 */
@Import(DevUtilityTestConfiguration.class)
@SpringBootApplication
//@EnableDiscoveryClient
public class DUT_SpringCloud_Producer_App {
	public static void main(String[] args) {
		SpringApplication.run(DUT_SpringCloud_Producer_App.class, args);
	}
}