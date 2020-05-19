package gestiondesEtudes;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InscriptionP�dagogique {
		protected int anneePromo;
		//protected Promotion p;
		protected int filierechoisie;
		private Student et;
		protected Ecole ec;
		protected Class c;
		protected Filiere f;
		
		Scanner sc = new Scanner(System.in);
		
		public InscriptionP�dagogique(Ecole ec) throws ParseException, IOException {
			this.ec = ec;
			anneePromo=0;
			while(anneePromo==0) {
			System.out.println("Vous vous inscrivez au titre de la :\n 1) Première année\n 2) Deuxième année\n 3) Troisième année");
			try {
			anneePromo = sc.nextInt();
			sc.nextLine();
			gestion();
			break;
			}catch(InputMismatchException er) {//catch 1
				System.out.println();
				System.err.println("Ce choix est invalide");
				sc.nextLine();
				
			}
			}
		}
		
		public void firstYear() throws ParseException, IOException {
			if (anneePromo == 1) {
				InscriptionAdministrative ia = new InscriptionAdministrative(ec);
				System.out.println("*****************************************************\n");
				System.out.println("\nChoisissez la classe :");
				ia.f.choisirClassFilere().addStud(ia.e);
				ia.e.anneePromo=1;
				setEt(ia.e);
				
				}
			}
		
		
		public void secondYear() {
			System.out.println("\nChoisissez une filière :");
			ec.affichefiliereEcole();
			filierechoisie=sc.nextInt();
			f=ec.choisirFiliere(filierechoisie);
			
			c=f.choisirClassFilere();
			System.out.println("\nChoisissez votre nom :");
			c.affichestudClass();
			int studchoisie=sc.nextInt();
			int i=1;
			for(Student s:c.stud) {
				if(i==studchoisie) {
					setEt(s);
					if(s.Decision==null) {
						
						System.err.println("Pas de décision pour le moment. Veuillez attendre la décision du conseil");
						break;
					}
					
					else {
					if (s.getDecision().equalsIgnoreCase("Passage")) {
						s.setAnneePromo(2);	
						c.stud.remove(s);
							System.out.println("Félicitations, vos notes et discipline vous ont permis de réussir. \nBienvenue dans cette nouvelle année !");
							System.out.println("\n----------------------\n");
							
							/*System.out.println("choisir la nouvelle promotion");
							f.afficheClassFiliere();
							int promo=sc.nextInt();*/
							c=f.choisirClassFilere();
							c.addStud(s);
							System.out.println("\n----------------------\n");
							setEt(s);
					}
					else {
							System.out.println("Désolé, vous allez redoubler. Bon courage !");
					}
					break;
					}
				}
			
				else i++;
			}
	}				
	
				
		
		
		public void thirdYear() {
			System.out.println("\nChoisissez votre filière :");
			ec.affichefiliereEcole();
			filierechoisie=sc.nextInt();
			f=ec.choisirFiliere(filierechoisie);
			c=ec.choisirFiliere(filierechoisie).choisirClassFilere();
			System.out.println("\nChoisissez votre nom :");
			c.affichestudClass();
			int studchoisie=sc.nextInt();
						if (ec.choisirFiliere(filierechoisie).choisirClassFilere().choisirStud(studchoisie).getDecision().equalsIgnoreCase("Passage")) {
							ec.choisirFiliere(filierechoisie).choisirClassFilere().choisirStud(studchoisie).setAnneePromo(3);	
							ec.choisirFiliere(filierechoisie).choisirClassFilere().stud.remove(ec.choisirFiliere(filierechoisie).choisirClassFilere().choisirStud(studchoisie));
								System.out.println("Félicitations, vos notes et discipline vous ont permis de réussir. \nBienvenue dans cette nouvelle année !");
								System.out.println("\n----------------------\n");
								
								System.out.println("choisir la nouvelle promotion");
								ec.choisirFiliere(filierechoisie).afficheClassFiliere();
								ec.choisirFiliere(filierechoisie).choisirClassFilere().addStud(ec.choisirFiliere(filierechoisie).choisirClassFilere().choisirStud(studchoisie));
								System.out.println("\n----------------------\n");
								
						}
						else {
								System.out.println("Désolé, vous allez redoubler. Bon courage !");
						}
		}
		
		public void gestion() throws ParseException, IOException {
			switch (anneePromo) {
			case 1 : firstYear(); break;
			case 2 : secondYear(); break;
			case 3 : thirdYear(); break;
			default : System.out.println("Réessayer"); anneePromo = sc.nextInt(); gestion(); break;
			}
		}

		public Student getEt() {
			return et;
		}

		public void setEt(Student et) {
			this.et = et;
		}
	
}
