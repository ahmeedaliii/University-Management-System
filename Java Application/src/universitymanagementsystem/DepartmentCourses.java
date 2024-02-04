/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;


/**
 *
 * @Ahmed Ali
 */
public class DepartmentCourses {
    
    private Integer  deptId;
    private Integer  courseId;
    
    public DepartmentCourses(Integer deptId, Integer courseId) {
        this.deptId = deptId;
        this.courseId = courseId;
          
    }
    
    // Getter for deptId
    public Integer getDeptId() {
        return deptId;
    }

    // Getter for courseId
    public Integer getCourseId() {
        return courseId;
    }
    
}
