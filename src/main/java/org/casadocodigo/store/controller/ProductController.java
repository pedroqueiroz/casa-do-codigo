package org.casadocodigo.store.controller;

import org.casadocodigo.store.dao.ProductDAO;
import org.casadocodigo.store.model.PriceType;
import org.casadocodigo.store.model.Product;
import org.casadocodigo.store.validation.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProductValidator());
    }

    @RequestMapping("/form")
    public ModelAndView getProductForm() {
        ModelAndView modelAndView = new ModelAndView("products/form");

        modelAndView.addObject("priceTypes", PriceType.values());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView add(@Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return getProductForm();
        }

        productDAO.add(product);

        redirectAttributes.addFlashAttribute("successMessage", "Product was added successfully!");

        return new ModelAndView("redirect:products");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listProducts() {
        ModelAndView modelAndView = new ModelAndView("products/listing");

        modelAndView.addObject("products", productDAO.list());

        return modelAndView;
    }
}
