package projet;

public class Amphi {
	private String nomAmphi;
	private Batiment batimentAmphi;
	private String etageAmphi; // string car l'étage n'est pas un nombre (information)
	private int nbAmphi;
	
	/*
	 * Les constructeurs
	 */
	public Amphi(String nomAmphi){
		this.nomAmphi = nomAmphi;
	}
	
	public Amphi(String nomAmphi, Batiment batimentAmphi, String etageAmphi) {
		this.nomAmphi = nomAmphi;
		this.batimentAmphi = batimentAmphi;
		this.etageAmphi = etageAmphi;
	}

	/*
	 * Les getters
	 */
	public String getNomAmphi() {
		return nomAmphi;
	}

	public Batiment getBatimentAmphi() {
		return batimentAmphi;
	}

	public String getEtageAmphi() {
		return etageAmphi;
	}

	public int getNbAmphi() {
		return nbAmphi;
	}
	
	/*
	 * Les setters, modification du nom impossible
	 */
	public void setBatimentAmphi(Batiment batimentAmphi) {
		this.batimentAmphi = batimentAmphi;
	}

	public void setEtageAmphi(String etageAmphi) {
		this.etageAmphi = etageAmphi;
	}

	public void setNbAmphi(int nbAmphi) {
		this.nbAmphi = nbAmphi;
	}
	
	public void setNomAmphi(String nomAmphi) {
		this.nomAmphi = nomAmphi;
	}

	/*
	 * L'affichage
	 */
	@Override
	public String toString() {
		return "Amphi :Nom : " + nomAmphi + 
				", Batiment : " + batimentAmphi + 
				", Etage : " + etageAmphi +
				", Nombre : " + nbAmphi;
	}
	
	
}
