package com.wwsoft;

import java.util.*;

class Listener1 implements Observer {   
	  
	public void update(Observable o, Object arg)  {   
		if ( o instanceof Notifier ) {   
			System.out.println("Listner1 got notified from Nofifier");   
			System.out.println("Current status of the nofifier: " + ((Notifier)o).getCurrentStatus());
		} 	else {   
			System.out.println("Listner1 didn't got notified from Nofifier");   
		}   
	}   
}   
	    
class Listener2 implements Observer {   
	  
	public void update(Observable o, Object arg)  {   
		if ( o instanceof Notifier ) {   
			System.out.println("Listner2 got notified from Nofifier");   
			System.out.println("Current status of the nofifier: " + ((Notifier)o).getCurrentStatus());
		} else {   
			System.out.println("Listner2 didn't got notified from Nofifier");    
		}   
	}   
}   
	    
class Notifier extends Observable {   
	String currentStatus;
	public void eventOccurs() {   
		System.out.println("Something has happened");   
		currentStatus = "New";
		setChanged();   
		notifyObservers();   
	}   
	public String getCurrentStatus() {
		return currentStatus;
	}
}   
	    
public class MyObserver {   
	static public void main(String[] args) {   
		Notifier notifier = new Notifier();   
		notifier.addObserver(new Listener1());   
		notifier.addObserver(new Listener2());   
		notifier.eventOccurs();     
	}   
}   

