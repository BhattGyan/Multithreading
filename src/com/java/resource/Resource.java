package com.java.resource;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Gyan
 * 
 * Create a resource like linkedList 
 * Create 2 methods to produce and consume the data from that List 
 *
 *
 *Produced : 1,2,3,4,5,6,7,8,9,10 
 *Consumed : 1,2,3,4,5,6,7,8,9,10
 */

public class Resource {
	
	private final static Queue<Integer> resourceQueue=new LinkedList<>();
	public final Integer CAPACITY=10;
	private static volatile int element=1;
	//method to produce element in resource
	public  void produce() throws InterruptedException {
		while(true) {
		System.out.println("Inside the produce method");

		synchronized(resourceQueue) {
		if(resourceQueue.size()<CAPACITY) {
			System.out.println("element produced "+element+" by thread "+Thread.currentThread().getName());
			resourceQueue.add(element);
			element++;
			resourceQueue.notify();	
		} else {
			System.out.println("ResourceQueue is full so Producer is in waiting state now");
			resourceQueue.wait();
			}
		}
			Thread.sleep(1000);
		}
	}
	
	//method to consume element from resource
	public void consume() throws InterruptedException {
		
		while(true) {
		System.out.println("Inside the consume method");
			synchronized (resourceQueue) {
				if(resourceQueue.size()>0) {
					int ele=resourceQueue.remove();
					System.out.println("element consumed "
                            + ele+" by thread "+Thread.currentThread().getName());
					resourceQueue.notify();
				} else {
					System.out.println("ResourceQueue is empty so Consumer is in waiting state now");

					resourceQueue.wait();
				}
			}
		Thread.sleep(1000);
		}
		
	}

}
