package org.elias.clase1jsp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String desc;
    private Double price;

    @Override
    public String toString() {
        return "Product: desc=" + desc + ", price=" + price;
    }
}
