package kioske.YounukLee7;

import java.util.ArrayList;

import kioske.YounukLee7.dbtablePocket.Order_list;

public class Test {

	public static void main(String[] args) {
		String[] strings = {"1","2","3"};
		
//		Order_list[] list = new Order_list[3];
//		list[0] = new Order_list();
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("1");
		list2.add("2");
		list2.add("3");
		
		ArrayList<Order_list> list3 = new ArrayList<>();
//		list3.add(new Order_list(1, 1,1000));
//		list3.add(new Order_list(1, 2,2000));
//		list3.add(new Order_list(1, 3,3000));
		
		for (int i = 0; i < list3.size(); i++) {
			list3.get(i);
			System.out.println(list3.get(i).getMENU_IDX() + " " + list3.get(i).getORDER_PRICE());
		}
		
	}
}
