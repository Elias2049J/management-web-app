package org.elias.clase1jsp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDTO {
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    private Double rawTotal;
    private Double discount;
    private Double finalTotal;
    private Integer candies;

    @Override
    public String toString() {
        return  "Product Name: " + productName + "\n" +
                "Quantity: " + quantity + "\n" +
                "Unit Price: " + unitPrice + "\n" +
                "Raw Total: " + rawTotal + "\n" +
                "Discount: " + discount + "\n" +
                "Final Total: " + finalTotal + "\n" +
                "Candies: " + candies;
    }
}
