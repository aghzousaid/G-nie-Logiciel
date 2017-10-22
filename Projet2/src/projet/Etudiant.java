package projet;

public class Etudiant {

	private String nom;
    private String prenom;
    private String ine;
    private String filiere;
    private String niveauEtude;
   

	private String email;
    private String groupe;
    private String dateDeNaissance;
  

	private String lieuDeNaissance;
    private String sexe;
    
    public Etudiant(String nom, String prenom, String ine, String filiere, String niveauEtude,
           String email,String dateDeNaissance , String lieuDeNaissance, String  groupe, String sexe)
	{
		
		this.nom = nom;
		this.prenom = prenom;
		this.ine = ine;
		this.filiere = filiere;
		this.niveauEtude = niveauEtude;
		this.email = email;
		this.groupe = groupe;
		this.dateDeNaissance = dateDeNaissance;
		this.lieuDeNaissance = lieuDeNaissance;
		this.sexe=sexe;
    }


@Override
public String toString() {
	return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", ine=" + ine + ", filiere=" + filiere + ", niveauEtude="
			+ niveauEtude + ", email=" + email + ", groupe=" + groupe + ", dateDeNaissance=" + dateDeNaissance
			+ ", lieuDeNaissance=" + lieuDeNaissance + ", sexe=" + sexe + "]";
}


public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
 }

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getIne() {
	return ine;
}

public void setIne(String ine) {
	this.ine = ine;
}

public String getFiliere() {
	return filiere;
}

public void setFiliere(String filiere) {
	this.filiere = filiere;
}

public String getNiveauEtude() {
	return niveauEtude;
}

public void setNiveauEtude(String niveauEtude) {
	this.niveauEtude = niveauEtude;
}

public String getEmail() {
	return email;
 }

public void setEmail(String email) {
	this.email = email;
 } 

public String getGroupe() {
	return groupe;
 }

public void setGroupe(String groupe) {
	this.groupe = groupe;
 }

public String getDateDeNaissance() {
	return dateDeNaissance;
 }

public void setDateDeNaissance(String dateDeNaissance) {
	this.dateDeNaissance = dateDeNaissance;
 }

public String getLieuDeNaissance() {
	return lieuDeNaissance;
 }

public void setLieuDeNaissance(String lieuDeNaissance) {
	this.lieuDeNaissance = lieuDeNaissance;
 } 

public String getSexe() {
		return sexe;
	}

public void setSexe(String sexe) {
		this.sexe = sexe;
	}
}
