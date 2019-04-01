package com.lessons.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.lessons.inteceptor.TimeInteceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.lessons.controller")
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	
	//国际化配置文件加载
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
		
	}
	
	//session 国际化
	@Bean("localeResolver")
	public SessionLocaleResolver s() {
		return new SessionLocaleResolver();
		
	}
	
	//处理跨域请求
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/**");
	}
	
	//拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// registry.addInterceptor(new LoginInteceptor());
		LocaleChangeInterceptor lr = new LocaleChangeInterceptor();
		lr.setParamName("lang");  //默认是locale
		registry.addInterceptor(new TimeInteceptor());
		registry.addInterceptor(lr);
	}

	//视图解析器
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
		
		
	}
	
//	@Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/jsp/");
//        resolver.setSuffix(".jsp");
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }

	//日期格式控制器
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
	}

	//静态资源处理
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/statics/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/statics/js/");
	}
}
