package org.elias.clase1jsp.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.elias.clase1jsp.dto.PurchaseDTO;
import org.elias.clase1jsp.entity.Product;
import org.elias.clase1jsp.service.SaleService;
import org.elias.clase1jsp.usecase.PurchaseUseCase;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/sale")
public class SaleServlet extends HttpServlet {
    private final Logger log = Logger.getLogger(SaleServlet.class.getName());
    private PurchaseUseCase saleService;

    @Override
    public void init() {
        this.saleService = new SaleService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productType = Integer.parseInt(request.getParameter("selProd"));
        int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
        log.info("Data entered: Product Type: " +productType+", Quantity: "+quantity);

        Product p = new Product();
        switch (productType) {
            case 0 -> p = new Product(1, "Primor", 8.50);
            case 1 -> p = new Product(1, "Dulzura", 10.00);
            case 2 -> p = new Product(1, "Tentacion", 7.00);
            case 3 -> p = new Product(1, "Explosion", 12.50);
        }
        log.info("Created New " + p);

        PurchaseDTO purchaseDTO = new PurchaseDTO();
        purchaseDTO.setProductName(p.getDesc());
        purchaseDTO.setQuantity(quantity);
        purchaseDTO.setUnitPrice(p.getPrice());
        log.info("Purchase Data entered:\n" + purchaseDTO);

        purchaseDTO = saleService.processPurchase(purchaseDTO);
        log.info("Purchase Data response:\n" + purchaseDTO);

        request.setAttribute("purchaseDTO", purchaseDTO);
        request.getRequestDispatcher("receipt.jsp").forward(request, response);
    }
}