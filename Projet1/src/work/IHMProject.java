package work;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//Construction de l'interface Principale
public class IHMProject extends JFrame {
	
    /**
	 * 
	 */
	//Declaration des composants de JFrame
	       private  JPanel linePanel1;
	       private  JPanel linePanel2;
	       private  JPanel linePanel3;
	       private  JPanel linePanel4;
	       private  JPanel linePanel5;
	       private  JPanel linePanel6;

           private  JTextField JTF1  = new JTextField(14); 
           private  JTextField JTF2  = new JTextField(21); 
           private  JTextField JTF3  = new JTextField(18);
           private  JTextField JTF4  = new JTextField(22);
           private  JTextField JTF5  = new JTextField(18);
           private  JTextField JTF6  = new JTextField(17);

            
           private  JLabel j1 = new JLabel("Arborescence");
           private  JLabel j2 = new JLabel("Filtrage d'Arborescence");
	       private  JLabel j3 = new JLabel("Decompression des fichiers");
	       private  JLabel j4 = new JLabel("Sauvegarder les informations");
	       private  JLabel j5 = new JLabel("Affichage des images");
	       private  JLabel j6 = new JLabel("Recherchre Par Nom");
	         
           private  JButton JB1 = new JButton("Parcourir");
           private  JButton JB2 = new JButton("Filtrer");
           private  JButton JB3 = new JButton("Decompresser");
           private  JButton JB4 = new JButton("SaveFile");
           private  JButton JB5 = new JButton("Afficher");
           private  JButton JB6 = new JButton("Chercher");
             
           private    TraitementPath TP;
           private    AfficherImage1 AI1;
            
           private String path;
             
  public IHMProject() {
	  this("Acceuil");
  }
  
  public IHMProject(String title){
	 super(title);
	 	 
	 
	 initLayout();
	 
	 initActions();
	   
  }
  
  private void initLayout() {
	// TODO Auto-generated method stub
	
	GridLayout grid = new GridLayout(6,2);
	Container contentPane =getContentPane();
	contentPane.setLayout(grid);
	
	         // First line
			linePanel1 = new JPanel();
			linePanel1.setSize(100,100);
			linePanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
			linePanel1.add(j1);
			linePanel1.add(JTF1);
			linePanel1.add(JB1);
			contentPane.add(linePanel1);

			 //Second line
			linePanel2 = new JPanel();
			linePanel2.setSize(100, 100);
			linePanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
			linePanel2.add(j2);
			linePanel2.add(JTF2);
			linePanel2.add(JB2);
			contentPane.add(linePanel2);

			
			// Third line
			 
			linePanel3 = new JPanel();
			linePanel3.setSize(100, 100);
			linePanel3.setLayout(new FlowLayout(FlowLayout.CENTER));
	     	linePanel3.add(j3);
			linePanel3.add(JTF3);
			linePanel3.add(JB3);
			contentPane.add(linePanel3);

			
			// Fourth line
			 
			linePanel4 = new JPanel();
			linePanel4.setSize(100, 100);
			linePanel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		    linePanel4.add(j4);
			linePanel4.add(JTF4);
			linePanel4.add(JB4);
			contentPane.add(linePanel4);
			
			//Fifth line
             
			linePanel5 = new JPanel();
			linePanel5.setSize(100, 100);
			linePanel5.setLayout(new FlowLayout(FlowLayout.CENTER));
		    linePanel5.add(j5);
			linePanel5.add(JTF5);
			linePanel5.add(JB5);
			contentPane.add(linePanel5);

			//Sixth 
			
			linePanel6 = new JPanel();
			linePanel6.setSize(100, 100);
			linePanel6.setLayout(new FlowLayout(FlowLayout.CENTER));
		    linePanel6.add(j6);
			linePanel6.add(JTF6);
			linePanel6.add(JB6);
			contentPane.add(linePanel6);
			
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(600,600);
	setResizable(false);
	setVisible(true);

}

