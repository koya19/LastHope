package gestiondeScolarit�;
import gestiondesEtudes.Student;
import gestiondesEtudes.Class;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Absence {

	protected Date date = new Date();
	private Element element = new Element();
	//protected boolean justification;
	public Map  <Student,Boolean>absStud=new TreeMap<>();
	public Map<Student,String>justif=new TreeMap<>();
	protected Class cl;
	SimpleDateFormat s= new SimpleDateFormat("dd MM yyyy");
	Scanner sc=new Scanner(System.in);
	String Newligne=System.getProperty("line.separator");
	
	public Absence(Element element,String date) throws ParseException {
		//justification =false;
		this.setElement(element);
		this.date=s.parse(date);
		this.cl=element.module.cl;
		cl.abs.add(this);
		for (Student s:cl.getStud()) {
			absStud.put(s, false);
		}
		for (Student s:cl.getStud()) {
			justif.put(s, "présent");
		}
		
	}
	public void justifieAbs(Student s) {
			if (this.justif.get(s).equalsIgnoreCase("non justifié"))
			{
				System.out.println("\nEntrez un motif d'absence :");
				String j=sc.nextLine();
				this.justif.put(s,j);
				
				element.absStud.put(s,element.absStud.get(s)-1);
				s.setNbrTotalAbsence(s.getNbrModuleNV()-1);
				this.element.notefinalElement.put(s,this.element.noteElement.get(s)-(double)((0.25)*this.element.absStud.get(s)));	
			}
			else if(this.justif.get(s).equalsIgnoreCase("présent")) {
				System.out.println("\nL'étudiant était présent");
			}
			else {
				System.out.println("\nVous avez déjà justifié l'absence de cet étudiant" );
			}
			this.element.module.notemodulestud();
	}
	
	public void addAbsence(Student s) {
		int a=this.element.absStud.get(s);
		if(absStud.get(s)==true) {
			System.out.println("\nVous avez déjà marqué cet étudiant absent dans cette séance");
		}
		else {
		justif.put(s,"Non justifié");
		absStud.put(s, true);
		s.setNbrTotalAbsence(s.getNbrModuleNV()+1);
		this.element.absStud.put(s,a+1);
		if(this.element.noteElement.get(s)!=-1) {
			this.element.notefinalElement.put(s,this.element.noteElement.get(s)-(double)((0.25)*this.element.absStud.get(s)));	
			
				
		}
		
		}
		this.element.module.notemodulestud();
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Elément "+element+" : "+s.format(date);
	}
	
	
}
