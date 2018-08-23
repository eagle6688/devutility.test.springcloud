package devutility.test.springcloud.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DUTSC_ProducerApp {
	public static void main(String[] args) {
		SpringApplication.run(DUTSC_ProducerApp.class, args);
	}
}