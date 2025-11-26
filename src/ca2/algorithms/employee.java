/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2.algorithms;

public class employee {
    public String name;
    public String managerType;
    public String department;

    public employee(String name, String managerType, String department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }

    public String getName() { return name; }
    public String getManagerType() { return managerType; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return name + " | " + managerType + " | " + department;
    }
}
