/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerFacade;

import entity.Customer;
import static entity.Customer_.id;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Hanne
 */
public class customerFacade {

    private static EntityManagerFactory emf;
    private static customerFacade instance;

    private customerFacade() {
    }

    public static customerFacade getBookFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new customerFacade();
        }
        return instance;
    }

    public Customer findByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, id);
            return customer;
        } finally {
            em.close();
        }
    }

    public List<Customer> findByLastName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select c from Customer c where lastName =" + name, Customer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public int getNumberOfCustomers() {
        // 
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery query = em.createQuery(" count(customer) c from Customer c ", Customer.class);
                    // udfyld manglede query fredag (anvned count)
                   
            return (int) query.getSingleResult();
        } finally {
            em.close();
        }
    }

    List<Customer> allCustomers(){
 EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    // udfyld manglede query fredag (anvned count)
                    = em.createQuery(" count ", Customer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
}

        
}
