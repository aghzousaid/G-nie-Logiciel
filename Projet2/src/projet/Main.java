package projet;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import projet.Etudiant;
import projet.RessourceHumaine;
import projet.CombinaisonRessource;
import projet.Calendrier;
import projet.CalendrierInterfacePersistence;
import projet.CalendrierPersistence;
import projet.CombinaisonAlreadyExistsException;


public final class Main {
	public static String a;
	public static String R1;
	public static String R2;
	public static String R3;
	public static String R4;
	public static String R5;
	public Main(String matiere,String professeur,String groupe , String salle ,String dateETheure){
		R1=matiere;
		R2=professeur;
		R3=groupe;
		R4=salle;
		R5=dateETheure;
		
	}
 
    public static void main(final String[] args) throws Exception {
    	CalendrierInterfacePersistence calendrier = new CalendrierPersistence();
    	CombinaisonRessource cr = new CombinaisonRessource
    						(R1,R2,R3,R4,R5);
    	try {
    		calendrier.add(cr);
    	} catch (CombinaisonAlreadyExistsException caee){
    		System.err.println(caee.getMessage());
    	}
    	
    	System.out.println("Before saving in the file");
        System.out.println(calendrier.toString());
 
    	calendrier.serializationSave("combinaison.ser");
    	
    	
    	calendrier.removeAll();
        System.out.println("After removing in the combinaison");
        System.out.println(calendrier.toString());
    		
    	calendrier.serializationRead("combinaison.ser");
    	
    	
    	System.out.println("After reading frome the file");
        a =calendrier.toString();
         
        System.out.println(a); 
    	
    }
    
    
    public String getCombinaison(){
	   return a;
   }
}

   