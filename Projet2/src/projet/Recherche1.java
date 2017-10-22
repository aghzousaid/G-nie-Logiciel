package projet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Recherche1 {

	String file;	
	String nom ;
	String prenom;
	public static boolean result;



	public BufferedReader fileReader = null;
	private static final String COMMA_DELIMITER = ";";

	 public Recherche1(String filename ,String nom , String prenom ){
		 
		file = filename;
		this.nom = nom;
		this.prenom=prenom;
		 
	 }
		
	 public boolean RechercheEnst(){
			 String line = "";
		    //Create the file reader
		    try {
					fileReader = new BufferedReader(new FileReader(file));
					  //Read the file line by line starting from the second line
		        while ((line = fileReader.readLine()) != null) {
		            //Get all tokens available in line
		            String[] tokens = line.split(COMMA_DELIMITER);
		            if (tokens.length > 0) {
		                System.out.println(tokens.length);

		                if(tokens[0].equals(nom) && tokens[1].equals(prenom)){
		                    result = true ;
		                    //break;
		                	//return result;
		                	
		                }
		               
		            }
		        }    
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    
			return result;

	 }
}
