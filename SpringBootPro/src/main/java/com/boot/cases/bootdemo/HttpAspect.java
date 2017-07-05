package com.boot.cases.bootdemo;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 统一记录请求日志，使用Logger方式
 * @author Administrator
 *
 */
@Aspect
@Component
public class HttpAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * com.boot.cases.bootdemo.GirlController.* (..) )")
	public void log(){
	}

	/**
	 * 处理方法
	 * JoinPoint 根据JoinPoint可以获取到调用的类一级方法
	 * @param joinPoint
	 */
	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		//logger.info("11111111");
		
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request =  (HttpServletRequest) attributes.getRequest();
		//url
		logger.info("url={}" ,request.getRequestURL());
		//method
		logger.info("method={}", request.getMethod());
		//ip
		logger.info("ip={}", request.getRemoteAddr());
		//类方法
		logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		//args
		logger.info("args={}",joinPoint.getArgs());
	}
	
	@After("log()")
	public void doAfter(){
		logger.info("22222222");
	}
	
	/**
	 * 获取处理结束后，返回的对象
	 * @param object
	 */
	@AfterReturning(returning="object" , pointcut="log()")
	public void doAfterReturing(Object object){
		logger.info("response={}" , object);
	}
}









