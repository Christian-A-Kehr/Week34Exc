/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import com.google.gson.Gson;
import entities.Employee;
import facades.EmployeeFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Hanne
 */
@Path("Employee")
public class EmployeeResouce {

    private EntityManagerFactory emf;
    EmployeeFacade facade = new EmployeeFacade();
    private static Gson gson = new Gson();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmployeeResouce
     */
    public EmployeeResouce() {
    }

    /**
     * Retrieves representation of an instance of dto.EmployeeResouce
     * @return an instance of java.lang.String
     */
    @Path ("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllEmployees() {
        List<entities.Employee> emp = facade.getAllEmployees();
        return gson.toJson(emp);
    }
    @Path ("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getEmployeeById(Long id) {
        Employee emp = facade.getEmployeeById(id);
        return gson.toJson(emp);
    }
    @Path ("highestpaid")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getEmployeesWithHighestSalary() {
        Employee emp = facade.getEmployeesWithHighestSalary();
        return gson.toJson(emp);
    }
    @Path ("name/{name}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getEmployeesByName(String name) {
        Employee emp = facade.getEmployeesByName(name);
        return gson.toJson(emp);
    }
   
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of EmployeeResouce
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
