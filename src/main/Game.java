package main;

import java.util.Scanner;

import jeu.Affichage;
import jeu.Horde;
import jeu.Joueur;


public class Game {
	
	Joueur j;
	Horde h;
	Affichage a;
	
	public Game(){
		this.a = null;
		this.h = null;
		this.j = null;
		
	}
	
	public void deroulement (){
		int choixJour;
		int choixNuit;
		boolean flag=true;
		Scanner s = new Scanner(System.in) ;

		do{
			System.out.println("\nLa journée commence, que décidez vous de faire ?");
			while(flag){
				System.out.println("1- Explorer pour trouver des ressources ?");
				System.out.println("2- Réduire la horde de zombies");
				System.out.println("3- Voir ses infos (Ne fait pas avancer la journée)");
				choixJour = s.nextInt();
				
				if (choixJour == 1){
					this.j.explorer();
					flag = false;
				}else if(choixJour == 2){
					this.j.reduireHorde();
					flag=false;
				}else{
					this.a.afficherMenuJoueur();
					flag=true;
				}
			}
			a.afficherMenuJoueur();
			flag = true;
			
			System.out.println("\nLe soir arrive, que décidez vous de faire ?");
			while(flag){
				System.out.println("1- Changer d'abri");
				System.out.println("2- Rester dans l'abri");
				System.out.println("3- Voir ses infos (Ne fais pas avancer la journée)");
				choixNuit = s.nextInt();
				
				if (choixNuit == 1){
					this.j.changerLieu();
					flag = false;
				}else if (choixNuit == 2){
					this.j.resterDansAbri();
					flag = false;
				}else{
					this.a.afficherMenuJoueur();
					flag = true;
				}
			}
			flag=true;
		}while(this.j.finJeu());
	}
	
	public void lancementPartie(){
		
		int choixMenu;
		String nomJoueur;
		this.h = new Horde();
		this.a = new Affichage(new Joueur("faux", new Horde()), new Horde());
		a.afficherMenuPrincipal();
		
		Scanner s = new Scanner(System.in) ;
		choixMenu = s.nextInt() ;
		
		if (choixMenu == 1){
			a.afficherHistoire();
			System.out.println();
			System.out.print("Choisissez votre nom de survivant :");
			nomJoueur = s.next();
			
			this.j = new Joueur(nomJoueur, h);
			a = new Affichage(j, h);
			
			a.afficherMenuJoueur();
			
			this.deroulement();
		}else if(choixMenu == 2){
			System.out.println("Accessible dans une prochaine version");
			lancementPartie();
		}else if(choixMenu == 3){
			a.afficherCommentJouer();
			lancementPartie();
		}else{
			System.out.print("Le programme quitte");
			System.exit(0);
		}
		s.close();
		
	}
	
	public static void main (String[] args){
		
		Game partie = new Game();
		
		partie.lancementPartie();
		
	
	}
	
}

