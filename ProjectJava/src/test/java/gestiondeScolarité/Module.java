package gestiondeScolarité;
import gestiondesEtudes.Class;
import gestiondesEtudes.Prof;
import gestiondesEtudes.Student;
import java.util.*;

public class Module {
	public String nomModule;
	public Class cl;
	protected int heureModule;
	protected Set<Element> eleModule=new HashSet<>();
	public Map<Student,Double> noteModule= new TreeMap<>();
	protected Map<Student,String> validModule= new TreeMap<>();
	protected Map<Element,Integer> heureElement= new HashMap<>();
	Scanner sc=new Scanner(System.in);
	 String Newligne=System.getProperty("line.separator");
	public Set <Prof> profClass= new HashSet<>();
	
	
	@SuppressWarnings("rawtypes")
	public Module(String nomModule,Class cl) {
		this.nomModule=nomModule;
		this.cl=cl;
		this.cl.moduleClass.add(this);
		
		
		Iterator iterator = this.cl.getStud().iterator();
		 while (iterator.hasNext()){
	         noteModule.put((Student)iterator.next(),0.0);
		 }
		this.notemodulestud();
		 
		 for(Element e : eleModule) {
			 heureElement.put(e,e.totalheure);
		 }
		
	}
	
	public void tauxDeValidation() {
		int v = 0;
		int nv = 0;
		for (Student s : cl.getStud()) {
			if (validModule.get(s)=="Validé") {
				v++;
			}
			else if (validModule.get(s)=="Non Validé") {
				nv++;
			}
			else {
				continue;
			}
		}
		float tv = (float)v*100/(v+nv);
		float tnv = (float)nv*100/(v+nv);
		if ((v+nv) != 0) {
			System.out.println("Le pourcentage d'étudiants ayant validé ce module est : " + tv +"%");
			System.out.println("Le pourcentage d'étudiants n'ayant pas pu valider ce module est : " + tnv +"%");
		}
		else {
			System.out.println("Pas de données pour le moment.");
		}
	}
	
	public void notemodulestud() {
		int total=0;
		int i=0;
		String valider;
		
		for (Student s:this.cl.getStud()) {
			total=0;
			i=0;
			valider="Validé";
			for (Element element: this.eleModule) {
				if (element.noteElement.get(s)!=-1) {
					total+=element.noteElement.get(s);
					i++;
					if(element.noteElement.get(s)<6) {
						valider="Non Validé";
						s.setNbrModuleNV(s.getNbrTotalAbsence()+1);
					}
					
				}
				System.out.println(total);
				 double moy=(float)total/i;
				 System.out.println(moy);
				 this.noteModule.put(s, moy);
			    this.validModule.put(s,valider);	
			    if(s.getAnneePromo()==1) {
			    	s.setNotes(this,moy);
			    }
			    if(s.getAnneePromo()==2) {
			    	s.setNotes2(this, moy);
			    }
			    if(s.getAnneePromo()==3) {
	
			    }
			    
			}
			
			
		
		}
		
		tauxDeValidation();
			 
	}
	public void affichenoteModuletud(Student s) {
		System.out.print(s.toString()+"              ");
		for (int i=0;i<20-s.toString().length();i++) {
			
			System.out.print(" ");
			}
		for (Element e: this.eleModule) {
						
		           System.out.print(e.noteElement.get(s));
		           for(int i=0;i<20;i++) {
		        	   System.out.print(" ");
		           }
		        
		}
		
		System.out.println(+this.noteModule.get(s)+"               "+this.validModule.get(s));
		
	}
	public void affichenoteModuleClass() {
		System.out.print("Etudiant ");                        
		for (int i=0;i<20;i++) {
			System.out.print(" ");
		}
		
		System.out.println("Module "+this.toString());
		for (int i=0;i<32;i++) {
			System.out.print(" ");
		}
		int l=0;
		
		for (Element e:this.eleModule) {
			l+=e.nomElement.length();			
			
			System.out.print(e.nomElement);
			for (int i=0;i<20-l;i++) {
				System.out.print(" ");
			}
			
		}
		for (int i=0;i<21-l;i++) {
			System.out.print(" ");
		}
		System.out.println(" Moy.             Val.");
		for (Student s: cl.getStud()) {
			this.affichenoteModuletud(s);
		}
	}
	
	
	public void affichEleModule() {
		System.out.println("\nLes éléments du "+ this.toString()+Newligne);
		int i=1;
		for (Element e:eleModule) {
			System.out.println(i+"-"+e.nomElement);
			i++;
		}
	}
	public void addEleModule(Element element) {
		this.eleModule.add(element);
		this.setHeureModule() ;
		
	}
	public boolean testheuresElem() {
		
		if(this.heureModule==0) {
			return true;
		}
		else return false;
	}
	public void afficheheuresModule() {
		System.out.println("\nLe nombre d'heures total du module est : "+this.heureModule);
		
		for (Element e: this.eleModule) {
			e.afficherhours();
		}
	}
	public Element choisieElement(int a) {
		int i=1;
		 for (Element e : this.eleModule) {
			 if(i==a) {
				 return e;		
			 }
			 else i++;
		 }
		 return null;
	}
	@Override
	public String toString() {
		return "Module " + nomModule ;
	}

	public Set<Element> getEleModule() {
		return eleModule;
	}

	public void setEleModule(Set<Element> eleModule) {
		this.eleModule = eleModule;
	}
	public int getHeureModule() {
		return heureModule;
	}
	public void setHeureModule() {
		this.heureModule=0;
		 for(Element e : eleModule) {
				heureModule+=e.totalheure;
			 }
	}
	
	
	
}
