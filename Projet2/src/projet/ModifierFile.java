package projet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ModifierFile {

	String ligneLue;
    ArrayList<String> ListLigne = new ArrayList<String>();
	int result;

	public BufferedReader fileReader = null;

	 String file;
	 String INE;
	
    private static final String COMMA_DELIMITER = ";";
	 public ModifierFile(String filename , String ine) {
		INE = ine;
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
