package com.mobcrush.internship;

/**
 *
 * @author Ushang-PC
 */
public class Customer {
    
    private long id;
    private boolean isPrime;

    /**
     * 
     * @return id of the customer
     */
    public long getId() {
        return id;
    }

    /**
     * 
     * @param id the ID of the customer
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 
     * @return whether the customer is prime or not 
     */
    public boolean isIsPrime() {
        return isPrime;
    }

    /**
     * 
     * @param isPrime whether the customer is prime or not 
     */
    public void setIsPrime(boolean isPrime) {
        this.isPrime = isPrime;
    }            
}


class CustomersToNotify{
    private Customer customer;
    private long productId;

    /**
     * 
     * @return Customer to notify
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * 
     * @param customer the customer to be notified
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * 
     * @return product ID of the product for which the customer needs to be notified
     */
    public long getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId the product for which the customer needs to be notified
     */
    public void setProductId(long productId) {
        this.productId = productId;
    }
        
}
