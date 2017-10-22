package read_write_CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ashraf_sarhan
 *
 */
public class CsvFileReader {
	
	static String a;
	static String b;
	static String c;
	static String d;
	static String e;
	static String f;
	
	//Delimiter used in CSV file
	
	//Student attributes index
	private static final int Combinaison_Jour_IDX = 0;
	private static final int Combinaison_Horaire_IDX = 1;
	private static final int Combinaison_Matière = 2;
	private static final int Combinaison_Professeur_IDX = 3;
	private static final int Combinaison_Salle_IDX = 4;
	private static final int Combinaison_Filière_IDX = 5; 
	private static final int Combinaison_AutreRessource = 6;
	
	
	public static void readCsvFile(String fileName) {

		BufferedReader fileReader = null;
     
        try {
        	//Create a new list of student to be filled by CSV file data 
        	List<Combinaison> combinaisons = new ArrayList<Combinaison>();
        	
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));
            
            //Read the CSV file header to skip it
            fileReader.readLine();
            
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                	//Create a new student object and fill his  data
					Combinaison combinaison = new Combinaison(tokens[Combinaison_Jour_IDX],tokens[ Combinaison_Horaire_IDX ],tokens[Combinaison_Matière], 
							tokens[Combinaison_Professeur_IDX], tokens[Combinaison_Salle_IDX],
							tokens[Combinaison_Filière_IDX]);
					combinaisons.add(combinaison);
				}
            }
            
            //Print the new student list
            for (Combinaison combinaison : combinaisons) {
				System.out.println(combinaison.toString());
				a=combinaison.getJour();
				b=combinaison.getHoraire();
				c=combinaison.getMatiere();
				d=combinaison.getProfesseur();
				e=combinaison.getSalle();
				f=combinaison.getFilière();
				
			}
        } 
        catch (Exception e) {
        	System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

	}


	public static String getA() {
		return a;
	}


	public static String getB() {
		return b;
	}


	public static String getC() {
		return c;
	}


	public static String getD() {
		return d;
	}


	public static String getE() {
		return e;
	}


	public static String getF() {
		return f;
	}

}
