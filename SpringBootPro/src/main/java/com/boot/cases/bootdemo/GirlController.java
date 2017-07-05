package com.boot.cases.bootdemo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {
	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
	private GirlService girlService;
	
	@GetMapping(value="/girls/two")
	public void girlTwo(){
		girlService.insertTwo();
	}

	/**
	 * 查询所有女生列表
	 * @return
	 */
	@GetMapping(value="/girls")
	public List<Girl> girlList(){
		return girlRepository.findAll() ;
	}
	
	/**
	 * 添加一个实体
	 * 1、实现表单验证
	 * @return
	 */
	@PostMapping(value="/girls")
	public Result girlAdd(@Valid Girl girl , BindingResult  bindingResult){
		if(bindingResult.hasErrors()){
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage()); 
		}
		return  ResultUtil.success(girlRepository.save(girl));
	}
	
	//查询
	@GetMapping(value="/girls/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id ){
		return girlRepository.findOne(id);
	}
	
	//更新
	@PutMapping(value="/girls/{id}")
	public Girl girlUpdate(@PathVariable("id") Integer id , @RequestParam("cupsize") String cupSize , @RequestParam("age") Integer age){
		Girl girl = new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);
	 return 	girlRepository.save(girl);
		
	}
	
	//删除
	@DeleteMapping(value="/girls/{id}")
	public void deleteGirl(@PathVariable("id") Integer id ){
		girlRepository.delete(id);
	}
	
	@GetMapping(value="/girls/age/{age}")
	public List<Girl> findByAge(@PathVariable("age") Integer age){
		return girlRepository.findByAge(age);
	}
	
	@GetMapping(value="/girls/getAge/{id}")
	public void  getAge(@PathVariable("id") Integer id) throws Exception {
		
			girlService.getAge(id);
	}
	
	
}








