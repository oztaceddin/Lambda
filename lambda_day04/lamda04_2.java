package lambda_day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class lamda04_2 {

	public static void main(String[] args) {
		
		Techpro trGunduz=new Techpro("yaz","TR gunduz",97,124);
		Techpro engGunduz=new Techpro("kis","ENG gunduz",95,131);
		Techpro trGece=new Techpro("bahar","TR gece",98,143);
		Techpro engGece=new Techpro("sonbahar","ENG gece",93,151);
		
		List<Techpro> list=new ArrayList<>(Arrays.asList(trGunduz,engGunduz,trGece,engGece));
        //bu classta return type çalışacagız	
		
		 System.out.println(batchOrt92byk(list));
		
		 System.out.println();
	     System.out.println(" *** ");
	     
	     
	     System.out.println(ogrcSayisiKck110(list));
	     
	    System.out.println();
	    System.out.println(" *** ");
	     
	     
	    System.out.println( baharKontrl(list));
	    
	    System.out.println();
	    System.out.println(" *** ");
	    
	    
	    System.out.println(ogrSayıTersSırala(list));    
	    
	    System.out.println();
	     System.out.println(" *** ");
	    
	     System.out.println(ortTop3(list));
	  
	     System.out.println();
	     System.out.println(" *** ");
	     
	     System.out.println(ogrSayiEnaz2(list));
	     
	     System.out.println();
	     System.out.println(" *** ");
	     
	     
	     System.out.println(ogrnOrt95TenBuyuk(list));   
	  
	     System.out.println();
	     System.out.println(" *** ");
	  
	     System.out.println(ogrnOrt95TenBuyuk1(list)+"--");
	     
	     System.out.println();
	     System.out.println(" *** ");
	     
	     System.out.println(ogrSayi130DanBuyukOrta(list));
	    
	  
	  
		
		
		
		
		
		
	
	
	}
	
	//task 01--batch ortlamalarının 92 den büyük oldg. kontr eden method creat edelim
	
	public static boolean batchOrt92byk(List<Techpro>list) {
		return list.stream().allMatch(t->t.getBatchOrt()>92);
		

	}//true
	
	//******************************************************
	
	
	//task 02-->ogrc sayilarinin hic birinin  110 den az olmadigini  
	//kontrol eden pr create ediniz.	
	
	
	
	public static boolean ogrcSayisiKck110 (List<Techpro>list) {
        return list.stream().noneMatch(t-> t.getOgrcSayisi()<110);
        
        //allMatch(t->t.getOgrcSayisi()>=110);
        
    }//true
	
	//***************************************************
	
	
	//task 03-->batch'lerde herhangi birinde "bahar" olup olmadigini 
	//kontrol eden pr create ediniz.
	
	
	public static boolean baharKontrl (List<Techpro>list) {
		
		return	list.stream().anyMatch(t->t.getBatch().equals("bahar"));
		
		
	}//true
	
	//*****************************************
	
	//task 04-->batch'leri ogr sayilarina gore b->k siralayiniz.
	
	
	public static Object ogrSayıTersSırala (List<Techpro>list) {
		
	return	list.stream().sorted(Comparator.comparing(Techpro::getOgrcSayisi).reversed()).collect(Collectors.toList());
		//öğrenci sayısı parametresine göre ter sıralama yaptık
	
		//collect---akıştaki elemanları istenen şarta göre toplar
		//Collectors.toList()--collect e toplanan elemanları list e çevirir
		
		
	}//[TechPro{batch='sonbahar', batchName='ENG gece', batchOrt=93, ogrcSayisi=151}, TechPro{batch='bahar', batchName='TR gece',
	//batchOrt=98, ogrcSayisi=143}, TechPro{batch='kis', batchName='ENG gunduz', batchOrt=95, ogrcSayisi=131}, TechPro{batch='yaz',
	//batchName='TR gunduz', batchOrt=97, ogrcSayisi=124}]
	
	
	//*******************************************************************
	
	//task 05-->batch'leri batch ort gore  b->k siralayip ilk3 'unu yazdiriniz.
	
	
	   public static List<Techpro> ortTop3(List<Techpro>list) {
	        return list.stream().
	                        sorted(Comparator.comparing(Techpro::getBatchOrt).
	                        reversed()).//b-->k sıralama yapar
	                        limit(3).//akıştaki elemanların ilk üçünü alır
	                        collect(Collectors.toList());
	   }//[TechPro{batch='bahar', batchName='TR gece', batchOrt=98, ogrcSayisi=143}, TechPro{batch='yaz', batchName='TR gunduz', batchOrt=97, ogrcSayisi=124}, TechPro{batch='kis', batchName='ENG gunduz', batchOrt=95, ogrcSayisi=131}]
	   
	   //*******************************************
	   
	   
	 //task 06--> ogrc sayisi en az olan 2. batch'i  yazdiriniz.
	   
	   
	   public static List<Techpro> ogrSayiEnaz2(List<Techpro>list){
		   
		   return list.stream().
                   sorted(Comparator.comparing(Techpro::getOgrcSayisi)).
                   limit(2).//ilk iki elemanı aldı
                   skip(1).//ilk elemanı atladı
                   collect(Collectors.toList());//collect e toplanan elemanları list e çevirir
                  
                   
		   
		   
	   }//[TechPro{batch='kis', batchName='ENG gunduz', batchOrt=95, ogrcSayisi=131}]
	
	   //*****************************************************************
	   
	   
	    //task 07--> batch ort 95 'den buyuk olan batch'lerin 
	   //ogrc sayilarini toplamini yazdiriniz
	   
	   
	   
	   public static Optional<Integer> ogrnOrt95TenBuyuk(List<Techpro>list){
		   
	return	   list.stream().filter(t->t.getBatchOrt()>95).
		   map(t->t.getOgrcSayisi()).reduce(Integer::sum);//reduce(0,(t,u)->t+u)
		   
		   
		   
		  
	   }//Optional[267]
	   
	  //**************************************************************
	   
	   
	   public static int ogrnOrt95TenBuyuk1(List<Techpro>list){
		   
			return	   list.stream().filter(t->t.getBatchOrt()>95).
					   mapToInt(t->t.getOgrcSayisi()).//maptoınt -->type göre int return eder sum() methodu çalışır 
					                                  // reduse gerek kalmaz daha kısa ve hızlı code imkanı sağlar
					   sum();//
 
	   }//267--
	   
	   //***********************************************************
	   
	   
	 //task 08--> Ogrenci sayisi 130'dan buyuk olan Batch'lerin 
	   //         batchOrt'larinin ortalamasini bulunuz.
	   
	   
	   public static OptionalDouble ogrSayi130DanBuyukOrta(List<Techpro>list) {
		   
	return	 list.stream().
			filter(t->t.getOgrcSayisi()>130).
		    mapToDouble(t->t.getBatchOrt()).
		    average();  //ortalama bulma
		   
		   
	   }//OptionalDouble[95.33333333333333]
	   
	

}
