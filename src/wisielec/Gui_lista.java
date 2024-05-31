package wisielec;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Gui_lista extends Gui{
	
	private ArrayList lista1;
	public ArrayList<String> arrayList = new ArrayList<>();

	public  Gui_lista(ArrayList s) {
		super(s);
		this.lista1 = s;
		
		
		 DefaultListModel<String> listModel = new DefaultListModel<>();
		   
		   
	        for (int i = 0; i < lista1.size(); i++) {
	        	String tymczas = (String) lista1.get(i);
	            listModel.addElement(tymczas);
	            System.out.println(tymczas);
	        }
	        
	 
	        JList<String> lista = new JList<>(listModel);
	        JScrollPane scroll = new JScrollPane(lista);
	        
	        GridBagConstraints scrollWlasciwosci = new GridBagConstraints();
	        scrollWlasciwosci.gridx = 0;
	        scrollWlasciwosci.gridy = 0;
	        
	        
	        scroll.setPreferredSize(new Dimension(150,200));
	        
	        
		
	        GridBagConstraints textWlasciwosci = new GridBagConstraints();
	        textWlasciwosci.gridx = 0; 											//pozycja na siatce działa podobnie jak array 2d 
	        textWlasciwosci.gridy = 1;  
	        textWlasciwosci.fill = GridBagConstraints.HORIZONTAL; 
	        textWlasciwosci.insets = new Insets(5, 5, 5, 5); 				//margines
	       
	  
	        
	       
	        
	        JButton przycisk = new JButton("Dodaj");
	        
	        GridBagConstraints przyciskWlasciwosci = new GridBagConstraints();
	        przyciskWlasciwosci.gridx = 1; 
	        przyciskWlasciwosci.gridy = 1; 
	        przyciskWlasciwosci.fill = GridBagConstraints.HORIZONTAL; 
	        przyciskWlasciwosci.insets = new Insets(5, 5, 5, 5); 
	        
	        GridBagConstraints przycis2kWlasciwosci = new GridBagConstraints();
	        przycis2kWlasciwosci.gridx = 2; 
	        przycis2kWlasciwosci.gridy = 1; 
	        przycis2kWlasciwosci.fill = GridBagConstraints.HORIZONTAL; 
	        przycis2kWlasciwosci.insets = new Insets(5, 5, 5, 5); 
	        
	       JButton przycisk3 = new JButton("zapisz");
	       przycisk3.addActionListener(new ActionListener() {
	    	   @Override
				public void actionPerformed(ActionEvent e) {
					oddajListe(listModel);
				}
				   
			   });
	       
	  
	       
	       GridBagConstraints przycisk3Wlasciwosci = new GridBagConstraints();
	       przycisk3Wlasciwosci.gridx = 2; 
	       przycisk3Wlasciwosci.gridy = 2; 
	       przycisk3Wlasciwosci.fill = GridBagConstraints.HORIZONTAL; 
	       przycisk3Wlasciwosci.insets = new Insets(5, 5, 5, 5); 
	       
	        
	     
	        
	        
	        JTextField poletekst = new JTextField("Wpisz słowo a następnie wybierz czy chcesz\ndodać je do listy czy usunąć");
	        GridBagConstraints poletekstWlasciwosci = new GridBagConstraints();
	        poletekstWlasciwosci.gridx = 0;
	        poletekstWlasciwosci.gridy = 2;
	        
	        
	        
	        
		
		JFrame oknoLista = new JFrame("Lista słów");
	
		
		oknoLista.setSize(800, 800);
		
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(100,20));
		
		
		
		
		   przycisk.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent d) {
					listModel.addElement(text.getText());		
				}
	        	});
		   
		   JButton przycisk2 = new JButton("Usuń");
		   przycisk2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = listModel.indexOf( text.getText());
				listModel.remove(index);
				
			}
			   
		   });

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,20,20));  
		panel.setLayout(new GridBagLayout());  	
		panel.add(scroll, scrollWlasciwosci);
		panel.add(text,textWlasciwosci);
		panel.add(przycisk, przyciskWlasciwosci);
		panel.add(przycisk2, przycis2kWlasciwosci);
		panel.add(poletekst,poletekstWlasciwosci);
		panel.add(przycisk3,przycisk3Wlasciwosci);
		
		
		oknoLista.add(panel);
		oknoLista.setVisible(true);
		
		
		}
	
	
	
	public void oddajListe(DefaultListModel<String> listModel) {
		   
	        for (int i = 0; i < listModel.getSize(); i++) {
	            arrayList.add(listModel.getElementAt(i));
	        }
	        Gui.s1 = arrayList;
	}
	
}
