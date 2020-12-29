package devutility.test.springcloud.producer.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.external.servlet.http.HttpServletUtils;
import devutility.internal.response.EasyResponse;
import devutility.test.model.Person;

/**
 * 
 * HomeController
 * 
 * @author: Aldwin Su
 * @version: 2020-06-08 17:45:25
 */
@RestController
@RequestMapping("home")
public class HomeController {
	@Autowired
	private HttpServletRequest request;

	@GetMapping("/hello")
	public Person hello(String name) {
		Person person = new Person();
		person.setName(name);
		person.setAge(20);
		person.setBirthday(new Date());
		person.setLocal(true);
		return person;
	}

	@GetMapping("teacher")
	public Person getTeacher(@RequestBody Person student) {
		Person teacher = new Person();
		teacher.setName(String.format("%s's teacher", student.getName()));
		return teacher;
	}

	@GetMapping("process")
	public EasyResponse process(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new EasyResponse();
	}

	@GetMapping("ip")
	public EasyResponse ip() {
		return new EasyResponse(HttpServletUtils.getClientIpAddress(request));
	}
}