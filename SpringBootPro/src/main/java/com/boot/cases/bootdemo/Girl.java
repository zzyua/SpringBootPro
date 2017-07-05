/**
 * 
 */
package com.boot.cases.bootdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Administrator
 *
 */
@Entity
public class Girl {
	public Girl(){
		
	}
	
	/**
	 * @ID
	 */
	@Id
	@GeneratedValue     //自增属性
	private Integer id ;
	
	private String cupSize;
	
	
	
	@Min(value=18,message ="未成年少女禁止入内")
	private Integer age;

	@NotNull(message="金额必填")
	private Float money;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	
	
	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Girl [id=" + id + ", cupSize=" + cupSize + ", age=" + age + ", money=" + money + "]";
	}

	
	
	
	

}
