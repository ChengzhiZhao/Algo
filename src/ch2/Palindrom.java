package ch2;
import java.util.Stack;

import CtCILibrary.LinkedListNode;

/*
 * 2.7 if a linked list is a palindrome
 * solution:
 * 1. ofc, I could traveral to the end, and move both head and end, see if match, if not move inward.
 * 2. single list, the the end can't move backward =>  use a stack
 * 3. when put stuff in the stack? in the middle. use two ptr to find the middle
 * 4. care the odd ones!
 */
public class Palindrom {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int length = 10;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
//		 nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		Palindrom q = new Palindrom();
		System.out.println(q.isPalindrome(head));

	}
	/*
	 * iterative, compare half to half
	 * push half of the list to stack.
	 */
	boolean isPalindrome(LinkedListNode head){
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.next != null){
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		//check if odd
		if(fast != null){
			slow = slow.next;
		}
		while(slow != null){
			int top = stack.pop();
			if(top != slow.data){return  false;}
			slow = slow.next;
		}
		return true;
	}
	
	/*
	 * recursive ??
	 */
}
