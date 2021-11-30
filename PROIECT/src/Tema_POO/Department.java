package Tema_POO;

import java.util.*;

public abstract class Department {
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	ArrayList<Job> jobs = new ArrayList<Job>();
	
	public abstract double getTotalSalaryBudget();
	
	public ArrayList<Job> getJobs() {
		return jobs;
	}
	
	public void add (Employee employee) {
		employees.add(employee);
	}
	
	public void remove (Employee employee) {
		employees.remove(employee);
	}
	
	public void add (Job job) {
		jobs.add(job);
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
}
