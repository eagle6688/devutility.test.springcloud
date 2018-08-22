package devutility.test.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DUTSC_ConsumerApp {
	public static void main(String[] args) {
		SpringApplication.run(DUTSC_ConsumerApp.class, args);
	}
}