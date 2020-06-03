package devutility.test.springcloud.consumer.hystrix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.test.model.Person;
import devutility.test.springcloud.consumer.hystrix.services.ProducerService;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private ProducerService producerService;

	@RequestMapping("/hello/{name}")
	public Person hello(@PathVariable("name") String name) {
		return producerService.hello(name);
	}

	@RequestMapping("/getteacher")
	public Person getTeacher() {
		Person student = new Person();
		student.setName("Lily");
		return producerService.getTeacher(student);
	}
}