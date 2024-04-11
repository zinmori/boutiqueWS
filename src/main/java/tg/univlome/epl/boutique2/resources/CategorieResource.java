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
import tg.univlome.epl.boutique.entite.Categorie;
import tg.univlome.epl.boutique.service.CategorieService;

/**
 *
 * @author DELL LATITUDE 3500
 */
@Path("/categorie")
public class CategorieResource {
    private final CategorieService cService;

    public CategorieResource() {
        this.cService = CategorieService.getInstance();
    }
    @GET
    @Produces("application/json")
    public List<Categorie> lister(){
        List<Categorie> listeCategorie = cService.lister();
        return listeCategorie;
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Categorie recuperer(@PathParam("id") long id){
        Categorie c = cService.recuperer(id);
        return c;
    }
    @GET
    @Path("/nombre")
    public int compter(){
        int nombre = cService.compter();
        return nombre;
    }
    @POST
    @Consumes("application/json")
    public void ajouter(Categorie c){
        System.out.println(c);
        cService.ajouter(c);
    }
    @PUT
    @Consumes("application/json")
    public void modifier(Categorie c){
        cService.modifier(c);
    }
    @DELETE
    public void supprimer(@QueryParam("id") long id){
        cService.supprimer(id);
    }
}
