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

public class Gui implements ActionListener {
	
	public static int wygrane = 0;
	public static int przegrane = 0;
	public static  ArrayList<String> s1;
	
	

	JFrame okno = new JFrame();
	public Gui(ArrayList s) {
		
		this.s1 = s;
		
		
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //jeśli zamkniesz okno aplikacja się wyłączy
		okno.setTitle("wisielec"); 							  //tekst który wyświetla się na górnej ramce
		okno.setPreferredSize(new Dimension(500,500));
		
		
		JButton graj = new JButton("Graj");
		graj.setPreferredSize(new Dimension(50,50));
		
		graj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_Trudnosc(s1);
				}
			});
			
		
		
		JButton baza = new JButton("Baza słów");
		
		
		baza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_lista(s1);
				
			}
		});
		
		JButton staty = new JButton("Statystyki");
		staty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_Staty();
											
			}
		});
			
	
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,20,20));  // ustawienia granicy - ramki
		panel.setLayout(new GridLayout(1,1));  							// elementy są ustawione na gridzie  
		
		okno.add(panel,BorderLayout.CENTER);							// dodanie panelu do okienka i określenie pozycji
		panel.add(graj);
		
		panel.add(staty);
		
		panel.add(baza);
		okno.pack();													// ustala rozmiar okna w oparciu o rozmiar i ilość elementów
		okno.setVisible(true);											// okno będzie wyświetlane
		
	}
	
	public static void przegrana() {przegrane = przegrane + 1;}
	public static void wygrana()   {wygrane = wygrane + 1;}
	
	public void zapisz(ArrayList<String> list) {
		this.s1 = list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}}
