package gestiondesEtudes;


public class Respo extends Personne {
	protected Filiere filière;
	protected String pwd;
	
	public Respo () {
		super();
	}
public Respo(String lastnamePers, String firstnamePers, String cniPers,Filiere filière,String pwd) {
		super(lastnamePers, firstnamePers,cniPers);
		this.filière=filière;
		this.pwd=pwd;
		filière.ecole.respoEcole.add(this);
		System.out.println("\nVous avez ajouté " +this.lastnamePers+" "+this.firstnamePers+" comme responsable de la filière "+filière.toString() );
	}
public Respo(String lastnamePers, String firstnamePers,Filiere filière,String pwd) {
	super(lastnamePers, firstnamePers);
	this.filière=filière;
	this.pwd=pwd;
	//filière.ecole.respoEcole.add(this);
	}
	public Respo (String a, String b) {
		super(a,b);

		
	} 
	
	public Filiere getFiliere() {
		return filière;
	}
	public boolean equals(Respo respo) {
		return this.firstnamePers.equals(respo.firstnamePers)&& this.lastnamePers.equals(respo.lastnamePers) && (this.filière.equals(respo.filière));
	}
	 public boolean exist() {
			for (Respo resp: filière.ecole.respoEcole) {
				if (resp.equals(this)) {
					return true;	
				}
				
			}
			 return false;
			
		}
	 public Respo choisir(int a) {
		 int i=1;
		 Respo respo= new Respo();
		 for (Respo r: filière.ecole.respoEcole) {
			 if (i==a) {
				 respo=r;
				 break;
			 }
			 else i++;
		 }
		 return respo;
	 }
	 public boolean verificationPWD() {
			for (Respo a :this.filière.ecole.respoEcole) {
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
