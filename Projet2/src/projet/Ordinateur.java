package projet;

public class Ordinateur {
	private int nbOrdinateur;
	private String typeOrdinateur;
	
	public Ordinateur (int nbOrdinateur, String typeOrdinateur ) {
		this.nbOrdinateur = nbOrdinateur;
		this.typeOrdinateur = typeOrdinateur;
	}

	public int getNbOrdinateur() {
		return nbOrdinateur;
	}

	public void setNbOrdinateur(int nbOrdinateur) {
		this.nbOrdinateur = nbOrdinateur;
	}

	public String getTypeOrdinateur() {
		return typeOrdinateur;
	}

	public void setTypeOrdinateur(String typeOrdinateur) {
		this.typeOrdinateur = typeOrdinateur;
	}

	@Override
	public String toString() {
		return "Ordinateur [nbOrdinateur=" + getNbOrdinateur () + ", typeOrdinateur=" + getTypeOrdinateur () + "]";
	}

}
