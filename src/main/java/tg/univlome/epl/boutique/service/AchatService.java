/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.service;

import java.util.ArrayList;
import java.util.List;
import tg.univlome.epl.boutique.entite.Achat;

/**
 *
 * @author DELL LATITUDE 3500
 */
public class AchatService {
    private static AchatService instance;
    
    private final List<Achat> liste;
    
    private AchatService() {
        this.liste = new ArrayList<>();
        // Constructeur privé pour empêcher l'instanciation directe.
    }
    
    public synchronized static AchatService getInstance() {
        if (instance == null) {
            instance = new AchatService();
        }
        return instance;
    }
    
    public void ajouter(Achat a) {
        System.out.println(a);
        liste.add(a);
    }
    
    public void modifier(Achat a) {
        for (int i = 0; i < liste.size(); i++) {
            Achat achat = liste.get(i);
            if (achat.getId() == a.getId()) {
                liste.set(i, a);
                break;
            }
        }
    }
    
    public void supprimer(long id) {
        liste.removeIf(produit -> produit.getId() == id);
    }
    
    public Achat recuperer(long id) {
        for (Achat a : liste) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null; // Aucun produit trouvé avec cet ID.
    }
    
    public int compter() {
        return liste.size();
    }
    
    public List<Achat> lister() {
        return liste;
    }
}
