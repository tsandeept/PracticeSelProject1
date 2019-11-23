package com.indeed.getallimages;
import com.indeed.test.OopsConstructor;

public class DummyClass extends OopsConstructor {
	
	public void method1(){
		System.out.println("Child Class method1");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
/*		OopsConstructor objOopsConstructor = new OopsConstructor();
		DummyClass objDummyClass = new DummyClass();
		objDummyClass.displayMessage1();
		objOopsConstructor.displayMessage2();
		objOopsConstructor.OopsConstructor();*/
		
		DummyClass objDummyClass = new DummyClass();
		objDummyClass.method1();
		
		
		
	}
	
}

/*
class SuperClass{
	public void method1(){
		System.out.println("Superclass method1");
	}
	public void method2(){
		System.out.println("Superclass method2");
	}
}

class ChildClass extends SuperClass{
	public void method1(){
		System.out.println("Child Class method1");
	}
}*/