package com.java8.training5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CreateEmpMgr{
	public static List<Emp> createemp(int size){
		List<Emp> list = new ArrayList<Emp>();
		List<String> names = Stream.of("Simran","Saloni","Asha","Vaishali", "Lili").collect(Collectors.toList());
		List<String> departments = Stream.of("HR","TRN","TA","FIN").collect(Collectors.toList());
		
		for (int i = 0;i< size;i++){
			Emp e1= new Emp();
			e1.setEmpno(i+1);
			e1.setEname( names.get(i %names.size() ));
			e1.setDept(departments.get(i% departments.size()));
			e1.setSalary((int)(Math.random()*1000));
			list.add(e1);
		}
		return list;
	}
}
public class EmpMgr {

	public static void main(String[] args) {
		List<Emp> list = CreateEmpMgr.createemp(10);
//		list.forEach(System.out::println);
/*	Stream<Emp> original = list.stream();
	Stream<Emp> empstr = 	original.filter((e)->e.getDept().equals("HR"));
	empstr.forEach(System.out::println);*/
	list.stream()
	.peek(e->System.out.println("str- " + e))
	.filter((e)->e.getDept().equals("HR"))
	.peek(e->System.out.println("filter - " + e))
	.forEach(System.out::println);
	}

}