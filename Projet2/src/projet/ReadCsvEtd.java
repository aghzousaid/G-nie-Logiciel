package projet;


	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;

	import javax.swing.JComboBox;

	public class ReadCsvEtd {


		public BufferedReader fileReader = null;
		 public JComboBox jcb6 ;
		 String file;
		
	    private static final String COMMA_DELIMITER = ";";
		 public ReadCsvEtd(String filename , JComboBox combo6) {
			jcb6 = combo6;
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
	                		jcb6.addItem(tokens[2]);
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
