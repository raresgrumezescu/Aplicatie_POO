package Tema_POO;

import java.util.*;
import java.lang.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonTest {

	public static void main(String args[]) throws InvalidDatesException{
	      //Creating a JSONParser object
	      JSONParser jsonParser = new JSONParser();
	      List<Employee> employees = new ArrayList<>();
	      List<User> users = new ArrayList<>();
	      List<Recruiter> recruiters = new ArrayList<>();
	      List<Manager> managers = new ArrayList<>();
	      
	      JSONParser jsonParser2 = new JSONParser();
	      List<Company> companies = new ArrayList<>();
	      List<socialMedia> socialMedias = new ArrayList<>();
	      
	      try {
	    	  Reader reader = new FileReader("C:\\Users\\rares\\Desktop\\consumers.json");
	         //Parsing the contents of the JSON file
	         JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
	         JSONArray employeesJson = (JSONArray) jsonObject.get("employees");
	         
	         for (Object emp : employeesJson) {
	        	 String name = (String) ((JSONObject) emp).get("name");
		         String email = (String) ((JSONObject) emp).get("email");
		         String phone = (String) ((JSONObject) emp).get("phone");
		         String date_of_birth = (String) ((JSONObject) emp).get("date_of_birth");
		         String genre = (String) ((JSONObject) emp).get("genre");
	        	 
		         JSONArray languagesJson = (JSONArray) ((JSONObject) emp).get("languages");
		         Vector<String> language = new Vector<String>();
		         JSONArray levelsJson = (JSONArray) ((JSONObject) emp).get("languages_level");
		         Vector<String> lev = new Vector<String>();
		         for (Object l : languagesJson) {
		        	 language.add((String) l);
		         }
		         
		         for (Object l : levelsJson) {
		        	 lev.add((String) l);
		         }
		         
		         long salary = (long) ((JSONObject) emp).get("salary");
		         
		         TreeSet<Education> education = new TreeSet<>();
		         TreeSet<Experience> experience = new TreeSet<>();
	        	 
		         JSONArray educationJson = (JSONArray) ((JSONObject) emp).get("education");
	        	 for (Object edu : educationJson) {
	        		 String level = (String) ((JSONObject) edu).get("level");
			         String name_edu = (String) ((JSONObject) edu).get("name");
			         String start_date = (String) ((JSONObject) edu).get("start_date");
			         String end_date = (String) ((JSONObject) edu).get("end_date");
			         String grade = (String) ((JSONObject) edu).get("grade");
			         Education ed = new Education(level, name_edu, start_date, end_date, Double.parseDouble(grade));
			         education.add(ed);
	        	 }
	        	 
	        	 JSONArray experienceJson = (JSONArray) ((JSONObject) emp).get("experience");
	        	 for (Object exp : experienceJson) {
	        		 String company = (String) ((JSONObject) exp).get("company");
			         String position = (String) ((JSONObject) exp).get("position");
			         String department = (String) ((JSONObject) exp).get("department");
			         String start_date = (String) ((JSONObject) exp).get("start_date");
			         String end_date = (String) ((JSONObject) exp).get("end_date");
			         Experience ex = new Experience(company, position, department, start_date, end_date);
			         experience.add(ex);
	        	 }
	        	 
	        	 Employee employee = new Employee(name, email, phone, date_of_birth, genre, null, null, (int) salary, education, experience, null, experience.first().companie);
	        	 employees.add(employee);
		      
	         }
	         
	         
	         JSONArray recruitersJson = (JSONArray) jsonObject.get("recruiters");
	         
	         for (Object rec : recruitersJson) {
	        	 String name = (String) ((JSONObject) rec).get("name");
		         String email = (String) ((JSONObject) rec).get("email");
		         String phone = (String) ((JSONObject) rec).get("phone");
		         String date_of_birth = (String) ((JSONObject) rec).get("date_of_birth");
		         String genre = (String) ((JSONObject) rec).get("genre");
	        	 
		         JSONArray languagesJson = (JSONArray) ((JSONObject) rec).get("languages");
		         Vector<String> language = new Vector<String>();
		         JSONArray levelsJson = (JSONArray) ((JSONObject) rec).get("languages_level");
		         Vector<String> lev = new Vector<String>();
		         for (Object l : languagesJson) {
		        	 language.add((String) l);
		         }
		         
		         for (Object l : levelsJson) {
		        	 lev.add((String) l);
		         }
		         
		         long salary = (long) ((JSONObject) rec).get("salary");
		         
		         TreeSet<Education> education = new TreeSet<>();
		         TreeSet<Experience> experience = new TreeSet<>();
	        	 
		         JSONArray educationJson = (JSONArray) ((JSONObject) rec).get("education");
	        	 for (Object edu : educationJson) {
	        		 String level = (String) ((JSONObject) edu).get("level");
			         String name_edu = (String) ((JSONObject) edu).get("name");
			         String start_date = (String) ((JSONObject) edu).get("start_date");
			         String end_date = (String) ((JSONObject) edu).get("end_date");
			         String grade = (String) ((JSONObject) edu).get("grade");
			         Education ed = new Education(level, name_edu, start_date, end_date, Double.parseDouble(grade));
			         education.add(ed);
	        	 }
	        	 
	        	 JSONArray experienceJson = (JSONArray) ((JSONObject) rec).get("experience");
	        	 for (Object exp : experienceJson) {
	        		 String company = (String) ((JSONObject) exp).get("company");
			         String position = (String) ((JSONObject) exp).get("position");
			         //String department = (String) ((JSONObject) exp).get("department");
			         String start_date = (String) ((JSONObject) exp).get("start_date");
			         String end_date = (String) ((JSONObject) exp).get("end_date");
			         Experience ex = new Experience(company, position, "IT", start_date, end_date);
			         experience.add(ex);
	        	 }
	        	 
	        	 Recruiter recruiter = new Recruiter(null, experience.first().companie, (int) salary, null, name, email, phone, date_of_birth, genre, language, lev, education, experience);
	        	 recruiters.add(recruiter);
		      
	         }
	         
	         
	         JSONArray usersJson = (JSONArray) jsonObject.get("users");
	         
	         for (Object use : usersJson) {
	        	 String name = (String) ((JSONObject) use).get("name");
		         String email = (String) ((JSONObject) use).get("email");
		         String phone = (String) ((JSONObject) use).get("phone");
		         String date_of_birth = (String) ((JSONObject) use).get("date_of_birth");
		         String genre = (String) ((JSONObject) use).get("genre");
	        	 
		         JSONArray languagesJson = (JSONArray) ((JSONObject) use).get("languages");
		         Vector<String> language = new Vector<String>();
		         JSONArray levelsJson = (JSONArray) ((JSONObject) use).get("languages_level");
		         Vector<String> lev = new Vector<String>();
		         for (Object l : languagesJson) {
		        	 language.add((String) l);
		         }
		         
		         for (Object l : levelsJson) {
		        	 lev.add((String) l);
		         }
		         
		         JSONArray interested_companiesJson = (JSONArray) ((JSONObject) use).get("interested_companies");
		         Vector<String> int_comp = new Vector<String>();
		         for (Object ic : interested_companiesJson) {
		        	 int_comp.add((String) ic);
		         }
		         
		         TreeSet<Education> education = new TreeSet<>();
		         TreeSet<Experience> experience = new TreeSet<>();
	        	 
		         JSONArray educationJson = (JSONArray) ((JSONObject) use).get("education");
	        	 for (Object edu : educationJson) {
	        		 String level = (String) ((JSONObject) edu).get("level");
			         String name_edu = (String) ((JSONObject) edu).get("name");
			         String start_date = (String) ((JSONObject) edu).get("start_date");
			         String end_date = (String) ((JSONObject) edu).get("end_date");
			         String grade = (String) ((JSONObject) edu).get("grade");
			         Education ed = new Education(level, name_edu, start_date, end_date, Double.parseDouble(grade));
			         education.add(ed);
	        	 }
	        	 
	        	 JSONArray experienceJson = (JSONArray) ((JSONObject) use).get("experience");
	        	 for (Object exp : experienceJson) {
	        		 String company = (String) ((JSONObject) exp).get("company");
			         String position = (String) ((JSONObject) exp).get("position");
			         //String department = (String) ((JSONObject) exp).get("department");
			         String start_date = (String) ((JSONObject) exp).get("start_date");
			         String end_date = (String) ((JSONObject) exp).get("end_date");
			         Experience ex = new Experience(company, position, "IT", start_date, end_date);
			         experience.add(ex);
	        	 }
	        	 
	        	 //long salary = (long) ((JSONObject) use).get("salary");
	        	 User user = new User(null, name, email, phone, date_of_birth, genre, language, lev, education, experience);
	        	 users.add(user);
		      
	         }
	         
	         JSONArray managersJson = (JSONArray) jsonObject.get("managers");
	         
	         for (Object man : managersJson) {
	        	 String name = (String) ((JSONObject) man).get("name");
		         String email = (String) ((JSONObject) man).get("email");
		         String phone = (String) ((JSONObject) man).get("phone");
		         String date_of_birth = (String) ((JSONObject) man).get("date_of_birth");
		         String genre = (String) ((JSONObject) man).get("genre");
	        	 
		         JSONArray languagesJson = (JSONArray) ((JSONObject) man).get("languages");
		         Vector<String> language = new Vector<String>();
		         JSONArray levelsJson = (JSONArray) ((JSONObject) man).get("languages_level");
		         Vector<String> lev = new Vector<String>();
		         for (Object l : languagesJson) {
		        	 language.add((String) l);
		         }
		         
		         for (Object l : levelsJson) {
		        	 lev.add((String) l);
		         }
		         
		         long salary = (long) ((JSONObject) man).get("salary");
		         
		         TreeSet<Education> education = new TreeSet<>();
		         TreeSet<Experience> experience = new TreeSet<>();
	        	 
		         JSONArray educationJson = (JSONArray) ((JSONObject) man).get("education");
	        	 for (Object edu : educationJson) {
	        		 String level = (String) ((JSONObject) edu).get("level");
			         String name_edu = (String) ((JSONObject) edu).get("name");
			         String start_date = (String) ((JSONObject) edu).get("start_date");
			         String end_date = (String) ((JSONObject) edu).get("end_date");
			         String grade = (String) ((JSONObject) edu).get("grade");
			         Education ed = new Education(level, name_edu, start_date, end_date, Double.parseDouble(grade));
			         education.add(ed);
	        	 }
	        	 
	        	 JSONArray experienceJson = (JSONArray) ((JSONObject) man).get("experience");
	        	 for (Object exp : experienceJson) {
	        		 String company = (String) ((JSONObject) exp).get("company");
			         String position = (String) ((JSONObject) exp).get("position");
			         //String department = (String) ((JSONObject) exp).get("department");
			         String start_date = (String) ((JSONObject) exp).get("start_date");
			         String end_date = (String) ((JSONObject) exp).get("end_date");
			         Experience ex = new Experience(company, position, "IT", start_date, end_date);
			         experience.add(ex);
	        	 }
	        	 
	        	 //long salary = (long) ((JSONObject) use).get("salary");
	        	 Manager manager = new Manager(null, experience.first().companie, (int) salary, null, name, email, phone, date_of_birth, genre, language, lev, education, experience);
	        	 managers.add(manager);
		      
	         }
	         
/*	         String id = (String) jsonObject.get("ID");
	         String first_name = (String) jsonObject.get("First_Name");
	         String last_name = (String) jsonObject.get("Last_Name");
	         String date_of_birth = (String) jsonObject.get("Date_Of_Birth");
	         String place_of_birth = (String) jsonObject.get("Place_Of_Birth");
	         String country = (String) jsonObject.get("Country");
	         //Forming URL
	         System.out.println("Contents of the JSON are: ");
	         System.out.println("ID :"+id);
	         System.out.println("First name: "+first_name);
	         System.out.println("Last name: "+last_name);
	         System.out.println("Date of birth: "+date_of_birth);
	         System.out.println("Place of birth: "+place_of_birth);
	         System.out.println("Country: "+country);
	         System.out.println(" ");
	         */
	    
	         Reader reader2 = new FileReader("C:\\Users\\rares\\Desktop\\consumers2.json");
	         
	         JSONObject jsonObject2 = (JSONObject) jsonParser.parse(reader2);
	         JSONArray companiesJson = (JSONArray) jsonObject.get("companies");    
	         
	         for (Object comp : companiesJson) {
	        	 String name = (String) ((JSONObject) comp).get("name");
	        	 
		         JSONArray itJson = (JSONArray) ((JSONObject) comp).get("it");
		         Vector<String> it = new Vector<String>();
		         
		         JSONArray managementJson = (JSONArray) ((JSONObject) comp).get("management");
		         Vector<String> management = new Vector<String>();
		         
		         JSONArray financeJson = (JSONArray) ((JSONObject) comp).get("finance");
		         Vector<String> finance = new Vector<String>();
		         
		         JSONArray marketingJson = (JSONArray) ((JSONObject) comp).get("marketing");
		         Vector<String> marketing = new Vector<String>();
		         
		         JSONArray recruiters2Json = (JSONArray) ((JSONObject) comp).get("recruiters");
		         Vector<String> recruiters2 = new Vector<String>();
		         
		         for (Object i : itJson) {
		        	 it.add((String) i);
		         }
		         
		         for (Object m : managementJson) {
		        	 management.add((String) m);
		         }
		         
		         for (Object f : financeJson) {
		        	 finance.add((String) f);
		         }
		         
		         for (Object m : marketingJson) {
		        	 marketing.add((String) m);
		         }
		         
		         for (Object r : recruiters2Json) {
		        	 recruiters2.add((String) r);
		         }
		         
		         JSONArray jobsJson = (JSONArray) ((JSONObject) comp).get("jobs");
		         ArrayList<Job> jobs = new ArrayList<>();
		         
	        	 for (Object jb : jobsJson) {
	        		 String jobName = (String) ((JSONObject) jb).get("jobName");
			         long noPosition = (long) ((JSONObject) jb).get("noPosition");
			         long salary = (long) ((JSONObject) jb).get("salary");
			         long graduationMin = (long) ((JSONObject) jb).get("graduationMin");
			         long graduationMax = (long) ((JSONObject) jb).get("graduationMax");
			         long experienceMin = (long) ((JSONObject) jb).get("experienceMin");
			         long experienceMax = (long) ((JSONObject) jb).get("experienceMax");
			         long averageMin = (long) ((JSONObject) jb).get("averageMin");
			         long averageMax = (long) ((JSONObject) jb).get("averageMax");
			         Constraint an_absolvire = new Constraint ((int)graduationMin,(int) graduationMax);
			         Constraint numar_ani_experienta = new Constraint ((int) experienceMin,(int) experienceMax);
			         Constraint medie_academica = new Constraint ((int) averageMin, (int) averageMax);
			         Job job = new Job (null, jobName, name, true, an_absolvire, numar_ani_experienta, medie_academica, null, (int) noPosition, (int) salary);
			         jobs.add(job);
	        	 }
	        	 
	        	 ArrayList<Employee> emplIt = new ArrayList<Employee>();
	        	 ArrayList<Employee> emplMan = new ArrayList<Employee>();
	        	 ArrayList<Employee> emplFin = new ArrayList<Employee>();
	        	 ArrayList<Employee> emplMar = new ArrayList<Employee>();
	        	 
	        	 for (Employee e : employees) {
	        		 if (e.nume_companie.equals("IT") == true)
	        			 emplIt.add(e);
	        		 if (e.nume_companie.equals("Management") == true)
	        			 emplMan.add(e);
	        		 if (e.nume_companie.equals("Finance") == true)
	        			 emplFin.add(e);
	        		 if (e.nume_companie.equals("Marketing") == true)
	        			 emplMar.add(e);
	        	 }
	        	 
	        	 DepartmentFactory fact = new DepartmentFactory();
		         IT It = (IT) fact.factory("IT", emplIt, jobs);
		         Management Management = (Management) fact.factory("Management", emplMan, null);
		         Finance Finance = (Finance) fact.factory("Finance", emplFin, null);
		         Marketing Marketing = (Marketing) fact.factory("Marketing", emplMar, null);
	        	 
		         ArrayList<Department> departamente = new ArrayList<Department>();
		     	 //ArrayList<Recruiter> recruit = new ArrayList<Recruiter>();
		     	 
		     	 ArrayList<Recruiter> goog = new ArrayList<>();
		     	 ArrayList<Recruiter> amaz = new ArrayList<>();
		     	 
		     	for (Recruiter r : recruiters) {
	        		 if (recruiters2.contains(r.resume.info.getName()) == true && name.equals("Google") == true)
	        			 goog.add(r);
	        		 if (recruiters2.contains(r.resume.info.getName()) == true && name.equals("Amazon") == true)
	        			 amaz.add(r);
	        	 }
		     	
		     	Company company = new Company();
		        for (Manager m : managers) {
		        	if (m.nume_companie.equals("Google") == true) {
		        		company = new Company (name, m, departamente, goog);
		        		m.company = company;
		        		for (Recruiter r : goog) {
		        			r.company = company;
		        		}
		        	}
		        	if (m.nume_companie.equals("Amazon") == true) {
		        		company = new Company (name, m, departamente, amaz);
		        		m.company = company;
		        		for (Recruiter r : amaz) {
		        			r.company = company;
		        		}
		        	}
		        }
		        
		        companies.add(company);
	         }
/*	         
	      JSONArray socialMediaJson = (JSONArray) jsonObject.get("companies");
	      for (Object sM : socialMediaJson) {
	    	  String jobName = (String) ((JSONObject) jb).get("jobName");
	      }
*/	         
	         
	      } catch (FileNotFoundException e) {
	            e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ParseException e) {
	         e.printStackTrace();
	      }
	      
	   }

}
