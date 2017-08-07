package com.boot.cases.bootdemo;

/**
 * 自定义Exception 必须要继承RuntimeException，
 * 因为Spring只对RuntimeException的异常进行事务的回滚
 * @author Administrator
 *
 */
public class DymaicException extends RuntimeException {
	
	private static final long serialVersionUID = -4431795741125420300L;

	private Integer code ;
	
	public DymaicException(ResultEnum resultEnum ) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
	
	

}
