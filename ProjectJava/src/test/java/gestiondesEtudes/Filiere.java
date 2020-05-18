package gestiondesEtudes;
import java.util.*;

public class Filiere implements Comparable<Filiere>{

protected String  nomFilière;
protected Set <Promo> promoFiliere =new HashSet<>();
protected Set <Class> classFiliere= new HashSet<>();
protected Set <Student> studFiliere= new TreeSet<>();
public Set <Prof> profFiliere =new HashSet<>();
protected Ecole ecole;
protected Respo r= new Respo ();
Scanner sc=new Scanner(System.in);
	
	public Filiere() {
		
	}
	
	public Filiere(String a,Ecole ecole) {
		nomFilière= a;
		this.ecole=ecole;
		ecole.filiereEcole.add(this);
		System.out.println("\nVous avez créé la filière "+this.nomFilière);
	}
//-----------------------------------------------------------------------------
	

	public String toString() {
		return  nomFilière ;
	}
//-------------------------------------------------------------------------------
	public void removePromoFiliere (Promo p) {
		 promoFiliere.remove(p);
	 }
	public void respoFiliere (Respo a) {
		r=a;
		System.out.println("\nVous avez désigné "+ r +" comme responsable de filière "+this.toString());
	}
	public void addpromoFiliere(Promo p) {
	
		promoFiliere.add(p);
	}
	@SuppressWarnings("rawtypes")
	public void afficheClassFiliere() {
			try {
		if (this.classFiliere.isEmpty()) {
			throw new NullPointerException("Pas de classe dans cette filière\n");
		}
		System.out.println("\nLes classes de la filière "  + this.toString());	
		 int i=1;
		 Iterator iterator = classFiliere.iterator();
		 while (iterator.hasNext()){
	         System.out.println(" "+i+"-"+iterator.next());
	         i++;
		}}catch(NullPointerException e) {
			System.out.println();
			System.err.println("Pas de classe dans cette filière\n");
		}
	}
 
	@SuppressWarnings("rawtypes")
	public void afficheStudFiliere() {
		 System.out.println("\nLes étudiants de la filière "  + this.toString());	
		 int i=1;
		 Iterator iterator = studFiliere.iterator();
		 while (iterator.hasNext()){
	         System.out.println(" "+i+"-"+iterator.next());
		 }
		}
	@SuppressWarnings("rawtypes")
	public void affichePromoFiliere() {
		System.out.println("\nLes promotions de la filière "+ this.toString() );
		int i=1;
		Iterator iterator = promoFiliere.iterator();
		while(iterator.hasNext()) {
			System.out.println(" "+i+"-"+iterator.next());
			i++;
		}
		
	}
	public Class choisirClassFilere() {
		Class cl = new Class ();
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
			for (Class c:this.classFiliere ) {
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
		
		 return this.nomFilière.compareTo(f.nomFilière) ;
	}
	public boolean equals(Filiere f) {
		return this.nomFilière.equals(f.nomFilière);
	}

	public String getNomFilière() {
		return nomFilière;
	}

	public void setNomFilière(String nomFilière) {
		this.nomFilière = nomFilière;
	}

	public Set<Promo> getPromoFiliere() {
		return promoFiliere;
	}

	public void setPromoFiliere(Set<Promo> promoFiliere) {
		this.promoFiliere = promoFiliere;
	}

	public Set<Class> getClassFiliere() {
		return classFiliere;
	}

	public void setClassFiliere(Set<Class> classFiliere) {
		this.classFiliere = classFiliere;
	}

	public Set<Student> getStudFiliere() {
		return studFiliere;
	}

	public void setStudFiliere(Set<Student> studFiliere) {
		this.studFiliere = studFiliere;
	}

	public Set<Prof> getProfFiliere() {
		return profFiliere;
	}

	public void setProfFiliere(Set<Prof> profFiliere) {
		this.profFiliere = profFiliere;
	}

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}

	public Respo getR() {
		return r;
	}

	public void setR(Respo r) {
		this.r = r;
	}

	
	@SuppressWarnings("unused")
	public void nbrProfParClass() {
		int i = 0;
		for (Class c : classFiliere) {
			for (Prof p : c.profClass) {
				i++;
			}
		}
		
		int m = i/(classFiliere.size());
		System.out.println("La moyenne de professeurs par classe est : " + m);
	}
	
	@SuppressWarnings("unused")
	public void nbrEtudParClass() {
		int i = 0;
		for (Class c : classFiliere) {
			for (Student s : c.stud) {
				i++;
			}
		}
		
		int m = i/(classFiliere.size());
		System.out.println("La moyenne d'étudiants par classe est : " + m);
	}
	

}
