package ch2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/*
 * delete a node in the middle of a single linked list, given only access to that node
 */
public class DeleteNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteNodeMiddle(head.next.next.next.next); // delete node 4
		System.out.println(head.printForward());

	}
	public static boolean deleteNodeMiddle(LinkedListNode node){
		if(node == null || node.next == null) {return false;}
		node.data = node.next.data;
		node.next = node.next.next;
		return true;
	}
}
