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
import tg.univlome.epl.boutique.entite.ProduitAchete;
import tg.univlome.epl.boutique.service.ProduitAcheteService;

/**
 *
 * @author DELL LATITUDE 3500
 */
@Path("/produitachete")
public class ProduitAcheteResource {
    
    private final ProduitAcheteService paService;

    public ProduitAcheteResource() {
        this.paService = ProduitAcheteService.getInstance();
    }
    @GET
    @Produces("application/json")
    public List<ProduitAchete> lister(){
        List<ProduitAchete> listeProduitAchete = paService.lister();
        return listeProduitAchete;
    }
    @GET
    @Path("/{idAchat}/{idProduit}")
    @Produces("application/json")
    public ProduitAchete recuperer(@PathParam("idAchat") long id1, @PathParam("idProduit") long id2){
        ProduitAchete pa = paService.recuperer(id1, id2);
        return pa;
    }
    @GET
    @Path("/nombre")
    public int compter(){
        int nombre = paService.compter();
        return nombre;
    }
    @POST
    @Consumes("application/json")
    public void ajouter(ProduitAchete pa){
        paService.ajouter(pa);
    }
    @PUT
    @Consumes("application/json")
    public void modifier(ProduitAchete pa){
        paService.modifier(pa);
    }
    @DELETE
    public void supprimer(@QueryParam("idAchat") long idAchat, @QueryParam("idProduit") long idProduit ){
        paService.supprimer(idAchat, idProduit);
    }
}