 private void initActions() {
	// TODO Auto-generated method stub
	 //Associer a chaque Boutton son action
	JB1.addActionListener( new ParcourirAction());
	JB2.addActionListener( new FiltrageAction());
	JB3.addActionListener( new DecompresserAction());
	JB4.addActionListener( new SaveFileAction());
	JB5.addActionListener( new AffichageAction());
	JB6.addActionListener( new RechercheAction());

	}
	
 private class ParcourirAction implements ActionListener{
		
		public  void actionPerformed(ActionEvent e){
			String text = JTF1.getText(); //Recuperer le contenue de JTF1
		    path=text;
			JTF2.setText(path);//Modifier le contenue de JTF2
			if((!path.equals(""))) {   
		
	        			// TODO Auto-generated method stub
				           //Affichage  de contenue de l'arborescence 
	        	           
	        			   JButton open    = new JButton();
	        			   JFileChooser fc = new JFileChooser();
	        			   fc.setCurrentDirectory(new java.io.File(path));
	        			   fc.setDialogTitle("Fichier");//Definir Le titre de fc
	        			   fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        			   
	        			   if(fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION){
	        					//permet d'afficher fc
	        			   }
	        	           System.out.println(fc.getSelectedFile().getAbsolutePath());
	        	          
	        	            
	        	    }
			else{
				System.out.println("Please enter a path!");
			}
	   }
 }
	
		private class FiltrageAction implements ActionListener{
		
			public  void actionPerformed(ActionEvent e){
				
				try {
					TP = new TraitementPath(path,true);//appel a la classe de TraitementPath
					
				    } 
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				   }
				System.out.println("Filtrage réussi");
			}		
			
		}
		
		private class DecompresserAction implements ActionListener{
             public  void actionPerformed(ActionEvent e){
				
				try {
					
				      JTF3.setText(path);
					  TP.Decompresser();//appel a la methode Decompresser() de la classe TP
					  JTF4.setText("cliquer sur saveFile pour sauvegarder les informations");
				    } 
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				   }
			    
		   }
		}
		
		
		private class SaveFileAction implements ActionListener{
            public  void actionPerformed(ActionEvent e){
            	
            	 
				 for(int i=0;i<TP.Repertoire().size();i++){
				  if(i==0)	 
				  TP.SaveInfFile("exemple_calc.ods",0);
				  
				  else{
					  if(i==1) TP.SaveInfFile("exemple_draw.odg",1);
					  else{
						  if(i==2)TP.SaveInfFile("exemple_impress.odp",2);
						  else TP.SaveInfFile("exemple_writer.odt",3);
						  JTF5.setText("cliquer sur Afficher pour voir les images");
					      }
				     }	  			  
				   }
             }
		}
		
		private class AffichageAction implements ActionListener{          
			public  void actionPerformed(ActionEvent e){
		
				AI1 = new AfficherImage1();
			    System.out.println("Entrer un nom d'un fichier pour obtenir son contenue");
		   }
		}
 
	  private class RechercheAction implements ActionListener{
	      public void actionPerformed(ActionEvent e){
			  
	      String namefile = JTF6.getText();
	      if(namefile !="" &&  (namefile.equals("exemple_calc.ods")|| namefile.equals("exemple_draw.odg")|| namefile.equals("exemple_impress.odp")|| namefile.equals("exemple_writer.odt"))){
			
            AfficherFichier AF = new AfficherFichier(namefile);
		 
		    JFrame JF = new JFrame();
	        JF.setSize(new Dimension(500,500));
	 
	        JPanel JP = new JPanel();
	 
	        JLabel JL = new JLabel();
	        JL.setIcon(new ImageIcon("C:/Users/DELL/Documents/FichierDezipper/"+namefile+"/Thumbnails/thumbnail.png"));
	        JP.add(JL);
	        
	        JF.setContentPane(JP);
	        JF.setVisible(true);
	        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     }
	    else{
		      System.out.println("Impossible");
	        }
		   
	 }
	}   
   	   
 public static void main(String []args){
	IHMProject projet =  new IHMProject();
     }
  }


