/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.5.23 : Database - sys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sys` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `sys`;

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` enum('1','2','3','4','5','6','7','8','9','10','11') CHARACTER SET utf8 NOT NULL,
  `prefix` enum('А','Б','В','Г','Д') CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `class` */

insert  into `class`(`id`,`number`,`prefix`) values 
(1,'7','Б'),
(2,'8','А'),
(3,'8','Б'),
(4,'8','В'),
(5,'7','А'),
(6,'9','Д');

/*Table structure for table `days` */

DROP TABLE IF EXISTS `days`;

CREATE TABLE `days` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lesson_id` (`lesson_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `days_ibfk_1` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  CONSTRAINT `days_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `days` */

insert  into `days`(`id`,`lesson_id`,`class_id`,`count`) values 
(1,1,3,20),
(2,2,3,15),
(3,2,2,17);

/*Table structure for table `lesson` */

DROP TABLE IF EXISTS `lesson`;

CREATE TABLE `lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `lesson` */

insert  into `lesson`(`id`,`name`) values 
(1,'Математика'),
(2,'Русский язык'),
(3,'Литература'),
(4,'Химия');

/*Table structure for table `mark` */

DROP TABLE IF EXISTS `mark`;

CREATE TABLE `mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `day` tinyint(11) NOT NULL,
  `mark` tinyint(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lesson_id` (`lesson_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `mark_ibfk_1` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  CONSTRAINT `mark_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `mark` */

insert  into `mark`(`id`,`lesson_id`,`student_id`,`day`,`mark`) values 
(1,1,1,2,4),
(3,2,2,3,4),
(4,1,1,7,2),
(5,1,1,5,4),
(6,1,3,3,5),
(7,1,4,10,4),
(8,1,4,15,2),
(9,1,3,10,2),
(10,1,3,8,5),
(11,1,3,2,2),
(12,1,5,12,4),
(13,1,4,5,4),
(14,1,5,1,5),
(15,1,5,4,5),
(16,1,5,10,4),
(17,1,5,17,5),
(18,1,4,17,2),
(19,1,1,13,4),
(20,1,1,10,3),
(21,1,4,12,4),
(22,1,4,13,5),
(23,1,3,15,5),
(24,1,3,20,5),
(25,1,3,5,4),
(26,1,1,9,5),
(27,1,4,1,2),
(28,2,1,2,4),
(29,1,4,7,2),
(30,1,5,7,4);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `fullName` varchar(256) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`class_id`,`fullName`) values 
(1,3,'Ковалев Олег Артемович'),
(2,2,'Полтавец Павел Евгеньевич'),
(3,3,'Иванов Иван Иванович'),
(4,3,'Петров Петр Петрович'),
(5,3,'Фоменко Илья Алексеевич');

/*Table structure for table `sys_config` */

DROP TABLE IF EXISTS `sys_config`;

CREATE TABLE `sys_config` (
  `variable` varchar(128) NOT NULL,
  `value` varchar(128) DEFAULT NULL,
  `set_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `set_by` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`variable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_config` */

insert  into `sys_config`(`variable`,`value`,`set_time`,`set_by`) values 
('diagnostics.allow_i_s_tables','OFF','2016-10-03 23:36:18',NULL),
('diagnostics.include_raw','OFF','2016-10-03 23:36:18',NULL),
('ps_thread_trx_info.max_length','65535','2016-10-03 23:36:18',NULL),
('statement_performance_analyzer.limit','100','2016-10-03 23:36:18',NULL),
('statement_performance_analyzer.view',NULL,'2016-10-03 23:36:18',NULL),
('statement_truncate_len','64','2016-10-03 23:36:18',NULL);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `lesson_id` (`lesson_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  CONSTRAINT `teacher_ibfk_3` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`id`,`user_id`,`lesson_id`,`class_id`) values 
(5,6,1,2),
(6,6,1,3);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(256) NOT NULL,
  `pass` varchar(256) NOT NULL,
  `fullName` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`login`,`pass`,`fullName`) values 
(5,'www.olegvip@mail.ru','$2a$10$q3x4ElEjJEJCeq7Gj1UWT.7EVlRa3/62z0JaA.w0z3h.QI.PTa0Te','Ковалев Олег Артемович'),
(6,'teacher@mail.ru','$2a$10$RfwlFRXM26Ysbpx37E0Cju0KDG5ZYNsp1FWtPuohjsDlnilFI0lPi','Самойлова Анна Владимировна'),
(11,'parent@yandex.ru','$2a$10$Rc20jjfbHBqMrkUQJ2Iwq.a8QhakJTu7Pf0B0QgJArVHa1ERivRG2','Пономарёв Игорь Леонидович'),
(12,'parent2@yandex.ru','$2a$10$C2QkDwNV03kVbMRE/rxCQeuvMKG52rdgfUT3HeiEogiOjKIuSuHWC','Андропова Анастасия Анатольевна');

/*Table structure for table `visit` */

DROP TABLE IF EXISTS `visit`;

CREATE TABLE `visit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `day` tinyint(11) NOT NULL,
  `visit` enum('П','О') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lesson_id` (`lesson_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `visit_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `visit_ibfk_2` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `visit` */

insert  into `visit`(`id`,`lesson_id`,`student_id`,`day`,`visit`) values 
(1,1,1,1,'О'),
(2,1,1,2,'П'),
(3,1,3,2,'П'),
(4,1,3,9,'П'),
(5,1,3,15,'П'),
(6,1,3,19,'О'),
(7,1,4,7,'П'),
(8,1,4,9,'П'),
(9,1,4,16,'П'),
(10,1,4,18,'П'),
(11,1,4,3,'О'),
(12,1,1,10,'О'),
(13,1,1,12,'П'),
(14,1,5,11,'П'),
(15,1,5,4,'О'),
(16,1,4,5,'О'),
(17,1,3,4,'П'),
(18,1,1,5,'П'),
(19,1,5,7,'П'),
(20,1,5,17,'О'),
(21,1,1,7,'О'),
(22,1,1,9,'О'),
(23,1,1,11,'О');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
