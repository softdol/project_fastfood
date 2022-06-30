package kioske.YounukLee7;

import java.util.ArrayList;
import java.util.Iterator;

import kioske.YounukLee7.dbtablePocket.Order_list;

public class ArrayListTest extends ArrayList<ArrayList>{
	
	public ArrayListTest() {
//		ArrayList subArrayList1 = new ArrayList<>();
		ArrayList subArrayList2 = new ArrayList<>();
		ArrayList subArrayList3 = new ArrayList<>();
		ArrayList subArrayList4 = new ArrayList<>();
		ArrayList subArrayList5 = new ArrayList<>();
		
//		for (int i = 1; i < 5; i++) {
//			subArrayList1.add(i);
//			subArrayList2.add(i);
//			subArrayList3.add(i);
//			subArrayList4.add(i);
//		}
		
		ArrayList<Order_list> subArrayList1 = new ArrayList<>();
		
//		subArrayList1.add(new Order_list(1,2,3,4));
//		
//		ArrayListTest()
		
		subArrayList2.add(2);
		subArrayList3.add(3);
		subArrayList4.add(4);
		subArrayList5.add(5);
		
		add(subArrayList1);
		add(subArrayList2);
		add(subArrayList3);
		add(subArrayList4);
		add(subArrayList5);
	}
	public static void main(String[] args) {
		ArrayListTest test = new ArrayListTest();
		System.out.println("ArrayList<ArrayList> : " + test);
		int a = Integer.valueOf(String.valueOf(test.get(4).get(0)));
		System.out.println(a);
	}
}
