package gestiondesEtudes;
import gestiondeScolarit�.Element;
import gestiondeScolarit�.Module;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import Excel.ExcelUtils;


public class Ecole implements Inscription{
	protected  String nomEcole;
	protected  String abrEcole;
	protected  String adressEcole;
	protected  String fondateur;
	protected  String type;
	protected  final String pwd="ADMIN";
	protected  int nbrFemme = 0;
	protected  int nbrHomme = 0;
	protected  int nbrPassage = 0;
	protected  int nbrRedoublant = 0;
	protected  Set <Student> studEcole=new TreeSet<>();
	protected  Set <Classe> classEcole= new HashSet<>();
	//protected  Set <Promo> promoEcole= new HashSet<>();
	protected  Set <Filiere> filiereEcole= new TreeSet<>();
	protected  Set <Responsable> respoEcole = new HashSet<>();
	protected  Set <Administrateur> adminEcole = new HashSet<>();
	public Set <Professeur> profEcole= new HashSet<>();
	public Map <Integer , Element > Salle= new HashMap<>();
	public Map<Personne,String> pwdEcole =new HashMap<>();
	Scanner sc=new Scanner(System.in);
	String Newligne=System.getProperty("line.separator");
	
	static int i = 0;
	static int j = 0;
	static int v = 0;
	

	public Ecole() throws IOException {
		
		if(i != 0) {
			loadSchool();
		}
		else {
			i++;
			System.out.println("-Entrez le nom de l'�cole :");
			nomEcole=sc.nextLine();
			ExcelUtils.setCellStringValue("./data/Ecole.xlsx",i, 0, nomEcole);
			System.out.println("\n-Entrez l'abr�viation de l'�cole :");
			abrEcole=sc.nextLine();
			ExcelUtils.setCellStringValue("./data/Ecole.xlsx",i, 1, abrEcole);
			System.out.println("\n-Entrez le fondateur de l'�cole :");
			fondateur=sc.nextLine();
			ExcelUtils.setCellStringValue("./data/Ecole.xlsx",i, 2, fondateur);
			System.out.println("\n-Entrez le type de l'�cole :");
			type=sc.nextLine();
			ExcelUtils.setCellStringValue("./data/Ecole.xlsx",i, 3, type);
			System.out.println("\n-Entrez l'adresse de l'�cole :");
			adressEcole=sc.nextLine();
			ExcelUtils.setCellStringValue("./data/Ecole.xlsx",i, 4, adressEcole);
		}
	}
	
	public void loadSchool() {//
		
	}

	public Ecole(String nomEcole, String abrEcole,String fondateur,String type, String adressEcole) {

		this.nomEcole = nomEcole;
		this.abrEcole = abrEcole;
		this.adressEcole = adressEcole;
		this.fondateur=fondateur;
		this.type=type;

	}
	
	public void inscription() throws IOException   {//insc Admin
		
		System.out.println("\n  ->Entez votre nom :");
		String lastnamePers=sc.next();
		System.out.println("\n  ->Entez votre pr�nom :");
		String firstnamePers=sc.next();
		System.out.println("\n  ->Entrez votre CNI :");
		String cniPers=sc.next();
		System.out.println("\n  ->Entrez un mot de passe :");
		String pwd=sc.next();	
		Administrateur a= new Administrateur(lastnamePers,firstnamePers,cniPers,pwd,this);
		this.adminEcole.add(a);
		this.pwdEcole.put(a,pwd);
		this.writeAdmin();
	}
	public  boolean verificationPWD(Personne prs,Map <Personne,String> a) {
		if (prs.pwd.equals(a.get(prs))) {
			return true;
		}
		else return false;
	}

