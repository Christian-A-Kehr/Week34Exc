package rest.service;

import com.google.gson.Gson;
import entities.Employee;
import facades.EmployeeFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("employee")
public class RenameMeResource {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static EmployeeFacade cf = EmployeeFacade.getFacadeExample(emf);
    
    private static Gson gson = new Gson();
    
    EmployeeFacade facade = new EmployeeFacade();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Employee entity) {
        throw new UnsupportedOperationException();
    }
    
//    @PUT
//    @Path("/{id}")
//    @Consumes({MediaType.APPLICATION_JSON})
//    public void update(Employee entity, @PathParam("id") int id) {
//        throw new UnsupportedOperationException();
//    }
    
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
   
}
