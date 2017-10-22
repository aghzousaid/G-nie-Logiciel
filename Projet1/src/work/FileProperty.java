package work;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
 
/**
 * Lire les propriétés d'un fichier
 
 */
public class FileProperty {
 
    private File file = null;
 
    /**
     * Contructeur
    
     */
    public FileProperty(String filename) {
        file = new File(filename);
       
    }
 
   
 
    /**
     * Afficher la date du fichier
     * @return date au format dd/m/yyyy H:mm:ss
     */    public String getFormatedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:mm:ss");
        Date d = new Date(this.file.lastModified());
        return sdf.format(d);
    }
 
    /**
     * Taille du fichier
     * @return unité byte
     */
    public Long getSize() {
        return this.file.length();
    }
 
    /**
     * Afficher la taille
     * @return taille au format xx Ko ou xx Mo
     */
    public String getFormatedSize() {
        int size = (int) (this.file.length() / 1024) + 1;
        if (size > 1024) {
            return (size / 1024) + " Mo";
        } else {
            return size + " ko";
        }
    }
 
    /**
     * Type du fichier
     * @return par exemple Image bitmap
     */
    public String getType() {
        JFileChooser chooser = new JFileChooser();
        return chooser.getTypeDescription(this.file);
    }
 
   
}