	public void addfili�re() {
		int a=1;

		while(a==1) {
			System.out.println("\n--Veuillez ajouter une fili�re :");
			System.out.println("\n  ->Entrez le nom de la nouvelle fili�re :");
			String nomFiliere=sc.next();
			Filiere f=new Filiere (nomFiliere,this);
			System.out.println("\n--D�terminer le chef de fili�re");
			System.out.println("\n  ->Entrez son nom :");
			String lastnamePers=sc.next();
			System.out.println("\n  ->Entrez son pr�nom :");
			String firstnamePers=sc.next();
			System.out.println("\n  ->Entrez son CNI :");
			String cniPers=sc.next();
			System.out.println("\n  ->Entrez un mot de passe pour ce responsable :");
			String pwd=sc.next();
			Responsable r= new Responsable(lastnamePers,firstnamePers,cniPers,f,pwd);
			this.pwdEcole.put(r,pwd);
			this. writeRespo();

			a=0;
			while(a==0) {
				System.out.println("\n--Voulez-vous ajouter une autre fili�re? \n 1) Oui\n 2) Non");

				try {
					a=sc.nextInt();	
					//sc.nextLine();
					if (a!=1 && a!=2) {
						throw new InputMismatchException("Ce choix est invalide");
					}

				}
				catch(InputMismatchException e) {
					System.out.println();
					System.err.println("Ce choix est invalide");
					sc.nextLine();
					a=0;
				}


			}

		}

	}
	public void writeAdmin(){
		File f=new File("AdminEcole.txt");
		try(BufferedWriter bw= new BufferedWriter(new FileWriter(f))) {
			bw.write("Les administrateurs de l'"+this.abrEcole+" :\n\n");
			for (Administrateur a: this.adminEcole) {
				bw.write(a.lastnamePers+"  "+a.firstnamePers+"      "+a.cniPers+"\n");
				v++;
				ExcelUtils.setCellStringValue("./data/ListeAdmin.xlsx",v, 0, a.lastnamePers);
				ExcelUtils.setCellStringValue("./data/ListeAdmin.xlsx",v, 1, a.firstnamePers);
				ExcelUtils.setCellStringValue("./data/ListeAdmin.xlsx",v, 2, a.cniPers);
				ExcelUtils.setCellStringValue("./data/ListeAdmin.xlsx",v, 3, a.pwd);
			}
		}
		catch(FileNotFoundException e) {
			System.err.println("Impossible");
		}
		catch(IOException e) {
			e.printStackTrace(); 
		}
	}

