package projet;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class testCal{
    public static int nbjour;
    static JFrame jf = new JFrame();
   static // JLable jl = new JLabel();
    JPanel jp = new JPanel();
    JButton jb = new JButton();
    
	public static void main(String args[]){
	String mois[] = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet",
					"Aout","Septembre","Octobre","Novembre","Décembre"};
	
	String jour[] = {"","Dimanche","Lundi" , "Mardi" ,
					"Mercredi" , "Jeudi","Vendredi","Samedi"};
	String jour1,mois1;
	int date , annee;
	
	Calendar cal =Calendar.getInstance();
	jour1=jour[2];
	date=cal.get(Calendar.DAY_OF_MONTH);
	mois1=mois[cal.get(Calendar.MONTH)];
	annee=cal.get(Calendar.YEAR);
	 nbjour = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    System.out.println(nbjour); // 30
    System.out.println(nbjour); // 30
    
    
    
    jf.setSize(new Dimension(500,500)); 
    jp.setLayout(new SpringLayout());
    Container contentPane = jf.getContentPane();
    contentPane.setLayout(new SpringLayout());
    
    for(int i=0 ;i<nbjour ; i++ ){
   
     contentPane.add(new JButton("KK"));
     SpringUtilities.makeCompactGrid(contentPane, 1,
             contentPane.getComponentCount(),
             1, 1, 1, 1);
    }

       
    jf.getContentPane().add(jp);
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
	System.out.println(""+jour1+""+date+""+mois1+""+annee);
	}
	
	public int getnbJour(){
		return nbjour;
	}
}
