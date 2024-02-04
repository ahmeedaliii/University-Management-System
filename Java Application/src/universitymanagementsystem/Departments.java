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
public class Departments {

    private Integer deptId;
    private String deptName;

    public Departments(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    // Getter for deptId
    public Integer getDeptId() {
        return deptId;
    }

    // Getter for deptName
    public String getDeptName() {
        return deptName;
    }
    
}
