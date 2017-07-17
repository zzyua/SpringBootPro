package com.boot.mysqls;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import com.boot.entity.Sales_volume;

/**
 * mybatis 注解实现批量更新的SQL语句拼接
 * @author Administrator
 *
 */
public class SalesVolumeProvider {

	public String insertAll(Map map) {  
        List<Sales_volume> sales = (List<Sales_volume>) map.get("list");  
        StringBuilder sb = new StringBuilder();  
        sb.append("INSERT INTO sales_volume ");  
        sb.append("(classcation , date , amount , regioname ,modifydate ,datatime) ");  
        sb.append("VALUES ");  
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].classcation}, #'{'list[{0}].date}, #'{'list[{0}].amount}, #'{'list[{0}].regioname}, now() , current_date)");  
        for (int i = 0; i < sales.size(); i++) {  
            sb.append(mf.format(new Object[]{i}));  
            if (i < sales.size() - 1) {  
                sb.append(",");  
            }  
        }  
        sb.append(" ON DUPLICATE KEY UPDATE amount=VALUES(amount) , modifydate=now()  ");
        return sb.toString();  
    }
}
