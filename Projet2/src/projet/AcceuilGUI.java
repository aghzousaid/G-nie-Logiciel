package projet;

import java.awt.EventQueue;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import javax.swing.JComponent;

import javax.swing.JMenuBar;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import javax.swing.event.MenuListener;



import javax.swing.event.MenuEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ImageIcon;
import java.awt.ScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.CardLayout;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.event.InputMethodListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.awt.event.InputMethodEvent;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import read_write_CSV.Combinaison;
import read_write_CSV.CsvFileReader;
import read_write_CSV.CsvFileWriter;
import read_write_CSV.Write_RM;

import javax.swing.border.BevelBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.io.FileWriter;


public class AcceuilGUI {
			
			
	        public  int indexSal=0;
	        
	        JPanel JPC;
	
			RessourceMaterielle RM = new RessourceMaterielle();
			ArrayList<Salle> alsalle ;
			
			JCalendar jc = new JCalendar();
			
		    JFrame frame;
		    JFrame frameSalle;
		    JFrame frEtdt = new JFrame();
		    JFrame frEnst = new JFrame();
			String A,B,C,D,E,F,I,G,K,L,M,N;
	
			RessourceHumaine RH = new RessourceHumaine();
	
    		JTextField nom = new JTextField(20), prenom = new JTextField(20), matiere = new JTextField(20),
		    tel = new JTextField(20), bureau = new JTextField(20),sexe = new JTextField(20),
		    email = new JTextField(20),
		 
		    nomEtudiant = new JTextField(20), prenomEtudiant = new JTextField(20), ine = new JTextField(20),
		    filière = new JTextField(20), niveauetude =new JTextField(20),datenaissance = new JTextField(20),
		    lieunaissance = new JTextField(20),groupe = new JTextField(20),sexeEtdt = new JTextField(20) ,
		    emailEtdt = new JTextField(20),
		    
		    
		    nomSalle = new JTextField(20),
		    
		    
		    nomEtdt = new JTextField(10),prenomEtdt = new JTextField(10),ineEtdt = new JTextField(10),
		    
		    
		    nomEnst = new JTextField(20),prenomEnst = new JTextField(20), matièreEnst = new JTextField(20),
		    
		    nomEtdtS = new JTextField(20),prenomEtdtS = new JTextField(20),ineEtdtS = new JTextField(20),
		    
		    nomEnstS = new JTextField(20),prenomEnstS = new JTextField(20),matièreEnstS = new JTextField(20),
		    
		    nomEtdtM = new JTextField(20),prenomEtdtM = new JTextField(20),ineEtdtM = new JTextField(20),
		    
		    nomEnstM = new JTextField(20),prenomEnstM = new JTextField(20),ineEnstM = new JTextField(20),
    		
    		jour = new JTextField(20),horaire = new JTextField(20),matière = new JTextField(20),
    		professeur = new JTextField(20),salle = new JTextField(20),filièreCmb = new JTextField(20);
    		
    		private JTable table;



			 public FileWriter fileWriter ;
			 public BufferedWriter sortie =null; 
			 private BufferedReader fileReader = null;
    		
