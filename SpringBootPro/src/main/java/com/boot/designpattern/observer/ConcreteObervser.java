package com.boot.designpattern.observer;

/**
 * 
 * @author Administrator
 *
 */
public class ConcreteObervser implements IObserver {

	@Override
	public void updateMwg(String subStatus) {
		System.out.println(subStatus);
		
	}
	
	
	
	public static void main(String[] args) {
		ConcreteObervser o1 = new ConcreteObervser();
		ConcreteObervser o2 = new ConcreteObervser();
		
		CoumsterSubject sub = new CoumsterSubject();
		sub.attach(o1);
		sub.attach(o2);
		
		sub.setStatus("1");
		
		sub.detach(o1);
		sub.setStatus("2");
	}

	
	
}
