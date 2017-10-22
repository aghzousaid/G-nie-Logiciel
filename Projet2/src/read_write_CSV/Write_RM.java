package read_write_CSV;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Write_RM {

	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	
	private static final String FILE_HEADER_RM = "salle";
	
	
	public static void writeSalle(BufferedWriter fileWriter,String sal ,int index ) throws IOException {
	
		try {
		
			
			if(index == 0 ){
			//Write the CSV file header
			/*fileWriter.append(FILE_HEADER_RM.toString());
			
			//Add a new line separator after the header
			/*fileWriter.append(NEW_LINE_SEPARATOR);
		
			fileWriter.append(sal);
			//fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append(sal);
			fileWriter.append(NEW_LINE_SEPARATOR);*/
			
			fileWriter.write(FILE_HEADER_RM.toString());
			fileWriter.write(sal);
			fileWriter.write(NEW_LINE_SEPARATOR);
			}
			
			else{
			
				fileWriter.write(sal);
				fileWriter.write(NEW_LINE_SEPARATOR);
				//fileWriter.append(sal);
				//fileWriter.append(COMMA_DELIMITER);
				//fileWriter.append(NEW_LINE_SEPARATOR);
			}
			
			

			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			 if( fileWriter!= null) {
				 fileWriter.close();
			    }
			/*try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}*/
			
		}
	}

}
