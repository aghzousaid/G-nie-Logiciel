package work;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;



/**
 * Lister le contenu d'un répertoire
 * http://www.fobec.com/java/964/lister-fichiers-dossiers-repertoire.html
 * @author fobec 2010
 */

public class TraitementPath {
 
    
	private static final String SEPARATOR = "#";
	private String initialpath = "";
    private Boolean recursivePath = false;
    private List <File> al = new ArrayList <File> ();
 
/**
 * Constructeur
 * @param path chemin du répertoire
 * @param subFolder analyse des sous dossiers
 * @throws IOException 
 */
    public TraitementPath(String path, Boolean subFolder) throws IOException {
        
        this.initialpath = path;
        this.recursivePath = subFolder;
        List();
        }
     
        public void List() throws IOException {
            this.listDirectory(this.initialpath);
        }
      
    private void listDirectory(String dir) throws IOException {
        File   file  = new File(dir);
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (!files[i].isDirectory()) {//Retourner true si l'objet encapsulé dans le Path est un répertoire
                	Path path = Paths.get(files[i].getPath());
                	String type = Files.probeContentType(path);
                	
                	if (type != null) {
             	       String S1= "application/vnd.oasis.opendocument.text";
             	       String S2= "application/vnd.oasis.opendocument.presentation";
             	       String S3= "application/vnd.oasis.opendocument.spreadsheet";
             	       String S4= "application/vnd.oasis.opendocument.graphics";
             	       if(type.equals( S1)){
             	    	 this.al.add(files[i]);
             	    	System.out.println(files[i].getName());   
                        } 
             	       if(type.equals(S2)){
             	    	 this.al.add(files[i]) ;   
               	    	System.out.println(files[i].getName());   
                         } 
             	       if(type.equals(S3)){
             	    	 this.al.add(files[i]) ;   
              	    	System.out.println(files[i].getName());   
                         }  
             	       if(type.equals(S4)){
             	    	 this.al.add(files[i]) ;   
             	    	System.out.println(files[i].getName());   
                        } 
             	    }
                if (files[i].isDirectory() == true && this.recursivePath == true) {
                    this.listDirectory(files[i].getAbsolutePath());
                }
                
            }
        }
    }    
      
   }

   
    public void Decompresser() throws FileNotFoundException, IOException{
    	
    	for(int i =0 ;i<al.size() ; i++){
    		File fichiercompresser = al.get(i) ;
    		String S = al.get(i).getName();
    		File dossier  = new File("C:/Users/DELL/Documents/FichierDezipper/"+S);
    		
    		DezipperFichier DezF = new DezipperFichier( fichiercompresser,  dossier);
    		System.out.println("Decompression de fichier est réussi");
    	}
    }	  
    
    public List<File> Repertoire(){
    	return al;
    }
    
    public void SaveInfFile(String fileName,int i)  {
    	
    try{   
    	    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
   
    	   
    	    	
    	    FileProperty FP = new FileProperty(al.get(i).getPath());
    	    String Date , Taille,Type;
    	    Date   = FP.getFormatedDate();
    	    Taille = FP.getFormatedSize();
    	    Type   = FP.getType();
    	    
    	    
            String s = al.get(i).getName();
    		String image = "C:/Users/DELL/Documents/FichierDezipper/"+s+"/Thumbnails/thumbnail.png";
    		writer.write(" Nom :"+al.get(i).getName() +SEPARATOR+" Taille : "+ Taille +SEPARATOR+ " Date de derniere modification: " +Date+SEPARATOR+" Type : " +Type +SEPARATOR+" Emplacement : "+al.get(i).getPath()+SEPARATOR+image);
    		
    		System.out.println("le sauvegarde des informations  de " +al.get(i).getName()+ " est terminé avec succée");
    		writer.newLine();
    	   
    		writer.close();
       		    		
    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    	}catch (IOException e) {
    		System.err.println(e.getMessage());
    	}
    }

 	
}
