package devutility.test.springcloud.feign.common;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;

public class FeignProxy implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return null;
	}
}