package projet;

public class Enseignant {

	private String nom;
    private String prenom;
    private String matiere;
    private String tel;
    private String email;
    private String bureau;
    private String sexe;
	



	public Enseignant(String nom, String prenom, String matiere, String tel,  String email,
			String bureau, String sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.matiere = matiere;
		this.tel = tel;
		this.email = email;
		this.bureau = bureau;
		this.sexe = sexe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

	@Override
	public String toString() {
	
		return "Enseignant [nom=" + nom + ", prenom=" + prenom + ", matiere=" + matiere + ", tel=" + tel
				+ ", email=" + email + ", bureau=" + bureau + ", sexe=" + sexe + "]";
	}
	
	
    
}
