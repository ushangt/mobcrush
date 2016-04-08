package com.mobcrush.internship;

import java.util.ArrayList;

/**
 *
 * @author Ushang-PC
 */
public interface ProductNotifier {
    
    // Scheme for ordering the notification list of customers
    public static int SCHEME_FIFO = 0;          // First in First out
    public static int SCHEME_PRIME_FIRST = 1;   // Prime members in FIFO order 
                                                // followed by nonPrime in FIFO
    
    /**
     * @param productId the product id for which the customer needs to be notified
     * @param scheme one of SCHEME_FIFO or SCHEME_PRIME_FIRST
     * @param numCustomersToBeNotified number of customers to be notified
     * @return the list of customer IDs to be notified
     */
    public ArrayList<Long> getCustomersToNotify(long productId, int scheme, 
            int numCustomersToBeNotified);
    
    /**
     * This method records a customer's request to be notified when the product 
     * becomes available
     * @param productId the product id for which the customer needs to be notified
     * @param customer the Customer to be notified
     */
    public void notifyMe(long productId, Customer customer);
    
}