		     private static final String COMMA_DELIMITER = ";";

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceuilGUI window = new AcceuilGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AcceuilGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 884, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
			}
		});
		
		frame.setJMenuBar(menuBar);
		
		JMenu RessourceHumaine = new JMenu("RessourceHumaine");
		RessourceHumaine.setForeground(Color.GREEN);
		RessourceHumaine.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Saved Pictures\\t\u00E9l\u00E9chargement (2).jpg"));
		
	
		menuBar.add(RessourceHumaine);
		
		JMenu mnEnseignant = new JMenu("Enseignant");
		RessourceHumaine.add(mnEnseignant);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("New menu item");
		mnEnseignant.add(mntmNewMenuItem_7);
		
		JMenu mnEtudiant = new JMenu("Etudiant");
		RessourceHumaine.add(mnEtudiant);
		
		JMenu mnAjouter = new JMenu("Ajouter");
		RessourceHumaine.add(mnAjouter);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Enseignant");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    JFrame JF = new JFrame();
			        JF.setSize(new Dimension(500,500));
			        
			
			        
			        JPanel JP3 = new JPanel();
			    
			        
			    
			        
			   
				    JP3.setLayout(new GridBagLayout());
				    addItem(JP3, new JLabel("Nom:"), 0, 0, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("Prenom:"), 0, 1, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("Matiere:"), 0, 2, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("Tel:"), 0, 3, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("Bureau:"), 0, 4, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("Sexe:"), 0, 5, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("E-mail:"), 0, 6, 1, 1, GridBagConstraints.EAST);

				    addItem(JP3, nom, 1, 0, 2, 1, GridBagConstraints.WEST);
				    addItem(JP3, prenom, 1, 1, 2, 1, GridBagConstraints.WEST);
			        addItem(JP3, matiere, 1, 2, 2, 1, GridBagConstraints.WEST);
				    addItem(JP3, tel, 1, 3, 2, 1, GridBagConstraints.WEST); 
				    addItem(JP3, bureau, 1, 4, 2, 1, GridBagConstraints.WEST);
				    addItem(JP3, sexe, 1, 5, 2, 1, GridBagConstraints.WEST);
				    addItem(JP3, email, 1, 6, 2, 1, GridBagConstraints.WEST);
			        
				    JButton JB1 = new JButton("Ajouter");
				    JButton JB2 = new JButton("Effacer");
				    addItem(JP3, JB1, 4, 8, 1, 1, GridBagConstraints.WEST);
				    addItem(JP3, JB2, 3, 8, 1, 1, GridBagConstraints.WEST);

			        
				    JB1.addActionListener(new AjouterEnseignantAction());
				    JB2.addActionListener(new EffacerEnstAction());
				    
				    
				    
				    
				    JF.getContentPane().add(JP3);
			        JF.setVisible(true);
			        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			

		 
		});
		
	
		mnAjouter.add(mntmNewMenuItem_8);
		
		JMenuItem mntmEtudiant = new JMenuItem("Etudiant");
		mntmEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 JFrame frEtdt = new JFrame();
			        frEtdt.setSize(new Dimension(500,500));
			        
			        JPanel JP3 = new JPanel();
			    
				    JP3.setLayout(new GridBagLayout());
				    addItem(JP3, new JLabel("Nom:"), 0, 0, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("Prenom:"), 0, 1, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("INE:"), 0, 2, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("Filière:"), 0, 3, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("NiveauEtude:"), 0, 4, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("Email:"), 0, 5, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("DateDeNaissance:"), 0, 6, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("LieuDeNaissance:"), 0, 7, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("Groupe:"), 0, 8, 1, 1, GridBagConstraints.EAST);
				    addItem(JP3, new JLabel("Sexe:"), 0, 9, 1, 1, GridBagConstraints.EAST);



				    addItem(JP3, nomEtudiant, 1, 0, 2, 1, GridBagConstraints.WEST);
				    addItem(JP3, prenomEtudiant, 1, 1, 2, 1, GridBagConstraints.WEST);
			        addItem(JP3, ine, 1, 2, 2, 1, GridBagConstraints.WEST);
				    addItem(JP3, filière, 1, 3, 2, 1, GridBagConstraints.WEST); 
				    addItem(JP3, niveauetude, 1, 4, 2, 1, GridBagConstraints.WEST);
				    addItem(JP3, emailEtdt, 1, 5, 2, 1, GridBagConstraints.WEST);
				    
				    addItem(JP3, datenaissance, 1, 6, 2, 1, GridBagConstraints.WEST);
				    addItem(JP3, lieunaissance, 1, 7, 2, 1, GridBagConstraints.WEST);
				    addItem(JP3, groupe, 1, 8, 2, 1, GridBagConstraints.WEST);
				    addItem(JP3, sexeEtdt, 1, 9, 2, 1, GridBagConstraints.WEST);
			        
				    JButton JB1 = new JButton("Ajouter");
				    addItem(JP3, JB1, 4, 10, 1, 1, GridBagConstraints.WEST);
			        
				    JB1.addActionListener(new AjouterEtudiantAction());
				    
				    
				   frEtdt.getContentPane().add(JP3);
			        frEtdt.setVisible(true);
			        frEtdt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnAjouter.add(mntmEtudiant);
		
		JMenu mnChercher = new JMenu("Chercher");
		RessourceHumaine.add(mnChercher);
		
		JMenuItem mntmEtudiant_1 = new JMenuItem("Etudiant");
		mntmEtudiant_1.addActionListener(new ActionListener() {
			

			public void actionPerformed( ActionEvent e ) {
			
		        frEtdt.setSize(new Dimension(400,400));
		        
                JPC =new JPanel();
			    JPC.setLayout(new GridBagLayout());
			    
			
			    addItem(JPC, new JLabel("Numéro_Etudiant"), 0, 0, 1, 1, GridBagConstraints.CENTER);
			    addItem(JPC, ineEtdt, 1, 0, 1, 1, GridBagConstraints.CENTER);
			    JButton JB = new JButton("Chercher");
			    addItem(JPC, JB, 1, 1,1,1, GridBagConstraints.CENTER);

		        
			    JB.addActionListener(new ChercherEtdtAction());
			    
			    			    
			    frEtdt.getContentPane().add(JPC);
		        frEtdt.setVisible(true);
		        frEtdt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			}
		});
		mnChercher.add(mntmEtudiant_1);
		
		JMenuItem mntmEnseignant = new JMenuItem("Enseignant");
		mntmEnseignant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		        frEnst.setSize(new Dimension(500,500));
		        
                JPanel JP =new JPanel();
			    JP.setLayout(new GridBagLayout());
			    
			    addItem(JP, new JLabel("Nom "), 0, 0, 1, 1, GridBagConstraints.CENTER);
			    addItem(JP, new JLabel("Prénom "), 0, 1, 1, 1, GridBagConstraints.CENTER);
			  
			    addItem(JP, nomEnst, 1, 0, 2, 1, GridBagConstraints.CENTER);
			    addItem(JP, prenomEnst, 1, 1, 2, 1, GridBagConstraints.CENTER);

			    
			    JButton JB = new JButton("Chercher");
			    addItem(JP, JB, 2, 2, 1, 1, GridBagConstraints.CENTER);
		        
			    JB.addActionListener(new ChercherEnstAction());
			    
			    			    
			    frEnst.getContentPane().add(JP);
		        frEnst.setVisible(true);
		        frEnst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnChercher.add(mntmEnseignant);
		
		JMenu mnNewMenu = new JMenu("Supprimer");
		RessourceHumaine.add(mnNewMenu);
		
		JMenuItem mntmEtudiant_2 = new JMenuItem("Etudiant");
		mntmEtudiant_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame JF = new JFrame();
		        JF.setSize(new Dimension(500,500));
		        
                JPanel JP =new JPanel();
			    JP.setLayout(new GridBagLayout());
			    
			    addItem(JP, new JLabel("Nom "), 0, 0, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, new JLabel("Prénom "), 0, 1, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, new JLabel("INE"), 0, 2, 1, 1, GridBagConstraints.EAST);


			    addItem(JP, nomEtdtS, 1, 0, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, prenomEtdtS, 1, 1, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, ineEtdtS, 1, 2, 1, 1, GridBagConstraints.EAST);

			    
			    JButton JB = new JButton("Supprimer");
			    addItem(JP, JB, 4, 3, 1, 1, GridBagConstraints.WEST);
		        
			    JB.addActionListener(new SupprimerEtdtAction());
			    
			    			    
			    JF.getContentPane().add(JP);
		        JF.setVisible(true);
		        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		mnNewMenu.add(mntmEtudiant_2);
		
		
		JMenuItem mntmEnseignant_1 = new JMenuItem("Enseignant");
		mntmEnseignant_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame JF = new JFrame();
		        JF.setSize(new Dimension(500,500));
		        
                JPanel JP =new JPanel();
			    JP.setLayout(new GridBagLayout());
			    
			    addItem(JP, new JLabel("Nom "), 0, 0, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, new JLabel("Prénom "), 0, 1, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, new JLabel("Matière"), 0, 2, 1, 1, GridBagConstraints.EAST);


			    addItem(JP, nomEnstS, 1, 0, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, prenomEnstS, 1, 1, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, matièreEnstS, 1, 2, 1, 1, GridBagConstraints.EAST);

			    
			    JButton JB = new JButton("Supprimer");
			    addItem(JP, JB, 4, 3, 1, 1, GridBagConstraints.WEST);
		        
			    JB.addActionListener(new SupprimerEnstAction());
			    
			    			    
			    JF.getContentPane().add(JP);
		        JF.setVisible(true);
		        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		mnNewMenu.add(mntmEnseignant_1);
		
		JMenu mnModifier = new JMenu("Modifier");
		RessourceHumaine.add(mnModifier);
		
		JMenuItem mntmEtudiant_3 = new JMenuItem("Etudiant");
		mntmEtudiant_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  
				
				JFrame JF = new JFrame();
		        JF.setSize(new Dimension(500,500));
		        
                JPanel JP =new JPanel();
			    JP.setLayout(new GridBagLayout());
			    
			    addItem(JP, new JLabel("Remplez vous ces champs!  "), 3, 0, 1, 1, GridBagConstraints.CENTER);
			    addItem(JP, new JLabel("nom "), 0, 1, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, new JLabel("prénom "), 0, 2, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, new JLabel("Matière"), 0, 3, 1, 1, GridBagConstraints.EAST);

			    
			    JButton JB = new JButton("Valider");
			    addItem(JP, JB, 4, 4, 1, 1, GridBagConstraints.WEST);
		        
			    JB.addActionListener(new ModifierEtdtAction());
			       
			    JF.getContentPane().add(JP);
		        JF.setVisible(true);
		        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		mnModifier.add(mntmEtudiant_3);
		
		JMenuItem mntmEnseignant_2 = new JMenuItem("Enseignant");
		mntmEnseignant_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame JF = new JFrame();
		        JF.setSize(new Dimension(500,500));
		        
                JPanel JP =new JPanel();
			    JP.setLayout(new GridBagLayout());
			    
			    addItem(JP, new JLabel("Remplez vous ces champs!  "), 3, 0, 1, 1, GridBagConstraints.CENTER);
			    addItem(JP, new JLabel("nom "), 0, 1, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, new JLabel("prénom "), 0, 2, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, new JLabel("Matière"), 0, 3, 1, 1, GridBagConstraints.EAST);
			    
			    JButton JB = new JButton("Valider");
			    addItem(JP, JB, 4, 4, 1, 1, GridBagConstraints.WEST);
		        
			    JB.addActionListener(new ModifierEnstAction());
			       
			    JF.getContentPane().add(JP);
		        JF.setVisible(true);
		        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		
		
		mnModifier.add(mntmEnseignant_2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		RessourceHumaine.add(menuBar_1);
		
		JMenu mnRessourcematerielle = new JMenu("RessourceMaterielle");
		mnRessourcematerielle.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Saved Pictures\\t\u00E9l\u00E9chargement.jpg"));
		mnRessourcematerielle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			}
		});
		menuBar.add(mnRessourcematerielle);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ordinateur");
		mnRessourcematerielle.add(mntmNewMenuItem);
	
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Amphi");
		mnRessourcematerielle.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Batiment");
		mnRessourcematerielle.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Salle");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frameSalle = new JFrame();
		        frameSalle.setSize(new Dimension(500,500));
		        
                JPanel JP =new JPanel();
			    JP.setLayout(new GridBagLayout());
			    
			    addItem(JP, new JLabel("Nom Salle"), 0, 0, 1, 1, GridBagConstraints.EAST);
			  /*  addItem(JP, new JLabel("Prénom "), 0, 1, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, new JLabel("Matière"), 0, 2, 1, 1, GridBagConstraints.EAST);*/


			    addItem(JP, nomSalle, 1, 0, 1, 1, GridBagConstraints.EAST);
			   /* addItem(JP, prenomEnstS, 1, 1, 1, 1, GridBagConstraints.EAST);
			    addItem(JP, matièreEnstS, 1, 2, 1, 1, GridBagConstraints.EAST);*/

			    
			    JButton JB = new JButton("Ajouter");
			    JButton JB1 = new JButton("Modifier");
			    addItem(JP, JB, 2, 1, 1, 1, GridBagConstraints.WEST);
			    addItem(JP, JB1, 1, 1, 1, 1, GridBagConstraints.WEST);
			    
			    JB.addActionListener(new AjouterSalleAction());
			    JB1.addActionListener(new EffacerSalleAction());
			    
			    			    
			    frameSalle.getContentPane().add(JP);
		        frameSalle.setVisible(true);
		        frameSalle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
	
		mnRessourcematerielle.add(mntmNewMenuItem_4);
		
	

		
		JMenu mnCalendrier = new JMenu("Calendrier");
		mnCalendrier.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Saved Pictures\\peer-to-peer-planning-for-cpd-350x230.jpg"));
		menuBar.add(mnCalendrier);
		
		JMenuItem mntmAffich = new JMenuItem("AjouterCombinaison");
		mntmAffich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 JFrame f = new JFrame("Mon Calendrier");
				    // Initialiser un calendrier avec la date suivant
				    /*c.add(new Calendrier(1990, 2, 15));*/
				 
				    // and beside it, the current month.
				    //c.add(new Calendrier1());
				    JPanel JP = new JPanel();
				    JP.setLayout(new GridBagLayout());
				    addItem(JP, new JLabel("Jour "), 0, 0, 1, 1, GridBagConstraints.EAST);
				    addItem(JP, new JLabel("Horaire "), 0, 1, 1, 1, GridBagConstraints.EAST);
				    addItem(JP, new JLabel("matière"), 0, 2, 1, 1, GridBagConstraints.EAST);
				    addItem(JP, new JLabel("Professeur "), 0, 3, 1, 1, GridBagConstraints.EAST);
				    addItem(JP, new JLabel("Salle "), 0, 4, 1, 1, GridBagConstraints.EAST);
				    addItem(JP, new JLabel("Filière"), 0, 5, 1, 1, GridBagConstraints.EAST);

				    JComboBox combo1 = new JComboBox();
				    JComboBox combo2 = new JComboBox();
				    JComboBox combo3 = new JComboBox();
				    JComboBox combo4 = new JComboBox();
				    JComboBox combo5 = new JComboBox();
				    JComboBox combo6 = new JComboBox();
				    
				    combo1.addItem("Lundi");
				    combo1.addItem("Mardi");
				    combo1.addItem("Mercredi");
				    combo1.addItem("Jeudi");
				    combo1.addItem("Vendredi");
				    
				    ReadFileCsv rcv = new ReadFileCsv("salle.csv" ,combo5 );
				    rcv.readFile();
				    
				    ReadCsvEnst rcen = new ReadCsvEnst("Enseignant.csv",combo3,combo4);
				    rcen.readFile();
				    
				    ReadCsvEtd rcet = new ReadCsvEtd("Etudiant.csv",combo6);
				    rcet.readFile();
					
					
					addItem(JP, combo1, 1, 0, 1, 1, GridBagConstraints.WEST);
					addItem(JP, combo2, 1, 1, 1, 1, GridBagConstraints.WEST);
				    addItem(JP, combo3, 1, 2, 1, 1, GridBagConstraints.WEST);
				    addItem(JP, combo4, 1, 3, 1, 1, GridBagConstraints.WEST);
				    addItem(JP, combo5, 1, 4, 1, 1, GridBagConstraints.WEST);
				    addItem(JP, combo6, 1, 5, 1, 1, GridBagConstraints.WEST);
					
				/*	JP.add(combo);
					JP.add(combo1);*/
					
					JButton JB = new JButton("Ajouter");
                    addItem(JP, JB, 4, 6, 1, 1, GridBagConstraints.WEST );
			       
				    JB.addActionListener(new AjouterAction());
				    f.getContentPane().add(JP);
				    f.pack();
				    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    f.setVisible(true);
			}
		});
		mnCalendrier.add(mntmAffich);
		
		JMenu mnAutooptimisation = new JMenu("AutoOptimisation");
		mnAutooptimisation.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Saved Pictures\\images.jpg"));
		menuBar.add(mnAutooptimisation);
		
		JMenuItem jm = new JMenuItem("Calendrier");
		jm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		JPanel jp = new JPanel();
		frame.getContentPane().setLayout(null);
		
		
	   Calendrier3 cl = new  Calendrier3();
	   jp.add(cl);
	   
		/*table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			/*new Object[][] {
				{"SAIUD3", null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, "", ""},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Jour", "Horaire", "Mati\u00E8re", "Professeur", "Salle","Fili\u00E8re"}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			
		
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			//boolean[] columnEditables = new boolean[] {
				//false, false, true, true, , false, false
			//};
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.getColumnModel().getColumn(5).setResizable(false);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBackground(Color.CYAN);
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(100, 100, 1000,1000 );*/
		frame.getContentPane().add(jp);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
		}
		});
		//JPanel panel = new JPanel();
		//jsp.setColumnHeaderView(panel);
	}
	
	 private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
		    GridBagConstraints gc = new GridBagConstraints();
		    gc.gridx = x;
		    gc.gridy = y;
		    gc.gridwidth = width;
		    gc.gridheight = height;
		    gc.weightx = 10.0;
		    gc.weighty = 10.0;
		    gc.insets = new Insets(5, 5, 5, 5);
		    gc.anchor = align;
		    gc.fill = GridBagConstraints.NONE;
		    p.add(c, gc);
		  }
	 
	 private class AjouterEnseignantAction implements ActionListener{
			
			public  void actionPerformed(ActionEvent e){
				
			 Enseignant enst = new Enseignant(nom.getText(), prenom.getText(), matiere.getText(), 
			 tel.getText(), email.getText(), bureau.getText(),  sexe.getText());
			
		     RH.AjouterEnseignant(enst);
		     
		     System.out.println( "ajout d'un enseignant a été effectuer avec succès");
		     
		     try  
			 {
			     FileWriter fstream = new FileWriter("Enseignant.csv", true); //true tells to append data.
			     sortie = new BufferedWriter(fstream);
			     sortie.write(nom.getText());
			     sortie.write(";");
			     sortie.write(prenom.getText());
			     sortie.write(";");
			     sortie.write(matiere.getText());
			     sortie.write(";");
			     sortie.write(tel.getText());
			     sortie.write(";");
			     sortie.write(email.getText());
			     sortie.write(";");
			     sortie.write(bureau.getText());
			     sortie.write(";");
			     sortie.write(sexe.getText());
			     sortie.write("\n");
			 }
			 catch (IOException a)
			 {
			     System.err.println("Error: " + a.getMessage());
			 }
			 finally
			 {
			     if(sortie != null) {
			         try {
						sortie.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			     }
			 }
		     
			 nom.setText("");
			 prenom.setText("");
			 matiere.setText(""); 
			 tel.setText("");
			 email.setText("");
			 bureau.setText("");
			 sexe.setText("");
		   }
	 }
	 
	 private class AjouterEtudiantAction implements ActionListener{
			
			public  void actionPerformed(ActionEvent e){
				
			 Etudiant etdt = new Etudiant(nomEtudiant.getText(), prenomEtudiant.getText(), ine.getText(), 
			 filière.getText(), niveauetude.getText(), emailEtdt.getText(), datenaissance.getText(),
			 lieunaissance.getText(),groupe.getText(),sexeEtdt.getText());
			
		    try {
				RH.AjouterEtudiant(etdt);
			} catch (EtudiantAlreadyExistsException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		    try  
			 {
			     FileWriter fstream = new FileWriter("Etudiant.csv", true); //true tells to append data.
			     sortie = new BufferedWriter(fstream);
			     sortie.write(nomEtudiant.getText());
			     sortie.write(COMMA_DELIMITER );
			     sortie.write(prenomEtudiant.getText());
			     sortie.write(COMMA_DELIMITER );
			     sortie.write(ine.getText());
			     sortie.write(COMMA_DELIMITER );
			     sortie.write(filière.getText());
			     sortie.write(COMMA_DELIMITER );
			     sortie.write(niveauetude.getText());
			     sortie.write(COMMA_DELIMITER );
			     sortie.write(emailEtdt.getText());
			     sortie.write(COMMA_DELIMITER );
			     sortie.write(datenaissance.getText());
			     sortie.write(COMMA_DELIMITER );
			     sortie.write(lieunaissance.getText());
			     sortie.write(COMMA_DELIMITER );
			     sortie.write(groupe.getText());
			     sortie.write(COMMA_DELIMITER );
			     sortie.write(sexeEtdt.getText());
			     sortie.write("\n");
			 }
			 catch (IOException a)
			 {
			     System.err.println("Error: " + a.getMessage());
			 }
			 finally
			 {
			     if(sortie != null) {
			         try {
						sortie.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			     }
			 }
		     
		     nomEtudiant.setText("");
		     prenomEtudiant.setText("");
			 ine.setText(""); 
			 filière.setText("");
			 niveauetude.setText("");
			 emailEtdt.setText("");
			 datenaissance.setText("");
			 lieunaissance.setText("");
			 groupe.setText("");
			 sexeEtdt.setText("");

		     
		   }
	 }
	 
	 private class ChercherEtdtAction implements ActionListener{
			
			public  void actionPerformed(ActionEvent e){
				
			boolean res;
			Recherche rc = new Recherche("Etudiant.csv" ,ineEtdt.getText() );
			res=rc.RechercheEtdt();
		    if(res==true){
               
		    		JLabel jl = new JLabel("L'etudiant que vous cherchez existe");
		    	
		    		addItem(JPC, jl, 0, 2, 0, 0, GridBagConstraints.CENTER);
		    		
		    		
				   // JButton JBS = new JButton("Supprimer");
				   // JButton JBM = new JButton("Modifier");
				   // addItem(JPC, JBS, 0, 3, 1, 1, GridBagConstraints.WEST);
				   // addItem(JPC, JBM, 1, 3, 1, 1, GridBagConstraints.WEST);

			        frEtdt.add(JPC);
				   // JBS.addActionListener(new SupprimerEtdtAction());
				   // JBM.addActionListener(new ModifierEtdtAction());

		    		System.out.println("L'etudiant que vous cherchez existe");
		    		
		    			
		    }
		    else{
	    		JLabel jl = new JLabel("L'etudiant que vous cherchez n'existe pas");
		    	
	    		addItem(JPC, jl, 0, 2, 0, 0, GridBagConstraints.CENTER);
	    		
	    		frEtdt.add(JPC);
		    	System.out.println("L'etudiant que vous cherchez n'existe pas");
		    }
		    frEtdt.setVisible(true);
			frEtdt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		    
		   }
	 }
	 
	 

	 private class ChercherEnstAction implements ActionListener{
			
			public  void actionPerformed(ActionEvent e){
		    RH.ChercherEnseignant(nomEnst.getText(),prenomEnst.getText());
		    
		    
		    boolean res;
			Recherche1 rc = new Recherche1("Enseignant.csv" ,nomEnst.getText(),prenomEnst.getText());
			res=rc.RechercheEnst();
		    if(res==true){
               
		    		JLabel jl = new JLabel("L'enseignant que vous cherchez existe");
		    	
		    		addItem(JPC, jl, 0, 3, 0, 0, GridBagConstraints.CENTER);

			        frEnst.add(JPC);
				   // JBS.addActionListener(new SupprimerEtdtAction());
				   // JBM.addActionListener(new ModifierEtdtAction());

		    		System.out.println("L'enseignant que vous cherchez existe");
		    		
		    			
		    }
		    else{
	    		JLabel jl = new JLabel("L'enseignant que vous cherchez n'existe pas");
		    	
	    		addItem(JPC, jl, 0, 3, 1, 1, GridBagConstraints.CENTER);
	    		
	    		frEnst.add(JPC);
		    	System.out.println("L'enseignant que vous cherchez n'existe pas");
		    }
		    frEnst.setVisible(true);
			frEnst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   }
	 }
	 
	 
	 
		 private class SupprimerEtdtAction implements ActionListener{	
			public  void actionPerformed(ActionEvent e){     
		    
		      ReadWriteCsv rwc = new ReadWriteCsv();
		      rwc.readFileEtdt("Etudiant.csv" , ineEtdtS.getText());
		      try {
				rwc.Write();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    }
	 }
		 
		 
		 private class SupprimerEnstAction implements ActionListener{
				
				public  void actionPerformed(ActionEvent e){
			   			    
			    ReadWriteCsv rwc = new ReadWriteCsv();
			      rwc.readFileEnst("Enseignant.csv" ,   nomEnstS.getText());
			      System.out.println("Ce enseignant a été supprimer avec succè ");
			      try {
					rwc.Write();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			   }
		 }
		 
		 private class ModifierEtdtAction implements ActionListener{
			 public  void actionPerformed(ActionEvent e){
				 
			 }
		 }
		 
		 private class ModifierEnstAction implements ActionListener{
			 public  void actionPerformed(ActionEvent e){
				 
			 }
		 }
		 
		 private class AjouterAction implements ActionListener{
			 public  void actionPerformed(ActionEvent e){
				 A=jour.getText();
				 B=horaire.getText();
				 C=matière.getText();
				 D=professeur.getText();
				 E=salle.getText();
				 F=filière.getText();
				 
				 String fileName = System.getProperty("user.home")+"/combinaison.csv";
					
				 System.out.println("Write CSV file:");
				 CsvFileWriter.writeCsvFileCO(fileName,A,B,C,D,E,F);
				 
				 System.out.println("\nRead CSV file:");
				CsvFileReader.readCsvFile(fileName);
				
				/*frame.getContentPane().setLayout(null);
				table = new JTable();
				table.setSurrendersFocusOnKeystroke(true);
				
				table.setColumnSelectionAllowed(true);
				table.setCellSelectionEnabled(true);*/
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{CsvFileReader.getA(), CsvFileReader.getB(), CsvFileReader.getC()
						, CsvFileReader.getD(), CsvFileReader.getE(), CsvFileReader.getF()},
						{null, null, null, null, null, null},
						{null, null, null, null, null,null},
						{null, null, null, null, null, null},
					},
					new String[] {"Jour", "Horaire", "Mati\u00E8re", "Professeur", "Salle","Fili\u00E8re"}
				));
				/*{
					
					private static final long serialVersionUID = 1L;
					Class[] columnTypes = new Class[] {
						String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					//boolean[] columnEditables = new boolean[] {
						//false, false, true, true, , false, false
					//};
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				});
				table.getColumnModel().getColumn(5).setResizable(false);
				table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				table.setBackground(Color.CYAN);
				JScrollPane jsp = new JScrollPane(table);
				jsp.setBounds(100, 100, 1000,1000 );
				frame.getContentPane().add(jsp);
				
				
				JPanel panel = new JPanel();
				jsp.setColumnHeaderView(panel);*/
				
				
				 
			 }
		 }
		 
		 
		 private class AjouterSalleAction implements ActionListener{
			 public  void actionPerformed(ActionEvent e){
				 Salle sl = new Salle(nomSalle.getText());
				 RM.ajouterSalle(sl);
				 alsalle = RM.getNomSalle();
				 
				 
				 try  
				 {
				     FileWriter fstream = new FileWriter("salle.csv", true); //true tells to append data.
				     sortie = new BufferedWriter(fstream);
				     sortie.write(nomSalle.getText());
				     sortie.write("\n");
				 }
				 catch (IOException a)
				 {
				     System.err.println("Error: " + a.getMessage());
				 }
				 finally
				 {
				     if(sortie != null) {
				         try {
							sortie.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				     }
				 }
				 
				/* try {
					 
					 /*if(indexSal == 0){
					  fileWriter = new FileWriter("salle.csv");
					 }
					
						    //BufferedWriter sortie = new BufferedWriter(new FileWriter("salle.csv", true));
							//fileWriter = new FileWriter("salle.csv");
							Write_RM.writeSalle(sortie,alsalle.get(indexSal).getNumeroSalle(), indexSal);
					 
				 } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				 }
				 indexSal=indexSal+1;*/
				 
				 for( Salle salle:alsalle){	 
				 System.out.println(salle.getNumeroSalle());
				 }
				 
				 
			
			 }
		 }
		 
		 private class EffacerSalleAction implements ActionListener{
			 public  void actionPerformed(ActionEvent e){
				 
				 nomSalle.setText("");
			 }
		 }
		 
		 
		 private class EffacerEnstAction implements ActionListener{
			 public  void actionPerformed(ActionEvent e){
				 nom.setText("");
				 prenom.setText("");
				 matiere.setText(""); 
				 tel.setText("");
				 email.setText("");
				 bureau.setText("");
				 sexe.setText("");
			 }
		 }
 }
