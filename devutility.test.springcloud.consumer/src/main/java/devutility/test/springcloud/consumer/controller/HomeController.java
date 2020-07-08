package devutility.test.springcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.test.model.Person;
import devutility.test.springcloud.consumer.service.ProducerService;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private ProducerService producerService;

	@GetMapping("/hello/{name}")
	public Person hello(@PathVariable("name") String name) {
		return producerService.hello(name);
	}

	@GetMapping("/getteacher")
	public Person getTeacher() {
		Person student = new Person();
		student.setName("Lily");
		return producerService.getTeacher(student);
	}
}