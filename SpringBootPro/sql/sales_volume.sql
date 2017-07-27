CREATE TABLE  IF NOT EXISTS   `dbgirl`.`sales_volume` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `classcation` varchar(45) NOT NULL COMMENT '类别：【总】、【vivo】、【oppo】',
  `date` varchar(10) NOT NULL COMMENT 'yyyy-MM保存，展示需要显示成yyyy年MM月',
  `datatime` varchar(45) DEFAULT NULL COMMENT '生成该记录的日期 yyyy-MM-dd HH:mm:ss',
  `amount` int(11) NOT NULL DEFAULT '0' COMMENT '数量',
  `regioname` varchar(55) NOT NULL COMMENT '地区name',
  `modifydate` datetime DEFAULT NULL COMMENT '记录修改的日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unindex` (`classcation`,`date`,`regioname`),
  KEY `classcation` (`classcation`),
  KEY `date` (`date`),
  KEY `regioname` (`regioname`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8



-----------------------------------------------------
DROP PROCEDURE IF EXISTS `pro_salse_query`;  
CREATE PROCEDURE pro_salse_query(OUT p_count INT)
BEGIN
	#Routine body goes here...
	
SET @sql = NULL;
	SELECT
	 GROUP_CONCAT(DISTINCT
		CONCAT(
		 'MAX(CASE st.date WHEN ''',st.date,''' THEN  st.amount ELSE 0 END ) 

      AS ''',st.date ,''' '
		)
	 ) INTO @sql
	FROM sales_volume st ;


SET @sql = CONCAT(' Create TEMPORARY table  tab1  (Select st.regioname, st.classcation, ', @sql, 
							'  From sales_volume st 
							
							Group by  st.classcation  ,  st.regioname   ) ; ');

	PREPARE stmt FROM @sql;
	EXECUTE stmt;
	DEALLOCATE PREPARE stmt;

  desc tab1 ;
  set p_count =  FOUND_ROWS(); 

-- select * from tab1  ORDER BY classcation ;

DROP TABLE tab1 ;

END
-------------------------