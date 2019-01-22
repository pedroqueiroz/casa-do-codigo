package org.casadocodigo.store.controller;

import org.casadocodigo.store.dao.ProductDAO;
import org.casadocodigo.store.model.PriceType;
import org.casadocodigo.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {

    @RequestMapping("/form")
    public ModelAndView getProductForm() {
        ModelAndView modelAndView = new ModelAndView("products/form");

        modelAndView.addObject("priceTypes", PriceType.values());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addProduct(Product product) {
        productDAO.add(product);

        return new ModelAndView("redirect:products");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listProducts() {
        ModelAndView modelAndView = new ModelAndView("products/listing");

        modelAndView.addObject("products", productDAO.list());

        return modelAndView;
    }

    @Autowired
    private ProductDAO productDAO;
}
