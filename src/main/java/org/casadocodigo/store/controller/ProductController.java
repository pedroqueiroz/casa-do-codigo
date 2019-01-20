package org.casadocodigo.store.controller;

import org.casadocodigo.store.dao.ProductDAO;
import org.casadocodigo.store.model.PriceType;
import org.casadocodigo.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @RequestMapping("/products/form")
    public ModelAndView getProductForm() {
        ModelAndView modelAndView = new ModelAndView("products/form");

        modelAndView.addObject("priceTypes", PriceType.values());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public String addProduct(Product product) {
        productDAO.add(product);

        return "products/success";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public ModelAndView listProducts() {
        ModelAndView modelAndView = new ModelAndView("products/listing");

        modelAndView.addObject("products", productDAO.list());

        return modelAndView;
    }

    @Autowired
    private ProductDAO productDAO;
}
