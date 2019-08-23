package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String Address;
    private Long Salary;

    public Employee(String Name, String Address, Long Salary) {
        this.Name = Name;
        this.Address = Address;
        this.Salary = Salary;
    }

    public Employee() {
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public Long getSalary() {
        return Salary;
    }
    
}
