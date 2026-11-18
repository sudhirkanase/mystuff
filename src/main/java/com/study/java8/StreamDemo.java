package com.study.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
 import static java.util.stream.Collectors.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


class Student {
	
	int id;
	String name;
	int marks;
	String section;
	
	public Student(int id, String name, int marks, String section) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.section = section;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	
	
	
}


public class StreamDemo {

	public static void main(String[] args) {
		//test1();
		
		//test2();
		
		int arr [] = {-9,-9,-9,1,1,1,0,-9,0,4,3,2,-9,-9,-9,1,2,3,0,0,8,6,6,0,0,0,0,-2,0,0,0,0,1,2,4,0};
		
		System.out.println(arr.length);
		
		int hourglassesInd[] = {0,1,2,7,12,13,14};
		//int hourglassesInd[] = {0,1,2,7,12};
		
		int startingIndex = 0;
		int sum = 0;
		
		boolean flag = true;
		
		int rowSize = 6;
		
		while(flag) {
			sum = 0;
			for (int i = 0; i < hourglassesInd.length; i++) {
				if( startingIndex+  hourglassesInd[i] >= arr.length ) {
					flag = false;
					break;
				}				
				sum += arr[startingIndex + hourglassesInd[i]];
			}
			startingIndex++;
			if(startingIndex == rowSize - 2) {
				startingIndex += 2;
				rowSize += 6;
				System.out.println("");
				System.out.println("");
			}
			
			System.out.print(sum + "  ");
		}
	
		
		

	}

	private static void test2() {
		
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "a", 60, "10a"));
		students.add(new Student(2, "b", 20, "10a"));
		students.add(new Student(3, "c", 50, "10b"));
		students.add(new Student(4, "d", 35, "10b"));
		students.add(new Student(5, "e", 100, "10c"));
		
		// find out the student having highest marks
		Optional<String> studentName = students.stream().min((a,b) -> {
			if(a.marks > b.marks)
				return 1;
			else if(a.marks < b.marks)
				return -1;
			else return 0;
			
		}).map((p) -> p.getName());
		
		System.out.println(studentName.get());
		
		// Each class students
		Map<String, Long> collect = students.stream().collect(Collectors.groupingBy(Student::getSection, Collectors.counting()));
		
		collect.entrySet().forEach((e) -> System.out.println( e.getKey() + "  --> " + e.getValue()));
		
		// Each class totoal marks
		
		Map<String, IntSummaryStatistics> collect2 = students.stream().collect(Collectors.groupingBy(Student::getSection, Collectors.summarizingInt(Student::getMarks) ));
		
		collect2.entrySet().forEach((e) -> System.out.println( e.getKey() + "  --> " + e.getValue().getSum()));
		
		// get names of the all students
		students.stream().map((s) -> { return s.name ;}).collect(Collectors.toList()).forEach(System.out::println);
		
		Optional<String> reduce = students.stream().map((s) -> { return s.name ;}).reduce((a, b) ->  { return a + "," + b; } );
		System.out.println(reduce.get());
		
		String collect3 = students.stream().map((s) -> { return s.name ;}).collect(Collectors.joining(", "));
		
		System.out.println(collect3);
		
		
		String string = students.stream().map((s) -> { return s.name ;}).toString();
		
		System.out.println(string);
	}
	
	private static void test1() {
		String s[] = { "1", "2", "3" };

		Stream<String> stream = Arrays.stream(s);

		Function<String, List<String>> function = (a) -> {
			return new ArrayList<String>(Arrays.asList(a + "base", a + "shift"));
		};

		Map<Boolean, List<String>> collect = stream.map(function).peek(System.out::println).flatMap(p -> p.stream()).
		collect(partitioningBy(p -> p.contains("base")));
		
		//collect.entrySet().stream().forEach((a) -> { System.out.println(a.getKey() + "" + a.getValue()); });
		stream = Arrays.stream(s);
		
		Map<String, List<String>> collect2 = stream.map(function).peek(System.out::println).flatMap(p -> p.stream()).
		collect(groupingBy( (p) -> {return p.contains("base") ? "base" : "shift";}, mapping((p) -> p, toList())));
		System.out.println(collect2);
		
		//collect2.entrySet().stream().forEach((a) -> { System.out.println(a.getKey() + "" + a.getValue()); });
		//forEach(System.out::println);
		//collect(Collectors.partitioningBy(p -> p.stream()));

//		List<Integer> list = new ArrayList<>();
//		
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);

		// list.stream().m
	}
}
