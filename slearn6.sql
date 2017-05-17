-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: slearn
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `min` double NOT NULL,
  `max` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'cat1',0,1),(2,'cat2',0.5,1.5),(3,'cat3',1,2),(4,'cat4',1.5,2.5),(5,'cat5',2,3),(6,'cat6',2.5,3.5),(7,'cat7',3,4),(8,'cat8',3.5,5),(9,'cat9',4,5),(10,'cat10',4.5,5),(11,'correct',0,5);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `choice`
--

DROP TABLE IF EXISTS `choice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `choice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `choice_text` varchar(1000) NOT NULL,
  `category` int(11) DEFAULT NULL,
  `question` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `question_fk_idx` (`question`),
  KEY `category_fk_idx` (`category`),
  CONSTRAINT `FK44vwej9g109rxo3lxpaqorn86` FOREIGN KEY (`question`) REFERENCES `question` (`id`),
  CONSTRAINT `FKhbnjng65tnvphen5ffp6crv0n` FOREIGN KEY (`category`) REFERENCES `category` (`id`),
  CONSTRAINT `category_fk` FOREIGN KEY (`category`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `question_fk` FOREIGN KEY (`question`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `choice`
--

LOCK TABLES `choice` WRITE;
/*!40000 ALTER TABLE `choice` DISABLE KEYS */;
INSERT INTO `choice` VALUES (1,'HighTyped Marked Language',1,1),(2,'HigherType Mixed Language',2,1),(3,'HypoTyped Mix Language',3,1),(4,'HyperType Mockup Langauge',4,1),(5,'HypoTyped Marker Language',5,1),(6,'Hyper Typed Mixed Language',6,1),(7,'HypoText Marked Language',7,1),(8,'Hyper Typed Markup Language',8,1),(9,'HyperType Markup Language',9,1),(10,'HyperText Marker Language',10,1),(11,'HyperText Markup Language',11,1),(35,'It\'s the name of a file',1,2),(36,'It\'s a type of document',2,2),(37,'It\'s an HTML element for text context similar to <code>&lt;p&gt;</code>',3,2),(38,'It\'s an element at the end of an HTML file',4,2),(39,'It defines the title in an HTML file',5,2),(40,'It can be used to define the styling',6,2),(41,'It renders the HTML code by type',7,2),(42,'It defines the type of metadata that follows',8,2),(43,'It encloses the whole html code in enclosing tags',9,2),(44,'It encloses the whole document and defines the HTML version of the document',10,2),(45,'It defines the document type and HTML version at the beginning',11,2),(47,'No tags: <br><code>1. Cat, 2. Dog </code>',1,4),(48,'The list tag <br><code>&lt;list&gt;Cat, Dog&lt;/list&gt;</code>',2,4),(49,'The list tag <br><code>&lt;li&gt;Cat, Dog&lt;/li&gt;</code>',3,4),(50,'Using paragraphs <br><code>&lt;p&gt;Cat&lt;/p&gt;<br>&lt;p&gt;Dog&lt;/p&gt;</code>',4,4),(51,'Using the list tag<br><code>&lt;li val=\"Cat\"&gt;<br>&lt;li val=\"Dog\"&gt;</code>',5,4),(52,'The ul tag <br><code>&lt;ul&gt;Cat&lt;/ul&gt; <br>&lt;ul&gt;Dog&lt;/ul&gt;</code>',6,4),(53,'The ol and li tags <br><code>&lt;ol&gt;<br>&lt;li&gt;Cat, Dog&lt;/li&gt;<br>&lt;/ol&gt;</code>',7,4),(54,'The ul and li tags <br><code>&lt;ul&gt;<br>&lt;li&gt;Cat&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;ul&gt;<br>&lt;li&gt;Dog&lt;/li&gt;<br>&lt;/ul&gt;</code>',8,4),(55,'The ul and li tags <br><code>&lt;ul&gt;<br>&lt;li&gt;Cat&lt;/li&gt;<br>&lt;li&gt;Dog&lt;/li&gt;<br>&lt;/ul&gt;</code>',9,4),(56,'The ol and li tags <br><code>&lt;ol&gt;<br>&lt;li&gt;Cat&lt;li&gt;Dog<br>&lt;/ol&gt;</code>',10,4),(57,'The ol and li tags <br><code>&lt;ol&gt;<br>&lt;li&gt;Cat&lt;/li&gt;<br>&lt;li&gt;Dog&lt;/li&gt;<br>&lt;/ol&gt;</code>',11,4),(58,'They are used for metadata at the beggining of the file and define extra data about the file.',1,5),(59,'They are used for defining menus, one for horizontal and one for vertical menus.',2,5),(60,'They are used for defining side menus, one for numbered items and one for non-numbered items.',3,5),(61,'They are used for defining lists, the difference being that ol is used with the tag li and the ul isn\'t.',4,5),(62,'They are used for representing lists, with the difference that one list is horizontal and one vertical.',5,5),(63,'They are used for representing lists, with the difference that ul was used in a previous HTML version and ul is used in HTML5.',6,5),(64,'They are used for representing lists, the difference being that ul adds numbers to items and ol doesn\'t add anything in front of the items.',7,5),(65,'They are used for representing lists, the difference being that ol adds numbers to items and ul doesn\'t add anything in front of the items.',8,5),(66,'They are used for representing lists, the difference being that ol adds bullets to items and ul doesn\'t add anything in front of the items.',9,5),(67,'They are used for representing lists, the difference being that ul adds numbers to items and ol adds bullets in front of the items.',10,5),(68,'They are used for representing lists, the difference being that ol adds numbers to items and ul adds bullets in front of the items.',11,5),(69,'They are attributes used for linking style sheets.',1,6),(70,'They are used for in-line styling.',2,6),(71,'They are used for declaring metadata. ',3,6),(72,'They are used for additional information reffering to the content of a tag.',4,6),(73,'They are attributes used for specifying page content.',5,6),(74,'They are used by the browser for identification and specifying page content.',6,6),(75,'They are elements used for defining style instructions in styling sheets.',7,6),(76,'They are attributes used for selecting text content elements in stylesheets.',8,6),(77,'Both are attributes used for selecting elements in external stylesheets and for uniquely selecting elements in scripts.',9,6),(78,'They are elements used for selecting particular tags in stylesheets and scripts.',10,6),(79,'They are attributes used for selecting elements in stylesheets and scripts.',11,6),(80,'It can be used with any element and it specifies the parent element.',1,7),(81,'It can be used inside div elements, to define inline styling.',2,7),(82,'It can be used only with metadata elements, to specify linked files.',3,7),(83,'It can be used with metadata elements, to specify linked files and scripts.',4,7),(84,'It can be used with img, link and anchor (a) elements and specifies the target file.',5,7),(85,'It can be used with img, anchor (a) and input elements and specifies the source file.',6,7),(86,'It can be used with img, video, input and anchor elements and its purpose is to link an external file.',7,7),(87,'It can be used with img, audio, video, input and link elements and its purpose is to specify a source file.',8,7),(88,'It can be used with img, audio, video, input and link elements and its purpose is to load a specified source file.',9,7),(89,'It can be used with img, audio, video, input and source elements and its purpose is to link to a file without loading it.',10,7),(90,'It can be used with img, audio, video, input and source elements and its purpose is to load a specified source file.',11,7),(91,'There is no difference, they can be used interchangeably.',1,8),(92,'An id is autogenerated while class is not.',2,8),(93,'A class is user defined and an id is set by the browser.',3,8),(94,'Class is a stronger selector in general because it\'s user defined.',4,8),(95,'An element is allowed to have multiple ids.',5,8),(96,'A class attribute is unique in a page and for an element.',6,8),(97,'A class attribute is unique in an html page but a single element can have multiple classes.',7,8),(98,'An element can have multiple classes and at least one id.',8,8),(99,'An element can have multiple classes and ids, but ids are unique per page.',9,8),(100,'An element can have one or more classes that are unique per page and only one unique id.',10,8),(101,'An element can have multiple classes that can be reused, but only one id that is unique per page.',11,8),(102,'It can be used with any element and it specifies the parent element.',1,9),(103,'It can be used inside div elements, to define inline styling.',2,9),(104,'It can be used only with metadata elements, to specify linked files.',3,9),(105,'It can be used with metadata elements, to specify linked files and scripts.',4,9),(106,'It can be used with img, link and anchor (a) elements and specifies the target file.',5,9),(107,'It can be used with img, anchor (a) as a hyperlink and input elements and specifies the source file.',6,9),(108,'It can be used with anchor elements and img and its purpose is to link an external file.',7,9),(109,'It can be used with anchor elements and link and its purpose is to link a script to the page.',8,9),(110,'It can be used with anchor elements as a hyperlink and link tag and its purpose is to load a specified source file.',9,9),(111,'It can be used with anchor elements as a hyperlink and link tag and its purpose is to load a file or page.',10,9),(112,'It can be used with anchor elements as a hyperlink and link tag and its purpose is to link or reference a file or page.',11,9),(114,'<code>&#x3C;href src=&#x22;some_image.jpg&#x22; alt=&#x22;https://www.some-domain.com/&#x22;/&#x3E;</code>',1,10),(115,'<code>&#x3C;link src=&#x22;some_image.jpg&#x22; alt=&#x22;https://www.some-domain.com/&#x22;/&#x3E;</code>',2,10),(116,'<code>&#x3C;link href=&#x22;some_image.jpg&#x22; alt=&#x22;https://www.some-domain.com/&#x22;&#x3E;&#x3C;/link&#x3E;</code>',3,10),(117,'<code>&#x3C;a href=&#x22;https://www.some-domain.com/&#x22; img=&#x22;some_image.jpg&#x22;&#x3E;</code>',4,10),(118,'<code>&#x3C;img href=&#x22;https://www.some-domain.com/&#x22; src=&#x22;some_image.jpg&#x22;&#x3E;</code>',5,10),(119,'<code>&#x3C;img src=&#x22;some_image.jpg&#x22;&#x3E;<br>&#x3C;a src=&#x22;https://www.some-domain.com/&#x22;&#x3E;<br>&#x3C;/a&#x3E;</code>',6,10),(120,'<code>&#x3C;a src=&#x22;https://www.some-domain.com/&#x22;&#x3E;<br>&#x3C;img href=&#x22;some_image.jpg&#x22;&#x3E;<br>&#x3C;/a&#x3E;</code>',7,10),(121,'<code>&#x3C;a href=&#x22;https://www.some-domain.com/&#x22;&#x3E;<br>&#x3C;img href=&#x22;some_image.jpg&#x22; alt=&#x22;My image&#x22;&#x3E;<br>&#x3C;/a&#x3E;</code>',8,10),(122,'<code>&#x3C;a href=&#x22;https://www.some-domain.com/&#x22;&#x3E;<br>&#x3C;img target=&#x22;some_image.jpg&#x22; alt=&#x22;My image&#x22;&#x3E;<br>&#x3C;/a&#x3E;</code>',9,10),(123,'<code>&#x3C;a href=&#x22;https://www.some-domain.com/&#x22;&#x3E;<br>&#x3C;img src=&#x22;some_image.jpg&#x22; target=&#x22;My image&#x22;&#x3E;<br>&#x3C;/a&#x3E;</code>',10,10),(124,'<code>&#x3C;a href=&#x22;https://www.some-domain.com/&#x22;&#x3E;<br>&#x3C;img src=&#x22;some_image.jpg&#x22; alt=&#x22;My image&#x22;&#x3E;<br>&#x3C;/a&#x3E;</code>',11,10),(126,'type, value, name, action, text, readonly, hyperlink',1,11),(127,'name, radio, action, text, readonly, type, required',2,11),(128,'name, hyperlink, radio, action, text, type, number, calendar',3,11),(129,'radio, checkbox, action, pattern, text, button, hyperlink',4,11),(130,'radio, action, select, text, button, number, calendar, pattern',5,11),(131,'select, radio, checkbox, password, string, multiple, calendar, button',6,11),(132,'radio, checkbox, select, password, string, submit, calendar',7,11),(133,'button, radio, checkbox, select, password, textarea, submit, date',8,11),(134,'submit, radio, checkbox, select, password, text, number, calendar, reset',9,11),(135,'button, radio, checkbox, select, password, text, date-time, submit, reset',10,11),(136,'button, radio, checkbox, select, password, text, submit, date, reset',11,11),(137,'text, value, name, action, button',1,12),(138,'text, radio-button, checkbox, action, select',2,12),(139,'input, radio, checkbox, form, submit',3,12),(140,'radio, checkbox, text, button, submit',4,12),(141,'input, select, checkbox, button, number, submit',5,12),(142,'select, input, submit, text-area, button',6,12),(143,'input, select, option, submit, text-area, button',7,12),(144,'button, select, textarea, option, submit, input',8,12),(145,'select, input, option, button, text-area',9,12),(146,'select, input, option, submit, textarea, button',10,12),(147,'select, input, option, textarea, button',11,12),(148,'For aesthetic purposes and it\'s implemented in the following way: <br><code>&#x3C;radio value=&#x22;Choice 1&#x22;&#x3E;&#x3C;/radio&#x3E;<br>&#x3C;radio value=&#x22;Choice 2&#x22;&#x3E;&#x3C;/radio&#x3E;<br>&#x3C;radio value=&#x22;Choice 3&#x22;&#x3E;&#x3C;/radio&#x3E;</code>',1,13),(149,'Because checkboxes can\'t be used with multiple choices and it\'s implemented in the following way: <br><code>&#x3C;radio id=&#x22;ch1&#x22;&#x3E;Choice 1&#x3C;/radio&#x3E;<br>&#x3C;radio id=&#x22;ch2&#x22;&#x3E;Choice 2&#x3C;/radio&#x3E;<br>&#x3C;radio id=&#x22;ch3&#x22;&#x3E;Choice 3&#x3C;/radio&#x3E;</code>',2,13),(150,'Because radio buttons can only be used in groups and it\'s implemented in the following way: <br><code>&#x3C;input type=&#x22;text&#x22; name=&#x22;radio&#x22;&#x3E;Choice 1&#x3C;/input&#x3E;<br>&#x3C;input type=&#x22;text&#x22; name=&#x22;radio&#x22;&#x3E;Choice 2&#x3C;/input&#x3E;<br>&#x3C;input type=&#x22;text&#x22; name=&#x22;radio&#x22;&#x3E;Choice 3&#x3C;/input&#x3E;</code>',3,13),(151,'Checkboxes cannot be used for questions with choices and it\'s implemented in the following way: <br><code>&#x3C;input type=&#x22;text&#x22; class=&#x22;radio&#x22;&#x3E;Choice 1&#x3C;/input&#x3E;<br>&#x3C;input type=&#x22;text&#x22; class=&#x22;radio&#x22;&#x3E;Choice 2&#x3C;/input&#x3E;<br>&#x3C;input type=&#x22;text&#x22; class=&#x22;radio&#x22;&#x3E;Choice 3&#x3C;/input&#x3E;</code>',4,13),(152,'Because checkboxes are used for mutually exclusive choices and it\'s implemented in the following way: <br><code>&#x3C;input type=&#x22;radio&#x22; value=&#x22;Choice 1&#x22;&#x3E;<br>&#x3C;input type=&#x22;radio&#x22; value=&#x22;Choice 2&#x22;&#x3E;<br>&#x3C;input type=&#x22;radio&#x22; value=&#x22;Choice 3&#x22;&#x3E;</code>',5,13),(153,'Because there are at least 2 choices per question and it\'s implemented in the following way: <br><code>&#x3C;input type=&#x22;radio&#x22; value=&#x22;Choice 1&#x22; name=&#x22;ch1&#x22;&#x3E;<br>&#x3C;input type=&#x22;radio&#x22; value=&#x22;Choice 2&#x22; name=&#x22;ch2&#x22;&#x3E;<br>&#x3C;input type=&#x22;radio&#x22; value=&#x22;Choice 3&#x22; name=&#x22;ch3&#x22;&#x3E;</code>',6,13),(154,'Because the user must select at least one choice and it\'s implemented in the following way: <br><code>&#x3C;input type=&#x22;radio&#x22; name=&#x22;Choice 1&#x22; id=&#x22;ch1&#x22;&#x3E;<br>&#x3C;input type=&#x22;radio&#x22; name=&#x22;Choice 2&#x22; id=&#x22;ch2&#x22;&#x3E;<br>&#x3C;input type=&#x22;radio&#x22; name=&#x22;Choice 3&#x22; id=&#x22;ch3&#x22;&#x3E;</code>',7,13),(155,'Because radio buttons are used for mutually exclusive choices and it\'s implemented in the following way: <br><code>&#x3C;input type=&#x22;radio&#x22; name=&#x22;Choice 1&#x22; value=&#x22;ch1&#x22; &#x3E;<br>&#x3C;input type=&#x22;radio&#x22; name=&#x22;Choice 2&#x22; value=&#x22;ch2&#x22;&#x3E;<br>&#x3C;input type=&#x22;radio&#x22; name=&#x22;Choice 3&#x22; value=&#x22;ch3&#x22;&#x3E;</code>',8,13),(156,'Because the user must select exactly one choice and it\'s implemented in the following way: <br><code>&#x3C;input type=&#x22;radio&#x22; name=&#x22;choice1&#x22; value=&#x22;chx&#x22;&#x3E;Choice 1<br>&#x3C;input type=&#x22;radio&#x22; name=&#x22;choice2&#x22; value=&#x22;chx&#x22;&#x3E;Choice 2<br>&#x3C;input type=&#x22;radio&#x22; name=&#x22;choice3&#x22; value=&#x22;chx&#x22;&#x3E;Choice 3</code>',9,13),(157,'Because the user must select exactly one choice and it\'s implemented in the following way: <br><code>&#x3C;input type=&#x22;radio&#x22; name=&#x22;choice&#x22; value=&#x22;1&#x22; id=&#x22;ch_q&#x22;&#x3E;Choice 1<br>&#x3C;input type=&#x22;radio&#x22; name=&#x22;choice&#x22; value=&#x22;2&#x22; id=&#x22;ch_q&#x22;&#x3E;Choice 2<br>&#x3C;input type=&#x22;radio&#x22; name=&#x22;choice&#x22; value=&#x22;3&#x22; id=&#x22;ch_q&#x22;&#x3E;Choice 3</code>',10,13),(158,'Because the user must select exactly one choice and it\'s implemented in the following way: <br><code>&#x3C;input type=&#x22;radio&#x22; name=&#x22;choice&#x22; value=&#x22;1&#x22; id=&#x22;ch_1&#x22;&#x3E;Choice 1<br>&#x3C;input type=&#x22;radio&#x22; name=&#x22;choice&#x22; value=&#x22;2&#x22; id=&#x22;ch_2&#x22;&#x3E;Choice 2<br>&#x3C;input type=&#x22;radio&#x22; name=&#x22;choice&#x22; value=&#x22;3&#x22; id=&#x22;ch_3&#x22;&#x3E;Choice 3</code>',11,13),(160,'br, footer, select, div, button',1,14),(161,'br, footer, input, radio, article, table',2,14),(162,'footer, select, head, button, input, table',3,14),(163,'br, footer, head, article, select, figure',4,14),(164,'article, footer, select, strong, pre, figure',5,14),(165,'article, footer, pre, table, head, figure',6,14),(166,'footer, article, head, nav, table, aside',7,14),(167,'article, footer, pre, audio, section, figure',8,14),(168,'article, footer, code, header, video, section, figure',9,14),(169,'article, footer, caption, header, audio, section, figure',10,14),(170,'article, footer, details, header, audio, section, figure',11,14),(171,'radio, action, select, text, button, number, calendar, pattern',1,15),(172,'radio, checkbox, date, password, tel, submit, calendar',2,15),(173,'date, radio, checkbox, select, password, textarea, submit, email',3,15),(174,'date, search, select, password, textarea, submit, email',4,15),(175,'date, search, select, password, textarea, week, email',5,15),(176,'date, search, tel, password, text, date-time, calendar, reset',6,15),(177,'date, search, tel, password, range, date-time, range, email',7,15),(178,'color, tel, search, range, date-time, calendar, email, number',8,15),(179,'date, color, tel, search, range, datetime, calendar, email',9,15),(180,'color, tel, search, range, year, week, email, number',10,15),(181,'color, tel, search, range, time, week, email, number',11,15),(182,'A server requests services from a browser client.',1,16),(183,'A server displays the results of the operations locally.',2,16),(184,'A server implements the client interface to perform more expensive tasks.',3,16),(185,'A server is the central part of the architecture, the one that a user manipulates.',4,16),(186,'A server requests activity to perform from the client.',5,16),(187,'A server requests activity to perform from the database.',6,16),(188,'A server performs an activity requested by the client or the database.',7,16),(189,'A server waits for incoming requests from the database and manages it.',8,16),(190,'A server waits for incoming requests from the client and displays the results locally.',9,16),(191,'A server waits for incoming requests from the client and serves one client at a time with the resources.',10,16),(192,'A server waits for incoming requests from the clients, manages data and serves the results or resources back to the client.',11,16),(193,'GET establishes the tunnel with the server and POST follows by adding data.',1,17),(194,'GET performs looping back in order to GET data and POST adds new data.',2,17),(195,'GET retrieves data from a database and Post replaces the old data with new data.',3,17),(196,'GET retrieves rows directly from a database and post replaces rows into a database.',4,17),(197,'GET retrieves rows directly from a database and post inserts rows into a database.',5,17),(198,'GET transfers only the status line and header section while post sends all information to a database.',6,17),(199,'GET retrieves information from a server and updates it while post only updates the information.',7,17),(200,'GET retrievs information from a server using given request body parameters and post uses the URI to save data.',8,17),(201,'GET retrieves information from a server by adding variables to the URL and post sends data through means of header variables.',9,17),(202,'GET retrieves information from a server using body parameters and post sends data through URL variables.',10,17),(203,'GET retrieves information from a server using URL variables and post sends data using body parameters.',11,17),(204,'CONNECTION, OPTION, DELETE, POST, HEADER',1,18),(205,'HEADER, GET, POST, RELOAD, DELETE, PUT',2,18),(206,'OPTION, GET, POST, RELOAD, PUT, HEAD',3,18),(207,'CONNECTION, GET, POST, PUT, OPTION, HEAD',4,18),(208,'DELETE, PUT, POST, OPTION, TRACK, CONNECT, GET.',5,18),(209,'PUT, POST, GET, CONNECT,  DELETE, TRACE, HEADER',6,18),(210,'PUT, POST, GET, CONNECT,  DELETE, OPTION, HEADER',7,18),(211,'PUT, POST, GET, CONNECTION, DELETE, OPTIONS, HEADER',8,18),(212,'PUT, POST, GET, CONNECT, DELETE, TRACK, OPTION, HEAD',9,18),(213,'PUT, POST, GET, CONNECT, DELETE, TRACE, OPTION, HEAD',10,18),(214,'PUT, POST, GET, CONNECT, DELETE, TRACE, OPTIONS, HEAD',11,18),(215,'SEARCH http://store.com/home/simple/black',1,19),(216,'OPTIONS http://store.com/home/type=simple/color=black',2,19),(217,'PUT http://store.com/home/type/simple/color/black',3,19),(218,'PUT http://store.com/home <br>body = {simple, black}',4,19),(219,'POST http://store.com/home <br>body = {TYPE=simple, COLOR=black}',5,19),(220,'POST http://store.com/home/type/color <br>body = {TYPE=simple&COLOR=black}',6,19),(221,'GET http://store.com/home body = {TYPE=\'simple\', COLOR=\'black\'}',7,19),(222,'GET http://store.com/home/type=simple/color=black',8,19),(223,'GET http://store.com/home?type=simple?color=black',9,19),(224,'GET http://store.com/home/type=simple&color=black',10,19),(225,'GET http://store.com/home?type=simple&color=black',11,19),(226,'Both are equally secure because they send data in the same way.',1,20),(227,'GET is more secure because it doesn\'t change any data on the server.',2,20),(228,'POST is considered more secure because the data is sent via URL and not in the body.',3,20),(229,'GET is more secure because the data is sent in the body of the request which makes it hidden.',4,20),(230,'POST is more secure because this way, the parameters are only stored in the browser history.',5,20),(231,'GET is more secure because the params are sent in URL which makes the size of the data limited and secures against injection.',6,20),(232,'POST is more secure because at pressing back button, the user will be asked for permission to resubmit the form.',7,20),(233,'POST is more secure because the parameters are only stored in the server logs.',8,20),(234,'POST is considered more secure because it also allows multipart encoding.',9,20),(235,'POST is more secure because binary data is also allowed.',10,20),(236,'POST is more secure because data is not displayed in the URL or stored on the browser.',11,20),(237,'Listens to incoming requests.',1,21),(238,'Maintains a connection to other clients',2,21),(239,'Can only request resources from one server',3,21),(240,'Can only receive and interpret HTML responses.',4,21),(241,'Can broadcast requests to other clients directly',5,21),(242,'A browser cannot be considered a client.',6,21),(243,'It can only connect to servers inside of its own geographical region',7,21),(244,'It handles heavy operations and that are run on the browser.',8,21),(245,'It can communicate with the server through HTML pages.',9,21),(246,'It displays the results that came from the server in object form.',10,21),(248,'Requests data or resources from the server.',11,21);
/*!40000 ALTER TABLE `choice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge_item`
--

DROP TABLE IF EXISTS `knowledge_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knowledge_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `lesson` int(11) NOT NULL,
  `total_theoretical_qs` int(11) DEFAULT '0',
  `total_reasoning_qs` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `lesson_fk_idx` (`lesson`),
  CONSTRAINT `FKr64vui6lq2x9jwd1tp0v6lvmr` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`),
  CONSTRAINT `lesson_fk` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge_item`
--

LOCK TABLES `knowledge_item` WRITE;
/*!40000 ALTER TABLE `knowledge_item` DISABLE KEYS */;
INSERT INTO `knowledge_item` VALUES (1,'HTML Elements',1,2,1),(2,'HTML Attributes',1,0,0),(3,'HTML Forms',1,0,0),(4,'HTML5',1,0,0),(5,'Client-server',4,0,0),(6,'HTTP methods',4,0,0);
/*!40000 ALTER TABLE `knowledge_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `content` mediumtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (1,'HTML','<p>HTML stands for Hyper Text Markup Language, which is the most widely used language on Web to develop web pages. </p></br><p>All HTML documents must start with a document type declaration: !DOCTYPE html enclosed in angle brackets. As told earlier, HTML is a markup language and makes use of various tags to format the content. These tags are enclosed within angle braces. Except few tags, most of the tags have their corresponding closing tags.</p> <br> <table class=\"table table-bordered\"><tbody><tr><th>Tag</th><th>Description</th></tr><tr><td>&lt;!DOCTYPE...&gt;</td><td>This tag defines the document type and HTML version.</td></tr><tr><td>&lt;html&gt;</td><td>This tag encloses the complete HTML document and mainly comprises of document header which is represented by <b>&lt;head&gt;...&lt;/head&gt;</b> and document body which is represented by <b>&lt;body&gt;...&lt;/body&gt;</b> tags.</td></tr><tr><td>&lt;head&gt;</td><td>This tag represents the document\'s header which can  keep other HTML tags like &lt;title&gt;, &lt;link&gt; etc.</td></tr><tr><td>&lt;title&gt;</td><td>The <b>&lt;title&gt;</b> tag is used inside the &lt;head&gt; tag  to mention the document title.</td></tr><tr><td>&lt;body&gt;</td><td>This tag represents the document\'s body which keeps other HTML tags like &lt;h1&gt;, &lt;div&gt;, &lt;p&gt; etc.</td></tr><tr><td>&lt;h1&gt;</td><td>This tag represents the heading.</td></tr><tr><td>&lt;p&gt;</td><td>This tag represents a paragraph.</td></tr></tbody></table>\n</br> <h3>Document metadata</h3> </br>\n<table class=\"standard-table\"><thead><tr><th scope=\"col\">Element</th><th scope=\"col\">Description</th></tr></thead><tbody>\n \n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/base\" title=\"The HTML <base> element specifies the base URL to use for all relative URLs contained within a document. There can be only one <base> element in a document.\"><code>&lt;base&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;base&gt;</code> element</strong> specifies the base URL to use for all relative URLs contained within a document. There can be only one <code>&lt;base&gt;</code> element in a document.</td>\n  </tr>\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/link\" title=\"The HTML <link> element specifies relationships between the current document and an external resource. Possible uses for this element include defining a relational framework for navigation. This Element is most used to link to style sheets.\"><code>&lt;link&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;link&gt;</code> element</strong> specifies relationships between the current document and an external resource. Possible uses for this element include defining a relational framework for navigation. This Element is most used to link to style sheets.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/meta\" title=\"The HTML <meta> element represents metadata that cannot be represented by other HTML meta-related elements, like <base>, <link>, <script>, <style> or <title>.\"><code>&lt;meta&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;meta&gt;</code> element</strong> represents <a href=\"/en-US/docs/Glossary/Metadata\" class=\"glossaryLink\" title=\"metadata: Metadata is — in its very simplest definition — data that describes data. For example, an HTML document is data, but HTML can also contain metadata in its <head> element that describes the document — for example who wrote it, and its summary.\">metadata</a> that cannot be represented by other HTML meta-related elements, like <a href=\"/en-US/docs/Web/HTML/Element/base\" title=\"The HTML <base> element specifies the base URL to use for all relative URLs contained within a document. There can be only one <base> element in a document.\"><code>&lt;base&gt;</code></a>, <a href=\"/en-US/docs/Web/HTML/Element/link\" title=\"The HTML <link> element specifies relationships between the current document and an external resource. Possible uses for this element include defining a relational framework for navigation. This Element is most used to link to style sheets.\"><code>&lt;link&gt;</code></a>, <a href=\"/en-US/docs/Web/HTML/Element/script\" title=\"The HTML <script> element is used to embed or reference an executable script.\"><code>&lt;script&gt;</code></a>, <a href=\"/en-US/docs/Web/HTML/Element/style\" title=\"The HTML <style> element contains style information for a document, or part of a document. By default, the style instructions written inside that element are expected to be CSS.\"><code>&lt;style&gt;</code></a> or <a href=\"/en-US/docs/Web/HTML/Element/title\" title=\"The HTML <title> element defines the title of the document, shown in a browser\'s title bar or on the page\'s tab. It can only contain text, and any contained tags are ignored.\"><code>&lt;title&gt;</code></a>.</td>\n  </tr>\n\n  <tr>\n<td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/style\" title=\"The HTML <style> element contains style information for a document, or part of a document. By default, the style instructions written inside that element are expected to be CSS.\"><code>&lt;style&gt;</code></a></td><td>The <strong>HTML <code>&lt;style&gt;</code> element</strong> contains style information for a document, or part of a document. By default, the style instructions written inside that element are expected to be <a href=\"/en-US/docs/Web/CSS\">CSS</a>.</td></tr></tbody></table>\n <h3>Content sectioning</h3></br>\n<table class=\"standard-table\">\n <thead>\n  <tr>\n\n   <th scope=\"col\">Element</th>\n   <th scope=\"col\">Description</th>\n  </tr>\n </thead>\n <tbody>\n \n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/address\" title=\"The HTML&nbsp;<address> element supplies contact information for its nearest <article> or <body> ancestor; in the latter case, it applies to the whole document.\"><code>&lt;address&gt;</code></a></td>\n   <td>The <strong>HTML&nbsp;<code>&lt;address&gt;</code> element</strong> supplies contact information for its nearest <a href=\"/en-US/docs/Web/HTML/Element/article\" title=\"The HTML <article> element represents a self-contained composition in a document, page, application, or site, which is intended to be independently distributable or reusable (e.g., in syndication). Examples include: a forum post, a magazine or newspaper article, or a blog entry.\"><code>&lt;article&gt;</code></a> or <a href=\"/en-US/docs/Web/HTML/Element/body\" title=\"The HTML <body> Element represents the content of an HTML&nbsp;document. There can be only one <body> element in a document.\"><code>&lt;body&gt;</code></a> ancestor; in the latter case, it applies to the whole document.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/article\" title=\"The HTML <article> element represents a self-contained composition in a document, page, application, or site, which is intended to be independently distributable or reusable (e.g., in syndication). Examples include: a forum post, a magazine or newspaper article, or a blog entry.\"><code>&lt;article&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;article&gt;</code> element</strong> represents a self-contained composition in a document, page, application, or site, which is intended to be independently distributable or reusable (e.g., in syndication). Examples include: a forum post, a magazine or newspaper article, or a blog entry.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/aside\" title=\"The HTML <aside> element represents a section of a document with content connected tangentially to the main content of the document (often presented as a sidebar).\"><code>&lt;aside&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;aside&gt;</code> element</strong> represents a section of a document with content connected tangentially to the main content of the document (often presented as a sidebar).</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/footer\" title=\"The HTML <footer> element represents a footer for its nearest sectioning content or sectioning root element. A footer typically contains information about the author of the section, copyright data or links to related documents.\"><code>&lt;footer&gt;</code></a></td>\n   <td>The<strong> HTML <code>&lt;footer&gt;</code> element</strong> represents a footer for its nearest <a href=\"/en-US/docs/Web/Guide/HTML/Sections_and_Outlines_of_an_HTML5_document#Defining_Sections_in_HTML5\">sectioning content</a> or <a href=\"/en-US/docs/Web/Guide/HTML/Sections_and_Outlines_of_an_HTML5_document#Sectioning_root\" title=\"Sections and Outlines of an HTML5 document#Sectioning root\">sectioning root</a> element. A footer typically contains information about the author of the section, copyright data or links to related documents.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/h1–h6\" title=\"The documentation about this has not yet been written; please consider contributing!\"><code>&lt;h1–h6&gt;</code></a></td>\n   <td></td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/header\" title=\"The HTML <header> element represents a group of introductory or navigational aids. It may contain some heading elements but also other elements like a logo, a search form, and so on.\"><code>&lt;header&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;header&gt;</code> element</strong> represents a group of introductory or navigational aids. It may contain some heading elements but also other elements like a logo, a search form, and so on.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/hgroup\" title=\"The HTML <hgroup> element represents a multi-level heading for a section of a document. It groups a set of <h1>–<h6> elements.\"><code>&lt;hgroup&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;hgroup&gt;</code> element</strong> represents a multi-level heading for a section of a document. It groups a set of <code><a href=\"/en-US/docs/Web/HTML/Element/Heading_Elements\">&lt;h1&gt;–&lt;h6&gt;</a></code> elements.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/nav\" title=\"The HTML <nav> element represents a section of a page that links to other pages or to parts within the page: a section with navigation links.\"><code>&lt;nav&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;nav&gt;</code> element</strong> represents a section of a page that links to other pages or to parts within the page: a section with navigation links.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/section\" title=\"The HTML <section> element represents a generic section of a document, i.e., a thematic grouping of content, typically with a heading.\"><code>&lt;section&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;section&gt;</code> element</strong> represents a generic section of a document, i.e., a thematic grouping of content, typically with a heading.</td>\n  </tr>\n\n </tbody>\n</table>\n <h3>Page content tags</h3></br>\n <table class=\"standard-table\">\n <thead>\n  <tr>\n\n   <th scope=\"col\">Element</th>\n   <th scope=\"col\">Description</th>\n  </tr>\n </thead>\n <tbody>\n \n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/dd\" title=\"The&nbsp;HTML <dd> element indicates the description of a term in a description list (<dl>).\"><code>&lt;dd&gt;</code></a></td>\n   <td>The&nbsp;<strong>HTML <code>&lt;dd&gt;</code> element</strong> indicates the description of a term in a description list (<a href=\"/en-US/docs/Web/HTML/Element/dl\" title=\"The HTML <dl> element encloses a list of groups of terms and descriptions. Common uses for this element are to implement a glossary or to display metadata (a list of key-value pairs).\"><code>&lt;dl&gt;</code></a>).</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/div\" title=\"The HTML <div> element is the generic container for flow content and does not inherently represent anything. Use it to group elements for purposes such as styling (using the class or id attributes), marking a section of a document in a different language (using the lang attribute), and so on.\"><code>&lt;div&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;div&gt;</code> element</strong> is the generic container for flow content and does not inherently represent anything. Use it to group elements for purposes such as styling (using the <code><a href=\"/en-US/docs/Web/HTML/Global_attributes#attr-class\">class</a></code> or <code><a href=\"/en-US/docs/Web/HTML/Global_attributes#attr-id\">id</a></code> attributes), marking a section of a document in a different language (using the <code><a href=\"/en-US/docs/Web/HTML/Global_attributes#attr-lang\">lang</a></code> attribute), and so on.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/dl\" title=\"The HTML <dl>&nbsp;element represents a description list.&nbsp;The element encloses a list of groups of terms and descriptions. Common uses for this element are to implement a glossary or to display metadata (a list of key-value pairs).\"><code>&lt;dl&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;dl&gt;</code>&nbsp;</strong>element represents a description list.<strong>&nbsp;</strong>The element encloses a list of groups of terms and descriptions. Common uses for this element are to implement a glossary or to display metadata (a list of key-value pairs).</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/dt\" title=\"The HTML <dt> element identifies a term in a description list. This element can occur only as a child element of a <dl>. It is usually followed by a <dd> element; however, multiple <dt> elements in a row indicate several terms that are all defined by the immediate next <dd> element.\"><code>&lt;dt&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;dt&gt;</code> element</strong> identifies a term in a description list. This element can occur only as a child element of a <a href=\"/en-US/docs/Web/HTML/Element/dl\" title=\"The HTML <dl> element (or HTML Description List Element) encloses a list of groups of terms and descriptions. Common uses for this element are to implement a glossary or to display metadata (a list of key-value pairs).\"><code>&lt;dl&gt;</code></a>. It is usually followed by a <a href=\"/en-US/docs/Web/HTML/Element/dd\" title=\"The&nbsp;HTML <dd> element&nbsp;(or&nbsp;HTML Description Element) indicates the description of a term in a description list (<dl>).\"><code>&lt;dd&gt;</code></a> element; however, multiple <code>&lt;dt&gt;</code> elements in a row indicate several terms that are all defined by the immediate next <a href=\"/en-US/docs/Web/HTML/Element/dd\" title=\"The&nbsp;HTML <dd> element&nbsp;(or&nbsp;HTML Description Element) indicates the description of a term in a description list (<dl>).\"><code>&lt;dd&gt;</code></a> element.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/figcaption\" title=\"The HTML <figcaption> element represents a caption or a legend associated with a figure or an illustration described by the rest of the data of the <figure> element which is its immediate ancestor.\"><code>&lt;figcaption&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;figcaption&gt;</code> element</strong> represents a caption or a legend associated with a figure or an illustration described by the rest of the data of the <a href=\"/en-US/docs/Web/HTML/Element/figure\" title=\"The HTML <figure> element represents self-contained content, frequently with a caption&nbsp;(<figcaption>), and is&nbsp;typically referenced as a single unit. While it is related to the main flow, its position is independent of the main flow. Usually this is an image, an illustration, a diagram, a code snippet, or a schema that is referenced in the main text, but that can be moved to another page or to an appendix without affecting the main flow.\"><code>&lt;figure&gt;</code></a> element which is its immediate ancestor.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/figure\" title=\"The HTML <figure> element represents self-contained content, frequently with a caption&nbsp;(<figcaption>), and is&nbsp;typically referenced as a single unit.\"><code>&lt;figure&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;figure&gt;</code> element</strong> represents self-contained content, frequently with a caption&nbsp;(<a href=\"/en-US/docs/Web/HTML/Element/figcaption\" title=\"The HTML <figcaption> element represents a caption or a legend associated with a figure or an illustration described by the rest of the data of the <figure> element which is its immediate ancestor.\"><code>&lt;figcaption&gt;</code></a>)<em><code>,</code></em> and is&nbsp;typically referenced as a single unit.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/hr\" title=\"The HTML <hr> element represents a thematic break between paragraph-level elements (for example, a change of scene in a story, or a shift of topic with a section). In previous versions of HTML, it represented a horizontal rule. It may still be displayed as a horizontal rule in visual browsers, but is now defined in semantic terms, rather than presentational terms.\"><code>&lt;hr&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;hr&gt;</code> element</strong> represents a thematic break between paragraph-level elements (for example, a change of scene in a story, or a shift of topic with a section). In previous versions of HTML, it represented a horizontal rule. It may still be displayed as a horizontal rule in visual browsers, but is now defined in semantic terms, rather than presentational terms.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/li\" title=\"The HTML <li> element is used to represent an item in a list. It must be contained in a parent element: an ordered list (<ol>), an unordered list (<ul>), or a menu (<menu>). In menus and unordered lists, list items are usually displayed using bullet points. In ordered lists, they are usually displayed with an ascending counter on the left, such as a number or letter.\"><code>&lt;li&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;li&gt;</code> element</strong> is used to represent an item in a list. It must be contained in a parent element: an ordered list (<a href=\"/en-US/docs/Web/HTML/Element/ol\" title=\"The HTML <ol> Element (or HTML Ordered List Element) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property.\"><code>&lt;ol&gt;</code></a>), an unordered list (<a href=\"/en-US/docs/Web/HTML/Element/ul\" title=\"The HTML <ul> element represents an unordered list of items, namely a collection of items that do not have a numerical ordering, and their order in the list is meaningless. Typically, unordered-list items are displayed with a bullet, which can be of several forms, like a dot, a circle or a squared. The bullet style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property.\"><code>&lt;ul&gt;</code></a>), or a menu (<a href=\"/en-US/docs/Web/HTML/Element/menu\" title=\"The HTML <menu> element represents a group of commands that a user can perform or activate. This includes both list menus, which might appear across the top of a screen, as well as context menus, such as those that might appear underneath a button after it has been clicked.\"><code>&lt;menu&gt;</code></a>). In menus and unordered lists, list items are usually displayed using bullet points. In ordered lists, they are usually displayed with an ascending counter on the left, such as a number or letter.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/main\" title=\"The HTML <main> element represents the main content of&nbsp; the <body> of a document or application. The main content area consists of content that is directly related to, or expands upon the central topic of a document or the central functionality of an application.\"><code>&lt;main&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;main&gt;</code> element</strong> represents the main content of&nbsp; the <a href=\"/en-US/docs/Web/HTML/Element/body\" title=\"The HTML <body> Element represents the content of an HTML&nbsp;document. There can be only one <body> element in a document.\"><code>&lt;body&gt;</code></a> of a document or application. The main content area consists of content that is directly related to, or expands upon the central topic of a document or the central functionality of an application.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/ol\" title=\"The HTML <ol> element represents an ordered list of items, typically rendered as a numbered list.\"><code>&lt;ol&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;ol&gt;</code> element</strong> represents an ordered list of items, typically rendered as a numbered list.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/p\" title=\"The HTML <p> element represents a paragraph of text.\"><code>&lt;p&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;p&gt;</code> element</strong> represents a paragraph of text.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/pre\" title=\"The HTML <pre> element represents preformatted text. Text within this element is typically displayed in a non-proportional (&quot;monospace&quot;) font exactly as it is laid out in the file. Whitespace inside this element is displayed as typed.\"><code>&lt;pre&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;pre&gt;</code> element</strong> represents preformatted text. Text within this element is typically displayed in a non-proportional (\"<a href=\"/en-US/docs/XUL/Style/monospace\">monospace</a>\") font exactly as it is laid out in the file. Whitespace inside this element is displayed as typed.</td>\n  </tr>\n\n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/ul\" title=\"The HTML <ul> element represents an unordered list of items, typically rendered as a bulleted list.\"><code>&lt;ul&gt;</code></a></td>\n   <td>The<strong> HTML <code>&lt;ul&gt;</code> element</strong> represents an unordered list of items, typically rendered as a bulleted list.</td>\n  </tr>\n  \n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/small\" title=\"The HTML <small> element makes the text font size one size smaller (for example, from large to medium, or from small to x-small) down to the browser\'s minimum font size.&nbsp; In HTML5, this element is repurposed to represent side-comments and small print, including copyright and legal text, independent of its styled presentation.\"><code>&lt;small&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;small&gt;</code></strong> <strong>element </strong>makes the text <em>font size</em> one size smaller (for example, from large to medium, or from small to x-small) down to the browser\'s minimum font size.&nbsp; In HTML5, this element is repurposed to represent side-comments and small print, including copyright and legal text, independent of its styled presentation.</td>\n  </tr>\n  \n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/strong\" title=\"The HTML <strong> element gives text strong importance, and is typically displayed in bold.\"><code>&lt;strong&gt;</code></a></td>\n   <td>The <strong>HTML </strong><code><strong>&lt;strong&gt;</strong></code><strong> element</strong> gives text strong importance, and is typically displayed in bold.</td>\n  </tr>\n  \n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/em\" title=\"The HTML <em> element&nbsp;marks text that has stress emphasis. The <em> element can be nested, with each level of nesting indicating a greater degree of emphasis.\"><code>&lt;em&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;em&gt;</code> element</strong>&nbsp;marks text that has stress emphasis. The <code>&lt;em&gt;</code> element can be nested, with each level of nesting indicating a greater degree of emphasis.</td>\n  </tr>\n  \n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/i\" title=\"The HTML <i> element represents a range of text that is set off from the normal text for some reason, for example, technical terms, foreign language phrases, or fictional character thoughts. It is typically displayed in italic type.\"><code>&lt;i&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;i&gt;</code> element</strong> represents a range of text that is set off from the normal text for some reason, for example, technical terms, foreign language phrases, or fictional character thoughts. It is typically displayed in italic type.</td>\n  </tr>\n  \n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/a\" title=\"The HTML <a> element (or anchor element) creates a hyperlink to other web pages, files, locations within the same page, email addresses, or any other URL.\"><code>&lt;a&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;a&gt;</code> element</strong> (or <em>anchor</em> element) creates a hyperlink to other web pages, files, locations within the same page, email addresses, or any other URL.</td>\n  </tr>\n  \n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/img\" title=\"The HTML <img> element represents an image in the document.\"><code>&lt;img&gt;</code></a></td>\n   <td>The <strong>HTML <code>&lt;img&gt;</code> element</strong> represents an image in the document.</td>\n  </tr>\n  \n  <tr>\n\n   <td style=\"vertical-align: top;\"><a href=\"/en-US/docs/Web/HTML/Element/video\" title=\"Use the HTML <video> element to embed video content in a document.\"><code>&lt;video&gt;</code></a></td>\n   <td>Use the <strong>HTML <code>&lt;video&gt;</code> element</strong> to embed video content in a document.</td>\n  </tr>\n\n </tbody>\n</table>\n\n</br><h2>HTML Attributes</h2>\n\n<ul>\n  <li>All HTML elements can have <b>attributes</b></li>\n  <li>Attributes provide <b>additional information</b> about an element</li>\n  <li>Attributes are always specified in <b>the start tag</b></li>\n  <li>Attributes usually come in name/value pairs like: <b>name=\"value\"</b></li>\n</ul>\n<table class=\"table table-bordered\">\n<tbody><tr><th><b>Attribute</b></th><th><b>Options</b></th><th><b>Function</b></th></tr>\n<tr><td>align</td><td>right, left, center</td><td>Horizontally aligns tags</td></tr>\n<tr><td>valign</td><td>top, middle, bottom</td><td>Vertically aligns tags within an HTML element.</td></tr>\n<tr><td>bgcolor</td><td>numeric, hexidecimal, RGB values</td><td>Places a background color behind an element</td></tr>\n<tr><td>background</td><td>URL</td><td>Places a background image behind an element</td></tr>\n<tr><td>id</td><td>User Defined</td><td>Names an element for use with Cascading Style Sheets.</td></tr>\n<tr><td>class</td><td>User Defined</td><td>Classifies an element for use with Cascading Style Sheets.</td></tr>\n<tr><td>width</td><td>Numeric Value</td><td>Specifies the width of tables, images, or table cells.</td></tr>\n<tr><td>height</td><td>Numeric Value</td><td>Specifies the height of tables, images, or table cells.</td></tr>\n<tr><td>title</td><td>User Defined</td><td>\"Pop-up\" title of the elements.</td></tr>\n</tbody></table>\n \n\n'),(2,'CSS','CSS stands for Cascading Style Sheets..'),(3,'Javascript','JavaScript is a lightweight, interpreted programming language. It is designed for creating network-centric applications. It is complimentary to and integrated with Java. JavaScript is very easy to implement because it is integrated with HTML. It is open and cross-platform.'),(4,'Web Sites','<p><strong>Client-server</strong> architecture, architecture of a computer network in which many clients (remote processors) request and receive service from a centralized server (host computer).</p><br><p><strong>Client</strong> computers provide an interface to allow a computer user to request services of the server and to display the results the server returns.</p><br><p><strong>Servers</strong> wait for requests to arrive from clients and then respond to them. Ideally, a server provides a standardized transparent interface to clients so that clients need not be aware of the specifics of the system (i.e., the hardware and software) that is providing the service.</p><br><p>Clients are often situated at workstations or on personal computers, while servers are located elsewhere on the network, usually on more powerful machines. This computing model is especially effective when clients and the server each have distinct tasks that they routinely perform.</p><br><p>In hospital data processing, for example, a client computer can be running an application program for entering patient information while the server computer is running another program that manages the database in which the information is permanently stored. Many clients can access the server’s information simultaneously, and, at the same time, a client computer can perform other tasks, such as sending e-mail.</p><br><p>A <strong>web server</strong> is a computer system that processes requests via HTTP, the basic network protocol used to distribute information on the World Wide Web. The term can refer to the entire system, or specifically to the software that accepts and supervises the HTTP requests</p><br><br><h3>HTTP methods</h3><br><table class=\"table table-bordered\"><tbody><tr><th>S.N.</th><th>Method and Description</th></tr><tr><td>1</td><td><b>GET</b><p>The GET method is used to retrieve  information from the given server using a given URI.  Requests using GET should only retrieve data and should have no other effect on the data.</p></td></tr><tr><td>2</td><td><b>HEAD</b><p>Same as GET, but it transfers the status line and the header section only.</p></td></tr><tr><td>3</td><td><b>POST</b><p>A POST request is used to send data to the server, for example, customer information, file upload, etc. using HTML forms.</p></td></tr><tr><td>4</td><td><b>PUT</b><p>Replaces all the current representations of the target resource with the uploaded content.</p></td></tr><tr><td>5</td><td><b>DELETE</b><p>Removes all the current representations of the target resource given by URI.</p></td></tr><tr><td>6</td><td><b>CONNECT</b><p>Establishes a tunnel to the server identified by a given URI.</p></td></tr><tr><td>7</td><td><b>OPTIONS</b><p>Describe the communication options for the target resource.</p></td></tr><tr><td>8</td><td><b>TRACE</b><p>Performs a message loop back test along with the path to the target resource.</p></td></tr></tbody></table>');
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson_connection`
--

DROP TABLE IF EXISTS `lesson_connection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson_connection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson1` int(11) NOT NULL,
  `lesson2` int(11) NOT NULL,
  `connection_value` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `lesson1_fk_idx` (`lesson1`),
  KEY `lesson2_fk_idx` (`lesson2`),
  CONSTRAINT `FKatlrhgb5qxkr67lsjdo84x60g` FOREIGN KEY (`lesson1`) REFERENCES `lesson` (`id`),
  CONSTRAINT `FKoo4g36f0n6eljfklfia9lltd7` FOREIGN KEY (`lesson2`) REFERENCES `lesson` (`id`),
  CONSTRAINT `lesson1_fk` FOREIGN KEY (`lesson1`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `lesson2_fk` FOREIGN KEY (`lesson2`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson_connection`
--

LOCK TABLES `lesson_connection` WRITE;
/*!40000 ALTER TABLE `lesson_connection` DISABLE KEYS */;
/*!40000 ALTER TABLE `lesson_connection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_text` varchar(400) NOT NULL,
  `lesson` int(11) DEFAULT NULL,
  `knowledge_item` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `lesson_fk_idx` (`lesson`),
  KEY `ki_q_fk_idx` (`knowledge_item`),
  CONSTRAINT `FKdp8j55qr7gnhmc06e85v5rtyt` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`),
  CONSTRAINT `FKln9bgcejjfk2y29n2xn9stoqh` FOREIGN KEY (`knowledge_item`) REFERENCES `knowledge_item` (`id`),
  CONSTRAINT `ki_q_fk` FOREIGN KEY (`knowledge_item`) REFERENCES `knowledge_item` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `lesson_q_fk` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'What does HTML stand for?',1,1,0),(2,'What does DOCTYPE do?',1,1,0),(4,'What and how should you use to construct the following structure in your page that has elements of the form: <p>1. Cat</p><p>2. Dog</p>',1,1,1),(5,'What is the purpose of the <code>&lt;ul&gt;</code> and <code>&lt;ol&gt;</code> tags, and how do they differ?',1,1,0),(6,'What is the purpose of adding a \"class\" or an \"id\"?',1,2,0),(7,'How is the attribute src used and what is its purpose?',1,2,0),(8,'What is the difference between classes and ids?',1,2,0),(9,'How is the attribute href used and what is its purpose?',1,2,0),(10,'How can you implement an image hyperlink (an image that references something)?',1,2,1),(11,'The following are all valid input types:',1,3,0),(12,'The following are all valid form elements:',1,3,0),(13,'This question is a form. Why is it implemented using radio buttons and not checkboxes and how are they implemented? ',1,3,1),(14,'The following are all new elements in HTML5:',1,4,0),(15,'The following are all new input types in HTML5: ',1,4,0),(16,'What is the purpose of a server in a client-server architecture?',4,5,0),(17,'What is the main difference between the GET request and POST request?',4,6,0),(18,'Which of the following are all correct HTTP methods?',4,6,0),(19,'The home page of a webstore selling t-shirts has 2 search inputs: one for the type of the t-shirt and one for the color. How would a sample request look like for searching?',4,6,1),(20,'Which of the following is true about GET vs POST methods as a more secure option?',4,6,1),(21,'What is true about a client in a Client-Server architecture?',4,5,0);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_activity`
--

DROP TABLE IF EXISTS `question_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `question` int(11) NOT NULL,
  `knowledge_item` int(11) DEFAULT NULL,
  `lesson` int(11) DEFAULT NULL,
  `difficulty` double DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `user_fk_aqct_idx` (`user`),
  KEY `question_fk_aqct_idx` (`question`),
  KEY `lesson_fk_aqct_idx` (`lesson`),
  KEY `FKtffgw3i73ngrt2mllx5b0y3d4` (`knowledge_item`),
  CONSTRAINT `FKcxc7xmc117bnw4yxl0v26r2vf` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKg5c74ldjtuuj7oqsumktla3jr` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`),
  CONSTRAINT `FKss9tkt9i9jyqitg47mmekp9hd` FOREIGN KEY (`question`) REFERENCES `question` (`id`),
  CONSTRAINT `FKtffgw3i73ngrt2mllx5b0y3d4` FOREIGN KEY (`knowledge_item`) REFERENCES `knowledge_item` (`id`),
  CONSTRAINT `lesson_fk_aqct` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `question_fk_aqct` FOREIGN KEY (`question`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_fk_aqct` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=362 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_activity`
--

LOCK TABLES `question_activity` WRITE;
/*!40000 ALTER TABLE `question_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `question_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_tag`
--

DROP TABLE IF EXISTS `question_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` int(11) DEFAULT NULL,
  `word_tag` int(11) DEFAULT NULL,
  `rank` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `question_fk_idx` (`question`),
  KEY `word_fk_idx` (`word_tag`),
  CONSTRAINT `FK3ccgcwdnvrufou1sfpya05ob` FOREIGN KEY (`word_tag`) REFERENCES `word_tag` (`id`),
  CONSTRAINT `FKt7wwx9h5y275neva0bbohsld2` FOREIGN KEY (`question`) REFERENCES `question` (`id`),
  CONSTRAINT `questiontag_fk` FOREIGN KEY (`question`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `word_fk` FOREIGN KEY (`word_tag`) REFERENCES `word_tag` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_tag`
--

LOCK TABLES `question_tag` WRITE;
/*!40000 ALTER TABLE `question_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `question_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_name` varchar(100) DEFAULT NULL,
  `name` varchar(400) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,'T1',''),(2,'T2','');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(300) NOT NULL,
  `xp` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `theory_score` double DEFAULT NULL,
  `reasoning_score` double DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'jon@got.com','watcherjon','11',0,1,2.5,2.5,0),(2,'s@got.com','cc','11',0,0,0,0,0),(3,'cc@gm.com','jon','$2a$10$MdawIyvUlZGKI7bgz3ifQe3/3Fv/wzJjE.DzPzwvR8F4g076238Nu',0,0,0,0,0),(4,'jon@gmail.com','jony','$2a$10$spYOXB3DDDjVKG9l9Js58ewStt8z79u5r8AHU3iwtvW2ccwu3i4Fq',0,0,0,0,0),(5,'j@got.com','user','qcwIlsoVGUmLixAHpZW8rQ3EqMYqrr7RifR9sRrl6SlNTv6xn6/P/bt7Vlg5TNaJ',30,1,0,0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_knowledge`
--

DROP TABLE IF EXISTS `user_knowledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_knowledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `knowledge_item` int(11) NOT NULL,
  `score` double DEFAULT NULL,
  `theoretical_qs_answered` int(11) DEFAULT NULL,
  `reasoning_qs_answered` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `user_k_fk_idx` (`user`),
  KEY `ki_fk_idx` (`knowledge_item`),
  CONSTRAINT `FK5skbtoi530l0c5lolxk63sfj2` FOREIGN KEY (`knowledge_item`) REFERENCES `knowledge_item` (`id`),
  CONSTRAINT `FKi35vujnpcrpjdtvrma1wl9b7f` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `ki_fk` FOREIGN KEY (`knowledge_item`) REFERENCES `knowledge_item` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_k_fk` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_knowledge`
--

LOCK TABLES `user_knowledge` WRITE;
/*!40000 ALTER TABLE `user_knowledge` DISABLE KEYS */;
INSERT INTO `user_knowledge` VALUES (1,1,1,2.5,15,0),(2,1,2,2.4,0,0),(3,1,3,2.5,2,2),(11,5,1,1.8999999999999997,6,0);
/*!40000 ALTER TABLE `user_knowledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `word_tag`
--

DROP TABLE IF EXISTS `word_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `word_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(100) NOT NULL,
  `frequency` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `word_tag`
--

LOCK TABLES `word_tag` WRITE;
/*!40000 ALTER TABLE `word_tag` DISABLE KEYS */;
INSERT INTO `word_tag` VALUES (1,'carbon',0.3),(2,'bond',0.5),(3,'hydrogen',0.1),(4,'deduction',0.5),(5,'methane',0.3),(6,'ethane',0.4),(7,'theory',0.5);
/*!40000 ALTER TABLE `word_tag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-18  0:26:23
