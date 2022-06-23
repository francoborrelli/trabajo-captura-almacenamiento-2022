package com.products.sbpg.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.products.sbpg.model.Product;


public class ProductSearchDTO {
    public List<ProductDTO> productsFound;
    public long millisecondsEllapsed = 0l;

    public ProductSearchDTO(List<Product> products, long lastTaskTimeMillis) {
        this.setProductsFound(products);
        this.setMillisecondsEllapsed(lastTaskTimeMillis);
    }

    public void setProductsFound(List<Product> products) {
        this.productsFound = products.stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
    }

    public void setMillisecondsEllapsed(long millis) {
        this.millisecondsEllapsed = millis;
    }
}