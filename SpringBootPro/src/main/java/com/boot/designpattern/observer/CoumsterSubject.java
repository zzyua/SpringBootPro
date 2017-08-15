package com.boot.designpattern.observer;

/**
 * 目标对象子类
 * @author Administrator
 *
 */
public class CoumsterSubject  extends Subject{
	
	private String status ;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		this.notifyUpdate(status);
	}
	
	
	
	

}
