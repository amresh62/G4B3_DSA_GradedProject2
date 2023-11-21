package constructionApplication;

import java.util.Hashtable;
import java.util.Scanner;

import floorPlanningFunctionalities.FunctionsForConstructionSequencing;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Hashtable<Integer, Integer> hashtable = new Hashtable<>();
		
		// create an object of type scanner to take input from the user
		Scanner userInput = new Scanner(System.in);
		
		// take the input from the user for the number of floors to be  build in the building
		int noOfFloorsInBuilding;
		System.out.println("kindly enter the total no of floors in the building");
		noOfFloorsInBuilding= userInput.nextInt();
		System.out.println(noOfFloorsInBuilding);
		
		
		// take the input for the buildings that are available for laying out
		int j=0;
		for(int i = 0; i< noOfFloorsInBuilding ; i++) {
			j=j+1;
			System.out.println("kindly enter floor size available on day: "+ j);
			hashtable.put(j, userInput.nextInt());	
		}
		// close the scanner variable 
		userInput.close();
		
		/*
		int k=0;
		for(int i=0; i < noOfFloorsInBuilding; i++) {
			k=k+1;
			int value = hashtable.get(k);
			System.out.println("floor available on Day " + k + "=" + value);	
		}
		*/
		
		// function to sequence the floors according to the available sizes
		FunctionsForConstructionSequencing ob1 = new FunctionsForConstructionSequencing();
		
		System.out.println("The order of construction is as follows");
		ob1.sequenceTheFloorPlan(hashtable, noOfFloorsInBuilding);

	}

}
