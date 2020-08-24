package devutility.test.springcloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.internal.lang.ObjectUtils;
import devutility.internal.model.OperationResult;
import devutility.test.model.Member;
import devutility.test.springcloud.feign.remote.ProducerRemote;

/**
 * 
 * ConsumerController
 * 
 * @author: Aldwin Su
 * @creation: 2020-08-24 15:09:55
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {
	@Autowired
	private ProducerRemote producerRemote;

	@GetMapping("test-post-json")
	public OperationResult testPostJosn(String name, int age) {
		Member member = new Member();
		member.setName(name);
		member.setAge(age);
		return producerRemote.receiveJson("ch", member);
	}

	@GetMapping("test-post-form")
	public OperationResult testPostForm(String name) throws ReflectiveOperationException {
		Member member = new Member();
		member.setName(name);
		return producerRemote.receiveForm("us", ObjectUtils.toHttpRequestParams(member));
	}
}