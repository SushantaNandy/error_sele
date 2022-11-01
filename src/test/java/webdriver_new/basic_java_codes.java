package webdriver_new;

import java.util.ArrayList;

public class basic_java_codes {

	public static void main(String[] args) {
		
		//Declaration of array
		// 1st way
		int[] arr =new int[5];
		arr[0]= 5;
		arr[1]= 7;
		System.out.println(arr[4]);   // if no value is stored in 3rd index it will print 0
		System.out.println(arr[0]);
		
		// 2nd way
		int[] arr2 = {1,2,3,4,5};
		System.out.println(arr2[3]);
		
		for(int i=0; i<arr2.length; i++) {    // to print all the values in our array
			System.out.println(arr2[i]);
		}
		
			//for enhanced loop
			String[] str= {"sus", "bhi","mi"};
			for(String s: str) {
				System.out.println(s);
				
				//ArrayList  this is not a tradition static way but a dynamic allocation
			ArrayList<String> a= new ArrayList<String>();  // making an object
			a.add("sus");
			a.add("lulla");             // passing the values 
			a.add("narwa");
			a.remove(0);       // used to remove the particular index from the array list
			System.out.println(a.get(1));  // used to print he values
			}

	}
		}



