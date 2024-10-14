/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DELL
 */
@Entity
public class EmployeTache {
    
    @EmbeddedId
    private EmployeTacheId pk;
    
    @ManyToOne
    @JoinColumn(name = "employeId", insertable = false, updatable = false)
    private Employe employe;
    
    @ManyToOne
    @JoinColumn(name = "tacheId", insertable = false, updatable = false)
    private Tache tache;
    
    @Temporal(TemporalType.DATE)
    private Date dateDebutReelle;
    
    @Temporal(TemporalType.DATE)
     private Date dateFinReelle;

    public EmployeTache() {
    }

    public EmployeTache(Employe emloye, Tache tache, Date dateDebutReelle, Date dateFinReelle) {
        this.employe = emloye;
        this.tache = tache;
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
    }

    public EmployeTacheId getPk() {
        return pk;
    }

    public void setPk(EmployeTacheId pk) {
        this.pk = pk;
    }

    public Employe getEmloye() {
        return employe;
    }

    public void setEmloye(Employe emloye) {
        this.employe = emloye;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }
    
    
    
    
}
    

