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