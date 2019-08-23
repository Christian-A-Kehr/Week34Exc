/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Employee;

/**
 *
 * @author Hanne
 */
public class EmployeeDTO {
    long id;
    String Name;
    String Address;

    public EmployeeDTO(Employee emp) {
        this.id = emp.getId();
        this.Name = emp.getName();
        this.Address = emp.getAddress();
    }
    
    
}
