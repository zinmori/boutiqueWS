/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.epl.boutique.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tg.univlome.epl.boutique.entite.Employe;

/**
 *
 * @author DELL LATITUDE 3500
 */
public class EmployeService {
    private static EmployeService instance;
    
    private final List<Employe> liste;
    
    private EmployeService() {
        this.liste = new ArrayList<>();
        
        liste.add(new Employe(1, "SATORU", "GOJO", LocalDate.of(1998,12,21), "123-234"));
        liste.add(new Employe(2, "ABOLO-SEWOVI", "Komi", LocalDate.of(1985,12,12), "234-567"));
        liste.add(new Employe(3, "VLADIMIR", "PUTIN", LocalDate.of(1952,9,7), "234-654"));
    }
    
    public synchronized static EmployeService getInstance() {
        if (instance == null) {
            instance = new EmployeService();
        }
        return instance;
    }
    
    public void ajouter(Employe e) {
        liste.add(e);
    }
    
    public void modifier(Employe e) {
        for (int i = 0; i < liste.size(); i++) {
            Employe emp = liste.get(i);
            if (emp.getId() == e.getId()) {
                liste.set(i, e);
                break;
            }
        }
    }
    
    public void supprimer(long id) {
        liste.removeIf(emp -> emp.getId() == id);
    }
    
    public Employe recuperer(long id) {
        for (Employe emp : liste) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
    
    public int compter() {
        return liste.size();
    }
    
    public List<Employe> lister() {
        return liste;
    }
}