	public void writeRespo() {
		File f=new File("RespoEcole.txt");
		try(BufferedWriter bw= new BufferedWriter(new FileWriter(f))) {
			bw.write("Les responsables de l'"+this.abrEcole+" :\n\n");
			for (Responsable  a: this.respoEcole) {
				bw.write(a.lastnamePers+" "+a.firstnamePers+"      "+a.cniPers+"      "+a.fili�re+"      "+a.pwd+"\n");
				j++;
				ExcelUtils.setCellStringValue("./data/ListeRespo.xlsx",j, 0, a.lastnamePers);
				ExcelUtils.setCellStringValue("./data/ListeRespo.xlsx",j, 1, a.firstnamePers);
				ExcelUtils.setCellStringValue("./data/ListeRespo.xlsx",j, 2, a.cniPers);
				ExcelUtils.setCellStringValue("./data/ListeRespo.xlsx",j, 3, a.fili�re.nomFili�re);
				ExcelUtils.setCellStringValue("./data/ListeRespo.xlsx",j, 4, a.pwd);
			}
		}
		catch(FileNotFoundException e) {
			System.err.println("Impossible");
		}
		catch(IOException e) {
			e.printStackTrace(); 
		}
	}
	public void addclass() throws IOException {
		int a=1;
		while (a==1) {
			System.out.println("\n--Veuillez ajouter une classe :");
			System.out.println("\n  ->Choisissez une fili�re :");
			this.affichefiliereEcole();
			try {
				a= sc.nextInt();
				if (a<1 ||  a>this.filiereEcole.size()) {
					throw new InputMismatchException("Ce choix est invalide");
				}
				System.out.println("\n ->Entrez une promotion");
				int p = sc.nextInt();
				sc.nextLine();


				int i=1;
				for (Filiere f: this.filiereEcole) {
					if(i==a) {
						for(Promotion promotion:f.promoFiliere) {

							if (promotion.nPromo==p) {
								System.out.println("Cette classe est d�j� ajout�e");
								i=0;
								break;
							}
							else i++;
						}
						if (i!=0) {
							Promotion promotion=new Promotion (f,p);
							Classe c= new Classe (f,promotion);
							this.classEcole.add(c);
							f.classFiliere.add(c);
							promotion.classPromo.add(c);
							ExcelUtils.setCellStringValue("./data/ListeDesClasses.xlsx",i, 0, c.toString());
							ExcelUtils.setCellStringValue("./data/ListeDesClasses.xlsx",i, 1, c.filiere.getNomFili�re());
							ExcelUtils.setCellStringValue("./data/ListeDesClasses.xlsx",i, 2, c.promotion.toString());
						}
						break;
					}
					else i++;
				}
				System.out.println("\n--Voulez-vous ajouter une autre classe ? \n  1) Oui\n  2) Non");
				a=sc.nextInt();	
				sc.nextLine();
				if (a!=1 && a!=2) {
					throw new InputMismatchException("Ce choix est invalide");
				}

			}
			catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Ce choix est invalide");
				sc.nextLine();
				a=1;
			}
		}
	}
	public void  affichestudEcole() {
		@SuppressWarnings("rawtypes")
		Iterator iterator = studEcole.iterator();
		System.out.println("Les �tudiants de l'"  + this.nomEcole + " :");

		while (iterator.hasNext()){
			System.out.println("-"+iterator.next());

		}
	}

	@Override
	public String toString() {
		return nomEcole + " ( " + abrEcole + " ) est une �cole d'"+ type + " fond�e par "+ fondateur ;
	}
	public void affichefiliereEcole() {
		@SuppressWarnings("rawtypes")
		
		Iterator iterator = filiereEcole.iterator();
		if(this.filiereEcole.isEmpty()) {
			System.err.println("Pas de fil�re pour la moment");
		}
		else {
		System.out.println("Les fili�res de l'"  + this.nomEcole);
		int i=1;
		while (iterator.hasNext()){
			System.out.println(i+"- "+iterator.next());
			i++;
		}}

	}
	public void afficheclassEcole() {
		@SuppressWarnings("rawtypes")
		Iterator iterator = classEcole.iterator();
		System.out.println("Les classes de "  + this.nomEcole);
		int i=1;
		while (iterator.hasNext()){
			System.out.println(i+"- "+iterator.next());
			i++;
		}

	}
	public void afficheclassEcole(Filiere f) {
		@SuppressWarnings("rawtypes")
		Iterator iterator = classEcole.iterator();
		System.out.println("Les classe de la "  + f);
		int i=1;
		while (iterator.hasNext()){
			Classe cl=(Classe) iterator.next();
			if (cl.filiere==f) {
				System.out.println(i+"- "+iterator.next());
				i++;
			}
		}
	}
	public void afficheclassFiliere() {
		if(this.filiereEcole.isEmpty()) {
			System.err.println("Pas de fili�re pour le moment");
		}
		else {
		int a=0;
		while(a==0) {
			System.out.println("\nChoisir la fili�re:");
			this.affichefiliereEcole();
			try {
				int filierechoisie=sc.nextInt();
				if (filierechoisie<1 ||  filierechoisie>this.filiereEcole.size()) {
					throw new InputMismatchException("Ce choix est invalide");
				}

				int i =1;
				for (Filiere f:this.filiereEcole) {
					if(i==filierechoisie) {
						f.afficheClassFiliere();
						break;
					}
					else i++;
				}
				a=1;
			}catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Ce choix est invalide");
				sc.nextLine();
				a=0;
			}catch(NullPointerException e) {
				System.out.println();
				System.err.println("Pas de choix actuellement.");
				sc.nextLine();
				a=0;
			}
		}
		}

	}



	public Classe choisirClass(int a) {
		int i=1;
		for (Classe c : this.classEcole) {
			if(i==a) {
				return c;		
			}
			else i++;
		}
		return null;
	}
	public Filiere choisirFiliere(int a) {

		int i=1;
		for (Filiere f: this.filiereEcole) {
			if(i==a) {
				return f;
			}
			else i++;
		}
		return null;

	}


	public void afficherheurModule() {
		int a=0;
		try {
		if (this.filiereEcole.isEmpty()) {
			throw new NullPointerException("Pas de fili�re pour le moment"); 
		}
		else {
		while (a==0) {
			System.out.println("\n--Choisissez une fili�re :");
			this.affichefiliereEcole();

			try {
				int filierechoisie=sc.nextInt();
				if (1>filierechoisie || filierechoisie>this.filiereEcole.size()) {
					throw new InputMismatchException("Ce choix est invalide.")	;
				}
				int i =1;
				for (Filiere f:this.filiereEcole) {
					if(i==filierechoisie) {
						System.out.println("\n--Choisissez une classe");
						f.afficheClassFiliere();
						int clchoisie=sc.nextInt();
						this.choisirClass(clchoisie).afficherheursModuleClass();
						a=1;
						break;

					}
					else i++;

				}
				a=1;
			}
			catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Ce choix est invalide");
				sc.nextLine();
				a=0;
			}
		}
		}
			

		
		}catch(NullPointerException e) {
			System.out.println();
			System.err.println("Pas de choix actuellement.");
			sc.nextLine();
			a=1;
		}
		}

	
	public void afficherEDT() {
		int a=0;
		while (a==0) {
			System.out.println("\n--Choisissez une fili�re :");
			this.affichefiliereEcole();

			try {
				int filierechoisie=sc.nextInt();
				if (1>filierechoisie || filierechoisie>this.filiereEcole.size()) {
					throw new InputMismatchException("Ce choix est invalide.")	;
				}
				int i =1;
				for (Filiere f:this.filiereEcole) {
					if(i==filierechoisie) {
						System.out.println("\n--Choisissez une classe :");
						f.afficheClassFiliere();
						int clchoisie=sc.nextInt();
						sc.nextLine();
						this.choisirClass(clchoisie).afficheEdtClass();
						a=1;
						break;

					}
					else i++;

				}
				a=1;
			}
			catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Ce choix est invalide");
			
				a=0;
			}
			catch(NullPointerException e) {
				System.out.println();
				System.err.println("Pas de choix actuellement.");
				//sc.nextLine();
				a=1;
			}


		}
	}
	public void removeClass() {
		int a=0;
		if(this.classEcole.isEmpty()) {
			System.out.println("Pas de classe dans cette �cole");
		}
		else {
			System.out.println("\n--Choisissez une classe :");
			this.afficheclassEcole();
			while (a==0) {
				

				try {
					int clchoisie=sc.nextInt();
					if (1>clchoisie || clchoisie>this.filiereEcole.size()) {
						throw new InputMismatchException("Ce choix est invalide.")	;
					}
					int i =1;

					for (Classe c:this.classEcole) {
						if(i==clchoisie) {
							for(Professeur p: c.profClass) {
								this.profEcole.remove(p);
							}
							c.filiere.classFiliere.remove(c);
							this.classEcole.remove(c);
							a=1;
							break;


						}
						else i++;
					}

					a=1;
				}

				catch(InputMismatchException e) {
					System.out.println();
					System.err.println("Ce choix est invalide");
					sc.nextLine();
					a=0;
				}
				catch(NullPointerException e) {
					System.out.println();
					System.err.println("Pas de choix actuellement.");
					sc.nextLine();
					a=1;
				}


			}
		}
	}
	public void removeFili�re() {
		int a=0;
		while(a==0) {
			if(this.filiereEcole.isEmpty()) {
				System.out.println("Pas de fil�re dans cette �cole");
				break;
			}
			else{
				System.out.println("\n--Choisir la fili�re :");
				this.affichefiliereEcole();

				try {
					int filierechoisie=sc.nextInt();
					if (1>filierechoisie || filierechoisie>this.filiereEcole.size()) {
						throw new InputMismatchException("Ce choix est invalide.")	;
					}


					int i =1;
					for (Filiere f:this.filiereEcole) {
						if(i==filierechoisie) {
							for (Professeur p:f.profFiliere) {
								this.pwdEcole.remove(p);
								this.profEcole.remove(p);
							}
							this.respoEcole.remove(f.r);
							this.filiereEcole.remove(f);
							this.pwdEcole.remove(f.r);
							for(Classe c : this.classEcole) {
								if(c.filiere.equals(f)) {
									this.classEcole.remove(c);
									
								}
							}

							this.writeRespo();;
							a=1;
							break;

						}
						else i++;

					}
					a=1;

				}
				catch(InputMismatchException e) {
					System.out.println();
					System.err.println("Ce choix est invalide");
					sc.nextLine();
					a=0;
				}
				catch(NullPointerException e) {
					System.out.println();
					System.err.println("Pas de choix actuellement.");
					sc.nextLine();
					a=1;
				}


			}

		}

	}
	public void removeAdmin(){

		int i=1;
		if (this.adminEcole.isEmpty()) {
			System.out.println("Pas d'administrateur � retirer");
		}
		else {
			System.out.println("\n--Choisir l'Admin");
			for(Administrateur a : this.adminEcole) {
				System.out.println("  "+i+"-"+a.toString());
			}
			try {
				int admin=sc.nextInt();
				if(1>admin && admin>=this.adminEcole.size()) {
					throw new InputMismatchException("Ce choix est invalide.")	;
				}
				i=1;
				for (Administrateur a : this.adminEcole) {
					if(i==admin) {
						this.adminEcole.remove(a);
						this.pwdEcole.remove(a);
						break;
					}
					else i++;
				}
				this.writeAdmin();
			}
			catch(InputMismatchException e) {
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
	}
	public void modResp() {
		int a=0;
		if(this.filiereEcole.isEmpty()) {
			System.out.println("Pas de fili�re dans cette �cole");
		}
		else {
			while (a==0) {

				System.out.println("\n--Choisissez une fili�re :");
				this.affichefiliereEcole();

				try {
					int filierechoisie=sc.nextInt();
					if (1>filierechoisie || filierechoisie>this.filiereEcole.size()) {
						throw new InputMismatchException("Ce choix est invalide.")	;
					}
					int i =1;

					for (Filiere f:this.filiereEcole) {
						if(i==filierechoisie) {
							this.respoEcole.remove(f.r);
							this.pwdEcole.remove(f.r);
							System.out.println("\n--D�terminer le chef de fili�re");
							System.out.println("\n  ->Entrez son nom :");
							String lastnamePers=sc.next();
							System.out.println("\n  ->Entrez son pr�nom :");
							String firstnamePers=sc.next();
							System.out.println("  ->Entrez son CNI :");
							String cniPers=sc.next();
							System.out.println("\n  ->Entrez un mot de passe pour ce responsable :");
							String pwd=sc.next();
							Responsable resp= new Responsable(lastnamePers,firstnamePers,cniPers,f,pwd);
							f.r=resp;
							this.pwdEcole.put(resp,pwd);
							this. writeRespo();

							break;

						}
						else i++;
					}

					a=1;
				}

				catch(InputMismatchException e) {
					System.out.println();
					System.err.println("Ce choix est invalide");
					sc.nextLine();
					a=0;
				}
				catch(NullPointerException e) {
					System.out.println();
					System.err.println("Pas de choix actuellement.");
					sc.nextLine();
					a=1;
				}


			}
		}
	}
	public Responsable connectionRespo(String lastnamePers, String firstnamePers,String pwd) {
		int a=0;
		Responsable responsable =new Responsable("","");
		while(a==0) {
			System.out.println("\n  ->Choisissez une fili�re : ");
			this.affichefiliereEcole();
			try {
				int filiere=sc.nextInt();
				if(1>filiere || filiere>this.filiereEcole.size()) {
					throw new InputMismatchException("Ce choix est invalide.")	;
				}
				responsable =new Responsable(lastnamePers,firstnamePers,this.choisirFiliere(filiere),pwd);
				break;


			}
			catch(InputMismatchException e) {
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
		return responsable;
	}

	public void addElement(Filiere filiere) {
		int a=3;
		while(a==3) {
			Classe cl= filiere.choisirClassFilere();
			if(cl.moduleClass.isEmpty()) {
				System.out.println("Pas de module pour le moment");
			}
			else {
				a=2;
				while (a==2) {
					System.out.println("\nChoisissez un module :");
					cl.affichermoduleClass();
					try {
						int modulechoisi=sc.nextInt();
						sc.nextLine();
						if(1>modulechoisi|| modulechoisi>cl.moduleClass.size()) {
							throw new InputMismatchException("Ce choix est invalide.");
						}
						a=1;
						while(a==1) {
							System.out.println("\nEntrez le nom de l'�l�ment");
							String nomElement=sc.nextLine();
							cl.addElement(modulechoisi,nomElement);
							a=5;
							while (a==5) {
								System.out.println(" 1) Ajouter un �l�ment"+Newligne+" 2) Changer le module"+Newligne+" 3) Changer la classe"+Newligne+" 4) Retour"+Newligne);
								try {
									a=sc.nextInt();
									sc.nextLine();
									if (a!=1 && a!=2 && a!=3 && a!=4) {
										throw new InputMismatchException("Ce choix est invalide");
									}
								}catch(InputMismatchException e) {
									System.out.println();
									System.err.println("Ce choix est invalide");
									sc.nextLine();
									a=5;

								}
								catch(NullPointerException e) {
									System.out.println();
									System.err.println("Pas de choix actuellement.");
									sc.nextLine();
									a=5;
								}
							}
						}
					}catch(InputMismatchException e) {
						System.out.println();
						System.err.println("Ce choix est invalide");
						sc.nextLine();
						a=2;

					}
					catch(NullPointerException e) {
						System.out.println();
						System.err.println("Pas de choix actuellement.");
						sc.nextLine();
						a=2;
					}
				}}
		}
	}
	public void addModule(Filiere filiere) {
		Classe cl= filiere.choisirClassFilere();
		System.out.println("\n--Entrez le nom du nouveau module :\n");
		sc.nextLine();
		String nomModule=sc.nextLine();
		Module module=new Module(nomModule,cl);
		int r1=1;
		while (r1==1) {
			System.out.println(" 1) Ajoutez un �l�ment\n 2) Retour");
			try {
				r1=sc.nextInt();
				sc.nextLine();
				if(r1!=1 && r1!=2) {
					throw new InputMismatchException("Ce choix est invalide.")	;
				}
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

			if(r1==2) {
				break;
			}
			else
			{
				System.out.println("\nEntrer le nom du nouvel �l�ment");
				String nomElement=sc.nextLine();
				Element element =new Element(nomElement,module);
				module.setHeureModule();
				element.definirSalle();
				//element.modhours();
				r1=1;
			}
		}

	}
	public void removeModule(Filiere filiere) {
		Classe cl= filiere.choisirClassFilere();
		if(cl.moduleClass.isEmpty()) {
			System.err.println("Pas de module dans la classe");
		}
		else {
			int a=0;
			while(a==0) {
				System.out.println("\nChoisissez un module");
				cl.affichermoduleClass();
				try {
					int modulechoisi=sc.nextInt();
					sc.nextLine();
					if(1>modulechoisi|| modulechoisi>cl.moduleClass.size()) {
						throw new InputMismatchException("Ce choix est invalide.");
					}

					cl.removeModule(modulechoisi);
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


		}
	}
	public void removeElement(Filiere filiere) {
		Classe cl= filiere.choisirClassFilere();
		int a=0;
		while(a==0) {
			System.out.println("\nChoisissez un module");
			cl.affichermoduleClass();
			try {
				int modulechoisi=sc.nextInt();
				sc.nextLine();
				if(1>modulechoisi|| modulechoisi>cl.moduleClass.size()) {
					throw new InputMismatchException("Ce choix est invalide.");
				}

				cl.removeElement(modulechoisi);
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
	}
	public boolean profverificationPWD(Professeur p) {
		for (Professeur a :this.profEcole) {
			if (a.equals(p)) {
				if (a.pwd.equals(p.pwd)) {

					return true;
				}

				break;
			}
		}
		return false;
	}
	public void afficherEcole() {
		System.out.println(this.nomEcole + " ( "+this.abrEcole+" ) est une �cole d'" +this.type+" fond�e par "+ this.fondateur);
		System.out.println("L'adresse de l'�cole est : " +this.adressEcole);
	}

	public String getAbrEcole() {
		return abrEcole;
	}

	public void setAbrEcole(String abrEcole) {
		this.abrEcole = abrEcole;
	}

	public String getAdressEcole() {
		return adressEcole;
	}

	public void setAdressEcole(String adressEcole) {
		this.adressEcole = adressEcole;
	}

	public String getFondateur() {
		return fondateur;
	}

	public void setFondateur(String fondateur) {
		this.fondateur = fondateur;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Administrateur> getAdminEcole() {
		return adminEcole;
	}

	public void setAdminEcole(Set<Administrateur> adminEcole) {
		this.adminEcole = adminEcole;
	}

	public String getNomEcole() {
		return nomEcole;
	}

	public void setNomEcole(String nomEcole) {
		this.nomEcole = nomEcole;
	}

	public Set<Student> getStudEcole() {
		return studEcole;
	}

	public void setStudEcole(Set<Student> studEcole) {
		this.studEcole = studEcole;
	}

	public Set<Classe> getClassEcole() {
		return classEcole;
	}

	public void setClassEcole(Set<Classe> classEcole) {
		this.classEcole = classEcole;
	}

	public Set<Filiere> getFiliereEcole() {
		return filiereEcole;
	}

	public void setFiliereEcole(Set<Filiere> filiereEcole) {
		this.filiereEcole = filiereEcole;
	}

	public Set<Responsable> getRespoEcole() {
		return respoEcole;
	}

	public void setRespoEcole(Set<Responsable> respoEcole) {
		this.respoEcole = respoEcole;
	}
	public void statInscriptionSexe() {
		if(nbrFemme+nbrHomme != 0) {
			float pg = nbrHomme*100/(nbrFemme+nbrHomme);
			float pf =nbrFemme*100/(nbrFemme+nbrHomme);
			System.out.println("Pourcentage des gar�ons parmi les nouveaux inscrits est : " + pg + "%");
			System.out.println("Pourcentage des filles parmi les nouveaux inscrits est : " + pf + "%");
		} else {
			System.out.println("Pas d'inscription pour le moment.");
		}
	}
	/*public void  statsReussite() {
		if(nbrPassage+nbrRedoublant != 0) {
			float tauxP = (nbrPassage*100)/(nbrPassage+nbrRedoublant);
			float tauxR = (nbrRedoublant*100)/(nbrPassage+nbrRedoublant);
			System.out.println("Le taux de personnes ayant termin� cette ann�e avec succ�s est : "+ tauxP + "%");
			System.out.println("Le taux de personnes qui vont redoubler cette ann�e est : "+ tauxR + "%");
		}
		else {
			System.out.println("Pas de donn�es pour le moment.");
		}
	}*/
}

