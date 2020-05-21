package gestiondesEtudes;

public class PvDeDélibération {
	protected Classe p;
	
	public PvDeDélibération(Classe p) {
		this.p = p;
	}
	
	public void générerPV() {
		System.out.println("\nPV de délibération de la promotion " + p.toString() + " :");
		for (Student e : p.stud) {
			System.out.println(e.miniPV());
		}
	}
}
