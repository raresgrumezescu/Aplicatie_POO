package Tema_POO;

import java.util.*;

public class Information {

	private String name;
	private String email;
	private String phone;
	private String date_of_birth;
	private String genre;
	
	//private List<String> languages = new ArrayList<String>();
	private Vector<String> languages = new Vector<String>();
	private Vector<String> level = new Vector<String>();
	//private List<String> level = new ArrayList<String>();
	
	Information(String name, String email, String phone, String date_of_birth, String genre, Vector<String> languages, Vector<String> level) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.date_of_birth = date_of_birth;
		this.genre = genre;
		this.languages = languages;
		this.level = level;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getDate_of_Birth() {
		return date_of_birth;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public String getLanguages() {
/*		Iterator<String> iter = languages.iterator();
		String lista = "";
		for (iter = languages.listIterator(); iter.hasNext();) {
			String cuvant = (String) iter.next();
			lista = lista + cuvant + " ";
		}*/
		String lista = "";
		for (String s : languages) {
			lista = lista + s + " ";
		}
		lista = lista + "\n";
		return lista;
	}
	
	public String getLevels() {
/*		ListIterator<String> iter;
		String lista = "";
		for (iter = level.listIterator(); iter.hasNext();) {
			String cuvant = (String) iter.next();
			lista = lista + cuvant + " ";
		}*/
		String lista = "";
		for (String s : level) {
			lista = lista + s + " ";
		}
		lista = lista + "\n";
		return lista;
	}
	
	public Vector<String> getList_of_Languages() {
		return languages;
	}
	
	public Vector<String> getList_of_Levels() {
		return level;
	}
	
	public static void main(String[] args) {
		List<String> languages = new ArrayList<String>();
		languages.add("English");
		languages.add("German");
		languages.add("French");
		languages.add("Romanian");
		
		List<String> level = new ArrayList<String>();
		level.add("Beginner");
		level.add("Advanced");
		level.add("Experienced");
		level.add("Experienced");
		
/*		Information info = new Information("Ionescu Ion", "ionescuion@gmail.com", "0707007007", "01.01.1999", "male", languages, level);
		System.out.println(info.getName());
		System.out.println(info.getEmail());
		System.out.println(info.getPhone());
		System.out.println(info.getDate_of_Birth());
		System.out.println(info.getGenre());
		System.out.println(info.getLanguages());
		System.out.println(info.getLevels());
	*/
	}

}
