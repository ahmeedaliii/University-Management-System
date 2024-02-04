/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

/**
 *
 * @author PC
 */
public class StudentGrades {
    
    private Integer  studentID;
    private Integer  courseID;
    private Integer  grade;
    private Integer  year;
    private Integer  semester;
    
    public StudentGrades(Integer studentID,Integer courseID,Integer grade,Integer year,Integer semester) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.grade = grade;
        this.year = year;
        this.semester = semester;
    }

    // Add getters and setters as needed
   public Integer getStudentID() {
        return studentID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public Integer getGrade() {
        return grade;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getSemester() {
        return semester;
    }

}
