package com.adr.rlet.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	
	public String placeOrder(String item,int quantity) {
		if(quantity<=0) {
			throw new IllegalArgumentException("quantity must be positive");
		}
		
		return "Order placed: " + quantity + " x " + item;
	}
	
	public String placeOrderWithValidation(String item, int quantity) {
	    validateQuantity(quantity);   // <-- calling "this", not the proxy
	    return "Validated order: " + quantity + " x " + item;
	}

	public void validateQuantity(int quantity) {
	    if (quantity <= 0) throw new IllegalArgumentException("bad qty");
	}
	
	
	public double calculateTotal(double price, int quantity) {
        // simulate a bit of work
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return price * quantity;
    }
}
