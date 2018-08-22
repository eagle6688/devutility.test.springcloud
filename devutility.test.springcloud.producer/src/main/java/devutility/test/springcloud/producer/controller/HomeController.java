package devutility.test.springcloud.producer.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devutility.test.model.Person;

@RestController
@RequestMapping("/home")
public class HomeController {
	@RequestMapping("/hello")
	public Person hello(String name) {
		Person person = new Person();
		person.setName(name);
		person.setAge(20);
		person.setBirthday(new Date());
		person.setLocal(true);
		return person;
	}

	@RequestMapping("/getteacher")
	public Person getTeacher(@RequestBody Person student) {
		Person teacher = new Person();
		teacher.setName(String.format("%s's teacher", student.getName()));
		return teacher;
	}
}