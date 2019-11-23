package com.indeed.test;

public class OopsConstructor 
{
	public OopsConstructor(){
		System.out.println("Super class Constructor message");
	}

	protected void displayMessage1()
	{
		System.out.println("Display message1");
	}
	public void displayMessage2()
	{
		displayMessage1();
		System.out.println("Display message2");
	}
	/*//Method name with return type and same class name is also a valid syntax as below. 
	public void OopsConstructor()
	{
		System.out.println("Method with same constructorname");
	}*/
	
	public void method1(){
		System.out.println("Superclass method1");
	}
	public void method2(){
		System.out.println("Superclass method2");
	}
	
/*	public static void main(String... args)
	{
		OopsConstructor objOopsConstructor = new OopsConstructor();
		objOopsConstructor.OopsConstructor();
	}*/
}






