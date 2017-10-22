package projet;

public class Departement {
	private String nomDepartement;
	private Batiment batDepartement;
	private String etageDepartement;
	
	/*
	 * Les constructeurs
	 */
	public Departement(String nomDepartement){
		this.nomDepartement = nomDepartement;
		this.batDepartement = null;
		this.etageDepartement = null;		
	}

	public Departement(String nomDepartement, Batiment batDepartement, String etageDepartement) {
		this.nomDepartement = nomDepartement;
		this.batDepartement = batDepartement;
		this.etageDepartement = etageDepartement;
	}
	
	/*
	 * Les getters
	 */
	public String getNomDepartement() {
		return nomDepartement;
	}

	public Batiment getBatDepartement() {
		return batDepartement;
	}

	public String getEtageDepartement() {
		return etageDepartement;
	}
	
	/*
	 * Les setters
	 */
	public void setBatDepartement(Batiment batDepartement) {
		this.batDepartement = batDepartement;
	}

	public void setEtageDepartement(String etageDepartement) {
		this.etageDepartement = etageDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	/*
	 * L'affichage
	 */
	@Override
	public String toString() {
		return "Departement [nomDepartement=" + nomDepartement + ", etageDepartement=" + etageDepartement + "]";
	}

	
}
