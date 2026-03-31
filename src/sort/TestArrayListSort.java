package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestArrayListSort {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(5);
		list.add(34);
		list.add(28);
		list.add(16);
		
		// 익명 클래스를 사용하여 코딩을 부여하면 Interface 도 new 가능
		Comparator<Integer> compAsc = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}};
		
			Comparator<Integer> compDesc = new Comparator<Integer>() {
				
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}};
				
		disp_list( list );
		// 오름차순 정렬(ascending)
		Collections.sort(list, compAsc);
		disp_list( list );
		// 내림차순 정렬(descending)
		Collections.sort(list, compDesc);
		disp_list( list );
		line();

		// 문자열 배열
		ArrayList<String> names = new ArrayList<>();
		names.add("이순신");
		names.add("김유신");
		names.add("강감찬");
		names.add("을지문덕");
		names.add("권율");
		
		disp_name(names);
		
		// Ascending sort
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		disp_name(names);
		
		// Descending sort
		Collections.sort(names, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
			
		});
		disp_name(names);
		
	}

	private static void disp_name(ArrayList<String> names) {
		for (String name : names) {
			System.out.print(name + ",");
		}
		System.out.println();
	}

	private static void line() {
		System.out.println("=========================");
		
	}

	private static void disp_list(ArrayList<Integer> list) {
		
		for (Integer num : list) {
			System.out.print(num + ",");
			
		}
		System.out.println();
	}

}
