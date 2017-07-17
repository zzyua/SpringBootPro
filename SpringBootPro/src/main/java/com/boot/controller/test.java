package com.boot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.boot.entity.DateFormatPoi;
import com.boot.entity.Regioname;
import com.boot.entity.Sales_volume;
import com.boot.util.poi.PoiUtil;

public class test {
	public static void main(String[] args) throws Exception   {
//		INSERT INTO sales_volume (classcation , date , amount , regioname) 
//		VALUES ('all','2016-04',46931,'慈溪'  ) ON DUPLICATE KEY UPDATE amount=931; 
		
		
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
		
	   
	   
	}
	

	
	
	
	
	

	
	

}
