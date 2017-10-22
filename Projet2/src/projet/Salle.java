package projet;

public class Salle {
	private String nombrePlaceSalle;
	private String etageSalle;
	private String numeroSalle;
	private Batiment batimentSalle;
	
	/*
	 * le constructeur
	 */
	public Salle(String numeroSalle) {
		this.numeroSalle = numeroSalle;
		//this.batimentSalle = batimentSalle;
		//this.etageSalle = etageSalle;
	}
	/*
	 * les getters
	 */
	public String getNombrePlaceSalle() {
		return nombrePlaceSalle;
	}

	public String getEtageSalle() {
		return etageSalle;
	}

	public String getNumeroSalle() {
		return numeroSalle;
	}

	public Batiment getBatimentSalle() {
		return batimentSalle;
	}
	/*
	 * les setters
	 */
	public void setNombrePlaceSalle(String nombrePlaceSalle) {
		this.nombrePlaceSalle = nombrePlaceSalle;
	}
	
	public void setEtageSalle(String etageSalle) {
		this.etageSalle = etageSalle;
	}
	public void setNumeroSalle(String numeroSalle) {
		this.numeroSalle = numeroSalle;
	}
	public void setBatimentSalle(Batiment batimentSalle) {
		this.batimentSalle = batimentSalle;
	}
	/*
	 * l'affichage
	 */
	@Override
	public String toString() {
		return "Salle [nombrePlaceSalle=" + nombrePlaceSalle + ", etageSalle=" + etageSalle + ", numeroSalle="
				+ numeroSalle + ", batimentSalle=" + batimentSalle + "]";
	}
	
	
}
