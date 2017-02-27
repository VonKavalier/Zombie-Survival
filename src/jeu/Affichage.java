package jeu;

public class Affichage {
	
	// C'est la classe qui sert à afficher des trucs :)

	private Joueur j;
	private Horde h;
	public static final int major = 0, minor = 1, patch = 0;
	public static final String version = major + "." + minor + "." + patch;
	
	public Affichage(Joueur j, Horde h) {
		this.j = j;
		this.h = h;
	}
	
	
	
	public Joueur getJoueur() {
		return j;
	}



	public void setJoueur(Joueur j) {
		this.j = j;
	}



	public Horde getHorde() {
		return h;
	}



	public void setHorde(Horde h) {
		this.h = h;
	}



	public void afficherMenuPrincipal(){
		System.out.println(" ,__, _,  , ,  __  ___,  _,       ");
		System.out.println("   / / \\,|\\/| '|_)' |   /_,       ");
		System.out.println("  /_'\\_/ | `| _|_) _|_,'\\_        ");                     
		System.out.println(" '  `'   '  `'    '       `       ");                    
		System.out.println("  _, ,  , ,_ ,   ,___,   ,_   ,   ");                   
		System.out.println(" (_, |  | |_)\\  /' | \\  /'|\\  |   ");                   
		System.out.println("  _)'\\__|'| \\ \\/` _|_,\\/` |-\\'|__ ");                   
		System.out.println(" '      ` '  `'  '    '   '  `  ' ");                   
		System.out.println("                                  ");        
		
		System.out.println("ver : "+version);
		System.out.println("");
		
		System.out.println("1) Commencer une nouvelle partie");
		System.out.println("2) Charger une partie");
		System.out.println("3) Comment jouer");
		System.out.println("4) Quitter");
	
		
	}
	public void afficherHistoire(){
		
		System.out.println("L'apocalypse zombie a commencé il y a de ça quelques jours.");
		System.out.println("Vous êtes un survivant, seul.");
		System.out.println("Vous avez réussi à vous retrancher dans "+ j.getLieu() +" avec de la nourriture et des munitions.");
		System.out.println("En vous réveillant dans ce lieu, vous apercevez une bouteille de poison, ainsi qu'une marque de piqûre sur votre bras droit.");
		System.out.println("Une note vous indique : \"Dans 20 jours le poison fera effet, dirige toi vers l'est si tu veux survivre. Signé: Un ami\"");
		System.out.println("Qui est cet ami ? Est-ce lui qui vous a empoisonné ? Vous devez obtenir des réponses.");
		System.out.println("En plus de cela, des zombies vous encerclent et se rapprochent chaque jours un peu plus.");
		
		afficherObjectif();
	}
	
	public void afficherObjectif(){
		System.out.println();
		System.out.println("Votre objectif dans cette aventure sera de rejoindre un camp de réfugiés situé à quelques lieux de là.");
		System.out.println("Vous devez y parvenir en moins de 20 jours, la date limite avant de succomber au poison.");
		System.out.println("Ainsi que de passez par 10 abris au cours de ces jours.");
		System.out.println("Bonne chance.");
	}
	
