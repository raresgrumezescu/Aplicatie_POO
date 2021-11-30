package Tema_POO;

import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

public class Recruiter extends Employee{
	
	Company company;
	
	Recruiter(Company company, String nume_companie, int salariu, List consumers, String name, String email, String phone,
			String date_of_birth, String genre, Vector<String> languages, Vector<String> level, TreeSet<Education> education, TreeSet<Experience> experience) {
		super(name, email, phone, date_of_birth, genre, languages, level ,salariu, education, experience, consumers, nume_companie);
		// TODO Auto-generated constructor stub
		this.company = company;
	}
	
	double rating = 5;
	
	public double evaluate (Job job, User user) {
		rating += 0.1;
		Request<Job, Consumer> request = new Request<Job, Consumer>(job, user, this, user.getTotalScore());
		company.manager.requests.add(request);
		return rating * user.getTotalScore();
	}

	public static void main(String[] args){
		
	}

}
