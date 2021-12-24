package lambda_day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import lambda_day01.Lambda01;

public class lambda02 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(12, -13, 65, 3, 7, 34, -22, 60, 42, 55));

		ciftKareMax(list);

		System.out.println();
		System.out.println("*********");

		tumToplam(list);// LAmbda Expression...

		System.out.println();
		System.out.println("*********");

		tumToplam1(list);// method reference...
		
		System.out.println();
		System.out.println("*********");
		
		
		ciftCarpım(list);// Method Reference...
		
		System.out.println();
		System.out.println("*********");
		
		
		ciftCarpım1(list);//Lambda expression...
		
		System.out.println();
		System.out.println("*********");
	
		enKucuk(list);

	}

	// List'in cift olan elelmanlarin karelerini aliniz ve en buyugunu yazdiriniz

	public static void ciftKareMax(List<Integer> list) {

		Optional<Integer> enBüyük = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);

		System.out.println(enBüyük);

		// int enbuyük = list.stream().filter(Lambda01::ciftBul).map(t -> t *
		// t).reduce(Integer::max);
		// reduce() returne edilen elelman null yada int 'den buyuk olur ihtimali icin
		// Java guvenlik olarak handle ederek
		// Optional class' sart kosuyor

		// reduce(Math::max); da kullanılır ancak daha daha spesifik olduğundan dar
		// olanla çalışılmalı reduce(Integer::max);

	}// Optional[3600]

	// ****************************************************************

	// List'teki tum elemanlarin toplamini yazdiriniz.
	// LAmbda Expression...

	public static void tumToplam(List<Integer> list) {

		int toplam = list.stream().reduce(0, (x, y) -> x + y);

		System.out.println(toplam);

		// x herzaman ilk değerini atanan degerden (0) alır
		// y herzaman değerini list.stream() dan alır(akış)
		// x ilk degerden sonraki değerlerini işlemden alır
		//

	}// 243

	// *******************************************************

	// List'teki tum elemanlarin toplamini yazdiriniz.
	// method reference...

	public static void tumToplam1(List<Integer> list) {

		Optional<Integer> toplam1 = list.stream().reduce(Integer::sum);
		Optional<Integer> toplam2 = list.stream().reduce(Math::addExact);

		System.out.println(toplam1);
		System.out.println(toplam2);

	}// Optional[243]
	
	
	

	// *****************************************************
	
	

	// List'teki cift elemanlarin carpimini yazdiriniz.
	// Method Reference...

	public static void ciftCarpım(List<Integer> list) {

		Optional<Integer> carpim=list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
		System.out.println(carpim);

	}//Optional[-22619520]  
	
	
	//***************************************************
	
	//List'teki cift elemanlarin  yazdiriniz.
	//Lambda expression...
	
	
	public static void ciftCarpım1(List<Integer> list) {
		
		int carpim1=list.stream().filter(Lambda01::ciftBul).reduce(1,(x,y)->x*y);
		System.out.println(carpim1);
		

	}//-22619520
	
	
	//***********************************************************
	
	
	//List'teki elemanlardan en kucugunu 4 farklı yontem ile yazdiriniz
	
	public static int minBul(int x,int y) {
		return x<y ?x:y;

		
	}
	

	public static void enKucuk(List<Integer> list) {
//1.yöntem	--method reference--integer class
    Optional<Integer> enKucuk =list.stream().reduce(Integer::min);
    System.out.println(enKucuk+"%");
    
//2.yöntem--method reference---math class
    
    Optional<Integer> enKucuk1 =list.stream().reduce(Math::min);
    System.out.println(enKucuk1+"&");
    
//3.yöntem----yukardaki minbul methodundan reference yaptı
    
    Optional<Integer> enKucuk2 =list.stream().reduce(lambda02::minBul);
    
    System.out.println(enKucuk2+"#");
    
 //4.yöntem--lambda expresion
    
     Integer enKucuk3 =list.stream().reduce(Integer.MAX_VALUE, (x,y)->x<y?x:y);
    
     System.out.println(enKucuk3+"!");
    

	
	}//Optional[-22]//2.yön::Optional[-22]--3.yönt--Optional[-22]---4.yöntem--(-22)
	
	
	
	
	
	
	
	
	
	

}
