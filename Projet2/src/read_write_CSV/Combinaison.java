package read_write_CSV;

import projet.Salle;

/**
 * @author ashraf
 *
 */
/**
 * @author DELL
 *
 */
public class Combinaison {
	
	private String jour;
	private String professeur;
	private String matiere;
	private String filière;
	private String Horaire;
	private String salle;
	
	public Combinaison(String jour, String horaire,String matiere,String professeur,String salle , String filière) {
		super();
		this.jour = jour;
		this.professeur = professeur;
		this.matiere = matiere;
		this.filière = filière;
		Horaire = horaire;
		this.salle = salle;
	}
	
	
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getProfesseur() {
		return professeur;
	}
	public void setProfesseur(String professeur) {
		this.professeur = professeur;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public String getFilière() {
		return filière;
	}
	public void setFilière(String filière) {
		this.filière = filière;
	}
	public String getHoraire() {
		return Horaire;
	}
	public void setHoraire(String horaire) {
		Horaire = horaire;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
	}
	
	
	@Override
	public String toString() {
		return "Combinaison [jour=" + jour + ", professeur=" + professeur + ", matiere=" + matiere + ", filière="
				+ filière + ", Horaire=" + Horaire + ", salle=" + salle + "]";
	}
}
