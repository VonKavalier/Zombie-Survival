package jeu;

public enum Etat {
	
	// La liste de tous les lieux, à continuer
	
	DEPRIME ("déprimé"),
	FATIGUE ("fatigué"),
	DOS ("mal au dos"),
	AMPOULES ("ampoules aux pieds"),
	PESSIMISTE ("pessimiste"),
	TRISTE ("triste"),
	SUICIDAIRE ("suicidaire"), // A travailler
	NOSTALGIQUE ("nostalgique");
	
	
	private String name = "";
	
	public static Etat getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
		   
	//Constructeur
	Etat(String name){
		this.name = name;
	}
		   
	public String toString(){
		return name;
	}
}
