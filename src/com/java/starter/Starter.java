package com.java.starter;

import com.java.consumer.ConsumerThread;
import com.java.producer.ProducerThread;

public class Starter {
	
	public static void main(String args[]) throws InterruptedException {
		
		Thread producer=new Thread(new ProducerThread());
		producer.setName("Producer");
		Thread consumer=new Thread(new ConsumerThread());
		consumer.setName("Consumer");
		producer.start();
		consumer.start();
		
		producer.join();
		consumer.join();
	}

}
