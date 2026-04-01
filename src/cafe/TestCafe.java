package cafe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
카페 주문 정산 프로그램
O1001,최지우,A,5,4500.0,Y
O1002,김서연,L,2,5200.0,N
O1003,박하준,D,3,10000.0,Y
O1004,박상준,T,3,6000.0,Y
O1005,박준,D,4,3800.0,N


*/
//입력data : 주문번호,고객명,메뉴코드,수량,단가,포장여부
//출력     : 주문번호,고객명,메뉴명,주문금액,포장비,최종금액,포장상태

//주문금액 = 수량 * 단가
//포장비   = 포장여부가 Y이면 주문금액의 3%, N이면 0원
//최종금액 = 주문금액 + 포장비
//메뉴명   = A:아메리카노, L:라떼, T:차, D:디저트
//포장상태 = Y:포장, N:매장

//금액은 소수이하 두자리로 반올림
//모든 기능은 class에 구현한다.

interface Ipo {
   void input();
   void process();
   void output();
}

class CafeVo {
   // Field
   //입력data : 주문번호,고객명,메뉴코드,수량,단가,포장여부
   //           num, name, menuCode, qty, price, packed
   private String num;
   private String name;
   private char menuCode;
   private int qty;
   private double price;
   private char packed;
   
   //출력     : 주문번호,고객명,메뉴명,주문금액,포장비,최종금액,포장상태
   //           num, name, menuName, ordKum, packMoney, kum, packedName
   private String menuName;
   private double ordKum;
   private double packMoney;
   private double Kum;
   private String packedName;
   
   // Constructor
   public CafeVo(String num, String name, char menuCode, int qty, double price, char packed) {
      super();
      this.num = num;
      this.name = name;
      this.menuCode = menuCode;
      this.qty = qty;
      this.price = price;
      this.packed = packed;
   }

   
   // Getter Setter
   public String getNum() {
      return num;
   }   
   public void setNum(String num) {
      this.num = num;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public char getMenuCode() {
      return menuCode;
   }
   public void setMenuCode(char menuCode) {
      this.menuCode = menuCode;
   }
   public int getQty() {
      return qty;
   }
   public void setQty(int qty) {
      this.qty = qty;
   }
   public double getPrice() {
      return price;
   }
   public void setPrice(double price) {
      this.price = price;
   }
   public char getPacked() {
      return packed;
   }
   public void setPacked(char packed) {
      this.packed = packed;
   }
   public String getMenuName() {
      return menuName;
   }
   public void setMenuName(String menuName) {
      this.menuName = menuName;
   }
   public double getOrdKum() {
      return ordKum;
   }
   public void setOrdKum(double ordKum) {
      this.ordKum = ordKum;
   }
   public double getPackMoney() {
      return packMoney;
   }
   public void setPackMoney(double packMoney) {
      this.packMoney = packMoney;
   }
   public double getKum() {
      return Kum;
   }
   public void setKum(double kum) {
      Kum = kum;
   }
   public String getPackedName() {
      return packedName;
   }
   public void setPackedName(String packedName) {
      this.packedName = packedName;
   }
   
   //toString
   @Override
   public String toString() {
      return "CafeVo [num=" + num + ", name=" + name + ", menuCode=" + menuCode + ", qty=" + qty + ", price=" + price
            + ", packed=" + packed + ", menuName=" + menuName + ", ordKum=" + ordKum + ", packMoney=" + packMoney
            + ", Kum=" + Kum + ", packedName=" + packedName + "]";
   }
   
}

class CafeOrder implements Ipo{
   
   List<CafeVo> cafeList  =  new ArrayList<>(); // 배열 크기 변함
   
   @Override
   public void input() {
      Scanner  in  = new Scanner(System.in);
      System.out.println("입력: 주문번호,고객명,메뉴코드,수량,단가,포장여부");
      
      int i = 0;
      while(true) { // while 무한루프, for 무한루프 for(;;){if()}
         String  line  = in.nextLine();
         if(line.equals("quit")) { 
            // System.out.println(line);
            break;
            }
         
         String [] li        =  line.trim().split(",");
         String    num       =  li[0].trim();
         String    name      =  li[1].trim();
         char      menuCode  =  li[2].toUpperCase().charAt(0);
         int       qty       =  Integer.parseInt(li[3].trim());
         double    price     =  Double.parseDouble(li[4].trim());
         char      packed    =  li[5].toUpperCase().charAt(0);
         
         CafeVo  cafeVo      =  new CafeVo(num, name, menuCode, qty, price, packed);
         
         cafeList.add(cafeVo);
         // System.out.println(cafeList.get(i));
         i++;
      }
   }

   @Override
   public void process() {
      for (int i = 0; i < cafeList.size(); i++) {
         CafeVo vo = cafeList.get(i);
         //주문금액 = 수량 * 단가
         vo.setOrdKum(vo.getQty() * vo.getPrice());
         
         //포장비   = 포장여부가 Y이면 주문금액의 3%, N이면 0원
         if(vo.getPacked() == 'Y')
            vo.setPackMoney(vo.getOrdKum() * 0.03);
         else
            vo.setPackMoney(0);
         
         //최종금액 = 주문금액 + 포장비
         vo.setKum(vo.getOrdKum() + vo.getPackMoney());
         
         //메뉴명   = A:아메리카노, L:라떼, T:차, D:디저트 menuCode -> menuName
         String mname = "";
         switch(vo.getMenuCode()) {
         case 'A': mname = "아메리카노"; break;
         case 'L': mname = "라떼"; break;
         case 'T': mname = "차"; break;
         case 'D': mname = "디저트"; break;
         }
         vo.setMenuName(mname);
         
         //포장상태 = Y:포장, N:매장
         String pname = "";
         switch(vo.getPacked()) {
         case 'Y': pname = "포장"; break;
         case 'N': pname = "매장"; break;
         }
         vo.setPackedName(pname);
      }
      
   }

   @Override
   public void output() {
      System.out.println("주문번호 고객명 메뉴명 주문금액 포장비 최종금액 포장상태");
      for (int i = 0; i < cafeList.size(); i++) {
         CafeVo vo = cafeList.get(i);
         
         System.out.printf("%s %s %s %.2f %.2f %.2f %s\n",
               vo.getNum(),
                   vo.getName(),
                   vo.getMenuName(),
                   vo.getOrdKum(),
                   vo.getPackMoney(),
                   vo.getKum(),
                   vo.getPackedName()
               );
      }
   }
   
}

public class TestCafe {

   public static void main(String[] args) {
      CafeOrder cafeOrder  =  new CafeOrder();
      cafeOrder.input();
      cafeOrder.process();
      cafeOrder.output();

   }

}
