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
import tg.univlome.epl.boutique.entite.Client;
import tg.univlome.epl.boutique.service.ClientService;

/**
 *
 * @author DELL LATITUDE 3500
 */
@Path("/client")
public class ClientRessource {
    
    private final ClientService cliService;

    public ClientRessource() {
        this.cliService = ClientService.getInstance();
    }
    @GET
    @Produces("application/json")
    public List<Client> lister(){
        List<Client> listeClient = cliService.lister();
        return listeClient;
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Client recuperer(@PathParam("id") long id){
        Client cli = cliService.recuperer(id);
        return cli;
    }
    @GET
    @Path("/nombre")
    public int compter(){
        int nombre = cliService.compter();
        return nombre;
    }
    @POST
    @Consumes("application/json")
    public void ajouter(Client cli){
        System.out.println(cli);
        cliService.ajouter(cli);
    }
    @PUT
    @Consumes("application/json")
    public void modifier(Client cli){
        cliService.modifier(cli);
    }
    @DELETE
    public void supprimer(@QueryParam("id") long id){
        cliService.supprimer(id);
    }
}
