package Tema_POO;

import java.util.*;
import java.lang.*;
/*
class InvalidDatesException extends Exception {
    
    public InvalidDatesException() {
    	super();
    }
    
    public InvalidDatesException(String s) {
    	super(s);
    }
}
*/
class Experience implements Comparable{

	String companie;
	String pozitie;
	String departament;
	String data_inceput;
	String data_sfarsit;
	
	Experience(String companie, String pozitie, String departament, String data_inceput, String data_sfarsit) throws  InvalidDatesException{
		if (data_sfarsit != null) {
			String an1 = data_inceput.substring(6);
			//System.out.print(an1 + "\n");
			String an2 = data_sfarsit.substring(6);
			//System.out.print(an2 + "\n");
			
			String luna1 = data_inceput.substring(3);
			//System.out.print(luna1 + "\n");
			String luna2 = data_sfarsit.substring(3);
			//System.out.print(luna2 + "\n");
			// daca anii nu corespund cu ordinea cronologica reala, atunci se arunca cate o exceptie
			if (an1.compareTo(an2) > 0) {
				throw new InvalidDatesException ("Date invalide1!");
			}
			// daca anii sunt egali, dar lunile sunt date invers ca parametru
			else if (an1.compareTo(an2) == 0 && luna1.compareTo(luna2) > 0) {
				throw new InvalidDatesException ("Date invalide2!");
			}//daca anul si luna sunt identice, insa zilele sunt date invers ca parametru
				else if (an1.compareTo(an2) == 0 && luna1.compareTo(luna2) == 0 && data_inceput.compareTo(data_sfarsit) > 0) {
					throw new InvalidDatesException ("Date invalide!");
			}
		}
		this.data_inceput = data_inceput;
		this.data_sfarsit = data_sfarsit;
		this.companie = companie;
		this.departament = departament;
		this.pozitie = pozitie;
	}
	//metoda compareTo ceruta
	public int compareTo(Object o) {
		Experience ed = (Experience) o;
		if (data_sfarsit == null || ed.data_sfarsit == null) {
			if (companie.compareTo(ed.companie) > 0)
				return 1;
			else if (companie.compareTo(ed.companie) < 0)
				return -1;
				else return 0;
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
		else
			return 0;
	}
	
	public String toString () {
		return companie + " " + departament + " " + pozitie + " " + data_inceput + " " + data_sfarsit + " ";
	}
	
	public static void main(String[] args) throws InvalidDatesException{
		Experience ex1 = new Experience("Amazon", "Human Resources", "CEO", "01.08.2014", "01.06.2018");
		System.out.println(ex1);
	}

}

