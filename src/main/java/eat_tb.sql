CREATE TABLE `eat_tb` (
  `id` varchar(20) NOT NULL,
  `code` int(11) NOT NULL,
  `number` int(11) NOT NULL DEFAULT '0',
  KEY `id_idx` (`id`),
  KEY `code_idx` (`code`),
  CONSTRAINT `code` FOREIGN KEY (`code`) REFERENCES `food_tb` (`code`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `user_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;