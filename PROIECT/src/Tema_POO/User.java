package Tema_POO;

import java.util.*;
import java.lang.*;

public class User extends Consumer {

	List<String> companies = new ArrayList<String>();
	
	User (List<String> companies, String name, String email, String phone, String date_of_birth, String genre, Vector<String> languages, Vector<String> level, TreeSet<Education> education, TreeSet<Experience> experience) {
		resume = new Resume (name, email, phone, date_of_birth, genre, languages, level, education, experience);
		//this.consumers = consumers;
		this.companies = companies;
	}
	// returneaza un obiect de tip employee rezultat pe baza
	//informatiilor luate de la obiectul user primit ca parametru
	public Employee convert(String companie, int salariu) {
		Employee employee = new Employee (resume.info.getName(), resume.info.getEmail(), resume.info.getPhone(), resume.info.getDate_of_Birth(), resume.info.getGenre(), resume.info.getList_of_Languages(), resume.info.getList_of_Levels(), salariu, this.getEd(), this.getEx(), consumers, companie);
		return employee;
	}
	// returneaza scorul total calculat pe baza cerintelor din enunt
	public Double getTotalScore() {
		Iterator it = resume.ex.iterator();
		int experienta = 0;
		while (it.hasNext()) {
			Experience exp = (Experience) it.next();
			String dataS = exp.data_sfarsit;
			String dataI = exp.data_inceput;
			//System.out.print(dataS + "\n" + dataI + "\n");
			//System.out.print(dataS.substring(6) + "\n" + dataI.substring(6) + "\n");
			//System.out.print(dataS.substring(3, 5) + "\n" + dataI.substring(3, 5) + "\n");
			if (dataS.substring(6).equals(dataI.substring(6)) != true) {
				int s = Integer.parseInt(dataS.substring(6), 10);
				int i = Integer.parseInt(dataI.substring(6), 10);
				experienta = experienta + s - i;
				//experienta++;
			}
			//System.out.print("Mesaj\n");
			else if (dataS.substring(3, 5).equals(dataI.substring(3, 5)) != true) {
				experienta++;
			} 
		}
		//System.out.print(experienta + "\n");
		Double med_acad1 = this.meanGPA();
		double med_acad2 = med_acad1;
		double medie = experienta * 1.5 + med_acad2;
		Double ret = medie;
		return ret;
	}
	
	public String toString() {
		String s = "";
		s = s + resume.info.getName() + "\n" + resume.info.getEmail() + "\n" + resume.info.getPhone() + "\n" + resume.info.getDate_of_Birth() + "\n" + resume.info.getGenre() + "\n";
		s = s + resume.info.getLanguages();
		s = s + resume.info.getLevels();
		s = s + "Interested companies:\t";
		for (String c : companies) {
			s = s + c;
		}
		s = s + "\n";
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
			//s = s + "\t" + e.departament + "\n";
			s = s + "\t" + e.data_inceput + "\n";
			s = s + "\t" + e.data_sfarsit + "\n";
			s = s + "\n";
		}
		return s;
	}
	
	public static void main(String[] args) throws InvalidDatesException{
		List<String> companii = new ArrayList<String> ();
		companii.add("IBM");
		companii.add("Intel");
		companii.add("Dell");
		companii.add("Lenovo");
		List<User> users = new ArrayList<User>();
		Vector<String> languages = new Vector<String>();
		languages.add("English");
		languages.add("German");
		languages.add("French");
		languages.add("Romanian");
		
		Vector<String> level = new Vector<String>();
		level.add("Beginner");
		level.add("Advanced");
		level.add("Experienced");
		level.add("Experienced");
		User user1 = new User(companii, "Marinescu", "marinescu@gmai.com", "0770070707", "02.01.1999", "Male", languages, level, null, null);
		User user2 = new User(companii, "Lucian", "patrascanul@gmai.com", "0770070707", "04.10.1900", "Male", languages, level, null, null);
		user1.add(user2);
		System.out.println(user1.getDegreeinFriendship(user2));
		Experience ex1 = new Experience("Amazon", "Human Resources", "CEO", "01.08.2014", "01.06.2018");
		user1.add(ex1);
		Education educ5 = new Education("college", "MIT", "01.08.2014", "01.06.2018", 9.50);
		//Education educ6 = new Education("highschool", "MIT", "01.08.2014", "01.06.2014", 8.75);
		user1.add(educ5);
		//user1.add(educ6);
		//System.out.println(user1.resume.info.getName());
		//System.out.println(user1.resume.ex.toString());
		//System.out.println(user1.resume.ed.toString());
		System.out.println(user1.consumers.get(0).resume.info.getName());
		System.out.println(user1.getTotalScore());
		Employee employee = user1.convert("Bitdefender", 4000);
		System.out.println(employee.salariu + " " + employee.nume_companie);
	}

}
