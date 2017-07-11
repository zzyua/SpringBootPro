package com.boot.util.poi;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;



public class PoiUtil {
	
	
	
	/**
	 * 根据excel文档，获名为取“XXXX财年”的Sheet
	 * @return
	 */
	public static   Sheet getAnnualStatisSheet(Workbook book) throws Exception {
		Sheet sheet = null ; 
		boolean  notFind = true ; //定义开关
		int sheetIndex = 0 ;
		while(notFind){
			Sheet sheetc = book.getSheetAt(sheetIndex);
			sheetIndex++;
			int result = sheetc.getSheetName().indexOf("财年");
			if(result > 0 ){
				notFind = false ; 
				sheet = sheetc ;
			}
			
		}
		return sheet ;
	}

	/** 
     * 复制单元格 
     *  
     * @param srcCell 
     * @param distCell 
     * @param copyValueFlag 
     *            true则连同cell的内容一起复制 
     */  
    public static void copyCell(Workbook wb,Cell srcCell, Cell distCell,  
            boolean copyValueFlag) {  
    	
        // 不同数据类型处理  
        @SuppressWarnings("deprecation")
		CellType srcCellType = srcCell.getCellTypeEnum() ; //     srcCell.getCellType();  
        distCell.setCellType(srcCellType);  
        if (copyValueFlag) {  
            if (srcCellType == CellType.NUMERIC) {  
                if (HSSFDateUtil.isCellDateFormatted(srcCell)) {  
                    distCell.setCellValue(srcCell.getDateCellValue());  
                } else {  
                    distCell.setCellValue(srcCell.getNumericCellValue());  
                }  
            } else if (srcCellType == CellType.STRING ) {  
                distCell.setCellValue(srcCell.getRichStringCellValue());  
            } else if (srcCellType == CellType.BLANK) {  
                // nothing21  
            } else if (srcCellType ==CellType.BOOLEAN) {  
                distCell.setCellValue(srcCell.getBooleanCellValue());  
            } else if (srcCellType ==CellType.ERROR) {  
                distCell.setCellErrorValue(srcCell.getErrorCellValue());  
            } else if (srcCellType ==CellType.FORMULA) {  
                distCell.setCellFormula(srcCell.getCellFormula());  
            } else { // nothing29  
            	distCell.setCellType(CellType._NONE);
            }  
        }  
        
    }  
    
    
    
    /** 
     * 复制一个单元格样式到目的单元格样式 
     * @param fromStyle 
     * @param toStyle 
     */  
    public static void copyCellStyle(CellStyle fromStyle,  
            CellStyle toStyle) {  
    	
    	HorizontalAlignment  alignment = fromStyle.getAlignmentEnum();
    	toStyle.setAlignment(alignment);
        toStyle.setTopBorderColor(fromStyle.getTopBorderColor());  
        toStyle.setBottomBorderColor(fromStyle.getBottomBorderColor());  
        toStyle.setRightBorderColor(fromStyle.getRightBorderColor());  
        toStyle.setLeftBorderColor(fromStyle.getLeftBorderColor());  
        //背景和前景  
        toStyle.setFillBackgroundColor(fromStyle.getFillBackgroundColor());  
        toStyle.setFillForegroundColor(fromStyle.getFillForegroundColor());  
        toStyle.setDataFormat(fromStyle.getDataFormat());  
        toStyle.setHidden(fromStyle.getHidden());  
        toStyle.setIndention(fromStyle.getIndention());//首行缩进  
        toStyle.setLocked(fromStyle.getLocked());  
        toStyle.setRotation(fromStyle.getRotation());//旋转  
        toStyle.setVerticalAlignment(fromStyle.getVerticalAlignmentEnum());
//        toStyle.setVerticalAlignment(fromStyle.getVerticalAlignment());  
        toStyle.setWrapText(fromStyle.getWrapText());  
          
    }  

}
