package com.github.eifellovkas.Ukol1.logika;

public class Slovo {
	private String nazevEn; 
	private String nazevCz;
	private String URL;
	
	public Slovo(String nazevEn, String nazevCz, String URL){
		this.nazevEn = nazevEn;
		this.nazevCz = nazevCz;
		this.URL = URL;
	}
	
	public String getNazevEn() {
		return nazevEn;
	}
	
	public String getNazevCz() {
		return nazevCz;
	}
	
	public String getURL() {
		return this.URL;
	}
}
