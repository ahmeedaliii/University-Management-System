Dept_Name VARCHAR2(100) NOT NULL,
  PRIMARY KEY (Dept_ID)
);

CREATE TABLE Course
(
  Course_ID INT NOT NULL,
  Course_Name INT VARCHAR2(100) NOT NULL,
  Course_hours INT NOT NULL,
  PRIMARY KEY (Course_ID)
);

CREATE TABLE DEPT_COURSES
(
  Dept_ID INT NOT NULL,
  Course_ID INT NOT NULL,
  PRIMARY KEY (Dept_ID, Course_ID),
  FOREIGN KEY (Dept_ID) REFERENCES Department(Dept_ID),
  FOREIGN KEY (Course_ID) REFERENCES Course(Course_ID)
);

CREATE TABLE Student
(
  Student_ID INT NOT NULL,
  First_Name VARCHAR2(100) NOT NULL,
  Last_Name INT VARCHAR2(100) NOT NULL,
  Birth_Date DATE NOT NULL,
  mob_number INT NOT NULL,
  Dept_ID INT NOT NULL,
  PRIMARY KEY (Student_ID),
  FOREIGN KEY (Dept_ID) REFERENCES Department(Dept_ID)
);

CREATE TABLE STUDENT_COURSE
(
  Student_ID INT NOT NULL,
  Course_ID INT NOT NULL,
  Grade INT NOT NULL,
  Year INT NOT NULL,
  Semester INT NOT NULL,
  PRIMARY KEY (Student_ID, Course_ID),
  FOREIGN KEY (Student_ID) REFERENCES Student(Student_ID),
  FOREIGN KEY (Course_ID) REFERENCES Course(Course_ID)
);

/*
Here's the last table as an Archive table to receive the deleted data as the
 data is a valuable thing we've and can't let it deleted without having a backup. 
*/
CREATE TABLE UNIVERSITY.Grades_Archive
(
  STUDENT_ID    INTEGER   ,
  COURSE_ID      INTEGER  ,
  GRADE             NUMBER(4,2)  ,
  YEAR               INTEGER   ,
  SEMESTER       INTEGER  
);
