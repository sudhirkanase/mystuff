package Java8_Training;


interface Test3{
	
	void hello();
	
	default void test1() {
		System.out.println("test");
	}
}

interface Test2{
	
	void hello();
	
	default void test1() {
		System.out.println("test2");
	}
}

class MyClass implements Test3, Test2{

	@Override
	public void hello() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test1() {
		// TODO Auto-generated method stub
		Test3.super.test1();
		Test2.super.test1();
	}
	
}

public class Test1 {
	public static void main(String[] args) {
		new MyClass().test1();
		
	}
}
