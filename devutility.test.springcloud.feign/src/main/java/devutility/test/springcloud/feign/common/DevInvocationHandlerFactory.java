package devutility.test.springcloud.feign.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import feign.InvocationHandlerFactory;
import feign.Target;

public class DevInvocationHandlerFactory implements InvocationHandlerFactory {
	@Override
	public InvocationHandler create(@SuppressWarnings("rawtypes") Target target, Map<Method, MethodHandler> dispatch) {
		return null;
	}
}