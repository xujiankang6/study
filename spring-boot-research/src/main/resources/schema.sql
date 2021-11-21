DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) NOT NULL,
  `upwd` varchar(255) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
