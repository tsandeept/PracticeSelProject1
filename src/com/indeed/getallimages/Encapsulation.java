package com.indeed.getallimages;

public class Encapsulation {
	
	private String owner = "Shivaram";

	public String getOwner1() {
		return owner;
	}

/*	public void setOwner1(String owner) {
		this.owner = owner;
	}*/
	
	public Encapsulation() {
		// TODO Auto-generated constructor stub
		//this.owner = "Hari";
		System.out.println(owner);
		System.out.println(this.owner);
	}
	
	

}
