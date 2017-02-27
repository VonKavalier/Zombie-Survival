package test;

import jeu.Horde;
import jeu.Joueur;

public class TestJoueur {
	public static void main (String[] args){
		
		Joueur j = new Joueur("Moi", new Horde());
		
		System.out.println(j.getLieu());
		System.out.println(j.getLieu());
		System.out.println("nb rations : "+j.getRations());
		j.changerLieu();
		System.out.println("***Changement de lieu***");
		System.out.println(j.getLieu());
		System.out.println("nb rations : "+j.getRations());
		
		
		System.out.println(j.alea(-1,3));
		
	}
}
