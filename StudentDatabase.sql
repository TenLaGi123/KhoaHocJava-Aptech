 create database StudentManagementSystem
 use StudentManagementSystem
 create table Class(
       ClassId int NOT NULL PRIMARY KEY IDENTITY,
       ClassCode NVARCHAR(50),
       ClassName NVARCHAR(100)
 	)

 