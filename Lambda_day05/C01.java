package Lambda_day05;

import java.util.Iterator;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

import lambda_day01.Lambda01;
import lambda_day04.lamda04_2;

@SuppressWarnings("unused")
public class C01 {

	



	public static void main(String[] args) {
		//TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program yaziniz.

		//TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz

		//TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz

		//TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz

		//TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz

		//TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz

		//TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz

	
	System.out.println(topla(10));
	
	System.out.println();
    System.out.println(" *** ");
    
    System.out.println(topla1(10));
	
    System.out.println();
    System.out.println(" *** ");
    
    System.out.println(topla2(10));
    
    System.out.println();
    System.out.println(" *** ");
    
    System.out.println(toplaCift(10));
    
    System.out.println();
    System.out.println(" *** ");
    
    System.out.println(toplaCift1(10));//2,4,6,8,10,12,14,16,18,20
    
    System.out.println();
    System.out.println(" *** ");
    
    System.out.println(toplaTek(10));//1,3,5,7,9,11,13,15,17,19
    
    System.out.println();
    System.out.println(" *** ");
    
     iKininKuvveti(10);
     
     System.out.println();
     System.out.println(" *** ");
     
     
   //  istenilenSayınınKuvveti(2);
     
     System.out.println();
     System.out.println(" *** ");
     
     
      sayiKuvveti(2,4);
      
      System.out.println();
      System.out.println(" *** ");
      
      System.out.println(istenenSayiniXFaktoriyel(5));
      
      
      
      
      System.out.println();
      System.out.println(" *** ");
      
      System.out.println(istenenSayiniXincikuvvet(2,3));
      
      
      
      
    
    
    
    
    
    
	
	
	}
	
	//TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program yaziniz.
	//Structured Programming
	public static int topla(int x) {
	    int toplam = 0;
	    for (int i = 0; i <= x; i++) {
	        toplam +=i;
	    }
	    return toplam;
	}//55
	
	//*******************************
	
	//Functional Programming
	public static int topla1(int x) {

	    return IntStream.range(1,x+1).//1 2 3 ... x elemanarinin akısı
	            sum();
	}//55
	
	//***********************
	
	public static int topla2(int x) {

	    return IntStream.rangeClosed(1,x).//1 2 3 ... x --> 1 ve x dahil
	            sum();
	}//55
	
	//*********************************
	
	
	//TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
	
	
	
	public static int toplaCift(int x) {
		
		return IntStream.rangeClosed(1,x).
				filter(Lambda01::ciftBul).//2,4,6-----
	            sum();
		
		//return IntStream.range(1,x).filter(t->t%2==0).sum();
	   
	}//30
	
	//********************************************
	
	 //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz
	
	
      public static int toplaCift1(int x) {
		
		return IntStream.
				iterate(2,t->t+2).//2,4,6,----
				limit(x).	//sınır verdik	--yukarıda 10 yazdığımızdan 2 den sonraki 10 tane çift rakamları aldı
				sum();
	            
	
           }	//110
      
      
      //*****************************************************
      
    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz
	
      public static int toplaTek(int x) {
    	    return IntStream.
    	            iterate(1,t->t+2).//1 3 5 ... x elemanarinin akısı
    	            limit(x).//akıştaki lk x elemanı verir 
    	            sum();//akışta ilk x elemanı toplar
    	}//100
      
      
      //***************************************
      
      
    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz
	
      public static void iKininKuvveti(int x) {
  	             IntStream.
  	            iterate(2,t->t*2).//2-4--8-16-32,,,,,,,,,,
  	            limit(x).//akıştaki lk x elemanı verir 
  	             forEach(t->System.out.print(t+" "));
  	             
  	             
  	}//2 4 8 16 32 64 128 256 512 1024 
      
      //************************************
      
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz
     
      
      /*   public static void istenilenSayınınKuvveti(int x) {
    	  
    	  Scanner scan=new Scanner(System.in);
    	  System.out.println("kuvvetlerini görmekistediğiniz rakamı girin");
    	  int b=scan.nextInt();
            IntStream.
           iterate(b,t->t*b).//2-4--8-16-32,,,,,,,,,,
           limit(x).//akıştaki lk x elemanı verir 
            forEach(t->System.out.print(t+" "));
            
            
    }//5 25  */
        
        //****************************************
        
        public static void sayiKuvveti(int x, int sayi) {
            IntStream.
                    iterate(sayi,t->sayi*t).
                    limit(x).
                    forEach(t-> System.out.print(t+" "));
        }//4 16 
        
        //****************************************************
        
      //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz
        
        
        
        public static OptionalInt istenenSayiniXFaktoriyel(int x) {

            return IntStream.
            		rangeClosed(1, x).
            		reduce(Math::multiplyExact);
                    
        
        
        }//OptionalInt[120]
        
        
        //2.yöntemm
        
      /*  
        
           public static int istenenSayiniFaktoriyeli1(int x) {	​
        	        return IntStream.rangeClosed(1,x).//a a^2 a^3 a^4... x elemanarinin akısı
        	                // reduce(Math::multiplyExact);
        	                 reduce(1,(t,u)->t*u);      	​
           }
        
       */ 

        
        //*****************************************************
        
      //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi yaziniz
        public static int istenenSayiniXincikuvvet(int a, int x) {

           return IntStream.iterate(a, t -> t * a).//a a^2 a^3 a^4... x elemanarinin akısı
                    limit(x).//akısdaki ilk x elamanı verir
                   reduce(0,(t,u)->u);
                  // skip(x-1);//skipten sonra çıkan elemanları tolist yaparak yazdırılmalı
        }//8
        
	
		
		
	}


