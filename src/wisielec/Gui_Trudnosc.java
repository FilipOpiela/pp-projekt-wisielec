package wisielec;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui_Trudnosc {
	
	Gui_Trudnosc(ArrayList s){
		JFrame okno = new JFrame();
		okno.setTitle("Poziom trudnosci"); 							  
		okno.setPreferredSize(new Dimension(500,500));
		
		
		JButton latwy = new JButton("Łatwy");
		latwy.setPreferredSize(new Dimension(50,50));
		
		latwy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_Graj(s, "latwy");
				okno.dispose();}
			});
		
		JButton sredni = new JButton("Średni");
		sredni.setPreferredSize(new Dimension(50,50));
		
		sredni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_Graj(s, "sredni");
				okno.dispose();}
			});
		
		JButton trudny = new JButton("Trudny");
		trudny.setPreferredSize(new Dimension(50,50));
		
		trudny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_Graj(s, "trudny");
				okno.dispose();}
			});
		
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,20,20));  // ustawienia granicy - ramki
		panel.setLayout(new GridLayout(0,3));  							// elementy są ustawione na gridzie  
		
		panel.add(latwy, 0);
		panel.add(sredni, 1);
		panel.add(trudny, 2);
		
		okno.add(panel,BorderLayout.CENTER);							// dodanie panelu do okienka i określenie pozycji
		
		okno.pack();													// ustala rozmiar okna w oparciu o rozmiar i ilość elementów
		okno.setVisible(true);		
		
		
		
		
		
		
		
	} // koniec konstruktora
	

	
}// koniec klasy
