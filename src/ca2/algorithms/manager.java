/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2.algorithms;

/**
 *
 * @author sarna
 */
public class manager {
    String name;
    String managerType;
    department department;
    
    public manager(String name, String managerType, department department0) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }
    
    public String getName() {
        return name;
    }
    
    public String getManagerType() {
        return managerType;
    }
    
    public department getDepartment() {
        return department;
    }
    
    @Override
    public String toString() {
        return name + " | " + managerType + " | " + department;
    }
}
