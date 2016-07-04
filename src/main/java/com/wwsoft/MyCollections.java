package com.wwsoft;
import java.util.*;

public class MyCollections {
	public static void main(String[] args) {	
		if (args.length==0) {
			System.out.println("Please enter some words separated by space");
			System.exit(0);
		}
		
		System.out.print("Input words are: ");
		for (int i=0; i<args.length; ++i) {
			System.out.print(args[i] + " ");
		}
		
		// Map
		Map map = new HashMap();
		
		// Initialize frequency table from command line
        for (String a : args) {
            Integer freq = (Integer) map.get(a);
            map.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println("\n\n"+ map.size() + " distinct words:");
        System.out.println(map);
        
        // Null key
        map.put(null, 0);
        
        Set keys = map.keySet();
        System.out.println(keys);
        
        Iterator iter = keys.iterator();
        
        while (iter.hasNext()) {
        	Object o = iter.next();
            System.out.println("(key:hash code:value)" + 
            		"(" + o + ":" + map.get(o).hashCode() + ":" + map.get(o) + ")");      	             	
        } 
	}
}
