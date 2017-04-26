-- 创建图书表
CREATE TABLE `book` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书ID',
  `name` varchar(100) NOT NULL COMMENT '图书名称',
  `number` int(11) NOT NULL COMMENT '馆藏数量',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='图书表';

-- 初始化图书数据
INSERT INTO `book` (`book_id`, `name`, `number`)
VALUES
(1000, 'Java程序设计', 10),
(1001, '数据结构', 10),
(1002, '设计模式', 10),
(1003, '编译原理', 10);

-- 创建预约图书表
CREATE TABLE `appointment` (
  `book_id` bigint(20) NOT NULL COMMENT '图书ID',
  `student_id` bigint(20) NOT NULL COMMENT '学号',
  `appoint_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '预约时间' ,
  PRIMARY KEY (`book_id`, `student_id`),
  INDEX `idx_appoint_time` (`appoint_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约图书表';

CREATE TABLE `class_course` (
  `class_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `term` varchar(50) NOT NULL  COMMENT '学期',
  `listContent` varchar(50) NOT NULL COMMENT '课程名',
  `week` varchar(50) NOT NULL COMMENT '星期',
  `lesson`varchar(50) NOT NULL COMMENT '节数',
  `info`varchar(200) NOT NULL COMMENT '课程明细',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='通过课程查询课表';

CREATE TABLE `list_info` (
  `list_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '列表信息id',
  `term` varchar(50) NOT NULL  COMMENT '学期',
  `list_content` varchar(200) NOT NULL COMMENT '课程名',
  `type` bigint(20) NOT NULL  COMMENT '列表类型',
  PRIMARY KEY (`list_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='列表信息表';
CREATE TABLE `teacher_course` (
  `class_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `term` varchar(50) NOT NULL  COMMENT '学期',
  `teacher` varchar(50) NOT NULL COMMENT '教师名',
  `week` varchar(50) NOT NULL COMMENT '星期',
  `lesson`varchar(50) NOT NULL COMMENT '节数',
  `info`varchar(200) NOT NULL COMMENT '课程明细',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='通过教师名查询课表';