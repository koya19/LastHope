package gestiondesEtudes;


public class Responsable extends Personne {
	protected Filiere filière;
	protected String pwd;
	
	public Responsable () {
		super();
	}
public Responsable(String lastnamePers, String firstnamePers, String cniPers,Filiere filière,String pwd) {
		super(lastnamePers, firstnamePers,cniPers);
		this.filière=filière;
		this.pwd=pwd;
		filière.ecole.respoEcole.add(this);
		System.out.println("\nVous avez ajouté " +this.lastnamePers+" "+this.firstnamePers+" comme responsable de la filière "+filière.toString() );
	}
public Responsable(String lastnamePers, String firstnamePers,Filiere filière,String pwd) {
	super(lastnamePers, firstnamePers);
	this.filière=filière;
	this.pwd=pwd;
	//filière.ecole.respoEcole.add(this);
	}
	public Responsable (String a, String b) {
		super(a,b);

		
	} 
	
	public Filiere getFiliere() {
		return filière;
	}
	public boolean equals(Responsable responsable) {
		return this.firstnamePers.equals(responsable.firstnamePers)&& this.lastnamePers.equals(responsable.lastnamePers) && (this.filière.equals(responsable.filière));
	}
	 public boolean exist() {
			for (Responsable resp: filière.ecole.respoEcole) {
				if (resp.equals(this)) {
					return true;	
				}
				
			}
			 return false;
			
		}
	 public Responsable choisir(int a) {
		 int i=1;
		 Responsable responsable= new Responsable();
		 for (Responsable r: filière.ecole.respoEcole) {
			 if (i==a) {
				 responsable=r;
				 break;
			 }
			 else i++;
		 }
		 return responsable;
	 }
	 public boolean verificationPWD() {
			for (Responsable a :this.filière.ecole.respoEcole) {
				if (a.equals(this)) {
					if (a.pwd.equals(this.pwd)) {
						return true;
					}
						
					break;
				}
			}
			 return false;
		}
		
	
	

}
