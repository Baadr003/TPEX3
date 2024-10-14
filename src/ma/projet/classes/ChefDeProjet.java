/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author DELL
 */
@Entity
public class ChefDeProjet extends Employe {
    
    @OneToMany(mappedBy = "chefDeProjet")
    private List<Projet> projets;

    public ChefDeProjet() {
    }

    public ChefDeProjet( String nom, String prenom, String telephone) {
        super(nom, prenom, telephone);
    }

    public ChefDeProjet(List<Projet> projets) {
        this.projets = projets;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
    
    
    
    
}
