package Tema_POO;

import java.util.*;

class Comp implements Comparator{
	public int compare(Object o1, Object o2){
		User u1 = (User) o1;
		User u2 = (User) o2;
		if (u1.getTotalScore() < u2.getTotalScore())
			return -1;
		else if (u1.getTotalScore() > u2.getTotalScore())
			return 1;
		else return 0;
	}
}

public class Manager extends Employee{

	Company company;
	
	SortedSet<Request<Job, Consumer>> requests = new TreeSet<Request<Job, Consumer>>(new Comp());
	
	Manager(Company company, String nume_companie, int salariu, List consumers, String name, String email, String phone,
			String date_of_birth, String genre, Vector<String> languages, Vector<String> level, TreeSet<Education> education, TreeSet<Experience> experience) {
		super(name, email, phone, date_of_birth, genre, languages, level, salariu, education, experience , consumers, nume_companie);
		// TODO Auto-generated constructor stub
		this.company = company;
	}
	
	public void process (Job job) {
		int noPositions = job.numar_candidati;
		
		Iterator<Request<Job, Consumer>> it = requests.iterator();
		while (it.hasNext()) {	
			Job j = it.next().getKey();
			if (j.equals(job) == true && it.next().getKey().numar_candidati > 0) {
				it.next().getKey().numar_candidati--;
				User u = (User) it.next().getValue1();
				Employee emp = u.convert(j.nume_companie, j.salariu);
				Iterator<Department> jt = company.departamente.iterator();
				while (jt.hasNext()) {
					if (jt.next().jobs.contains(job) == true) {
						company.add(emp, jt.next());
						break;
					}
				}
			}
			requests.remove(it.next());
		}
	}
	
	public static void main(String[] args) {
		//User ionica = 
		//Request<Job, Consumer> req1 = new Request<Job, Consumer>(web_developer, ionica, recruiter1, ionica.getTotalScore());

	}

}
