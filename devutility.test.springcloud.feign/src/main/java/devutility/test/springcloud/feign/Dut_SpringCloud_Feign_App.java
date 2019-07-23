package devutility.test.springcloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Dut_SpringCloud_Feign_App {
	public static void main(String[] args) {
		SpringApplication.run(Dut_SpringCloud_Feign_App.class, args);
	}
}