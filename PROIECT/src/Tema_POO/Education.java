package Tema_POO;

import java.util.*;
import java.lang.*;

class InvalidDatesException extends Exception {
    
    public InvalidDatesException() {
    	super();
    }
    
    public InvalidDatesException(String s) {
    	super(s);
    }
}

class Education implements Comparable{

	String nivel;
	String nume;
	String data_inceput;
	String data_sfarsit;
	double medie;
	
	Education(String nivel, String nume, String data_inceput, String data_sfarsit, double medie) throws  InvalidDatesException{
		if (data_sfarsit != null) {
			String an1 = data_inceput.substring(6);
			//System.out.print(an1 + "\n");
			String an2 = data_sfarsit.substring(6);
			//System.out.print(an2 + "\n");
			
			String luna1 = data_inceput.substring(3, 5);
			//System.out.print(luna1 + "\n");
			String luna2 = data_sfarsit.substring(3, 5);
			//System.out.print(luna2 + "\n");
			// daca anii nu corespund cu ordinea cronologica reala, atunci se arunca cate o exceptie
			if (an1.compareTo(an2) > 0) {
				throw new InvalidDatesException ("Date invalide1!");
			}
			// daca anii sunt egali, dar lunile sunt date invers ca parametru
			else if (an1.compareTo(an2) == 0 && luna1.compareTo(luna2) > 0) {
				throw new InvalidDatesException ("Date invalide2!");
			}	//daca anul si luna sunt identice, insa zilele sunt date invers ca parametru
				else if (an1.compareTo(an2) == 0 && luna1.compareTo(luna2) == 0 && data_inceput.compareTo(data_sfarsit) > 0) {
					throw new InvalidDatesException ("Date invalide!");
			}
		}
		this.data_inceput = data_inceput;
		this.data_sfarsit = data_sfarsit;
		this.nivel = nivel;
		this.medie = medie;
		this.nume = nume;
	}
	//metoda compareTo ceruta
	public int compareTo(Object o) {
		Education ed = (Education) o;
		if (data_sfarsit == null || ed.data_sfarsit == null) {
			String an1 = data_inceput.substring(6);
			String an2 = ed.data_inceput.substring(6);
			if (an1.compareTo(an2) > 0)
				return 1;
			else if (an1.compareTo(an2) < 0)
				return -1;
				else {
					String luna1 = data_inceput.substring(2);
					String luna2 = ed.data_inceput.substring(2);
					if (luna1.compareTo(luna2) > 0)
						return 1;
					else if (luna1.compareTo(luna2) < 0)
						return -1;
					else {
						if (data_inceput.compareTo(ed.data_inceput) > 0)
							return 1;
						else if (data_inceput.compareTo(ed.data_inceput) < 0)
								return -1;
							else return 0;
					}
				}
		}
		else if (data_sfarsit != ed.data_sfarsit) {
			String an1 = data_sfarsit.substring(6);
			String an2 = ed.data_sfarsit.substring(6);
			if (an1.compareTo(an2) > 0)
				return -1;
			else if (an1.compareTo(an2) < 0)
				return 1;
				else {
					String luna1 = data_sfarsit.substring(2);
					String luna2 = ed.data_sfarsit.substring(2);
					if (luna1.compareTo(luna2) > 0)
						return -1;
					else if (luna1.compareTo(luna2) < 0)
						return 1;
					else {
						if (data_sfarsit.compareTo(ed.data_sfarsit) > 0)
							return -1;
						else if (data_sfarsit.compareTo(ed.data_sfarsit) < 0)
								return 1;
							else return 0;
					}
				}
		}
		else {
			if (medie > ed.medie) return -1;
			else if (medie < ed.medie) return 1;
			else return 0;
		}
	}
	
	public String toString () {
		return nivel + " " + nume + " " + data_inceput + " " + data_sfarsit + " " + medie + "\n";
	}
	
	public static void main(String[] args) throws InvalidDatesException{
		Education educ1 = new Education("highschool", "Thomas Jefferson High School for Science and Technology", "01.08.2000", "01.06.2004", 9.75);
		Education educ2 = new Education("college", "King's College", "01.10.2009", null, 9.89);
		Education educ3 = new Education("college", "University of Oxford", "01.08.2006", "01.06.2009", 8.75);
		Education educ4 = new Education("college", "Stanford University", "01.08.2015", "01.07.2019", 9.25);
		Education educ5 = new Education("college", "MIT", "01.08.2014", "01.06.2018", 9.50);
		
		List list = new ArrayList();
		list.add(educ1);
		list.add(educ2);
		list.add(educ3);
		list.add(educ4);
		list.add(educ5);
		Collections.sort(list);
		System.out.println(list);
		
		TreeSet<Education> edu = new TreeSet<Education>();
		edu.add(educ1);
		edu.add(educ2);
		edu.add(educ3);
		edu.add(educ4);
		edu.add(educ5);
		//System.out.println(edu);
		//System.out.println (educ1);
		//System.out.println (educ2);
		//System.out.println (educ3);
		//System.out.println (educ4);
		//System.out.println (educ1.compareTo(educ2));
	}

}
