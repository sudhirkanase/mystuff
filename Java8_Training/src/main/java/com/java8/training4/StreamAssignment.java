package com.java8.training4;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.google.common.base.Predicate;

public class StreamAssignment {

	public static void main(String[] args) {

		// Create employee data
		List<Emp> emps = CreateEmpMgr.createemp();

		emps.stream().forEach(System.out::println);

		// 1) All records where ename ends with "li" and sorted on salary
		System.out.println("------------- Sol 1---------------------------");

		emps.stream().filter((e1) -> e1.getEname().endsWith("li"))
				.sorted((e2, e3) -> Double.compare(e2.getSalary(), e3.getSalary())).forEach(System.out::println);

		System.out.println("------------- Sol 1---------------------------");

		// All records where sal betwwen 100 and 200
		System.out.println("------------- Sol 2---------------------------");

		Predicate<Emp> empSalPredicate = (e) -> e.getSalary() > 100 && e.getSalary() < 200;

		emps.stream().filter(empSalPredicate).forEach(System.out::println);

		System.out.println("------------- Sol 2---------------------------");

		// All records where dept is either 'TRN' or 'HR'
		System.out.println("------------- Sol 3---------------------------");
		Predicate<Emp> deptPredicate = (e) -> e.getDept().equalsIgnoreCase("TRN") || e.getDept().equalsIgnoreCase("HR");

		emps.stream().filter(deptPredicate).forEach(System.out::println);
		System.out.println("------------- Sol 3---------------------------");

		// Show the 1st 10 records accept N and P from user based on input show next or
		// previous 10 records
		System.out.println("------------- Sol 4---------------------------");

		System.out.println("------------- Sol 4---------------------------");

		int currShowing = 0;
		int pageSize = 10;
		int totalRecs = emps.size();
		
		Scanner sc = new Scanner(System.in); 
		while (true) {

			System.out.println("currShowing from " + currShowing + "  to " + (currShowing + pageSize));
			emps.stream().skip(currShowing).limit(pageSize).forEach(System.out::println);
			System.out.println("Enter N or P to show next or previous records");
			char ch = sc.next().charAt(0);
			if (ch == 'n') {					
				currShowing += pageSize;
				// Exceeding the max size
				if(currShowing >= totalRecs) {
					currShowing -= 10;
					System.err.println("You cannot go next beyond this");
				}
			} else if (ch == 'p') {
				currShowing -= pageSize;
				if(currShowing <=0 ) {
					currShowing = 0;
					System.err.println("You cannot go previous beyond this");
				}
			}else {
				System.out.println("Invalid input");
			}

		}

	}
}
