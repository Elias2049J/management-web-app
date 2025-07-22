package org.elias.clase1jsp.service;

import org.elias.clase1jsp.dto.PurchaseDTO;
import org.elias.clase1jsp.enumerate.DiscountType;
import org.elias.clase1jsp.usecase.PurchaseUseCase;

import java.util.logging.Logger;
public class SaleService implements PurchaseUseCase {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public double getRawTotal(double unitPrice, Integer quantity) {
        log.info("RawTotal: " + unitPrice * quantity);
        return unitPrice * quantity;
    }
    
    @Override
    public double getDiscount(double total, Integer quantity) {
        DiscountType dt;
        if (quantity < 5) dt = DiscountType.ONE;
        else if (quantity < 10) dt = DiscountType.TWO;
        else if (quantity < 15) dt = DiscountType.THREE;
        else dt = DiscountType.FOUR;
        log.info("Discount: "+ total * dt.getValue());
        return total * dt.getValue();
    }

    @Override
    public double getTotal(double rawTotal, double discount) {
        log.info("Final Total" + (rawTotal - discount));
        return rawTotal - discount;
    }

    @Override
    public Integer getCandies(double total, Integer quantity) {
        if (total >= 250) {
            log.info("Candies: "+ quantity * 3);
            return quantity * 3;
        }
        else {
            log.info("Candies: "+ quantity * 2);
            return quantity * 2;
        }
    }

    @Override
    public PurchaseDTO processPurchase(PurchaseDTO p) {
        double rawTotal = getRawTotal(p.getUnitPrice(), p.getQuantity());
        double discount = getDiscount(rawTotal, p.getQuantity());
        double finalTotal = getTotal(rawTotal, discount);

        p.setRawTotal(rawTotal);
        p.setDiscount(discount);
        p.setFinalTotal(finalTotal);
        p.setCandies(getCandies(finalTotal, p.getQuantity()));
        return p;
    }
}
