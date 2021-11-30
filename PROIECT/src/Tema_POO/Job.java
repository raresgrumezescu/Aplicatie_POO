package Tema_POO;

import java.util.*;

//import Tema_POO.Queue;

public class Job {

	String nume_job;
	String nume_companie;
	boolean flag;
	
	Constraint an_absolvire;
	Constraint numar_ani_experienta;
	Constraint medie_academica;
	
	List<User> candidati; 
	int numar_candidati;
	int salariu;
	// camp suplimentar pentru company
	Company company;
	
	public Job (Company company, String nume_job, String nume_companie, boolean flag, Constraint an_absolvire, Constraint numar_ani_experienta, Constraint medie_academica, List<User> candidati, int numar_candidati, int salariu) {
		
		this.nume_job = nume_job;
		this.nume_companie = nume_companie;
		this.flag = flag;
		
		this.an_absolvire = an_absolvire;
		this.numar_ani_experienta = numar_ani_experienta;
		this.medie_academica = medie_academica;
		
		this.candidati = candidati; 
		this.numar_candidati = numar_candidati;
		this.salariu = salariu;
		
		this.company = company;
	}
	// daca job-ul este valabil, foloseste bfs iterativ pentru
	// a se determina recruiter-ul din reteaua de utilizatori
	// a user-ului dat ca parametru
	public void apply (User user) {
		if(flag == true) {
			Recruiter recruiter = new Recruiter(null, null, 0, null, null, null, null, null, null, null, null, null, null);
			Queue queue = new Queue();
			List<Consumer> vazut = new ArrayList<Consumer>();
			vazut.add(user);
			queue.Enqueue(user);
			while (queue.isEmpty() == false) {
				Consumer cons = (Consumer) queue.peek();
				for (Consumer c : cons.consumers) {
					if (vazut.contains(c) == false) {
						vazut.add(c);
						queue.Enqueue(c);
						recruiter = (Recruiter) c;
					}
				}
			}
			// la final, se calculeaza scorul primit de la recruiter
			// dupa ce recruiter-ul a fost gasit
			double score = recruiter.evaluate(this, user);
		}
	}
	
	//metoda verifica daca user-ul dat ca parametru respecta constrangerile cerute de job in obiectele de tip Constraint.
	public boolean meetsRequirments (User user) {
		Iterator it = user.resume.ed.iterator();
		while (it.hasNext()) { 
			Education edu = (Education) it.next();
			if (edu.nivel.equals("college") == true) {
				String an = edu.data_sfarsit.substring(6);
				Integer year = Integer.parseInt(an);
				if (year > an_absolvire.sup || year < an_absolvire.inf)
					return false;
			}
        }
		it = user.resume.ex.iterator();
		int experienta = 0;
		while (it.hasNext()) {
			Experience exp = (Experience) it.next();
			String dataS = exp.data_sfarsit;
			String dataI = exp.data_inceput;
			if (dataS.substring(6).equals(dataI.substring(6)) != true) {
				int s = Integer.parseInt(dataS.substring(6), 10);
				int i = Integer.parseInt(dataI.substring(6), 10);
				experienta = experienta + s - i;
			}
			//System.out.print("Mesaj\n");
			else if (dataS.substring(3, 5).equals(dataI.substring(3, 5)) != true) {
				experienta++;
			} 
		}
		if (experienta > numar_ani_experienta.sup || experienta < numar_ani_experienta.inf)
			return false;
		Double med_acad1 = user.meanGPA();
		double med_acad2 = med_acad1;
		if (med_acad2 > medie_academica.sup || med_acad2 < medie_academica.inf)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
