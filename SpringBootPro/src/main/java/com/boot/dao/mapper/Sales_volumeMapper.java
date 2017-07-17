package com.boot.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.boot.entity.Sales_volume;
import com.boot.mysqls.SalesVolumeProvider;

public interface Sales_volumeMapper {
	@Select("SELECT * FROM sales_volume")
//	@Results({ @Result(property = "classcation",  column = "classcation" ),
//					  @Result(property = "regioname", column = "regioname"), 
//					  @Result(property = "date", column = "date"), 
//					  @Result(property = "amount", column = "amount") 
//					})
	@Results
	public List<Sales_volume> findAll();
	
	
//	@Insert("INSERT INTO sales_volume (classcation , date , amount , regioname)   VALUES(#{classcation}, #{date}, #{amount} , #{regioname})  ON DUPLICATE KEY UPDATE amount=#{amount} ")
//    public  void insert(Sales_volume  sales_volume);
	
	
	@InsertProvider(type = SalesVolumeProvider.class, method = "insertAll")  
    void insertAll(@Param("list") List<Sales_volume> users); 
	
	
	
}
