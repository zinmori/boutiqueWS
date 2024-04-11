/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tg.univlome.epl.boutique.entite.Categorie;
import tg.univlome.epl.boutique.entite.Produit;

/**
 *
 * @author DELL LATITUDE 3500
 */
public class ProduitService {
    private static ProduitService instance;
    
    private final List<Produit> liste;
    
    private ProduitService() {
        this.liste = new ArrayList<>();
        Categorie c1 = new Categorie(1, "Savon", "");
        Categorie c2 = new Categorie(2, "Boisson", "");
        
        liste.add(new Produit(1, "Kdo", 500, LocalDate.of(2024, 12, 2), c1));
        liste.add(new Produit(2, "Fanico", 200, LocalDate.of(2025, 2, 23), c1));
        liste.add(new Produit(3, "Sodabi", 500, LocalDate.of(2025, 6, 2), c2));
        liste.add(new Produit(4, "Awoyo", 650, LocalDate.of(2024, 12, 12), c2));
        liste.add(new Produit(5, "Tchoukoutchou", 400, LocalDate.of(2024, 1, 21), c2));
        
    }
    
    public synchronized static ProduitService getInstance() {
        if (instance == null) {
            instance = new ProduitService();
        }
        return instance;
    }
    
    public void ajouter(Produit p) {
        liste.add(p);
    }
    
    public void modifier(Produit p) {
        int i = 0;
        for (Produit produit : liste) {
            if (produit.equals(p)) {
                liste.set(i, p);
                return;
            }
            i++;
        }
    }
    
    public void supprimer(long id) {
        liste.removeIf(produit -> produit.getId() == id);
    }
    
    public Produit recuperer(long id) {
        for (Produit produit : liste) {
            if (produit.getId() == id) {
                return produit;
            }
        }
        return null; // Aucun produit trouvé avec cet ID.
    }
    
    public int compter() {
        return liste.size();
    }
    
    public List<Produit> lister() {
        return liste;
    }
}