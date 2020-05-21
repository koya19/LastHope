package gestiondesEtudes;
import java.util.*;

public class Filiere implements Comparable<Filiere>{

protected String  nomFili�re;
protected Set <Promotion> promoFiliere =new HashSet<>();
protected Set <Classe> classFiliere= new HashSet<>();
protected Set <Student> studFiliere= new TreeSet<>();
public Set <Professeur> profFiliere =new HashSet<>();
protected Ecole ecole;
protected Responsable r= new Responsable ();
Scanner sc=new Scanner(System.in);
	
	public Filiere() {
		
	}
	
	public Filiere(String a,Ecole ecole) {
		nomFili�re= a;
		this.ecole=ecole;
		ecole.filiereEcole.add(this);
		System.out.println("\nVous avez cr�� la fili�re "+this.nomFili�re);
	}
//-----------------------------------------------------------------------------
	

	public String toString() {
		return  nomFili�re ;
	}
//-------------------------------------------------------------------------------
	public void removePromoFiliere (Promotion p) {
		 promoFiliere.remove(p);
	 }
	public void respoFiliere (Responsable a) {
		r=a;
		System.out.println("\nVous avez d�sign� "+ r +" comme responsable de fili�re "+this.toString());
	}
	public void addpromoFiliere(Promotion p) {
	
		promoFiliere.add(p);
	}
	@SuppressWarnings("rawtypes")
	public void afficheClassFiliere() {
			try {
		if (this.classFiliere.isEmpty()) {
			throw new NullPointerException("Pas de classe dans cette fili�re\n");
		}
		System.out.println("\nLes classes de la fili�re "  + this.toString());	
		 int i=1;
		 Iterator iterator = classFiliere.iterator();
		 while (iterator.hasNext()){
	         System.out.println(" "+i+"-"+iterator.next());
	         i++;
		}}catch(NullPointerException e) {
			System.out.println();
			System.err.println("Pas de classe dans cette fili�re\n");
		}
	}
 
	@SuppressWarnings("rawtypes")
	public void afficheStudFiliere() {
		 System.out.println("\nLes �tudiants de la fili�re "  + this.toString());	
		 int i=1;
		 Iterator iterator = studFiliere.iterator();
		 while (iterator.hasNext()){
	         System.out.println(" "+i+"-"+iterator.next());
		 }
		}
	@SuppressWarnings("rawtypes")
	public void affichePromoFiliere() {
		System.out.println("\nLes promotions de la fili�re "+ this.toString() );
		int i=1;
		Iterator iterator = promoFiliere.iterator();
		while(iterator.hasNext()) {
			System.out.println(" "+i+"-"+iterator.next());
			i++;
		}
		
	}
	public Classe choisirClassFilere() {
		Classe cl = new Classe ();
		int a=0;
		while (a==0) {
		System.out.println("\nChoisissez une classe :");
		this.afficheClassFiliere();
		try {
			int classchoisie=sc.nextInt();
		//	sc.nextLine();
			if (0>classchoisie ||  classchoisie>this.classFiliere.size()) {
				throw new InputMismatchException("Ce choix est invalide.")	;
			}
			int i=1;
			for (Classe c:this.classFiliere ) {
				if (i==classchoisie) {
					cl=c;
					break;
				}
				else i++;
			}
			break;
		
	}catch(InputMismatchException e) {
		System.out.println();
		System.err.println("Ce choix est invalide");
		sc.nextLine();
		
		
	}
	catch(NullPointerException e) {
		System.out.println();
		System.err.println("Pas de choix actuellement.");
		sc.nextLine();
		 
	}
		}
		return cl;
		}
		
		
		 
	
	public int compareTo(Filiere f) {
		
		 return this.nomFili�re.compareTo(f.nomFili�re) ;
	}
	public boolean equals(Filiere f) {
		return this.nomFili�re.equals(f.nomFili�re);
	}

	public String getNomFili�re() {
		return nomFili�re;
	}

	public void setNomFili�re(String nomFili�re) {
		this.nomFili�re = nomFili�re;
	}

	public Set<Promotion> getPromoFiliere() {
		return promoFiliere;
	}

	public void setPromoFiliere(Set<Promotion> promoFiliere) {
		this.promoFiliere = promoFiliere;
	}

	public Set<Classe> getClassFiliere() {
		return classFiliere;
	}

	public void setClassFiliere(Set<Classe> classFiliere) {
		this.classFiliere = classFiliere;
	}

	public Set<Student> getStudFiliere() {
		return studFiliere;
	}

	public void setStudFiliere(Set<Student> studFiliere) {
		this.studFiliere = studFiliere;
	}

	public Set<Professeur> getProfFiliere() {
		return profFiliere;
	}

	public void setProfFiliere(Set<Professeur> profFiliere) {
		this.profFiliere = profFiliere;
	}

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}

	public Responsable getR() {
		return r;
	}

	public void setR(Responsable r) {
		this.r = r;
	}

	
	@SuppressWarnings("unused")
	public void nbrProfParClass() {
		int i = 0;
		for (Classe c : classFiliere) {
			for (Professeur p : c.profClass) {
				i++;
			}
		}
		
		int m = i/(classFiliere.size());
		System.out.println("La moyenne de professeurs par classe est : " + m);
	}
	
	@SuppressWarnings("unused")
	public void nbrEtudParClass() {
		int i = 0;
		for (Classe c : classFiliere) {
			for (Student s : c.stud) {
				i++;
			}
		}
		
		int m = i/(classFiliere.size());
		System.out.println("La moyenne d'�tudiants par classe est : " + m);
	}
	

}
