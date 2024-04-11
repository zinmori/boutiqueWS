/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tg.univlome.epl.boutique.entite.Client;

/**
 *
 * @author DELL LATITUDE 3500
 */
public class ClientService {
    private static ClientService instance;
    
    private final List<Client> liste;
    
    private ClientService() {
        this.liste = new ArrayList<>();
        
        liste.add(new Client(1,"DONQUIXOTE", "DOFLAMINGO", LocalDate.of(2000,12,12),"1213-134-2055","546-756-987"));
        liste.add(new Client(2,"TELOU", "Oded", LocalDate.of(2003,12,12),"1014-134-3324","634-665-789"));
        liste.add(new Client(3,"ÉDOUAGBLÉ", "Roland", LocalDate.of(2001,12,12),"2234-127-2934","213-444-567"));
    }
    
    public synchronized static ClientService getInstance() {
        if (instance == null) {
            instance = new ClientService();
        }
        return instance;
    }
    
    public void ajouter(Client c) {
        liste.add(c);
    }
    
    public void modifier(Client c) {
        for (int i = 0; i < liste.size(); i++) {
            Client cli = liste.get(i);
            if (cli.getId() == c.getId()) {
                liste.set(i, c);
                break;
            }
        }
    }
    
    public void supprimer(long id) {
        liste.removeIf(cli -> cli.getId() == id);
    }
    
    public Client recuperer(long id) {
        for (Client cli : liste) {
            if (cli.getId() == id) {
                return cli;
            }
        }
        return null; // Aucun produit trouvé avec cet ID.
    }
    
    public int compter() {
        return liste.size();
    }
    
    public List<Client> lister() {
        return liste;
    }
}
