package ch2;
import CtCILibrary.*;

/*
 *  partition a linked list so that all node less than x come before all nodes greater or larger than
 */

public class Partition {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {1, 3, 7, 5, 2, 9, 4};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());
		
		/* Partition */
		LinkedListNode h = partition(head, 5);
		
		/* Print Result */
		System.out.println(h.printForward());

	}
	
	public static LinkedListNode partition(LinkedListNode node, int x){
		LinkedListNode beforeHead = null;
		LinkedListNode beforeTail = null;
		LinkedListNode afterHead = null;
		LinkedListNode afterTail = null;
		
		while(node != null){
			LinkedListNode next = node.next;
			node.next = null;
			if(node.data < x){
				//append to before
				if(beforeHead == null){ 
					beforeHead = node;
					beforeTail = node;
					}else{
						beforeTail.next = node;
						beforeTail = node;
					}
			} else{
				//append to after
				if(afterHead == null){
					afterHead = node;
					afterTail = node;
				}else{
					afterTail.next = node;
					afterTail = node;
				}
			}
			node = next;
		}
		//merge
		beforeTail.next = afterHead;
		return beforeHead;
	}

}
