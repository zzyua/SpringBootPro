package com.boot;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.entity.Person;

@SpringBootApplication
@MapperScan("com.boot.dao.mapper")
@Controller
public class SpringBootProApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProApplication.class, args);
	}
	
	
	 @RequestMapping("/")
	    public String index(Model model){
		 	Person onePerson = new Person("微儿博客", 18);
			
			List<Person> list = new ArrayList<Person>();
			Person p1 = new Person("张三", 18);
			Person p2 = new Person("李四", 19);
			Person p3 = new Person("王五", 20);
			list.add(p1);
			list.add(p2);
			list.add(p3);
			
			model.addAttribute("oneperson", onePerson);//向模板传数据
			model.addAttribute("people", list);
	        return "indexs";
	    }
	 
	 
	
}
