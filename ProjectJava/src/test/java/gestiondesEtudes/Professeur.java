package gestiondesEtudes;
import gestiondeScolarité.Element;
import gestiondeScolarité.Module;

import java.util.Set;


public class Professeur extends Personne{
	protected final String profession ="Professeur";
	protected Element element;
	protected Module module;


	//----------------------------------GETTERS & SETTERS--------------------------------------------------------------
		
	public Professeur () {
		super();
		
		
	}
	public Professeur (String a, String b,String pwd) {
		super(a,b);
		this.pwd=pwd;
		}
	public Professeur(String nom) {
		this.lastnamePers=nom;
		System.out.println("\nCréation du prof "+ this.toString());
	}
	public Element getElement() {
		return element;
	}
	public void setElement(Element element) {
		this.element = element;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	public Professeur (String lastnamePers, String firstnamePers, String cniPers,String pwd,Element e) {
		super (lastnamePers, firstnamePers,cniPers);
		this.pwd=pwd;
		this.element=e;
		this.module=e.getModule();

		if (this.exist(module.profClass)==false) {
			module.profClass.add(this);
			
			
		}
		
	}
	
	public boolean exist(Set<Professeur> list) {
		for (Professeur p: list) {
			if (p.equals(this)) {
				return true;
				
			}
			
			
		}
		 return false;
	}
	

}
