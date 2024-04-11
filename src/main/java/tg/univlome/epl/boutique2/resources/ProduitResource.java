package tg.univlome.epl.boutique2.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;
import java.util.List;
import tg.univlome.epl.boutique.entite.Produit;
import tg.univlome.epl.boutique.service.ProduitService;

/**
 *
 * @author
 */
@Path("/produit")
public class ProduitResource {

    private final ProduitService pService;

    public ProduitResource() {
        this.pService = ProduitService.getInstance();
    }

    @GET
    public Response lister() {
        List<Produit> l = pService.lister();
        return Response.ok()
                .entity(new GenericEntity<List<Produit>>(l) {
                })
                .build();
    }

    @GET
    @Path("/{id}")
    public Produit recuperer(@PathParam("id") long id) {
        return pService.recuperer(id);
    }

    @GET
    @Path("/nombre")
    public Response compter() {
        int compt = pService.compter();
        return Response.status(Response.Status.OK)
                .entity(compt)
                .build();
    }

    @POST
    public void ajouter(Produit p) {
        pService.ajouter(p);
    }

    @PUT
    public void modifier(Produit p) {
        pService.modifier(p);
    }

    @DELETE
    public void supprimer(@QueryParam("id") long id) {
        pService.supprimer(id);
    }
}
