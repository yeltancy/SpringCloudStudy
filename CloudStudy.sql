-- 创建数据库
CREATE DATABASE CloudStudy;

-- 使用数据库
USE CloudStudy;

-- 删除DB_USER表
DROP TABLE IF EXISTS DB_USER;

-- 删除DB_BOOK表
DROP TABLE IF EXISTS DB_BOOK;

-- 删除DB_BORROW表
DROP TABLE IF EXISTS DB_BORROW;

-- 创建DB_USER表
CREATE TABLE DB_USER (
                         uid INT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         age INT,
                         sex ENUM('男', '女') NOT NULL
);

-- 创建DB_BOOK表
CREATE TABLE DB_BOOK (
                         bid INT PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         b_desc VARCHAR(255)
);

-- 创建DB_BORROW表，并设置外键约束
CREATE TABLE DB_BORROW (
                           id INT PRIMARY KEY,
                           f_uid INT,
                           f_bid INT,
                           UNIQUE INDEX unique_bid_uid (f_uid, f_bid),
                           FOREIGN KEY (f_uid) REFERENCES DB_USER(uid),
                           FOREIGN KEY (f_bid) REFERENCES DB_BOOK(bid)
);

-- 向DB_USER表插入数据
INSERT INTO DB_USER (uid, name, age, sex) VALUES
                                              (1, '张三', 20, '男'),
                                              (2, '李四', 22, '女'),
                                              (3, '王五', 24, '男');

-- 向DB_BOOK表插入数据
INSERT INTO DB_BOOK (bid, title, b_desc) VALUES
                                             (101, 'MySQL基础教程', 'MySQL数据库基础入门教程'),
                                             (102, '高级编程指南', '深入探讨编程技术'),
                                             (103, '数据分析实战', '数据分析的实战案例分析');

-- 向DB_BORROW表插入数据
INSERT INTO DB_BORROW (id, f_uid, f_bid) VALUES
                                             (1, 1, 101),
                                             (2, 2, 102),
                                             (3, 3, 103),
                                             (4, 1, 103); -- 假设张三也借了数据分析实战这本书