package work;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AfficherImage1 {


        public AfficherImage1( ){
        	
        JFrame frmM = new JFrame();
        frmM.setSize(new Dimension(700,700));
 
        JPanel pnlM = new JPanel();
 
        JLabel lblM1 = new JLabel();
        lblM1.setIcon(new ImageIcon("C:/Users/DELL/Documents/FichierDezipper/exemple_writer.odt/Thumbnails/thumbnail.png"));
        pnlM.add(lblM1);
 
        JLabel lblM2 = new JLabel();
        lblM2.setIcon(new ImageIcon("C:\\Users\\DELL\\Documents\\FichierDezipper\\exemple_impress.odp\\Thumbnails\\thumbnail.png"));
        pnlM.add(lblM2);
         
        JLabel lblM3 = new JLabel();
        lblM3.setIcon(new ImageIcon("C:\\Users\\DELL\\Documents\\FichierDezipper\\exemple_draw.odg\\Thumbnails\\thumbnail.png"));
        pnlM.add(lblM3);
        
        
        JLabel lblM4 = new JLabel();
        lblM4.setIcon(new ImageIcon("C:\\Users\\DELL\\Documents\\FichierDezipper\\exemple_calc.ods\\Thumbnails\\thumbnail.png"));
        pnlM.add(lblM4);
        
        frmM.setContentPane(pnlM);
        frmM.setVisible(true);
        frmM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
