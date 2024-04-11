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
import tg.univlome.epl.boutique.entite.Achat;
import tg.univlome.epl.boutique.service.AchatService;

/**
 *
 * @author DELL LATITUDE 3500
 */
@Path("/achat")
public class AchatResource {

    private final AchatService aservice;

    public AchatResource() {
        this.aservice = AchatService.getInstance();
    }

    @GET
    @Produces("application/json")
    public List<Achat> lister() {
        List<Achat> listeAchat = aservice.lister();
        return listeAchat;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Achat recuperer(@PathParam("id") long id) {
        Achat a = aservice.recuperer(id);
        return a;
    }

    @GET
    @Path("/nombre")
    public int compter() {
        int nombre = aservice.compter();
        return nombre;
    }

    @POST
    @Consumes("application/json")
    public void ajouter(Achat a) {
        System.out.println(a);
        aservice.ajouter(a);
    }

    @PUT
    @Consumes("application/json")
    public void modifier(Achat a) {
        aservice.modifier(a);
    }

    @DELETE
    public void supprimer(@QueryParam("id") long id) {
        aservice.supprimer(id);
    }
}
