package com.java.resource;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Gyan
 * 
 * Create a resource like linkedList 
 * Create 2 methods to produce and consume the data from that List 
 *
 */

public class Resource {
	
	private final static List<Integer> resourceList=new LinkedList<>();
	public final Integer CAPACITY=10;
	
	//method to produce element in resource
	public  void produce(int element) throws InterruptedException {
		//while(true) {
		System.out.println("Inside the produce method");

		synchronized(this) {
		if(resourceList.size()<CAPACITY) {
			System.out.println("element produced "+element+" by thread "+Thread.currentThread().getName());
			resourceList.add(element);
		notifyAll();	
		} else {
				wait();
			}
		}
			Thread.sleep(1000);
		//}
	}
	
	//method to consume element from resource
	public void consume(int element) throws InterruptedException {
	//	while(true) {
		System.out.println("Inside the consume method");
			synchronized (this) {
				if(resourceList.size()>0) {
					 System.out.println("element consumed-"
                             + resourceList.get(element)+" by thread "+Thread.currentThread().getName());
					resourceList.remove(element);
					notifyAll();
				} else {
					wait();
				}
			}
		Thread.sleep(1000);
		}
		
	//}

}
