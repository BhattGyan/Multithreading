package com.java.consumer;

import com.java.resource.Resource;

public class ConsumerThread implements Runnable {

	private Resource resource;
	
	@Override
	public void run() {
		resource=new Resource();
			try {
				resource.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

}
