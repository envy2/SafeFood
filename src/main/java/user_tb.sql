CREATE TABLE `user_tb` (
  `id` varchar(20) NOT NULL,
  `pwd` varchar(45) NOT NULL,
  `name` varchar(10) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `alr` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
