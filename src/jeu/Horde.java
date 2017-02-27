package jeu;


public class Horde { 
	
	// Ici on s'occupe des zombies
	
	private int distance;
	private int nbZombies;
	
	public Horde() {
		this.nbZombies = 5;
		this.distance = 7;
	}
	
	public int getNbZombies() {
		return nbZombies;
	}

	public void setNbZombies(int nbZombies) {
		this.nbZombies = nbZombies;
	}
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public void init(){
		this.setDistance(7);
		this.setNbZombies(5);
	}
	
	public int alea(int min, int max){
		return (int) (min + (Math.random() * (max - min))); // Retourne un nombre aléatoire entre min et max non compris
	}
	
	public void nouvelleTailleHorde(){
		this.setNbZombies(this.alea(1, 6));
	}
	
	public void nouvelleDistanceHorde(){
		this.setDistance(this.alea(5,9));
	}
	
	public void supprimerZombie(int nb){
		this.setNbZombies(this.getNbZombies()-nb);
	}
}
