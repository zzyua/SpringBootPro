package com.boot.cases.bootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
	
	
	
	@Autowired
	private GirlRepository girlRepository;
	
	/**
	 * 数据库事务管理
	 * 插入、更新的时候都可以用这个控制
	 */
	@Transactional
	public void insertTwo(){
		Girl girlA = new Girl();
		girlA.setCupSize("E");
		girlA.setAge(27);
		Girl girlB = new Girl();
		girlB.setCupSize("Ggg");
		girlB.setAge(32);
		
		girlRepository.save(girlA);
		girlRepository.save(girlB);
	}
	
	public void getAge(Integer id ) throws Exception {
		Girl girl = girlRepository.findOne(id);
		Integer age = girl.getAge();
		if(age < 10 ){
			//你还在上小学吧 code 100
			throw  new DymaicException(ResultEnum.PRIMARY_SCHOOL);
			
		}else if(age > 10 && age < 16 ){
			//返回“你可能在上初中” code 101
			throw  new DymaicException(ResultEnum.MIDDLE_SCHOOL);
		}
		
	}
	
	/**
	 * 通过id查找一个女生
	 * @param id
	 * @return
	 */
	public Girl findOne(Integer id){
		return girlRepository.findOne(id);
	}

}
