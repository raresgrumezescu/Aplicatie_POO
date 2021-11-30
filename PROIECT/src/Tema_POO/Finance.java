package Tema_POO;

import java.util.ArrayList;
// clasa Finance
public class Finance extends Department{

	Finance(ArrayList<Employee> employees, ArrayList<Job> jobs) {
		this.employees = employees;
		this.jobs = jobs;
	}
	
	public double getTotalSalaryBudget() {
		
		double salariu_total = 0;
		for (Employee e : employees) {
			salariu_total += e.salariu + 0.16 * e.salariu;
		}
		return salariu_total;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
