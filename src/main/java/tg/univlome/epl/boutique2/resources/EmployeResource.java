/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique2.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import java.util.List;
import tg.univlome.epl.boutique.entite.Employe;
import tg.univlome.epl.boutique.service.EmployeService;

/**
 *
 * @author DELL LATITUDE 3500
 */
@Path("/employe")
public class EmployeResource {
    private final EmployeService empService;

    public EmployeResource() {
        this.empService = EmployeService.getInstance();
    }
    @GET
    @Produces("application/json")
    public List<Employe> lister(){
        List<Employe> listeEmploye = empService.lister();
        return listeEmploye;
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Employe recuperer(@PathParam("id") long id){
        Employe emp = empService.recuperer(id);
        return emp;
    }
    @GET
    @Path("/nombre")
    public int compter(){
        int nombre = empService.compter();
        return nombre;
    }
    @POST
    @Consumes("application/json")
    public void ajouter(Employe emp){
        empService.ajouter(emp);
    }
    @PUT
    @Consumes("application/json")
    public void modifier(Employe emp){
        empService.modifier(emp);
    }
    @DELETE
    public void supprimer(@QueryParam("id") long id){
        empService.supprimer(id);
    }
}
