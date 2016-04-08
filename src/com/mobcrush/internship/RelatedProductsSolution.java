/** Implement the "people who bought X item also bought Y item" 
 *  feature in amazon.com **/
package com.mobcrush.internship;

import java.util.ArrayList;

/**
 *
 * @author Ushang-PC
 */
public class RelatedProductsSolution implements RelatedProducts{
    
    ArrayList<Purchase> purchases;

    public RelatedProductsSolution() {
        purchases = new ArrayList<>();
    }
        
    /**
     * This method simulates a new purchase. Adds purchase to the 
     * purchases list. In real world scenario add them to database here 
     * using a web service call (ideally a REST based POST request)
     * @param customerID the id of the customer who made the purchase
     * @param productId the id of the product which was purchased
     */
    @Override
    public void registerPurchase(long customerID, long productId) {
        Purchase newPurchase = new Purchase();
        newPurchase.setCustomerId(customerID);
        newPurchase.setProductId(productId);
        purchases.add(newPurchase);
    }

    /**
     * This method first gets the list of all related 
     * customers ie all customers who bought the same product. It then goes
     * through all purchases with that customers and checks if they have bought 
     * some other products. If the product is not already added in the final 
     * list it is added to it. This procedure continues numProducts times or if
     * the entire list is searched and no more related products can be found.
     * @param customerID the id of the customer for which the related products are needed
     * @param productId the id of the product for which the related products are needed
     * @param numProducts the number of related products required
     * @return Returns the list of next `numProducts` products related to this product
     */
    @Override
    public ArrayList<Long> getRelatedProducts(long customerID, long productId, 
            int numProducts) {
       
        int count = 0; // Count the number of products added till now
        ArrayList<Long> relatedProductsList = new ArrayList<>();
        // Get the related list of all customers
        ArrayList<Long> relatedCustomerList = 
                getAllRelatedCustomers(customerID, productId);
        // Go through the list of all related customers one by one
        outer: for(long cId: relatedCustomerList){
            // Go thorugh all purchases to check these three things:
            // 1. If the customer id is same as the related customer
            // 2. If the product purchased is not the same as product under 
            //    consideration (Since we want other related products)
            // 3. If the product doesn't already exist in the final products 
            //    list. Since we want all unique related products
            for(Purchase anotherPurchase : purchases){
                if(anotherPurchase.getCustomerId() == cId && 
                    anotherPurchase.getProductId() != productId &&
                   !relatedProductsList.contains(anotherPurchase.getProductId())){
                    // Check if the numProducts count has been reached. If not
                    // keep adding the product to the final list. If it has 
                    // reached break out of the outer loop.
                    if(count <= numProducts){
                        relatedProductsList.add(anotherPurchase.getProductId());
                        count++;
                    }
                    else
                        break outer;
                }
            }            
        }
        return relatedProductsList;
              
    }        

    /**
     * getRelatedCustomer: Method checks the list of all purchases in which the 
     * product purchases was the same but the customer was different and returns
     * the first such customer.
     * @param customerID the id of the customer for which the related customer is needed
     * @param productID the id of the product for which the related customer is needed
     * @return Returns the ID of a different customer who has also 
     * bought the productID
     */
    @Override
    public long getRelatedCustomer(long customerID, long productID) {
        for(Purchase anotherPurchase: purchases){
            if(anotherPurchase.getProductId() == productID && 
                    anotherPurchase.getCustomerId() != customerID)
                return anotherPurchase.getCustomerId();
        }
        return 0;   // 0 indicates no other customer bought the given product
    }
    
    /**
     * getAllRelatedCustomers: Method checks the list of all purchases in which 
     * the product purchases was the same but the customer was different and 
     * returns the entire list of such customers.
     * @param customerID the id of the customer for which the related customers are needed
     * @param productID he id of the product for which the related customers are needed
     * @return Returns the list of  different customers who has also 
     * bought the productID
     */
    public ArrayList<Long> getAllRelatedCustomers(long customerID, 
            long productID){
        ArrayList<Long> relatedCustomersList = new ArrayList<>();
        for(Purchase anotherPurchase: purchases){
            if(anotherPurchase.getProductId() == productID && 
                    anotherPurchase.getCustomerId() != customerID)
                relatedCustomersList.add(anotherPurchase.getCustomerId()); 
        }
        return relatedCustomersList;
    }
}
