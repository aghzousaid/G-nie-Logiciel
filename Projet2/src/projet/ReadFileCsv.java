package projet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComboBox;

public class ReadFileCsv {

	

	 public BufferedReader fileReader = null;
	 JComboBox jcb ;
	 String file;
	
     private static final String COMMA_DELIMITER = ";";
	 public ReadFileCsv(String filename , JComboBox combo ) {
		jcb = combo;
		file = filename; 
	 }
	 
	 public void readFile(){
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
                 for(int i=0; i<tokens.length ; i++){
                 	jcb.addItem(tokens[i]);
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

	 }
	
}
