package gestiondesEtudes;
import java.util.*;

public class Promo {
	protected int nPromo;
	protected Set<Class> classPromo= new HashSet<>();
	protected Set <Student>studPromo=new TreeSet<>();
	
	public Promo () {
		nPromo=0;
		
	}
	public Promo (int a) {
		nPromo=a;
		
	}
	
	public Promo(Filiere filiere,int b) {
		nPromo=b;
		
		filiere.promoFiliere.add(this);
		
	}
	//------------------------------------------------------------------------
	
	public String toString() {
		return " " + nPromo + " ";
	}
	
	//------------------------------------------------------------------------
	 
	 
	 @SuppressWarnings("rawtypes")
	public void afficheClassPromo() {
		 Iterator iterator = classPromo.iterator();
		 System.out.println("\nLes étudiants de la classe "  + this.toString());	
		 while (iterator.hasNext()){
				System.out.println( iterator.next() );
			}
	 }
	 
	 @SuppressWarnings("rawtypes")
	public void afficheStudPromo() {
		 Iterator iterator = studPromo.iterator();
		 System.out.println("\nLes étudiants de la promotion "  + this.toString());	
		 while (iterator.hasNext()){
	         System.out.println(iterator.next());
		 }	 
	 }

}
