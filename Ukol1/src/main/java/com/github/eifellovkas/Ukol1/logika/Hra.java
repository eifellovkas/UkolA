package com.github.eifellovkas.Ukol1.logika;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.eifellovkas.Ukol1.logika.Slovo;

public class Hra {
	private boolean konecHry = false;
	private List<Slovo> slovicka;
	private String hadane;
	private int dobre = 0;
	private int spatne = 0;
		
	
	public Hra() {
		slovicka = new ArrayList<Slovo>();
		Slovo bull = new Slovo("bull", "býk", "/com/github/eifellovkas/ui/bull.png");
		slovicka.add(bull);
		Slovo elephant = new Slovo("elephant", "slon", "/com/github/eifellovkas/ui/elephant.png");
		slovicka.add(elephant);
		Slovo dog = new Slovo("dog", "pes", "/com/github/eifellovkas/ui/dog.png");
		slovicka.add(dog);
		Slovo owl = new Slovo("owl", "sova", "/com/github/eifellovkas/ui/owl.png");
		slovicka.add(owl);
		Slovo fox = new Slovo("fox", "liška", "/com/github/eifellovkas/ui/fox.png");
		slovicka.add(fox);
		Slovo pig = new Slovo("pig", "prasátko", "/com/github/eifellovkas/ui/pig.png");
		slovicka.add(pig);
		
		
		
	}
	public List<Slovo> getSlovicka(){
		return slovicka;
	}
	
    public boolean konecHry() {
        return konecHry;
    }
    
    public void vyberSlovo() {
    	Random nahodneSlovo = new Random();
    	hadane = slovicka.get(nahodneSlovo.nextInt(slovicka.size())).getNazevEn();
    }
    public String getHadane() {
    	return hadane;
    }
    
    public int getDobre(){
    	return dobre;
    }
    public int getSpatne() {
    	return spatne;
    	
    }
    public boolean trefa(String slovo) {
    	if (slovo.equals(hadane)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public void setSkore(String slovo) {
    	if (trefa(slovo))  {
    		dobre = dobre + 1;
    	}
    	else
    	{
    		spatne = spatne + 1;
    	}
    }
}
