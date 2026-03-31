package sort;

import java.util.Arrays;
import java.util.Collections;

public class TestArraySort {

   public static void main(String[] args) {
      // 정렬 : sort
      // int [] 는 람다식 사용불가 ! 
      int [] arr1 = new int[] {1,5,3,2,4};
      System.out.println(Arrays.toString(arr1));      //[1, 5, 3, 2, 4]
      
      Arrays.sort(arr1);
      System.out.println(Arrays.toString(arr1));      //[1, 2, 3, 4, 5]

// ----------------------------------------------------------------------------------------------      
/*      
 * Error : The method sort(int[]) in the type Arrays is not applicable for the arguments (int[], (<no type> a, <no type> b) -> {})
 파라메타가 int 배열이라서
      Arrays.sort(arr1,(a,b) -> { return b - a;});   // 내림차순
*/
      System.out.println("=====================");
      Integer [] arr2 = new Integer[] {1,5,3,2,4};
      System.out.println(Arrays.toString(arr2));      //
      
      Arrays.sort(arr2,(a,b) -> { return a - b;});   // 오름차순
      System.out.println(Arrays.toString(arr1));      //
      Arrays.sort(arr2,(a,b) -> { return b - a;});   // 내림차순
      System.out.println(Arrays.toString(arr1));      //
      System.out.println("=====================");

// ----------------------------------------------------------------------------------------------   
      
      Double [] arr3 = { 12.3, 3.8, 2.145, 16.8 };
      System.out.println(Arrays.toString(arr3)); 
      
      Arrays.sort(arr3);   
      System.out.println(Arrays.toString(arr3)); 
      
//      Collections.sort(arr3); // List 만 들어올 수 있음 , double x
      
      Arrays.sort(arr3, Collections.reverseOrder());      // 내림
      System.out.println(Arrays.toString(arr3)); 
      System.out.println("=====================");
      
// ----------------------------------------------------------------------------------------------
      
      String [] names = {"유진","카리나","윈터","가을","이서"};
      System.out.println(Arrays.toString(names));
      
//      Arrays.sort(names, (a,b) -> { return a - b; );      // 글자비교라서 a - b 사용 x
      Arrays.sort(names, (a,b) -> { return a.compareTo(b); });      // 오름
      System.out.println(Arrays.toString(names));
      
      
      Arrays.sort(names, (a,b) -> { return b.compareTo(a); });      // 내림
      System.out.println(Arrays.toString(names));
      
      }
      
// ----------------------------------------------------------------------------------------------      
   }
