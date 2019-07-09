 
 -- create table Class(
  --     ClassId int NOT NULL PRIMARY KEY IDENTITY,
  --     ClassCode NVARCHAR(50),
  --     ClassName NVARCHAR(100)
 --	);

 --SELECT * FROM Class;
--INSERT INTO Class(ClassCode, ClassName) VALUES('12A', 'Lop 12 A ne');
--SELECT * FROM Class;

--DELETE from Class where ClassId = '2';

--CREATE TABLE Result(
--   StudentId INT NOT NULL,
  -- SubjectId INT NOT NULL,
  -- Mark INT
--);


--SELECT Student.StudentName, Student.StudentID, Class.className
--FROM Class INNER JOIN Student 
--ON Class.ClassId = Student.ClassId;

-- INSERT INTO Student(StudentName,BirthDate,ClassId)
-- VALUES(N'PhạmTuấnAnh', '05/08/1993', NULL), 
--  (N'PhanVănHuy', '10/06/1992', NULL), 
-- (N'NguyễnHoàngMinh', '07/09/1992', NULL),
-- (N'TrầnTuấnTú', '10/10/1993', NULL),
-- (N'ĐỗAnhTài', '06/06/1992', NULL)

--DELETE FROM Student where 5>2;
--SELECT * FROM Student;

SELECT StudentId, StudentName, FORMAT (BirthDate, 'd', 'en-US' )  as BirthDate, ClassId
FROM Student;

-- INSERT INTO Class(ClassCode,ClassName)
-- VALUES ('C1106KV','12A'),
-- ('C1108GV','12B'),
-- ('C1108IV','12C'),
-- ('C1108HV', '12D'),
-- ('C1109GV', '12E')


-- UPDATE Student
-- SET ClassId = 16
-- WHERE StudentId IN (15);

-- SELECT ClassId, ClassName FROM Class;
-- select * FROM Student;
-- -- SELECT * FROM Class;

-- SELECT Student.StudentName, Student.BirthDate,Class.ClassName FROM Student 
-- LEFT JOIN Class ON Class.ClassId = Student.ClassId;

--  DELETE FROM Class WHERE 5>1;

-- SELECT Class.ClassCode, Class.ClassName, Student.* FROM Class 
-- INNER JOIN Student ON Class.ClassId = Student.ClassId
-- ORDER BY Class.ClassName ASC;

-- SELECT * FROM Student Where StudentName LIKE '%an%';

-- SELECT Student.StudentID as 'MãSinhViên',
--        Student.StudentName as 'TênSinhViên',
--        Student.BirthDate as 'NgàySinh'
--        FROM Student WHERE BirthDate BETWEEN '1992-10-10' AND '1993-10-10';


-- select Class.ClassId as 'MãLớp', Class.ClassCode as 'TênLớp', Student2.totalStudents as 'SĩSốLớp' FROM Class 
-- INNER JOIN 
-- (SELECT ClassId, count(*) as totalStudents
-- FROM Student GROUP BY ClassId) as Student2 
-- ON Class.ClassId = Student2.ClassId;

-- INSERT INTO Subject(SubjectName,SessionCount)
-- VALUES('C Programming', 22),
-- ('Web Design', 18),
-- ('Database Management', 23);


-- SELECT * FROM Student;
-- select * from Subject;


-- INSERT INTO Result(Mar)

--select * from Student;

 