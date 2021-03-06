package devutility.test.springcloud.consumer.hystrix;

import org.springframework.stereotype.Component;

import devutility.test.model.Person;
import devutility.test.springcloud.consumer.service.ProducerService;

@Component
public class ProducerServiceHystrix implements ProducerService {
	@Override
	public Person hello(String name) {
		System.out.println("Hystrix hello!");
		return null;
	}

	@Override
	public Person getTeacher(Person student) {
		System.out.println("Hystrix get teacher!");
		return null;
	}
}