package wisielec;

import java.util.ArrayList;

public class Main {
	
	

	
	public static void main(String[] args) {
		
		ArrayList<String> slowa = new ArrayList<String>();
		slowa.add("Kameleon");
		slowa.add("Marzanna");
		slowa.add("Helikopter");
		slowa.add("Filar");
		slowa.add("Szachownica");
		slowa.add("Kokos");
		slowa.add("Rower");
		slowa.add("Cytryna");
		slowa.add("Wulkan");
		slowa.add("Pudełko");
		
		
		System.out.println("Działam");
		
			try {
		Gui kek = new Gui(slowa);    } catch (Exception e) {e.printStackTrace();}
	
		
			
	}
	
	





}
