package projet;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Demo {

	private static final int NB_COL = 10;
	private static final int NB_ROW = 5;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()-> run());
	}
	
	public static void run() {
	
		JFrame frame = new JFrame("Démo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayPanel panel = new ArrayPanel();
		panel.setBackground(Color.CYAN.darker());
		panel.setForeground(Color.CYAN);
		panel.setLineColor(Color.CYAN);
	    //panel.setFont(new Font("Arial", Font.PLAIN, 12));

		for(int col=0; col<NB_COL; col++) {
			
			switch(col){
			case 0:
				panel.addColumn("8:00-9:00");
				break;
			case 1:
				panel.addColumn("9:00-10:00");
				break;
			case 2:
				panel.addColumn("10:00-11:00");
				break;
			case 3:
				panel.addColumn("11:00-12:00");
				break;	
			case 4:
				panel.addColumn("12:00-13:00");
				break;
				
			case 5:
				panel.addColumn("13:00-14:00");
				break;
			case 6:
				panel.addColumn("14:00-15:00");
				break;
			case 7:
				panel.addColumn("15:00-16:00");
				break;
			case 8:
				panel.addColumn("16:00-17:00");
				break;	
			case 9:
				panel.addColumn("17:00-18:00 ");
				break;
			}
		
		}
		
		
		for(int row=0; row<NB_ROW; row++) {
			switch(row){
			case 0:
				panel.addRow("Lundi");
				break;
			case 1:
				panel.addRow("Mardi");
				break;
			case 2:
				panel.addRow("Mercredi");
				break;
			case 3:
				panel.addRow("Jeudi");
				break;	
			case 4:
				panel.addRow("Vendredi");
				break;
			}
		}
		
		frame.getContentPane().add(new JScrollPane(panel));

		frame.pack();
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		
		//panel.setGridVisible(true);
		
		//panel.addRow("xxx", 2);
		JPanel jpanel = new JPanel();
		//JPanel casePanel = new JPanel();
		jpanel.setPreferredSize(new Dimension(100, 100));
		//casePanel.add(new JButton("xxxx"));
		Main mn= new Main("Introduction à l'informatique","Mr Jean", 
				"L1 Informatique Gr. B", "B546", "jeudi 24 mars, 8h30 - 10h30");

		jpanel.add(new JTextArea(mn.getCombinaison()));
		//casePanel.add(new JLabel("professeur kdnckdskndsk;n;"));
		//casePanel.add(new JLabel("professeur kdnckdskndsk;n;"));
		
		panel.setPanel(jpanel, 2, 2);

		//panel.swapRow(1, 2);
		//panel.swapRow(2, 0);
		//panel.swapColumn(1, panel.getColumnCount()-1);
		//panel.swapColumn(1, 2);transformer le contenue de la colonne 2 vers 1;
		//panel.swapRow(1, 2);
		
		frame.pack();
		
		/*panel.removeRow(2);
		panel.removeRow(2);
		panel.removeColumn(0
		panel.removeColumn(2);*/
		
	}

}
