package com.boot.designpattern.proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MyInvocatioHandler implements InvocationHandler {
	
	private Object traget ;
	
	public MyInvocatioHandler(Object traget){
		 this.traget  = traget ;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		 System.out.println("-----before-----");
		 Object result = method.invoke(traget, args);
		 System.out.println("-----end-----");
		return result;
	}
	
	// 生成代理对象
	public Object getProxy(){
		ClassLoader  loader = Thread.currentThread().getContextClassLoader();
		Class<?>[] interfaces = traget.getClass().getInterfaces();
		return Proxy.newProxyInstance(loader, interfaces, this);
	}

}
