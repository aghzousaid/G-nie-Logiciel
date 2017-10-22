package projet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import configuration.Constantes;
import configuration.Creneau;
import configuration.DatePerso;
import ecole.EmploiDuTemps;

public class Calendrier3 extends JFrame{

	

		/** La Constante serialVersionUID. */
		private static final long serialVersionUID = 6965169604071304265L;

		/** Le calendrier. */
		private JCalendar calendrier = null;

		/** Le paneau. */
		private JPanel pan = new JPanel();

		/** La table. */
		private JTable table = null;

		/** La derniere date choisie. */
		private DatePerso derniereDate = null;

		/** Le dernier creneau choisi. */
		private Creneau creneauChoisi = Creneau.UN;

		/** L'emploi du temps */
		private EmploiDuTemps edt;

		/** La barre de menu */
		private JMenuBar barreMenu;

		/** Le menu fichier */
		private JMenu fichier;

		/** Le menuItem charger */
		private JMenuItem charger;
		/** Le menuItem enregistrer */
		private JMenuItem save;

		/** Le bouton réserver */
		private JButton bouton;

		/**
		 * Instancie un nouveau calendrier.
		 */
		public Calendrier3() {

			// Initialiser les attributs et le frame
			this.edt = edt;
			this.derniereDate = new DatePerso();

			pan.setLayout(new BorderLayout());
			this.setContentPane(pan);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(Constantes.LARGEUR_FENETRE, Constantes.HAUTEUR_FENETRE);
			this.setTitle(Constantes.TITRE);
			this.setResizable(false);
			this.setLocationRelativeTo(null);

			calendrier = new JCalendar();

			// Initialiser la JTable et la barre de menu
			JScrollPane scrollpane = initialiserTable();
			this.initialiserMenu();

			// Initialiser le bouton et ajouter l'écouteur
			/*setBouton(new JButton(Constantes.TEXTE_BOUTON_RESERVER));
			getBouton().addMouseListener(new ControleurBouton(this, this.edt));

			// Ajouter l'écouteur au calendrier
			calendrier.addPropertyChangeListener(new ControleurCalendrier(this,
					this.edt));*/

			// Initialiser la liste déroualante
			JComboBox<String> combo = new JComboBox<String>();
			combo.setPreferredSize(new Dimension(100, 20));
			combo.addItem(Constantes.CRENEAU1);
			combo.addItem(Constantes.CRENEAU2);
			combo.addItem(Constantes.CRENEAU3);
			combo.addItem(Constantes.CRENEAU4);
			//combo.addItemListener(new ControleurCombo(this));

			// Ajouter les composatns au panneau principal
			pan.add(scrollpane, BorderLayout.WEST);
			pan.add(calendrier, BorderLayout.CENTER);

			// Ajouter un sous panneau pour le bouton de réservation et la lsite
			// déroulante
			JPanel pan2 = new JPanel();
			pan2.setLayout(new GridLayout(2, 1));
			pan2.add(combo);
			//pan2.add(getBouton());

			// ajouter le sous panneau
			pan.add(pan2, BorderLayout.SOUTH);

			this.setVisible(true);

		}

		/**
		 * Méthode pour initialiser la barre de menu
		 */
		private void initialiserMenu() {

			this.barreMenu = new JMenuBar();
			this.fichier = new JMenu("Fichier");
			this.charger = new JMenuItem("Charger emploi du temps");
			this.save = new JMenuItem("Enregistrer emploi du temps");

			// Ajouter l'écouteur au bouton charger
			this.charger.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {

				}

				@Override
				public void mouseEntered(MouseEvent arg0) {

				}

				@Override
				public void mouseExited(MouseEvent arg0) {

				}

				@Override
				public void mousePressed(MouseEvent arg0) {

					// Demander le chemin du fichier à l'utilisateur
					JFileChooser chooser = new JFileChooser(Constantes.pathActuel);

					String path = null;
					int valeur = chooser.showOpenDialog(Calendrier3.this);

					if (valeur == JFileChooser.APPROVE_OPTION) {
						path = chooser.getSelectedFile().getAbsolutePath();

						boolean b = edt.charger(path, "1.0.0");
						if (b) {
							// Mettre à jour la JTable
							//majTable();
						}

					}
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {

				}

			});

			this.save.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {

				}

				@Override
				public void mouseEntered(MouseEvent arg0) {

				}

				@Override
				public void mouseExited(MouseEvent arg0) {

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// Demander le chemin du fichier à l'utilisateur
					JFileChooser chooser = new JFileChooser(Constantes.pathActuel);

					String path = null;
					int valeur = chooser.showOpenDialog(Calendrier3.this);

					if (valeur == JFileChooser.APPROVE_OPTION) {
						path = chooser.getSelectedFile().getName();
						edt.sauvegarder(path, "1.0.0");

					}
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {

				}

			});

			// Construire la barre de menu et l'ajouter au frame principal
			this.fichier.add(this.charger);
			this.fichier.add(this.save);
			this.barreMenu.add(this.fichier);
			this.setJMenuBar(this.barreMenu);

		}

		/**
		 * Initialiser la table.
		 * 
		 * @return La Jscroll pane contenant le tableau
		 */
		private JScrollPane initialiserTable() {
			// Construire un modèle de tableau
			DefaultTableModel model = new DefaultTableModel(0, 4) {

				/**
				 * 
				 */
				private static final long serialVersionUID = -6462681671254367203L;

				// Rendre les cellules non éditables
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};

			table = new JTable(model);

			// Nommer les 4 colonnes selon les créneau existants
			table.getColumnModel().getColumn(0).setHeaderValue(Constantes.CRENEAU1);
			table.getColumnModel().getColumn(1).setHeaderValue(Constantes.CRENEAU2);
			table.getColumnModel().getColumn(2).setHeaderValue(Constantes.CRENEAU3);
			table.getColumnModel().getColumn(3).setHeaderValue(Constantes.CRENEAU4);

			// Insérer la JTable dans un scroll pane au cas ou celui ci dépasse la
			// taille du frame (apparition d'une scroll bar dans ce cas)
			JScrollPane scrollpane = new JScrollPane(table);

			// Ajouter l'écouteur sur la JTable
			//table.addMouseListener(new ControleurTable(this, this.edt));
			return scrollpane;
		}
		
		
		
		

}
