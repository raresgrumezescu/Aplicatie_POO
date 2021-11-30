package Tema_POO;

import java.util.ArrayList;
//clasa Marketing
public class Marketing extends Department{

	Marketing(ArrayList<Employee> employees, ArrayList<Job> jobs) {
		this.employees = employees;
		this.jobs = jobs;
	}
	
	public double getTotalSalaryBudget() {
		
		double salariu_total = 0;
		for (Employee e : employees) {
			if (e.salariu > 5000)
				salariu_total += e.salariu + 0.1 * e.salariu;
			else if (e.salariu < 3000)
				salariu_total += e.salariu;
				else
					salariu_total += e.salariu + 0.16 * e.salariu;
		}
		return salariu_total;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

