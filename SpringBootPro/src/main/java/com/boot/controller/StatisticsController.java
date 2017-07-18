package com.boot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.cases.bootdemo.Result;
import com.boot.cases.bootdemo.ResultUtil;
import com.boot.dao.mapper.Sales_volumeMapper;
import com.boot.entity.Sales_volume;
import com.boot.util.poi.PoiUtil;
/**
 * 年度统计Excel操作Controller
 */
@RestController
public class StatisticsController {
	
	
	
	@Autowired
	private Sales_volumeMapper salesvoDao;
	
	
	@GetMapping(value = "do/findall")
	public Result findAll(){
		return ResultUtil.success(salesvoDao.findAll());
	}
	
	@GetMapping(value = "do/insertall")
	public  void testInsert() throws Exception {

		String file = "D:/poi/files/移动销量数据2017.4-2018.3.xlsx";
		
		InputStream ins = null;
		Workbook wb = null;
		Sheet sheet = null ;
		FileOutputStream fileOut = null;
		ins = new FileInputStream(new File(file));
		wb = WorkbookFactory.create(ins);
		try {
			sheet =  PoiUtil.getAnnualStatisSheet(wb); //wb.getSheetAt(2);//
		} catch (Exception e) {
			if(  e instanceof IllegalArgumentException) {
				System.out.println("没有找到含有【财年】的sheet");
			}else
				e.printStackTrace();
		}
		
		List<Sales_volume> listEntits = PoiUtil.getAlllist(sheet);

		salesvoDao.insertAll(listEntits);
	}
	
	
	/**
	 * 将年度数据Excel进行持久化操作
	 */
	@GetMapping(value = "do/persistence")
	public List<Sales_volume> doPersistence() throws Exception{
		String file = "D:/poi/files/移动销量数据2017.4-2018.3.xlsx";
		
		InputStream ins = null;
		Workbook wb = null;
		Sheet sheet = null ;
		FileOutputStream fileOut = null;
		ins = new FileInputStream(new File(file));
		wb = WorkbookFactory.create(ins);
		try {
			sheet =  PoiUtil.getAnnualStatisSheet(wb); //wb.getSheetAt(2);//
		} catch (Exception e) {
			if(  e instanceof IllegalArgumentException) {
				System.out.println("没有找到含有【财年】的sheet");
			}else
				e.printStackTrace();
		}
		
		List<Sales_volume> listEntits = PoiUtil.getAlllist(sheet);
		System.out.println(listEntits.size());
		for (Sales_volume sales_volume : listEntits) {
			System.out.println(sales_volume.getClasscation()+" ; " +sales_volume.getRegioname()+" ; " + sales_volume.getAmount() + " ; " +sales_volume.getDate() + " ;  " +sales_volume.getDatatime());
		}
		
		
		
		
		return listEntits ;
	}


}
