package Tema_POO;

import java.util.*;

public class Application {
// Folosind Singleton Pattern, creez un obiect de tip aplication
	private static Application app = null;
	
	private Application() {
		companies = new ArrayList<Company>();
		users = new ArrayList<User>();
	}
	
	public static Application getInstance() {
		if (app == null)
			app = new Application();
		return app;
	}
	
	ArrayList<Company> companies;
	ArrayList<User> users;
	
	public ArrayList<Company> getCompanies() {
		return companies;
	}
	// returneaza compania al carui nume a fost dat ca parametru
	// daca nu o gaseste, returneaza null
	public Company getCompany(String name) {
		Iterator<Company> it = companies.iterator();
		while (it.hasNext()) {
			if (it.next().nume.equals(name) == true)
				return it.next();
		}
		return null;
	}
	
	public void add(Company company) {
		companies.add(company);
	}
	
	public void add(User user) {
		users.add(user);
	}
	
	public boolean remove(Company company) {
		boolean isDeleted = companies.remove(company);
		return isDeleted;
	}
	
	public boolean remove(User user) {
		boolean isDeleted = users.remove(user);
		return isDeleted;
	}
	// creeaza o list de job-uri conform
	// preferintelor utilizatorului;
	// returneaza la final aceasta lista
	public ArrayList<Job> getJobs(List<String> companies) {
		ArrayList<Job> jobs = new ArrayList<Job>();
		Iterator<Company> it = this.companies.iterator();
		while (it.hasNext()) {
			if (companies.contains(it.next().nume) == true) {
				Iterator<Department> jt = it.next().departamente.iterator();
				while (jt.hasNext()) {
					for (Job j : jt.next().jobs) {
						if (j.flag == true)
							jobs.add(j);
					}
				}
			}
		}
		return jobs;
	}
	
	
	
	public static void main(String[] args) {
		

	}

}
