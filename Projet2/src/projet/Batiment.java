package projet;

public class Batiment {
	private String nomBatiment;
	private int nbBatiment;
	/**
	 * @param Nom du batiement
	 */
	public Batiment(String nomBatiment) {
		this.nomBatiment = nomBatiment;
	}
	
	/*
	 * les getters
	 */
	public String getNomBatiment() {
		return nomBatiment;
	}
	public int getNbBatiment() {
		return nbBatiment;
	}
	
	/*
	 * les setters
	 */
	public void setNbBatiment(int nbBatiment) {
		this.nbBatiment = nbBatiment;
	}
	
	public void setNomBatiment(String nomBatiment) {
		this.nomBatiment = nomBatiment;
	}

	/*
	 * l'affichage
	 */
	@Override
	public String toString() {
		return "Batiment [nomBatiment=" + nomBatiment + ", nbBatiment=" + nbBatiment + "]";
	}
	
	
	
}
