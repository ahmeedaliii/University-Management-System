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
import java.sql.Date;

public class StudentData {
    private Integer  studentId;
    private String  firstName;
    private String  lastName;
    private Date birthDate;
    private String  mobNumber;
    private Integer  deptId;

    public StudentData(Integer studentId, String firstName, String lastName, Date birthDate, String mobNumber, Integer deptId) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.mobNumber = mobNumber;
        this.deptId = deptId;
          
    }

    // Add getters and setters as needed
    public Integer getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getMobNumber() {
        return mobNumber;
    }

    public Integer getDeptId() {
        return deptId;
    }
}
