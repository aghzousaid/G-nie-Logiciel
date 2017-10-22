package read_write_CSV;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ashraf
 * 
 */
public class CsvFileWriter {

	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	private static final String FILE_HEADER_Co = "Jour,Horaire,Matière,Professeur,Salle,Filière";
	private static final String FILE_HEADER_En = "nom,prenom,matiere,tel,email,bureau,sexe";
	private static final String FILE_HEADER_Et = "nom,prenom,ine,filiere,niveauEtude,email,groupe,dateDeNaissance,lieuDeNaissance,sexe";
	private static final String FILE_HEADER_RM = "ordinateur,amphi,batiment,salle";
	
	
	public static void writeCsvFileCO(String fileName,String j,String h,String m,String pr ,String s,String f ) {
		
		//Create new students objects
		Combinaison combinaison = new Combinaison(j, h, m, pr,s,f);
		
		
		//Create a new list of student objects
		List<Combinaison> combinaisons = new ArrayList<Combinaison>();
		combinaisons.add(combinaison);
	
		
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter(fileName);

			//Write the CSV file header
			fileWriter.append(FILE_HEADER_Co.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (Combinaison cmb : combinaisons) {
				fileWriter.append(cmb.getJour());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(cmb.getHoraire());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(cmb.getMatiere());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(cmb.getProfesseur());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(cmb.getSalle());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(cmb.getFilière());
				fileWriter.append(NEW_LINE_SEPARATOR);
			}

			
			
			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}



public static void writeCsvFileRM(String fileName,String salle,String amphi,String batiment,String ordinateur ) {
	
	//Create new students objects
	Combinaison combinaison = new Combinaison(salle, amphi, batiment, ordinateur);
	
	
	//Create a new list of student objects
	List<Combinaison> combinaisons = new ArrayList<Combinaison>();
	combinaisons.add(combinaison);

	
	FileWriter fileWriter = null;
			
	try {
		fileWriter = new FileWriter(fileName);

		//Write the CSV file header
		fileWriter.append(FILE_HEADER_RM.toString());
		
		//Add a new line separator after the header
		fileWriter.append(NEW_LINE_SEPARATOR);
		
		//Write a new student object list to the CSV file
		for (Combinaison cmb : combinaisons) {
			fileWriter.append(cmb.getJour());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(cmb.getHoraire());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(cmb.getMatiere());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(cmb.getProfesseur());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(cmb.getSalle());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(cmb.getFilière());
			fileWriter.append(NEW_LINE_SEPARATOR);
		}

		
		
		System.out.println("CSV file was created successfully !!!");
		
	} catch (Exception e) {
		System.out.println("Error in CsvFileWriter !!!");
		e.printStackTrace();
	} finally {
		
		try {
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Error while flushing/closing fileWriter !!!");
            e.printStackTrace();
		}
		
	}
}
}

