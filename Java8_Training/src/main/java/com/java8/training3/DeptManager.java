package com.java8.training3;

import java.util.ArrayList;
import java.util.List;

public class DeptManager implements MyInterface<Dept>{
private List<Dept> list = new ArrayList<>();
	
	public static void main(String[] args) {
		DeptManager mgr = new DeptManager();
		for(int i = 1; i<= 10;i++){
			Dept d = new Dept();
			d.setDeptno(i);
			d.setDname("Nameof"+i);
			if (i %2 ==0)
					d.setLoc("Hyd");
			else
					d.setLoc("Pune");
			mgr.insert(d);
		}
		mgr.list.forEach((d)->System.out.println(d));
		
	}

/*	@Override
	public void insert(Dept t) {
		list.add(t);
	}
*/
	@Override
	public void delete(Dept t) {
		// for loop to delete that object with same pk
	}

	@Override
	public void update(Dept t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return list;
	}

	
}