package gestiondesEtudes;

public class PvDeDélibération {
	protected Class p;
	
	public PvDeDélibération(Class p) {
		this.p = p;
	}
	
	public void générerPV() {
		System.out.println("\nPV de délibération de la promotion " + p.toString() + " :");
		for (Student e : p.stud) {
			System.out.println(e.miniPV());
		}
	}
}
