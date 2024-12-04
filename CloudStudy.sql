-- 创建数据库
CREATE DATABASE CloudStudy;

-- 使用数据库
USE CloudStudy;

-- 创建DB_BOOK表
CREATE TABLE DB_BOOK (
                         uid INT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         age INT NOT NULL ,
                         sex ENUM('男', '女') NOT NULL
);

-- 创建DB_BORROW表
CREATE TABLE DB_BORROW (
                           bid INT PRIMARY KEY,
                           title VARCHAR(255) NOT NULL,
                           b_desc VARCHAR(255) NOT NULL
);

-- 创建DB_USER表，并设置外键约束
CREATE TABLE DB_USER (
                         id INT PRIMARY KEY,
                         f_uid INT,
                         f_bid INT,
                         UNIQUE KEY unique_bid_uid (f_uid, f_bid),
                         FOREIGN KEY (f_uid) REFERENCES DB_BOOK(uid),
                         FOREIGN KEY (f_bid) REFERENCES DB_BORROW(bid)
);