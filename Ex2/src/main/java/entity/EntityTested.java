/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Hanne
 */
public class EntityTested {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();
        try {
        Customer b1 = new Customer("Bob", "Bobsen");
        Customer b2 = new Customer("John", "Johnson");
        Customer b3 = new Customer("Debbi", "debbisen");
        
        
        em.getTransaction().begin();
        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        em.getTransaction().commit();
        }finally{
         em.close();
    }
    }
}
