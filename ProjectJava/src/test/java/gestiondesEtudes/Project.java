package gestiondesEtudes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Project {

	@SuppressWarnings({ "deprecation", "unused" })
	public static void main(String[] args) throws ParseException, IOException   {
		Scanner sc= new Scanner(System.in);
		String Newligne=System.getProperty("line.separator");
		
		System.out.println("************************** BIENVENUE DANS LE SYSTEME ****************************" );
		System.out.println("**************************       Mr.directeur         ****************************\n\n" );
		
		Ecole ecole=new Ecole();
		System.out.println("\n--Veuillez entrer vos données personnelles");
		ecole.inscription();
		ecole.addfilière();
		ecole.addclass();
		System.out.println("\nLa phase de création de l'école est terminée avec succès\n ");
		System.out.println("**************************BIENVENUE DANS LE SYSTEM "+ecole.abrEcole+"****************************\n\n" );
		int id=0;
		while (id==0) {//connection while(id==0)
			int e=0;
			while(e==0) {
				System.out.println("--Se connecter comme étant :\n  1) Administrateur\n  2) Responsable de filière\n  3) Enseignant\n  4) Etudiant\n  5) Visiteur");
		 		try {//try 1
					id=sc.nextInt();	
					if (id!=1 && id!=2 && id!=3 && id!=4 && id!=5) {
						throw new InputMismatchException("Ce choix est invalide");
						}
					sc.nextLine();
					break;
				}//try 1
				catch(InputMismatchException er) {//catch 1
					System.out.println();
					System.err.println("Ce choix est invalide");
					sc.nextLine();
					e=0;
				}//catch 1
		 		
			}
			
//---------------------------------ADMIN------------------------------------------------------	 	
			if(id==1) {//connection admin
				System.out.println("\n ->Entrez votre Nom ");
				String nom =sc.nextLine();
				System.out.println("\n ->Entrez votre  Prénom");
				String prenom =sc.nextLine();
				System.out.println("\n ->Entrez un mot de passe");
		 		String pwd =sc.nextLine();
				Administrateur admin=new Administrateur(nom,prenom,pwd,ecole);
				if (admin.exist(ecole.adminEcole)==false) {//check l'existence de l'admin
					System.out.println("\nVous n'êtes pas membre de l'administration\n");
					id=0;
				}//check l'existence du admin
				else if (admin.verificationPWD()==false) {//check pwd
					System.out.println("Mot de passe est incorrecte !");
					id=0;
				}//check pwd
				else {// passwd et l'existence verifiés admin
					int ad1=0;
					while (ad1==0) {//menu d'administrateur
						System.out.println("--Choisissez votre prochaine action:\n\n    1) Gestion des études\n    2) Les statistiques et rapports\n    3) Retour\n");
						try {//try 1
							ad1=sc.nextInt();	
							if (ad1!=1 && ad1!=2 && ad1!=3 ) {
								throw new InputMismatchException("Ce choix est invalide");
								}
						}//try 1
						catch(InputMismatchException er) {//catch 1
							System.out.println();
							System.err.println("Ce choix est invalide");
							sc.nextLine();
							ad1=0;
						}//catch 1
						if(ad1==1) {//gestion des etudes
							int ad2=0;
							while (ad2==0) {//menu gestion des études
								System.out.println("--Choisissez votre prochaine action:\n    1) Ajouter un Administrateur\n    2) Ajouter une filière\n    3) Ajouter une classe\n    4) Retirer une filière\n    5) Retirer une classe\n    6) Retirer un administrateur\n    7) Changer le responsable d'une filière\n    8) Retour\n");
								try {//try 2
									ad2=sc.nextInt();	
									if (ad2!=1 && ad2!=2 && ad2!=3 && ad2!=4 && ad2!=5 && ad2!=6 && ad2!=7 && ad2!=8) {
										throw new InputMismatchException("Ce choix est invalide");
										}
								}//try 2
								catch(InputMismatchException er) {//catch 2
									System.out.println();
									System.err.println("Ce choix est invalide");
									sc.nextLine();
									ad2=0;
								}//catch2
								if(ad2==1) {//ajouter un admin
									ecole.inscription();
									ad2=0;
								}//ajouter un admin
								if(ad2==2) {//ajouter une filière
									ecole.addfilière();
									ad2=0;
								}//ajouter une filière
								if(ad2==3) {//ajout d'une class
									ecole.addclass();
									ad2=0;
								}//ajout d'une class
								if(ad2==4) {//retirer une filière
									ecole.removeFilière();
									ad2=0;
								}//retirer une filière
								if(ad2==5) {//retirer une classe
									ecole.removeClass();
									ad2=0;
								}//retirer une classe
								if(ad2==6) {//retirer un admin
									ecole.removeAdmin();
									ad2=0;
								}//retirer un admin
								if(ad2==7) {//changer un respp
									ecole.modResp();
									ad2=0;
								}//changer un respp
								if (ad2==8) {//retour2
									ad1=0;	
									
								}//retour2	
							}//menu gestion des etudes
						}//gestion des etudes
						
				
						if(ad1==2) {//les statistique et rapports
							int ad2=0;
							while (ad2==0) {//menu les statistique et rapports
								System.out.println("--Choisissez votre prochaine action:\n\n    1) Statistiques et rapport sur les études\n    2) Statistiques et rapport de scolarité\n    3) Statistiques et rapport sur les examens\n    4) Retour\n");
								try {//try 2
									ad2=sc.nextInt();	
									if (ad2!=1 && ad2!=2 && ad2!=3 && ad2!=4) {
										throw new InputMismatchException("Ce choix est invalide");
										}
								}//try 2
								catch(InputMismatchException er) {//catch 2
									System.out.println();
									System.err.println("Ce choix est invalide");
									sc.nextLine();
									ad2=0;
									
								}//catch2
								if (ad2==1) {//stat sur les etudes
									ad2=6;
									while(ad2==6){//menu statist d'etudes
										System.out.println("Choisissez votre prochaine action:\n    1) Afficher les filières de l'école\n    2) Afficher les classes d'une filière\n    3) Afficher les heures des modules pour chaque filière\n    4) Afficher les emplois du temps\n    5) Retour\n");
										try {//try 2
											ad2=sc.nextInt();	
											if (ad2!=1 && ad2!=2 && ad2!=3 && ad2!=4 && ad2!=5) {
												throw new InputMismatchException("Ce choix est invalide");
												}
										}//try 2
										catch(InputMismatchException er) {//catch 2
											System.out.println();
											System.err.println("Ce choix est invalide");
											sc.nextLine();
											ad2=6;
											
										}//catch2
										if(ad2==1) {//aficher les fillière
											ecole.affichefiliereEcole();
											ad2=6;
										}//aficher les fillière
										if(ad2==2) {//afficher les classes
											ecole.afficheclassFiliere();
											ad2=6;
										}//afficher les classes
										if(ad2==3) {//afficher les heures du modules
											ecole.afficherheurModule();
											ad2=6;
										}//afficher les heures du modules
										if(ad2==4) {//afficher les EDT
											ecole.afficherEDT();
											ad2=6;
										}//afficher les EDT
										if(ad2==5) {
											ad2=0;
										}
									}//menu statist d'etudes
								}//stat sur les etudes
								if(ad2==2) {//stat sur la scolarité
									ad2=0;
								}//stat sur la scolarité
								if(ad2==3) {//stat sur les examen
									ad2=0;
								}//stat sur les examen
								if(ad2==4) {//retour2
									ad1=0;
								}//retour2
							}//menu les statistique et rapports
						}//les statistique et rapports
						if(ad1==3) {//retour1
							System.out.println("\nMerci de votre visite.");
							id=0;
						}//retour1
					
					}//menu d'administrateur
					
				}// passwd et l'existence verifié admin
			
				
				
				
				
			}////connection admin
	////---------------------------------------------Responsable de filière----------------------------------------
			if(id==2) {//connection responsable de filière
				System.out.println("\n ->Entrez votre Nom ");
				String nom =sc.nextLine();
				System.out.println("\n ->Entrez votre Prénom");
				String prenom =sc.nextLine();
				System.out.println("\n ->Entrez votre mot de passe");
		 		String pwd =sc.nextLine();
				if (ecole.respoEcole.isEmpty()==true) {//existence des responsable
					System.out.println("Pas de responsable pour le moment.");
					id=0;
				}//existence des responsable
				else {//le SET n'est p vide
					
					Respo resp =ecole.connectionRespo(nom, prenom, pwd);
					if(resp.exist()==false) {//existences du respo connecte
						System.out.println("Vous n'êtes pas enregistré comme responsable.");
						id=0;
					}//existences du respo connecte
					else if(resp.verificationPWD()==false) {//verifi pwd
						System.out.println("Mot de passe est incorrecte");
						id=0;
					}//verifi pwd
					else {//pwd o existence verifié
						int r1=0;
						while (r1==0) {//menu respo
							System.out.println("--Choisissez votre prochaine action:\n\n    1) Gestion des études\n    2) Gestion de scolarité\n    3) Retour\n");
							try {//try 1
								r1=sc.nextInt();	
								if (r1!=1 && r1!=2 && r1!=3 ) {
									throw new InputMismatchException("Ce choix est invalide");
									}
							}//try 1
							catch(InputMismatchException er) {//catch 1
								System.out.println();
								System.err.println("Ce choix est invalide");
								sc.nextLine();
								r1=0;
							}//catch 1
							
							if(r1==1) {//gestion des etudes
								r1=0;
								while (r1==0) {//MENU GESTION DES ETUDES
									System.out.println("\nChoisissez votre prochaine action:\n\n    1) Ajouter un module pour une classe\n    2) Ajouter un élément\n    3) Retirer un module\n    4) Retirer un élément\n    5) Gestion d'emploi du temps\n    6) Afficher les données de la filière\n    7) Retour\n");
									try {//try 1
										r1=sc.nextInt();	
										if (r1!=1 && r1!=2 && r1!=3 && r1!=4&& r1!=5 && r1!=6 && r1!=7 && r1!=8) {
											throw new InputMismatchException("Ce choix est invalide");
											}
									}//try 1
									catch(InputMismatchException er) {//catch 1
										System.out.println();
										System.err.println("Ce choix est invalide");
										sc.nextLine();
										r1=0;
										
									}//catch 1
									
									if (r1==1) {//Ajout des modules pour une classe
										ecole.addModule(resp.filière);
										
										r1=0;
									}//Ajout des modules pour une classe
									
									if(r1==2) {//2-ajout d'element
										ecole.addElement(resp.filière);
										r1=0;
									}//2-ajout d'element
									
									if(r1==3) {//Retirer un module
										ecole.removeModule(resp.filière);
										r1=0;
									}//Retirer un module
									if(r1==4) {//Retirer un élément
										ecole. removeElement(resp.filière);
										r1=0;
									}//Retirer un élément
									
									if(r1==5) {//Gestion d'emploi
										
										
										Class cl= resp.filière.choisirClassFilere();
										
										SimpleDateFormat s= new SimpleDateFormat("dd MM yyyy");
										int r2=0;
										while(r2==0) {
											System.out.println("\nChoisissez votre prochaine action : \n    1) Créer un nouvel EDT\n    2) Modifier un EDT\n    3) Retour");
											try {//try 1
												r2=sc.nextInt();	
												sc.nextLine();
												if (r2!=1 && r2!=2 && r2!=3) {
													throw new InputMismatchException("Ce choix est invalide");
												}
													}catch(InputMismatchException er) {//catch 1
														System.out.println();
														System.err.println("Ce choix est invalide");
														sc.nextLine();
														r2=0;
														
													}//catch 1
										
											if (r2==1) {//creer un new EDT
												while(r2==1) {
													if (cl.moduleClass.isEmpty()) {
														System.err.println("Pas de module pour le moment");
														r2=0;
														break;
													}
													else {
												System.out.println("\nVeuillez entrer la date de début de l'emploi sous forme 'dd mm yyyy'  (La date devrait correspondre à un Lundi) \n");
												try {
													
												String date=sc.nextLine();
												if(s.parse(date).getDay()==1) {
													if (cl.testheurModule()==false) {//semaine normale
														cl.addEDT( date);
														r2=0;
														break;
													}//semaine normale
													
													else {//semaine exam
														cl.examEDT( date);
														r2=0;
													}//semaine exam
													
												}
												else {
													System.err.println("Veuillez saisir une date de début de semaine\n");
													r2=1;
												}
												}
												catch(ParseException er) {
													System.out.println();
													System.err.println("la forme de la date est Inconvenable");
												//	sc.nextLine();
													r2=1;
													}
												}
												}
											}//creer un new EDT
									
											
											 if (r2==2) {//modifier l'edt
												if(cl.emploi.isEmpty()) {
													System.err.println("Pas d'emploi à  modifier");
													r2=0;
												}
												else {
												cl.modEdt();
												r2=0;
												}
											}//modifier l'edt
											
											 if(r2==3) {//retour
												 r1=0;
											 }
										}
										
											
									
													
										
											
										
									}//Gestion d'emploi
									
									if(r1==6) {//Afficher les données
										int r2=0;
										while(r2==0) {//menu d'affichage
											System.out.println("\nChoisissez votre prochaine action :\n    1) Afficher les classes de la filière"+resp.filière.nomFilière+"\n    2) Afficher les étudiants de la filière"+resp.filière.nomFilière+"\n    3) Afficher les profs de la filière"+resp.filière.nomFilière+"\n    4) Afficher les emplois d'une classe"+resp.filière.nomFilière+"\n    5) Afficher les modules d'une classe "+resp.filière.nomFilière+"\n    6) Afficher les éléments d'un module "+resp.filière.nomFilière+"\n    7) Afficher le PV de délibération\n    8) Retour\n");										
											try {//try 1
											r2=sc.nextInt();
											if (r2!=1 && r2!=2 && r2!=3 && r2!=4&& r2!=5 && r2!=6 && r2!=7 && r2!=8) {
												throw new InputMismatchException("Ce choix est invalide");
												}
										}//try 1
										catch(InputMismatchException er) {//catch 1
											System.out.println();
											System.err.println("Ce choix est invalide");
											sc.nextLine();
											r2=0;
											
										}//catch 1
											
								
											if (r2==1) {//AFFICHAGE classe
												
												resp.filière.afficheClassFiliere();
												r2=0;
											}//AFFICHAGE classe
											if(r2==2) {//affichage etudiant
												
												Class cl= resp.filière.choisirClassFilere();
												cl.affichestudClass();
												r2=0;
											}//affichage etudiant
											if (r2==3) {//afficher les profs
												
												Class cl= resp.filière.choisirClassFilere();
												
												cl.afficherProf();
												r2=0;
												
											}//afficher les profs
											if(r2==4) {// affichage les emploi
												
												Class cl= resp.filière.choisirClassFilere();
												cl.afficheEdtClass();
												r2=0;
											}//affichage les emploi
											if (r2==5) {// affichage module
												Class cl= resp.filière.choisirClassFilere();
												cl.affichermoduleClass();
												r2=0;
											}// affichage module
											if(r2==6) {//affichage element 
												Class cl= resp.filière.choisirClassFilere();
												cl.afficherElementClass();
												r2=0;
												
											}//affichage element 
											if (r2==7) {//PV
												Class cl= resp.filière.choisirClassFilere();
												cl.affichermoduleClass();
												PvDeDélibération p =new PvDeDélibération(cl)	;
												p.générerPV();
											}//rPV
											if (r2==8) {//retour
												r1=0	;
											}//retour
										
										
										}//menu d'affichage
										
									}//Afficher les données
								
									if(r1==7) {//retour 1
										r1=0;
										break;
									}//retour 1
								}//MENU GESTION DES ETUDES
						
							}//gestion des etudes
						
							if(r1==2) {//gestion de scolarité 
								int r2=0;
								while(r2==0) {//MENU GESTION SCOLARITE
									System.out.println("\nChoisissez votre prochaine action :\n    1) Gestion des notes\n    2) Gestion des absences\n       3) Retour\n");
									try {
									r2=sc.nextInt();
									if (r2!=1 && r2!=2  && r2!=3) {
										throw new InputMismatchException("Ce choix est invalide");
										}
								}//try 1
								catch(InputMismatchException er) {//catch 1
									System.out.println();
									System.err.println("Ce choix est invalide");
									sc.nextLine();
									r2=0;
									
								}//catch 1
									
									
						
									if (r2==1) {//gestion des notes
										int r3=0;
										while(r3==0) {
											System.out.println("\nChoisissez votre prochaine action:\n    1) Entrer les notes\n    2) Modifier les notes\n    3) Afficher les notes\n   4) Retour");
											try {
											r3=sc.nextInt();
											if (r2!=1 && r2!=2  && r2!=3 && r1!=4) {
												throw new InputMismatchException("Ce choix est invalide");
												}
										}//try 1
										catch(InputMismatchException er) {//catch 1
											System.out.println();
											System.err.println("Ce choix est invalide");
											sc.nextLine();
											r2=0;
											
										}//catch 1		
											if(r3==1) {//entrer les notes 
												Class cl=resp.filière.choisirClassFilere();
												cl.addnoteStud();
											}//entrer les notes
											if(r3==2) {//modifier les notes
												Class cl=resp.filière.choisirClassFilere();
												cl.ModnoteStud();
											}//modifier les notes
											if(r3==3) {//afficher les notes
												Class cl=resp.filière.choisirClassFilere();
												cl.affichernoteModuleClass();
											}//afficher les notes
											if(r3==4) {//retour
												r2=0;
											}//retour
										}
									}//gestion des notes
									if(r2==2) {//gestion des abscences
										r2=1;
										while(r2==1) {//menu de l'abs
											System.out.println("\nChoisissez votre prochaine action:\n    1) Ajouter un absence\n    2) Justifier un absence\n    3) Retour");
											try {
											r2=sc.nextInt();
											if (r2!=1 && r2!=2  && r2!=3) {
												throw new InputMismatchException("Ce choix est invalide");
												}
										}//try 1
										catch(InputMismatchException er) {//catch 1
											System.out.println();
											System.err.println("Ce choix est invalide");
											sc.nextLine();
											r2=0;
											
										}//catch 1	
											if(r2==1) {//ajout de l'abs
												Class cl = resp.filière.choisirClassFilere();
												cl.addAbs();
												r2=1;
											}//ajout de l'abs
											if(r2==2) {//justif
												Class cl = resp.filière.choisirClassFilere();
												cl.justifieAbs();
												r2=1;
											}//justif
											if(r2==3) {//retour
												r2=0;
											}//retour
										}//menu de l'abs
										
									}//gestion des abscences
									if(r2==3) {//retour
										r1=0;
										break;
									}//retour
									
								}//MENU GESTION SCOLARIT2
							}//gestion de scolarité
							
							if(r1==3) {//retour1
								id=0;
							}//retour1
							
						}//menu respo
					}//pwd ou existence verifié
					
				}//le SET n'est pas vide
				
		
			}//connection responsable de filière
			
//-----------------------------------------------------Prof---------------------------------------------
			
			if(id==3) {//connection enseignant
				System.out.println("\n ->Entrez votre Nom ");
				String nom =sc.nextLine();
				System.out.println("\n ->Entrez votre Prénom");
				String prenom =sc.nextLine();
				System.out.println("\n ->Entrez votre mot de passe");
		 		String pwd =sc.nextLine();
				if (ecole.profEcole.isEmpty()==true) {//existence des prof
					System.out.println("Pas d'enseignants pour le moment.");
					id=0;
				}//existence des prof
				else {//le SET n'est p vide
					Prof prof =new Prof (nom, prenom,pwd);
					if(prof.exist(ecole.profEcole)==false) {//existences du prof connecte
						System.out.println("Vous n'êtes pas inscrit comme un enseignant.");
						id=0;
					}//existences du prof connecte
					else if(ecole.profverificationPWD(prof)==false) {//verifi pwd
						System.out.println("\nMot de passe est incorrecte");
						id=0;
					}//verifi pwd
					else {//pwd o existence verifié
						for(Prof p:ecole.profEcole) {//affectation des données
							if(p.equals(prof)) {//affectation des données
								prof=p;
								break;
							}//affectation des données
						}//affectation des données
							int r1=0;
							while (r1==0) {//menu Prof
								System.out.println("\n--Choisissez votre prochaine action :\n\n    1) Afficher les notes \n    2) Afficher l'emploi du temps\n    3) Retour\n");
								try {//try 1
									r1=sc.nextInt();	
									if (r1!=1 && r1!=2 && r1!=3 ) {
										throw new InputMismatchException("Ce choix est invalide");
										}
								}//try 1
								catch(InputMismatchException er) {//catch 1
									System.out.println();
									System.err.println("Ce choix est invalide");
									sc.nextLine();
									r1=0;
								}//catch 1
								if(r1==1) {//afficher les notes
									prof.element.affichenoteElement();
									r1=0;
								}
								if(r1==2) {//afficher l'emploi
									prof.module.cl.afficheEdtClass();
									r1=0;
								}
								if(r1==3) {//retour
									id=0;
								}
							}//menu Prof
						
						
					}//pwd o existence verifié
				}
			}//connection enseignant
//---------------------------------------------STUD------------------------------------
			if(id==4) {//connection etudiant
				System.out.println("\n ->Entrez votre Nom ");
				String nom =sc.nextLine();
				System.out.println("\n ->Entrez votre Prénom");
				String prenom =sc.nextLine();
				System.out.println("\n ->Entrez votre mot de passe");
		 		String pwd =sc.nextLine();
				int s1=0;
				Student s= new Student(nom, prenom,pwd);
				while(s1==0) {//menu
				if(ecole.studEcole.isEmpty()) {//ecole vide
					System.out.println("Aucun étudiant dans cette école\n Voulez-vous vous inscrire ?\n 1) Oui\n 2) Non\n");
					try {
					s1=sc.nextInt();
					
					if(s1!=1 && s1!=2) {
						throw new InputMismatchException("Ce choix est invalide");
					}
					if(s1==2) {
						s1=4;
					}
				}catch(InputMismatchException er) {//catch 1
					System.out.println();
					System.err.println("Ce choix est invalide");
					sc.nextLine();
					s1=0;
				}
				}//ecole vide
				else if(s.exist(ecole.studEcole)==false) {//n'existe pas
						
						System.out.println("Vous n'êtes pas un étudiant dans cette école :\n 1) S'inscrire\n 2) Quitter");
						try {
						
						if(s1!=1 && s1!=2) {
							throw new InputMismatchException("Ce choix est invalide");
						}
						s1=sc.nextInt();
						if(s1==2) {
							s1=4;
						}
					}catch(InputMismatchException er) {//catch 1
						System.out.println();
						System.err.println("Ce choix est invalide");
						sc.nextLine();
						s1=0;
					}//catch 1
						}//n'existe pas
				else {//etudiant existant
					for(Student st:ecole.studEcole) {//affectation des filière
						if(st.equals(s)) {//affectation de filière
							s.filière=st.filière;
							break;
						}//affectation de filière
					}//affectation de filière
					
					 if (s.verificationPWD()==false) {   //pwd incorrecte
					System.out.println("Mot de passe incorrecte");
					id=0;
					break;
				}//pwd incorrecte
				else {//verification des pwd et existence
					
				
					for(Student st:ecole.studEcole) {//affectation des données
						if(st.equals(s)) {//affectation des données
							s=st;
							break;
						}//affectation des données
					}//affectation des données
					
					System.out.println("\nChoisissez votre prochaine action :\n    1) S'inscrire pour l'année suivante\n    2) Afficher les notes\n    3) Afficher l'EDT\n    4) Retour\n" );
					try {
						s1=sc.nextInt();
						if(s1!=1 && s1!=2 && s1!=3 && s1!=4) {
							throw new InputMismatchException("Ce choix est invalide\n");
						}
					}catch(InputMismatchException er) {//catch 1
						System.out.println();
						System.err.println("Ce choix est invalide\n");
						sc.nextLine();
						s1=0;
					}//catch 1
				}//verification des pwd et existence
				}//etudiant existant
				if (s1==1) {//inscription
					InscriptionPédagogique ip=new InscriptionPédagogique(ecole);
					s=ip.getEt();
					
					s1=0;
					
				}//inscription
				if(s1==2) {//afficher les notes
					s.c.affichernoteStud(s);
					s1=0;
				}//afficher les notes
				if(s1==3) {//afficher les EDT
					s.c.afficheEdtClass();
					s1=0;
				}//afficher les EDT
				if(s1==4) {//retour
					id=0;
				}//retour
				}//menu
				
			}//connection etudiant
//----------------------------VISITEUR--------------------------------------------------------
			if(id==5) {//connection visiteur
				Visiteur v=new Visiteur(ecole);
				
				if(sc.next().equals("3")) id = 0;
			}//connection visiteur
	 		
	 		
	 		
	 		
		}//connection while(id==0)
		sc.close();
	}//main

}//class
