package gestiondesEtudes;

import java.util.HashSet;
import java.util.Set;

public class ConseilDeClasse {
	protected Set<Respo> equipe;
	protected Respo chef;
	protected Student e;
	
	protected static int nbrPassage = 0;
	protected static int nbrRedoublant = 0;
	
	public ConseilDeClasse(Respo chef, Student e) {
		this.equipe = new HashSet<>();
		this.chef = chef;
		this.e = e;
	}
	
	public String Décision() {
		if (e.getNbrModuleNV() <= 2) {
			e.setDecision("Passage");
			nbrPassage++;
			return "Passage";
		}
		else if (e.getNbrModuleNV() <= 4 && e.getNbrTotalAbsence() <= 8) {
			e.setDecision("Passage");
			nbrPassage++;
			return "Passage";
		}
		else {
			e.setDecision("Redoublement");
			nbrRedoublant++;
			return "Redoublement";
		}
	}
	
	public void statsReussite() {
		if(nbrPassage+nbrRedoublant != 0) {
			float tauxP = (nbrPassage*100)/(nbrPassage+nbrRedoublant);
			float tauxR = (nbrRedoublant*100)/(nbrPassage+nbrRedoublant);
			System.out.println("Le taux de personnes ayant terminé cette année avec succès est : "+ tauxP + "%");
			System.out.println("Le taux de personnes qui vont redoubler cette année est : "+ tauxR + "%");
		}
		else {
			System.out.println("Pas de données pour le moment.");
		}
	}
}
