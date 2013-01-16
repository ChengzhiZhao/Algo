package ch3;

import java.util.Stack;

/*
 * 3.6
 * sort a stack in ascending order, 
 * support ops like push, pop, peek, isEmpty
 *       12
 *  10    8
 *  5     3
 *  
 *  0. all in s1
 *  1. keep poped
 *  2. [<] poped[>]
 */
public class SortedStack {
	Stack<Integer> unsorted,cache,sorted;
	public SortedStack(){
		unsorted = new Stack<Integer>();
		cache = new Stack<Integer>();
		sorted = new Stack<Integer>();
	}
	
	public void initil(int[] input){
		for(int i : input){
			unsorted.push(i);
		}
	}
		
	public void sort(){
		assert(unsorted.size() > 0);
		while(unsorted.size() > 0){
			int cur = unsorted.pop();
			if(sorted.size() == 0) {sorted.push(cur); return;}
			while( sorted.peek() > cur && sorted.size() > 0){
				cache.push(sorted.pop());
			}
			sorted.push(cur);
			while(cache.size() > 0){
				sorted.push(cache.pop());
			}
		}
	}
	public String toString(){
		return unsorted.toString() + "\n" +
	           cache.toString() + "\n" + sorted.toString();
	}
	
	
	
	public static void main(String[] args) {
		SortedStack stack = new SortedStack();
		int[] input = {3,2,1,4,5,6,7,7,7,8};
		stack.initil(input);
		System.out.println(stack.toString());
		stack.sort();
		System.out.println(stack.toString());
		

	}

}
