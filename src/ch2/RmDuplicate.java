package ch2;
import java.util.Hashtable;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/*
 * 2.1 remove duplicates from a unsorted linked list
 */
public class RmDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 4);
		System.out.println(head.printForward());
//		deleteDupsRunner(head);
		insertNth(head, new LinkedListNode(5, null, null), 2);
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
//	insertNth()
//	sortedInsert()
//	insertSort()
//	append()
//	frontbacksplit() // odd and even
//	removeDuplicate()
//	MoveNodes()
	
	public static boolean insertNth(LinkedListNode head, LinkedListNode node, int pos){
		for(int i=0; i < pos; ++i){
			if(head != null){
				head = head.next;//could be null now
			}else{
				return false;//not enough n
			}
		}
		LinkedListNode next = head.next;
		head.next = node;
		node.next = next;
		return  true;
	}
}
