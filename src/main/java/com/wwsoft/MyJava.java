package com.wwsoft;

public class MyJava {
	
	public MyJava() {
		System.out.println("My Java constructor");
	}
	
	public int dummy() {
		System.out.println("MyJava dummy method.");
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println("args: " + args.length);
		if (args.length > 0) { 
		  for (int i=0; i<args.length; ++i) {
		    System.out.println("args[" + i + "]" + args[i] );
		  }
		}
	}
}
