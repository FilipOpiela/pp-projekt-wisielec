package wisielec;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui_Staty extends JFrame{
	int w = Gui.wygrane;
	int l = Gui.przegrane;
	
	public Gui_Staty(){
		JFrame okno = new JFrame("Statystyki");
		JPanel panel = new JPanel(new java.awt.GridLayout(2, 2));
		
		JLabel wyg = new JLabel("Wygrane");
        JLabel prze = new JLabel("Przegrane");
        panel.add(wyg);
        panel.add(prze);
        
        
        JLabel wS = new JLabel(Integer.toString(w));
        JLabel lS = new JLabel(Integer.toString(l));
        panel.add(wS);
        panel.add(lS);
		
        okno.getContentPane().add(panel);
        okno.pack();
        okno.setVisible(true);
		

	}// koniec konstruktora
}// koniec klasy
