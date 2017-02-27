package test;
import jeu.Lieu;

public class TestLieu {
	public static void main (String[] args){
		Lieu lieu = Lieu.getRandom();
		
//		System.out.println(Lieu.getRandom());
//		System.out.println(lieu);
		
		while(lieu!=Lieu.HOTEL){
			lieu = Lieu.getRandom();
			System.out.println("f");
		}
		System.out.println(lieu);
		
	}
}
