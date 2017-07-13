package com.boot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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
			sheet =  PoiUtil.getAnnualStatisSheet(wb); //wb.getSheetAt(2);//
		} catch (Exception e) {
			if(  e instanceof IllegalArgumentException) {
				System.out.println("没有找到含有【财年】的sheet");
			}else
				e.printStackTrace();
		}
		
		initstatisticSheet(sheet);
	//	System.out.println(Regioname.CIXI.getValue());
		
	//	Row row = sheet.getRow(1);
		//System.out.println(getDate(row.getCell(2)));
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
	 * 解析Sheet ,初始化sheet的数据的结构
	 * @param sheet
	 */
	public static void initstatisticSheet(Sheet sheet){
		int rowNum = sheet.getLastRowNum();
		String cellVal = "";
		for(int i = 0 ; i < rowNum ; i++){
			Row row = sheet.getRow(i);
			try {
				cellVal	 = row.getCell(0).getStringCellValue();
			} catch (NullPointerException e) {
				cellVal= "";
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			System.out.println(cellVal);
		}
		
	}
	
	
	/**
	 * 解析xml，获取店总的数据
	 * @param sheet
	 * @return
	 */
	public static void  getTotallist(Sheet sheet){
		DecimalFormat df = new DecimalFormat("0");   //将数字格式化
		CellType  type = null ; 
		int rowNum = sheet.getLastRowNum(); //取得最大的有效行数
		String regioname = "";
		for(int i = 0 ; i < rowNum ; i++){
			Row row = sheet.getRow(i);
			int cellNum = row.getLastCellNum(); //取得最大有效列数
			for(int j = 0 ; j < cellNum ; j++){
				String  regionCellval  = "";
				
				Cell cell = row.getCell(j);
				
				try {
					type = cell.getCellTypeEnum();
				} catch (NullPointerException e) {
					break ; 
				}catch (Exception e) {
					e.printStackTrace();
				}
			
//				if(i == 0){
//					regionCellval
//					
//				}else if(i == 1){
//					//continue; 
//				}else{
//					
//				}
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
	
	/**
	 * 解析， 获取VIVO的数据
	 * @param sheet
	 */
	public static void  getVivollist(Sheet sheet){
		
	}
	
	/**
	 * 解析， 获取Oppo的数据
	 * @param sheet
	 */
	public static void  getOppollist(Sheet sheet){
		
	}
	
	private  static String getDate(Cell cell){
        DecimalFormat df = new DecimalFormat("#");
        String result ="";
        if(cell == null){
            return "";
        }
        CellType type = cell.getCellTypeEnum();
        if(type == CellType.NUMERIC){
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        	result =  sdf.format(DateUtil.getJavaDate(cell.getNumericCellValue()));
        }if(type ==CellType.STRING ){
        	result= cell.getStringCellValue();
        }
        
        
//        switch (hssfCell.getCellTypeEnum()){
//        case  CellType.NUMERIC : // HSSFCell.CELL_TYPE_NUMERIC:
//            if(HSSFDateUtil.isCellDateFormatted(hssfCell)){
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//                return sdf.format(HSSFDateUtil.getJavaDate(hssfCell.getNumericCellValue()));
//            }
//
//                return df.format(hssfCell.getNumericCellValue());
//        case HSSFCell.CELL_TYPE_STRING:
//            return hssfCell.getStringCellValue();
//        case HSSFCell.CELL_TYPE_FORMULA:
//            return hssfCell.getCellFormula();
//        case HSSFCell.CELL_TYPE_BLANK:
//            return "";
//
//        }
        
        
        
    return result;


    }
	

}
