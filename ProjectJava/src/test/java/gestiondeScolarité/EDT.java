package gestiondeScolarit�;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EDT {
	
	protected Date begin=new Date();
	protected Date end = new Date();
	protected String jour[]=new String[6];
	protected Element matin[]=new Element[6];
	protected Element apresmidi[]=new Element[6];
	protected String discipline = "";
	protected String examcheck;
	Scanner sc=new Scanner(System.in);
	String Newligne=System.getProperty("line.separator");
	
	
	
	
	@SuppressWarnings({ "deprecation", "unused" })
	public  EDT(String date) throws ParseException {
		SimpleDateFormat s= new SimpleDateFormat("dd MM yyyy");
		SimpleDateFormat sdf= new SimpleDateFormat("EEE ");
		begin=s.parse(date);
		end=s.parse(date);
		
		Element element= new Element();
		int i=0;
		while (i<6) {
				
				
			matin[i]=element;
			apresmidi[i]=element;
			i++;
		}
		i=0;
		while (i<5) {
			
		end.setDate(end.getDate()+1);	
		i++;
		}
		jour[0]="lun.";
		jour[1]="mar.";
		jour[2]="mer.";
		jour[3]="jeu.";
		jour[4]="ven.";
		jour[5]="sam.";
		
		System.out.println("\nVous avez créé un EDT");
	}
	 public void afficheEDT() {
		 SimpleDateFormat sdf= new SimpleDateFormat("EEEE dd MMMM yyyy");
		 System.out.println("*********************************************************************************************");
		 System.out.println("EDT de la semaine du "+ sdf.format(begin)+" au "+ sdf.format(end)+"\n");
		 
		 System.out.println("                            9h00min-12h45min           14h15min-18h00min");
		 System.out.println("");
			 for (int i=0;i<6;i++) {
			 System.out.println(jour[i]+"                     "+ matin[i].getNomElement()+"                                 "+apresmidi[i].getNomElement());
			
			 System.out.println("                        "+matin[i].enseignantElement.get(discipline)+"                                 "+apresmidi[i].enseignantElement.get(discipline));
			 System.out.println("                        Salle n° "+matin[i].salle+"                            "+"Salle n° "+apresmidi[i].salle);
			 System.out.println("");
		 }
			 System.out.println("*********************************************************************************************"); 
	 }
	
	public void addElement(int jour,int periode, Element element,String discip) {
		this.examcheck="";
		this.discipline=discip;
		if (periode ==1)
			matin [jour-1]=element;
		else
			apresmidi [jour-1]=element;	
	}
	public void addElementExam(int jour,int periode, Element element,String duree) throws ParseException {
		this.examcheck="exam";
		element.duree=duree;
		if (periode ==1)
			matin [jour-1]=element;
		else
			apresmidi [jour-1]=element;	
	}
	public void afficheEDTExam() {
		 SimpleDateFormat sdf= new SimpleDateFormat("EEEE dd MMMM yyyy");
		 
		 System.out.println("*********************************************************************************************");
		 System.out.println("EDT de la semaine du "+ sdf.format(begin)+" au "+ sdf.format(end)+"\n");
		 
		 System.out.println("                            9h00min-12h45min           14h15min-18h00min");
		 System.out.println("");
			 for (int i=0;i<6;i++) {
			 System.out.println(jour[i]+"                               "+ matin[i].getNomElement()+"                                 "+apresmidi[i].getNomElement());
			
			 System.out.println("                        "+matin[i].duree+"                                 "+apresmidi[i].duree);
			 System.out.println("");
		 }
			 System.out.println("*********************************************************************************************"); 
	 }

	public Date getBegin() {
		return begin;
	}
	public Date getEnd() {
		return end;
	}
	public void getmatin() {
		System.out.println(matin);
	}
	public String getDiscipline() {
		return discipline;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf= new SimpleDateFormat("EEEE dd MMMM yyyy");
		return sdf.format(begin);
	}
	public String getExamcheck() {
		return examcheck;
	}
	public void setExamcheck(String examcheck) {
		this.examcheck = examcheck;
	}
	
	
}
