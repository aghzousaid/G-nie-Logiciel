package projet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Recherche {

String file;	
String ine ;
public static boolean result;



public BufferedReader fileReader = null;
private static final String COMMA_DELIMITER = ";";

 public Recherche(String filename ,String ine ){
	 
	file = filename;
	this.ine = ine;
	 
 }
	
 public boolean RechercheEtdt(){
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
	                System.out.println(tokens[2]);
	                if(tokens[2].equals(ine)){
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
