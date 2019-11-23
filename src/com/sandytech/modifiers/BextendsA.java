package com.sandytech.modifiers;

public class BextendsA extends A{
	public BextendsA(){
		A a = new A();
		a.display();
	
	}
	
	public void method1()
	{
		System.out.println(num);
	}
	
	public static void main(String... args){
		BextendsA objBextendsA = new BextendsA();
		objBextendsA.method1();
	}
}
