package org.elias.clase1jsp.usecase;

import org.elias.clase1jsp.dto.PurchaseDTO;

public interface PurchaseUseCase {
    double getRawTotal(double unitPrice, Integer quantity);
    double getDiscount(double total, Integer quantity);
    double getTotal(double rawTotal, double discount);
    Integer getCandies(double total, Integer quantity);
    PurchaseDTO processPurchase(PurchaseDTO p);
}
