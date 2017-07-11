package com.boot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.boot.entity.Regioname;
import com.boot.util.poi.PoiUtil;

public class test {
	public static void main(String[] args) throws Exception   {
		String file = "D:/poi/files/移动销量数据2017.4-2018.3.xlsx";
		
		InputStream ins = null;
		Workbook wb = null;
		Sheet sheet = null ;
		FileOutputStream fileOut = null;
		ins = new FileInputStream(new File(file));
		wb = WorkbookFactory.create(ins);
		try {
			sheet = PoiUtil.getAnnualStatisSheet(wb);
		} catch (Exception e) {
			if(  e instanceof IllegalArgumentException) {
				System.out.println("没有找到含有【财年】的sheet");
			}else
				e.printStackTrace();
		}
		System.out.println(Regioname.CIXI.getValue());
		
		//getAlllist(sheet);
//	   System.out.println(sheet.getSheetName());
	   
//	   System.out.println(sheet.getLastRowNum());
	//	DecimalFormat df = new DecimalFormat("0");  
		//CellType  type  = null ; 
		//cellValue = df.format(cell.getNumericCellValue());  
	  // Row row = sheet.getRow(20);
	 //  Cell cell = row.getCell(21);
	   //  type  = cell.getCellTypeEnum();
//	   System.out.println(type.name());
//	   System.out.println(df.format(cell.getNumericCellValue()));
//	   System.out.println(row.getLastCellNum());
	   
	   
	}
	
	
	/**
	 * 获取指定Sheet中的数据，并将其转换为实体
	 * @param sheet
	 * @return
	 */
	public static void  getAlllist(Sheet sheet){
		DecimalFormat df = new DecimalFormat("0"); 
		CellType  type = null ; 
		int rowNum = sheet.getLastRowNum();
		for(int i = 0 ; i < rowNum ; i++){
			Row row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			for(int j = 0 ; j < cellNum ; j++){
				Cell cell = row.getCell(i);
				try {
					type = cell.getCellTypeEnum();
				} catch (NullPointerException e) {
					break ; 
				}catch (Exception e) {
					e.printStackTrace();
				}
			
				if(type == CellType.STRING){  //String类型操作
					cell.getStringCellValue();
				}else if(type ==CellType.NUMERIC || type ==CellType.FORMULA){ //数字类型操作
					Double.valueOf(cell.getNumericCellValue()).intValue();
				}else{//空类型操作
					
				}
			}
			
			
		//	System.out.println(Double.valueOf(cell.getNumericCellValue()).intValue());
		//	System.out.println(cellNum);
			
		}
//		Row row = sheet.getRow(66);
//		Cell cell = row.getCell(0);
//		System.out.println(cell.getStringCellValue());
		
		
		
		
	}
	
	

}
