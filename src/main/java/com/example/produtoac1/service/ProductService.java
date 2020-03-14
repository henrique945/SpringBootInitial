package com.example.produtoac1.service;

import java.util.ArrayList;

import com.example.produtoac1.model.Product;
import com.example.produtoac1.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductService
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Busca um produto e trata se ele existe ou não
     */
    public Product getProduct(int id) {
        Product product = productRepository.getProductById(id);
        // caso não existe já retorna null

        return product;
    }

    /**
     * Busca e retorna os produtos que tem a quantidade maior que zero (estão em
     * estoque)
     */
    public ArrayList<Product> getProductInStock() {
        ArrayList<Product> products = productRepository.getProducts();
        ArrayList<Product> selectedProducts = new ArrayList<Product>();

        for (Product p : products) {
            if (p.getEstoque() > 0) {
                selectedProducts.add(p);
            }
        }

        return selectedProducts;
    }

    /**
     * Busca e retorna os produtos acima do valor passado
     */
    public ArrayList<Product> getProductBiggerThan(double valor) {
        ArrayList<Product> products = productRepository.getProducts();
        ArrayList<Product> selectedProducts = new ArrayList<Product>();

        for (Product p : products) {
            if (p.getValor() > valor) {
                selectedProducts.add(p);
            }
        }

        return selectedProducts;
    }

    /**
     * Busca e retorna os produtos acima do valor passado
     */
    public ArrayList<Product> getProductLesserThan(double valor) {
        ArrayList<Product> products = productRepository.getProducts();
        ArrayList<Product> selectedProducts = new ArrayList<Product>();

        for (Product p : products) {
            if (p.getValor() < valor) {
                selectedProducts.add(p);
            }
        }

        return selectedProducts;
    }

}