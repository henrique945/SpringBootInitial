package com.example.produtoac1.controller;

import java.util.ArrayList;

import com.example.produtoac1.model.Product;
import com.example.produtoac1.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ProductController
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    /**
     * Função que controla a view de produtos por id
     */
    @GetMapping("/product/{id}")
    public ModelAndView getProduct(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("productView");

        Product product = service.getProduct(id);

        if (product == null) {
            mv = new ModelAndView("failMessageView");
            return mv;
        }

        mv.addObject("product", product);

        return mv;
    }

    /**
     * Função que controla a view de produtos em estoque
     */
    @GetMapping("/productStock")
    public ModelAndView getStockProducts() {
        ModelAndView mv = new ModelAndView("productStockView");

        ArrayList<Product> products = service.getProductInStock();

        mv.addObject("products", products);

        return mv;
    }

    /**
     * Função que controla a view de produtos acima do valor
     */
    @GetMapping("/productBiggerThan/{value}")
    public ModelAndView getProductBiggerThan(@PathVariable("value") int value) {
        ModelAndView mv = new ModelAndView("productBiggerView");

        ArrayList<Product> products = service.getProductBiggerThan(value);

        mv.addObject("products", products);
        mv.addObject("value", value);

        return mv;
    }

    /**
     * Função que controla a view de produtos acima do valor
     */
    @GetMapping("/productLesserThan/{value}")
    public ModelAndView getProductLesserThan(@PathVariable("value") int value) {
        ModelAndView mv = new ModelAndView("productLesserView");

        ArrayList<Product> products = service.getProductLesserThan(value);

        mv.addObject("products", products);
        mv.addObject("value", value);

        return mv;
    }

}