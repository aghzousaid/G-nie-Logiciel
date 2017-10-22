package projet;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class ReadWriteCsv{
	

	String ligneLue;
    ArrayList<String> ListLigne=null;
	int result;

	public BufferedReader fileReader = null;

	 String file;
	 String INE;
	 
	 String nomEnst;
	
    private static final String COMMA_DELIMITER = ";";
	 public ReadWriteCsv() {
		 ListLigne = new ArrayList<String>();
	 }
	 
	 public void readFileEtdt(String filename , String ine){
	 String line = "";
	    INE = ine;
		file = filename; 
     //Create the file reader
     try {
			fileReader = new BufferedReader(new FileReader(file));
			  //Read the file line by line starting from the second line
        while ((line = fileReader.readLine()) != null) {
            //Get all tokens available in line
            String[] tokens = line.split(COMMA_DELIMITER);
            if (tokens.length > 0) {
            	System.out.println(tokens.length);
                		result=tokens[2].compareTo(INE);
                		if(result!=0){
                			ListLigne.add(line);
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
	 
	 
	 public void readFileEnst(String filename , String nom){
	 String line = "";
	   nomEnst=nom;
     //Create the file reader
     try {
			fileReader = new BufferedReader(new FileReader(file));
			  //Read the file line by line starting from the second line
        while ((line = fileReader.readLine()) != null) {
            //Get all tokens available in line
            String[] tokens = line.split(COMMA_DELIMITER);
            if (tokens.length > 0) {
            	System.out.println(tokens.length);
                		result=tokens[0].compareTo(nomEnst);
                		if(result!=0){
                			ListLigne.add(line);
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
	 
	 public void Write() throws IOException{
	 FileWriter fw = new FileWriter(file,false);
	 BufferedWriter bw = new BufferedWriter(fw);
	 PrintWriter fichierSortie = new PrintWriter(bw);
	 for (int i = 0; i < ListLigne.size(); i++) {
	      fichierSortie.println(ListLigne.get(i).trim());
	 }
	 
	 fichierSortie.close();
	 bw.close();
	 fw.close();
	 
	 }
}

