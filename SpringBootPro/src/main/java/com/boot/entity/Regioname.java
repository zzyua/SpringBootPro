package com.boot.entity;

public enum Regioname {
	
	CIXI("慈溪"),
	HUZHOU("湖州"),
	JIAXING("嘉兴"),
	LISHUI("丽水"),
	NINGBO("宁波"),
	NINGHAI("宁海"),
	PINGYANG("平阳"),
	QUZHOU("衢州"),
	RUIAN("瑞安"),
	SHAOXIN("绍兴"),
	SHIQU("市区"),
	TAIZHOU("台州"),
	TONGLU("桐庐"),
	WENLING("温岭"),
	WENZHOU("温州"),
	XIAOSHAN("萧山"),
	YIWU("义务"),
	YUHANG("余杭"),
	ZHOUSHAN("舟山")
	;
	
	
	
	private String value;
	
	private Regioname(String value){
		
		this.value = value ;
	}
	
	
	public String getValue(){
		return value;
	}
	

}
