package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Sales_volume;
import com.boot.repository.SalesRepository;

@RestController
public class SalesTestController {
	
	@Autowired
	private SalesRepository salesRepository;
	
	@GetMapping(value="sales/all")
	public List<Sales_volume> showAll(){
		return salesRepository.findAll();
	}
	
	@GetMapping(value="sales/class/{classname}")
	private List<Sales_volume> classAll(@PathVariable("classname") String className){
		System.out.println("calssName="+className);
		return salesRepository.findByClasscationOrderByRegioname(className);
	}

}
