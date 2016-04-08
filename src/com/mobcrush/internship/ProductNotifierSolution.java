/* Implement the "notify me when the item is in stock" feature in amazon.com */
package com.mobcrush.internship;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Ushang-PC
 */
public class ProductNotifierSolution implements ProductNotifier{
    
    // Assuming arraylist of all customers who wish to be notified about a 
    // particular product. 
    ArrayList<CustomersToNotify> customersToNotify;
    
    public ProductNotifierSolution(){
        //Initialize the arraylist
        customersToNotify = new ArrayList<>();  
    }
    
    /**
     * 
     * @param productId the product id for which the customer needs to be notified
     * @param scheme one of SCHEME_FIFO or SCHEME_PRIME_FIRST
     * @param numCustomersToBeNotified number of customers to be notified
     * @return the list of customer IDs to be notified
     */
    @Override
    public ArrayList<Long> getCustomersToNotify(long productId, int scheme, 
            int numCustomersToBeNotified) {
        // Reversing the list as we need a FIFO. The first customers added will 
        // be at the end of the list
        Collections.reverse(customersToNotify);
        // Create an arraylist to return
        ArrayList<Long> customerList = new ArrayList<>();
        int count = 0;  // Count the number of customers notified till now
        if(scheme == SCHEME_FIFO){
            for(CustomersToNotify customer : customersToNotify){
                if(count <= numCustomersToBeNotified){
                    customerList.add(customer.getCustomer().getId());
                    count++;
                }                
            }
        }
        else if(scheme == SCHEME_PRIME_FIRST){
            // Since we need prime customers first and then non prime
            // create a separate list for non prime. While adding prime memebers             
            // to the final array list
            ArrayList<Long> nonPrimeList = new ArrayList<>();
            for(CustomersToNotify customer : customersToNotify){
                if(count <= numCustomersToBeNotified){
                    if(customer.getCustomer().isIsPrime())
                        customerList.add(customer.getCustomer().getId());
                    else
                        nonPrimeList.add(customer.getCustomer().getId());
                    count ++;
                }                
            }
            // Reversing the non prime list since we want them in FIFO.
            Collections.reverse(nonPrimeList);
            // Append the non prime list to the prime list
            customerList.addAll(nonPrimeList);
        }
        //Return the list of customer IDs
        return customerList;
    }

    /**
     * This method adds the customers interested in the product to a list for
     * simulating purposes; In real world scenario add them to database here 
     * using a web service call (ideally a REST based POST request)
     * @param productId the product id for which the customer needs to be notified
     * @param customer the Customer to be notified
     */
    @Override
    public void notifyMe(long productId, Customer customer) {        
        CustomersToNotify notifyCustomer = new CustomersToNotify();
        notifyCustomer.setCustomer(customer);
        notifyCustomer.setProductId(productId);
        customersToNotify.add(notifyCustomer);       
    }
    
}
