package com.mobcrush.internship;

import java.util.ArrayList;

/**
 *
 * @author Ushang-PC
 */
public interface RelatedProducts {
    
    /**
     * registerPurchase: Called when a product purchase is made by a customer
     * @param customerID the id of the customer who made the purchase
     * @param productId  the id of the product which was purchased
     */
    public void registerPurchase(long customerID, long productId);
    
    /**
     * getRelatedProducts: Returns the next `numProducts` products related to 
     * this product
     * @param customerID the id of the customer for which the related products are needed
     * @param productId the id of the product for which the related products are needed
     * @param numProducts the number of related products required
     * @return Returns the next `numProducts` products related to 
     * this product
     */
    public ArrayList<Long> getRelatedProducts(long customerID, long productId, 
            int numProducts);
    
    /**
     * getRelatedCustomer: Returns the ID of a different customer who has also 
     * bought the productID
     * @param customerID the id of the customer for which the related customers are needed
     * @param productID the id of the product for which the related customers are needed
     * @return the ID of a different customer who has also 
     * bought the productID
     */
    public long getRelatedCustomer(long customerID, long productID);
    
}
