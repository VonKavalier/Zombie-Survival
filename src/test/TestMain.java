package test;

import jeu.Affichage;
import jeu.Horde;
import jeu.Joueur;

public class TestMain {
	public static void main (String[] args){
		
		Horde h = new Horde();
		Joueur j = new Joueur("Tom", h);
		Affichage a = new Affichage(j,h);
		
		a.afficherMenuJoueur();
		
		System.out.println();
		System.out.println("********changement de lieu (-2 nourriture, lieu+1, jours+1)*********");
		
		j.changerLieu();
		a.afficherMenuJoueur();
		
		System.out.println();
		System.out.println("********rester dans abri (-1 nourriture, jours+1, z1-3, 1-5)*********");
		
		j.resterDansAbri();
		a.afficherMenuJoueur();
		
		System.out.println();
		System.out.println("********test explo*********");
		
		j.getHorde().setDistance(2);
		j.explorer();
		a.afficherMenuJoueur();
	}
}
