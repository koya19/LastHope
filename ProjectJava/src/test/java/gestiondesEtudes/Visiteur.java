package gestiondesEtudes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Visiteur extends Personne{
	protected Ecole e;
	
	Scanner sc = new Scanner(System.in);
	
	public Visiteur(Ecole e) {
		super();
		this.e = e;
		System.out.println("                        Bienvenue en mode Visiteur ! \n");
		gestionVisiteur();
	}
	public Visiteur(String a, String b, Ecole e) {
		super(a,b);
		this.e = e;
		System.out.println("                        Bienvenue en mode Visiteur ! \n");
		gestionVisiteur();
	}
	
	public void afficherEcole() {
		System.out.println(e.toString());
	}
	
	public void afficherFiliere() {
		e.affichefiliereEcole();
	}
	
	public void quitter() {
		sc.close();
	}
	
	public void gestionVisiteur() {
		int a=0;
		while(a!=3) {
		System.out.println("Choisissez votre prochaine action :\n 1) Afficher des informations sur l'école\n 2) Afficher les filières de l'école\n 3) Quitter");
		try {
		switch(sc.next()) {
		case "1" : e.afficherEcole(); gestionVisiteur(); break;
		case "2" : afficherFiliere(); gestionVisiteur(); break;
		case "3" : a=3; break;
		}
		}catch(InputMismatchException er) {//catch 1
			System.out.println();
			System.err.println("Ce choix est invalide\n");
			sc.nextLine();
		}
	}
}
}
