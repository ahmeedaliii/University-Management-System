CREATE OR REPLACE function UNIVERSITY.calc_total_GPA(v_student_id number )
return number
is
       V_SUM number(8, 2);       v_total number(8, 2);
       V_COUNT number(8, 2);      V_GPA number(8, 2);
begin
    select sum(GRADE) ,count(GRADE)
    into V_SUM , V_COUNT
    from UNIVERSITY.STUDENT_COURSE
    where STUDENT_ID = v_student_id
    Group by STUDENT_ID ;
     v_total := V_COUNT * 100;
    V_GPA := V_SUM / v_total * 100;
    return V_GPA;
end;

------------------------------------

CREATE OR REPLACE procedure UNIVERSITY.update_student_info
    (v_student_id INTEGER, V_fname VARCHAR2, V_lname VARCHAR2, B_DATE Date, V_MOB_NUMBER  VARCHAR2, V_DEPT_ID INTEGER)
is
begin
        UPDATE UNIVERSITY.Student
        SET
          FIRST_NAME = V_fname,
          LAST_NAME = V_lname,
          BIRTH_DATE = B_DATE,
          MOB_NUMBER = V_MOB_NUMBER,
          DEPT_ID = V_DEPT_ID
        WHERE STUDENT_ID = v_student_id;  
end;

----------------------------------

CREATE OR REPLACE PROCEDURE UNIVERSITY.ADD_To_Archive
  (  p_std_id          Grades_Archive.STUDENT_ID%type
   , p_course_id      Grades_Archive.COURSE_ID%type
   , p_grade        Grades_Archive.GRADE%type
   , p_year          Grades_Archive.YEAR%type
   , p_semster   Grades_Archive.SEMESTER%type
   )
IS
BEGIN
  INSERT INTO Grades_Archive (STUDENT_ID, COURSE_ID, GRADE,
                           YEAR, SEMESTER)
    VALUES(p_std_id, p_course_id, p_grade, p_year, p_semster);
END;



CREATE OR REPLACE TRIGGER UNIVERSITY.STUDENT_COURSE_TRG
Before Delete ON UNIVERSITY.STUDENT_COURSE
FOR EACH ROW
BEGIN
    UNIVERSITY.ADD_To_Archive(:old.STUDENT_ID, :old.COURSE_ID, :old.GRADE, :old.YEAR, :old.SEMESTER);
END;
