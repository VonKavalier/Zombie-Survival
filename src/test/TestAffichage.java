package test;

import jeu.Affichage;
import jeu.Horde;
import jeu.Joueur;

public class TestAffichage {
	
	public static void main (String[] args){
		Joueur j = new Joueur("test", new Horde());
		j.setJours(3);
		Affichage affichage = new Affichage(j, new Horde());
		
		affichage.afficherHistoire();
		System.out.println();
		affichage.afficherMenuPrincipal();
		System.out.println();
		affichage.afficherObjectif();
		System.out.println();
		System.out.println(j.getLieu());
		System.out.println();
		affichage.afficherMenuJoueur();
		
		
		
		
		
	}
	
}
