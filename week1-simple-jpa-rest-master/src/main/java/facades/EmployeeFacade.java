package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {
    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // metoder fra opgave Exercise 1:
    public Employee getEmployeeById(Long id) {
        EntityManager em = getEntityManager();
        try {
//        TypedQuery<Employee> query = em.createQuery("SELECT e From Employee e where e =" + id,Employee.class);
            Employee emp = em.find(Employee.class, id);

            return emp;
        } finally {
            em.close();
        }

    }

    public Employee getEmployeesByName(String name) {
        EntityManager em = getEntityManager();
        try {
            Employee emp = em.find(Employee.class, name);
            return emp;
        } finally {
            em.close();
        }
    }

    public List<Employee> getAllEmployees() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Employee> query = em.createQuery("SELECT e From Employee e", Employee.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Employee getEmployeesWithHighestSalary() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Employee> maxSalary = em.createQuery("SELECT MAX(e.Salary) From Employee e", Employee.class);
            TypedQuery<Employee> emp = em.createQuery("SELECT e From Employee e where e.Salary =" + maxSalary, Employee.class);
            
            return emp.getSingleResult();
        } finally {
            em.close();
        }
    }
    public void createEmployee(String Name, String Address, Long Salary){
      Employee emp = new Employee(Name, Address, Salary);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
} 

}
