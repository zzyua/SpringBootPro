package com.boot.cases.bootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
	private static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result handler(Exception e ){
		
		if(e instanceof DymaicException){
			DymaicException dymaicException= (DymaicException)e;
			return ResultUtil.error(dymaicException.getCode(), dymaicException.getMessage());
		}else{
			logger.error("【系统异常】：{}",e);
			return ResultUtil.error( -1 ,"未知错误");
		}
		
	}
}
