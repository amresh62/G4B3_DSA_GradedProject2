package floorPlanningFunctionalities;

import java.util.Hashtable;
import java.util.Stack;

public class FunctionsForConstructionSequencing {public void sequenceTheFloorPlan(Hashtable<Integer, Integer > a, int noOfFloors) {
	
	boolean stackEmpty;
	// create a stack for storing floor size that are not used
	Stack<Integer> notUsedFloorSizes = new Stack<>();
	// access elements according to the day 
	int floorSizeThatCanBePlaced;
	int floorsPlaced=0;
	int trackDayOfConstruction=0;
	int lastElementPushedIntoStack = 0;
	int noOfElementsPlacedInStack=0;
	int diffBetweenConsecutiveElements = 0;

	// iterrate through all the available floors depending upon the noOfFloorsAvailable
		for(int i=0; i< noOfFloors; i++) {
			trackDayOfConstruction=trackDayOfConstruction+1;
			floorSizeThatCanBePlaced= noOfFloors-floorsPlaced;
			Integer floor= a.get(trackDayOfConstruction);
			stackEmpty = notUsedFloorSizes.empty();
		
			// check wether stack is empty or not
			if( stackEmpty ) {
				// if stack is empty then add the floor size available on Day "x" directly to the stack
				notUsedFloorSizes.push(floor);
				noOfElementsPlacedInStack++;
			}
			else {
				// if stack is not empty and a new floor size is available compare it with prev floors available
				// and place it into the stack according to its size into the stack
				int stackEmptiedFlag=0;
				int floorPlacedBackInStack=0;
				int g=0;	// variable to pop the values out of stack into array for processing
				int h=0;	// variable to acess values stored into the array for processing
				int arr[]= new int[noOfElementsPlacedInStack+1];
				
				
				stackEmpty = notUsedFloorSizes.empty();
				// if stack is not empty then pop out the last entered floor size of it for comparison 
				// with the current available floor size
				if(!stackEmpty) {
					arr[g]= notUsedFloorSizes.pop();		//h
					g++;
					h=g-1;
					noOfElementsPlacedInStack--;
				}
			
				// till current available floor size is less then the last poped out floor size from stack
				// continue to pop out floors stored into the stack and save them into the array
				while(floor< arr[h]) {
					stackEmpty = notUsedFloorSizes.empty();
					if(!stackEmpty) {
						arr[g]= notUsedFloorSizes.pop();
						noOfElementsPlacedInStack--;
						g++;
						h=g-1;
					}	
					else {
						// break out of the loop if stack has no floors left in it
						stackEmptiedFlag=1;
						break;
					}
				}
			
				
				// now place all the floors back into the stack along with the current floor 
				// in correct sequence so that the top most floor is the biggest floor size available
				while(h !=-1) {
					//h--;
					if(floorPlacedBackInStack==0) {
						if(floor< arr[h]) {
							notUsedFloorSizes.push(floor);
							noOfElementsPlacedInStack++;
							floorPlacedBackInStack=1;
					
						}
					}
					notUsedFloorSizes.push(arr[h]);
					h--;
					noOfElementsPlacedInStack++;
				}
				
				if(floorPlacedBackInStack==0)
				{
					if(stackEmptiedFlag==0)
					{
						floorPlacedBackInStack=1;
						notUsedFloorSizes.push(floor);
						noOfElementsPlacedInStack++;
					}
				}
			}
		
			// now with the updated stack pop out the last entered floor to check wether 
			// the current floor can be placed onto the building or not
			stackEmpty = notUsedFloorSizes.empty();
			if(!stackEmpty) {
				lastElementPushedIntoStack= notUsedFloorSizes.pop();
				noOfElementsPlacedInStack--;
			}
		
			// if current floor can be placed then pop out previous floor sizes and compare them 
			// if these can also be placed onto the building 
			// place them as well
			if(lastElementPushedIntoStack==floorSizeThatCanBePlaced) {
				int z=0;
				int l=0;
				int c=0;
				int u=1;
				int arr[]= new int[noOfElementsPlacedInStack+1];
				stackEmpty = notUsedFloorSizes.empty();
				if(!stackEmpty) {
					arr[z]= notUsedFloorSizes.pop();
					z++;
					l=z-1;
					noOfElementsPlacedInStack--;
				}
				if(arr.length != 0)
				{
					if(u!=1)
					{
					
					}	
					diffBetweenConsecutiveElements=lastElementPushedIntoStack-arr[l];
					while(diffBetweenConsecutiveElements == u) {
						u++;
						stackEmpty = notUsedFloorSizes.empty();
						if(!stackEmpty) {
							arr[z]= notUsedFloorSizes.pop();
							z++;
							l=z-1;
							noOfElementsPlacedInStack--;
							diffBetweenConsecutiveElements=lastElementPushedIntoStack-arr[l];
						}
					}
					if(!stackEmpty)
					{
						notUsedFloorSizes.push(arr[l]);
						noOfElementsPlacedInStack++;
						arr[l]=0;
						z--;
						l=z;
					}
				}

				//System.out.println();
				System.out.println("Day: " + trackDayOfConstruction);
				System.out.print(lastElementPushedIntoStack);
				if(z==0) {
					System.out.println();
				}
				floorsPlaced++;
			
				while(z != 0) {
					if(arr[c] != 0)
					{
						z--;
						System.out.print(" ");
						System.out.print(arr[c]);
						floorsPlaced++;
						c++;
				
						if(z==0) {
							System.out.println();
						}
				
					}
				}	
			
			
				//System.out.println(arr[0]);
			
			}
		
			else
			{			
				System.out.println("Day: " + trackDayOfConstruction);
				System.out.println(" ");
				notUsedFloorSizes.push(lastElementPushedIntoStack);
				noOfElementsPlacedInStack++;
			}
		
		}
					
	}




}
