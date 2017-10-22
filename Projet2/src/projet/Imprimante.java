package projet;

public class Imprimante {
	private String typeImprimante;
	private String nombreImprimante;
	
	/*
	 * le constructeur
	 */
	public Imprimante(String typeImprimante, String nombreImprimante) {
		this.typeImprimante = typeImprimante;
		this.nombreImprimante = nombreImprimante;
	}
	/*
	 * les getters
	 */
	public String getTypeImprimante() {
		return typeImprimante;
	}

	public String getNombreImprimante() {
		return nombreImprimante;
	}
	/*
	 * les setters
	 */
	public void setTypeImprimante(String typeImprimante) {
		this.typeImprimante = typeImprimante;
	}

	public void setNombreImprimante(String nombreImprimante) {
		this.nombreImprimante = nombreImprimante;
	}

	@Override
	public String toString() {
		return "Imprimante [typeImprimante=" + typeImprimante + ", nombreImprimante=" + nombreImprimante + "]";
	}
	
	
}
