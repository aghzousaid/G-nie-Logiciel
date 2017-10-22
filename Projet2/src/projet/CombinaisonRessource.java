package projet;

import java.io.Serializable;
import java.util.Date;

public final class CombinaisonRessource implements Serializable {
	private String date;
    private String enseignant;
    private String promo;
    private String salle;
    private String cours;
     
    public CombinaisonRessource(String cours, String enseignant, String promo, String salle, String date) {
    	this.cours = cours;
    	this.enseignant = enseignant;
    	this.promo = promo;
    	this.salle = salle;
    	this.date = date;
    }
    
    public String getCours () {
    	return cours;
    }
    
    public String getEnseignant () {
    	return enseignant;
    }
    
    public String getEtudiant () {
    	return promo;
    }
    
    public String getSalle () {
    	return salle;
    }
    
    public String toString () {
    	return "Cours1 : "+cours+"\nEnseignant :"+enseignant+"\nPromotion :"+promo+"\nSalle :"+salle+"\nDate :"+date;
    }
	

}
