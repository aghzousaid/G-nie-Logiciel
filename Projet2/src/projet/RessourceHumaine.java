package projet;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RessourceHumaine {

	private ArrayList<Etudiant> alEtudiant ; 
	private ArrayList<Enseignant> alEnseignant ; 
	
	
	public RessourceHumaine( ){
		this.alEtudiant= new ArrayList<Etudiant>();
		this.alEnseignant= new  ArrayList<Enseignant>();
		
	 }
	
	public void AjouterEtudiant(Etudiant etdt)throws EtudiantAlreadyExistsException{
		if(!ContientE(etdt)){
			alEtudiant.add(etdt);
			System.out.println("L'ajout d'un etudiant est effectuée avec succès");
			System.out.println(alEtudiant.toString());
		}
		else
		{
			throw new EtudiantAlreadyExistsException(etdt);
		}
		/*System.out.println("L'ajout d'un etudiant est effectuée avec succès");
		alEtudiant.get(0).toString();*/
	}
	
	public void AjouterEnseignant(Enseignant enst){
		alEnseignant.add(enst);
		System.out.println("L'ajout d'un enseignanant est effectuée avec succès");
	}
	
	
	public Etudiant ChercherEtudiant(String nom, String prenom, String ine)  /*throws NoSuchElementException*/{
		Etudiant tmp = null;
		for(int i =0 ;i<alEtudiant.size();i++){
			if(alEtudiant.get(i).getNom().equals(nom)){
				if(alEtudiant.get(i).getPrenom().equals(prenom)){
					if( alEtudiant.get(i).getIne().equals(ine)){
			
		
						tmp = alEtudiant.get(i) ;
						System.out.println ("Cet étudiant existe");
					}	
				}	
			}
		}
		
		if (tmp == null) {
			System.out.println("Cet étudiant " +nom+ " " +prenom+ " avec l'ine " +ine+ " n'existe pas");
		}
		
			return tmp;
		
	}
	/*public String ChercherEtudiant(String nom , String prenom ,String ine){
		String tmp = null;
		for(int i=0 ;i<alEtudiant.size() ;i++){
			if(nom.equals(alEtudiant.get(i).getNom()) && prenom.equals(alEtudiant.get(i).getPrenom()) 
			   && ine.equals(alEtudiant.get(i).getIne()) ){
				System.out.println("cet etudiant existe");
				tmp= alEtudiant.get(i).toString() ;
			}
			else tmp= "cet etudiant n'existe pas";
		}
		
		return  tmp;
	}*/
	
	public String ChercherEnseignant(String nom , String prenom ){
		String tmp = null;
		for(int i=0 ;i<alEnseignant.size() ;i++){
			if(nom  == alEnseignant.get(i).getNom() && prenom == alEnseignant.get(i).getPrenom() ){
				System.out.println("Ce professeur existe");
				tmp = alEnseignant.get(i).toString() ;
			}
			else tmp= "ce professeur n'existe pas";
		}
		
		return  tmp;
	}
	
	
	
	public void SupprimerEtudiant( String nom ,String prenom , String ine){
		String tmp = null;
		for(int i=0 ;i<alEtudiant.size() ;i++){
			if(alEtudiant.get(i).getNom().equals(nom)&& alEtudiant.get(i).getPrenom().equals(prenom)
					&& alEtudiant.get(i).getIne().equals(ine)){
				alEtudiant.remove(alEtudiant.get(i)) ;
				tmp="ok";
				System.out.println("la suppression a été bien réalisé");
				
			}
			
			
		}
		 
			if(tmp.equals(null)){
				System.out.println("cet etudiant n'existe pas dans la liste des étudiant");
			}
			
			for(int i=0 ;i<alEtudiant.size();i++){
				System.out.println(alEtudiant.get(i));
			}
			
	}
	
	
	public void SupprimerEnseignant(String nom ,String prenom , String matière){
		String tmp = null;
	
		for(int i=0 ;i<alEnseignant.size();i++){
			if( alEnseignant.get(i).getNom().equals( nom) && alEnseignant.get(i).getPrenom().equals(prenom) 
					&& alEnseignant.get(i).getMatiere().equals(matière)){
				alEnseignant.remove(alEnseignant.get(i));
				tmp="ok";			
				System.out.println("la suppression a été bien réalisé");
			}
		}
		
		
		if(tmp.equals(null)){
			System.out.println("ce(cette) enseignant(e) n'existe pas dans la liste des enseignants");
		}	
		for(int i=0 ;i<alEnseignant.size();i++){
			System.out.println(alEnseignant.get(i));
		}	
	}
	
	
	
	public int getNbEtudiant(){
		return alEtudiant.size();
	}
	
    public int getNbEnseignant(){
		return alEnseignant.size();
	}
    
    public String toString1(){
    	return alEnseignant.get(0).getBureau();
    }
    
    public String toString2(){
    	return alEtudiant.toString();
    }
    
    public boolean ContientE(Etudiant etdt)   
    {
   	boolean result=false;
   	 for(int i=0 ; i<getNbEtudiant() ; i++)
   	 { 
   		 if(alEtudiant.get(i) == etdt)
   		 {
   			  result=true;
   		 }
   	 }
   	 return result;
    }
   
    
}
