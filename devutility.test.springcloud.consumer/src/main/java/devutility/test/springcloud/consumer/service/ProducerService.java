package devutility.test.springcloud.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import devutility.test.model.Person;
import devutility.test.springcloud.consumer.hystrix.ProducerServiceHystrix;

@FeignClient(name = "spring-cloud-producer", fallback = ProducerServiceHystrix.class)
public interface ProducerService {
	@GetMapping("/home/hello")
	Person hello(@RequestParam(value = "name") String name);

	@GetMapping("/home/teacher")
	Person getTeacher(@RequestBody Person student);
}