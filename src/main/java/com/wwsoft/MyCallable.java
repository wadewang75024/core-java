package com.wwsoft;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<String> {
	String input;
	public MyCallable(String input) {
		this.input = input;
	}
	
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "I am thread: " + Thread.currentThread().getName() 
        		+ " This is my input: " + input;
    }
    
    public static void main(String args[]){
    	
        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        /*
         * A Future represents the result of an asynchronous computation. 
         * Methods are provided to check if the computation is complete, 
         * to wait for its completion, and to retrieve the result of the computation. 
        */
        //Create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<Future<String>>();
        
        for(int i=0; i< 100; i++){
            // Create MyCallable instance and 
        	// submit Callable tasks to be executed by thread pool       	
            Callable<String> callable = new MyCallable("loop" + i);
            Future<String> future = executor.submit(callable);
            //add Future to the list, we can get return value using Future
            list.add(future);
        }
        
        for(Future<String> fut : list){
            try {
                // print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println(new Date()+ "::"+fut.get());
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (ExecutionException  e) {
                e.printStackTrace();
            }
        }
        
        //shut down the executor service now
        executor.shutdown();
        while (!executor.isTerminated()) {  }  
  	    System.out.println("Finished all threads");
    }
}

