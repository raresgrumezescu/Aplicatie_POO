package Tema_POO;

import java.util.*;

public class Test {

	public static void main(String[] args) throws InvalidDatesException{
/*		Vector<String> languages = new Vector<String>();
		languages.add("English");
		languages.add("French");
		Vector<String> languages_level = new Vector<String>();
		languages_level.add("Experienced");
		languages_level.add("Beginner");
		Education highschool = new Education("highschool", "Thomas Jefferson High School for Science and Technology", "01.08.2000", "01.06.2004", 9.75);
		Education college = new Education("college", "MIT", "01.08.2004", "01.06.2008", 9.00);
		TreeSet<Education> education = new TreeSet<Education>();
		education.add(highschool);
		education.add(college);
		Experience google = new Experience("Google", "SDE", "IT", "01.07.2006", "01.04.2010");
		Experience amazon = new Experience("Amazon", "Senior SDE", "IT", "01.05.2010", null);
		TreeSet<Experience> experience = new TreeSet<Experience>();
		experience.add(google);
		experience.add(amazon);
		//Vector<Consumers> consumers = new Vector<Consumers>();
		Employee employee = new Employee("Harmony Lorinda", "harmonyl@gmail.com", "+4111111111", "12.01.1986", "female", languages, languages_level, 5000, education, experience, null, experience.first().companie);
		System.out.println(employee);
*/		
		
		
/*		Vector<String> languages = new Vector<String>();
		languages.add("English");
		languages.add("French");
		Vector<String> languages_level = new Vector<String>();
		languages_level.add("Experienced");
		languages_level.add("Experienced");
		Education highschool = new Education("highschool", "High School of Brussels", "01.08.2000", "01.06.2004", 9.6);
		Education college = new Education("college", "University of Oxford", "01.08.2004", "01.06.2008", 8.8);
		TreeSet<Education> education = new TreeSet<Education>();
		education.add(highschool);
		education.add(college);
		Experience playtika = new Experience("Playtika", "Recruiter", "IT", "01.10.2009", "01.01.2013");
		Experience google = new Experience("Google", "Recruiter", "IT", "01.10.2015", null);
		TreeSet<Experience> experience = new TreeSet<Experience>();
		experience.add(playtika);
		experience.add(google);
		//Vector<Consumers> consumers = new Vector<Consumers>();
		Recruiter recruiter = new Recruiter(null, experience.first().companie, 8000, null, "Jonie Phillip", "jphilip@gmail.com", "+4123456789", "02.02.1980", "male", languages, languages_level, education, experience);
		System.out.println(recruiter);
*/	
/*	
		Vector<String> languages = new Vector<String>();
		languages.add("English");
		languages.add("French");
		Vector<String> languages_level = new Vector<String>();
		languages_level.add("Experienced");
		languages_level.add("Beginner");
		Vector<String> interested_companies = new Vector<String>();
		interested_companies.add("Google");
		Education highschool = new Education("highschool", "Gilbert Classical Academy", "01.09.2003", "01.06.2007", 6.75);
		Education college = new Education("college", "MIT", "01.08.2007", "01.06.2012", 8.8);
		Education master = new Education("master", "MIT", "01.08.2012", "01.06.2015", 9.35);
		TreeSet<Education> education = new TreeSet<Education>();
		education.add(highschool);
		education.add(college);
		education.add(master);
		Experience mit = new Experience("MIT", "Researcher", null, "01.08.2015", "01.06.2016");
		TreeSet<Experience> experience = new TreeSet<Experience>();
		experience.add(mit);
		//Vector<Consumers> consumers = new Vector<Consumers>();
		User user = new User(interested_companies, "Jonie Phillip", "jphilip@gmail.com", "+4123456789", "02.02.1980", "male", languages, languages_level, education, experience);
		System.out.println(user);
*/
		
		Vector<String> languages = new Vector<String>();
		languages.add("English");
		languages.add("French");
		Vector<String> languages_level = new Vector<String>();
		languages_level.add("Experienced");
		languages_level.add("Beginner");
		Vector<String> interested_companies = new Vector<String>();
		interested_companies.add("Google");
		Education highschool = new Education("highschool", "Gilbert Classical Academy", "01.09.2003", "01.06.2007", 6.75);
		Education college = new Education("college", "MIT", "01.08.2007", "01.06.2012", 8.8);
		Education master = new Education("master", "MIT", "01.08.2012", "01.06.2015", 9.35);
		TreeSet<Education> education = new TreeSet<Education>();
		education.add(highschool);
		education.add(college);
		education.add(master);
		Experience mit = new Experience("MIT", "Researcher", null, "01.08.2015", "01.06.2016");
		TreeSet<Experience> experience = new TreeSet<Experience>();
		experience.add(mit);
		//Vector<Consumers> consumers = new Vector<Consumers>();
		User user = new User(interested_companies, "Jonie Phillip", "jphilip@gmail.com", "+4123456789", "02.02.1980", "male", languages, languages_level, education, experience);
		System.out.println(user);
		
	}
}
