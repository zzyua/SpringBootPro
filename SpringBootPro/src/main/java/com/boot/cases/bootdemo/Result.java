package com.boot.cases.bootdemo;

/**
 * Http请求返回最外层对象
 * @author Administrator
 *
 */
public class Result<T> {
	/**
	 * 状态码
	 */
	private Integer code;
	
	/**
	 * 结果说明
	 */
	private String msg;
	
	/**
	 * 具体信息
	 */
	private T data ;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	

}






