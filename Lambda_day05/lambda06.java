package Lambda_day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class lambda06 {
	public static void main(String[] args) throws IOException {

		// TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
		System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");

		Files.lines(Paths.get("src\\Lambda_day05\\haluk.txt")).forEach(t -> System.out.println(t + ","));
		/*
		 * Basari gayrete asıktır, functional programming gayet basarili, lambda bilen
		 * sirti yere gelmez, Javacanlar ayaginiza tas degmesin,
		 */
		
		
		
		
		
		

		// TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk
		// harflerle yazdiriniz)
		System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");

		
		Files.lines(Paths.get("src\\Lambda_day05\\haluk.txt")).
		map(String::toUpperCase).//akışdaki satırlar büyük harlerle  dönüştürüldü
		
		forEach(t -> System.out.print(t + ","));
		//BASARİ GAYRETE ASIKTIR,FUNCTİONAL PROGRAMMİNG GAYET BASARİLİ,LAMBDA BİLEN SİRTİ YERE GELMEZ,
		//JAVACANLAR AYAGİNİZA TAS DEGMESİN,
		
		
		

		
		// TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
		System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");

		
		Files.lines(Paths.get("src\\Lambda_day05\\haluk.txt")).
		limit(1).//ilk satırı almamıza yaradı
		map(String::toLowerCase).//tüm akışı küçük harfe dönüştürdü
		forEach(t -> System.out.println(t + ","));//yazdırmamıza yaradı
		
		//basari gayrete asıktır,
		
		
		

		
		
		// TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz
		// yazdiriniz
		System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");

		System.out.println(Files.lines(Paths.get("src\\Lambda_day05\\haluk.txt")).
				filter(t->t.contains("basari")).//içeriğinde basari olup olmadıgına bakar
				count()+" tane aradığınız kelime mevcut");//bulduğunu bize yazdırır
		
		//1 satırda geçiyormuş
		
		

		
		// TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri yazdiriniz.
		System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");

		
		
		Files.lines(Paths.get("src\\Lambda_day05\\haluk.txt")).
		map(t->t.split(" ")).//" " göre satırlarlardaki elemanları parçalayıp arraya atadı
		flatMap(Arrays::stream).//arrays classndan stream ile array elemanlarından yeni bir akış oluşturduk
		distinct().collect(Collectors.toList()).//yeni akıştaki array elemanları tekrarsız hale getirildi
		forEach(t -> System.out.print(t + ","));
		
		//Basari,gayrete,asıktır,functional,programming,gayet,basarili,lambda,bilen,sirti,yere,gelmez,Javacanlar,ayaginiza,tas,degmesin,seni,seviyorum,
		
		
		

		
		
		// TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order yazdiriniz.
		System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");

		
		
		System.out.println(Files.lines(Paths.get("src\\Lambda_day05\\haluk.txt")).
                map(t -> t.split("")).
                flatMap(Arrays::stream).//splitten bize array geldigi için biz flatMap ile yeni bir akış oluşturuyoruz
                        sorted().
                        collect(Collectors.toList()));//liste cevirip yazdırıyoourz
		
		//[ ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , B, B, J,
		//a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a,
		//a, a, a, b, b, b, c, c, d, d, e, e, e, e, e, e, e, e, e,
		//e, e, e, f, g, g, g, g, g, g, g, i, i, i, i, i, i, i, i, i, 
		//i, i, i, i, i, k, l, l, l, l, l, l, m, m, m, m, m, m, n, n, n, 
		//n, n, n, n, n, o, o, o, p, r, r, r, r, r, r, r, r, r, r, r, s, s,
		//s, s, s, s, s, s, s, t, t, t, t, t, t, u, u, v, v, y, y, y, y, y, z, z, ı, ı]
		
		
		
		
		
		
		
		
		
		
		
		// TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini
		// buyuk harf kucuk harf bagımsız yaziniz.
		System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");

		// TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana
		// yazdiran programi yaziniz
		System.out.println(
				"\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");

		// TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
		System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");

		// TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
		System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");

		// TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
		System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");

	}

}
