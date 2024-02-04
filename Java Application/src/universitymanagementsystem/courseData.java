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
public class courseData {
    
    private Integer  courseID;
    private String  courseName;
    private Integer  courseHours;
    
    public courseData(Integer courseID, String courseName, Integer courseHours) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseHours = courseHours;
        
    }

    // Add getters and setters as needed
   public Integer getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getCourseHours() {
        return courseHours;
    }
    
}
