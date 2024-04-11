/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.service;

import java.util.ArrayList;
import java.util.List;
import tg.univlome.epl.boutique.entite.Categorie;

/**
 *
 * @author DELL LATITUDE 3500
 */
public class CategorieService {
    private static CategorieService instance;
    
    private final List<Categorie> liste;
    
    private CategorieService() {
        this.liste = new ArrayList<>();
        
        liste.add(new Categorie(1,"Savon", "Tout type de savon pour vos activite menageres."));
        liste.add(new Categorie(2,"Boisson", "Bieres, sucreries, et boissons fortes"));
        liste.add(new Categorie(3,"Produits cosmetiques", "Creme, pommade, parfums et autres"));
        liste.add(new Categorie(4,"Articles scolaires", "divers articles scolaires, cahier, bic, ardoise..."));
    }
    
    public synchronized static CategorieService getInstance() {
        if (instance == null) {
            instance = new CategorieService();
        }
        return instance;
    }
    
    public void ajouter(Categorie c) {
        liste.add(c);
    }
    
    public void modifier(Categorie c) {
        for (int i = 0; i < liste.size(); i++) {
            Categorie cat = liste.get(i);
            if (cat.getId() == c.getId()) {
                liste.set(i, c);
                break;
            }
        }
    }
    
    public void supprimer(long id) {
        liste.removeIf(cat -> cat.getId() == id);
    }
    
    public Categorie recuperer(long id) {
        for (Categorie cat : liste) {
            if (cat.getId() == id) {
                return cat;
            }
        }
        return null; // Aucun produit trouvé avec cet ID.
    }
    
    public int compter() {
        return liste.size();
    }
    
    public List<Categorie> lister() {
        return liste;
    }
}
