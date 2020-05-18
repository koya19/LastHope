package gestiondesEtudes;



public abstract class Personne {
	protected String lastnamePers;
	protected String firstnamePers;
	protected String cniPers;
	protected String pwd;

	

	
	public Personne() {
		lastnamePers="";
		firstnamePers="";
		}
	public Personne(String a, String b) {
		lastnamePers=a;
		firstnamePers=b;
		}
	
	public Personne(String lastnamePers, String firstnamePers, String cniPer)  {
		
		this.lastnamePers = lastnamePers;
		this.firstnamePers = firstnamePers;
		this.cniPers = cniPer;
		
	
	}
	
	
	public String toString() {
		return   lastnamePers + " "+ firstnamePers ;
	}
	public boolean equals(Personne pers) {
		return (this.lastnamePers.equals(pers.lastnamePers)) && (this.firstnamePers.equals(pers.firstnamePers));
	}
	

}
