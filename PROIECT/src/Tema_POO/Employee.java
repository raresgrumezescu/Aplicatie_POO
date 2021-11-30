package Tema_POO;

import java.util.*;

//import Tema_POO.Consumer.Resume;

public class Employee extends Consumer{

	String nume_companie;
	int salariu;
	
	Employee (String name, String email, String phone, String date_of_birth, String genre, Vector<String> languages, Vector<String> level, int salariu, TreeSet<Education> education, TreeSet<Experience> experience, List<Consumer> consumers, String nume_companie) {
		resume = new Resume (name, email, phone, date_of_birth, genre, languages, level, education, experience);
		this.consumers = consumers;
		this.nume_companie = nume_companie;
		this.salariu = salariu;
		//this.resume = resume;
	}
	
	public String toString() {
		String s = "";
		s = s + resume.info.getName() + "\n" + resume.info.getEmail() + "\n" + resume.info.getPhone() + "\n" + resume.info.getDate_of_Birth() + "\n" + resume.info.getGenre() + "\n";
		s = s + resume.info.getLanguages();
		s = s + resume.info.getLevels();
		s = s + "Education:\n";
		for (Education e : resume.ed) {
			s = s + "\t" + e.nivel + "\n";
			s = s + "\t" + e.nume + "\n";
			s = s + "\t" + e.data_inceput + "\n";
			s = s + "\t" + e.data_sfarsit + "\n";
			s = s + "\t" + e.medie + "\n";
			s = s + "\n";
		}
		s = s + "Experience:\n";
		for (Experience e : resume.ex) {
			s = s + "\t" + e.companie + "\n";
			s = s + "\t" + e.pozitie + "\n";
			s = s + "\t" + e.departament + "\n";
			s = s + "\t" + e.data_inceput + "\n";
			s = s + "\t" + e.data_sfarsit + "\n";
			s = s + "\n";
		}
		return s;
	}
	
	public static void main(String[] args) {
		//Employee employee = new Employee();
	}

}
