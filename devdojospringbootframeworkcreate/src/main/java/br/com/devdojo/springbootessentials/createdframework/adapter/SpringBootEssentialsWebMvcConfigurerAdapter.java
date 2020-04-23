package br.com.devdojo.springbootessentials.createdframework.adapter;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author ferreira
 * @since 06/04/2020
 */
@Configuration
public class SpringBootEssentialsWebMvcConfigurerAdapter implements WebMvcConfigurer{

	/**
	 * configuration for pagination, first page, size 5
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		PageableHandlerMethodArgumentResolver phmar = new PageableHandlerMethodArgumentResolver();
		phmar.setFallbackPageable(PageRequest.of(0, 5));
		resolvers.add(phmar);
	}
}
