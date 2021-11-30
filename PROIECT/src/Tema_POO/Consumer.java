package Tema_POO;

import java.util.*;

public abstract class Consumer {
	
	class Resume{
		public Information info;
		public TreeSet<Education> ed;
		public TreeSet<Experience> ex;
		
		Resume(String name, String email, String phone, String date_of_birth, String genre, Vector<String> languages, Vector<String> level, TreeSet<Education> education, TreeSet<Experience> experience) {
			info = new Information (name, email, phone, date_of_birth, genre, languages, level);
			ed = education;
			ex = experience;
		}

	}

	List<Consumer> consumers = new ArrayList<Consumer>();
	Resume resume;
	
	public TreeSet<Education> getEd() {
		return resume.ed;
	}
	
	public TreeSet<Experience> getEx() {
		return resume.ex;
	}
	
	public void add (Education education) {
		resume.ed.add(education);
	}
	
	public void add (Experience experience) {
		resume.ex.add(experience);
	}
	
	public void add (Consumer consumer) {
		consumers.add(consumer);
	}
	// folosind bfs iterativ, determina cat de departe se afla consumer-ul dat
	// ca parametru de consumer-ul curent
	public int getDegreeinFriendship (Consumer consumer) {
		int grad = 0;
		Queue queue = new Queue();
		List<Consumer> vazut = new ArrayList<Consumer>();
		vazut.add(this);
		queue.Enqueue(this);
		while (queue.isEmpty() == false) {
			Consumer cons = (Consumer) queue.peek();
			for (Consumer c : cons.consumers) {
				if (consumer.equals(c) == true)
					return grad + 1;
				if (vazut.contains(c) == false) {
					vazut.add(c);
					queue.Enqueue(c);
				}
			}
			grad++;
		}
		return -1;
	}
	
	public void remove (Consumer consumer) {
		Iterator<Consumer> it;
		int index = 0;
		for (it = consumers.listIterator(); it.hasNext();) {
			if (consumer.equals(it.next()) == true)
				break;
			index++;
		}
		consumers.remove(index);
	}
	// cauta anul promovarii licentei in lista educatiei din resume
	//daca gaseste data, selecteaza cu substring() anul,
	// il converteste la Integer si il returneaza
	public Integer getGraduationYear () {
		Iterator<Education> it = resume.ed.iterator();
		while (it.hasNext()) { 
			Education edu = (Education) it.next();
			if (edu.nivel.equals("college") == true) {
				String an = edu.data_sfarsit.substring(6);
				Integer year = Integer.parseInt(an);
				return year;
			}
        }
		return null;
	}
	//determina media academica conform specificatiilor din enunt
	public Double meanGPA() {
		Iterator<Education> it = resume.ed.iterator();
		double suma = 0;
		int k = 0;
		while (it.hasNext()) { 
			Education edu = (Education) it.next();
			suma += edu.medie;
			k++;
        }
		double medie = suma / k;
		Double med = medie;
		return med;
	}
	
}
