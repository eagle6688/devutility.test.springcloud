package devutility.test.springcloud.feign.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import feign.Feign;
import feign.InvocationHandlerFactory;
import feign.Target;

public final class DevFeign {
	public static final class Builder extends Feign.Builder {
		@Override
		public Feign build() {
			super.invocationHandlerFactory(new InvocationHandlerFactory() {
				@SuppressWarnings("rawtypes")
				@Override
				public InvocationHandler create(Target target, Map<Method, MethodHandler> dispatch) {
					return null;
				}
			});

			//super.contract(new HystrixDelegatingContract(contract));
			return super.build();
		}
	}
}