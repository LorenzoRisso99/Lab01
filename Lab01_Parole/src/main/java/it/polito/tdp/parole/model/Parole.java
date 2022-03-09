package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	private List<String> parole= new ArrayList<String>();
		
	public Parole() {
	}
	
	public void addParola(String p) {
		this.parole.add(p);
	}
	
	public List<String> getElenco() {
		List<String> lOrdinata = new LinkedList<String>(parole);
		Collections.sort(lOrdinata, new ComparatoreAlfabetico());
		return lOrdinata;
	}
	
	public void reset() {
		parole.clear();
	}

	public void cancellaParola(String s) {
		for(String ss : getElenco()) {
			if(ss.equals(s) == true) {
				parole.remove(ss);
			}
		}
	}
	
	

}
