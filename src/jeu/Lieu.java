package jeu;

public enum Lieu {
	
	// La liste de tous les lieux, non exhaustive 
	
	CABANE ("une cabane d�labr�e"),
	MAISON ("une maison abandonn�e"),
	EGOUTS ("les �gouts de la ville"),
	CINEMA ("un cin�ma morbide"),
	TOILETTES ("des toilettes publiques"),
	AVION ("une carcasse d'avion"),
	HALL ("un hall d'immeuble sombre"),
	SPORT ("une salle de sport d�saffect�e"),
	CYBERCAFE ("un cybercaf� d�truit"),
	CRECHE ("une cr�che en piteux �tat"),
	BOULANGERIE ("une boulangerie insalubre"),
	HANGAR ("un hangar d�saffect�"),
	BUS ("un bus retourn�"),
	ROULOTTE ("une ancienne roulotte de forain"),
	CAVE ("une cave moisie"),
	BOUTIQUE ("une boutique d'habits"),
	GYMNASE ("un gymnase vide"),
	STUDIO ("un studio d'enregistrement d�laiss�"),
	ATELIER ("un atelier de peinture d�cr�pi"),
	HOTEL ("une chambre d'h�tel vide");
	
	
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
