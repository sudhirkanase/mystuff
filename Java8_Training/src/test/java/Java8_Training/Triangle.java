package Java8_Training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Triangle {
	
	public static void main(String[] args) {
		//printTriangle(5);
		printTriangle1(5);
		test();
	}

	private static void test() {
		
		//List.of("sara","sudhir","kanase");
		
		 int a[][] =  { 
				 		{1, 2, 3, 4}, {7, 8, 9, 0}, {5, 6}, {12, 18, 19, 20, 17}, {22}
		 };
//		//Stream.of(t)
//		List<String> names = new ArrayList<String>(Arrays.asList("sara","sudhir","kanase")) ;
//		//Character[] collect = names.stream().flatMap(a -> Stream.of(a.toCharArray())).toArray(Character[]::new); 
//		long collect = names.stream().flatMap(a -> Stream.of(a.toCharArray())).count();
//		System.out.println(collect);
		//Stream.of(collect).forEach(a -> System.out.println(a));
		 
		 int[] array1 = Stream.of(a).flatMapToInt(b -> Arrays.stream(b)).toArray();
		 Arrays.stream(array1).forEach(c -> System.out.println(c));
		 
		 List<String> names = new ArrayList<String>(Arrays.asList("sara","sudhir","kanase")) ;
		 System.out.println(names.stream().flatMap(d -> Stream.of(d.toCharArray())).count());
		 
		 String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

		  // Java 8
		  String[] result = Stream.of(array)  // Stream<String[]>
		          .flatMap(Stream::of)        // Stream<String>
		          .toArray(String[]::new);    // [a, b, c, d, e, f]

		  for (String s : result) {
		      System.out.println(s);
		  }
	}

	private static void printTriangle1(int i) {
		for(int cnt = 0; cnt < i ; cnt++) {
			for(int space = i; space > cnt; space--) {
				System.out.print(" ");
			}
			for(int cnt1 = 0; cnt1 <= cnt ; cnt1++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}

	private static void printTriangle(int i) {
	
		for(int cnt = 0; cnt < i ; cnt++) {
			for(int cnt1 = 0; cnt1 <= cnt ; cnt1++)
			System.out.print("* ");
			System.out.println();
		}
	
		
	}
}
