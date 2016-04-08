package com.mobcrush.internship;

/**
 *
 * @author Ushang-PC
 */
public class Purchase {
    
    private long customerId;
    private long productId;

    /**
     * 
     * @return the id of the customer who made the purchase
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * 
     * @param customerId the id of the customer who made the purchase
     */
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    /**
     * 
     * @return the id of the product whose purchase was made
     */
    public long getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId the id of the product which was purchased
     */
    public void setProductId(long productId) {
        this.productId = productId;
    }
    
    
    
}
