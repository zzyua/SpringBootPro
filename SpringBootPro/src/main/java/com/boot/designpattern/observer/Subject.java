package com.boot.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象 父类
 * @author Administrator
 *
 */
public class Subject {
	
	//维护观察者列表
	private List<IObserver> observers = new ArrayList<IObserver>();
	
	//增加观察者对象
	public void attach(IObserver oberver){
		observers.add(oberver);
	}
	
	//移出观察者对象
	public void detach(IObserver oberver){
		observers.remove(oberver);
	}
	
	protected void notifyUpdate(String status){
		for (IObserver observer : observers) {
			observer.updateMwg(status);
		}
	}
}
