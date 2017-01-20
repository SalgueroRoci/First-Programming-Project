//*******************************************************************
//  Programmer(s): Rocio Salguero
//	[Program name]  
//  Class: CPSC Java 223J - 02
// 	Project [#]
// 	Due Date:  [mm/dd/yyyy]
//	Description: [Description] 
//  
//*******************************************************************

import java.util.*; // for read from console java.util.scanner;
import java.lang.*; //Used for Math operations 
import java.io.*; //file readers 

public class Test
{
	
	public static void main(String[] args) {
		LinkedList myList = new LinkedList(); 
		int[] a = {3, 9,5,1,2};
		for (int i =0; i < a.length; ++i){
			myList.insertOrdered(a[i]);
			myList.insertQueue(a[i]);
			myList.insertStack(a[i]);
			
		}
		
		
		System.out.println("Content in the list Ordered, Queue, Stack:");
		myList.display(myList.ordered);
		myList.display(myList.queue);
		myList.display(myList.stack);
	}

	
	
	
} //end class 
    
class node {
	int info; 
	node next; 
	public node(int val) {
		info = val; 
		next = null; 		
	}
	
}

class LinkedList {
	node stack, queue, ordered; 
	LinkedList() {
		stack = null; queue = null; ordered = null; 		
	}
	
	public void insertStack(int val) {
		//insert val infront of the list LIFO
		
		node temp = new node(val); 
		temp.next = stack; 
		stack = temp; 
		
	}
	
	public void insertQueue(int val) {
		//FIFO
		node p; 
		node temp = new node(val); 
		if(queue == null) {
			queue = temp; 
		}
		else {
			//make p point to the last node 
			p = queue;
			while(p.next != null) {p = p.next;}
			p.next = temp; 
		}
	}
	
	public void insertOrdered(int val) {
		node temp = new node(val); 
		
		//find p and q 
		node p,q; 
		p = q = ordered; 
		
		while (p != null && p.info < val) {
			q = p; 
			p = p.next; 
		}
		
		if (p == ordered) {
			temp.next = p;
			ordered = temp;
		} 
		else if (p == null){
			q.next = temp; 
		}
		else {
			temp.next = p; 
			q.next = temp; 
		}
	}
	
	public int getValS() {
		//returns the last in the stack 
		return stack.info;
	}
	
	public int getValQ() {
		//returns the first in the queue
		return queue.info; 		
	}
	
	public int getValO() {
		return ordered.info; 
	}
	
	public void deleteSval() {
		node temp = stack;
		stack = temp.next; 
		temp = null; 
	}
	
	public void deleteQval() {
		node temp = queue; 
		queue = queue.next; 
		temp = null; 		
	}
	
	public void deleteOval() {
		node temp = ordered; 
		ordered = ordered.next; 
		temp = null; 
	}
	
	public void deleteOrdered(int val) {
		//find p and q 
		node p, q, temp; 
		p = q = temp = ordered; 
		
		while (temp.info != val && temp != null) {
			q = temp;
			temp = temp.next; 
			p = temp.next;
		}
		
		//delete temp node and rearrange the values 
		if (temp == ordered) {
			//if on the front of the list 
			ordered = ordered.next;
			temp = null; 
		} 
		else if (p == null) {
			//if on the last of the list 
			q.next = null; 
			temp = null; 
		}
		else if(temp == null) {
			System.out.println("Does not exist!");			
		}
		else {
			q.next = p; 
			temp = null; 
		}
		
	}
	
	public void display(node p) {
		while(p != null) {
			System.out.print(p.info + " ->");
			p = p.next;
		}
		System.out.println("null");
	}
}
