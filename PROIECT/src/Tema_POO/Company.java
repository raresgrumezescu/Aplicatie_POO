package Tema_POO;

import java.util.*;

//import Tema_POO.Queue;

public class Company {

	String nume;
	// camp suplimentar in care pastrez manager-ul companiei
	Manager manager;
	ArrayList<Department> departamente = new ArrayList<Department>();
	ArrayList<Recruiter> recruiters = new ArrayList<Recruiter>();
	
	Company() {
		
	}
	
	Company (String nume, Manager manager, ArrayList<Department> departamente ,ArrayList<Recruiter> recruiters) {
		this.nume = nume;
		this.manager = manager;
		this.departamente = departamente;
		this.recruiters = recruiters;
	}
	
	public void add (Department department) {
		departamente.add(department);
	}
	
	public void add (Recruiter recruiter) {
		recruiters.add(recruiter);
	}
	
	public void add (Employee employee, Department department) {
		ListIterator<Department> it;
		for (it = departamente.listIterator(); it.hasNext();) {
			Department dep = (Department) it.next();
			if (dep.equals(department) == true) {
				dep.employees.add(employee);
			}
		}
	}
	
	public void remove (Employee employee) {
		ListIterator<Department> it;
		for (it = departamente.listIterator(); it.hasNext();) {
			Department dep = (Department) it.next();
			if (dep.employees.contains(employee) == true) {
				dep.employees.remove(employee);
			}
		}
	}
	
	public void remove (Department department) {
		ListIterator<Department> it;
		for (it = departamente.listIterator(); it.hasNext();) {
			Department dep = (Department) it.next();
			if (dep.equals(department) == true) {
				dep.employees.clear();
				departamente.remove(dep);
			}
		}
	}
	
	public void remove (Recruiter recruiter) {
		recruiters.remove(recruiter);
	}
	
	public void move (Department source, Department destination) {
		ListIterator<Employee> it;
		for (it = source.employees.listIterator(); it.hasNext();) {
			Employee empl = (Employee) it.next();
			destination.employees.add(empl);
		}
	}
	
	public void move (Employee employee, Department newDepartment) {
		ListIterator<Department> it;
		for (it = departamente.listIterator(); it.hasNext();) {
			Department dep = (Department) it.next();
			if (dep.employees.contains(employee) == true) {
				dep.employees.remove(employee);
			}
		}
		newDepartment.employees.add(employee);
	}
	
	public boolean contains (Department department) {
		return departamente.contains(department);
	}
	
	public boolean contains (Employee employee) {
		ListIterator<Department> it;
		for (it = departamente.listIterator(); it.hasNext();) {
			Department dep = (Department) it.next();
			if (dep.employees.contains(employee) == true) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains (Recruiter recruiter) {
		return recruiters.contains(recruiter);
	}
	// folosind bfs iterativ, gaseste recruiter-ul potrivit
	public Recruiter getRecruiter (User user) {
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
		return recruiter;
		//double score = recruiter.evaluate(this, user);
	}
	//determina job-urile disponibile dintr-o companie
	// creeaza o lista cu aceste job-uri pe care apoi o returneaza
	public ArrayList<Job> getJobs() {
		ArrayList<Job> avaiable = new ArrayList<Job>();
		ListIterator<Department> it;
		for (it = departamente.listIterator(); it.hasNext();) {
			Department dep = (Department) it.next();
			ListIterator<Job> jt;
			for (jt = dep.jobs.listIterator(); jt.hasNext();) {
				Job job = (Job) jt.next();
				if (job.flag == true) {
					avaiable.add(job);
				}
			}
		}
		return avaiable;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
