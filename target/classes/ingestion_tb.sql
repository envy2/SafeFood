CREATE TABLE `ingestion_tb` (
  `id` varchar(20) NOT NULL,
  `code` int(11) NOT NULL,
  `number` int(11) DEFAULT '0',
  `day` date NOT NULL,
  KEY `fcode_idx` (`code`),
  KEY `uid_idx` (`id`),
  CONSTRAINT `fcode` FOREIGN KEY (`code`) REFERENCES `food_tb` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uid` FOREIGN KEY (`id`) REFERENCES `user_tb` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
