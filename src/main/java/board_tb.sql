CREATE TABLE `board_tb` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `content` text NOT NULL,
  `writer` varchar(20) NOT NULL,
  `write_date` date DEFAULT NULL,
  `read_count` int(11) DEFAULT '0',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
