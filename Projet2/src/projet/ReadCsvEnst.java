package projet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JComboBox;

public class ReadCsvEnst {


	 public BufferedReader fileReader = null;
 	  JComboBox jcb3 ;
	 JComboBox jcb4 ;
	 String file;
	
    private static final String COMMA_DELIMITER = ";";
	 public ReadCsvEnst(String filename , JComboBox combo3 , JComboBox combo4) {
		jcb3 = combo3;
		jcb4 = combo4;
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
                		jcb3.addItem(tokens[0]);
                		jcb4.addItem(tokens[0]);//+""+tokens[1]
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
