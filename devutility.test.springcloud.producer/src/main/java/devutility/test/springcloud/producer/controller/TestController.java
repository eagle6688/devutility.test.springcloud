package devutility.test.springcloud.producer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.internal.model.OperationResult;
import devutility.test.model.Member;

/**
 * 
 * TestController
 * 
 * @author: Aldwin Su
 * @creation: 2020-08-24 15:00:55
 */
@RestController
@RequestMapping("test")
public class TestController {
	@PostMapping("receive-json")
	public OperationResult receivePostJosn(String languageCode, @RequestBody Member member) {
		OperationResult result = new OperationResult();
		result.setMessage(languageCode);
		result.setData(member);
		return result;
	}

	@PostMapping("receive-form")
	public OperationResult receivePostForm(String languageCode, Member member) {
		OperationResult result = new OperationResult();
		result.setMessage(languageCode);
		result.setData(member);
		return result;
	}
}