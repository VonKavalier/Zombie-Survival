package jeu;

public enum Lieu {
	
	// La liste de tous les lieux, non exhaustive 
	
	CABANE ("une cabane délabrée"),
	MAISON ("une maison abandonnée"),
	EGOUTS ("les égouts de la ville"),
	CINEMA ("un cinéma morbide"),
	TOILETTES ("des toilettes publiques"),
	AVION ("une carcasse d'avion"),
	HALL ("un hall d'immeuble sombre"),
	SPORT ("une salle de sport désaffectée"),
	CYBERCAFE ("un cybercafé détruit"),
	CRECHE ("une crèche en piteux état"),
	BOULANGERIE ("une boulangerie insalubre"),
	HANGAR ("un hangar désaffecté"),
	BUS ("un bus retourné"),
	ROULOTTE ("une ancienne roulotte de forain"),
	CAVE ("une cave moisie"),
	BOUTIQUE ("une boutique d'habits"),
	GYMNASE ("un gymnase vide"),
	STUDIO ("un studio d'enregistrement délaissé"),
	ATELIER ("un atelier de peinture décrépi"),
	HOTEL ("une chambre d'hôtel vide");
	
	
	private String name = "";
	
	public static Lieu getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
		   
	//Constructeur
	Lieu(String name){
		this.name = name;
	}
		   
	public String toString(){
		return name;
	}
}
