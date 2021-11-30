package Tema_POO;

import java.util.ArrayList;
// foloseste pattern-ul Factory pentru a stabili ce departamente sa creeze
public class DepartmentFactory {
	public static Department factory (String departmentName, ArrayList<Employee> employees, ArrayList<Job> jobs) {
		if (departmentName.equals("IT") == true) {
			return new IT(employees, jobs);
		}
		if (departmentName.equals("Management") == true) {
			return new Management(employees, jobs);
		}
		if (departmentName.equals("Marketing") == true) {
			return new Marketing(employees, jobs);
		}
		if (departmentName.equals("Finance") == true) {
			return new Finance(employees, jobs);
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