	public void afficherCommentJouer(){
		System.out.println("Le jeu se décompose en journées");
		System.out.println("");
		System.out.println("Chaque jours vous aurez le choix entre \"explorer\" ou vous attaquer à la horde pour la réduire");
		System.out.println("Chaque fin de journée vous aurez le choix entre rester dans l'abri ou changer");
		System.out.println("");
		System.out.println("Plus de détails en dessous");
		System.out.println("");
		System.out.println("-------EN JOURNEE-------");
		System.out.println("EXPLORATION");
		System.out.println("Vous partirez en vue de trouver des rations et des munitions");
		System.out.println("La quantité trouvée sera différente selon la distance et le nombre de zombies");
		System.out.println("Il y a une chance plus ou moins grande de tomber sur un zombie, il vous faudra vous décider à tirer ou fuir en perdant une ration");
		System.out.println("");
		System.out.println("REDUIRE LA HORDE");
		System.out.println("Votre but est d'aller attaquer la horde pour supprimer quelques zombies et rendre l'exploration plus simple et moins risquée");
		System.out.println("Vous ne manquerez jamais votre tir, cependant vous utiliserez toutes vos munitions disponibles");
		System.out.println("");
		System.out.println("");
		System.out.println("-------FIN DE JOURNEE-------");
		System.out.println("RESTER DANS L'ABRI");
		System.out.println("Les zombies vont se rapprocher d'une certaine distance chaque jours");
		System.out.println("D'autres zombies vont également se joindre à la horde");
		System.out.println("Une ration est consommée, il faut en préserver le plus possible");
		System.out.println("Vous passez à la journée suivante");
		System.out.println("");
		System.out.println("CHANGER D'ABRI");
		System.out.println("Possible seulement si vous possédez 2 rations");
		System.out.println("Le nombre de lieux visités augmente de 1");
		System.out.println("Vous passez également au jour suivant");
		System.out.println("Vous n'êtes pas sûr de réussir, ça dépend de la distance et de la taille de la horde");
		System.out.println("Si vous ratez, vous restez et perdez 2 ration en fuite en plus de celle pour vous nourrir ainsi qu'une partie de vos munitions pour aider votre retraite");
		System.out.println("Sinon");
		System.out.println("Vous utilisez une partie de vos munitions pour garantir votre fuite");
		System.out.println("Le voyage vous fait consommer 2 rations");
		System.out.println("Puisque vous changez de lieu la horde est plus loin mais plus nombreuse");
	}

	public void afficherMenuJoueur(){
		int joursActuel = this.j.getJours()+1;
		String apresJours;
		if(joursActuel == 1)
			apresJours = "er";
		else
			apresJours = "ème";
		
		System.out.println("|---------------VOUS-----------------|");
		System.out.println("");
		System.out.println("• "+this.j.getNom());
		System.out.println("• "+joursActuel+apresJours+" jour");
		System.out.println("• Etat : "+j.getEtat());
		System.out.println("");
		System.out.println("|---------------ABRI-----------------|");
		System.out.println("");
		System.out.println("• "+this.j.getLieu());
		System.out.println("");
		System.out.println("|---------------SURVIE---------------|");
		System.out.println("");
		System.out.println("• Rations : "+this.j.getRations());
		System.out.println("• Ammo : "+this.j.getAmmo());
		System.out.println("");
		System.out.println("|---------------HORDE----------------|");
		System.out.println("");
		System.out.println("• Distance de la horde : "+this.j.getHorde().getDistance()+"km");
		System.out.println("• Taille de la horde : "+this.j.getHorde().getNbZombies());
		System.out.println("");
		System.out.println("|---------------OBJECTIFS------------|");
		System.out.println("");
		System.out.println("• Lieux visités : "+this.j.getNbLieuxVisite()+"/10");
		System.out.println("• Jours passés: "+this.j.getJours()+"/20");
		System.out.println("");
		System.out.println("|------------------------------------|");
	}
	
	public void afficherResultatExploration(int r, int a){
		System.out.println("\nPendant votre exploration vous avez trouvé :");
		System.out.println("-rations : +"+r);
		System.out.println("-ammo : +"+a);
	}
	
	public void afficherResultatChangerLieu(int zombiesTues, int ammoRestante, Lieu lieu){
		System.out.println("\n-Zombies tués : "+zombiesTues);
		System.out.println("-Ammo restante : "+ammoRestante);
		System.out.println("-Nouveau lieu : "+lieu);
	}
	
	public void afficherPerdreExplo(){
		System.out.println("\nVous êtes mort durant votre exploration.");
		System.out.println("Fin du jeu");
	}
	
	public void afficherPerdreRations(){
		System.out.println("\nVous êtes mort car vous n'aviez plus assez de rations pour survivre la nuit");
		System.out.println("Fin du jeu");
	}
	
	public void afficherPerdreHorde(){
		System.out.println("\nVous êtes mort car la horde vous a rattrapé");
		System.out.println("Fin du jeu");
	}
	
	public void afficherPerdreObjectifs(){
		System.out.println("\nLes 20 jours se sont écoulés et vous n'avez pas trouvé le repaire de survivants");
		System.out.println("Fin du jeu");
	}
	
}
