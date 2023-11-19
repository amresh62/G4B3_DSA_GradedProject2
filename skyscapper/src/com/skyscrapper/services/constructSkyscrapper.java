package com.skyscrapper.services;
import java.util.Stack;
public class constructSkyscrapper {	
	public void constructFloor(int[] floorSizes) {
		Stack<Integer> stack = new Stack<>();
		int floorcount=0;
		for (int i = 0; i < floorSizes.length; i++) {
			System.out.println("Day: " + (i + 1));
			if(floorSizes[i]==floorSizes.length-floorcount)
			{
				stack.push(floorSizes[i]);
				while(!stack.isEmpty() && stack.peek()>=floorSizes.length-floorcount)
				{
					System.out.print(stack.pop()+" ");
					floorcount++;
				}
			}
			else {
				stack.push(floorSizes[i]);
			}			
			System.out.println();
		}
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop()+" ");
		}
	}

}
