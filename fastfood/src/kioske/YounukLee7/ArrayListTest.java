package kioske.YounukLee7;

import java.util.ArrayList;

public class ArrayListTest extends ArrayList<ArrayList>{
	
	public ArrayListTest() {
		ArrayList subArrayList1 = new ArrayList<>();
		ArrayList subArrayList2 = new ArrayList<>();
		ArrayList subArrayList3 = new ArrayList<>();
		ArrayList subArrayList4 = new ArrayList<>();
		ArrayList subArrayList5 = new ArrayList<>();
		
		for (int i = 1; i < 6; i++) {
			subArrayList1.add(i);
			subArrayList2.add(i);
			subArrayList3.add(i);
			subArrayList4.add(i);
			subArrayList5.add(i);
		}
		
		add(subArrayList1);
		add(subArrayList2);
		add(subArrayList3);
		add(subArrayList4);
		add(subArrayList5);
	}
	public static void main(String[] args) {
		ArrayListTest test = new ArrayListTest();
		System.out.println(test);
		
		test.remove(0);
		System.out.println(test);
	}
}
