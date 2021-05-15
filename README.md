# 二手车管理系统

> fe仓库： https://github.com/kibuniverse/scsms
>
> be仓库： https://github.com/hyb-store/scsms-be





## 需求分析

 二手车管理系统为每一个用户提供买车以及卖车的功能，每一个用户既是买家又是卖家。

页面进入后会自动获取用户的定位并展示用户附近门店的在售车辆信息，用户也可以根据车辆（类型，颜色，里程数）以及门店的信息进行筛选。

门店的信息由平台方维护，门店的信息包括地址，空闲的位置，名称，电话等，用户在卖车的时会选择将自己的车在哪一个门店出售，平台会根据车的估价进行判断该车在哪一个网点更容易被售出。



## 几个概念

- `用户`：在该二手车管理系统中无厂商的角色，每个用户即是买家同时也是卖家
- `在售车辆`：目前正在售卖的车辆，由卖家上传，与卖家以及网点关联
- `车辆信息`：数据库中存在的车辆的信息



## 设计

### 前端展示设计

前端主要分为三个页面

- 买车/看车
- 我要卖车
- 我的卖车





### 数据库设计

```sql
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(10) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(16) NOT NULL DEFAULT '' COMMENT '密码',
  `avatar` varchar(50) NOT NULL DEFAULT '' COMMENT '头像',
  `phone_num` varchar(11) NOT NULL DEFAULT '' COMMENT '电话',
  `email` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
  `gender` int(1) NOT NULL DEFAULT 0 COMMENT '性别',
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_sale_car`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_id` varchar(10) NOT NULL DEFAULT '' COMMENT '汽车id',
  `price` varchar(10) NOT NULL DEFAULT '' COMMENT '汽车卖出的价格',
  `km` int(8) NOT NULL DEFAULT '' COMMENT '汽车行驶的里程数(km)',
  `color` varchar(10) NOT NULL DEFAULT '' COMMENT '汽车的颜色',
  `status` int(1) NOT NULL DEFAULT '' COMMENT '是否卖掉',
  `views` int(5) NULL DEFAULT 0 COMMENT '汽车浏览量',
  `store_id` int(11) NOT NULL DEFAULT 0 COMMENT '门店id',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '车主id',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '车的上架日期'
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_car`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `brand` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '汽车品牌',
  `series` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '汽车车系',
  `model` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '汽车款式',
  `structure` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '汽车车身结构(5门5座两厢车)',
  `fuel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '汽车的燃料类型(电动、汽油、混动)',
  `price` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '汽车原价/厂商指导价',
  PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `t_store`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL DEFAULT '' COMMENT '门店名称',
  `address` varchar(50) NOT NULL DEFAULT '' COMMENT '门店地址',
  `phone_num` varchar(11) NOT NULL DEFAULT '' COMMENT '电话',
  `longitude` varchar(15) NOT NULL DEFAULT '' COMMENT '经度',
  `latitude` varchar(15)  NOT NULL DEFAULT '' COMMENT '纬度',
  `counts` int(4) NOT NULL DEFAULT 9999 COMMENT '总容量',
  `using_count` int(4) NOT NULL  DEFAULT 0 COMMENT '已使用的容量',
  PRIMARY KEY (`id`)
);

CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sale_car_id` int(11) NOT NULL COMMENT '卖出的车的id',
  `store_id` int(11) NOT NULL DEFAULT '' COMMENT '门店id',
  `buyer_id` int(11) NOT NULL DEFAULT '' COMMENT '买家id',
  `seller_id` int(11) NOT NULL DEFAULT '' COMMENT '卖家id',
  `price` varchar(10)  NOT NULL DEFAULT '' COMMENT '卖出价格',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '成交日期',
  PRIMARY KEY (`id`)
);
```



### 接口设计

#### 用户

- 获取用户信息

#### 门店

- 获取门店列表
- 获取某个门店的详细信息

#### 在售车辆

- 根据筛选条件获取在售车辆列表
- 获取某在售车辆的详细信息









## 小组成员

### 前端页面开发

- 严凯治 负责框架搭建
- 李岳耿 负责卖车页面开发
- 任文涛 负责卖车页面开发



### 后端接口开发

- 齐彭涛 负责 框架搭建 数据库创建
- 黄颖博 负责业务开发 数据库创建
- 马集笃 负责业务开发

