INSERT INTO Class(ClassCode, ClassName)
Values ("C1106KV", "12A"),
("C1108GV","12B"),
("C1108IV","12C"),
("C1108HV","12D"),
("C1109GV","12E");


INSERT INTO Student(StudentName, BirthDate,ClassId)
Values ("PhạmTuấnAnh", "1993-08-05",1),
("PhanVănHuy", "1992-06-10",1),
("NguyễnHoàngMinh", "1992-09-07",2),
("TrầnTuấnTú", "1993-10-10",2),
("ĐỗAnhTài", "1992-06-06",3);

Drop Table Student;

CREATE TABLE Student(
	StudentId int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	StudentName nvarchar(200),
	BirthDate datetime,
	ClassId int
);

INSERT INTO Subject(SubjectName,SessionCount)
Values ("C Programming", 22),
("Web Design", 18),
("Database Management", 23);
 
INSERT INTO Result(StudentId,SubjectId,Mark)
Values (1,1,8),
(1,2,7),
(2,3,5),
(3,2,6),
(4,3,9),
(5,2,8);

CREATE TABLE IF NOT EXISTS Customers  (
	 CustomerID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	 Gender nvarchar(100),
	 BirthDate datetime,
	 JobCategory int,
	 Salary float,
	 SalaryBegin float,
	 JobTime int
);


 