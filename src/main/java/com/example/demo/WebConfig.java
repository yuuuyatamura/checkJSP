//package com.example.demo;
//
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//
//@Configuration
//public class WebConfig {
//
//	@Bean
//	public MessageSource messageSource() {
//		ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
//		
//		//メッセージのプロパティファイル名を指定する
//		bean.setBasename("classpath:messages");
//		
//		//メッセージプロパティの文字コードを指定します
//		bean.setDefaultEncoding("UTF-8");
//		
//		return bean;
//	}
//	
//	@Bean
//	public LocalValidatorFactoryBean localValidatorFavtoryBean() {
//		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
//		
//		localValidatorFactoryBean.setValidationMessageSource(messageSource());
//		
//		return localValidatorFactoryBean;
//	}
//}
