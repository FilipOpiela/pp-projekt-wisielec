package wisielec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Gui_Graj extends JFrame {
    private ArrayList<String> listaHasel;
    private String slowoDoOdgadniecia;
    private StringBuilder odgadnieteLitery;
    private JLabel labelOdgadnieteLitery;
    private JTextField poleTekstowe;
    
    int zycia = 6;
    int dmg = 1;

    public Gui_Graj(ArrayList<String> listaHasel, String t ) {
    	
    	if(t == "latwy") {zycia = 10;}
    	if(t == "trudny") {zycia = 4;}
    	
        this.listaHasel = listaHasel;
        losujHaslo();
        //System.out.println("wylosowane haslo to " + slowoDoOdgadniecia);

        setTitle("Wisielec");
        setSize(400, 200);
        setLocationRelativeTo(null);

     
        JPanel panelGorny = new JPanel();
        JPanel panelDolny = new JPanel();

      
        odgadnieteLitery = new StringBuilder(slowoDoOdgadniecia.length());
        for (int i = 0; i < slowoDoOdgadniecia.length(); i++) {
            odgadnieteLitery.append("-");				//zanim odgadne litery to są same "-" 
        }
        labelOdgadnieteLitery = new JLabel(odgadnieteLitery.toString());

      
        poleTekstowe = new JTextField(1);
        JButton przyciskSprawdz = new JButton("Sprawdź");

   
        panelGorny.add(labelOdgadnieteLitery);

       
        panelDolny.add(new JLabel("Podaj literę:"));
        panelDolny.add(poleTekstowe);
        panelDolny.add(przyciskSprawdz);

 
        add(panelGorny, BorderLayout.NORTH);
        add(panelDolny, BorderLayout.CENTER);

       
        przyciskSprawdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sprawdzLitere();
            }
        });
        setVisible(true);
    }// koniec konstruktora

    private void losujHaslo() {
        Random rand = new Random();
        slowoDoOdgadniecia = listaHasel.get(rand.nextInt(listaHasel.size()));
    }

    private void sprawdzLitere() {
        String litera = poleTekstowe.getText();
        char[] slowoArray = slowoDoOdgadniecia.toCharArray();
        boolean czyZgadniete = false;
        for (int i = 0; i < slowoArray.length; i++) {
            if (Character.toLowerCase(slowoArray[i]) == Character.toLowerCase(litera.charAt(0))) {
                odgadnieteLitery.setCharAt(i, slowoArray[i]);
                czyZgadniete = true;
            }
        }
        if (!czyZgadniete) {
        	zycia = zycia - dmg;
            JOptionPane.showMessageDialog(this, "Niepoprawna litera!\nPozostało " + zycia+ " żyć");
            if(zycia == 0) {Gui.przegrana();
            JOptionPane.showMessageDialog(this, "Przegrales");
            dispose(); }
            
        }
        labelOdgadnieteLitery.setText(odgadnieteLitery.toString());
        poleTekstowe.setText("");
        if (odgadnieteLitery.indexOf("-") == -1) {
            System.out.println("Nie ma już placeholderów gracz wygrał");
            Gui.wygrana();
            JOptionPane.showMessageDialog(this, "Odgadles cale slowo - Wygrywasz");
            dispose(); }

 
}
}// koniec klasy
