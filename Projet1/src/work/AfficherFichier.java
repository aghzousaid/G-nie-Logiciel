package work;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
 
import javax.swing.JFrame;
import javax.swing.JTextArea;
 
public class AfficherFichier extends JFrame
{   
	private String Nfile;
    private JTextArea text;
 
    public AfficherFichier(String namefile)
    {
    	this.Nfile = namefile;
        // INIT
        setTitle(Nfile);
        setSize(600,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(getParent());
 
         
        // TEXTE
        text = new JTextArea(readFile("C:\\Users\\DELL\\workspace\\Project\\"+Nfile));
        // AJOUT DANS LA FENETRE
        add(text,BorderLayout.WEST);
         
        // AFFICHE
        setVisible(true);
    }
     
    /**
     * Lis un fichier
     * @param file adresse du fichier
     * @return chaine de caractère
     */
    public String readFile( String file )
    {
        // LIS LE FICHIER
        String lines = "";
        String line;
        try
        {
            // CREE LE FLUX
            BufferedReader reader = new BufferedReader( new FileReader(file) );
             
            // LIS LIGNE A LIGNE
           
           
            while( (line = reader.readLine()) != null )
                lines += line+"\n";
        }
        catch( Exception e )
        {
            lines = "Une erreur s'est produite durant la lecture du flux : "+e.getMessage();
        }  
         
        return lines;
    }
     
 
}
