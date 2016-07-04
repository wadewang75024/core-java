package com.wwsoft.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.wwsoft.MyJava;

public class MyJunit4 {
	@Test 
	public void testMyJava() {
		MyJava tester = new MyJava();	
		assertEquals("Testing: ", 0, tester.dummy()) ;
	}
}
