package gestiondesEtudes;


public class Responsable extends Personne {
	protected Filiere fili�re;
	protected String pwd;
	
	public Responsable () {
		super();
	}
public Responsable(String lastnamePers, String firstnamePers, String cniPers,Filiere fili�re,String pwd) {
		super(lastnamePers, firstnamePers,cniPers);
		this.fili�re=fili�re;
		this.pwd=pwd;
		fili�re.ecole.respoEcole.add(this);
		System.out.println("\nVous avez ajout� " +this.lastnamePers+" "+this.firstnamePers+" comme responsable de la fili�re "+fili�re.toString() );
	}
public Responsable(String lastnamePers, String firstnamePers,Filiere fili�re,String pwd) {
	super(lastnamePers, firstnamePers);
	this.fili�re=fili�re;
	this.pwd=pwd;
	//fili�re.ecole.respoEcole.add(this);
	}
	public Responsable (String a, String b) {
		super(a,b);

		
	} 
	
	public Filiere getFiliere() {
		return fili�re;
	}
	public boolean equals(Responsable responsable) {
		return this.firstnamePers.equals(responsable.firstnamePers)&& this.lastnamePers.equals(responsable.lastnamePers) && (this.fili�re.equals(responsable.fili�re));
	}
	 public boolean exist() {
			for (Responsable resp: fili�re.ecole.respoEcole) {
				if (resp.equals(this)) {
					return true;	
				}
				
			}
			 return false;
			
		}
	 public Responsable choisir(int a) {
		 int i=1;
		 Responsable responsable= new Responsable();
		 for (Responsable r: fili�re.ecole.respoEcole) {
			 if (i==a) {
				 responsable=r;
				 break;
			 }
			 else i++;
		 }
		 return responsable;
	 }
	 public boolean verificationPWD() {
			for (Responsable a :this.fili�re.ecole.respoEcole) {
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
