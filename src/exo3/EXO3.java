/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.classes.ChefDeProjet;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.EmployeTacheId;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.services.EmployeService;
import ma.projet.services.EmployeTacheService;
import ma.projet.services.ProjetService;
import ma.projet.services.TacheService;
import ma.projet.util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class EXO3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
     
        
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     
       ProjetService projetService = new ProjetService();
        TacheService tacheService = new TacheService();
        EmployeService employeService = new EmployeService();
        EmployeTacheService employeTacheService = new EmployeTacheService();
        
        
          //creation d'un chef de projet
            ChefDeProjet chef = new ChefDeProjet("Ahmed", "Ahmed", "021558899");
            employeService.create(chef);

            Employe employe1 = new Employe("Karim","Karim","0632669988");
            employeService.create(employe1);

            Projet projet = new Projet("Gestion de stock", dateFormat.parse("13/10/2024"), dateFormat.parse("18/112/2024"));
            projet.setChefDeProjet(chef);
            projetService.create(projet);

            Tache tache1 = new Tache("Analyse", dateFormat.parse("10/02/2013"),dateFormat.parse("20/02/2013"), 800);
            tache1.setProjet(projet);
            tacheService.create(tache1);

            Tache tache2 = new Tache("Conception",dateFormat.parse("10/03/2013"), dateFormat.parse("15/03/2013"), 1200);
            tache2.setProjet(projet);
            tacheService.create(tache2);

            Tache tache3 = new Tache("Développement", dateFormat.parse("10/04/2013"),dateFormat.parse("25/04/2013"), 2000);
            tache3.setProjet(projet);
            tacheService.create(tache3);

            EmployeTache et1 = new EmployeTache(employe1, tache1,dateFormat.parse("10/02/2013"),dateFormat.parse("20/02/2013"));
            et1.setPk(new EmployeTacheId(employe1.getId(), tache1.getId()));
            employeTacheService.create(et1);
            System.out.println("EmployeTache créé : " + employe1.getNom() + " - " + tache1.getNom());

            EmployeTache et2 = new EmployeTache(employe1, tache2,dateFormat.parse("10/03/2013"),dateFormat.parse("15/03/2013"));
            et2.setPk(new EmployeTacheId(employe1.getId(), tache2.getId()));
            employeTacheService.create(et2);
            System.out.println("EmployeTache créé : " + employe1.getNom() + " - " + tache2.getNom());
    
        
        //Liste des tâches réalisées par un employé
            System.out.println("\n Liste des tâches réalisées par un employé :");
            List<Tache> tachesRealisees = employeService.getTachesRealisees(employe1);
            for (Tache tache : tachesRealisees) {
                System.out.println(" - " + tache.getNom());
            }

        
         //  Liste des projets gérés par un employé (chef de projet)
            System.out.println("\n Liste des projets gérés par un employé (chef de projet) :");
            List<Projet> projetsGeres = employeService.getProjetsGeres(chef);
            for (Projet p : projetsGeres) {
                System.out.println(" - " + p.getNom());
            }
        
            System.out.println("\nListe des tâches planifiées pour un projet :");
            List<Tache> tachesPlanifiees = projetService.getTachesPlanifiees(projet);
            for (Tache tache : tachesPlanifiees) {
                System.out.println(" - " + tache.getNom() + " (du " + dateFormat.format(tache.getDateDebut()) + 
                        " au " + dateFormat.format(tache.getDateFin()) + ")");
            }

            
            // Liste des tâches réalisées dans un projet
          System.out.println("\nListe des tâches réalisées dans un projet :");
          System.out.println("\nProjet: " +projet.getId()+"   Nom : "+projet.getNom()+"    Date Début :"+ dateFormat.format(projet.getDateDebut()) + ")");
            List<Tache> tachesRealiseesDansProjet = projetService.getTachesRealisees(projet);
            for (Tache tache : tachesRealiseesDansProjet) {
                System.out.println( "\n -Nom: " + tache.getNom() +"    Date Début Réelle : "+tache.getDateDebut()+"   Date Fin réelle : "+tache.getDateFin());
            }
        
            
            //Liste des tâches dont le prix est supérieur à 1000 DH
         System.out.println("\nListe des tâches dont le prix est supérieur à 1000 DH :");
            List<Tache> tachesPrixSuperieur = tacheService.getTachesPrixSuperieur1000();
            for (Tache tache : tachesPrixSuperieur) {
                System.out.println(" - " + tache.getNom() + " (Prix : " + tache.getPrix() + " DH)");
            }
            
            
            //Liste des tâches réalisées entre deux dates
            System.out.println("\nListe des tâches réalisées entre deux dates :");
            Date debut = dateFormat.parse("01/02/2013");
            Date fin = dateFormat.parse("31/03/2013");
            List<Tache> tachesPeriode = tacheService.getTachesRealiseesPeriode(debut, fin);
            for (Tache tache : tachesPeriode) {
                System.out.println(" - " + tache.getNom());
            }
    }
    
    
   
}
