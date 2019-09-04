-- 查看sql_mode设置
show variables like "sql_mode";
-- 设置sql_mode
set sql_mode='';
set sql_mode='NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES';

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  PRIMARY KEY(`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

LOCK TABLES `tb_user` WRITE;
INSERT INTO `tb_user` VALUES(1,'学生甲','123456');
UNLOCK TABLES;

DROP TABLE IF EXISTS `tb_login_date`;
CREATE TABLE `tb_login_date` (
  `login_date_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_time` datetime DEFAULT NULL,
  `user_id` int(10) NOT NULL,
  PRIMARY KEY (`login_date_id`),
  KEY `fk_login_date_user`(`user_id`),
  CONSTRAINT `fk_login_date_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user`(`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
