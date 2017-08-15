package com.boot.designpattern.proxy.demo1;

public class UserServiceImpl implements Service {

	@Override
	public void add() {  
        System.out.println("This is add service by UserServiceImpl");  
    }  

}
