/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class studentReport {
    private Integer  courseId;
    private String  courseName;
    private Integer  EnrolledStudents;
    private Integer avgGPA;

    public studentReport(Integer courseId, String courseName, Integer EnrolledStudents, Integer avgGPA ) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.EnrolledStudents = EnrolledStudents;
        this.avgGPA = avgGPA;
          
    }
    
    public Integer getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getEnrolledStudents() {
        return EnrolledStudents;
    }

    public Integer getAvgGPA() {
        return avgGPA;
    }
    
}