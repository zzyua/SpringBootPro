package com.boot.repository;

import java.util.List;

import com.boot.entity.Sales_volume;

public interface SalesRepository
//extends JpaRepository<Sales_volume,Integer>
{
	
	/**
	 * 根据类别名称来查找数据
	 * @param className
	 * @return
	 */
	public List<Sales_volume> findByClasscationOrderByRegioname(String className);
	
	/**
	 * 根据日期查询数据
	 * @param date
	 * @return
	 */
	public List<Sales_volume> findByDate(String date);
	
	/**
	 * 根据地区查询数据
	 * @param regioname
	 * @return
	 */
	public List<Sales_volume> findByRegioname(String regioname);
	
	/**
	 * 组合条件查询：类别、日期、地区
	 * @param className
	 * @param date
	 * @param regioname
	 * @return
	 */
	public  List<Sales_volume> findByClasscationAndDateAndRegioname(String className,String date,String regioname);
	
	/**
	 * 组合条件查询：类别、日期
	 * @param className
	 * @param date
	 * @return
	 */
	public  List<Sales_volume> findByClasscationAndDate(String className,String date);
	
	

	/**
	 * 组合条件查询：类别、地区
	 * @param className
	 * @param regioname
	 * @return
	 */
	public  List<Sales_volume> findByClasscationAndRegioname(String className,String regioname);


	/**
	 * 组合条件查询：日期、地区
	 * @param date
	 * @param regioname
	 * @return
	 */
	public  List<Sales_volume> findByDateAndRegioname(String date,String regioname);
}
