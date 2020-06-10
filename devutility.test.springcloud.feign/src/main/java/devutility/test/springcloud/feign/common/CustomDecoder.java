package devutility.test.springcloud.feign.common;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;

import devutility.internal.lang.reflect.GenericTypeUtils;
import devutility.test.springcloud.feign.model.OtherApiResponse;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.optionals.OptionalDecoder;

/**
 * 
 * CustomDecoder
 * 
 * @author: Aldwin Su
 * @version: 2020-06-10 11:26:48
 */
public class CustomDecoder implements Decoder {
	private ObjectFactory<HttpMessageConverters> messageConverters;
	private final Decoder delegate;

	public CustomDecoder(ObjectFactory<HttpMessageConverters> messageConverters) {
		this.messageConverters = messageConverters;
		Objects.requireNonNull(this.messageConverters, "Message converters must not be null. ");
		this.delegate = new OptionalDecoder(new ResponseEntityDecoder(new SpringDecoder(this.messageConverters)));
	}

	@Override
	public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			Type rawType = parameterizedType.getRawType();

			if (rawType instanceof Class) {
				@SuppressWarnings("rawtypes")
				Class rawClass = (Class) rawType;

				if (rawClass.equals(OtherApiResponse.class)) {
					Type genericType = GenericTypeUtils.getGenericType(parameterizedType);
					Object data = delegate.decode(response, genericType);
					return new OtherApiResponse<Object>(data);
				}
			}
		}

		return delegate.decode(response, type);
	}
}