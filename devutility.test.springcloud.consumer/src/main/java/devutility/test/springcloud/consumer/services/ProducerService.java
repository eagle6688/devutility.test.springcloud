package devutility.test.springcloud.consumer.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import devutility.test.model.Person;
import devutility.test.springcloud.consumer.hystrix.ProducerServiceHystrix;

@FeignClient(name = "spring-cloud-producer", fallback = ProducerServiceHystrix.class)
public interface ProducerService {
	@RequestMapping(value = "/home/hello")
	Person hello(@RequestParam(value = "name") String name);

	@RequestMapping(value = "/home/getteacher")
	Person getTeacher(@RequestBody Person student);
}