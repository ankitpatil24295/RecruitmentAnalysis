/*
SQLyog Community v12.4.3 (32 bit)
MySQL - 5.7.19-log : Database - recruitmentanalysis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`recruitmentanalysis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `recruitmentanalysis`;

/*Table structure for table `applicant` */

DROP TABLE IF EXISTS `applicant`;

CREATE TABLE `applicant` (
  `applicant_id` int(10) NOT NULL AUTO_INCREMENT,
  `applicant_name` varchar(30) NOT NULL,
  `applicant_skill_set` varchar(15) NOT NULL,
  `applicant_experience` double(4,2) NOT NULL,
  PRIMARY KEY (`applicant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `applicant` */

insert  into `applicant`(`applicant_id`,`applicant_name`,`applicant_skill_set`,`applicant_experience`) values 
(1,'ankit','java',1.50),
(2,'hemant','java',2.40),
(3,'dhanu','python',1.00),
(4,'Akash','database',2.50),
(5,'pallavi','java',4.00),
(6,'jay','architecture',11.00),
(7,'viru','business',8.00),
(8,'jayshree','python',1.00),
(10,'jayshree','python',3.00),
(11,'jayshree','db',3.00),
(12,'parthiv','manager',14.00),
(13,'khusbu','java',3.00),
(14,'suyog','java',5.00),
(15,'nayan','junit',7.00),
(16,'harshada','c',3.40),
(17,'dinesh','c++',10.00);

/*Table structure for table `applicantapply` */

DROP TABLE IF EXISTS `applicantapply`;

CREATE TABLE `applicantapply` (
  `applicant_id` int(10) NOT NULL DEFAULT '0',
  `position_id` int(10) NOT NULL DEFAULT '0',
  `date_of_apply` date NOT NULL,
  PRIMARY KEY (`applicant_id`,`position_id`),
  KEY `position_id` (`position_id`),
  CONSTRAINT `applicantapply_ibfk_1` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`applicant_id`),
  CONSTRAINT `applicantapply_ibfk_2` FOREIGN KEY (`position_id`) REFERENCES `post` (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `applicantapply` */

insert  into `applicantapply`(`applicant_id`,`position_id`,`date_of_apply`) values 
(1,501,'2017-01-08'),
(3,505,'2017-10-23'),
(4,502,'2017-10-29'),
(5,504,'2017-10-29'),
(10,505,'2017-10-30'),
(11,502,'2017-10-30'),
(12,508,'2017-10-30'),
(13,501,'2017-10-30'),
(14,501,'2017-10-30'),
(15,501,'2017-10-30'),
(16,501,'2017-10-30'),
(17,511,'2017-10-30');

/*Table structure for table `hr` */

DROP TABLE IF EXISTS `hr`;

CREATE TABLE `hr` (
  `hr_id` int(10) NOT NULL DEFAULT '0',
  `hr_name` varchar(30) NOT NULL,
  `hr_password` varchar(50) NOT NULL,
  `hr_department` varchar(30) NOT NULL,
  `hr_contact` varchar(15) NOT NULL,
  PRIMARY KEY (`hr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hr` */

insert  into `hr`(`hr_id`,`hr_name`,`hr_password`,`hr_department`,`hr_contact`) values 
(201,'hema','java1','hi','93984143'),
(202,'pallavi','12345','bye','93984143'),
(203,'sharvani','Lenovo@2020','exp','99999999');

/*Table structure for table `interview` */

DROP TABLE IF EXISTS `interview`;

CREATE TABLE `interview` (
  `applicant_id` int(10) NOT NULL DEFAULT '0',
  `position_id` int(10) NOT NULL DEFAULT '0',
  `date_of_interview` date NOT NULL,
  `candidate_result` tinyint(1) NOT NULL,
  `date_of_joining` date DEFAULT NULL,
  `joining_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`position_id`,`applicant_id`),
  KEY `applicant_id` (`applicant_id`),
  CONSTRAINT `interview_ibfk_1` FOREIGN KEY (`applicant_id`) REFERENCES `applicantapply` (`applicant_id`),
  CONSTRAINT `interview_ibfk_2` FOREIGN KEY (`position_id`) REFERENCES `applicantapply` (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `interview` */

insert  into `interview`(`applicant_id`,`position_id`,`date_of_interview`,`candidate_result`,`date_of_joining`,`joining_status`) values 
(1,501,'2017-10-03',1,'2017-10-11',1),
(13,501,'2017-10-04',1,'2017-10-16',1),
(14,501,'2017-10-01',1,'2017-10-18',1),
(4,502,'2017-10-07',1,'2017-10-18',1),
(5,504,'2017-10-05',0,NULL,0),
(3,505,'2017-10-04',1,'2017-10-19',1);

/*Table structure for table `post` */

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `position_id` int(10) NOT NULL DEFAULT '0',
  `hr_id` int(10) NOT NULL,
  `position_name` varchar(30) NOT NULL,
  `no_of_position` int(10) NOT NULL,
  `experience_required` double(4,2) NOT NULL,
  `position_post_date` date NOT NULL,
  `position_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`position_id`),
  KEY `hr_id` (`hr_id`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`hr_id`) REFERENCES `hr` (`hr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `post` */

insert  into `post`(`position_id`,`hr_id`,`position_name`,`no_of_position`,`experience_required`,`position_post_date`,`position_status`) values 
(501,201,'java expert',0,2.00,'2017-02-01',0),
(502,202,'DBMS expert',3,2.00,'2017-02-01',1),
(503,201,'',4,3.50,'1970-01-01',1),
(504,201,'javacore',5,3.50,'1970-01-01',1),
(505,201,'python',0,2.00,'2017-10-28',0),
(508,203,'project manager',0,8.00,'2017-10-28',0),
(511,203,'productmanager',4,3.00,'2017-10-30',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
