package org.casadocodigo.store.controller;

import org.casadocodigo.store.dao.ProductDAO;
import org.casadocodigo.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/products/form")
    public String getProductForm() {
        return "products/form";
    }

    @RequestMapping("/products")
    public String addProduct(Product product) {
        productDAO.add(product);

        return "products/success";
    }

    @Autowired
    private ProductDAO productDAO;
}
