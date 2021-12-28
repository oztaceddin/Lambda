package lambda_day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda04 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("mehmet",
                "emre", "nilgun", "cincix", "kader",
                "emine", "islam", "islam", "kokorec"));
		
		karakteriEnBuyukEl(list);
		
		System.out.println();
        System.out.println(" *** ");
        
        karakteriEnBuyukEl2(list);
        System.out.println();
        System.out.println(" *** ");
        
        
        sonHarfSıralıilkElemanHaric(list);
	}
	
	 //Karakter sayisi en buyuk elemani yazdiriniz.
	   public static void karakteriEnBuyukEl(List<String> list){
	       System.out.println(list.
	               stream().
	               sorted(Comparator.comparing(t -> t.toString().length()).//lenght karakter uzunluguna gore siraladi k->b
	                       reversed()).//ters sirlad b->k
	               findFirst());//ilk elelmani aldi
                //  limit(1));//limit (a) akısdan çıkan elemanları a parametresini göre ilk a elemanını verir

          }//Optional[kokorec]
	   
	   public static void karakteriEnBuyukEl2(List<String> list){
		   
	  Stream<String>sonİsim=     list.
	               stream().
	               sorted(Comparator.comparing(t -> t.toString().length()).//lenght karakter uzunluguna gore siraladi k->b
	                       reversed()).//ters sirlad b->k
	              // findFirst());//ilk elelmani aldi
                  limit(1);//limit (a) akısdan çıkan elemanları a parametresini göre ilk a elemanını verir
	                       //direk yazdıramayız yazdırırsak bize referans kodunu verir
	            System.out.println(Arrays.toString(sonİsim.toArray()));
	  
	   
	   }//[kokorec, mehmet, nilgun, cincix, kader](5)--(1)[kokorec]
	   
	   
	   
	   //list elemanlarını son harfine göre sıralayıp ilk eleman hariç kalan elemanları yaazdır
	   
	   
	   
	   public static void sonHarfSıralıilkElemanHaric(List<String> list) {
		   
		   list.stream().sorted(Comparator.comparing(t -> t.toString().length()-1)).skip(1).forEach(t->System.out.print(t+" "));
		   
		 
		   
	   }//kader emine islam islam mehmet nilgun cincix kokorec 
	   
	   
	   
	   
	   

}
