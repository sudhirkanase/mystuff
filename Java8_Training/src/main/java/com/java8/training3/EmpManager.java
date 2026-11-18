package com.java8.training3;

import java.util.ArrayList;
import java.util.List;

public class EmpManager implements MyInterface<Emp>{
private List<Emp> list = new ArrayList<>();
	
	public static void main(String[] args) {
		EmpManager mgr = new EmpManager();
		for(int i = 1; i<= 10;i++){
			Emp d = new Emp();
			d.setEmpno(i);
			d.setEname("Nameof"+i);
			d.setSalary(i *1000);
			mgr.insert(d);
		}
		//mgr.list.forEach((e)->System.out.println(e));
		mgr.list.forEach(System.out::println);
	//	System.out.println(mgr.list());
	}

/*	@Override
	public void insert(Emp t) {
		list.add(t);
	}
*/
	@Override
	public void delete(Emp t) {
		// for loop to delete that object with same pk
	}

	@Override
	public void update(Emp t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Emp> list() {
		// TODO Auto-generated method stub
		return list;
	}

	
}