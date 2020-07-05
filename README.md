# 介绍

Spring Boot + Vue 前后端分离的简单案例：图书管理后台系统。

功能比较简单，只涉及一张表的增删改查，主要目的是理解前后端分离的基本思想，掌握前后端分离项目的开发思路。

# 使用技术

前端：

- Vue
- Element UI

后端：

- Spring Boot
- Spring Data Jpa
- MySQL

API 文档：

- JApiDocs：无需额外注解的 SpringBoot API 文档生成工具，它会将代码中的注释解析为 API 文档。但我在使用过程中发现了一些小问题，无法解析 Spring Data Jpa 的类（比如 Page）。

# 准备

数据库（名为 demo）建表语句：

```sql
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) NOT NULL COMMENT '书名',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;
```

# 运行

将两个项目分别使用编译器打开（推荐 IDEA）

1. 在 vue-demo 下分别执行两条命令
   - npm install
   - npm run serve

2. 修改 `application.yml` 文件下数据库连接信息后，直接点击运行 springboot-demo 项目

3. 浏览器地址栏输入 `localhost:8080` 即可访问页面