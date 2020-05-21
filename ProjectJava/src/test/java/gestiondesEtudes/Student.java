
package gestiondesEtudes;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import gestiondeScolarité.Module;

public class Student  extends Personne implements Comparable<Student> {
	protected String mail;
	protected boolean paiement;
	protected String telephone;
	protected String CNE;
	protected String sexe;
	Date date = new Date();
	protected Classe c;
	protected Filiere filière;
	protected int anneePromo;
	protected String formation;
	protected String Decision;
	protected int nbrModuleNV;
	protected int NbrTotalAbsence;
	//protected final String profession="étudiant";
	protected Map<Module, Double> notes =new HashMap<>();
	protected Map<Module, Double> notes2 =new HashMap<>();
	protected Map<Module, Double> notes3=new HashMap<>();
	SimpleDateFormat s= new SimpleDateFormat("dd MM yyyy");
	
	//--------------------------------------------------------------------------------
	public Student () {
		super();
	}

	public Student (String a, String b,String pwd) {
		super(a,b);	
		this.pwd=pwd;
	}

	/*
public Student(Class c,String lastnamePers, String firstnamePers, String cniPers, char gender,
		Date date, String lieu) {
		super(lastnamePers, firstnamePers,cniPers,gender,date,lieu);
		this.c = c;
	}
	 */public Student(String nom, String prenom,Date date, String mail, String telephone, String CNE, int anneePromo,Filiere f) throws ParseException {
		 super(nom, prenom);
		 this.date=date;
		 this.mail=mail;
		 this.telephone=telephone;
		 this.CNE = CNE;
		 NbrTotalAbsence=0;
		 this.filière=f;
		 this.anneePromo = anneePromo;

	 }
	 public boolean verificationPWD() {
		 for (Student a :filière.studFiliere) {
			 if (a.equals(this)) {
				 if (a.pwd.equals(this.pwd)) {
					 return true;
				 }

				 break;
			 }
		 }
		 return false;
	 }
	 public boolean exist(Set <Student> list) {
		 for (Student stud: list) {
			 if (stud.equals(this)) {
				 return true;

			 }


		 }
		 return false;
	 }
	 //-------------------------------------------------------------------------------------------

	 public void afficherStudent() {
		 System.out.println("Nom complet : " + this.lastnamePers + " " + this.firstnamePers + "\n" + "Mail : " + mail + "\n" + "Téléphone : " + telephone + "\n" + "CNE : " + CNE + "\n" + "Filière : " + this.filière + "\n" + "Année promotion : " + anneePromo);

	 }
	 public String getFirstnameStud() {
		 return super.firstnamePers;
	 }

	 public void setFirstnameStud(String firstnameStud) {
		 this.firstnamePers = firstnameStud;
	 }

	 public String getLastnameStud() {
		 return lastnamePers;
	 }

	 public void setLastnameStud(String lastnameStud) {
		 this.lastnamePers = lastnameStud;
	 }

	 public Classe getC() {
		 return c;
	 }

	 public String getCNE() {
		 return CNE;
	 }

	 public void setCNE(String cNE) {
		 CNE = cNE;
	 }

	 public void setC(Classe c) {
		 this.c = c;
	 }
	 public String toString() {
		 return     lastnamePers + " " +firstnamePers ;
	 }

	 public int getAnneePromo() {
		 return anneePromo;
	 }

	 public void setAnneePromo(int anneePromo) {
		 this.anneePromo = anneePromo;
	 }

	 public Map<Module, Double> getNotes() {
		 return notes;
	 }

	 public void setNotes(Module m,Double a) {
		 this.notes.put(m, a);
	 }

	 public Map<Module, Double> getNotes2() {
		 return notes2;
	 }

	 public void setNotes2(Module m,Double a) {
		 this.notes2.put(m, a);
	 }

	 public Map<Module, Double>getNotes3() {
		 return notes3;
	 }

	 public void setNotes3(Module m,Double a) {
		 this.notes3.put(m, a);
	 }

	 public String getDecision() {
		 return Decision;
	 }

	 public void setDecision(String decision) {
		 Decision = decision;
	 }
	 


	 public int getNbrModuleNV() {
		 return nbrModuleNV;
	 }

	 public void setNbrModuleNV(int nbrModuleNV) {
		 this.nbrModuleNV = nbrModuleNV;
	 }

	 public int getNbrTotalAbsence() {
		 return NbrTotalAbsence;
	 }

	 public void setNbrTotalAbsence(int nbrTotalAbsence) {
		 NbrTotalAbsence = nbrTotalAbsence;
	 }
	 public Filiere getFiliere() {
		 return this.filière;
	 }

	 //-----------------------------------------------------------------------------------------------
	 public int compareTo(Student s)
	 {         
		 return this.lastnamePers.compareTo(s.lastnamePers) ;    //Sorts the objects in descending order
	 }

	 //-------------------------------------------------------------------------------------
	 public String miniPV() {
		 if (anneePromo == 1) {
			 return getCNE()+ " " + getLastnameStud() + " " + getFirstnameStud() + " " + moyenne1() + " " + getDecision();
		 }
		 else if (anneePromo == 2) {
			 return getCNE()+ " " + getLastnameStud() + " " + getFirstnameStud() + " " + moyenne2() + " " + getDecision();
		 }
		 else if (anneePromo == 3) {
			 return getCNE()+ " " + getLastnameStud() + " " + getFirstnameStud() + " " + moyenne3() + " " + getDecision();
		 }
		 else return "";
	 }

	 public float moyenne1() {
		 float f = 0;
		 int i = 0;
		 for (Module m : c.moduleClass) {
			 f += notes.get(m);
			 i++;
		 }
		 return (float)f/i;
	 }

	 public float moyenne2() {
		 float f = 0;
		 int i = 0;
		 for (Module m : c.moduleClass) {
			 f += notes2.get(m);
			 i++;
		 }
		 return (float)f/i;
	 }

	 public float moyenne3() {
		 float f = 0;
		 int i = 0;
		 for (Module m : c.moduleClass) {
			 f += notes3.get(m);
			 i++;
		 }
		 return (float)f/i;
	 }

	 public float moyenneDiplome() {
		 return (moyenne1()+moyenne2()+moyenne3())/3;
	 }

	 public String mentionDiplome() {
		 if (moyenneDiplome() < 11) {
			 return "Vous n'avez pas réussi";
		 }
		 else if (moyenneDiplome() < 12 && moyenneDiplome() >= 11) {
			 return "Passable";
		 }
		 else if (moyenneDiplome() < 14 && moyenneDiplome() >= 12) {
			 return "Assez bien";
		 }
		 else if (moyenneDiplome() < 16 && moyenneDiplome() >= 14) {
			 return "Bien";
		 }
		 else if (moyenneDiplome() < 18 && moyenneDiplome() >= 16) {
			 return "Très Bien";
		 }
		 else {
			 return "Excellent";
		 }
	 }

	public Filiere getFilière() {
		return filière;
	}

	public void setFilière(Filiere filière) {
		this.filière = filière;
	}
}


