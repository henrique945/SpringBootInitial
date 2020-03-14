package com.example.produtoac1.repository;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.produtoac1.model.Product;

import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 */
@Repository
public class ProductRepository {

    public HashMap<Integer, Product> hm = new HashMap<Integer, Product>();

    public ProductRepository() {
        hm.put(1, new Product(1, "arroz", 5.5, 10));
        hm.put(2, new Product(2, "feijao", 1.3, 10));
        hm.put(3, new Product(3, "carne", 54.7, 10));
        hm.put(4, new Product(4, "ovo", 20.3, 10));
        hm.put(5, new Product(5, "pao", 100.5, 10));
        hm.put(6, new Product(6, "laranja", 0.5, 10));
        hm.put(7, new Product(7, "uva", 3.9, 10));
        hm.put(8, new Product(8, "limao", 4.5, 10));
        hm.put(9, new Product(9, "macarrao", 7.2, 10));
        hm.put(10, new Product(10, "cafe", 13, 10));
    }

    /**
     * Metódo que retorna o produto pelo id dele
     */
    public Product getProductById(int id) {
        return hm.get(id);
    }

    /**
     * Metódo que retorna todos os produtos
     */
    public ArrayList<Product> getProducts() {
        return new ArrayList<Product>(hm.values());
    }
}