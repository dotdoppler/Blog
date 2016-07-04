/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50708
Source Host           : 127.0.0.1:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50708
File Encoding         : 65001

Date: 2016-07-04 21:58:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hashtag
-- ----------------------------
DROP TABLE IF EXISTS `hashtag`;
CREATE TABLE `hashtag` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `createdAt` varchar(255) DEFAULT NULL,
  `updatedAt` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `hashtag_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hashtag
-- ----------------------------
INSERT INTO `hashtag` VALUES ('1', '万青', '2016-07-03 20:10:18', '2016-07-03 20:10:33');
INSERT INTO `hashtag` VALUES ('2', 'Song', '2016-07-04 10:09:55', '2016-07-04 10:10:01');
INSERT INTO `hashtag` VALUES ('3', 'Silicon Valley', '2016-07-04 11:10:17', '2016-07-04 11:10:22');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` bigint(20) NOT NULL,
  `createdAt` varchar(255) DEFAULT NULL,
  `updatedAt` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `link` varchar(255) NOT NULL,
  `content` longtext,
  `renderedContent` longtext,
  `postStatus` varchar(255) NOT NULL,
  `postFormat` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '2016-07-03 14:16:06', '2016-07-03 14:16:09', '大石碎胸口', 'big-stone-crash-chest', null, null, 'PUBLISHED', 'MARKDOWN');
INSERT INTO `post` VALUES ('2', '2016-07-03 14:19:11', null, '十万嬉皮', '10000Hippies', null, null, 'PUBLISHED', 'MARKDOWN');
INSERT INTO `post` VALUES ('3', '2016-07-03 17:48:00', null, 'rootless tree', 'rootless-tree', null, 'What I want from you is empty your head\r\n我希望你不要东想西想\r\nThey say be true, don\'t stay in your bed\r\n人们说要现实点 不要再留在你的床上\r\nWe do what we need to be free\r\n我们自由地做着爱做的事\r\nAnd it leans on me like a rootless tree\r\n但我被迫面对事实 就像无根的树\r\nWhat I want from us is empty our minds\r\n我希望我们不要东想西想\r\nWe fake the thoughts, and fracture the times\r\n我们伪装了思想 断开了境遇\r\nWe go blind when we\'ve needed to see\r\n需要用眼时我们变得盲目\r\nAnd this leans on me, like a rootless...\r\n但我被迫面对事实 就像无根的树\r\nAnd all we\'ve been through leave it\r\n我们经历的一切\r\nThere\'s nothing in you\r\n这不是你的错\r\nAnd did you hate me,\r\n如果你恨我\r\nhate me so good\r\n恨我 那很好\r\nThat you just let me out, let me out, let me out\r\n这样你就可以让我走 让我走\r\nOf this hell when you\'re around\r\n从你周围的地狱走开\r\nLet me out, let me out, let me out\r\n让我走 让我走 让我走\r\nHell when you\'re around\r\n从你周围的地狱走开\r\nLet me out, let me out, let me out\r\n让我走 让我走 让我走\r\nWhat I want from this\r\n我希望能从中\r\nIs learn to let go\r\n学到放手\r\nNo not of you\r\n不是你\r\nOf all that\'s been told\r\n故事里的人物都不是真的\r\nKillers re-invent and believe\r\n冷血之人重新创造了 并相信了这个故事\r\nAnd this leans on me, like a rootless...\r\n但我被迫面对事实 就像无根的树\r\nAnd all we\'ve been through\r\n我们经历的一切\r\nI said leave it,\r\n我说离开吧\r\nThere\'s nothing in you\r\n这不是你的错\r\nAnd did you hate me\r\n如果你恨我\r\nhate me so good\r\n恨我 那很好\r\nThat you just let me out, let me out, let me out\r\n这样你就可以让我走 让我走\r\nOf this hell when you\'re around\r\n从你周围的地狱走开\r\nLet me out, let me out, let me out\r\n让我走 让我走 让我走\r\nOf this hell when you\'re around\r\n从你周围的地狱走开\r\nLet me out, let me out, let me out\r\n让我走 让我走 让我走\r\nHell when you\'re around\r\n当你在我身边 这就像地狱\r\nLet me out, let me out, let me out\r\n让我走 让我走 让我走\r\nLet me out, let me out, let me out, let me out\r\nLet me out, let me out, let me out, let me out\r\nLet me out, let me out, let me out let me out\r\nAnd all we\'ve been through\r\n我们所经历的一切\r\nI said leave it,\r\n我说走吧\r\nIt\'s nothing in you\r\n这不是你的错\r\nAnd did you hate me,\r\n如果你恨我\r\nhate me so good\r\n恨我 那很好\r\nThat you just let me out, let me out, let me out\r\n这样你就可以让我走 让我走\r\nHell when you\'re around\r\n当你在我身边 这就像地狱\r\nLet me out, let me out, let me out,\r\n让我走 让我走 让我走\r\nHell when you\'re around\r\n当你在我身边 这就像地狱\r\nLet me out, let me out, let me out\r\n让我走 让我走 让我走\r\nHell when you\'re around\r\n当你在我身边 这就像地狱\r\nLet me out, let me out, let me out\r\n让我走 让我走 让我走\r\nHell when you\'re around\r\n当你在我身边 这就像地狱', 'PUBLISHED', 'MARKDOWN');

-- ----------------------------
-- Table structure for posts_tags
-- ----------------------------
DROP TABLE IF EXISTS `posts_tags`;
CREATE TABLE `posts_tags` (
  `id` bigint(20) NOT NULL,
  `post_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  KEY `posts_tags_post_id_fk` (`post_id`),
  KEY `posts_tags_hashtag_id_fk` (`tag_id`),
  CONSTRAINT `posts_tags_hashtag_id_fk` FOREIGN KEY (`tag_id`) REFERENCES `hashtag` (`id`),
  CONSTRAINT `posts_tags_post_id_fk` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of posts_tags
-- ----------------------------
INSERT INTO `posts_tags` VALUES ('1', '1', '1');
INSERT INTO `posts_tags` VALUES ('2', '2', '1');
INSERT INTO `posts_tags` VALUES ('3', '1', '2');

-- ----------------------------
-- Table structure for setting
-- ----------------------------
DROP TABLE IF EXISTS `setting`;
CREATE TABLE `setting` (
  `id` bigint(20) NOT NULL,
  `siteName` varchar(255) DEFAULT NULL,
  `slogan` varchar(255) DEFAULT NULL,
  `notification` varchar(255) DEFAULT NULL,
  `createdAt` varchar(255) DEFAULT NULL,
  `updatedAt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of setting
-- ----------------------------
INSERT INTO `setting` VALUES ('1', 'Playground', 'Hi, There', 'Hello,World', '2016-07-03 11:15:55', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `createdAt` varchar(255) DEFAULT NULL,
  `updatedAt` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2016-07-04 14:27:17', '2016-07-04 14:27:20', 'admin', 'xx@gmail.yy', '$2a$10$H2seEImwPocE8F83sIYXqOFC5n0gI97K8aiWCY9g/DBK3M1K4r8ea', 'ADMIN');
