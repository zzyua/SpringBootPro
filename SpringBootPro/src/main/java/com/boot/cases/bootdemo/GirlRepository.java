package com.boot.cases.bootdemo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlRepository extends JpaRepository<Girl, Integer>{
	
	/**
	 * 扩展查询方法注意： 方法格式findBy+字段名【首字母大写】
	 * 通过年龄来查询
	 * 
	 */
	public List<Girl> findByAge(Integer age) ;

}
