package Tema_POO;

import Tema_POO.Queue.Node;
// Clasa suplimentara pe care o folosesc pentru
// a crea cozile de care am nevoie la bfs-uri
public class Queue {
	class Node {
		Object item; 
		Node link; 
		Node (Object item ,Node link) {
			this.item = item ;
			this.link = link ;
		}
	}
	
	private Node bottom = null;
	private Node top = null;
	
	public void Enqueue (Object item) {
		Node node = new Node(item , top);
		if (bottom == null) {
			bottom = top = node;
			top.link = null;
			bottom.link = null;
		}
		else if (bottom == top && bottom != null) {
			top.link = node;
			top.link.link = null;
			top = node;
			bottom.link = top;
		}
			else {
				top.link = node;
				top.link.link = null;
				top = node;
			}
	}
	
	public void Dequeue () {
		Node p;
		if (bottom == null)
			System.out.print("Coada este goala!");
		else {
			p = bottom;
			bottom = bottom.link;
		}
	}
	
	public Object peek () {
		if (bottom == null) {
			System.out.print("Coada este goala!");
			return null;
	}
		else
			return bottom.item ;
	}
	
	public boolean isEmpty () {
		//return bottom == null;
		if (bottom == null)
			return true;
		return false;
	}
	
	public String toString () {
		String q="";
		Node node = bottom;
		while (node != null ) {
			//System.out.print("Mesaj\n");
			q += node.item + " ";
			node = node.link ;
		}
		return q;
	}
	
	public static void main (String[] args) {
		Queue queue = new Queue();
		queue.Enqueue(1);
		queue.Enqueue(2);
		queue.Enqueue(3);
		System.out.println(queue.toString());
	}
}