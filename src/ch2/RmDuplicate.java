package ch2;
import java.util.Hashtable;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/*
 * 2.1 
 */
public class RmDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(1000, 0, 2);
		System.out.println(head.printForward());
		deleteDupsRunner(head);
		System.out.println(head.printForward());
	}
	
	public static void deleteDups(LinkedListNode n){
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		LinkedListNode previous = null;
		while(n != null){
			if( table.containsKey(n.data)){
				previous.next = n.next;
			} else{
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}
	

	//no temporary buffer
	public static void deleteDupsRunner(LinkedListNode head){
		LinkedListNode current = head;
		while(current != null){
			LinkedListNode runner = current;
			while(runner.next != null){
				if(current.data == runner.next.data){
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}	
	}
}
