-- 用户信息 
DROP TABLE
IF EXISTS `user`;

CREATE TABLE `user` (
	`id` INT NOT NULL auto_increment,
	`name` VARCHAR (32) NOT NULL COMMENT '用户名',
	`password` VARCHAR (32) NOT NULL COMMENT '密码',
	`openid` VARCHAR (64) COMMENT '微信openid',
	`real_name` VARCHAR (32) NOT NULL COMMENT '真实姓名',
	`birthday` DATE COMMENT '生日',
	`gender` TINYINT DEFAULT '0' COMMENT '性别，0未知1男2女',
	`phone_number` VARCHAR (16) COMMENT '电话号码',
	`email` VARCHAR (64) COMMENT '邮箱地址',
	`address` VARCHAR (256) COMMENT '住址',
	`intro` VARCHAR (512) COMMENT '简介',
	`photo_icon` VARCHAR (128) COMMENT '头像文件路径',
	`pw_reset_code` VARCHAR (8) COMMENT '密码重置码',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP  COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '用户信息';

-- 角色信息
DROP TABLE
IF EXISTS `role`;

CREATE TABLE `role` (
	`id` INT NOT NULL auto_increment,
	`name` VARCHAR (32) NOT NULL COMMENT '角色名称',
	`intro` VARCHAR (512) COMMENT '简介',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP  COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '角色信息';

-- 权限信息
DROP TABLE
IF EXISTS `permission`;

CREATE TABLE `permission` (
	`id` INT NOT NULL auto_increment,
	`code` VARCHAR (32) NOT NULL COMMENT '权限码CATE_PER',
	`name` VARCHAR (32) NOT NULL COMMENT '权限名称',
	`intro` VARCHAR (512) COMMENT '简介',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP  COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '权限信息';

-- 用户_角色 
DROP TABLE
IF EXISTS `user_role`;

CREATE TABLE `user_role` (
	`id` INT NOT NULL auto_increment,
	`user_id` INT NOT NULL,
	`role_id` INT NOT NULL,
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP  COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '用户-角色关联';

-- 角色_权限 
DROP TABLE
IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
	`id` INT NOT NULL auto_increment,
	`role_id` INT NOT NULL,
	`permission_id` INT NOT NULL,
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP  COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '角色-权限关联';

-- 系统参数
DROP TABLE
IF EXISTS `variable`;

CREATE TABLE `variable` (
	`id` TINYINT DEFAULT '1' NOT NULL,
	`morning_start` TIME NOT NULL COMMENT '早上开始时间',
	`evening_end` TIME NOT NULL COMMENT '晚上结束时间',
	`book_duration` TINYINT NOT NULL COMMENT '一个预约时间的分钟数',
	`rest_days` VARCHAR (8) DEFAULT '0011111' COMMENT '休息日，首位为星期一，1工作0休息，如1111100',
	`server_role_name` VARCHAR (8) DEFAULT '服务者' COMMENT '服务者角色名称，如教师、医生',
	`client_role_name` VARCHAR (8) DEFAULT '客户' COMMENT '客户角色名称，如学生、患者',
	`service_name` VARCHAR (8) DEFAULT '服务' COMMENT '服务分类名称，如课程、科室',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP  COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '系统参数';

-- 初始化系统参数
INSERT INTO `variable`
VALUES
	(
		'1',
		'08:00:00',
		'22:00:00',
		'60',
		'0011111',
		'教师',
		'学生',
		'课程',
		NULL,
		NULL
	);

-- service
DROP TABLE
IF EXISTS `service`;

CREATE TABLE `service` (
	`id` INT NOT NULL auto_increment,
	`name` VARCHAR (16) NOT NULL COMMENT '名称',
	`intro` VARCHAR (512) NOT NULL COMMENT '介绍',
	`status` TINYINT NOT NULL COMMENT '状态，0未启用1正常',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP  COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '服务项目';

-- service_server
DROP TABLE
IF EXISTS `service_server`;

CREATE TABLE `service_server` (
	`id` INT NOT NULL auto_increment,
	`service_id` INT NOT NULL COMMENT '服务id',
	`service_name` VARCHAR (16) NOT NULL COMMENT '服务名称',
	`server_id` INT NOT NULL COMMENT '服务者用户id',
	`server_name` VARCHAR (32) NOT NULL COMMENT '服务者用户名',
	`status` TINYINT NOT NULL COMMENT '状态，0未启用1启用',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP  COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '服务_服务者';

-- service_server_client
DROP TABLE
IF EXISTS `service_server_client`;

CREATE TABLE `service_server_client` (
	`id` INT NOT NULL auto_increment,
	`service_server_id` INT NOT NULL COMMENT '服务_服务者id',
	`client_id` INT NOT NULL COMMENT '客户id',
	`client_name` VARCHAR (32) NOT NULL COMMENT '客户用户名',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP  COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '服务_服务者_客户';

-- client_service
DROP TABLE
IF EXISTS `client_service`;

CREATE TABLE `client_service` (
	`id` INT NOT NULL auto_increment,
	`client_id` INT NOT NULL COMMENT '客户id',
	`client_name` VARCHAR (32) NOT NULL COMMENT '客户用户名',
	`service_id` INT NOT NULL COMMENT '服务id',
	`service_name` VARCHAR (16) NOT NULL COMMENT '服务名称',
	`service_num` FLOAT(4,1) NOT NULL COMMENT '剩余服务次数',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP  COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '客户_服务';

-- payment
DROP TABLE
IF EXISTS `payment`;

CREATE TABLE `payment` (
	`id` VARCHAR (16) NOT NULL,
	`client_id` INT NOT NULL COMMENT '客户id',
	`client_name` VARCHAR (32) NOT NULL COMMENT '客户用户名',
	`service_id` INT NOT NULL COMMENT '服务id',
	`service_name` VARCHAR (16) NOT NULL COMMENT '服务名称',
	`cashier_id` INT NOT NULL COMMENT '收银员id',
	`cashier_name` VARCHAR (32) NOT NULL COMMENT '收银员用户名',
	`intro` VARCHAR (512) COMMENT '说明',
	`service_num` DECIMAL (4, 1) NOT NULL COMMENT '充值的服务次数',
	`price` DECIMAL (8, 2) NOT NULL COMMENT '总价',
	`status` TINYINT NOT NULL COMMENT '状态,0无意义1待支付2已支付3待退款4已退款',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP  COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '支付记录';

-- book_record
DROP TABLE
IF EXISTS `book_record`;

CREATE TABLE `book_record` (
	`id` VARCHAR (16) NOT NULL,
	`service_server_client_id` INT NOT NULL COMMENT '服务_服务者_客户id',
	`start_time` DATETIME NOT NULL COMMENT '开始时间',
	`end_time` DATETIME NOT NULL COMMENT '结束时间',
	`service_num` DECIMAL (4, 1) NOT NULL COMMENT '服务次数(按时间计算)',
	`book_type` TINYINT NOT NULL COMMENT '预约类型,0不重复1每天2每周3每月',
	`repeat_id` INT NOT NULL COMMENT '重复id',
	`creater_id` INT NOT NULL COMMENT '创建人id',
	`creater_name` VARCHAR (32) NOT NULL COMMENT '创建人姓名',
	`modifier_id` INT NOT NULL COMMENT '修改人id',
	`modifier_name` VARCHAR (32) NOT NULL COMMENT '修改人姓名',
	`intro` VARCHAR (512) COMMENT '说明',
	`status` TINYINT NOT NULL COMMENT '状态,0无意义1待审核2待赴约3待确认4已取消5已赴约',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP  COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '预约记录';

-- book repeat

