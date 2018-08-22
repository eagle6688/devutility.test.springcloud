package devutility.test.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DUTSC_EurekaApp {
	public static void main(String[] args) {
		SpringApplication.run(DUTSC_EurekaApp.class, args);
	}
}