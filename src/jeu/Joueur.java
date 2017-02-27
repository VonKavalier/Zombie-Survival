package jeu;

public class Joueur {
	
	// �a c'est toi et tout ce que tu peux faire
	
	private int rations; // La nourriture
	private int ammo; // Les munitions
	private String nom; // Ton nom de perso
	private Lieu lieu; // L'abri actuel
	private Horde horde; // La horde qui t'encercle
	private int nbLieuxVisite; // Le nombre de lieux visit�s (objectif)
	private int jours; // Le nombre de jours pass�s
	private Affichage affichage;
	private Etat etat;
	
	public Joueur(String nom, Horde horde) {
		this.rations = 4;
		this.ammo = 3;
		this.nom = nom;
		this.lieu = Lieu.getRandom();
		this.nbLieuxVisite = 1;
		this.jours = 0;
		this.horde = horde;
		this.etat = Etat.getRandom();
	}

	public int getRations() {
		return rations;
	}

	public void setRations(int rations) {
		this.rations = rations;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammu) {
		this.ammo = ammu;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	
	public Horde getHorde() {
		return horde;
	}

	public void setHorde(Horde horde) {
		this.horde = horde;
	}

	public int getNbLieuxVisite() {
		return nbLieuxVisite;
	}

	public void setNbLieuxVisite(int nbLieuxVisite) {
		this.nbLieuxVisite = nbLieuxVisite;
	}

	public int getJours() {
		return jours;
	}

	public void setJours(int jours) {
		this.jours = jours;
	}
	
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	
	public void explorer(){ // Faire (une chance/la taille de la horde) de tomber sur un zombie et choix tirer ou s'enfuir + perdre 1 ration
		int rationsTrouvees = 0;
		int ammuTrouvees = 0;
		int idDistance;
		int idNbZombies;
		int NbZombiesRencontres = 0;
		
		// On attribue des indices en fonction de la distance pour faire les tests avec la taille de la horde
		if(this.horde.getDistance()<3)
			idDistance = 1;
		else if(this.horde.getDistance()>=3 && this.horde.getDistance()<5)
			idDistance = 2;
		else
			idDistance = 3;
		
		// On attribue des indices en fonction de la taille de la horde
		if(this.horde.getNbZombies()<=2)
			idNbZombies = 1;
		else if(this.horde.getNbZombies()>2 && this.horde.getNbZombies()<=5)
			idNbZombies = 2;
		else
			idNbZombies = 3;
		
		// Le nombre de zombies aura plus d'importance que la distance (pas encore fini)
		
		if(idDistance == 1 && idNbZombies == 1){ // Proche et peu
			if (alea(this.horde.getDistance(),this.horde.getNbZombies()+1)!=this.horde.getDistance()+1){
				rationsTrouvees = alea(0,horde.getNbZombies());
				ammuTrouvees = alea(0,horde.getNbZombies()); // Entre 1 et 2 munitions trouv�es
				this.setRations(this.getRations()+rationsTrouvees);
				this.setAmmo(this.getAmmo()+ammuTrouvees);
			}
			else if(this.getAmmo()>0){
				System.out.println("Vous venez de tomber sur un zombie pendant votre exploration.");
				System.out.println("Afin de vous en sortir vous lui avez tiré une balle dans la tête et");
				System.out.println("Vous êtes enfui direction votre abri sans pouvoir ramener quoi que ce soit.");
			}else{
				System.out.println("Vous n'aviez plus assez de munitions pour vous défendre");
				perdu(1);
			}
		}		
		
		if(this.getRations()-rationsTrouvees <= 0){
			perdu(2);
		}else{
			this.affichage = new Affichage(new Joueur("Nom", this.horde), this.horde); // Ouais cette ligne est d�gueu
			affichage.afficherResultatExploration(rationsTrouvees, ammuTrouvees);
		}
	}
	
	public void reduireHorde(){
		System.out.println("pas implémenté");
	}

	public void changerLieu(){
		int zombiesASupp=0;
		if(alea(0,(horde.getNbZombies())/2)==1 || alea(0,(horde.getNbZombies())/2)==2 || alea(0,(horde.getNbZombies())/2)==3 && this.getRations()>=2){
			while(this.ammo >= this.horde.getNbZombies()/4){
				this.horde.setNbZombies(this.horde.getNbZombies()-1);
				this.setAmmo(this.getAmmo()-1);
				zombiesASupp++;
			}
			this.horde.supprimerZombie(zombiesASupp);
			this.setLieu(Lieu.getRandom()); // On change de lieu
			this.setEtat(Etat.getRandom()); // On change d'�tat
			this.setRations(this.getRations()-2); // On perd 2 de nourriture � cause du voyage
			this.setJours(this.getJours()+1); // On passe au jours suivant
			this.setNbLieuxVisite(this.getNbLieuxVisite()+1); // Et on visite un lieu en plus
			this.horde.nouvelleTailleHorde(); // On r�initialise le nombre de zombies
			this.horde.nouvelleDistanceHorde(); // On r�initialise leur distance
			
			this.affichage = new Affichage(this, this.horde);
			this.affichage.afficherResultatChangerLieu(zombiesASupp, this.getAmmo(), this.getLieu());
			
		}else if(alea(0,horde.getNbZombies()/2) != 1 && alea(0,horde.getNbZombies()/2) !=2 && alea(0,horde.getNbZombies()/2) !=3){
			this.resterDansAbri();
			this.setRations(this.getRations()-2); // Perdu dans la retraite
			this.setAmmo(this.getAmmo()-(this.horde.getNbZombies()/2));// On perd l'�quivalent d'un tier de la horde en ammo
		
		}else{
			System.out.println("Pas assez de rations pour le voyage !");
			System.out.println("Vous devez passez une nuit et une journée de plus ici...");
			resterDansAbri();
		}
	}
	
	public void resterDansAbri(){
		this.horde.setDistance(this.horde.getDistance()-this.alea(1, 3)); // Les zombies se rapprochent entre 1 et 3
		this.horde.setNbZombies(this.horde.getNbZombies()+this.alea(1,5)); // Les zombies augmentent entre 1 et 5
		this.setRations(this.getRations()-1); // On passe la nuit et on mange une ration
		this.setJours(this.getJours()+1); // On passe au jours suivant
		this.setEtat(Etat.getRandom()); // On change d'�tat
		
	}
	
	public int alea(int min, int max){
		return (int) (min + (Math.random() * (max - min))); // Retourne un nombre al�atoire entre min et max non compris
	}
	
	public void journee(){
		
	}
	
	public boolean finJeu(){ // Quand on gagne l'�tat est am�lior�
		boolean b=false;
		
		if (this.getRations()<0) // On perd si pas de bouffe, horde sur nous, objectifs non remplis
			return (perdu(2));
		else if(this.horde.getDistance() <=0)
			return perdu(3);
		else if (this.getJours() >= 20 && this.getNbLieuxVisite()<1)
			return perdu(4);
		else  // On gagne si objectifs remplis
			b=true;
		
		return b;
	}
	
	// 1- explo
	// 2- plus de nourriture
	// 3- horde arrivée
	// 4- objectifs non remplis
	public boolean perdu(int cause){
		if (cause == 1){
			this.affichage.afficherPerdreExplo();
		}
		else if (cause == 2){
			this.affichage.afficherPerdreRations();
		}
		else if (cause == 3){
			this.affichage.afficherPerdreHorde();
		}
		else if(cause == 4){
			this.affichage.afficherPerdreObjectifs();
		}
		return false;
	}
	
}
