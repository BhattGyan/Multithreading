package com.java.producer;

import com.java.resource.Resource;

public class ProducerThread implements Runnable {
	
	
	private Resource resource;

	@Override
	public void run() {
		resource=new Resource();
		try {
			resource.produce();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
