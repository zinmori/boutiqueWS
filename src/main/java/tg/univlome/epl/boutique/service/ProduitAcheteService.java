/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.service;

import java.util.ArrayList;
import java.util.List;
import tg.univlome.epl.boutique.entite.ProduitAchete;

/**
 *
 * @author DELL LATITUDE 3500
 */
public class ProduitAcheteService {
    private static ProduitAcheteService instance;
    
    private final List<ProduitAchete> liste;
    
    private ProduitAcheteService() {
        this.liste = new ArrayList<>();
        // Constructeur privé pour empêcher l'instanciation directe.
    }
    
    public synchronized static ProduitAcheteService getInstance() {
        if (instance == null) {
            instance = new ProduitAcheteService();
        }
        return instance;
    }
    
    public void ajouter(ProduitAchete p) {
        liste.add(p);
    }
    
    public void supprimer(long idProduit, long idAchat) {
        liste.removeIf(pa -> pa.getProduit().getId() == idProduit && pa.getAchat() == idAchat);
    }
    
    public void modifier(ProduitAchete pa) {
        int i = 0;
        for (ProduitAchete proAch : liste) {
            if (proAch.equals(pa)) {
                liste.set(i, pa);
                return;
            }
            i++;
        }
    }
    
    public ProduitAchete recuperer(long idProduit, long idAchat) {
        for (ProduitAchete proAch : liste) {
            if (proAch.getProduit().getId() == idProduit && proAch.getAchat() == idAchat) {
                return proAch;
            }
        }
        return null;
    }
    
    public int compter() {
        return liste.size();
    }
    
    public List<ProduitAchete> lister() {
        return liste;
    }
}
