package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {

	@SuppressWarnings("unused")
	private static final int List = 0;
	@SuppressWarnings("unused")
	private static final int Integer = 0;

	/*
	 * 1) Lambda "Functional Programming" "Functional Programming" de
	 * "Nasil yaparim?" degil "Ne yaparim?" dusunulur. 2) "Structured Programming"
	 * de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur 3)
	 * "Functional Programming" hiz, code kisaligi, code okunabilirligi ve hatasiz
	 * code yazma acilarindan cok faydalidir. 4) Lambda sadece
	 * collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak
	 * map'lerde kullanılmaz. Lambda kullanmak hatasız code kullanmaktır.
	 */

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, 3, 7, 34, 22, 68, 42, 27));

		pirintElStructured(list);

		System.out.println();
		System.out.println("*********");

		printElfunctional(list);

		System.out.println();
		System.out.println("*********");

		pirintElfunctional1(list);// lambda reference

		System.out.println();
		System.out.println("*********");

		printCiftElStructured(list);

		System.out.println();
		System.out.println("*********");

		printElfunctional(list);// lambda expression

		System.out.println();
		System.out.println("*********");

		printCiftFunctional1(list);// lambda reference

		System.out.println();
		System.out.println("*********");

		printCİftAltmıstanKucuk(list);

		System.out.println();
		System.out.println("*********");

		printTekYirmiBuyuk(list);

		System.out.println();
		System.out.println("*********");

		ciftKare(list);

		System.out.println();
		System.out.println("*********");

		tekKupBirfazla(list);

		System.out.println();
		System.out.println("*********");

		ciftKarakok(list);

		System.out.println();
		System.out.println("*********");

		enBuyukEleman(list);

	}

	// structured programming ile list elemanlarını tamamını yazdırın

	public static void pirintElStructured(List<Integer> list) {

		for (Integer w : list) {
			System.out.print(w + " ");// 12 13 65 3 7 34 22 68 42 27
		}

	}// 12 13 65 3 7 34 22 68 42 27

	// Functional Programming ile list elemanlerinin tamamini
	// aralarina bosluk birakarak yazdiriniz

	public static void printElfunctional(List<Integer> list) {

		list.stream().forEach(t -> System.out.print(t + ","));// lambda expression:: lambda ifadesi

		// stream(): dataları yukarıdan aşagıya akış şeklinde getirir
		// foreach(): datanın parametresini göre her bir elemanı işler
		// t-> : lambda operatorü
		// lambda expression yapısı cok tavsiye edilmez daha çok METHOD reference
		// kullanılır

	}// 12,13,65,3,7,34,22,68,42,27,

	// method reference---> kendi create ettiğimiz veya javadan aldığımız
	// method ile

	// classname: methodname----EZBERLEEEEEEEEE

	public static void printEl(int t) {// refere edilecek method create edelim

		System.out.print(t + "-");

	}

	public static void pirintElfunctional1(List<Integer> list) {

		list.stream().forEach(Lambda01::printEl);// işte lambda budur

	}// 12-13-65-3-7-34-22-68-42-27-

	// structured Programming ile list elemanlerinin cift olanalrini
	// ayni satirda aralarina bosluk birakarak yazdiriniz

	// uzunyoll

	public static void printCiftElStructured(List<Integer> list) {

		for (Integer w : list) {

			if (w % 2 == 0) {
				System.out.print(w + " ");
			}
		} // 12 34 22 68 42

	}

	// functional Programming ile list elemanlerinin cift olanalrini
	// ayni satirda aralarina bosluk birakarak yazdiriniz

	public static void printCiftFunctional(List<Integer> list) {

		list.stream().filter(t -> t % 2 == 0).forEach(Lambda01::printEl);

		// filter()->ois içerisinde elemanları istenen şarta göre filtreleme yapar

	}// 12 34 22 68 42

	public static boolean ciftBul(int i) {
		return i % 2 == 0;
	}

	public static void printCiftFunctional1(List<Integer> list) {

		list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl);

	}

	// Functional Programming ile list elemanlarinin cift olanalrinin
	// 60 dan kucuk olanlarını ayni satirda aralarina bosluk birakarak yazdiriniz

	public static void printCİftAltmıstanKucuk(List<Integer> list) {

		list.stream().filter(t -> t % 2 == 0 & t < 60).forEach(Lambda01::printEl);

	}// 12-34-22-42-

	// Functional Programming ile list elemanlarinin tek olanalrini veya 20 dan
	// buyuk
	// olanlarını ayni satirda aralarina bosluk birakarak yazdiriniz

	public static void printTekYirmiBuyuk(List<Integer> list) {
		list.stream().filter(t -> t % 2 == 1 || t > 20).forEach(Lambda01::printEl);

	}// 13-65-3-7-34-22-68-42-27-

	// Functional Programming ile list elemanlarinin cift olanlarinin
	// karelerini ayni satirda aralarina bosluk birakarak yazdiriniz

	public static void ciftKare(List<Integer> list) {

		list.stream().filter(Lambda01::ciftBul).map(t -> t * t).forEach(Lambda01::printEl);

	}// 144-1156-484-4624-1764-

	// Functional Programming ile list elemanlarinin tek olanlarinin
	// kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz

	public static void tekKupBirfazla(List<Integer> list) {

		list.stream().filter(t -> t % 2 == 1).map(t -> (t * t * t) + 1).forEach(Lambda01::printEl);

	}// 2198-274626-28-344-19684-

	// Functional Programming ile list elemanlarinin cift olanlarinin
	// karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

	public static void ciftKarakok(List<Integer> list) {

		list.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t -> System.out.println(t + "*"));

	}/*
		 * 3.4641016151377544* 5.830951894845301* 4.69041575982343* 8.246211251235321*
		 * 6.48074069840786
		 **/

	// list'in en buyuk elemanini yazdiriniz

	public static void enBuyukEleman(List<Integer> list) {

		Optional<Integer> maxEleman = list.stream().reduce(Math::max);

		System.out.println(maxEleman);

		// reduce --azaltmak --bir çok datayı tek bir
		// dataya(max-min-çarpma-bölme-toplama)
		// çevirmek için kullanılır

	}// Optional[68]

}
