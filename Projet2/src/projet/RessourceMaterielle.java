package projet;

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class RessourceMaterielle {
	private ArrayList <Salle> alSalle;
	private ArrayList <Batiment> alBatiment;
	private ArrayList <Ordinateur> alOrdinateur;
	private ArrayList <Amphi> alAmphi;
	
	public RessourceMaterielle () {
		this.alSalle = new ArrayList <Salle> ();
		this.alBatiment = new ArrayList <Batiment> ();
		this.alOrdinateur = new ArrayList <Ordinateur> ();
		this.alAmphi = new ArrayList <Amphi> ();
	}
	
	public void ajouterSalle (Salle salle) {
		alSalle.add(salle);
	}

	public void ajouterBatiment(Batiment batiment) {
		alBatiment.add(batiment);
	}

	
	
	public void ajouterOrdinateur(Ordinateur ordinateur) {
		alOrdinateur.add(ordinateur);
	}
	
	
	public void ajouterAmphitheatre(Amphi amphitheatre) {
		alAmphi.add(amphitheatre);
	}
	
	
	public void supprimerSalle (Salle salle) {
		alSalle.remove(salle);
	}
	
	public void supprimerBatiment (Batiment batiment) {
		alBatiment.remove(batiment);
	}
	
	
	
	public void supprimerOrdinateur(Ordinateur ordinateur) {
		alOrdinateur.remove(ordinateur);
	}
	
	
	public void supprimerAmphitheatre(Amphi amphi) {
		alAmphi.remove(amphi);
	}
	
	
	public Salle chercherSalle (Salle numeroSalle) throws NoSuchElementException {
		Salle result = null;
		for(Salle salle : alSalle){
			if(salle.getNumeroSalle().equals(numeroSalle)){
				result= salle;
			}
		}
		if (result == null) {
			throw new NoSuchElementException ("La salle " +numeroSalle+ "n'existe pas");
		}
		else {
			return result;
		}
	}
	
	
	public Batiment chercherBatiment (Batiment nomBatiment) throws NoSuchElementException {
		Batiment result = null;
		for(Batiment batiment : alBatiment){
			if(batiment.getNomBatiment().equals(nomBatiment)){
				result= batiment;
			}
		}
		if (result == null) {
			throw new NoSuchElementException ("Le batiment " +nomBatiment+ "n'existe pas");
		}
		else {
			return result;
		}
	}
	

	
	
	
	public Ordinateur chercherOrdinateur (String typeOrdinateur) throws NoSuchElementException {
		Ordinateur result = null;
		for (Ordinateur ordinateur : alOrdinateur) {
			if (ordinateur.getTypeOrdinateur().equals(typeOrdinateur)) {
				result = ordinateur ;
			}
		}
		if (result == null) {
			throw new NoSuchElementException ("L'ordinateur " +typeOrdinateur+ "n'existe pas");
		}
		else {
			return result;
		}
	}
	
	
	
	public Amphi chercherAmphi (Amphi nomAmphi) throws NoSuchElementException {
		Amphi result = null;
		for (Amphi amphi : alAmphi) {
			if (amphi.getNomAmphi().equals(nomAmphi)) {
				result = amphi ;
			}
		}
		if (result == null) {
			throw new NoSuchElementException ("L'amphi " +nomAmphi+ "n'existe pas");
		}
		else {
			return result;
		}
	}

	@Override
	public String toString() {
		return "RessourceMaterielle []";
	}
	
	
	public ArrayList <Salle> getNomSalle(){
		return alSalle;
	}
	
	
	
	
	
	
	
	
	

}
