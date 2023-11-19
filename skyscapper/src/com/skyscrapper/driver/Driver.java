package com.skyscrapper.driver;

import java.util.LinkedHashSet;
import java.util.Scanner;
import com.skyscrapper.services.constructSkyscrapper;

public class Driver{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the total number of floors in the building");
		int totalFloors = scanner.nextInt();
		LinkedHashSet<Integer> uniqueFloorSizes = new LinkedHashSet<>();
		for (int i = 0; i < totalFloors; i++) {
			System.out.println("Enter the floor size given on day " + (i + 1));
			int floorSize = scanner.nextInt();			
			while (!uniqueFloorSizes.add(floorSize)) {
				System.out.println("Floor size must be distinct. Enter a different size for day " + (i + 1));
				floorSize = scanner.nextInt();
			}
		}		
		int[] floorSizes = uniqueFloorSizes.stream().mapToInt(Integer::intValue).toArray();
		scanner.close();
		constructSkyscrapper construct=new constructSkyscrapper();
		construct.constructFloor(floorSizes);
	}
	
}