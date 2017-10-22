package projet;

public class Laboratoire {
	private String nomLaboratoire;
	private String etageLaboratoire;
	private Departement departementLaboratoire;
	private Batiment batimentLaboratoire;
	
	/*
	 * le constructeur
	 */
	public Laboratoire(String nomLaboratoire, String etageLaboratoire, Departement departementLaboratoire,Batiment batimentLaboratoire) {
		this.nomLaboratoire = nomLaboratoire;
		this.etageLaboratoire = etageLaboratoire;
		this.departementLaboratoire = departementLaboratoire;
		this.batimentLaboratoire = batimentLaboratoire;
	}

	/*
	 * les getters
	 */
	public String getNomLaboratoire() {
		return nomLaboratoire;
	}


	public String getEtageLaboratoire() {
		return etageLaboratoire;
	}


	public Departement getDepartementLaboratoire() {
		return departementLaboratoire;
	}


	public Batiment getBatimentLaboratoire() {
		return batimentLaboratoire;
	}

	/*
	 * les setters
	 */
	public void setNomLaboratoire(String nomLaboratoire) {
		this.nomLaboratoire = nomLaboratoire;
	}


	public void setEtageLaboratoire(String etageLaboratoire) {
		this.etageLaboratoire = etageLaboratoire;
	}


	public void setDepartementLaboratoire(Departement departementLaboratoire) {
		this.departementLaboratoire = departementLaboratoire;
	}


	public void setBatimentLaboratoire(Batiment batimentLaboratoire) {
		this.batimentLaboratoire = batimentLaboratoire;
	}
	/*
	 * l'affichage
	 */
	@Override
	public String toString() {
		return "Laboratoire [nomLaboratoire=" + nomLaboratoire + ", etageLaboratoire=" + etageLaboratoire
				+ ", departementLaboratoire=" + departementLaboratoire + ", batimentLaboratoire=" + batimentLaboratoire
				+ "]";
	}
	
	
}
